package ru.gb.hm4.calc;

import java.util.ArrayList;
import java.util.List;

public class Calc {
    private List<CalcOperation> history;
    private MyLogger logger;
    private List<Lexeme> lexemes;
    private LexemeBuffer lexemeBuffer;
    private int operationId;

    public Calc() {
        logger = new MyLogger(Calc.class.getName());
        lexemes = new ArrayList<>();
        lexemeBuffer = new LexemeBuffer();
        history = new ArrayList<>();
        logger.addHandler();
    }

    private List<Lexeme> lexAnalyze(String expText) {
        int pos = 0;
        while (pos< expText.length()) {
            char c = expText.charAt(pos);
            switch (c) {
                case '(':
                    lexemes.add(new Lexeme(LexemeType.LEFT_BRACKET, c));
                    pos++;
                    continue;
                case ')':
                    lexemes.add(new Lexeme(LexemeType.RIGHT_BRACKET, c));
                    pos++;
                    continue;
                case '+':
                    lexemes.add(new Lexeme(LexemeType.OP_PLUS, c));
                    pos++;
                    continue;
                case '-':
                    lexemes.add(new Lexeme(LexemeType.OP_MINUS, c));
                    pos++;
                    continue;
                case '*':
                    lexemes.add(new Lexeme(LexemeType.OP_MUL, c));
                    pos++;
                    continue;
                case '/':
                    lexemes.add(new Lexeme(LexemeType.OP_DIV, c));
                    pos++;
                    continue;
                default:
                    if (c <= '9' && c >= '0') {
                        StringBuilder sb = new StringBuilder();
                        do {
                            sb.append(c);
                            pos++;
                            if (pos >= expText.length()) {
                                break;
                            }
                            c = expText.charAt(pos);
                        } while (c <= '9' && c >= '0');
                        lexemes.add(new Lexeme(LexemeType.NUMBER, sb.toString()));
                    } else {
                        if (c != ' ') {
                            throw new RuntimeException("Unexpected character: " + c);
                        }
                        pos++;
                    }
            }
        }
        lexemes.add(new Lexeme(LexemeType.EOF, ""));
        return lexemes;
    }

    private double expr(LexemeBuffer lexemes) {
        Lexeme lexeme = lexemes.next();
        if (lexeme.type == LexemeType.EOF) return 0;
        else {
            lexemes.back();
            return plusminus(lexemes);
        }
    }

    private double plusminus(LexemeBuffer lexemes) {
        double value = multdiv(lexemes);
        while (true) {
            Lexeme lexeme = lexemes.next();
            switch (lexeme.type) {
                case OP_PLUS:
                    value += multdiv(lexemes);
                    break;
                case OP_MINUS:
                    value -= multdiv(lexemes);
                    break;
                case EOF:
                case RIGHT_BRACKET:
                    lexemes.back();
                    return value;
                default:
                    throw new RuntimeException("Unexpected token: " + lexeme.value + " at position: " + lexemes.getPos());
            }
        }
    }

    private double multdiv(LexemeBuffer lexemes) {
        double value = factor(lexemes);
        while (true) {
            Lexeme lexeme = lexemes.next();
            switch (lexeme.type) {
                case OP_MUL:
                    value *= factor(lexemes);
                    break;
                case OP_DIV:
                    value /= factor(lexemes);
                    break;
                case EOF:
                case RIGHT_BRACKET:
                case OP_PLUS:
                case OP_MINUS:
                    lexemes.back();
                    return value;
                default:
                    throw new RuntimeException("Unexpected token: " + lexeme.value + " at position: " + lexemes.getPos());
            }
        }
    }

    private double factor(LexemeBuffer lexemes) {
        Lexeme lexeme = lexemes.next();
        switch (lexeme.type) {
            case NUMBER:
                return Double.parseDouble(lexeme.value);
            case LEFT_BRACKET:
                double value = plusminus(lexemes);
                lexeme = lexemes.next();
                if (lexeme.type != LexemeType.RIGHT_BRACKET) {
                    throw new RuntimeException("Unexpected token: " + lexeme.value + " at position: " + lexemes.getPos());
                }
                return value;
            default:
                throw new RuntimeException("Unexpected token: " + lexeme.value + " at position: " + lexemes.getPos());
        }
    }

    public double getResult(String expression) {
        List<Lexeme> lexemes = lexAnalyze(expression);
        LexemeBuffer lexemeBuffer = new LexemeBuffer(lexemes);
        double result = expr(lexemeBuffer);
        lexemes.clear();
        lexemeBuffer = null;
        return result;
    }

    public void logInfo(String msg) {
        logger.logInfo(msg);
    }

    private void addHistory(String expr, double result) {
        history.add(new CalcOperation(++operationId, expr, result));
    }

    public List<CalcOperation> getHistory() {
        return history;
    }

    public void fixOperation(String expr, double result) {
        addHistory(expr, result);
        logInfo("expr: " + expr + ", result: " + result);
    }
}
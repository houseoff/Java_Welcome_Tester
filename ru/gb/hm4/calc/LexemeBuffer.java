package ru.gb.hm4.calc;

import java.util.List;

class LexemeBuffer {
    private int pos;

    public List<Lexeme> lexemes;

    public LexemeBuffer() {
    }

    public LexemeBuffer(List<Lexeme> lexemes) {
        this.lexemes = lexemes;
    }

    public Lexeme next() {
        return lexemes.get(pos++);
    }

    public void back() {
        pos--;
    }

    public int getPos() {
        return pos;
    }
}

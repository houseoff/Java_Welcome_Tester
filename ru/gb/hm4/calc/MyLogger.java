package ru.gb.hm4.calc;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

class MyLogger {
    private Logger logger;

    public MyLogger(String className) {
        logger = Logger.getLogger(className);
    }

    public void addHandler() {
        try {
            FileHandler fh = new FileHandler("log_calc.log", true);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void logInfo(String msg) {
        logger.info(msg);
    }
}

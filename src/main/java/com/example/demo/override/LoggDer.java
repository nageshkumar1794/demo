package com.example.demo.override;

public class LoggDer extends Logg {
    public void logsDer(Double val, int v) {
        logMessage.append(" Double Value: " + val + " Int Val " + v + "\n");
    }
}

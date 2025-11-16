package com.example.demo.override;

public abstract class Logg {

    protected StringBuilder logMessage = new StringBuilder();

    public void logs(String msg) {
         logMessage.append(msg  + "\n");
    }

    public abstract void logsDer(Double d, int i);

    public void logs(String msg, Integer iValue) {
        System.out.println(" Coverting to Primitive Data Type " + iValue.intValue());
        logMessage.append(msg + "\n");
    }
    public String logs(String msg, Exception e) {
        logMessage.append("Ex: ").append(e.getMessage()).append("  ").append(msg+ "\n");
        return e.getMessage();
    }

    public  int logs(String level, String msg ) {
        logMessage.append("Level: ").append("  ").append(msg+ "\n");
        return 1;
    }

    @Override
    public String toString() {
        System.out.println(logMessage);
        return "Meg : " + logMessage;
    }
}


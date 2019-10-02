package org.evertones.model;

public class LogData {

    private final String template;
    private final String      log;

    public LogData(String template, String log) {
        this.template = template;
        this.log = log;
    }

    public String getTemplate() {
        return template;
    }

    public String getLog() {
        return log;
    }
}


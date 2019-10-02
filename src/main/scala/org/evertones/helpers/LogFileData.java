package org.evertones.helpers;

import org.evertones.model.LogData;

import java.io.InputStream;

public class LogFileData extends LogData {

    private InputStream data;
    private final String encoding;

    public LogFileData(String template, String log, InputStream data) {
        this(template, log, data, null);
    }

    public LogFileData(String template, String log, InputStream data, String encoding) {
        super(template, log);
        this.data = data;
        this.encoding = encoding;
    }

    public InputStream getData() {
        return data;
    }

    public void setData(InputStream data) {
        this.data = data;
    }

    public String getEncoding() {
        return encoding;
    }
}

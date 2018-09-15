package com.quaspec.service.application.service;

public interface LoggerService {

    public void info(String message);

    public void info(String message, Object ... object);

    public void warning(String warning);

    public void warning(String warning, Object ... object);

    public void error(String tag,Throwable err);

    public void error(Throwable err);

    //public void logJSON(String prefix,JsonNode jsonNode);

    //public ObjectMapper jackson2ObjectMapper();
}

package com.quatspec.service.application.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.quatspec.service.application.service.LoggerService;

@Service("loggerService")
public class LoggerServiceImpl implements LoggerService{

	final Logger logger = LoggerFactory.getLogger(LoggerServiceImpl.class);

    public LoggerServiceImpl(){}

    public void info(String message){
            logger.info(message);
    }

    public void info(String message, Object ... object){
         logger.info(message,object);
    }

    public void warning(String warning){
        logger.warn(warning);
    }

    public void warning(String warning, Object ... object){
        logger.warn(warning,object);
    }

    public void error(String tag,Throwable err){
         logger.error(tag,err);
    }

    public void error(Throwable err){
         logger.error("",err);
    }

 /*   public void logJSON(String prefix,JsonNode jsonNode){
        try {
            logger.info(prefix + "$$$$$" + this.jacksonObjectMapper.writeValueAsString(jsonNode));
        }catch(Exception err){
            logger.error("Error",err);
        }
    }

    public ObjectMapper jackson2ObjectMapper(){
        return this.jacksonObjectMapper;
    }*/


}

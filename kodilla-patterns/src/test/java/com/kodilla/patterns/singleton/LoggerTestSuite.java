package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {

    @Test
    public void testGetLastLog(){
        //Given
        Logger logger = Logger.getInstance();
        String log = "first log";
        logger.log(log);
        //When
        String lastLog = logger.getLastLog();
        //Then
        Assert.assertEquals("first log", lastLog);
    }
}

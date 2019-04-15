package com.docondev.chain.reporter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ReporterTest {

    private AbstractReporter reporterChain;

    @Before
    public void setUp() {
        reporterChain = buildChain();
        reporterChain.setDefaultReporter(new DefaultReporter());
    }

    @Test
    public void givenOneHundred_ReturnsOneHundred() {
        assertTrue(reporterChain.reportMessage(100, "100 Message").equals(100));
    }

    @Test
    public void givenTen_ReturnsTen() {
        assertTrue(reporterChain.reportMessage(10, "10 Message").equals(10));
    }

    @Test
    public void givenNotChainedValue_ReturnsDefaultValue() {
        assertTrue(reporterChain.reportMessage(99, "99 Message").equals(-1));
    }

    private static AbstractReporter buildChain() {
        AbstractReporter oneHundredReporter = new LevelOneHundredReporter();
        AbstractReporter fiftyReporter = new LevelFiftyReporter();
        AbstractReporter tenReporter = new LevelTenReporter();

        oneHundredReporter.setNextReporter(fiftyReporter);
        fiftyReporter.setNextReporter(tenReporter);
        return oneHundredReporter;
    }

}

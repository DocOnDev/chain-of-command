package com.docondev.chain.command;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandChainTest extends AbstractCommandTest {
    @Before
    public void setUp() {
        mixRateCommand.setNextCommand(targetCommand);
//        controls.add(makeControl(MIX_RATE, 5));
    }

    @Test
    public void GivenDifferentMixRate_RunsMixRateCommand() {
        controls.add(makeControl(99.99, TARGET));
        mixRateCommand.execute(controls);
        assertEquals("Mix Rate", controls.getCommandRun());
    }

    @Test
    public void GivenDifferentTarget_RunsMixRateCommand() {
        controls.add(makeControl(MIX_RATE, 99));
        mixRateCommand.execute(controls);
        assertEquals("Target", controls.getCommandRun());
    }

    @Test
    public void GivenDifferentTargetAndMixRate_RunsFirstCommand() {
        controls.add(makeControl(99.99, 99));
        mixRateCommand.execute(controls);
        assertEquals("Mix Rate", controls.getCommandRun());
    }

}

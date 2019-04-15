package com.docondev.chain.command;

import org.junit.Test;

import static org.junit.Assert.*;

public class MixRateCommandTest extends AbstractCommandTest {

    @Test
    public void GivenNoControls_IsNotThisCommand() {
        assertFalse(mixRateCommand.isThisCommand(new Controls()));
    }

    @Test
    public void GivenSameMixRates_IsNotThisCommand() {
        assertFalse(mixRateCommand.isThisCommand(controls));
    }

    @Test
    public void GivenDifferentMixRates_IsThisCommand() {
        controls.add(mismatchMixRate());
        assertTrue(mixRateCommand.isThisCommand(controls));
    }

    @Test
    public void GivenDifferentMixRates_ExecutesCommand() {
        controls.add(mismatchMixRate());
        mixRateCommand.execute(controls);
        assertTrue(controls.getCommandRun().equals("Mix Rate"));
    }

    @Test
    public void GivenSameMixRates_DoesNotExecuteCommand() {
        mixRateCommand.execute(controls);
        assertNull(controls.getCommandRun());
    }
}

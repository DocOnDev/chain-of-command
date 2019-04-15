package com.docondev.chain.command;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


public class TargetCommandTest extends AbstractCommandTest {
    @Test
    public void GivenNoControls_IsNotThisCommand() {
        assertFalse(targetCommand.isThisCommand(new Controls()));
    }

    @Test
    public void GivenSameTargets_IsNotThisCommand() {
        assertFalse(targetCommand.isThisCommand(controls));
    }

    @Test
    public void GivenDifferentTargets_IsThisCommand() {
        controls.add(mismatchTarget());
        assertTrue(targetCommand.isThisCommand(controls));
    }

    @Test
    public void GivenDifferentTargets_ExecutesCommand() {
        controls.add(mismatchTarget());
        targetCommand.execute(controls);
        assertTrue(controls.getCommandRun().equals("Target"));
    }

    @Test
    public void GivenSameTargets_DoesNotExecuteCommand() {
        targetCommand.execute(controls);
        assertNull(controls.getCommandRun());
    }
}

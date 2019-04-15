package com.docondev.chain.command;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ControlsTest {

    private Controls controls;

    @Before
    public void setUp() {
        controls = new Controls();
    }

    @Test
    public void GivenDifferentMixRate_ReportsDifferentMixRate() {
        controls.add(makeControlWithMixRate(99.99));
        controls.add(makeControlWithMixRate(55.55));

        assertTrue(controls.hasDifferentMixRates());
    }

    @Test
    public void GivenSameMixRate_ReportsSameMixRate() {
        controls.add(makeControlWithMixRate(99.99));
        controls.add(makeControlWithMixRate(99.99));

        assertFalse(controls.hasDifferentMixRates());
    }

    @Test
    public void GivenDifferentTarget_ReportsDifferentTarget() {
        controls.add(makeControlWithTarget(99));
        controls.add(makeControlWithTarget(55));

        assertTrue(controls.hasDifferentTargets());
    }

    @Test
    public void GivenSameTarget_ReportsSameTarget() {
        controls.add(makeControlWithTarget(99));
        controls.add(makeControlWithTarget(99));

        assertFalse(controls.hasDifferentTargets());
    }

    @Test
    public void ControlsImplementsIterable() {
        assertTrue(Iterable.class.isAssignableFrom(controls.getClass()));
    }

    private Control makeControlWithTarget(Integer target) {
        Control control = new Control();
        control.setTarget(target);
        return control;
    }

    private Control makeControlWithMixRate(Double mixRate) {
        Control control = new Control();
        control.setMixRate(mixRate);
        return control;
    }
}

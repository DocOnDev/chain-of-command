package com.docondev.chain.command;

abstract class AbstractCommandTest {
    Controls controls = new Controls();
    TargetCommand targetCommand = new TargetCommand();
    MixRateCommand mixRateCommand = new MixRateCommand();
    Double MIX_RATE = 10.0;
    Integer TARGET = 10;

    AbstractCommandTest() {
        controls.add(makeMatchingControl());
        controls.add(makeMatchingControl());
    }

    private Control makeMatchingControl() {
        return makeControl(MIX_RATE, TARGET);
    }

    Control mismatchTarget() {
        return makeControlWithTarget(99);
    }

    Control mismatchMixRate() {
        return makeControlWithMixRate(99.9);
    }

    private Control makeControlWithTarget(Integer target) {
        return makeControl(MIX_RATE, target);
    }

    private Control makeControlWithMixRate(Double mixRate) {
        return makeControl(mixRate, TARGET);
    }

    Control makeControl(Double mixRate, Integer target) {
        Control control = new Control();
        control.setMixRate(mixRate);
        control.setTarget(target);
        return control;
    }

}

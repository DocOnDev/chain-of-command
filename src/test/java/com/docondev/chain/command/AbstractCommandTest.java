package com.docondev.chain.command;

public abstract class AbstractCommandTest {
    Controls controls = new Controls();
    TargetCommand targetCommand = new TargetCommand();
    MixRateCommand mixRateCommand = new MixRateCommand();
    Double MIX_RATE = 10.0;
    Integer TARGET = 10;

    public AbstractCommandTest() {
        controls.add(makeMatchingControl());
        controls.add(makeMatchingControl());
    }

    protected Control makeMatchingControl() {
        return makeControl(MIX_RATE, TARGET);
    }

    protected Control mismatchTarget() {
        return makeControlWithTarget(99);
    }

    protected Control mismatchMixRate() {
        return makeControlWithMixRate(99.9);
    }

    protected Control makeControlWithTarget(Integer target) {
        return makeControl(MIX_RATE, target);
    }

    protected Control makeControlWithMixRate(Double mixRate) {
        return makeControl(mixRate, TARGET);
    }

    protected Control makeControl(Double mixRate, Integer target) {
        Control control = new Control();
        control.setMixRate(mixRate);
        control.setTarget(target);
        return control;
    }


}

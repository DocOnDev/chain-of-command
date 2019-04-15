package com.docondev.chain.command;

public class Control {
    Integer target;
    Double mixRate;
    String feature;

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }

    public Double getMixRate() {
        return mixRate;
    }

    public void setMixRate(Double mixRate) {
        this.mixRate = mixRate;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }
}

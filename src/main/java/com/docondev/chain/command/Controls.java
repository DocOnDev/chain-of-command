package com.docondev.chain.command;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Controls implements Iterable<Control> {
    List<Control> controls = new ArrayList<>();
    String commandRun;

    public String getCommandRun() {
        return commandRun;
    }

    public void setCommandRun(String commandRun) {
        this.commandRun = commandRun;
    }

    public Controls() {
    }

    public void add(Control control) {
        this.controls.add(control);
    }

    @Override
    public Iterator<Control> iterator() {
        return controls.iterator();
    }

    public boolean hasDifferentTargets() {
        if (controls.size() > 0) {
            Integer target = controls.get(0).getTarget();
            return !controls.parallelStream().allMatch(i -> i.getTarget().equals(target));
        }
        return false;
    }

    public boolean hasDifferentMixRates() {
        if (controls.size() > 0) {
            Double mixRate = controls.get(0).getMixRate();
            return !controls.parallelStream().allMatch(i -> i.getMixRate().equals(mixRate));
        }
        return false;
    }
}

package com.docondev.chain.command;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Controls implements Iterable<Control> {
    private List<Control> controlList = new ArrayList<>();
    private String commandRun;

    public String getCommandRun() {
        return commandRun;
    }

    void setCommandRun(String commandRun) {
        this.commandRun = commandRun;
    }

    public void add(Control control) {
        this.controlList.add(control);
    }

    @Override
    public Iterator<Control> iterator() {
        return controlList.iterator();
    }

    boolean hasDifferentTargets() {
        if (!controlList.isEmpty()) {
            Integer target = controlList.get(0).getTarget();
            return !controlList.parallelStream().allMatch(i -> i.getTarget().equals(target));
        }
        return false;
    }

    boolean hasDifferentMixRates() {
        if (!controlList.isEmpty()) {
            Double mixRate = controlList.get(0).getMixRate();
            return !controlList.parallelStream().allMatch(i -> i.getMixRate().equals(mixRate));
        }
        return false;
    }
}

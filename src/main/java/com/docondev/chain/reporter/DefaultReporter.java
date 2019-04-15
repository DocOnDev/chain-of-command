package com.docondev.chain.reporter;

public class DefaultReporter extends AbstractDefaultReporter {
    @Override
    protected Integer write(String message) {
        System.out.println("Default Reporter: " + message);
        return level;
    }
}

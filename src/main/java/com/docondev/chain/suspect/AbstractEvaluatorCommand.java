package com.docondev.chain.suspect;

import org.apache.commons.lang3.StringUtils;

import java.util.logging.Logger;

public abstract class AbstractEvaluatorCommand {

    enum Evaluations {
        SUSPICIOUS(true),
        TRUSTWORTHY(false);

        private final boolean decision;

        Evaluations(boolean decision) {
            this.decision = decision;
        }
    }

    static final boolean SUSPICIOUS = true;
    static final boolean TRUSTWORTHY = false;

    private AbstractEvaluatorCommand nextCommand;
    static final Logger logger = Logger.getLogger(AbstractEvaluatorCommand.class.getName());

    public EvaluatorResponse execute(Suspect suspect) {
        if (shouldDetain(suspect)) {
            return generatedResponse(Evaluations.SUSPICIOUS);
        }

        if (nextCommand != null) {
            return nextCommand.execute(suspect);
        }
        return generatedResponse(Evaluations.TRUSTWORTHY);
    }

    private EvaluatorResponse generatedResponse(Evaluations evaluation) {
        return new EvaluatorResponse(getCommandName(), evaluation.decision);
    }

    public void setNextCommand(AbstractEvaluatorCommand command) {
        this.nextCommand = command;
    }

    protected abstract boolean shouldDetain(Suspect suspect);

    private String getCommandName() {
        return parseToHumanReadableCommandName();
    }

    private String parseToHumanReadableCommandName() {
        return StringUtils.join(
                StringUtils.splitByCharacterTypeCamelCase(this.getClass().getSimpleName()),
                ' '
        ).replace("Command", "").trim();
    }
}
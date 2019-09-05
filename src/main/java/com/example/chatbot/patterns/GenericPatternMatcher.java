package com.example.chatbot.patterns;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public abstract class GenericPatternMatcher implements IPatternMatcher {

    protected List<ActionPattern> patterns;

    protected Matcher matcher;

    GenericPatternMatcher() {
        patterns = new ArrayList<>();
    }

    void addPattern(ActionPattern actionPattern) {
        patterns.add(actionPattern);
    }

    protected Matcher getMatcher() {
        return matcher;
    }

    @Override
    public PatternType matchAny(String text) {

        for (ActionPattern actionPattern: patterns) {

            if ((matcher = actionPattern.getPattern().matcher(text)).matches()) {
                return actionPattern.getType();
            }
        }

        return PatternType.NONE;
    }
}

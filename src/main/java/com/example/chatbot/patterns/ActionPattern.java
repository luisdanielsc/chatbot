package com.example.chatbot.patterns;

import java.util.regex.Pattern;

public class ActionPattern {

    private Pattern pattern;

    private PatternType type;

    public ActionPattern(Pattern pattern, PatternType type) {
        this.pattern = pattern;
        this.type = type;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public PatternType getType() {
        return type;
    }
}

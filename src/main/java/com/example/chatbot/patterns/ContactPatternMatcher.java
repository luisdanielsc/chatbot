package com.example.chatbot.patterns;

import java.util.regex.Pattern;

public class ContactPatternMatcher extends GenericPatternMatcher {

    private String nameRegex = "(?<name>[[a-zA-Z]+ ]+)";

    private String emailRegex = "(?<email>[a-z0-9_-\\.]+@[[a-z0-9]+\\.]+[a-z]{2,3})";

    private String phoneRegex = "(?<phone>\\+?[0-9]{8,10})";

    public ContactPatternMatcher() {
        super();

        patterns.add(new ActionPattern(
                Pattern.compile(String.format("^Create contact: %s[,%s[,%s]?]?$", nameRegex, emailRegex, phoneRegex)),
                PatternType.CREATE_CONTACT));

        patterns.add(new ActionPattern(
                Pattern.compile(String.format("^Show contact: %s$", nameRegex)),
                PatternType.SHOW_CONTACT
        ));

        patterns.add(new ActionPattern(
                Pattern.compile(String.format("^Delete contact: %s$", nameRegex)),
                PatternType.DELETE_CONTACT
        ));

        patterns.add(new ActionPattern(
                Pattern.compile(String.format("^Contact %s set name: %s$", nameRegex, nameRegex)),
                PatternType.MODIFY_CONTACT
        ));

        patterns.add(new ActionPattern(
                Pattern.compile(String.format("^Contact %s set email: %s$", nameRegex, emailRegex)),
                PatternType.MODIFY_CONTACT
        ));

        patterns.add(new ActionPattern(
                Pattern.compile(String.format("^Contact %s set phone: %s$", nameRegex, phoneRegex)),
                PatternType.MODIFY_CONTACT
        ));

        patterns.add(new ActionPattern(
                Pattern.compile(String.format("^Search contact by name: %s$", nameRegex)),
                PatternType.SEARCH_CONTACT_BY_NAME
        ));

        patterns.add(new ActionPattern(
                Pattern.compile(String.format("^Search contact by email: %s$", emailRegex)),
                PatternType.SEARCH_CONTACT_BY_EMAIL
        ));

        patterns.add(new ActionPattern(
                Pattern.compile(String.format("^Search contact by phone: %s$", phoneRegex)),
                PatternType.SEARCH_CONTACT_BY_PHONE
        ));
    }

    public String getNameGroup() {
        return matcher.group("name");
    }

    public String getEmailGroup() {
        return matcher.group("email");
    }

    public String getPhoneGroup() {
        return matcher.group("phone");
    }
}

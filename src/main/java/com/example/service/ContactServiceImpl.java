package com.example.service;

import com.example.domain.Contact;

import java.util.HashMap;
import java.util.Map;

public class ContactServiceImpl extends GenericService<Contact> implements Service<Contact> {

    @Override
    Class<Contact> getEntityType() {
        return Contact.class;
    }

    public Contact findByName(String name) {
        Map<String, String> params = new HashMap<>();
        params.put("contact_name", name);

        return session.queryForObject(Contact.class, "MATCH (c:Contact {name: $contact_name}) RETURN c", params);
    }
}

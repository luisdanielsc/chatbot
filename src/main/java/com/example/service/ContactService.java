package com.example.service;

import com.example.domain.Contact;
import org.neo4j.ogm.model.Result;

interface ContactService extends Service<Contact> {

    Result getContactByName(String name);
}

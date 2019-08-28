package com.example.service;

import com.example.domain.History;

public class HistoryServiceImpl extends GenericService<History> implements HistoryService {

    @Override
    Class<History> getEntityType() {
        return History.class;
    }
}

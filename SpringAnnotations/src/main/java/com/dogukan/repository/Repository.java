package com.dogukan.repository;

import com.dogukan.domain.Message;

public interface Repository {
    void saveMessage(Message message);
}

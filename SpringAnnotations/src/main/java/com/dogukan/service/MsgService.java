package com.dogukan.service;

import com.dogukan.domain.Message;

public interface MsgService {
    void sendMessage(Message message);

    void saveMessage(Message message);
}

package com.nowcoder.community.service;

import com.nowcoder.community.dao.MessageMapper;
import com.nowcoder.community.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    MessageMapper messageMapper;

    public List<Message> selectMessageById(int fromId) {
        List<Message> message = messageMapper.selectMessageById(fromId);

        return message;
    }
}

package com.abhi.shoes.component;

import com.abhi.shoes.dao.UserInfoRepository;
import com.abhi.shoes.model.UserInfo;
import lombok.extern.java.Log;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Log
public class MQListener {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void receiveMessage(UserInfo message){
        log.info("Received Message :>>>>>>>"+message);
        userInfoRepository.save(message);
    }
}

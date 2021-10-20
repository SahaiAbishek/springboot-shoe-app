package com.abhi.shoes.service;

import com.abhi.shoes.model.UserInfo;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabitMQService {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.queue}")
    private String queue;

    public void send(UserInfo userInfo) {
        try{
            rabbitTemplate.convertAndSend(queue, userInfo);
            System.out.println("Send msg = " + userInfo);
        } catch (Exception ex){
            ex.printStackTrace();
        }


    }
}

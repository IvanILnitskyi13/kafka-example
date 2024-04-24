package com.example.kafkaexample.controllers;

import com.example.kafkaexample.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/messages")
@RequiredArgsConstructor
public class MessageController {

    private final KafkaTemplate<String, String> kafkaTemplate;
    @PostMapping("/publish")
    public void publish(@RequestBody UserDto user) {
        kafkaTemplate.send("users", user.getName());
    }
}

package br.com.rabbitmq.userpublishmessage.publisher.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    
    private String name;
    private String email;
    private String subject;
    private String description;
}

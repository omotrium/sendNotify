package com.tayo.test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author talabiomotayo on 7/1/20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String email;
    private String htmlTemplate;
    private String receiver;
    private String subject;
    private String text;
    private String phoneNumber;
}

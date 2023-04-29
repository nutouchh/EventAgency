package com.nutouchh.EventAgency.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Action {
    private Long id;
    private String title; //название услуги - действия
    private String description; //описание услуги
    private int price; //цена услуги
}

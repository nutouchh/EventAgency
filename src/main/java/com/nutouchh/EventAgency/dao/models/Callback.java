package com.nutouchh.EventAgency.dao.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Callback {
    private String name;
    private String email;
    private String phone;
    private String comment;

    @Override
    public String toString() {
        return "Имя: " + name + "\n"
                + "Почта: " + email + "\n"
                + "Телефон: " + phone + "\n"
                + "Комментарий: " + comment;
    }
}


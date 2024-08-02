package ru.example.framework.postgres.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"empCodeId\"")
    private Long empCodeId;

    @Column(length = 64, nullable = false)
    private String text;

    @Override
    public String toString() {
        return "User{" +
                "empCodeId=" + empCodeId +
                ", text='" + text + '\'' +
                '}';
    }
}

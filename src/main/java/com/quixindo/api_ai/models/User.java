package com.quixindo.api_ai.models;

import jakarta.persistence.*;
import lombok.*;

@Entity()
@Table(name = "tb_users")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String email;
    private String password;
}
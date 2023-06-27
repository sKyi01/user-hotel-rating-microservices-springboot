package com.springboot.user.services.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "micro_users")
public class User {

    @Id
    @Column(name = "user_id")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String userId;
    @Column(length = 50)
    private String name;
    @Column(unique = true, length = 50)
    private String email;
    @Column(length = 1000)
    private String about;


    @Transient
    private List<Rating> rating = new ArrayList<>();


    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", about='" + about + '\'' +
                '}';
    }


}

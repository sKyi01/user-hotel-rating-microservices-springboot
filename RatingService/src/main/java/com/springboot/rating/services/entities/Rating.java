package com.springboot.rating.services.entities;


import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document
public class Rating {

    private String userId;
    private String hotelId;
    @Id
    private String ratingId;
    private String feedback;
    private int rating;

}

package com.codecool.hogwartshouses.persistence.entity;

import com.codecool.hogwartshouses.data.House;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {
    @Id
    @GeneratedValue
    private long id;
    private House house;
    @OneToOne
    private Student student;
}

package com.demandfarm.character;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class House {
    @Id
    @Column(name = "house_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private
    Long houseId;

    @Column(name = "house_name")
    private
    String houseName;

}

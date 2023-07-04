package com.demandfarm.character;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class House {
    @Id
    @Column(name = "house_id")
    private
    Long houseId;

    @Column(name = "house_name")
    private
    String houseName;

}

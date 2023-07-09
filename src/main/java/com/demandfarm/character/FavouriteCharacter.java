package com.demandfarm.character;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class FavouriteCharacter {

    @Id
    @GeneratedValue
    @Column(name = "favourite_character_id")
    private Long favouriteCharacterId;

    @Column(name = "character_id")
    private Long characterId;

}

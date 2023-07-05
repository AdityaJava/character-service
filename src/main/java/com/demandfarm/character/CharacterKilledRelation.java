package com.demandfarm.character;

import lombok.Data;

import javax.persistence.*;
//This is who is killed by character i.e characterKilledId
@Data
@Entity
public class CharacterKilledRelation {

    @Id
    @Column(name = "character_killed_relation_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long characterKilledRelationId;

    @Column(name = "character_id")
    private Long characterId;

    @Column(name = "character_killed_id")
    private Long characterKilledId;
}

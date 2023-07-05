package com.demandfarm.character;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class CharacterMarriedEngagedRelation {

    @Id
    @Column(name = "character_married_engaged_relation_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long characterMarriedEngagedRelationId;

    @Column(name = "character_id")
    Long characterId;

    @Column(name = "character_married_engaged_id")
    Long characterMarriedEngagedId;
}

package com.demandfarm.character;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class CharacterMarriedEngagedRelation {

    @Id
    @Column(name = "character_married_engaged_relation_id")
    Long characterMarriedEngagedRelationId;

    @Column(name = "character_id")
    Long characterId;

    @Column(name = "character_married_engaged_id")
    Long characterMarriedEngagedId;
}

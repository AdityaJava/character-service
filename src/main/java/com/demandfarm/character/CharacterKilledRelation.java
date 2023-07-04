package com.demandfarm.character;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class CharacterKilledRelation {

    @Id
    @Column(name = "character_killed_relation_id")
    private Long characterKilledRelationId;

    @Column(name = "character_id")
    private Long characterId;

    @Column(name = "character_killed_id")
    private Long characterKilledId;
}

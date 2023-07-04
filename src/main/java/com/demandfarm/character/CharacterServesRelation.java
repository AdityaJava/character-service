package com.demandfarm.character;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class CharacterServesRelation {

    @Id
    @Column(name = "character_serves_relation_id")
    private Long characterServesRelationId;

    @Column(name = "character_id")
    private Long characterId;

    @Column(name = "character_serves_id")
    private Long characterServesId;
}

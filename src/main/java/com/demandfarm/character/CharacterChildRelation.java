package com.demandfarm.character;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class CharacterChildRelation {

    @Id
    @Column(name = "character_child_relation__id")
    private Long characterChildRelationId;

    @Column(name = "character_id")
    private Long characterId;

    @Column(name = "character_child_id")
    private Long characterChildId;
}

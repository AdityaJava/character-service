package com.demandfarm.character;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class CharacterSiblingRelation {

    @Id
    @Column(name = "character_sibling_relation_id")
    private Long characterSiblingRelationId;

    @Column(name = "character_id")
    private Long characterId;

    @Column(name = "character_sibling_id")
    private Long characterSiblingId;
}

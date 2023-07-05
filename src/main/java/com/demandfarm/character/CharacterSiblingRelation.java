package com.demandfarm.character;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class CharacterSiblingRelation {

    @Id
    @Column(name = "character_sibling_relation_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long characterSiblingRelationId;

    @Column(name = "character_id")
    private Long characterId;

    @Column(name = "character_sibling_id")
    private Long characterSiblingId;
}

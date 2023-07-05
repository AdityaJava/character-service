package com.demandfarm.character;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class CharacterServesRelation {

    @Id
    @Column(name = "character_serves_relation_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long characterServesRelationId;

    @Column(name = "character_id")
    private Long characterId;

    @Column(name = "character_serves_id")
    private Long characterServesId;
}

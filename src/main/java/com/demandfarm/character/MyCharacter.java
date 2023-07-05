package com.demandfarm.character;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "my_character")
public class MyCharacter {

    @Id
    @Column(name = "character_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long characterId;

    @Column(name = "character_name")
    private
    String characterName;

    @Column(name = "actor_name")
    private
    String actorName;

    @Column(name = "actor_link")
    private
    String actorLink;

    @Column(name = "house_id")
    private Long houseId;

    @Column(name = "nickname")
    String nickname;

    @Column(name = "royal")
    String royal;

    @OneToMany(mappedBy = "characterId")
    private
    List<CharacterChildRelation> characterChildList;

    @OneToMany(mappedBy = "characterId")
    private
    List<CharacterKilledRelation> characterKilledRelationList;

    @OneToMany(mappedBy = "characterId")
    private
    List<CharacterSiblingRelation> characterSiblingList;

    @OneToMany(mappedBy = "characterId")
    private
    List<CharacterServesRelation> characterServesList;

    @OneToMany(mappedBy = "characterId")
    private
    List<CharacterMarriedEngagedRelation> characterMarriedEngagedList;

}

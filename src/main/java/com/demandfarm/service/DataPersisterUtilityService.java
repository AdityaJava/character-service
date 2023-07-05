package com.demandfarm.service;

import com.demandfarm.character.*;
import org.springframework.stereotype.Service;

@Service
public class DataPersisterUtilityService {
    public House constructHouse(String houseName) {
        House house = new House();
        house.setHouseName(houseName);
        return house;
    }

    public MyCharacter constructMyCharacter(String characterName) {
        MyCharacter myCharacter = new MyCharacter();
        myCharacter.setCharacterName(characterName);
        return myCharacter;
    }

    public CharacterChildRelation contructCharacterChildRelation(MyCharacter character, MyCharacter child) {
        CharacterChildRelation characterChildRelation = new CharacterChildRelation();
        characterChildRelation.setCharacterChildId(child.getCharacterId());
        characterChildRelation.setCharacterId(character.getCharacterId());
        return characterChildRelation;
    }

    public CharacterKilledRelation contructCharacterKilledRelation(MyCharacter character, MyCharacter killed) {
        CharacterKilledRelation characterKilledRelation = new CharacterKilledRelation();
        characterKilledRelation.setCharacterKilledId(killed.getCharacterId());
        characterKilledRelation.setCharacterId(character.getCharacterId());
        return characterKilledRelation;
    }

    public CharacterMarriedEngagedRelation contructCharacterMarriedEngagedRelation(MyCharacter character, MyCharacter marriedTo) {
        CharacterMarriedEngagedRelation characterMarriedEngagedRelation = new CharacterMarriedEngagedRelation();
        characterMarriedEngagedRelation.setCharacterId(character.getCharacterId());
        characterMarriedEngagedRelation.setCharacterMarriedEngagedId(marriedTo.getCharacterId());
        return characterMarriedEngagedRelation;
    }

    public CharacterServesRelation contructCharacterServesRelation(MyCharacter servantCharacter, MyCharacter masterCharacter) {
        CharacterServesRelation characterServesRelation = new CharacterServesRelation();
        characterServesRelation.setCharacterId(servantCharacter.getCharacterId());
        characterServesRelation.setCharacterServesId(masterCharacter.getCharacterId());
        return characterServesRelation;
    }

    public CharacterSiblingRelation contructCharacterSiblingRelation(MyCharacter character, MyCharacter sibling) {
        CharacterSiblingRelation characterSiblingRelation = new CharacterSiblingRelation();
        characterSiblingRelation.setCharacterId(character.getCharacterId());
        characterSiblingRelation.setCharacterSiblingId(sibling.getCharacterId());
        return characterSiblingRelation;
    }

}

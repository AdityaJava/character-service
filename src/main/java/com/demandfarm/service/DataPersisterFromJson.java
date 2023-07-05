package com.demandfarm.service;

import com.demandfarm.character.*;
import com.demandfarm.repository.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Data
@Service
public class DataPersisterFromJson {

    private CharacterRepository characterRepository;
    private CharacterChildRelationRepository characterChildRelationRepository;
    private CharacterKilledRelationRepository characterKilledRelationRepository;
    private CharacterMarriedEngagedRelationRepository characterMarriedEngagedRelationRepository;
    private CharacterServesRelationRepository characterServesRelationRepository;
    private CharacterSiblingRelationRepository characterSiblingRelationRepository;
    private HouseRepository houseRepository;
    private DataPersisterUtilityService dataPersisterUtilityService;
    @Value("classpath:data.json")
    private
    Resource resourceFile;

    @Autowired
    public DataPersisterFromJson(CharacterRepository characterRepository, CharacterChildRelationRepository characterChildRelationRepository, CharacterKilledRelationRepository characterKilledRelationRepository, CharacterMarriedEngagedRelationRepository characterMarriedEngagedRelationRepository, CharacterServesRelationRepository characterServesRelationRepository, CharacterSiblingRelationRepository characterSiblingRelationRepository, HouseRepository houseRepository, DataPersisterUtilityService dataPersisterUtilityService) {
        this.characterRepository = characterRepository;
        this.characterChildRelationRepository = characterChildRelationRepository;
        this.characterKilledRelationRepository = characterKilledRelationRepository;
        this.characterMarriedEngagedRelationRepository = characterMarriedEngagedRelationRepository;
        this.characterServesRelationRepository = characterServesRelationRepository;
        this.characterSiblingRelationRepository = characterSiblingRelationRepository;
        this.houseRepository = houseRepository;
        this.dataPersisterUtilityService = dataPersisterUtilityService;
    }


    public void persistCharacterToDB() throws IOException {
        CharacterJsonMapper characterJsonMapper = parseJsonFile();
        List<CharacterJsonData> characterJsonDataList = characterJsonMapper.getCharacterJsonDataList();
        persistRelationsToDB(characterJsonDataList);
    }


    private void persistRelationsToDB(List<CharacterJsonData> characterJsonDataList) {
        MyCharacter child = new MyCharacter();
        MyCharacter parent = new MyCharacter();
        MyCharacter character = new MyCharacter();

        for (CharacterJsonData characterJsonData : characterJsonDataList) {
            List<String> childsOfCharacter = characterJsonData.getParentOf();
            List<String> parentsOfCharacter = characterJsonData.getParents();

            List<String> characterKilledList = characterJsonData.getKilled();
            List<String> characterKilledByList = characterJsonData.getKilledBy();

            //character married to
            List<String> characterMarriedEngagedList = characterJsonData.getMarriedEngaged();

            List<String> characterServesList = characterJsonData.getServes();
            List<String> characterServedByList = characterJsonData.getServedBy();

            List<String> characterSiblingList = characterJsonData.getSiblings();


            character = characterRepository.save(dataPersisterUtilityService.constructMyCharacter(characterJsonData.getCharacterName()));
            if (childsOfCharacter != null) {
                for (String childOfCharacter : childsOfCharacter) {
                    child = characterRepository.save(dataPersisterUtilityService.constructMyCharacter(childOfCharacter));
                    characterChildRelationRepository.save(dataPersisterUtilityService.contructCharacterChildRelation(character, child));
                }
            }
            if (parentsOfCharacter != null) {
                for (String parentOfCharacter : parentsOfCharacter) {
                    parent = characterRepository.save(dataPersisterUtilityService.constructMyCharacter(parentOfCharacter));
                    characterChildRelationRepository.save(dataPersisterUtilityService.contructCharacterChildRelation(parent, character));
                }
            }

            if (characterKilledList != null) {
                for (String characterKilled : characterKilledList) {
                    MyCharacter characterKilledTemp = characterRepository.save(dataPersisterUtilityService.constructMyCharacter(characterKilled));
                    characterKilledRelationRepository.save(dataPersisterUtilityService.contructCharacterKilledRelation(character, characterKilledTemp));
                }
            }
            if (characterKilledByList != null) {
                for (String characterKilledBy : characterKilledByList) {
                    MyCharacter characterKilledByTemp = characterRepository.save(dataPersisterUtilityService.constructMyCharacter(characterKilledBy));
                    characterKilledRelationRepository.save(dataPersisterUtilityService.contructCharacterKilledRelation(characterKilledByTemp, character));
                }
            }
            if (characterMarriedEngagedList != null) {
                for (String characterMarriedEngaged : characterMarriedEngagedList) {
                    MyCharacter characterMarriedEngagedTemp = characterRepository.save(dataPersisterUtilityService.constructMyCharacter(characterMarriedEngaged));
                    characterMarriedEngagedRelationRepository.save(dataPersisterUtilityService.contructCharacterMarriedEngagedRelation(character, characterMarriedEngagedTemp));
                }
            }
            if (characterServesList != null) {
                for (String characterServes : characterServesList) {
                    MyCharacter characterServesTemp = characterRepository.save(dataPersisterUtilityService.constructMyCharacter(characterServes));
                    characterServesRelationRepository.save(dataPersisterUtilityService.contructCharacterServesRelation(character, characterServesTemp));
                }
            }
            if (characterServedByList != null) {
                for (String characterServedBy : characterServedByList) {
                    MyCharacter characterServedByTemp = characterRepository.save(dataPersisterUtilityService.constructMyCharacter(characterServedBy));
                    characterServesRelationRepository.save(dataPersisterUtilityService.contructCharacterServesRelation(characterServedByTemp, character));
                }
            }

            if (characterSiblingList != null) {
                for (String characterSibling : characterSiblingList) {
                    MyCharacter characterSiblingTemp = characterRepository.save(dataPersisterUtilityService.constructMyCharacter(characterSibling));
                    characterSiblingRelationRepository.save(dataPersisterUtilityService.contructCharacterSiblingRelation(characterSiblingTemp, character));
                }
            }
            if (characterJsonData.getHouseName() != null) {
                House house = houseRepository.save(dataPersisterUtilityService.constructHouse(characterJsonData.getHouseName()));
                character.setHouseId(house.getHouseId());
            }
            character.setActorLink(characterJsonData.getActorLink());
            character.setActorName(characterJsonData.getActorName());
            character.setRoyal(characterJsonData.getRoyal());
            character.setNickname(characterJsonData.getNickname());
            characterRepository.save(character);
        }
    }

    public CharacterJsonMapper parseJsonFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        CharacterJsonMapper characterJsonMapper = objectMapper.readValue(getResourceFile().getFile(), CharacterJsonMapper.class);
        return characterJsonMapper;
    }


}

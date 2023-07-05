package com.demandfarm.service;

import com.demandfarm.repository.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;

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

    @Autowired
    public DataPersisterFromJson(CharacterRepository characterRepository, CharacterChildRelationRepository characterChildRelationRepository, CharacterKilledRelationRepository characterKilledRelationRepository, CharacterMarriedEngagedRelationRepository characterMarriedEngagedRelationRepository, CharacterServesRelationRepository characterServesRelationRepository, CharacterSiblingRelationRepository characterSiblingRelationRepository, HouseRepository houseRepository, Resource resourceFile) {
        this.characterRepository = characterRepository;
        this.characterChildRelationRepository = characterChildRelationRepository;
        this.characterKilledRelationRepository = characterKilledRelationRepository;
        this.characterMarriedEngagedRelationRepository = characterMarriedEngagedRelationRepository;
        this.characterServesRelationRepository = characterServesRelationRepository;
        this.characterSiblingRelationRepository = characterSiblingRelationRepository;
        this.houseRepository = houseRepository;
        this.resourceFile = resourceFile;
    }

    @Value("classpath:data.json")
    private
    Resource resourceFile;

    public CharacterJsonMapper parseJsonFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        CharacterJsonMapper characterJsonMapper = objectMapper.readValue(getResourceFile().getFile(), CharacterJsonMapper.class);
        return characterJsonMapper;
    }


    private Resource getResourceFile() {
        return resourceFile;
    }

    private void setResourceFile(Resource resourceFile) {
        this.resourceFile = resourceFile;
    }
}

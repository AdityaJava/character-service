package com.demandfarm.service;

import com.demandfarm.character.MyCharacter;
import com.demandfarm.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CharacterService {

    private CharacterRepository characterRepository;

    private DataPersisterFromJson dataPersisterFromJson;

    @Autowired
    public CharacterService(CharacterRepository characterRepository, DataPersisterFromJson dataPersisterFromJson) {
        this.characterRepository = characterRepository;
        this.dataPersisterFromJson = dataPersisterFromJson;
    }

    public List<MyCharacter> getCharacters(){
        return characterRepository.findAll();
    }

    public void persistDataFromJsonToDB() throws IOException {
        dataPersisterFromJson.persistCharacterToDB();
    }
}

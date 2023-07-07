package com.demandfarm.service;

import com.demandfarm.character.House;
import com.demandfarm.character.MyCharacter;
import com.demandfarm.repository.CharacterRepository;
import com.demandfarm.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CharacterService {

    private CharacterRepository characterRepository;

    private HouseRepository houseRepository;
    private DataPersisterFromJson dataPersisterFromJson;

    @Autowired
    public CharacterService(CharacterRepository characterRepository, DataPersisterFromJson dataPersisterFromJson, HouseRepository houseRepository) {
        this.characterRepository = characterRepository;
        this.dataPersisterFromJson = dataPersisterFromJson;
        this.houseRepository = houseRepository;
    }

    public Page<MyCharacter> getCharacters(Pageable pageable) {
        return characterRepository.findAll(pageable);
    }

    public void persistDataFromJsonToDB() throws IOException {
        dataPersisterFromJson.persistCharacterToDB();
    }

    public List<House> getHouses() {
        return houseRepository.findAll();
    }

    public List<MyCharacter> getCharactersBasedOnHouse(String houseName) {
        House house = houseRepository.findTopByHouseName(houseName);
        if (house == null) {
            throw new RuntimeException("House not found");
        }
        return characterRepository.findByHouseId(house.getHouseId());
    }

    public MyCharacter getCharacter(Long id) {
        return characterRepository.findById(id).orElse(null);
    }
}

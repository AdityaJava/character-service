package com.demandfarm.service;

import com.demandfarm.annotation.MyAnnotation;
import com.demandfarm.character.House;
import com.demandfarm.character.MyCharacter;
import com.demandfarm.character.ToUpdateData;
import com.demandfarm.repository.CharacterRepository;
import com.demandfarm.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
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

    @MyAnnotation
    public Page<MyCharacter> getCharacters(Pageable pageable) {
        return characterRepository.findAll(pageable);
    }

    @PostConstruct
    public void storeOnLoad() throws IOException {
        dataPersisterFromJson.persistCharacterToDB();
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

    @Transactional
    public MyCharacter getCharacter(Long id) {
        return characterRepository.findById(id).orElse(null);
    }

    @Transactional
    public void markAsFavouriteOrUnfavourite(ToUpdateData toUpdateData, Long characterId) {
        MyCharacter myCharacter = characterRepository.findById(characterId).orElse(null);
        if(myCharacter!=null){
            myCharacter.setFavouriteCharacter(toUpdateData.getIsFavourite());
        }
    }

    public Page<MyCharacter> getFavouriteCharacters(Pageable pageable) {
        return characterRepository.findByFavouriteCharacter(true, pageable);
    }
}

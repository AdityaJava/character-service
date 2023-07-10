package com.demandfarm.controller;

import com.demandfarm.character.House;
import com.demandfarm.character.MyCharacter;
import com.demandfarm.character.ToUpdateData;
import com.demandfarm.service.CharacterService;
import com.demandfarm.service.DataPersisterFromJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/characters")
@CrossOrigin(origins = "*", methods = {RequestMethod.PUT,RequestMethod.GET})
public class CharacterController {

    private CharacterService characterService;

    @Autowired
    public CharacterController(DataPersisterFromJson dataPersisterFromJson, CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    public Page<MyCharacter> getCharacters(Pageable pageable) {
        return characterService.getCharacters(pageable);
    }

    @GetMapping("/{id}")
    public MyCharacter getCharacter(@PathVariable("id") Long id) {
        return characterService.getCharacter(id);
    }


    @GetMapping("/houses")
    public List<House> getHouses() {
        return characterService.getHouses();
    }

    @GetMapping("/familytree/{houseName}")
    public List<MyCharacter> getCharacterInHouse(@PathVariable("houseName") String houseName) {
        return characterService.getCharactersBasedOnHouse(houseName);
    }

    @PostMapping("/jsonFile")
    public void mapJsonToObject() throws IOException {
        characterService.persistDataFromJsonToDB();
    }

    @PutMapping("/favourite/{characterId}")
    public void markAsFavouriteOrUnfavourite(@PathVariable Long characterId, @RequestBody ToUpdateData toUpdateData ){
        characterService.markAsFavouriteOrUnfavourite(toUpdateData, characterId);
    }

    @GetMapping("/favourite")
    public List<MyCharacter> getFavouriteCharacters(Boolean status){
        return characterService.getFavouriteCharacters(status);
    }
}
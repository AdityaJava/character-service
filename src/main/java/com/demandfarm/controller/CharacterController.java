package com.demandfarm.controller;

import com.demandfarm.character.FavouriteCharacter;
import com.demandfarm.character.House;
import com.demandfarm.character.MyCharacter;
import com.demandfarm.service.CharacterJsonMapper;
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
@CrossOrigin(origins = "http://localhost:3000")
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

    @PutMapping("/favouriteCharacter")
    public FavouriteCharacter markCharacterAsFavourite(@RequestBody FavouriteCharacter favouriteCharacter){
        return characterService.markAsFavouriteCharacter(favouriteCharacter);
    }

    @DeleteMapping("/favouriteCharacter/{favouriteCharacterId}")
    public void markCharacterAsNotFavourite(@PathVariable Long favouriteCharacterId){
         characterService.deleteFavouriteCharacter(favouriteCharacterId);
    }

}

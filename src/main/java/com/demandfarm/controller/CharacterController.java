package com.demandfarm.controller;

import com.demandfarm.character.MyCharacter;
import com.demandfarm.service.CharacterJsonMapper;
import com.demandfarm.service.CharacterService;
import com.demandfarm.service.DataPersisterFromJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/characters")
public class CharacterController {

    private CharacterService characterService;
    @Autowired
    public CharacterController(DataPersisterFromJson dataPersisterFromJson, CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    public List<MyCharacter> getCharacters(){
        return characterService.getCharacters();
    }

    @PostMapping("/jsonFile")
    public void mapJsonToObject() throws IOException {
        characterService.persistDataFromJsonToDB();
    }


}

package com.demandfarm.controller;

import com.demandfarm.service.CharacterJsonMapper;
import com.demandfarm.service.DataPersisterFromJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1")
public class CharacterController {

    private DataPersisterFromJson dataPersisterFromJson;

    @Autowired
    public CharacterController(DataPersisterFromJson dataPersisterFromJson) {
        this.dataPersisterFromJson = dataPersisterFromJson;
    }

    @PostMapping("/jsonFile")
    public CharacterJsonMapper mapJsonToObject(@RequestBody CharacterJsonMapper characterJsonMapper) throws IOException {
        return dataPersisterFromJson.parseJsonFile();
    }

}

package com.demandfarm.service;

import com.demandfarm.repository.CharacterRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DataPersisterFromJson {

    @Autowired
    CharacterRepository characterRepository;

    @Value("classpath:data.json")
    Resource resourceFile;
    public CharacterJsonMapper persistDataToDB() throws IOException {
        System.out.println(characterRepository.findById(1l));
        System.out.println(resourceFile.getFilename());
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        CharacterJsonMapper characterJsonMapper = objectMapper.readValue(resourceFile.getFile(), CharacterJsonMapper.class);
        return characterJsonMapper;
    }

}

package com.demandfarm.service;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CharacterJsonMapper implements Serializable {

    @JsonProperty("characters")
    List<CharacterJsonData> characterJsonDataList;
}

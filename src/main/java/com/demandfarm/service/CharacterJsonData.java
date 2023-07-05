package com.demandfarm.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CharacterJsonData {

    private String characterName;
    private String characterLink;
    private String actorName;
    private String actorLink;
    private String houseName;
    private String royal;
    private String nickname;
    private List<String> parents;
    private List<String> siblings;
    private List<String> killedBy;
    private List<String> servedBy;
    private List<String> parentOf;
    private List<String> marriedEngaged;
    private List<String> killed;
    private List<String> serves;
    //private List<String> guardedBy;
}

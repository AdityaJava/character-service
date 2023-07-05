package com.demandfarm.repository;

import com.demandfarm.character.MyCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<MyCharacter, Long> {
    public MyCharacter findTopByCharacterName(String characterName);
    public List<MyCharacter> findByHouseId (Long houseId);
}

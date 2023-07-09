package com.demandfarm.repository;

import com.demandfarm.character.FavouriteCharacter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavouriteCharacterRepository extends JpaRepository<FavouriteCharacter, Long> {
    public FavouriteCharacter findTopByCharacterId(Long CharacterId);
}

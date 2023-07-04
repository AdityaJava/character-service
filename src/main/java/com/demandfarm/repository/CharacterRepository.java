package com.demandfarm.repository;

import com.demandfarm.character.MyCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<MyCharacter, Long> {
}

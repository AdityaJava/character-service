package com.demandfarm.repository;

import com.demandfarm.character.CharacterKilledRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterKilledRelationRepository extends JpaRepository<CharacterKilledRelation, Long> {
}

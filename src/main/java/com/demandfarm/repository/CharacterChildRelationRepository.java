package com.demandfarm.repository;

import com.demandfarm.character.CharacterChildRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterChildRelationRepository extends JpaRepository<CharacterChildRelation, Long> {
}

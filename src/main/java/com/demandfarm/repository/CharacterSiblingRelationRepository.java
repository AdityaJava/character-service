package com.demandfarm.repository;

import com.demandfarm.character.CharacterSiblingRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterSiblingRelationRepository extends JpaRepository<CharacterSiblingRelation, Long> {
}

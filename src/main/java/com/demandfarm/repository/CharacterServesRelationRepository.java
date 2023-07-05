package com.demandfarm.repository;

import com.demandfarm.character.CharacterServesRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterServesRelationRepository extends JpaRepository<CharacterServesRelation, Long> {
}

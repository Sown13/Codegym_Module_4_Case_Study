package com.group1.web_games.repo.intermediate_repo;

import com.group1.web_games.model.intermediate.CharacterItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICharacterItemRepo extends JpaRepository<CharacterItem,Long> {
}

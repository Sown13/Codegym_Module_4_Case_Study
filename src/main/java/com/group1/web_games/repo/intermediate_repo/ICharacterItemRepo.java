package com.group1.web_games.repo.intermediate_repo;

import com.group1.web_games.model.intermediate.CharacterItem;
import com.group1.web_games.model.main_entity.GameCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICharacterItemRepo extends JpaRepository<CharacterItem,Long> {
    List<CharacterItem> findCharacterItemByGameCharacter(GameCharacter gameCharacter);
}

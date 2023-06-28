package com.group1.web_games.repo.main_entity_repo;

import com.group1.web_games.model.main_entity.CharacterDetail;
import com.group1.web_games.model.main_entity.GameCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICharacterDetailRepo extends JpaRepository<CharacterDetail,Long> {

}

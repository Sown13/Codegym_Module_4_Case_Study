package com.group1.web_games.repo.main_entity_repo;

import com.group1.web_games.model.main_entity.GameCharacter;
import com.group1.web_games.model.main_entity.GameSession;
import com.group1.web_games.model.main_entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGameSessionRepo extends JpaRepository<GameSession,Long> {
    List<GameSession> findGameSessionByUserEntity (UserEntity userEntity);
}

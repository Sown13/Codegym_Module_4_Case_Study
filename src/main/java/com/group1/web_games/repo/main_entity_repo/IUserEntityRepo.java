package com.group1.web_games.repo.main_entity_repo;

import com.group1.web_games.model.main_entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserEntityRepo extends JpaRepository<UserEntity,Long> {
    @Query(value = "select u from UserEntity as u where u.email = :email")
    UserEntity findByUserEmail(String email);





}

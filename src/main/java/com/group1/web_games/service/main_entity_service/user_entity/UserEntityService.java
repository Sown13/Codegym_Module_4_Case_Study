package com.group1.web_games.service.main_entity_service.user_entity;

import com.group1.web_games.model.main_entity.UserEntity;
import com.group1.web_games.repo.main_entity_repo.IUserEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserEntityService implements IUserEntityService{
    @Autowired
    private IUserEntityRepo userEntityRepo;

    @Override
    public Iterable<UserEntity> findAll() {
        return userEntityRepo.findAll();
    }

    @Override
    public Optional<UserEntity> findById(Long id) {
        return userEntityRepo.findById(id);
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        return userEntityRepo.save(userEntity);
    }

    @Override
    public void remove(Long id) {
        userEntityRepo.deleteById(id);
    }
}

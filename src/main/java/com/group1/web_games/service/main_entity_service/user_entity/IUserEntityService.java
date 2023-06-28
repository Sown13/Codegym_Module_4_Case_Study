package com.group1.web_games.service.main_entity_service.user_entity;

import com.group1.web_games.model.main_entity.UserEntity;
import com.group1.web_games.service.IGeneralService;

public interface IUserEntityService extends IGeneralService<UserEntity> {
    UserEntity findByUserEmail(String email);
}

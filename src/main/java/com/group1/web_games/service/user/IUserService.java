package com.group1.web_games.service.user;

import com.group1.web_games.model.user.User;
import com.group1.web_games.service.IGeneralService;

public interface IUserService extends IGeneralService<User> {

    User findByUserEmail(String email);

}

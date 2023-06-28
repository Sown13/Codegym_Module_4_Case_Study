package com.group1.web_games.repo.user;


import com.group1.web_games.model.user.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String user);
    @Query(value = "select u from User as u where u.email = :email")
    User findByUserEmail(String email);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    Boolean findByUsernameAndPassword(String username, String password);



}

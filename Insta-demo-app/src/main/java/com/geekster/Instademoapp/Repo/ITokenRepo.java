package com.geekster.Instademoapp.Repo;

import com.geekster.Instademoapp.Model.Token;
import com.geekster.Instademoapp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITokenRepo extends JpaRepository<Token, Integer> {
    Token findByUser(User existingUser);

    Token findFirstByTokenValue(String token);
}

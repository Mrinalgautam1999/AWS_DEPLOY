package com.geekster.Instademoapp.Service;

import com.geekster.Instademoapp.Model.Token;
import com.geekster.Instademoapp.Repo.ITokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    @Autowired
    ITokenRepo tokenRepo;

    public void createToken(Token token) {
        tokenRepo.save(token);
    }


    public boolean Authentication(String email, String token) {
        Token tokeValue = tokenRepo.findFirstByTokenValue(token);

        if(tokeValue != null){
            return tokeValue.getUser().getUserEmail().equals(email);
        }else{
            return false;
        }
    }

    public void deleteToken(String token) {
        Token token1 = tokenRepo.findFirstByTokenValue(token);
        tokenRepo.delete(token1);
    }
}

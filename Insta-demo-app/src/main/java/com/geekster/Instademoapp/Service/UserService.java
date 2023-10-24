package com.geekster.Instademoapp.Service;

import com.geekster.Instademoapp.Model.Token;
import com.geekster.Instademoapp.Model.User;
import com.geekster.Instademoapp.Repo.ITokenRepo;
import com.geekster.Instademoapp.Repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;


@Service
public class UserService {
    @Autowired
    IUserRepo userRepo;

    @Autowired
    ITokenRepo tokenRepo;

    @Autowired
    TokenService tokenService;

    public String userSignUp(User user) {
        String userEmail = user.getUserEmail();

        User existingUser = userRepo.findFirstByUserEmail(userEmail);
        if(existingUser != null){
            return "Email is Already Registered !!!";
        }

        String password = user.getUserPassword();
        try {
            String userPassword = PasswordEncryptor.encrypt(password);
            user.setUserPassword(userPassword);
            userRepo.save(user);
            return "Insta User Registered!!!";
        }catch (Exception e){
            return "Invalid Credential!!!";
        }
    }

    public String userSignIn(String email, String password) {
        User existingUser = userRepo.findFirstByUserEmail(email);
        if (existingUser == null) {
            return "Email is not Registered";
        }else if(tokenRepo.findByUser(existingUser)!= null){
                return "You Already Sign In";
        }else{
            try {
                String userPassword = PasswordEncryptor.encrypt(password);
                if (existingUser.getUserPassword().equals(userPassword)) {
                    Token token = new Token(existingUser);
                    tokenService.createToken(token);
                    return token.getTokenValue();
                }else{
                    return "Invalid Password";
                }
            } catch (NoSuchAlgorithmException e) {
                return "Server Error";
            }
        }
    }

    public String userSignOut(String email, String token) {
        if(tokenService.Authentication(email,token)){
            tokenService.deleteToken(token);
            return "signOut";
        }else {
            return "SignOut";
        }
    }
}

package com.geekster.Instademoapp.Service;

import com.geekster.Instademoapp.Repo.IAdminRepo;
import com.geekster.Instademoapp.Repo.ITokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    IAdminRepo adminRepo;

}

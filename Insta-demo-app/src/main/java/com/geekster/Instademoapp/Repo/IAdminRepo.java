package com.geekster.Instademoapp.Repo;

import com.geekster.Instademoapp.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminRepo extends JpaRepository<Admin, Integer> {
}

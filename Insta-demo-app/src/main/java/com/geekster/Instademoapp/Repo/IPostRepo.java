package com.geekster.Instademoapp.Repo;

import com.geekster.Instademoapp.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepo extends JpaRepository<Post, Integer> {
}

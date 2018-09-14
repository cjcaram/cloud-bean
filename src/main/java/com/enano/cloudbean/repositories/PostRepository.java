package com.enano.cloudbean.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enano.cloudbean.entities.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
  List<Post> findByCreatorId(long id);
}

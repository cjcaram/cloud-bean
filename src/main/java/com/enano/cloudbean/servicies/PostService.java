package com.enano.cloudbean.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enano.cloudbean.entities.Post;
import com.enano.cloudbean.entities.User;
import com.enano.cloudbean.repositories.PostRepository;

@Service
public class PostService {
  
  @Autowired
  private PostRepository postRepository;

  public List<Post> getAllPosts(){
    return postRepository.findAll();
  }
  
  public void insert(Post post) {
    postRepository.save(post);
  }
  
  public List<Post> getPostsByUser(User user){
    return postRepository.findByCreatorId(user.getId());
  }

  public Post getPostById(Long postId) {
    return postRepository.getOne(postId);
  }
}

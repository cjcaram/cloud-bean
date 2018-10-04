package com.enano.cloudbean.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.enano.cloudbean.dtos.CommentDto;
import com.enano.cloudbean.entities.Comment;
import com.enano.cloudbean.entities.Post;
import com.enano.cloudbean.entities.User;
import com.enano.cloudbean.services.CommentService;
import com.enano.cloudbean.services.PostService;
import com.enano.cloudbean.services.UserService;

@RestController
public class BlogController {
  
  @Autowired
  private PostService postService;
  
  @Autowired
  private UserService userService;
  
  @Autowired
  private CommentService commentService;
  
  @GetMapping(value= "/private")
  public String privateEndPoint(){
    return "PRIVADO";
  }
  
  @GetMapping(value = "/posts")
  public List<Post> getPosts(){
    return postService.getAllPosts();
  }
  
  @GetMapping(value = "/posts/{userName}")
  public List<Post> postsByUserName(@PathVariable String userName){
    return postService.getPostsByUser(userService.getUserByUsername(userName));
  }
  
  @GetMapping(value = "/post-detail/{postId}")
  public Post getSinglePost(@PathVariable Long postId){
    return postService.getPostById(postId);
  }
  
  @PostMapping(value = "/post")
  public String publishPost(@RequestBody Post post) {
    
    post.setCreator(getLoggedUser());
    if(post.getDateCreated() == null) {
      post.setDateCreated(new Date());
    }
    postService.insert(post);
    return "Post was saved";
  }

  @DeleteMapping(value = "/comment/{id}")
  public boolean deleteComment(@PathVariable Long id){
      return commentService.deletePost(id);
  }

  @GetMapping(value = "/comments/{postId}")
  public List<Comment> getComments(@PathVariable Long postId){
      return commentService.getComments(postId);
  }

  @PostMapping(value = "/post/postComment")
  public boolean postComment(@RequestBody CommentDto comment){
      Post post = postService.getPostById(comment.getPostId());
      User creator = getLoggedUser();
      if(post == null || creator == null)
          return false;

      commentService.comment(new Comment(comment.getText(),post,creator));
      return true;
  }
  
  private User getLoggedUser() {
    return userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
  }
  

}

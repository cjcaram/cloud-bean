package com.enano.cloudbean.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enano.cloudbean.entities.Comment;
import com.enano.cloudbean.repositories.CommentRepository;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getComments(Long postId) {
        return commentRepository.findByPostId(postId);
    }

    public void comment(Comment comment) {
        commentRepository.save(comment);
    }

    public boolean deletePost(Long id) {
        commentRepository.deleteById(id);
        return true;
    }
}

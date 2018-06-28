package com.leszeknowinski.bloggyEll.models.services;

import com.leszeknowinski.bloggyEll.models.CommentEntity;
import com.leszeknowinski.bloggyEll.models.PostEntity;
import com.leszeknowinski.bloggyEll.models.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    PostRepository postRepository;


    public void addComment(String author, String comment, int postId){
        PostEntity post = postRepository.findById(postId).get();
        CommentEntity newComment = addNewCommentEntity(author, comment, post);
        post.getComments().add(newComment);
        postRepository.save(post);
    }

    private CommentEntity addNewCommentEntity(String author, String comment, PostEntity postEntity){
        CommentEntity newComment = new CommentEntity();
        newComment.setAuthor(author);
        newComment.setContent(comment);
        newComment.setPost(postEntity);
        return newComment;
    }
}

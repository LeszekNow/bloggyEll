package com.leszeknowinski.bloggyEll.models.services;

import com.leszeknowinski.bloggyEll.models.CommentEntity;
import com.leszeknowinski.bloggyEll.models.PostEntity;
import com.leszeknowinski.bloggyEll.models.repositories.CommentRepository;
import com.leszeknowinski.bloggyEll.models.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;


    public void addComment(String author, String comment, int postId, int authorId){
        PostEntity post = postRepository.findById(postId).get();
        CommentEntity newComment = addNewCommentEntity(author, comment, post, authorId);
        post.getComments().add(newComment);
        postRepository.save(post);
    }

    private CommentEntity addNewCommentEntity(String author, String comment, PostEntity postEntity, int authorId){
        CommentEntity newComment = new CommentEntity();
        newComment.setAuthor(author);
        newComment.setContent(comment);
        newComment.setPost(postEntity);
        newComment.setAuthorId(authorId);
        return newComment;
    }

    public CommentRepository getCommentRepository() {
        return commentRepository;
    }
}

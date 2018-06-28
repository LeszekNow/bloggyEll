package com.leszeknowinski.bloggyEll.models.services;

import com.leszeknowinski.bloggyEll.models.CategoryEntity;
import com.leszeknowinski.bloggyEll.models.PostEntity;
import com.leszeknowinski.bloggyEll.models.forms.PostForm;
import com.leszeknowinski.bloggyEll.models.repositories.CategoryRepository;
import com.leszeknowinski.bloggyEll.models.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    CategoryRepository categoryRepository;
    //@Async it speed up site response, not guarantee do all job before response
    @Transactional // method will do all or nothing
    public void addPost(PostForm postForm, String userIp){
        Optional<CategoryEntity>category = categoryRepository.findById(postForm.getCategory());

        PostEntity newPost = new PostEntity();
        newPost.setCategory(category.orElseThrow(IllegalStateException::new));
        newPost.setAuthor(postForm.getAuthor());
        newPost.setTitle(postForm.getTitle());
        newPost.setArticle(postForm.getArticle());
        newPost.setComments(Collections.emptyList());
        newPost.setUserIp(userIp);
        postRepository.save(newPost);
    }

    public PostRepository getPostRepository(){
        return postRepository;
    }
}

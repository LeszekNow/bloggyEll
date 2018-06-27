package com.leszeknowinski.bloggyEll.models.controllers;

import com.leszeknowinski.bloggyEll.models.PostEntity;
import com.leszeknowinski.bloggyEll.models.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    PostRepository postRepository;

    @GetMapping("/")
    @ResponseBody
    public String index(){
        Optional<PostEntity> postEntity = postRepository.findById(1);
        PostEntity postEntityWithoutOptional = postEntity.get();
        return postEntityWithoutOptional.getTitle() + " " + postEntityWithoutOptional.getComments().toString();
    }
}

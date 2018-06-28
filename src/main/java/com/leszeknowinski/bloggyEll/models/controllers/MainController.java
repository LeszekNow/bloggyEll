package com.leszeknowinski.bloggyEll.models.controllers;

import com.leszeknowinski.bloggyEll.models.forms.PostForm;
import com.leszeknowinski.bloggyEll.models.services.CategoryService;
import com.leszeknowinski.bloggyEll.models.services.CommentService;
import com.leszeknowinski.bloggyEll.models.services.PostService;
import com.leszeknowinski.bloggyEll.models.services.UserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MainController {

    @Autowired
    PostService postService;

    @Autowired
    CommentService commentService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    UserService userService;

    @ModelAttribute
    public void addModel(Model model){
        model.addAttribute("user", userService);
    }

    @GetMapping("/")
    public String index(Model model){
        if(!userService.isLogged()){
            model.addAttribute("info", "Login or Register!");
            return "redirect:/login";
        }
        model.addAttribute("posts", postService.getPostRepository().findAll());
        return "index";
    }

    @GetMapping("/post/{id}")
    public String post(@PathVariable("id") int id, Model model){
        model.addAttribute("post", postService.getPostRepository().findById(id).orElseThrow(IllegalStateException::new));
        return "post";
    }

    @PostMapping("/comment/{postId}")
    public String addComment(@RequestParam("author") String author,
                             @RequestParam("comment") String comment,
                             @PathVariable("postId") int postId){
        commentService.addComment(author, comment, postId);
        return "redirect:/post/" + postId;

    }

    @GetMapping("/add/post")
    public String addPost(Model model){
        model.addAttribute("postFrom", new PostForm());
        model.addAttribute("categories", categoryService.getCategories());
        return "addPost";
    }

    @PostMapping("/add/post")
    public String addPost(@ModelAttribute PostForm postForm, HttpServletRequest httpServletRequest){
        postService.addPost(postForm, httpServletRequest.getRemoteHost());
        return "redirect:/";
    }
}

package com.leszeknowinski.bloggyEll.models.forms;

import lombok.Data;

@Data
public class PostForm {
    private String title;
    private String article;
    private String author;
    private int category;
}



package com.leszeknowinski.bloggyEll.models.services;

import com.leszeknowinski.bloggyEll.models.CategoryEntity;
import com.leszeknowinski.bloggyEll.models.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<CategoryEntity>getCategories(){
       return categoryRepository.findAll();
    }
}

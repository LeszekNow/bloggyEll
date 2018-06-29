package com.leszeknowinski.bloggyEll.models.repositories;

import com.leszeknowinski.bloggyEll.models.PostEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<PostEntity, Integer> {

    List<PostEntity>findByAuthorContains(String s);
    List<PostEntity>findByArticleContains(String s);
    List<PostEntity>findByTitleContains(String s);

}

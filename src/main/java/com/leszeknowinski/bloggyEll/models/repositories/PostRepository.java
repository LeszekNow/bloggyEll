package com.leszeknowinski.bloggyEll.models.repositories;

import com.leszeknowinski.bloggyEll.models.PostEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<PostEntity, Integer> {
}

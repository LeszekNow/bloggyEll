package com.leszeknowinski.bloggyEll.models.repositories;

import com.leszeknowinski.bloggyEll.models.CommentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<CommentEntity, Integer> {

}

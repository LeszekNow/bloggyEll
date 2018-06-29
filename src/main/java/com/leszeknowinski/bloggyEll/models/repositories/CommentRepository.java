package com.leszeknowinski.bloggyEll.models.repositories;

import com.leszeknowinski.bloggyEll.models.CommentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.xml.stream.events.Comment;
import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<CommentEntity, Integer> {
    List<CommentEntity> findByContentContains(String s);
    List<CommentEntity> findByAuthorContains(String s);

}

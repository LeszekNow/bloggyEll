package com.leszeknowinski.bloggyEll.models.repositories;

import com.leszeknowinski.bloggyEll.models.CategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity, Integer> {
}

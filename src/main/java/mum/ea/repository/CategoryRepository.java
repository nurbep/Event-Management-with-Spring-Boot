package mum.ea.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.ea.domain.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer>{

}

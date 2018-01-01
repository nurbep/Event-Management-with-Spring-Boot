package mum.ea.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.ea.domain.Comment;


@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer>{

}
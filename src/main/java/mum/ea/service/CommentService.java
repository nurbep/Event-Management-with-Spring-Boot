package mum.ea.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.ea.domain.Comment;
import mum.ea.repository.CommentRepository;

@Service
@Transactional
public class CommentService {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private CommentRepository commentRepository;
	
	public List<Comment> getAllComments() {
		List<Comment> comments = new ArrayList<>();
		commentRepository.findAll().forEach(comments::add);
		return comments;
	}

	public Comment getComment(int commentId) {
		return commentRepository.findOne(commentId);
	}
	
	public void addComment(Comment comment) {
		commentRepository.save(comment);
	}

	public void updateComment(Comment comment) {
		commentRepository.save(comment);
	}

	public void deleteComment(Comment comment) {
		commentRepository.delete(comment);
	}
	
	public void deleteComment(int commentId) {
		commentRepository.delete(commentId);
	}

}

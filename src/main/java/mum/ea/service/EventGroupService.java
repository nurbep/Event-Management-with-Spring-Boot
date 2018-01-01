package mum.ea.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.ea.domain.EventGroup;
import mum.ea.repository.EventGroupRepository;


@Service
@Transactional
public class EventGroupService {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private EventGroupRepository groupRepository;
	
	public List<EventGroup> getAllGroups() {
		List<EventGroup> groups = new ArrayList<>();
		groupRepository.findAll().forEach(groups::add);
		return groups;
	}

	public EventGroup getGroup(int groupId) {
		return groupRepository.findOne(groupId);
	}
	
	public void addGroup(EventGroup group) {
		groupRepository.save(group);
	}

	public void updateComment(EventGroup group) {
		groupRepository.save(group);
	}

	public void deleteEvent(EventGroup group) {
		groupRepository.delete(group);
	}
	
	public void deleteEvent(int groupId) {
		groupRepository.delete(groupId);
	}

}

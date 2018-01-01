package mum.ea.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.ea.config.GetCurrentUser;
import mum.ea.domain.Comment;
import mum.ea.domain.Event;
import mum.ea.domain.Facility;
import mum.ea.repository.EventRepository;

@Service
@Transactional
public class EventService {

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	GetCurrentUser curUser;

	public List<Event> getAllEvents() {
		List<Event> events = new ArrayList<>();
		eventRepository.findAll().forEach(events::add);
		return events;
	}

	public Event getEvent(int eventId) {
		return eventRepository.findOne(eventId);
	}

	public void addEvent(Event event) {
		eventRepository.save(event);

	}

	public void updateEvent(Event event) {

		event.setEventOrganizer(curUser.loggedUser());
		eventRepository.save(event);

	}

	public void deleteEvent(Event event) {
		eventRepository.delete(event);
	}

	public void deleteEvent(int eventId) {
		eventRepository.delete(eventId);
	}

	public List<Event> searchEvent(String name) {
		return eventRepository.findAllByNameLikeOrderByStartDateDesc(name);
	}

	public List<Event> findAllByFacilityAndDateBetween(Event e) {
		List<Event> lst = eventRepository.findAllByIdNotAndFacilityAndStartDateBetween(e.getId(), e.getFacility(),
				e.getStartDate(), e.getEndDate());
		lst.addAll(eventRepository.findAllByIdNotAndFacilityAndEndDateBetween(e.getId(), e.getFacility(),
				e.getStartDate(), e.getEndDate()));
		return lst;
	}

	@Scheduled(cron = "0 0 0/1 * * ?")
	public void closeEvent() {
		System.out.println("-------------show--------");
		Query query = em.createQuery("Update Event e set e.status=false where e.endDate<CURRENT_TIMESTAMP");
		query.executeUpdate();
	}

	@PersistenceContext
	private EntityManager em;

	public List<Comment> findAll(String name) {
		// TypedQuery query = em.createQuery("select c from Comment c where
		// c.description like '%" +s +"%'",Comment.class);

		TypedQuery query = em.createQuery("select e from Event e where e.name like  '%" + name + "%'", Event.class);
		// query.setParameter("name", "name");
		// query.setFirstResult(1 * 10);
		// query.setMaxResults(10);

		return query.getResultList();
	}

}
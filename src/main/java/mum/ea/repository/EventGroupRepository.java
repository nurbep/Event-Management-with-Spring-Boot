package mum.ea.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.ea.domain.EventGroup;


@Repository
public interface EventGroupRepository extends CrudRepository<EventGroup, Integer>{

}
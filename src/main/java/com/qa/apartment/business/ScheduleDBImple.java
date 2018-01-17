package com.qa.apartment.business;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.qa.apartment.persistance.Schedule;
import com.qa.apartment.util.JSONUtil;

@Transactional(Transactional.TxType.SUPPORTS)
public class ScheduleDBImple {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	private JSONUtil util = new JSONUtil();
	
	@Transactional(Transactional.TxType.REQUIRED)
	public String createScheduleFromString(String schedule) {
		Schedule aSchedule = util.getObjectForJSON(schedule, Schedule.class);
		em.persist(aSchedule);
		return "{\"message\": \"schedule sucessfully added\"}";
	}
	
	@Transactional(Transactional.TxType.REQUIRED)
	public String deleteSchedule(long id) {
		em.remove(em.find(Schedule.class, id));
		return "{\"message\": \"schedule sucessfully removed\"}";
	}
	
	@Transactional(Transactional.TxType.REQUIRED)
	public String updateSchedule(String schedule)
	{
		Schedule aSchedule = util.getObjectForJSON(schedule, Schedule.class);
		em.merge(aSchedule);
		return "{\"message\": \"schedule sucessfully updated\"}";
	}
	
	public Schedule findSchedule(Long id)
	{
		return em.find(Schedule.class, id);
	}
	
	public List<Schedule> findAllSchedules()
	{
		TypedQuery<Schedule> query = em.createQuery("SELECT m FROM Schedule m", Schedule.class);
        return query.getResultList();
	}
}


package com.qa.apartment.business;

import static javax.transaction.Transactional.TxType.REQUIRED;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.qa.apartment.persistance.Schedule;
import com.qa.apartment.util.JSONUtil;

@ApplicationScoped
@Alternative
public class ScheduleImple implements ScheduleService  {
	
private Map<Long, Schedule> scheduleList;
	
	@Inject
	private JSONUtil util;
	
	public ScheduleImple()
	{
		scheduleList = new HashMap<Long, Schedule>();
	}
	

	@Transactional(REQUIRED)
	public String createScheduleFromString(String schedule)
	{
		Schedule aSchedule = util.getObjectForJSON(schedule, Schedule.class);
		scheduleList.put((long) aSchedule.getId(), aSchedule);
		return "{\"message\": \"schedule map sucessfully added\"}";
	}
	
	@Transactional(REQUIRED)
	public String updateSchedule(String schedule) {
		Schedule updatedSchedule = util.getObjectForJSON(schedule, Schedule.class);
		scheduleList.replace((long) updatedSchedule.getId(), updatedSchedule);
		return "{\"message\": \"schedule sucessfully updated\"}";
	}
	
	@Transactional(REQUIRED)
	public String deleteSchedule(long id) {
		scheduleList.remove(id);
		return "{\"message\": \"schedule sucessfully deleted\"}";
	}
	
	public String findAllSchedules()
	{
	      return util.getJSONForObject(scheduleList);
	}


	@Override
	public String findSchedule(long id) {
			return util.getJSONForObject(scheduleList.get(id));
	}
}

package com.qa.apartment.business;

public interface ScheduleService {
		
		String findSchedule(long id);

		String findAllSchedules();

		String createScheduleFromString(String schedule);

		String deleteSchedule(long id);

		String updateSchedule(String schedule);
}
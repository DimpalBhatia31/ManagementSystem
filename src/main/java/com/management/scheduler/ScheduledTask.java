package com.management.scheduler;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.management.service.EmployeService;

@Component
public class ScheduledTask {

	private static final Log LOGGER = LogFactory.getLog(ScheduledTask.class);

	@Autowired
	EmployeService personService;

	@Scheduled(cron = "0 0 11 * * ?")
	public void readAndSaveData() {
		try {
			int count = personService.readAndFetchData();
			LOGGER.info("Data has been dumped successfully, nb_objects = " + count);
		} catch (Exception e) {
			LOGGER.error("Unable to save data in db = " + e);
		}
	}

}

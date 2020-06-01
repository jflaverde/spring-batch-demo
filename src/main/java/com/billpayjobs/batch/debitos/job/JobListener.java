package com.billpayjobs.batch.debitos.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobListener extends JobExecutionListenerSupport{

	private static final Logger LOG = LoggerFactory.getLogger(JobListener.class);
	
	@Autowired
	public JobListener() {
		super();
	}
	
	public void afterJob(JobExecution jobExecution) {
		if(jobExecution.getStatus()==BatchStatus.COMPLETED) {
			LOG.info("Finalizó el JOB!! verificar los resultados");
		}
	}
}

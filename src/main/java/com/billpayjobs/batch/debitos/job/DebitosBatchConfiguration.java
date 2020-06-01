package com.billpayjobs.batch.debitos.job;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.billpayjobs.batch.debitos.job.processor.MatriculaItemProcessor;

@Configuration
@EnableBatchProcessing
public class DebitosBatchConfiguration {
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private Step1 step1;
	
	@Autowired
	private Step2 step2;
	
	@Bean
	public MatriculaItemProcessor processor() {
		return new MatriculaItemProcessor();
	}
	
	@Bean
	public Job readMatriculaJob(JobListener listener) {
		return jobBuilderFactory.get("ObtenerMatriculas")
				.listener(listener)
				.start(step1.step1())
				.next(step2.step2())
				.incrementer(new RunIdIncrementer())
				.build();
	}

	
}

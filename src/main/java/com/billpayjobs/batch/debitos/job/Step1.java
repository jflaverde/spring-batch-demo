package com.billpayjobs.batch.debitos.job;

import java.util.LinkedList;
import java.util.List;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.billpayjobs.batch.debitos.job.client.MatriculaApiClient;
import com.billpayjobs.batch.debitos.job.entities.Matricula;

@Configuration
public class Step1 {

	
	@Autowired
	private StepBuilderFactory StepBuilderFactory;
	
	
	@Autowired
	private MatriculaApiClient matriculaClient;
	
	public ListItemReader<Matricula> reader(){
		List<Matricula> matriculas = new LinkedList<>();
		matriculas=matriculaClient.findAll();
		return new ListItemReader<>(matriculas);
	}
	
	public ItemWriter<Matricula> writer(){
		return items ->{
			for(Matricula item: items) {
				System.out.println("matricula " + item);
			}
		};
	}
	
	
	public Step step1() {
		return this.StepBuilderFactory.get("step1")
				.<Matricula,Matricula>chunk(1)
				.reader(reader())
				.writer(writer())
				.listener(new StepExecutionListenerSupport() {
					@Override
					public ExitStatus afterStep(StepExecution stepExecution) {
						stepExecution.getJobExecution().getExecutionContext()
						.putInt("conteo matriculas", stepExecution.getReadCount());
						return super.afterStep(stepExecution);
					}
				})
				.build();
	}
}

package com.billpayjobs.batch.debitos.job;

import java.util.LinkedList;
import java.util.List;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.billpayjobs.batch.debitos.job.entities.Matricula;

@Configuration
public class Step2 {

	
	@Autowired
	private StepBuilderFactory StepBuilderFactory;
	
	public ListItemReader<Matricula> reader(){
		List<Matricula> matriculas = new LinkedList<>();
		return new ListItemReader<>(matriculas);
	}
	
	public ItemWriter<Matricula> writer(){
		return items ->{
			for(Matricula item: items) {
				System.out.println("matricula " + item);
			}
		};
	}
	
	public Step step2() {
		return this.StepBuilderFactory.get("step2")
				.tasklet((stepContribution, chunkContext) -> {
						int readCount = chunkContext.getStepContext().getStepExecution()
						.getJobExecution().getExecutionContext()
						.getInt("conteo matriculas");
						
						System.out.println("conteo matriculas " + readCount);
						return RepeatStatus.FINISHED;
				})
				.build();
	}
}

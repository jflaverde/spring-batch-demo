package com.billpayjobs.batch.debitos.job.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.billpayjobs.batch.debitos.job.entities.Matricula;

@FeignClient(name="matriculas", url="http://localhost:8080")
public interface MatriculaApiClient {
	
	@GetMapping("/v1/matriculas/")
	public List<Matricula> findAll();

}

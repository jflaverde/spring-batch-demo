package com.billpayjobs.batch.debitos.job.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Matricula {

	@Id
	@GeneratedValue
	private int id;
	
	private boolean activo;
	
	@Enumerated(EnumType.STRING)
	private tipoMatriculaEnum tipo;
}

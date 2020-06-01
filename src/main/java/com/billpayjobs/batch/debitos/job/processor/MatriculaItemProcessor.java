package com.billpayjobs.batch.debitos.job.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.billpayjobs.batch.debitos.job.entities.Matricula;
import com.billpayjobs.batch.debitos.job.entities.tipoMatriculaEnum;

public class MatriculaItemProcessor implements ItemProcessor<Matricula,Matricula> {

	private static final Logger LOG = LoggerFactory.getLogger(MatriculaItemProcessor.class);
	
	@Override
	public Matricula process(Matricula item) throws Exception {
		if(item.getTipo()== tipoMatriculaEnum.DOMICILIACION) {
			return item;
		}
		return null;
	}

}

package com.dell.emc.service;

import java.util.List;

import javax.validation.Valid;

import com.dell.emc.exception.ResourceNotFoundException;
import com.dell.emc.model.Sample;

public interface SampleService {


	Sample getSampleByid(Long emcId) throws ResourceNotFoundException;

	Sample createSample(@Valid Sample emc);

	void deleteSample(Sample emc);

	List<Sample> findAll();

}
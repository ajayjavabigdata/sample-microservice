package com.dell.emc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dell.emc.exception.ResourceNotFoundException;
import com.dell.emc.model.Sample;
import com.dell.emc.repository.SampleRepository;



@Service
public class SampleServiceImpl implements SampleService {
	

	@Autowired
	private SampleRepository emcRepository;
	
	public List<Sample> findAll() {
		return emcRepository.findAll();
	}
	
	
	public Sample getSampleByid(Long emcId) throws ResourceNotFoundException {
		return emcRepository
        .findById(emcId)
        .orElseThrow(() -> new ResourceNotFoundException("Sample not found on :: " + emcId));
	}
	
	public Sample createSample(Sample emc) {
		 return emcRepository.save(emc);
	}
	
	public void deleteSample(Sample emc) {
		 emcRepository.delete(emc);
	}

	

}

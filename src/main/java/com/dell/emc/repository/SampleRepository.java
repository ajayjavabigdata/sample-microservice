package com.dell.emc.repository;

import com.dell.emc.model.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SampleRepository extends JpaRepository<Sample, Long> {}

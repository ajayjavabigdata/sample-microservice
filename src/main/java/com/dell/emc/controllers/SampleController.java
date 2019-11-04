package com.dell.emc.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.dell.emc.exception.ResourceNotFoundException;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.dell.emc.model.Sample;
import com.dell.emc.service.SampleService;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1")
public class SampleController {

  @Autowired
  private SampleService emcService;
  /**
   * Get all emcs list.
   *
   * @return the list
   */
  @GetMapping("/emcs")
  public List<Sample> getAllSamples() {
    return emcService.findAll();
  }

  /**
   * Gets emcs by id.
   *
   * @param emcId the emc id
   * @return the emcs by id
   * @throws ResourceNotFoundException the resource not found exception
   */
  @GetMapping("/emcs/{id}")
  public ResponseEntity<Sample> getSamplesById(@PathVariable(value = "id") Long emcId)
      throws ResourceNotFoundException {
        Sample emc = emcService.getSampleByid(emcId);
    return ResponseEntity.ok().body(emc);
  }

  /**
   * Create emc emc.
   *
   * @param emc the emc
   * @return the emc
   */
  @PostMapping("/emcs")
  public Sample createSample(@Valid @RequestBody Sample emc) {
    return emcService.createSample(emc);
  }

  /**
   * Update emc response entity.
   *
   * @param emcId the emc id
   * @param emcDetails the emc details
   * @return the response entity
   * @throws ResourceNotFoundException the resource not found exception
   */
  @PutMapping("/emcs/{id}")
  public ResponseEntity<Sample> updateSample(
      @PathVariable(value = "id") Long emcId, @Valid @RequestBody Sample emcDetails)
      throws ResourceNotFoundException {

    Sample emc = emcService.getSampleByid(emcId);
    emc.setEmail(emcDetails.getEmail());
    emc.setLastName(emcDetails.getLastName());
    emc.setFirstName(emcDetails.getFirstName());
    final Sample updatedSample = emcService.createSample(emc);
    return ResponseEntity.ok(updatedSample);
  }

  /**
   * Delete emc map.
   *
   * @param emcId the emc id
   * @return the map
   * @throws Exception the exception
   */
  @DeleteMapping("/emcs/{id}")
  public Map<String, Boolean> deleteSample(@PathVariable(value = "id") Long emcId) throws Exception {
    Sample emc = emcService.getSampleByid(emcId);
    emcService.deleteSample(emc);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }
 

}

package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Job;
import com.example.demo.service.JobService;

@RestController
@RequestMapping("/job")
public class JobController<job> {

	@Autowired
	private JobService jobService;
	
	//Add New records
	@PostMapping("/")
	public String CreateJob(@RequestBody Job job) {
		jobService.createJob(job);
		return "Job Created";
	}
	
	//get all records
	@GetMapping("/all")
	public List<Job> GetAllJobs(){
		return jobService.getAllJobs();
	}
	
	//Get record by id
	@GetMapping("/{id}")
	public Optional<Job> GetbyId(@PathVariable int id) {
		return jobService.getJobById(id);
	}
	
	//Update record by id
	@PutMapping("/{id}")
	public Optional<Job> UpdatejobRecord(@PathVariable int id,@RequestBody Job job) {
		return jobService.updateJob(id, job);
	}
	
	//delete by id
	@DeleteMapping("/{id}")
	public String DeleteByid(@PathVariable int id) {
		return jobService.deleteJob(id);
	}
	
	// Add new Records in List
	@PostMapping("/add")
	public ResponseEntity<String> AddlistofJobs(@RequestBody List<Job> job) {
		String result=jobService.saveAll(job);
		if("Job list cannot be empty".equals(result)) {
			return ResponseEntity.badRequest().body(result);
		}else {
			return ResponseEntity.ok(result);
		}
		
		
	}
}

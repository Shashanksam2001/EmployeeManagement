package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Job;
import com.example.demo.service.JobService;

@Controller

public class JobController<job> {

	@Autowired
	private JobService jobService;

	@PostMapping("/")
	public String CreateJob(@RequestBody Job job) {
		jobService.createJob(job);
		return "Job Created";
	}
	@GetMapping("/All")
	public List<Job> GetAllJobs(){
		return jobService.getAllJobs();
		
	}
	@GetMapping("/{id}")
	public Optional<Job> GetbyId(@PathVariable int id) {
		return jobService.getJobById(id);
	}
	@PutMapping("/{id}")
	public Optional<Job> UpdatejobRecord(@PathVariable int id,@RequestBody Job job) {
		return jobService.updateJob(id, job);
	}
	@DeleteMapping("/{id}")
	public String DeleteByid(@PathVariable int id) {
		return jobService.deleteJob(id);
	}
}

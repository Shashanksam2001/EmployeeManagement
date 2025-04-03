package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Job;

public interface JobService {
		Job createJob(Job job);
		String saveAll(List<Job> job);
	    List<Job> getAllJobs();
	    Optional<Job> getJobById(int id);
	    Optional<Job> updateJob(int id, Job job);
	    String deleteJob(int id);

}

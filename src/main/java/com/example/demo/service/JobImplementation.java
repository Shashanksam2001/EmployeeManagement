package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Job;
import com.example.demo.repository.JobRepo;
@Service

public class JobImplementation implements JobService {
	@Autowired
	private JobRepo jobRepo;

	@Override
	public Job createJob(Job job) {
		return jobRepo.save(job);
	}

	@Override
	public List<Job> getAllJobs() {
		return jobRepo.findAll();
	}

	@Override
	public Optional<Job> getJobById(int id) {
		Optional<Job> byid=jobRepo.findById(id);
		return byid;
	}

	@Override
	public Optional<Job> updateJob(int id, Job job) {
		return jobRepo.findById(id).map(existingJob -> {
	        existingJob.setTitle(job.getTitle());
	        existingJob.setDescription(job.getDescription());
	        existingJob.setMinSalary(job.getMinSalary());
	        existingJob.setMaxSalary(job.getMaxSalary());
	        return jobRepo.save(existingJob); // Save and return updated job
	    });
	}

	@Override
	public String deleteJob(int id) {
		if(jobRepo.findById(id).isPresent()) {
			jobRepo.deleteById(id);
			return "Deleted";
		}else {
			return "Id not present";
		}
	}

	@Override
	public String saveAll(List<Job> jobs) {
		try {
            if (jobs == null || jobs.isEmpty()) {
                return "Job list cannot be empty";
            }
            jobRepo.saveAll(jobs);
            return "Jobs added successfully";
        } catch (Exception e) {
            throw new RuntimeException("Error saving jobs: " + e.getMessage());
        }
		
	}

}

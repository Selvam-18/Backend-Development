package com.example.JobApp.service;

import com.example.JobApp.model.JobPost;
import com.example.JobApp.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public void addJob(JobPost jobPost) {
        repo.addJob(jobPost);
    }

    public List<JobPost> getAllJobs() {
        return repo.getAllJobs();
    }

    public JobPost getJob(int postId) {
        return repo.getJob(postId);
    }

    public void updateJob(JobPost updatedJob) {
        repo.updatedJob(updatedJob);
    }

    public void deleteJob(int postId) {
        repo.deleteJob(postId);
    }
}

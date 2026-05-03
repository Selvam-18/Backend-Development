package com.example.JobApp;


import com.example.JobApp.model.JobPost;
import com.example.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping("posts")
    public List<JobPost> getAllJobs() {
        return service.getAllJobs();
    }

    @GetMapping("posts/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId) {
        return service.getJob(postId);
    }

    @PostMapping("jobpost")
    public JobPost addJob(@RequestBody JobPost newJobPost) {
        service.addJob(newJobPost);
        return service.getJob(newJobPost.getPostId());
    }

    @PutMapping("jobpost")
    public JobPost updateJob(@RequestBody JobPost updatedJob) {
        service.updateJob(updatedJob);
        return service.getJob(updatedJob.getPostId());
    }

    @DeleteMapping("jobpost/{postId}")
    public String deleteJob(@PathVariable("postId") int postId) {
        service.deleteJob(postId);

        return "Post Deleted";
    }

    @GetMapping("load")
    public String load() {
        service.load();
        return "Load success";
    }

    @GetMapping("jobposts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword) {
        return service.searchKeyword(keyword);
    }
}

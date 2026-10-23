package com.example.SpringBootREST.Service;

import com.example.SpringBootREST.Model.JobPost;
import com.example.SpringBootREST.Repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JobService {

    @Autowired
    private JobRepo repo ;

    @Autowired
    private  Data data;


    public void addJob(JobPost job){
        repo.save(job);

    }

    public List<JobPost> getAllJobs(){
        return repo.findAll();
    }


    public JobPost getJob(int id) {
        return repo.findById(id).orElse(new JobPost());
    }

    public void updateJob(JobPost job) {
        repo.save(job);
    }

    public void deleteJob(int id) {
        repo.deleteById(id);
    }


    public void load() {
        repo.saveAll(data.getJobs());

    }

    public List<JobPost> searchBykeyword(String key) {
        return repo.findByPostProfileContainingOrPostDescContaining(key,key);
    }
}
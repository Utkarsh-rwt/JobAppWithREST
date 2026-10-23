package com.example.SpringBootREST;

import com.example.SpringBootREST.Model.JobPost;
import com.example.SpringBootREST.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// for returning xml too add jackson xml
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobController {

    @Autowired
    private JobService service ;

    @GetMapping("/jobPosts")
//    @GetMapping(path = "/jobPosts", produces = "application/json") this willl only return json not xml
     List<JobPost> getjobs(){
        return service.getAllJobs();
    }

    @GetMapping("/jobPost/{postID}")
    JobPost getjob(@PathVariable("postID") int id  ){
        return service.getJob(id);
    }


    @PostMapping("/jobPost")
//    @PostMapping(path = "/jobPost", consumes =  "application/xml") this will only acccept xml
    public  void addJob(@RequestBody  JobPost job){
        service.addJob(job);

    }

    @PutMapping("/jobPost")
    public JobPost updateJob(@RequestBody JobPost job){
        service.updateJob(job);
        return service.getJob(job.getPostID());
    }

    @DeleteMapping("/jobPost/{postID}")
    public void deleteJob(@PathVariable("postID") int id){
        service.deleteJob(id);
    }

    @GetMapping("/jobPosts/search/{keyword}")
    public List<JobPost> searchBykeyword(@PathVariable("keyword") String key){
        return service.searchBykeyword(key);
    }

    @GetMapping("/load")
    public String load (){
        service.load();
        return "succes";
    }

}

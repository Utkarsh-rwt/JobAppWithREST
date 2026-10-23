package com.example.SpringBootREST.Repository;

import com.example.SpringBootREST.Model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer> {


    List<JobPost> findByPostProfileContainingOrPostDescContaining(String key, String key1);


}
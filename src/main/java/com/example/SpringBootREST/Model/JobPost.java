package com.example.SpringBootREST.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
@Scope("prototype")
public class JobPost{

    @Id
    private  int postID;
    private  String postProfile;
    private String postDesc;
    private int reqExperience;
    private List<String> postTechStack;
}
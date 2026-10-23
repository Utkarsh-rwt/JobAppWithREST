package com.example.SpringBootREST.Service;

import com.example.SpringBootREST.Model.JobPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Data {


    private List<JobPost> jobs = List.of(
            new JobPost(1, "Java Developer",
                    "Develop backend applications using Java and Spring Boot", 2,
                    List.of("Java", "Spring Boot", "PostgreSQL")),

            new JobPost(2, "Frontend Developer",
                    "Build responsive user interfaces for web applications", 1,
                    List.of("HTML", "CSS", "JavaScript", "React")),

            new JobPost(3, "Backend Developer",
                    "Design REST APIs and scalable backend services", 3,
                    List.of("Node.js", "Express.js", "MongoDB")),

            new JobPost(4, "Full Stack Developer",
                    "Develop and maintain full stack web applications", 2,
                    List.of("React", "Java", "Spring Boot", "MySQL")),

            new JobPost(5, "DevOps Engineer",
                    "Manage CI/CD pipelines and cloud infrastructure", 3,
                    List.of("Docker", "Kubernetes", "AWS", "Jenkins")),

            new JobPost(6, "Data Analyst",
                    "Analyze datasets and create business reports", 1,
                    List.of("SQL", "Excel", "Power BI", "Python")),

            new JobPost(7, "Machine Learning Engineer",
                    "Build and deploy machine learning models", 2,
                    List.of("Python", "TensorFlow", "Scikit-learn", "Pandas")),

            new JobPost(8, "Android Developer",
                    "Develop and maintain Android mobile applications", 2,
                    List.of("Java", "Kotlin", "Android SDK")),

            new JobPost(9, "Go Developer",
                    "Build high-performance backend services and APIs", 1,
                    List.of("Go", "Gin", "PostgreSQL", "Docker")),

            new JobPost(10, "Software Engineer",
                    "Design, implement, and test software solutions", 0,
                    List.of("C++", "Data Structures", "Algorithms", "Git")),

            new JobPost(11, "Python Developer",
                    "Develop Python applications and backend services", 1,
                    List.of("Python", "FastAPI", "PostgreSQL", "Docker")),

            new JobPost(12, "Spring Boot Developer",
                    "Build enterprise applications using Spring Boot", 2,
                    List.of("Java", "Spring Boot", "Hibernate", "PostgreSQL")),

            new JobPost(13, "React Developer",
                    "Create interactive and reusable frontend components", 1,
                    List.of("React", "JavaScript", "TypeScript", "CSS")),

            new JobPost(14, "Cloud Engineer",
                    "Design and maintain scalable cloud infrastructure", 3,
                    List.of("AWS", "Terraform", "Docker", "Linux")),

            new JobPost(15, "Database Administrator",
                    "Maintain database performance, security, and backups", 3,
                    List.of("PostgreSQL", "MySQL", "SQL", "Linux")),

            new JobPost(16, "Cybersecurity Engineer",
                    "Identify vulnerabilities and secure software systems", 2,
                    List.of("Linux", "Networking", "Python", "Wireshark")),

            new JobPost(17, "iOS Developer",
                    "Develop mobile applications for Apple devices", 2,
                    List.of("Swift", "SwiftUI", "Xcode")),

            new JobPost(18, "UI/UX Designer",
                    "Design intuitive user experiences and interfaces", 1,
                    List.of("Figma", "Prototyping", "Wireframing", "UI Design")),

            new JobPost(19, "QA Engineer",
                    "Test software applications and identify defects", 1,
                    List.of("Java", "Selenium", "JUnit", "Postman")),

            new JobPost(20, "Automation Test Engineer",
                    "Develop automated test suites for software products", 2,
                    List.of("Java", "Selenium", "TestNG", "Jenkins")),

            new JobPost(21, "C++ Developer",
                    "Develop efficient and high-performance applications", 2,
                    List.of("C++", "STL", "Data Structures", "Algorithms")),

            new JobPost(22, "System Engineer",
                    "Maintain operating systems and troubleshoot infrastructure", 1,
                    List.of("Linux", "Bash", "Networking", "Docker")),

            new JobPost(23, "Blockchain Developer",
                    "Build decentralized applications and smart contracts", 2,
                    List.of("Solidity", "Ethereum", "JavaScript", "Web3.js")),

            new JobPost(24, "Data Engineer",
                    "Build data pipelines and manage large-scale data systems", 2,
                    List.of("Python", "SQL", "Apache Spark", "Airflow")),

            new JobPost(25, "AI Engineer",
                    "Develop AI-powered applications and intelligent systems", 2,
                    List.of("Python", "PyTorch", "Transformers", "FastAPI")),

            new JobPost(26, "Site Reliability Engineer",
                    "Improve system reliability, monitoring, and availability", 3,
                    List.of("Linux", "Kubernetes", "Prometheus", "Grafana")),

            new JobPost(27, "Network Engineer",
                    "Configure, monitor, and troubleshoot computer networks", 2,
                    List.of("TCP/IP", "Routing", "Switching", "Linux")),

            new JobPost(28, "Technical Support Engineer",
                    "Resolve technical issues and support software users", 0,
                    List.of("Linux", "Networking", "SQL", "Troubleshooting")),

            new JobPost(29, "PHP Developer",
                    "Develop dynamic web applications and backend services", 1,
                    List.of("PHP", "Laravel", "MySQL", "REST APIs")),

            new JobPost(30, "Ruby on Rails Developer",
                    "Build web applications using Ruby on Rails", 2,
                    List.of("Ruby", "Rails", "PostgreSQL", "Redis")),

            new JobPost(31, "Embedded Systems Engineer",
                    "Develop firmware and software for embedded devices", 2,
                    List.of("C", "C++", "Microcontrollers", "RTOS")),

            new JobPost(32, "Game Developer",
                    "Develop interactive games and gameplay systems", 2,
                    List.of("C++", "Unity", "C#", "Game Physics")),

            new JobPost(33, "Firmware Engineer",
                    "Write and optimize low-level firmware for hardware devices", 1,
                    List.of("C", "C++", "Embedded Linux", "Microcontrollers")),

            new JobPost(34, "Angular Developer",
                    "Build scalable single-page applications using Angular", 2,
                    List.of("Angular", "TypeScript", "RxJS", "HTML", "CSS")),

            new JobPost(35, "Next.js Developer",
                    "Develop server-rendered and full stack web applications", 1,
                    List.of("Next.js", "React", "TypeScript", "Node.js")),

            new JobPost(36, "Microservices Engineer",
                    "Design distributed applications using microservices", 3,
                    List.of("Java", "Spring Boot", "Kafka", "Docker")),

            new JobPost(37, "API Developer",
                    "Design and implement secure and scalable APIs", 1,
                    List.of("Java", "Spring Boot", "REST", "PostgreSQL")),

            new JobPost(38, "Network Security Engineer",
                    "Implement network security policies and monitoring systems", 3,
                    List.of("Firewalls", "TCP/IP", "Linux", "Wireshark")),

            new JobPost(39, "Technical Lead",
                    "Lead development teams and oversee software architecture", 5,
                    List.of("Java", "System Design", "Microservices", "AWS")),

            new JobPost(40, "Graduate Software Engineer",
                    "Assist in developing, debugging, and testing software applications", 0,
                    List.of("Java", "SQL", "Git", "Data Structures"))
    );

    @Autowired
    public  List<JobPost> getJobs() {
        return jobs;
    }
}

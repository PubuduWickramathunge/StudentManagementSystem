package com.pwick.SpringCourse.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
          Student pubudu =  new Student("pubudu", "pwick@asd.com", LocalDate.of(2000, Month.JANUARY, 01 ));
          Student oshada =  new Student("oshada", "osh@asd.com", LocalDate.of(1000, Month.MAY, 05 ));
          Student kasun =  new Student("Kasun", "kas@asd.com", LocalDate.of(1666, Month.DECEMBER, 21 ));

            List<Student> students = Stream.of(pubudu, oshada, kasun)
                    .collect(Collectors.toList());
            studentRepository.saveAll(students);
        };
    }
}

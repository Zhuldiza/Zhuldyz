package com.example.demo.reposotories;

import com.example.demo.models.Stud;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface StudRepository extends CrudRepository<Stud,Long> {
      Optional<Stud> findById(Long id);
}

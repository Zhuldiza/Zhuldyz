package com.example.demo.reposotories;

import com.example.demo.models.Mugalim;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MugalimRepository extends CrudRepository<Mugalim, Long> {
    Optional<Mugalim> findById(Long id);}
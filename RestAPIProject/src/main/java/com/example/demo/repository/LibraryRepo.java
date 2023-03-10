package com.example.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Library;

//Interface extending the JPARepository Interface
public interface LibraryRepo extends JpaRepository<Library, Integer> {

}

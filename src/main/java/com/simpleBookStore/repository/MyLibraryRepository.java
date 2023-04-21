package com.simpleBookStore.repository;

import com.simpleBookStore.entity.MyLibraryList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyLibraryRepository extends JpaRepository<MyLibraryList, Integer> {

}

package com.simpleBookStore.service;

import com.simpleBookStore.entity.MyLibraryList;
import com.simpleBookStore.repository.MyLibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyLibraryService {

    @Autowired
    private MyLibraryRepository myLibraryRepository;

    //NOTE: This is one is different so changing the variable might be necessary
    public void saveMyBooks(MyLibraryList myLibraryList) {
        myLibraryRepository.save(myLibraryList);
    }

    public List<MyLibraryList> getAllBooks() {
        return myLibraryRepository.findAll();
    }

    public void deleteById(int id) {
        myLibraryRepository.deleteById(id);
    }
}

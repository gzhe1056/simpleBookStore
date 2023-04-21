package com.simpleBookStore.service;

import com.simpleBookStore.entity.BookStore;
import com.simpleBookStore.repository.BookStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookStoreService {

    @Autowired
    private BookStoreRepository bookStoreRepository;

    public void save(BookStore bookStore) {
        bookStoreRepository.save(bookStore);
    }

    public List<BookStore> allBooks() {
        return bookStoreRepository.findAll();
    }

    public BookStore getBookById(int id) {
        return bookStoreRepository.findById(id).get();
    }

    public void deleteById(int id) {
        bookStoreRepository.deleteById(id);
    }
}

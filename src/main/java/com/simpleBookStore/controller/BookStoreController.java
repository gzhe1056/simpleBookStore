package com.simpleBookStore.controller;

import com.simpleBookStore.entity.BookStore;
import com.simpleBookStore.entity.MyLibraryList;
import com.simpleBookStore.service.BookStoreService;
import com.simpleBookStore.service.MyLibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookStoreController {

    @Autowired
    private BookStoreService bookStoreService;

    @Autowired
    private MyLibraryService myLibraryService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/book_checkout")
    public String bookRegister() {
        return "bookCheckout";
    }

    @GetMapping("/books")
    private ModelAndView allBooks() {
        List<BookStore> list = bookStoreService.allBooks();
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("bookList");
//        modelAndView.addObject("book", list);
        return new ModelAndView("bookList", "book", list);
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute BookStore bookStore) {
        bookStoreService.save(bookStore);
        return "redirect:/books";
    }

    @GetMapping("/my_library")
    public String getMyLibrary(Model model) {
        List<MyLibraryList> list = myLibraryService.getAllBooks();
        model.addAttribute("book", list);
        return "myLibrary";
    }

    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id) {
        BookStore bookStore = bookStoreService.getBookById(id);
        MyLibraryList ml = new MyLibraryList(bookStore.getId(), bookStore.getName(), bookStore.getAuthor(), bookStore.getPrice());
        myLibraryService.saveMyBooks(ml);
        return "redirect:/my_library";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id, Model model) {
        BookStore bookStore = bookStoreService.getBookById(id);
        model.addAttribute("book", bookStore);
        return "bookEdit";
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        bookStoreService.deleteById(id);
        return "redirect:/books";
    }
}

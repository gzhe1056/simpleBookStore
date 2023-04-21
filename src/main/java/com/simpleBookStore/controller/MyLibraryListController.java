package com.simpleBookStore.controller;

import com.simpleBookStore.service.MyLibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyLibraryListController {

    @Autowired
    private MyLibraryService myLibraryService;

    @RequestMapping("/deleteMyList/{id}")
    public String deleteMyList(@PathVariable("id") int id) {
        myLibraryService.deleteById(id);
        return "redirect:/my_library";
    }
}

package com.verinon.lbm.controller;




import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.verinon.lbm.jpa.BookRepository;
import com.verinon.lbm.jpa.Singleton;
import com.verinon.lbm.jpa.SmartBookSystemRepository;
import com.verinon.lbm.pojos.Book;
import com.verinon.lbm.pojos.BookFactory;
import com.verinon.lbm.pojos.SmartBookSystem;
import com.verinon.lbm.services.BookServices;
import com.verinon.lbm.services.SmartServices;


@Controller
public class BookController
{
    @Autowired
    BookServices services;

    @Autowired
    SmartServices smartservices = Singleton.getInstance();

    @Autowired
    BookRepository bookRepository;
    
    @Autowired
    SmartBookSystemRepository sbRepository;
    
    BookFactory bookfactory = new BookFactory();

    @RequestMapping("/show-listof-all-books")
    public String showListOfBooks(ModelMap model)
    {

    	model.addAttribute("listBooks", services.getAllBooks());
        return "showallbooks";
    }

    @RequestMapping("/add-book")
    public String addBooksShowPage(ModelMap model)
    {
    	Book book = bookfactory.getBook("BOOK");
        model.addAttribute("book", book);
        return "addbook";
    }

    @PostMapping("/add-book")
    public String addBooks(@ModelAttribute("book")Book book)
    {

        services.saveBook(book);
        return "redirect:show-listof-all-books";
    }

    @RequestMapping("/delete-book")
    public String deleteBookFromList(int id)
    {
        services.deleteBookById(id);
        return "redirect:show-listof-all-books";
    }

    @PostMapping("/edit-book")
    public String editBookDetails(int id,Book book)
    {
 
        if(bookRepository.existsById(id))
        {
            services.editBook(id,book);

        }
        return "redirect:show-listof-all-books";
    }

    @GetMapping("/edit-book")
    public String editBookDetailsShowPage(ModelMap model)
    {
    	Book book = bookfactory.getBook("BOOK");
        model.addAttribute("book", book);
        return "edit";
    }

    @GetMapping("/get-book-details")
    public String getBookDetailsShowPage(ModelMap model)
    {
        model.put("searchbook", services.getAllBooks());
        //model.put("searchbook", bookRepository.findAll());
        return "bookdetails";
    }

    @GetMapping("/sml-main")
    public String forBookBorrow(ModelMap model)
    {

    	model.put("bookslist", services.getAllBooks());
    	SmartBookSystem smartBookSystem = new SmartBookSystem();
        model.addAttribute("smartBookSystem", smartBookSystem);
        return "smartbooksystem";
    }
    
    @PostMapping("/sml-main")
    public String addEntries(@ModelAttribute("smartBookSystem")SmartBookSystem smartBookSystem)
    {
    	smartBookSystem.setDateOfBorrow(new Date());
        smartservices.saveEntry(smartBookSystem);
        return "redirect:show-borrow-list";
    }

    @GetMapping("/del-smartbs")
    public String whenDeleteBook(int id)
    {

        smartservices.deleteEntryById(id);
        return "redirect:show-borrow-list";
    }

    @RequestMapping("/set-returndate")
    public String setReturnDate(int id,SmartBookSystem smartBookSystem)
    {
        
        if(sbRepository.existsById(id))
        {
            smartservices.returnBook(id,smartBookSystem);

        }
        return "redirect:show-borrow-list";
    }

    @GetMapping("/show-borrow-list")
    public String showBorrowBookPage(ModelMap model)
    {
    	model.addAttribute("listEntries", smartservices.getAllEntries());
        return "SmartShowBorrow";
    }

}

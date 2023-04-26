package com.verinon.lbm.pojos;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;


import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book
{
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    int book_id;
    
    @Column(name = "name")
    String book_name;
    
    @Column(name = "author")
    String book_authors;
 
    
    

    public Book(int book_id, String book_name, String book_authors,  boolean is_book_available) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.book_authors = book_authors;

    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", book_name='" + book_name + '\'' +
                ", book_authors='" + book_authors + '\'' +
                '}';
    }


    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_authors() {
        return book_authors;
    }

    public void setBook_authors(String book_authors) {
        this.book_authors = book_authors;
    }

    public Book()
    {
    	
    }

}

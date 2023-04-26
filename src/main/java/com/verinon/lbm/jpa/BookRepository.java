package com.verinon.lbm.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.verinon.lbm.pojos.Book;


public interface BookRepository extends JpaRepository<Book,Integer>
{
    //List<BookPojo> findByBook_name(String book_name);
}

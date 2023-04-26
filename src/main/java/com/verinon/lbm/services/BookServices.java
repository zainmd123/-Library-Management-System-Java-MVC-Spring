package com.verinon.lbm.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verinon.lbm.jpa.BookRepository;
import com.verinon.lbm.pojos.Book;



@Service
public class BookServices
{
	@Autowired
	private BookRepository bookRepository;

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	public void saveBook(Book book) {
		this.bookRepository.save(book);
	}

	public void deleteBookById(int id) {
		this.bookRepository.deleteById(id);
	}
    public void editBook(int id, Book book)
    {
        for (Book bid : getAllBooks()) {
            if(bid.getBook_id()==id)
            {
                bid.setBook_name(book.getBook_name());
                bid.setBook_authors(book.getBook_authors());
                this.bookRepository.save(bid);
                
            }
        }
    }

	public Book getBookById(int id) {
		Optional<Book> optional = bookRepository.findById(id);
		Book book = null;
		if (optional.isPresent()) {
			book = optional.get();
		} else {
			throw new RuntimeException(" Book not found for id :: " + id);
		}
		return book;
	}
}

//    static List<BookPojo> listOfBooks= new ArrayList<>();
//    static int id=4;
//    static
//    {
//        //id=4;
//        listOfBooks.add(new BookPojo(1,"C","DenniesRich",150.25,"ComputerScience",new Date(),new Date(),new Date(),true));
//        listOfBooks.add(new BookPojo(2,"Java","James",180.25,"ComputerScience",new Date(),new Date(),new Date(),true));
//        listOfBooks.add(new BookPojo(3,"Python","Rossum",250.95,"ComputerScience",new Date(),new Date(),new Date(),true));
//    }
//
//
//    public List<BookPojo> showAllBooksData()
//    {
//
//        return listOfBooks;
//    }
//
//    public List<BookPojo> addBook(String book_name,String book_authors,double book_price,Date book_published,boolean is_book_available,String book_dept)
//    {
//        listOfBooks.add(new BookPojo(id++,book_name, book_authors,book_price, book_dept, new Date(), new Date(),book_published,is_book_available));
//
//        return listOfBooks;
//    }
//
//    public void delBook(int id)
//    {
//        Iterator it= listOfBooks.iterator();
//
//        while (it.hasNext())
//        {
//            BookPojo bid=(BookPojo) it.next();
//            if(bid.getBook_id()==id)
//            {
//                it.remove();
//            }
//        }
//    }
//

//
//    public BookPojo getBookDetails(String book_name)
//    {
//        for (BookPojo mybook : listOfBooks) {
//            if((mybook.getBook_name()).equalsIgnoreCase(book_name))
//            {
//                return mybook;
//            }
//        }
//        return null;
//    }
//
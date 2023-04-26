package com.verinon.lbm.pojos;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "entries")
public class SmartBookSystem
{
    @Id
    @GeneratedValue
    int id;
    
    @Column(name="bookname")
    String bookName;
    
    @Column(name="username")
    String userName;
    
    @Column(name="dob")
    Date dateOfBorrow;
    
    @Column(name="dor")
    Date dateOfReturn;

    public SmartBookSystem(String userName,String bookName,Date date) {
        this.bookName = bookName;
        this.userName = userName;
        this.dateOfBorrow=date;
    }
    public SmartBookSystem()
    {
    	
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getDateOfBorrow() {
        return dateOfBorrow;
    }

    public void setDateOfBorrow(Date dateOfBooked) {
        this.dateOfBorrow = dateOfBooked;
    }

    public Date getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(Date localDate) {
        this.dateOfReturn = localDate;
    }


    @Override
    public String toString() {
        return "SmartBookSystem{" +
                "bookName='" + bookName + '\'' +
                ", memberName='" + userName + '\'' +
                ", dateOfBooked=" + dateOfBorrow +
                ", dateOfReturn=" + dateOfReturn +
                '}';
    }
}

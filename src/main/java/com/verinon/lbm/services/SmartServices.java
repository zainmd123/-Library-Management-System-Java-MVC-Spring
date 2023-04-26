package com.verinon.lbm.services;
import java.time.LocalDateTime; 
import java.util.Date; 
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verinon.lbm.jpa.BookRepository;
import com.verinon.lbm.jpa.SmartBookSystemRepository;
import com.verinon.lbm.pojos.Book;
import com.verinon.lbm.pojos.SmartBookSystem;

@Service
public class SmartServices
{
	@Autowired
	private SmartBookSystemRepository sbRepository;
	
	public List<SmartBookSystem> getAllEntries() {
		return sbRepository.findAll();
	}
	
	public void saveEntry(SmartBookSystem smartBookSystem) {

		this.sbRepository.save(smartBookSystem);
	}
	
	public void deleteEntryById(int id) {
		this.sbRepository.deleteById(id);
	}

	public void returnBook(int id, SmartBookSystem smartBookSystem) {
		// TODO Auto-generated method stub
		
		for (SmartBookSystem sm : getAllEntries()) {
            if(sm.getId()==id)
            {
                sm.setUserName(sm.getUserName());
                sm.setBookName(sm.getBookName());
                sm.setDateOfBorrow(sm.getDateOfBorrow());
                sm.setDateOfReturn(new Date());
                this.sbRepository.save(sm);
                
            }
        }
	}
	
}	
//    List<SmartBookSystem> smartBookSystems=new ArrayList<>();
//    List<SmartBookSystem> totalHistory=new ArrayList<>();
//
//
//
//        public List<SmartBookSystem> getDetailsAboutMember(String memberName, String bookName, Date date)
//        {
//
//            smartBookSystems.add(new SmartBookSystem(memberName,bookName,date));
//            totalHistory.add(new SmartBookSystem(memberName,bookName,date));
//            return smartBookSystems;
//        }
//
//    public List<SmartBookSystem> getTotalDetails()
//        {
//            return smartBookSystems;
//        }
//
//
//
//    public void delMember(String name)
//    {
//        Iterator it= smartBookSystems.iterator();
//
//        while (it.hasNext())
//        {
//            SmartBookSystem sbs=(SmartBookSystem) it.next();
//            if(sbs.getMemberName().equalsIgnoreCase(name))
//            {
//
//                //sbs.setDateOfReturn(date);
//                it.remove();
//            }
//        }
//    }
//
//
//
//        public List<SmartBookSystem> showTotalHistory()
//        {
//            return totalHistory;
//        }
//
//        public SmartBookSystem checkMember(String name)
//        {
//            for (SmartBookSystem sbs : totalHistory) {
//                if(sbs.getMemberName().equalsIgnoreCase(name))
//                {
//                    sbs.setDateOfReturn(new Date());
//                    return sbs;
//                }
//            }
//
//            return null;
//        }


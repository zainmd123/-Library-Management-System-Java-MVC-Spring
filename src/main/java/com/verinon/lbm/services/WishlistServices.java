package com.verinon.lbm.services;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verinon.lbm.jpa.WishlistRepository;
import com.verinon.lbm.pojos.Wishlist;
import com.verinon.lbm.pojos.WishlistIterator;

@Service
public class WishlistServices{

	@Autowired
	private WishlistRepository wishlistRepository;

	public List<Wishlist> getAllWishes() {
		
		List<Wishlist> myList = new ArrayList<>();
		WishlistIterator<Wishlist> iterator = new WishlistIterator<>(wishlistRepository.findAll());
		while (iterator.hasNext()) {
		    Wishlist wishlist = iterator.next();
		    myList.add(wishlist);
		    
		}
		return myList;
	}

	public void saveWish(Wishlist wishlist) {
		this.wishlistRepository.save(wishlist);
	}

	public Wishlist getWishById(long id) {
		Optional<Wishlist> optional = wishlistRepository.findById(id);
		Wishlist wishlist = null;
		if (optional.isPresent()) {
			wishlist = optional.get();
		} else {
			throw new RuntimeException(" Wish not found for id :: " + id);
		}
		return wishlist;
	}
	public void deleteWishById(long id) {
		this.wishlistRepository.deleteById(id);
	}
	public void editWish(long id, Wishlist wishlist)
    {
        for (Wishlist wid : getAllWishes()) {
            if(wid.getId()==id)
            {
                wid.setBookName(wishlist.getBookName());
                this.wishlistRepository.save(wid);
                
            }
        }
    }
}

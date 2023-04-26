package com.verinon.lbm.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verinon.lbm.pojos.Wishlist;



@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long>{
	
}

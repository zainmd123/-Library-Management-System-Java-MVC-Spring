package com.verinon.lbm.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verinon.lbm.pojos.Review;



@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{

}
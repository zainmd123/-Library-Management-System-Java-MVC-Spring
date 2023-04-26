package com.verinon.lbm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verinon.lbm.jpa.ReviewRepository;
import com.verinon.lbm.pojos.Book;
import com.verinon.lbm.pojos.Review;


@Service
public class ReviewServices{

	@Autowired
	private ReviewRepository reviewRepository;

	public List<Review> getAllReviews() {
		return reviewRepository.findAll();
	}

	public void saveReview(Review review) {
		this.reviewRepository.save(review);
	}

	public Review getReviewById(long id) {
		Optional<Review> optional = reviewRepository.findById(id);
		Review review = null;
		if (optional.isPresent()) {
			review = optional.get();
		} else {
			throw new RuntimeException(" Review not found for id :: " + id);
		}
		return review;
	}
	public void deleteReviewById(long id) {
		this.reviewRepository.deleteById(id);
	}
	public void editReview(long id, Review review)
    {
        for (Review rid : getAllReviews()) {
            if(rid.getId()==id)
            {
                rid.setTitle(review.getTitle());
                rid.setDescription(review.getDescription());
                this.reviewRepository.save(rid);
                
            }
        }
    }
}
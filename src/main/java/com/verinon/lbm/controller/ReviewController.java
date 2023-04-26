package com.verinon.lbm.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.verinon.lbm.services.ReviewServices;
import com.verinon.lbm.jpa.ReviewRepository;
import com.verinon.lbm.pojos.Book;
import com.verinon.lbm.pojos.Review;

@Controller
public class ReviewController {

	@Autowired
	private ReviewServices reviewService;
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	// display list of reviews
	@GetMapping("/listOfReviews")
	public String seeAllReviews(Model model) {
		model.addAttribute("listReviews", reviewService.getAllReviews());
		return "showallreviews";	
	}
	
	@GetMapping("/showReviewform")
	public String showNewReviewForm(Model model) {
		// create model attribute to bind form data
		Review review = new Review();
		model.addAttribute("review", review);
		return "new-review";
	}
	
	@PostMapping("/showReviewform")
	public String saveReview(@ModelAttribute("review") Review review) {
		// save review to database
		reviewService.saveReview(review);
		return "redirect:/listOfReviews";
	}
    @RequestMapping("/delete-review")
    public String deleteReviewFromList(long id)
    {
        reviewService.deleteReviewById(id);
        return "redirect:listOfReviews";
    }

    @PostMapping("/edit-review")
    public String editReviewDetails(long id,Review review)
    {
 
        if(reviewRepository.existsById(id))
        {
            reviewService.editReview(id,review);

        }
        return "redirect:listOfReviews";
    }

    @GetMapping("/edit-review")
    public String editReviewDetailsShowPage(ModelMap model)
    {
    	Review review = new Review();
        model.addAttribute("review", review);
        return "editReviews";
    }
		
	
}

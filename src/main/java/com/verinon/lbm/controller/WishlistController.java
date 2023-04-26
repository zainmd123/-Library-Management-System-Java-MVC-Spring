package com.verinon.lbm.controller;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.verinon.lbm.services.WishlistServices;
import com.verinon.lbm.jpa.WishlistRepository;
import com.verinon.lbm.pojos.Wishlist;

@Controller
public class WishlistController {

	@Autowired
	private WishlistServices wishlistService;
	
	@Autowired
	private WishlistRepository wishlistRepository;
	
	// display list of reviews
	@GetMapping("/wishList")
	public String seeAllWishes(Model model) {
		model.addAttribute("listWishes",wishlistService.getAllWishes());
		return "showallwishes";	
	}
	
	@GetMapping("/showWishform")
	public String showNewWishForm(Model model) {
		// create model attribute to bind form data
		Wishlist wishlist = new Wishlist();
		model.addAttribute("wishlist", wishlist);
		return "new-wish";
	}
	
	@PostMapping("/showWishform")
	public String saveWish(@ModelAttribute("review") Wishlist wishlist) {
		// save review to database
		wishlistService.saveWish(wishlist);
		return "redirect:/wishList";
	}
    @RequestMapping("/delete-wish")
    public String deleteWishFromList(long id)
    {
        wishlistService.deleteWishById(id);
        return "redirect:wishList";
    }

    @PostMapping("/edit-wish")
    public String editWishDetails(long id,Wishlist wishlist)
    {
 
        if(wishlistRepository.existsById(id))
        {
            wishlistService.editWish(id,wishlist);

        }
        return "redirect:wishList";
    }

    @GetMapping("/edit-wish")
    public String editReviewDetailsShowPage(ModelMap model)
    {
    	Wishlist wishlist = new Wishlist();
        model.addAttribute("wishlist", wishlist);
        return "editWishes";
    }
		
	
}

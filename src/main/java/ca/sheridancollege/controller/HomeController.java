package ca.sheridancollege.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.beans.Account;
import ca.sheridancollege.beans.Customer;
import ca.sheridancollege.beans.Donation;
import ca.sheridancollege.repository.DonationRepository;
import lombok.AllArgsConstructor;


@Controller
@AllArgsConstructor
public class HomeController {
	
	private DonationRepository donationRepository;

	@GetMapping("/")
	public String index(Model model) {
		Optional<Donation> donate = donationRepository.findById((long) 1);
		model.addAttribute("donation", donate.get());
		
		return "index.html";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("account", new Account());

		return "login.html";
	}
	
	@GetMapping("/about")
	public String about(Model model) {
		Optional<Donation> donate = donationRepository.findById((long) 1);
		model.addAttribute("donation", donate.get());
		
		return "aboutUs.html";
	}
	
	@GetMapping("/donate")
	public String donate(Model model) {
		
		Optional<Donation> donate = donationRepository.findById((long) 1);
		model.addAttribute("donation", donate.get());

		return "donate.html";
	}

}

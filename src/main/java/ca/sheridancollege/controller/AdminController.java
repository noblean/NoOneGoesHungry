package ca.sheridancollege.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.beans.Account;
import ca.sheridancollege.beans.Customer;
import ca.sheridancollege.beans.Donation;
import ca.sheridancollege.beans.Volunteer;
import ca.sheridancollege.repository.AccountRepository;
import ca.sheridancollege.repository.CustomerRepository;
import ca.sheridancollege.repository.DonationRepository;
import ca.sheridancollege.repository.VolunteerRepository;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class AdminController {

	private VolunteerRepository volunteerRepository;
	private AccountRepository accountRepository;
	private CustomerRepository customerRepository;
	private DonationRepository donationRepository;

	
	@GetMapping("/adminDashboard/volunteerApplicants")
	public String adminDashboard(Model model) {
		model.addAttribute("volunteerList", volunteerRepository.findByStatus("PENDING"));
		
		return "admin/volunteer/volunteerApplicants.html";
	}
	
	@GetMapping("/adminDashboard/volunteerList")
	public String volunteerList(Model model) {
		model.addAttribute("volunteerList", volunteerRepository.findByStatus("APPROVED"));
		
		return "admin/volunteer/activeVolunteerList.html";
	}
	
	@GetMapping("/adminDashboard/viewVolunteerInfo/{id}") 
	public String viewVolunteerInfo(Model model, @PathVariable Long id) {
		
		Optional<Volunteer> volunteer = volunteerRepository.findById(id);
		
		model.addAttribute("volunteer", volunteer.get());
		
		return "admin/volunteer/volunteerInfo.html";
	}
	
	@GetMapping("/adminDashboard/viewVolunteer/{id}") 
	public String viewVolunteer(Model model, @PathVariable Long id) {
		
		Optional<Volunteer> volunteer = volunteerRepository.findById(id);
		
		model.addAttribute("volunteer", volunteer.get());
		
		return "admin/volunteer/volunteerDetails.html";
	}
	
	@GetMapping("/adminDashboard/volunteerWaitlist")
	public String volunteerWaitlist(Model model) {
		model.addAttribute("volunteerList", volunteerRepository.findByStatus("WAITLIST"));
		
		return "admin/volunteer/volunteerWaitlist.html";
	}
	
	@GetMapping("/adminDashboard/volunteerInactive")
	public String volunteerInactive(Model model) {
		model.addAttribute("volunteerList", volunteerRepository.findByStatus("INACTIVE"));
		
		return "admin/volunteer/volunteerInactive.html";
	}

	
	
	
	/* -------------------------------------------------
	 * 			CUSTOMER MANAGMENT
	 */
	
	@GetMapping("/adminDashboard/customerApplicants")
	public String customerDashboard(Model model) {
		model.addAttribute("customerList", customerRepository.findByStatus("PENDING"));
		
		return "admin/customer/customerApplicants.html";
	}
	
	@GetMapping("/adminDashboard/customerList")
	public String customerList(Model model) {
		model.addAttribute("customerList", customerRepository.findByStatus("APPROVED"));
		
		return "admin/customer/activeCustomerList.html";
	}
	
	@GetMapping("/adminDashboard/viewCustomerInfo/{id}") 
	public String viewCustomerInfo(Model model, @PathVariable Long id) {
		
		Optional<Customer> customer = customerRepository.findById(id);
		
		model.addAttribute("customer", customer.get());
		
		return "admin/customer/customerInfo.html";
	}
	
	@GetMapping("/adminDashboard/viewCustomer/{id}") 
	public String viewCustomer(Model model, @PathVariable Long id) {
		
		Optional<Customer> customer = customerRepository.findById(id);
		
		model.addAttribute("customer", customer.get());
		
		return "admin/customer/customerDetails.html";
	}
	
	@GetMapping("/adminDashboard/customerWaitlist")
	public String customerWaitlist(Model model) {
		model.addAttribute("customerList", customerRepository.findByStatus("WAITLIST"));
		
		return "admin/customer/customerWaitlist.html";
	}
	
	@GetMapping("/adminDashboard/customerInactive")
	public String customerInactive(Model model) {
		model.addAttribute("customerList", customerRepository.findByStatus("INACTIVE"));
		
		return "admin/customer/customerInactive.html";
	}
	
	
	/* -------------------------------------------------
	 * 			ADMIN USER MANAGMENT
	 */

	
	@GetMapping("/adminDashboard/userList")
	public String userList(Model model) {
		model.addAttribute("userList", accountRepository.findAll());
		
		return "admin/user/activeUserList.html";
	}
	
	@GetMapping("/adminDashboard/viewUser/{id}") 
	public String viewUser(Model model, @PathVariable Long id) {
		
		Optional<Account> account = accountRepository.findById(id);
		
		model.addAttribute("user", account.get());
		
		return "admin/user/userDetails.html";
	}
	
	/* -------------------------------------------------
	 * 			ADMIN USER MANAGMENT
	 */

	
	@GetMapping("/adminDashboard/manage")
	public String manage(Model model) {
		Optional<Donation> donate = donationRepository.findById((long) 1);
		model.addAttribute("donation", donate.get());
		
		return "admin/manage/manage.html";
	}
	
	@PostMapping("/adminDashboard/manage")
	public String postmanage(Model model, @ModelAttribute Donation donation) {
		Optional<Donation> donate = donationRepository.findById((long) 1);
		donationRepository.save(donation);
		model.addAttribute("donation", donation);
		
		return "redirect:/adminDashboard/manage";
	}
	
	

}

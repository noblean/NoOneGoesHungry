package ca.sheridancollege.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.beans.Customer;
import ca.sheridancollege.beans.Donation;
import ca.sheridancollege.beans.Volunteer;
import ca.sheridancollege.repository.CustomerRepository;
import ca.sheridancollege.repository.DonationRepository;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class CustomerController {
	
	private CustomerRepository customerRepository;
	private DonationRepository donationRepository;
	
	@GetMapping("/customer")
	public String customer(Model model) {
		
		 Optional<Donation> donate = donationRepository.findById((long) 1);
			model.addAttribute("donation", donate.get());
		
		model.addAttribute("customer", new Customer());

		return "customer/customerRegistration.html";
	}
	
	@PostMapping("/customer/register")
	public String registerCustomer(Model model, @Valid @ModelAttribute Customer customer, BindingResult result) {
		
		model.addAttribute("customer", customer);
		
		if (result.hasErrors()) {
			return "customer/customerRegistration.html";
		}
		
		return "customer/customerRegistrationConfirmDetails.html";
	}
	
	@PostMapping("/customer/confirm")
	public String confirmCustomer(Model model, @ModelAttribute Customer customer) {
		
		model.addAttribute("customer", customer);
		
		customer.setStatus("PENDING");
		
		customerRepository.save(customer);
		
		return "customer/customerRegistrationConfirmation.html";
	}
	
	@GetMapping("/adminDashboard/deleteCustomer/{id}")
	public String deleteCustomer(Model model, @PathVariable Long id) {
		customerRepository.deleteById(id);
		
		return "redirect:/adminDashboard/customerApplicants";
	}
	
	@GetMapping("/adminDashboard/deactivateCustomer/{id}")
	public String deactivateCustomer(Model model, @PathVariable Long id) {
		Optional<Customer> search = customerRepository.findById(id);
		Customer customer = search.get();
		customer.setStatus("INACTIVE");
		
		customerRepository.save(customer);
		return "redirect:/adminDashboard/customerList";
	}

	@GetMapping("/adminDashboard/approveCustomer/{id}")
	public String approveCustomer(Model model, @PathVariable Long id) {
		Optional<Customer> searchCustomer = customerRepository.findById(id);
		
		Customer customer = searchCustomer.get();
		customer.setStatus("APPROVED");
		
		customerRepository.save(customer);
		
		return "redirect:/adminDashboard/customerApplicants";
	}
	
	@GetMapping("/adminDashboard/rejectCustomer/{id}")
	public String rejectCustomer(Model model, @PathVariable Long id) {
		Optional<Customer> searchCustomer = customerRepository.findById(id);
		
		Customer customer = searchCustomer.get();
		customer.setStatus("WAITLIST");
		
		customerRepository.save(customer);
		
		return "redirect:/adminDashboard/customerApplicants";
	}
	
	@GetMapping("/adminDashboard/editCustomer/{id}") 
	public String editCustomer(Model model, @PathVariable Long id) {
		Optional<Customer> customer = customerRepository.findById(id);
		model.addAttribute("customer", customer);
		
		return "admin/customer/editCustomer.html"; 
	}
	
	@PostMapping("/adminDashboard/updateCustomer") 
	public String updateCustomer(Model model, @ModelAttribute Customer customer) {
		customerRepository.save(customer);
		
		return "redirect:/adminDashboard/customerList";
	}
}

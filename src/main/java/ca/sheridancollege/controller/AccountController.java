package ca.sheridancollege.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.beans.Account;
import ca.sheridancollege.repository.AccountRepository;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class AccountController {
	private AccountRepository accountRepository;
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@GetMapping("/adminDashboard/registerUser")
	public String registerUser(Model model) {
		 model.addAttribute("user", new Account());

		return "admin/user/userRegistration.html";
	}
	
	@PostMapping("/adminDashboard/addUser")
	public String addUser(Model model, @Valid @ModelAttribute("user") Account account, BindingResult result) {
		model.addAttribute("user", account);
		
		if (result.hasErrors()) {
			return "admin/user/userRegistration.html";
		}
		
		String encodedPass = encoder.encode(account.getPassword());
		account.setPassword(encodedPass);
		
		accountRepository.save(account);
		
		return "redirect:/adminDashboard/userList";
	}
	
	@GetMapping("/adminDashboard/editUser/{id}") 
	public String editUser(Model model, @PathVariable Long id) {
		Optional<Account> account = accountRepository.findById(id);
		model.addAttribute("user", account);
		
		return "admin/user/editUser.html";
	}
	
	@PostMapping("/adminDashboard/updateUser/{id}") 
	public String updateUser(Model model, @ModelAttribute Account account) {
		Long id = account.getId();
		String firstName = account.getFirstName();
		String lastName = account.getLastName();
		String username = account.getUsername();
		
		accountRepository.updateAccountInfo(id, firstName, lastName, username);
		
		return "redirect:/adminDashboard/userList";
	}
	
	@GetMapping("/adminDashboard/resetPassword/{id}")
	public String resetPassword(Model model, @PathVariable Long id) {
		Account account = accountRepository.findById(id).get();
		
		model.addAttribute("user", account);
		
		return "admin/user/resetPassword.html";
	}
	
	@PostMapping("/adminDashboard/updatePassword/{id}")
	public String udpatePassword(Model model, @ModelAttribute Account account) {
		Long id = account.getId();
		String rawPassword = account.getPassword();
		String encodedPassword = encoder.encode(rawPassword);
		
		accountRepository.resetPassword(id, encodedPassword);
		
		return "redirect:/adminDashboard/userList";
	}
	
	@GetMapping("/adminDashboard/deleteUser/{id}")
	public String deleteUser(Model model, @PathVariable Long id) {
		accountRepository.deleteById(id);

		return "redirect:/adminDashboard/userList";
	}
}
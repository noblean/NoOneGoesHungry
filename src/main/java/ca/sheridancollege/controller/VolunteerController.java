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

import ca.sheridancollege.beans.Donation;
import ca.sheridancollege.beans.Volunteer;
import ca.sheridancollege.repository.DonationRepository;
import ca.sheridancollege.repository.VolunteerRepository;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class VolunteerController {
	
	private VolunteerRepository volunteerRepository;
	private DonationRepository donationRepository;
	
	@GetMapping("/volunteer")
	public String volunteer(Model model) {
		
		 model.addAttribute("volunteer", new Volunteer());
		 
		 Optional<Donation> donate = donationRepository.findById((long) 1);
			model.addAttribute("donation", donate.get());

		return "volunteer/volunteerRegistration.html";
	}
	
	@PostMapping("/volunteer/register")
	public String registerVolunteer(Model model, @Valid @ModelAttribute Volunteer volunteer, 
			BindingResult result) {
		
		model.addAttribute("volunteer", volunteer);
		
		if (result.hasErrors()) {
			return "volunteer/volunteerRegistration.html";
		}
		
		return "volunteer/volunteerRegistrationConfirmDetails.html";
	}
	
	@PostMapping("/volunteer/confirm")
	public String confirm(Model model, @ModelAttribute Volunteer volunteer) {
		
		model.addAttribute("volunteer", volunteer);
		
		volunteer.setStatus("PENDING");
		
		volunteerRepository.save(volunteer);

		return "volunteer/volunteerRegistrationConfirmation.html";
	}

	@GetMapping("/adminDashboard/deleteVolunteer/{id}")
	public String deleteVolunteer(Model model, @PathVariable Long id) {
		volunteerRepository.deleteById(id);

		return "redirect:/adminDashboard/volunteerList";
	}
	
	@GetMapping("/adminDashboard/deactivateVolunteer/{id}")
	public String deactivateVolunteer(Model model, @PathVariable Long id) {
		Optional<Volunteer> searchVolunteer = volunteerRepository.findById(id);
		Volunteer volunteer = searchVolunteer.get();
		volunteer.setStatus("INACTIVE");
		
		volunteerRepository.save(volunteer);
		return "redirect:/adminDashboard/volunteerList";
	}

	@GetMapping("/adminDashboard/approveVolunteer/{id}")
	public String approveVolunteer(Model model, @PathVariable Long id) {
		Optional<Volunteer> searchVolunteer = volunteerRepository.findById(id);
		
		Volunteer volunteer = searchVolunteer.get();
		volunteer.setStatus("APPROVED");
		
		volunteerRepository.save(volunteer);
		
		return "redirect:/adminDashboard/volunteerApplicants";
	}
	
	@GetMapping("/adminDashboard/rejectVolunteer/{id}")
	public String rejectVolunteer(Model model, @PathVariable Long id) {
		Optional<Volunteer> searchVolunteer = volunteerRepository.findById(id);
		
		Volunteer volunteer = searchVolunteer.get();
		volunteer.setStatus("WAITLIST");
		
		volunteerRepository.save(volunteer);
		
		return "redirect:/adminDashboard/volunteerApplicants";
	}
	
	@GetMapping("/adminDashboard/editVolunteer/{id}") 
	public String editVolunteer(Model model, @PathVariable Long id) {
		Optional<Volunteer> volunteer = volunteerRepository.findById(id);
		model.addAttribute("volunteer", volunteer);
		
		return "admin/volunteer/editVolunteer.html";
	}
	
	@PostMapping("/adminDashboard/updateVolunteer") 
	public String updateVolunteer(Model model, @ModelAttribute Volunteer volunteer) {
		volunteerRepository.save(volunteer);
		
		return "redirect:/adminDashboard/volunteerList";
	}
}

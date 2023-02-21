package ca.sheridancollege.bootstrap;


import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import ca.sheridancollege.beans.Account;
import ca.sheridancollege.beans.Customer;
import ca.sheridancollege.beans.Donation;
import ca.sheridancollege.beans.Volunteer;
import ca.sheridancollege.repository.AccountRepository;
import ca.sheridancollege.repository.CustomerRepository;
import ca.sheridancollege.repository.DonationRepository;
import ca.sheridancollege.repository.VolunteerRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner  {
	
	private VolunteerRepository volunteerRepository;
	private CustomerRepository customerRepository;
	private AccountRepository accountRepository;
	private DonationRepository donation;

	@Override
	public void run(String... args) throws Exception {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
//	  Donation money = Donation.builder()
//			  .goal("$9,000")
//			  .amountRaised("$3,500")
//			  .percentAmountRaised(30)
//			  .description("We are a non-profit organization helping those in need. No One Goes Hungry (NOGH) is run solely by volunteers! We rescue food and transform it into meals to distribute to the community, as well as create grocery packages filled with produce, bread, fresh meat, dry goods and dairy. The rescued food is prepared by volunteers each week and then delivered to the homes of anyone in need.")
//			  .about("No One Goes Hungry (NOGH) started back on Sunday Nov 1st, 2020, at Caribbean Vibes Milton where we cooked 300 meals and fed our community with the awesome volunteers like Kimberley Savage-Paulson and her son, Maliha Khan Ahmed and so many more.")
//			  .homeblock1("We are a non-profit organization helping those in need. No One Goes Hungry (NOGH) is run solely by volunteers! We rescue food and transform it into meals to distribute to the community, as well as create grocery packages filled with produce, bread, fresh meat, dry goods and dairy. The rescued food is prepared by volunteers each week and then delivered to the homes of anyone in need.")
//			  .homeblock2("We get fresh produce, fruit, frozen meat, dairy, bread, dry goods, and frozen veggies/fruit from various organizations. Food for Life is one of our biggest partners. La Rose Specialty Foods and Fine Italian Bakery - Milton, Ontario is another plentiful local partner. Optimist Club of Milton is another great bridge into the community as we make frozen meals for all their families who register for meals.")
//			  .volunteer("We welcome people to deliver and to work in the kitchen, doing basic cooking. We ask volunteers to wear closed-toe shoes, short-sleeved shirts (no sleeveless shirts or short shorts) and masks, of course. No experience necessary, just willing hands to help others. We look forward to having you as a member of our team.")
//			  .meals("We would like to help out everyone in need, unfortunately our operations limit us currently to only the regions Milton, Halton, and Oakville in Ontario, Canada. Please sign up below and we will get back to you with more information!")
//			  .build();
		
//	  	donation.save(money);
		
		Account admin = Account.builder()
				.firstName("Melani")
				.lastName("Bastians")
				.username("melanib")
				.password(encoder.encode("nogh"))
				.role("ADMIN")
				.build();
		
		accountRepository.save(admin);
		
		
//		
//		Volunteer v1 = Volunteer.builder()
//				.firstName("Melani")
//				.lastName("Bastians")
//				.position("Kitchen, Delivery")
//				.availability("Monday 11:00am - 1:30pm")
//				.volunteerArea("Halton")
//				.email("noghhaltonon@gmail.com")
//				.phone("416-555-6143")
//				.status("APPROVED")
//				.build();
//		
//		Volunteer v2 = Volunteer.builder()
//				.firstName("Carl")
//				.lastName("Sander")
//				.position("Delivery")
//				.availability("Friday 11:00am - 1:30pm")
//				.volunteerArea("Milton")
//				.email("f.sand83@hotmail.ca")
//				.phone("647-632-9416")
//				.status("PENDING")
//				.build(); 
//		
//		Volunteer v3 = Volunteer.builder()
//				.firstName("Catherine")
//				.lastName("Sander")
//				.position("Delivery")
//				.availability("Friday 11:00am - 1:30pm")
//				.volunteerArea("Milton")
//				.email("cat.s1@gmail.com")
//				.phone("905-111-3214")
//				.status("PENDING")
//				.build();
//		
//		Volunteer v4 = Volunteer.builder()
//				.firstName("Donna")
//				.lastName("Jagoe")
//				.position("Kitchen")
//				.availability("Monday 11:00am - 1:30pm, Wednesday 1:30pm - 4:00pm")
//				.volunteerArea("Oakville")
//				.email("d_jagoe@hotmail.com")
//				.phone("000-000-0000")
//				.status("APPROVED")
//				.build();
//		
//		Volunteer v5 = Volunteer.builder()
//				.firstName("Kimberley")
//				.lastName("Savage-Paulson")
//				.position("Kitchen")
//				.availability("Monday 11:00am - 1:30pm, Wednesday 1:30pm - 4:00pm")
//				.volunteerArea("Oakville")
//				.email("j.bastians@nogh.com")
//				.phone("(416) 267-9436")
//				.status("APPROVED")
//				.build();
//		
//		Volunteer v6 = Volunteer.builder()
//				.firstName("Nicole")
//				.lastName("Morgan")
//				.position("Kitchen")
//				.availability("Monday 11:00am - 1:30pm")
//				.volunteerArea("Oakville")
//				.email("nikky@gmail.com")
//				.phone("000-000-0000")
//				.status("WAITLIST")
//				.build();
//		
//		volunteerRepository.save(v1);
//     	volunteerRepository.save(v2);
//		volunteerRepository.save(v3);
//		volunteerRepository.save(v4);
//		volunteerRepository.save(v5);
//		volunteerRepository.save(v6);
//		
//		Customer c1 = Customer.builder()
//				.firstName("Harvey")
//				.lastName("Valverde")
//				.address("121 ALLAN ST")
//				.city("Oakville")
//				.numInHousehold(4)
//				.email("harvey.valverde86@yahoo.ca")
//				.dietaryOption("Vegetarian")
//				.phone("(778) 514-1216")
//				.postal("L6J 3N3")
//				.status("PENDING")
//				.build();
//		
//		Customer c2 = Customer.builder()
//				.firstName("Janna")
//				.lastName("Heasley")
//				.address(null)
//				.city(null)
//				.numInHousehold(3)
//				.email("j.heasley@gmail.com")
//				.dietaryOption("None")
//				.phone(null)
//				.postal(null)
//				.status("APPROVED")
//				.build();
//		
//		customerRepository.save(c1);
//		customerRepository.save(c2);
//	  

	
	
	}
}

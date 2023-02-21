package ca.sheridancollege.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Volunteer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String position; // volunteer position (Kitchen, Delivery)
	
	private String availability; // volunteers Day and time available 
	
	private String volunteerArea; // delivery are, Milton/Oakville/Halton
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String phone;
	
	private Boolean enrolledSecondary; // if the volunteer is in need of secondary school volunteer hours
	
	private String status; // PENDING/WAITLIST/APPROVED/INACTIVE
}

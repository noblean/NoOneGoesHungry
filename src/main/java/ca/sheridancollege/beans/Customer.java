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
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String address;
	private String postal;
	private String city;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String phone;
	
	private String accommodations;
	
	private String dietaryOption;
	
	private Integer numInHousehold;
	
	private String status; // PENDING/REJECTED/APPROVED/WAITLIST

}

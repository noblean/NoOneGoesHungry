package ca.sheridancollege.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Donation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String goal; 
	
	private String amountRaised;
	
	private Integer percentAmountRaised;
	
	@Lob
	private String description;
	
	@Lob
	private String homeblock1;
	
	@Lob
	private String homeblock2;
	
	@Lob
	private String volunteer;
	
	@Lob
	private String meals;
	
	@Lob
	private String about;
	
}

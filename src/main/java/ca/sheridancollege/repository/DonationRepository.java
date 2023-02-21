package ca.sheridancollege.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import ca.sheridancollege.beans.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long>{
	

	
}
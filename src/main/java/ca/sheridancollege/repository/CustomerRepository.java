package ca.sheridancollege.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.beans.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

	public boolean existsByEmail(String email);
	
	public List<Customer> findByStatus(String status);

}

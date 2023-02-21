package ca.sheridancollege.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import ca.sheridancollege.beans.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	
	public Optional<Account> findById(Long id);
	
	public Account findByUsername(String username);
	
	public boolean existsByUsername(String username);
	
	@Transactional
	@Modifying
	@Query("UPDATE Account a SET a.firstName = :firstName, a.lastName = :lastName, a.username = :username where a.id = :id")
	void updateAccountInfo(
			@Param(value = "id") Long id, 
			@Param(value = "firstName") String firstName, 
			@Param(value = "lastName") String lastName,
			@Param(value = "username") String username);
	
	@Transactional
	@Modifying
	@Query("UPDATE Account a SET a.password = :password where a.id = :id")
	void resetPassword(
			@Param(value = "id") Long id,
			@Param(value = "password") String password);

}

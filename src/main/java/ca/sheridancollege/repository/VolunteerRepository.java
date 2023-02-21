package ca.sheridancollege.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import ca.sheridancollege.beans.Volunteer;

@Transactional
public interface VolunteerRepository extends JpaRepository<Volunteer, Long>{
	public Optional<Volunteer> findById(Long id);
	
	public List<Volunteer> findByStatus(String status);
	
	public boolean existsByEmail(String email);
	
	@Modifying
	@Query("UPDATE Volunteer v SET v.phone = :phone, v.email = :email where v.id = :id")
	void updateContactInfo(
			@Param(value = "id") Long id, 
			@Param(value = "phone") String phone, 
			@Param(value = "email") String email);
}

package ca.sheridancollege.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ca.sheridancollege.beans.Account;
import ca.sheridancollege.repository.AccountRepository;
import ca.sheridancollege.security.UserAccount;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Account account = accountRepository.findByUsername(username);
		
		if (account == null) {
			throw new UsernameNotFoundException("User " + username + " was not found in the database");
		}
		
		return new UserAccount(account);
	}
}

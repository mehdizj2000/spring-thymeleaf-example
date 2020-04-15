package au.com.tml.example.services.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import au.com.tml.example.domain.UserInfo;
import au.com.tml.example.repo.UserInfoRepo;

@Service
public class MyUserDetailsServiceImpl implements UserDetailsService {

	private UserInfoRepo userInfoRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<UserInfo> userInfoOpt = userInfoRepo.findByEmail(username);
		UserInfo userInfo = userInfoOpt
				.orElseThrow(() -> new UsernameNotFoundException("No User Found with email: " + username));

		Collection<? extends GrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));

		return new User(userInfo.getEmail(), userInfo.getPassword(), authorities);

	}

	public UserInfoRepo getUserInfoRepo() {
		return userInfoRepo;
	}

	@Autowired
	public void setUserInfoRepo(UserInfoRepo userInfoRepo) {
		this.userInfoRepo = userInfoRepo;
	}

}

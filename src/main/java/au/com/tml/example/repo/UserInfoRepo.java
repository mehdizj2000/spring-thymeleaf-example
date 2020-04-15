package au.com.tml.example.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.tml.example.domain.UserInfo;

public interface UserInfoRepo extends JpaRepository<UserInfo, Long> {

	Optional<UserInfo> findByEmail(String email);

}

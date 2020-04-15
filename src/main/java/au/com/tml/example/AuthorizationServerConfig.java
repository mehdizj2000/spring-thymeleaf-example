package au.com.tml.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	private AuthenticationManager authenticationManager;

	@Bean
	public TokenStore tokenStore() {
		return new InMemoryTokenStore();
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
	// @formatter:off
		clients
			.inMemory()
			.withClient("mqas-test")
			.secret(passwordEncoder().encode("6t2er3b2476gb237167u"))
			.authorizedGrantTypes("password")
			.scopes("mehdi-kjh")
			.accessTokenValiditySeconds(3600);
	// @formatter:on
	}

	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();

	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore()).authenticationManager(authenticationManager);
	}

	public AuthenticationManager getAuthenticationManager() {
		return authenticationManager;
	}

	@Autowired
	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

}

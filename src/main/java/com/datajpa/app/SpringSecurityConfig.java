package com.datajpa.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;

import com.datajpa.app.auth.handler.LoginSuccessHandler;

@EnableMethodSecurity(securedEnabled = true,prePostEnabled = true)
@Configuration
public class SpringSecurityConfig {
	@Autowired
	private LoginSuccessHandler successHandler;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
		
	// STEP 1 Deshabilitar la seguridad en filter chain	
		@Bean
		public SecurityFilterChain filterChain(HttpSecurity http ) throws Exception {

			 http.authorizeHttpRequests( authorize -> {
				try {
                    authorize
                            .requestMatchers(new MvcRequestMatcher(null, "/"),
                                    new MvcRequestMatcher(null, "/css"),
                                    new MvcRequestMatcher(null, "/js/**"),
                                    new MvcRequestMatcher(null, "/images/**"),
                                    new MvcRequestMatcher(null, "/listar"),
                                    new MvcRequestMatcher(null, "/logout"),
                                    new MvcRequestMatcher(null, "/login")).permitAll()
                            .requestMatchers(new MvcRequestMatcher(null, "/ver/**")).hasAnyRole("USER")
                            .requestMatchers(new MvcRequestMatcher(null, "/upload/**")).hasAnyRole("USER")
                            .requestMatchers(new MvcRequestMatcher(null, "/form/**")).hasAnyRole("ADMIN")
                            .requestMatchers(new MvcRequestMatcher(null, "/eliminar/**")).hasAnyRole("ADMIN")
                            .requestMatchers(new MvcRequestMatcher(null, "/factura/**")).hasAnyRole("ADMIN")
                            .requestMatchers(new MvcRequestMatcher(null, "/logout")).hasAnyRole("ADMIN", "USER")
                            .anyRequest().authenticated()
                            .and()
                            .formLogin(login -> login.successHandler(successHandler).
                            		loginPage("/login").permitAll())
                            
                            .logout(logout -> {
								try {
									logout.permitAll()
									.and()
									.exceptionHandling().accessDeniedPage("/error_403");
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							});
                            ;
				} catch (Exception e) {
	
					e.printStackTrace();
				}
			});
	            
	
			
	        return http.build();
		}

			
	
	@Bean
	public UserDetailsService userDetailsService(AuthenticationManagerBuilder builder) throws Exception {
//	 	PasswordEncoder encoder = passwordEncoder();
//        UserBuilder user = User.builder().passwordEncoder(password->
//		 encoder.encode(password)
//	);
//        builder.inMemoryAuthentication()
//        .withUser(user.username("admin").password("12345").roles("ADMIN","USER"))
//        .withUser(user.username("tony").password("12345").roles("USER"));
         
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User
                .withUsername("tony")
                .password(passwordEncoder().encode("123"))
                .roles("USER")
                .build());
         manager.createUser(User
                    .withUsername("admin")
                    .password(passwordEncoder().encode("123"))
                    .roles("ADMIN","USER")
                    .build());
        
        return  manager;
    }

}

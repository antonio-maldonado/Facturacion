package com.datajpa.app;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;

import com.datajpa.app.auth.handler.LoginSuccessHandler;
import com.datajpa.app.models.service.JpaUserDetailsService;

@EnableMethodSecurity(securedEnabled = true,prePostEnabled = true)
@Configuration
public class SpringSecurityConfig {
	@Autowired
	private LoginSuccessHandler successHandler;
		
//	@Autowired 
//	DataSource dataSource;
//	
	@Autowired
	private JpaUserDetailsService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
		@Bean
		SecurityFilterChain filterChain(HttpSecurity http ) throws Exception {

			 http.authorizeHttpRequests( authorize -> {
				try {
                    authorize
                            .requestMatchers(new MvcRequestMatcher(null, "/"),
                                    new MvcRequestMatcher(null, "/css"),
                                    new MvcRequestMatcher(null, "/js/**"),
                                    new MvcRequestMatcher(null, "/images/**"),
                                    new MvcRequestMatcher(null, "/listar"),
                                    new MvcRequestMatcher(null, "/logout"),
                                    new MvcRequestMatcher(null, "/locale"),
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

//		@Autowired
//		public void configureGlobal(AuthenticationManagerBuilder build) throws Exception {
//			
//		}

//@Bean
//	public UserDetailsService userDetailsService(AuthenticationManagerBuilder build) throws Exception {
////	 	PasswordEncoder encoder = passwordEncoder();
////        UserBuilder user = User.builder().passwordEncoder(password->
////		 encoder.encode(password)
////	);
////        builder.inMemoryAuthentication()
////        .withUser(user.username("admin").password("12345").roles("ADMIN","USER"))
////        .withUser(user.username("tony").password("12345").roles("USER"));
//         
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User
//                .withUsername("tony")
//                .password(passwordEncoder.encode("123"))
//                .roles("USER")
//                .build());
//         manager.createUser(User
//                    .withUsername("admin")
//                    .password(passwordEncoder.encode("123"))
//                    .roles("ADMIN","USER")
//                    .build());
//        
//        return  manager;
//
//		
//    }

@Autowired
public void userDetailsService1(AuthenticationManagerBuilder build) throws Exception {
   build.userDetailsService(userDetailsService)
   .passwordEncoder(passwordEncoder);
}

//	@Bean
//	AuthenticationManager authManager(HttpSecurity http) throws Exception {
//	    return http.getSharedObject(AuthenticationManagerBuilder.class)
//	            .jdbcAuthentication()
//	            .dataSource(dataSource)
//	            .passwordEncoder(passwordEncoder)
//	            .usersByUsernameQuery("select username, password, enabled from users where username=?")
//	            .authoritiesByUsernameQuery("select u.username, a.authority from authorities a inner join users u on (a.user_id=u.id) where u.username=?")
//	            .and().build();
//	}
//	
//	@Bean
//	AuthenticationManager authManager(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception {
//		
//		AuthenticationManagerBuilder authManagerBuilder = http
//				.getSharedObject( AuthenticationManagerBuilder.class);
//		
//		authManagerBuilder
//			.userDetailsService( userDetailsService ) 
//			.passwordEncoder( passwordEncoder );
//		
//		return authManagerBuilder.build();
//	}
//	

}

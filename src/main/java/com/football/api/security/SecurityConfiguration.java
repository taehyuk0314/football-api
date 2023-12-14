package com.football.api.security;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.football.api.common.Constants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {
	
	public static int SESSION_TIMEOUT;
	
	public SecurityConfiguration(@Value("${spring.session.timeout}") int sessionTimeout) {
		SecurityConfiguration.SESSION_TIMEOUT = sessionTimeout;
	}
	
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

	@Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(AbstractHttpConfigurer::disable)
            .headers((headerConfig) ->
            	headerConfig.frameOptions((frameOptionsConfig) ->
            		frameOptionsConfig.sameOrigin()
    			)	
    		)            
            .authorizeHttpRequests((authz) -> authz
    		.requestMatchers("/mypage/**").hasAnyAuthority(Constants.ROLE_MEMBER)
            .anyRequest().permitAll()
            )
            .logout(AbstractHttpConfigurer::disable)
    		.securityContext((securityContext) -> securityContext
				.requireExplicitSave(false)
			);
        return http.build();	
	}
	@Bean
	public WebMvcConfigurer webMvcConfigurer() {
	    return new WebMvcConfigurer() {
	        @Override
	        public void addCorsMappings(CorsRegistry registry) {
	            registry.addMapping("/**")
	            .allowedOriginPatterns("*")
	                    .allowedMethods("*")
	                    .allowedHeaders("*")
	                    .allowCredentials(true)
	                    .maxAge(86400); // 1일
	        }
	    };
	}    
    @Bean
	public CookieSerializer cookieSerializer() {
	    DefaultCookieSerializer cookieSerializer = new DefaultCookieSerializer();
	    cookieSerializer.setUseSecureCookie(true);
	    cookieSerializer.setSameSite("None");
	    return cookieSerializer;
	}	
}

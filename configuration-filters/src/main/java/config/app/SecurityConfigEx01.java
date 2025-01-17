package config.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfigEx01 {
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return new WebSecurityCustomizer() {
            @Override
            public void customize(WebSecurity web) {
                web
                    .ignoring()
                    .requestMatchers(new AntPathRequestMatcher("/assets/**"));
            }
        };
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {        
//        http.formLogin(new Customizer<FormLoginConfigurer<HttpSecurity>>() {
//			
//			@Override
//			public void customize(FormLoginConfigurer<HttpSecurity> t) {
//				
//			}
//		});
    	
    	// 위와 아래는 같은 코드
    	http
    		.formLogin((formLogin) -> {
    			// 여기서 configure 세팅
//    			formLogin
//    				.loginPage("/user/login")
//    				.usernameParameter("email")
//    				.loginProcessingUrl("/auth");
//    			
    			// 뭐 이런 것들
    		});
    	
    	return http.build();
    }
}

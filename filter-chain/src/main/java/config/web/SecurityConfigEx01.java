package config.web;

import filter.SecurityFilterEx01;
import filter.SecurityFilterEx02;
import filter.SecurityFilterEx03;
import filter.SecurityFilterEx04;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfigEx01 {
    @Bean
    public SecurityFilterEx01 securityFilterEx01() {
        return new SecurityFilterEx01();
    }

    @Bean
    public SecurityFilterEx02 securityFilterEx02() {
        return new SecurityFilterEx02();
    }

    @Bean
    public SecurityFilterEx03 securityFilterEx03() {
        return new SecurityFilterEx03();
    }

    @Bean
    public SecurityFilterEx04 securityFilterEx04() {
        return new SecurityFilterEx04();
    }
}

package config.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.authentication.ui.DefaultLoginPageGeneratingFilter;
import org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter;
import org.springframework.security.web.session.DisableEncodeUrlFilter;

@Configuration
public class SecurityConfigEx03 {
    @Bean
    public DisableEncodeUrlFilter disableEncodeUrlFilter() {
        return new DisableEncodeUrlFilter();
    }

    @Bean
    public WebAsyncManagerIntegrationFilter webAsyncManagerIntegrationFilter() {
        return new WebAsyncManagerIntegrationFilter();
    }

    @Bean
    public DefaultLoginPageGeneratingFilter defaultLoginPageGeneratingFilter() {
        return new DefaultLoginPageGeneratingFilter();
    }
}
package config.web;

import config.WebConfig;
import jakarta.servlet.Filter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes={WebConfig.class, SecurityConfigEx02.class})
@WebAppConfiguration
public class SecurityConfigEx02Test {
    private MockMvc mvc;
    private FilterChainProxy filterChainProxy;

    @BeforeEach
    public void setup(WebApplicationContext applicationContext) {
        filterChainProxy = applicationContext.getBean("springSecurityFilterChain", FilterChainProxy.class);
        mvc = MockMvcBuilders
                .webAppContextSetup(applicationContext)
                .addFilter(new DelegatingFilterProxy(filterChainProxy), "/*")
                .build();
    }
}


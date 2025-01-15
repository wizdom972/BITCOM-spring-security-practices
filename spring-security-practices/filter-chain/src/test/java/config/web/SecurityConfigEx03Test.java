package config.web;

import config.WebConfig;
import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
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
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes={WebConfig.class, SecurityConfigEx03.class})
@WebAppConfiguration
public class SecurityConfigEx03Test {
    private MockMvc mvc;
    private FilterChainProxy filterChainProxy;
    @Autowired
    private HttpServletResponse httpServletResponse;

    @BeforeEach
    public void setup(WebApplicationContext applicationContext) {
        filterChainProxy = applicationContext.getBean("springSecurityFilterChain", FilterChainProxy.class);
        mvc = MockMvcBuilders
                .webAppContextSetup(applicationContext)
                .addFilter(new DelegatingFilterProxy(filterChainProxy), "/*")
                .build();
    }
}

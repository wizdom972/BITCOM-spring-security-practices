package config.web;

import config.WebConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes={WebConfig.class, SecurityConfigEx01.class})
@WebAppConfiguration
public class SecurityConfigEx01Test {
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

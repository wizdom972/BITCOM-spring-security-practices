package config.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

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

import config.WebConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { WebConfig.class, SecurityConfigEx03.class })
@WebAppConfiguration
public class SecurityConfigEx03Test {
	private MockMvc mvc;
	private FilterChainProxy filterChainProxy;

	@BeforeEach
	public void setup(WebApplicationContext applicationContext) {
		filterChainProxy = applicationContext.getBean("springSecurityFilterChain", FilterChainProxy.class);
		mvc = MockMvcBuilders.webAppContextSetup(applicationContext)
				.addFilter(new DelegatingFilterProxy(filterChainProxy), "/*").build();
	}

	@Test
	public void testSecurityFilterChains() {
		List<SecurityFilterChain> securityFilterChains = filterChainProxy.getFilterChains();

		assertEquals(2, securityFilterChains.size());
	}

	@Test
	public void testSecurityFilterChain01() {
		SecurityFilterChain securityFilterChain = filterChainProxy.getFilterChains().getFirst();

		assertEquals(0, securityFilterChain.getFilters().size());
	}

	@Test
	public void testSecurityFilterChain02() {
		SecurityFilterChain securityFilterChain = filterChainProxy.getFilterChains().getLast();

		assertEquals(3, securityFilterChain.getFilters().size());
	}

	@Test
	public void testAssets() throws Throwable {
		mvc.perform(get("/assets/images/logo.svg"))
			.andExpect(status().isOk())
			.andExpect(content().contentType("image/svg+xml"))
			.andDo(print());
	}

	@Test
	public void testHello() throws Throwable {
		mvc.perform(get("/hello"))
			.andExpect(status().isOk())
			.andExpect(content().string("world"))
			.andDo(print());
	}
}

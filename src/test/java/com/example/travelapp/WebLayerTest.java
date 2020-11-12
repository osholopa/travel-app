package com.example.travelapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;

//Web layer tests

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class WebLayerTest {

	@Autowired
	private MockMvc mockMvc;

	// Test that root page is open for all
	@Test
	public void testDefaultHeader() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Matkailu-app")));
	}

	// Test that add page redirects if not authenticated
	@Test
	public void testAddPageLoginRedirect() throws Exception {
		this.mockMvc.perform(get("/addjourney")).andDo(print()).andExpect(status().isFound());
	}

	//Test that login URL returns login form
	@Test
	public void testLoginPage() throws Exception {
		this.mockMvc.perform(get("/login")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Kirjaudu sisään")));
	}
	
}

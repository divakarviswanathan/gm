package com.globomart.productcatalogue.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashSet;
import java.util.Set;

import org.json.JSONArray;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.globomart.productcatalogue.rest.entity.ProductDTO;
import com.google.gson.Gson;

/**
 * @author divakar
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

	@Autowired
	private MockMvc mockMvc;

	private static Set<String> productManufacturersSet = new HashSet<>();

	@BeforeClass
	public static void setUp() {
		productManufacturersSet.add("LG");
		productManufacturersSet.add("Godrej");
		productManufacturersSet.add("Sony");
		productManufacturersSet.add("Le");
	}
	@Test
	public void testGetAll() throws Exception {
		MvcResult result = mockMvc.perform(get("/v1/products")).andExpect(status().isOk()).andReturn();
		String content = result.getResponse().getContentAsString();
		JSONArray jsonArray = new JSONArray(content);
		for (int i = 0; i < jsonArray.length(); i++) {
			assert (productManufacturersSet.contains((jsonArray.getJSONObject(i).get("manufacturer"))));
		}
	}

	@Test
	public void testRemoveProduct() throws Exception {
		mockMvc.perform(delete("/v1/products/4")).andExpect(status().isOk());
		MvcResult result = mockMvc.perform(get("/v1/products")).andExpect(status().isOk()).andReturn();
		String content = result.getResponse().getContentAsString();
		assert (!content.contains("Samsung"));
	}

	@Test
	public void testGetProductByType() throws Exception {
		MvcResult result = mockMvc.perform(get("/v1/products/searchByType/?type=fridge")).andExpect(status().isOk())
				.andReturn();
		String content = result.getResponse().getContentAsString();
		JSONArray jsonArray = new JSONArray(content);
		assert (jsonArray.length() == 2);
	}

	@Test
	public void testGetProductByManu() throws Exception {
		MvcResult result = mockMvc.perform(get("/v1/products/searchByManu/?manu=Le")).andExpect(status().isOk())
				.andReturn();
		String content = result.getResponse().getContentAsString();
		JSONArray jsonArray = new JSONArray(content);
		assert (jsonArray.length() == 1);
	}

	@Test
	public void testaddNewProduct() throws Exception {
		ProductDTO pto = new ProductDTO();
		pto.setId(0);
		pto.setDescription("Test Desc");
		pto.setType("Test");
		pto.setName("test-product");
		pto.setType("Test TYpe");
		Gson gson = new Gson();
		mockMvc.perform(
				post("/v1/products").contentType(MediaType.APPLICATION_JSON)
						.content(gson.toJson(pto)))
				.andExpect(status().isOk());
		MvcResult result = mockMvc.perform(get("/v1/products")).andReturn();
		String content = result.getResponse().getContentAsString();
		assert (content.contains("test-product"));
	}
}

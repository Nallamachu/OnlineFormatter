package com.converter.convert;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
//This is Still Under Investigation
public class JsonToYAMLConverter {
	static String str = "{'employees':[{ 'firstName':'John', 'lastName':'Doe' },"
			+ "{ 'firstName':'Anna', 'lastName':'Smith' },"
			+ "{ 'firstName':'Peter', 'lastName':'Jones' }]}";

	public static void main(String[] args) throws JsonProcessingException, IOException {
		System.out.println(asYaml(str));
	}

	public static String asYaml(String jsonString) throws JsonProcessingException, IOException {
		if (jsonString != null) {
			JsonNode jsonNodeTree = new ObjectMapper().readTree(jsonString);
			String jsonAsYaml = new YAMLMapper().writeValueAsString(jsonNodeTree);
			return jsonAsYaml;
		} else {
			return null;
		}
	}
}

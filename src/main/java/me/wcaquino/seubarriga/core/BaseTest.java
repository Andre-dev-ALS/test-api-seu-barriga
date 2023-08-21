package me.wcaquino.seubarriga.core;

import static org.hamcrest.Matchers.lessThan;

import org.junit.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import me.wcaquino.seubarriga.data_provider.ConfigFileReader;

public class BaseTest {

	@BeforeClass
	public static void setup() {
		ConfigFileReader configFile = new ConfigFileReader();
		RestAssured.baseURI = configFile.getApplicationUrl();
		RestAssured.port = configFile.getPort();
		RestAssured.basePath = configFile.getBasePath();
		RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
		reqBuilder.setContentType(configFile.getContentType());
		RestAssured.requestSpecification = reqBuilder.build();

		ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
		resBuilder.expectResponseTime(lessThan(configFile.getMaxWaitTime()));
		RestAssured.responseSpecification = resBuilder.build();

		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
	}

}

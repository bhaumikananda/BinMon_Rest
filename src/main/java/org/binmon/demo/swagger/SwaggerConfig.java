package org.binmon.demo.swagger;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	public static final Contact DEFAULT_CONTACT = new Contact(
		      "Ananda Bhaumik", "http://www.google.com", "bhaumikananda@gmail.com");
		  
		  public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
		      "Binmon API Title", "Binmon API Description", "1.0",
		      "urn:tos", DEFAULT_CONTACT, 
		      "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");

		  private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = 
		      new HashSet<String>(Arrays.asList("application/json",
		          "application/xml"));

    @Bean
    public Docket api() {
     
        	    return new Docket(DocumentationType.SWAGGER_2)
        	            .apiInfo(DEFAULT_API_INFO)
        	            .produces(DEFAULT_PRODUCES_AND_CONSUMES)
        	            .consumes(DEFAULT_PRODUCES_AND_CONSUMES);
    }
    

    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "Spring Boot REST API",
                "Spring Boot REST API for Online Store",
                "1.0",
                "Terms of service",
                new Contact("John Thompson", "https://springframework.guru/about/", "john@springfrmework.guru"),
               "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");
        return apiInfo;
    }
}

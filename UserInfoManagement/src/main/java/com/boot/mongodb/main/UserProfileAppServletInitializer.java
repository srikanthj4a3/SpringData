package com.boot.mongodb.main;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class UserProfileAppServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        builder.sources(UserProfileApp.class);
        return super.configure(builder);
    }

}

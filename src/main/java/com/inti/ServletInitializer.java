package com.inti;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
<<<<<<< HEAD
		return application.sources(Tp1JenkinsApplication.class);
=======
		return application.sources(Td1JenkinsApplication.class);
>>>>>>> branch 'master' of https://github.com/lucieargaud/TP1Jenkins.git
	}

}

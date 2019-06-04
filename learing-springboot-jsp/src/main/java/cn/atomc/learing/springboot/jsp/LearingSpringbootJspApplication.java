package cn.atomc.learing.springboot.jsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class LearingSpringbootJspApplication  extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(LearingSpringbootJspApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(LearingSpringbootJspApplication.class, args);
    }
}

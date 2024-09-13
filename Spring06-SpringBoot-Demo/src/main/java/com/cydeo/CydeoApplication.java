package com.cydeo;

import com.cydeo.model.Comment;
import com.cydeo.service.CommentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
/*
* Spring Project Structure:
src/main/java: Contains application source code.

src/main/resources: Contains non-Java resources.

src/test/java: Contains test code.

mvnw and mvnw.cmd: Maven wrapper scripts. They allow you to build the project even if Maven is not installed on your machine. These scripts automatically download and run the correct version of Maven, ensuring consistency across different environments.

pom.xml: The Maven build specification file.

CydeoApplication.java: The main Spring Boot class that bootstraps the project.

application.properties: Initially empty, but used to specify configuration properties.

static: Stores any static content (images, CSS, JS, etc.).

templates: Contains template files that will be rendered to the browser (e.g., Thymeleaf).
* */
@SpringBootApplication
public class CydeoApplication {

	public static void main(String[] args) {
//		ApplicationContext container= new AnnotationConfigApplicationContext(CydeoApplication.class);
//		ApplicationContext container= SpringApplication.run(AppConfig.class);
		ApplicationContext container= SpringApplication.run(CydeoApplication.class);

		CommentService commentService=container.getBean(CommentService.class);
		Comment comment=new Comment();
		comment.setAuthor("Nick");
		comment.setText("JavaDeveloper Course Will Help You To Become Qualified Full Stack Developer");
		commentService.publishComment(comment);

		// Returning port SpringBoot is running on

//		System.out.println(commentService.portInfo());
	}

}

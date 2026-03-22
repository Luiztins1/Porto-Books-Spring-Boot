package io.github.Luiztins1.com.portobook.pbsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PbsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PbsystemApplication.class, args);
	}

	@GetMapping("hello-word")
	public String helloword(){
		return "Hello word";
	}

}

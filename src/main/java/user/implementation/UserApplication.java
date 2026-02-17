package user.implementation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author pulkitbhatia
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = "user.*")
@EntityScan("user.*")
public class UserApplication {

	public static void main(String[] args) {
		String tmpName=null;
		tmpName.substring(0,1);
		String password = "admin123";  // Hardcoded password
        System.out.println(password);
		SpringApplication.run(UserApplication.class, args);

	}
}

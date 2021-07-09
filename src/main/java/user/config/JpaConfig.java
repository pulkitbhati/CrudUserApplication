package user.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author pulkitbhatia
 *
 */
@Configuration
@EnableJpaRepositories(basePackages = "user.*")
public class JpaConfig {

}

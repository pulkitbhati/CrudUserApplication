package user.user;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import user.entities.User;

/**
 * @author pulkitbhatia
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Serializable> {

}

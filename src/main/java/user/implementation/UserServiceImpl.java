package user.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import user.entities.User;
import user.user.UserRepository;

/**
 * @author pulkitbhatia
 *
 */
@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserRepository userRepository;

	@Transactional
	public User save(User user) {
		User createUser = userRepository.save(user);
		return createUser;
	}

	@Transactional
	public User update(User user) {

		User updateUser = userRepository.save(user);
		return updateUser;
	}

	@Transactional
	public User get(Long id) {
		Optional<User> user = userRepository.findById(id);
		User getUser = user.get();
		return getUser;
	}

	@Transactional
	public void delete(User user) {
		userRepository.delete(user);
	}
}
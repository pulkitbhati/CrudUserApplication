package user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import user.entities.User;
import user.implementation.IUserService;
import user.user.UserRepository;

/**
 * @author pulkitbhatia
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/create")
	public User createUser(@RequestBody User user) {
		User createResponse = userService.save(user);
		return createResponse;
	}

	@PutMapping("/update/{id}")
	public User updateUser(@RequestBody User user, @PathVariable("id") String id) {
		User dbUser = userService.get(Long.valueOf(id));
		dbUser.setUsername(user.getUsername() != null ? user.getUsername() : dbUser.getUsername());
		dbUser.setEmail(user.getEmail() != null ? user.getEmail() : dbUser.getEmail());
		dbUser.setPassword(user.getPassword() != null ? user.getPassword() : dbUser.getPassword());
		dbUser.setName(user.getName() != null ? user.getName() : dbUser.getName());
		dbUser.setId(Long.valueOf(id));

		User updateResponse = userService.update(dbUser);
		return updateResponse;
	}

	@GetMapping("/{id}")
	public User getUser(@PathVariable Long id) {
		User getReponse = userService.get(id);
		return getReponse;
	}

	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") String id) {
		User user = userService.get(Long.valueOf(id));
		userService.delete(user);
		return "Record deleted succesfully";
	}

	@GetMapping("/list")
	public List<User> findAll() {
		return userRepository.findAll();
	}

}

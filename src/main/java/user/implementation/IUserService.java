package user.implementation;

import org.springframework.stereotype.Component;

import user.entities.User;

/**
 * @author pulkitbhatia
 *
 */
@Component
public interface IUserService {

	/**
	 * @param user
	 * @return
	 */
	public User save(User user);

	/**
	 * @param user
	 * @return
	 */
	public User update(User user);

	/**
	 * @param id
	 * @return
	 */
	public User get(Long id);

	/**
	 * @param user
	 */
	public void delete(User user);
}

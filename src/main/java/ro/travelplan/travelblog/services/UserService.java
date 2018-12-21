package ro.travelplan.travelblog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ro.travelplan.travelblog.models.User;

@Service
public interface UserService {
	List<User> findAll();
	User findById(Long id);
	User create(User user);
	User edit(User user);
	void deleteById(Long id);
}

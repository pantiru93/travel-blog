package ro.travelplan.travelblog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ro.travelplan.travelblog.models.Post;

@Service
public interface PostService {
	List<Post> findAll();
	List<Post> findLatest5();
	Post findById(Long id);
	Post create(Post post);
	Post edit(Post post);
	void deleteById(Long id);
}

package ro.travelplan.travelblog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import ro.travelplan.travelblog.models.Post;
import ro.travelplan.travelblog.repositories.PostRepository;

@Service
@Primary
public class PostServiceImpl implements PostService{

	@Autowired
	private PostRepository postRepository;
	
	@Override
	public List<Post> findAll(){
		return this.postRepository.findAll();
	}
	
	@Override
	public Post findById(Long id) {
		return this.postRepository.findById(id).get();
	}

	@Override
	public Post create(Post post) {
		return this.postRepository.save(post);
	}

	@Override
	public Post edit(Post post) {
		return this.postRepository.save(post);
	}

	@Override
	public void deleteById(Long id) {
		this.postRepository.deleteById(id);
	}

	@Override
	public List<Post> findLatest5() {
		// TODO Auto-generated method stub
		return null;
	}
}

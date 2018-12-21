package ro.travelplan.travelblog.controllers;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ro.travelplan.travelblog.models.Post;
import ro.travelplan.travelblog.services.PostService;

@Controller
public class PostController {
	@Autowired
	private PostService postService;
	
	@RequestMapping("/posts")
	public String index(Model model) {
		List<Post> latest5Posts = postService.findAll();
		model.addAttribute("latest5posts",latest5Posts);
		return "post/index";
	}
	
	@RequestMapping("/post/{id}")
	public String post(@PathVariable(value = "id") long id, Model model) {
		Post post = postService.findById(id);
		model.addAttribute("post", post);
		System.out.println(post.getTrips());
		return "post/view";
	}
	
	@GetMapping("/post/create")
    public String showPostCreateForm(Post post, Model model) {
		
	List<Post.PostType> postTypes = Arrays.asList(Post.PostType.values());
		
		model.addAttribute("postTypes", postTypes);
		
        return "post/create";
    }
	
	@PostMapping("/post/create")
	public String addPost(@Valid Post post, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Post.PostType> postTypes = Arrays.asList(Post.PostType.values());
			
			model.addAttribute("postTypes", postTypes);
			return "post/create";
		}

		postService.create(post);
		return "redirect:/post/" + post.getId();
	}
	
	@GetMapping("/post/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Post post = postService.findById(id);
		if (post == null) {
			throw new IllegalArgumentException("Invalid post id: " + id);
		}
		List<Post.PostType> postTypes = Arrays.asList(Post.PostType.values());
		
		model.addAttribute("postTypes", postTypes);
		
		model.addAttribute("post", post);
		return "post/edit";
	}
	
	@PostMapping("/post/edit/{id}")
	public String updatePost(@PathVariable("id") long id, @Valid Post post, 
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        post.setId(id);
	        return "post/edit";
	    }
	         
	    postService.create(post);
	    return "redirect:/post/" + post.getId();
	}
}

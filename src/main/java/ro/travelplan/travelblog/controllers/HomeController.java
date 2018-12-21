package ro.travelplan.travelblog.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ro.travelplan.travelblog.models.Post;
import ro.travelplan.travelblog.services.PostService;

@Controller
public class HomeController {
	@Autowired
	private PostService postService;
	
	@RequestMapping("/")
	public String index(Model model) {
		List<Post> latest5Posts = postService.findAll();
		model.addAttribute("latest5posts",latest5Posts);
		return "index";
	}
}

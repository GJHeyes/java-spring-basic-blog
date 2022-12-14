package com.pluralsight.blog;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pluralsight.blog.data.PostRepository;
import com.pluralsight.blog.model.Post;

import org.springframework.ui.ModelMap;

@Controller
public class BlogController {

    private PostRepository postRepository;

    public BlogController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @RequestMapping("post/{id}")
    public String postDetails(@PathVariable Long id, ModelMap modelMap) {
        Post blogId = postRepository.findById(id);
        modelMap.put("post", blogId);
        return "post-details";
    }

    @RequestMapping("/")
    public String listPosts(ModelMap modelMap) {

        List<Post> allPosts = postRepository.getAllPosts();
        modelMap.put("posts", allPosts);
        return "home";
    }

}

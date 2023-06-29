package com.springboot.restfulwebservices.user;

import com.springboot.restfulwebservices.jpa.UserRepository;
import com.springboot.restfulwebservices.post.Post;
import com.springboot.restfulwebservices.post.PostRepository;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJpaResource {
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public UserJpaResource(UserRepository repository, PostRepository postJpaRepository, UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> retrieveUserById(@PathVariable Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("id: " + id));
        EntityModel<User> entityModel = EntityModel.of(user);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userRepository.deleteById(id);
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrieveAllPosts(@PathVariable Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("id: " + id));
        return user.getPosts();
    }

    @GetMapping("/jpa/users/{id}/posts/{post_id}")
    public Post getPostById(@PathVariable Integer post_id) {
//        User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException("id: " + id));
        return postRepository.findById(post_id).orElseThrow(() -> new UserNotFoundException("post id: " + post_id));
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Post> createPostForUser(@PathVariable Integer id, @Valid @RequestBody Post post) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("id: " + id));
        post.setUser(user);
        Post savedPost = postRepository.save(post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPost.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}

package com.Architecture_Website.Architecture_Website.Controller;

import com.Architecture_Website.Architecture_Website.Model.PostEntity;
import com.Architecture_Website.Architecture_Website.Request.PostRequest;
import com.Architecture_Website.Architecture_Website.Response.PostResponse;
import com.Architecture_Website.Architecture_Website.Service.PostService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostController {
    private final PostService postService;

    @PostMapping
    public ResponseEntity<?> createPost(
            @RequestBody PostRequest postRequest
    ){
        postService.save(PostEntity.builder()
                        .title(postRequest.title())
                        .viewQuantity(postRequest.viewQuantity())
                        .titleImage(postRequest.titleImage())
                        .content(postRequest.content())
                        .status(postRequest.status())
                        .slug(postRequest.slug())
                        .description(postRequest.description())
                .build());
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<PostResponse> getAllPosts(){
        return postService.getAllPosts();
    }

    @DeleteMapping("{slug}")
    public ResponseEntity<?> deletePost(@PathVariable String slug){
        postService.deleteBySlug(slug);
        return ResponseEntity.ok().build();
    }
}

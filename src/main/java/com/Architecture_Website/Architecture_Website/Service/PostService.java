package com.Architecture_Website.Architecture_Website.Service;

import com.Architecture_Website.Architecture_Website.Controller.PostController;
import com.Architecture_Website.Architecture_Website.Mapper.PostMapper;
import com.Architecture_Website.Architecture_Website.Model.PostEntity;
import com.Architecture_Website.Architecture_Website.Repository.PostRepository;
import com.Architecture_Website.Architecture_Website.Response.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final PostMapper postMapper;

    public void save(PostEntity postEntity) {
        postRepository.save(postEntity);
    }

    public List<PostResponse> getAllPosts() {
        return postRepository.getAllPost()
                .stream()
                .map(postMapper::toPostResponse)
                .toList();
    }


    public void deleteBySlug(String slug) {
        postRepository.deletePostEntitiesBySlug(slug);
    }
}

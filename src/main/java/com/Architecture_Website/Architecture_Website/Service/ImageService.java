package com.Architecture_Website.Architecture_Website.Service;

import com.Architecture_Website.Architecture_Website.Model.ImageEntity;
import com.Architecture_Website.Architecture_Website.Model.PostEntity;
import com.Architecture_Website.Architecture_Website.Repository.ImageRepository;
import com.Architecture_Website.Architecture_Website.Repository.PostRepository;
import lombok.RequiredArgsConstructor;
import com.Architecture_Website.Architecture_Website.Model.ProjectEntity;
import com.Architecture_Website.Architecture_Website.Repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;
    private final PostRepository postRepository;
    private final ProjectRepository projectRepository;

    public void uploadImage(UUID postId, String url) {
        PostEntity post = postRepository.getReferenceById(postId);
        imageRepository.save(ImageEntity.builder()
                .post(post)
                .url(url)
                .build());
    }
}

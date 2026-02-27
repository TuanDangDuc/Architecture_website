package com.Architecture_Website.Architecture_Website.Service;

import com.Architecture_Website.Architecture_Website.Model.ImageEntity;
import com.Architecture_Website.Architecture_Website.Model.PostEntity;
import com.Architecture_Website.Architecture_Website.Repository.ImageRepository;
import com.Architecture_Website.Architecture_Website.Repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;
    private final PostRepository postRepository;

    public void uploadImage(UUID postId, String url) {
        PostEntity post = postRepository.getReferenceById(postId);
        imageRepository.save(ImageEntity.builder()
                        .post(post)
                        .url(url)
                .build());
    }
}

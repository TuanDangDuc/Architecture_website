package com.Architecture_Website.Architecture_Website.Service;

import org.springframework.stereotype.Repository;
import com.Architecture_Website.Architecture_Website.Model.ImageEntity;
import com.Architecture_Website.Architecture_Website.Model.ProjectEntity;
import com.Architecture_Website.Architecture_Website.Repository.ImageRepository;
import com.Architecture_Website.Architecture_Website.Repository.ProjectRepository;
import com.Architecture_Website.Architecture_Website.Request.ImageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;
    private final ProjectRepository projectRepository;

    public ImageEntity addImageToProject(ImageRequest request) {
        ProjectEntity project = projectRepository.findById(request.projectId())
                .orElseThrow(() -> new RuntimeException("Project not found"));

        ImageEntity image = ImageEntity.builder()
                .url(request.url())
                .project(project)
                .build();

        return imageRepository.save(image);
    }
}

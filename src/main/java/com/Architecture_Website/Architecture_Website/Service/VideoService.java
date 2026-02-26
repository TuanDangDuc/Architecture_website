package com.Architecture_Website.Architecture_Website.Service;

import com.Architecture_Website.Architecture_Website.Model.ProjectEntity;
import com.Architecture_Website.Architecture_Website.Model.VideoEntity;
import com.Architecture_Website.Architecture_Website.Repository.ProjectRepository;
import com.Architecture_Website.Architecture_Website.Repository.VideoRepository;
import com.Architecture_Website.Architecture_Website.Request.VideoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VideoService {
    private final VideoRepository videoRepository;
    private final ProjectRepository projectRepository;

    public VideoEntity addVideoToProject(VideoRequest request) {
        ProjectEntity project = projectRepository.findById(request.projectId())
                .orElseThrow(() -> new RuntimeException("Project not found"));

        VideoEntity video = VideoEntity.builder()
                .title(request.title())
                .project(project)
                .build();

        return videoRepository.save(video);
    }
}

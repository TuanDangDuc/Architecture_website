package com.Architecture_Website.Architecture_Website.Service;

import com.Architecture_Website.Architecture_Website.Model.Enum.Status;
import com.Architecture_Website.Architecture_Website.Model.ImageEntity;
import com.Architecture_Website.Architecture_Website.Model.ProjectEntity;
import com.Architecture_Website.Architecture_Website.Repository.AccountRepository;
import com.Architecture_Website.Architecture_Website.Repository.CategoryRepository;
import com.Architecture_Website.Architecture_Website.Repository.ImageRepository;
import com.Architecture_Website.Architecture_Website.Repository.ProjectRepository;
import com.Architecture_Website.Architecture_Website.Request.ProjectRequest;
import com.Architecture_Website.Architecture_Website.Request.UpdateProjectRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final CategoryRepository categoryRepository;
    private final AccountRepository accountRepository;
    private final ImageRepository imageRepository;

    public ProjectEntity createProject(ProjectRequest request) {
        // CategoryEntity category = categoryRepository.findById(request.categoryId())
        // .orElseThrow(() -> new RuntimeException("Category not found"));

        ProjectEntity project = ProjectEntity.builder()
                .name(request.name())
                .area(request.area())
                .constructionCost(request.constructionCost())
                .style(request.style())
                .titleImage(request.titleImage())
                .type(request.type())
                .slug(request.slug())
                .content(request.content())
                .status(request.status())
                .category(categoryRepository.getReferenceById(request.categoryId()))
                .owner(accountRepository.getReferenceById(request.adminId()))
                .build();

        ProjectEntity savedProject = projectRepository.save(project);

        if (request.images() != null && !request.images().isEmpty()) {
            List<ImageEntity> imageEntities = request.images().stream().map(url -> ImageEntity.builder()
                    .url(url)
                    .project(savedProject)
                    .build()).toList();
            imageRepository.saveAll(imageEntities);
        }

        return savedProject;
    }

    public List<ProjectEntity> getAllProjects() {
        Status st = Status.ACTIVE;
        return projectRepository.getAll(st);
    }

    public ProjectEntity getProjectById(UUID id) {
        return projectRepository.findById(id).orElseThrow(() -> new RuntimeException("Project not found"));
    }

    public void deleById(UUID id) {
        projectRepository.deleteById(id);
    }

    public List<ProjectEntity> getAllProjectByAdminId(UUID id) {
        return projectRepository.getProjectByAdminId(id);
    }

    public ResponseEntity<?> update(UpdateProjectRequest request) {
        ProjectEntity project = ProjectEntity.builder()
                .id(request.id())
                .name(request.name())
                .area(request.area())
                .constructionCost(request.constructionCost())
                .style(request.style())
                .titleImage(request.titleImage())
                .type(request.type())
                .slug(request.slug())
                .content(request.content())
                .status(request.status())
                .category(categoryRepository.getReferenceById(request.categoryId()))
                .build();

        projectRepository.update(project);

        if (request.images() != null) {
            List<ImageEntity> existImages = imageRepository.getImageEntitiesByProjectId(project.getId());
            imageRepository.deleteAll(existImages);

            List<ImageEntity> newImages = request.images().stream().map(url -> ImageEntity.builder()
                    .url(url)
                    .project(project)
                    .build()).toList();
            imageRepository.saveAll(newImages);
        }

        return ResponseEntity.ok().build();
    }

    public List<ProjectEntity> getProjectBySubCategoryId(UUID id) {
        return projectRepository.getProjectBySubCategoryId(id);
    }
}

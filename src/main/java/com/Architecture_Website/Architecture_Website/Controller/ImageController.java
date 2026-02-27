package com.Architecture_Website.Architecture_Website.Controller;

import com.Architecture_Website.Architecture_Website.Model.ImageEntity;
import com.Architecture_Website.Architecture_Website.Request.ImageRequest;
import com.Architecture_Website.Architecture_Website.Service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/image")
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;

    @PostMapping("/add-to-project")
    public ResponseEntity<ImageEntity> addImageToProject(@RequestBody ImageRequest request) {
        return ResponseEntity.ok(imageService.addImageToProject(request));
    }
}

package com.Architecture_Website.Architecture_Website.Controller;

import com.Architecture_Website.Architecture_Website.Model.VideoEntity;
import com.Architecture_Website.Architecture_Website.Request.VideoRequest;
import com.Architecture_Website.Architecture_Website.Service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/video")
@RequiredArgsConstructor
public class VideoController {
    private final VideoService videoService;

    @PostMapping("/add-to-project")
    public ResponseEntity<VideoEntity> addVideoToProject(@RequestBody VideoRequest request) {
        return ResponseEntity.ok(videoService.addVideoToProject(request));
    }
}

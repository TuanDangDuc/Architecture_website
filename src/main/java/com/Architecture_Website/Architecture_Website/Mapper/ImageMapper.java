package com.Architecture_Website.Architecture_Website.Mapper;

import com.Architecture_Website.Architecture_Website.Model.ImageEntity;
import com.Architecture_Website.Architecture_Website.Response.ImageResponse;
import jakarta.persistence.Column;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public class ImageMapper {
    public ImageResponse toImageResponse(ImageEntity entity) {
        return ImageResponse.builder()
                .id(entity.getId())
                .url(entity.getUrl())
                .build();
    }
}

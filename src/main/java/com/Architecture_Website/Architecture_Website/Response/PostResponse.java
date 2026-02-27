package com.Architecture_Website.Architecture_Website.Response;

import com.Architecture_Website.Architecture_Website.Model.Enum.Status;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import lombok.Builder;

@Builder
public record PostResponse(
        String title,
        Integer viewQuantity,
        String titleImage,
        @Column(columnDefinition = "TEXT")
        String content,
        Status status,
        String slug,
        @Column(columnDefinition = "TEXT")
        String description
) {
}

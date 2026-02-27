package com.Architecture_Website.Architecture_Website.Request;

import com.Architecture_Website.Architecture_Website.Model.Enum.Status;
import com.Architecture_Website.Architecture_Website.Model.PostEntity;
import jakarta.persistence.Column;

public record PostRequest(
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

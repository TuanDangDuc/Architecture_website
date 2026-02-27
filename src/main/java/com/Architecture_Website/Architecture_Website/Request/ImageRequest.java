package com.Architecture_Website.Architecture_Website.Request;

import lombok.Data;

import java.util.UUID;

@Data
public class ImageRequest {
    UUID postId;
    String url;
}

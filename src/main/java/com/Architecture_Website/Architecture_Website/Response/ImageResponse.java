package com.Architecture_Website.Architecture_Website.Response;

import lombok.Builder;

import java.util.UUID;

@Builder
public record ImageResponse(
        UUID id,
        String url
) {
}

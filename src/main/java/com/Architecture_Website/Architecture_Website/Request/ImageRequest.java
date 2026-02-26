package com.Architecture_Website.Architecture_Website.Request;

import java.util.UUID;

public record ImageRequest(
        String url,
        UUID projectId
) {
}

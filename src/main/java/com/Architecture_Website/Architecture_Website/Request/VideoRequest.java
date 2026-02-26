package com.Architecture_Website.Architecture_Website.Request;

import java.util.UUID;

public record VideoRequest(
        String title,
        UUID projectId) {
}

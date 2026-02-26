package com.Architecture_Website.Architecture_Website.Request;

import java.util.UUID;

public record CategoryRequest(
        String name,
        UUID parentId
) {
}

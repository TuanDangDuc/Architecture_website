package com.Architecture_Website.Architecture_Website.Mapper;

import com.Architecture_Website.Architecture_Website.Model.PostEntity;
import com.Architecture_Website.Architecture_Website.Response.PostResponse;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {
    public PostResponse toPostResponse(PostEntity postEntity) {
        return PostResponse.builder()
                .title(postEntity.getTitle())
                .viewQuantity(postEntity.getViewQuantity())
                .titleImage(postEntity.getTitleImage())
                .content(postEntity.getContent())
                .status(postEntity.getStatus())
                .description(postEntity.getDescription())
                .slug(postEntity.getSlug())
                .build();
    }
}

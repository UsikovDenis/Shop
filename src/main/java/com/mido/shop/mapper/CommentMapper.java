package com.mido.shop.mapper;

import com.mido.shop.api.dto.CommentDto;
import com.mido.shop.domain.entity.Comment;
import com.mido.shop.mapper.decorator.CommentMapperDecorator;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;



@Mapper
@DecoratedWith(CommentMapperDecorator.class)
public interface CommentMapper {

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "product", ignore = true)
    Comment toEntity(CommentDto commentDto);

    @Mapping(target = "userId", source = "comment.user.id")
    @Mapping(target = "userName", source = "comment.user.name")
    CommentDto toDto(Comment comment);
}

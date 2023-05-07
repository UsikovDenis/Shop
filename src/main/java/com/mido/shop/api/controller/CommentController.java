package com.mido.shop.api.controller;

import com.mido.shop.api.dto.CommentDto;
import com.mido.shop.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/user/{userId}/product/{productId}")
    public CommentDto commentSave(
            @PathVariable UUID userId,
            @PathVariable UUID productId,
            @RequestBody CommentDto commentDto
    ) {
        commentDto.setId(null);
        commentDto.setUserId(userId);
        commentDto.setProductId(productId);
        return commentService.saveOrUpdate(commentDto);
    }

}

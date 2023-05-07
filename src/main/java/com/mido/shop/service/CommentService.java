package com.mido.shop.service;

import com.mido.shop.api.dto.CommentDto;
import com.mido.shop.domain.repository.CommentRepository;
import com.mido.shop.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    @Transactional
    public CommentDto saveOrUpdate(CommentDto commentDto){
        return commentMapper.toDto(
                commentRepository.save(
                        commentMapper.toEntity(commentDto)));
    }

}

package com.mido.shop.mapper.decorator;

import com.mido.shop.api.dto.CommentDto;
import com.mido.shop.domain.entity.Comment;
import com.mido.shop.domain.entity.Product;
import com.mido.shop.domain.entity.User;
import com.mido.shop.domain.repository.ProductRepository;
import com.mido.shop.domain.repository.UserRepository;
import com.mido.shop.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class CommentMapperDecorator implements CommentMapper {

    @Autowired
    @Qualifier("delegate")
    private CommentMapper commentMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;


    @Override
    public Comment toEntity(CommentDto commentDto) {
        User user = userRepository.findById(commentDto.getUserId())
                .orElseThrow(() -> new RuntimeException());

        Product product = productRepository.findById(commentDto.getProductId())
                .orElseThrow(() -> new RuntimeException());

        Comment comment = commentMapper.toEntity(commentDto);
        comment.setUser(user);
        comment.setProduct(product);
        return comment;
    }
}

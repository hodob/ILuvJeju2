package com.finalprj.ILuvJeju.service.impl.review;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finalprj.ILuvJeju.domain.Member;
import com.finalprj.ILuvJeju.domain.review.Review;
import com.finalprj.ILuvJeju.domain.review.ReviewComment;
import com.finalprj.ILuvJeju.dto.review.ReviewCommentDTO;
import com.finalprj.ILuvJeju.repository.MemberRepository;
import com.finalprj.ILuvJeju.repository.review.ReviewCommentRepository;
import com.finalprj.ILuvJeju.repository.review.ReviewRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewCommentServiceImpl {

    @Autowired
    ReviewCommentRepository repository;
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<ReviewCommentDTO> getComments(Long reviewNo) {
        List<ReviewComment> commentEntity = repository.findAllByReview_ReviewNo(reviewNo);
        List<ReviewCommentDTO> comments = modelMapper.map(commentEntity, new TypeToken<List<ReviewCommentDTO>>() {
        }.getType());

        return comments;
    }

    public ReviewComment insertComment(ReviewCommentDTO dto) {
        dto.setWDate(LocalDateTime.now());
        ReviewComment comment = modelMapper.map(dto, ReviewComment.class);

        System.out.println("==================================="+dto.toString());

        Review review = reviewRepository.findByReviewNo(comment.getReview().getReviewNo());
        Member member = memberRepository.findOneById(comment.getMember().getId());

        dto.setReview(review);
        dto.setMember(member);
        return repository.save(comment);
    }

    @Transactional
    public void updateComment(Long commentNo, ReviewCommentDTO dto) {
        ReviewComment comment = repository.findByCommentNo(commentNo);
        comment.setWDate(LocalDateTime.now());
        comment.setContent(dto.getContent());

    }

    public void deleteComment(Long commentNo) {
        repository.deleteById(commentNo);
    }

}

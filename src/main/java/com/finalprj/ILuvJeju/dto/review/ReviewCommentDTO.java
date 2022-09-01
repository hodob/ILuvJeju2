package com.finalprj.ILuvJeju.dto.review;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

import com.finalprj.ILuvJeju.domain.Member;
import com.finalprj.ILuvJeju.domain.review.Review;

@Getter
@Setter
@ToString
public class ReviewCommentDTO {
    private Long commentNo;
    private Review review;
    private Member member;
    private String content;
    private LocalDateTime wDate;
}

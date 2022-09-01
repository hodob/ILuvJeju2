package com.finalprj.ILuvJeju.dto;
import com.querydsl.core.annotations.QueryProjection;

import lombok.Getter;
import lombok.Setter;



@Getter @Setter
public class MainItemDto {

    private Long id;
    private String itemNm;
    private String itemDetail;
    private String imgUrl;
    private Integer price;

    //DTO의 생성자에 @QueryProjection을 붙여주어야 합니다.
    @QueryProjection
    public MainItemDto(Long id, String itemNm, String itemDetail, String imgUrl,Integer price){
        this.id = id;
        this.itemNm = itemNm;
        this.itemDetail = itemDetail;
        this.imgUrl = imgUrl;
        this.price = price;
    }

}
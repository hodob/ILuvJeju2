package com.finalprj.ILuvJeju.repository;

import com.finalprj.ILuvJeju.dto.ItemSearchDto;
import com.finalprj.ILuvJeju.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.finalprj.ILuvJeju.dto.MainItemDto;

public interface ItemRepositoryCustom {

    Page<Item> getAdminItemPage(ItemSearchDto itemSearchDto, Pageable pageable);

    Page<MainItemDto> getMainItemPage(ItemSearchDto itemSearchDto, Pageable pageable);

}
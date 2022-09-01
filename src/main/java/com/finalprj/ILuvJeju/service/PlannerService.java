package com.finalprj.ILuvJeju.service;

import java.text.ParseException;
import java.util.List;

import com.finalprj.ILuvJeju.domain.Planner;
import com.finalprj.ILuvJeju.dto.PlannerDTO;

/*
 * 플래너 service
 *
 * @Author 백정연
 * @Date 2021/08/07
 */

public interface PlannerService {
    PlannerDTO insertPlanner(PlannerDTO dto) throws ParseException;
    List<PlannerDTO> selectPlanners(String id);
    PlannerDTO selectPlanner(Long plannerNo);
    void deletePlanner(Long plannerNo);

    default Planner dtoToEntity(PlannerDTO dto) throws ParseException {
        Planner entity = null;

        if(dto.getPlannerNo() != null){     // 플래너 수정할 경우 플래너 번호도 같이 전달
            entity = Planner.builder()
                    .plannerNo(dto.getPlannerNo())
                    .id(dto.getId())
                    .title(dto.getTitle())
                    .fDate(dto.getFDate())
                    .lDate(dto.getLDate())
                    .intro(dto.getIntro())
                    .wDate(dto.getWDate())
                    .build();
        }else {                         // 플래너 생성할 경우 dto에는 플래너 번호가 없기에 제외
            entity = Planner.builder()
                    .id(dto.getId())
                    .title(dto.getTitle())
                    .fDate(dto.getFDate())
                    .lDate(dto.getLDate())
                    .intro(dto.getIntro())
                    .build();
        }
        return entity;
    }

    default PlannerDTO entityToDto(Planner planner) {
        PlannerDTO dto = PlannerDTO.builder()
                .plannerNo(planner.getPlannerNo())
                .id(planner.getId())
                .title(planner.getTitle())
                .intro(planner.getIntro())
                .fDate(planner.getFDate())
                .lDate(planner.getLDate())
                .wDate(planner.getWDate())
                .build();
        return dto;
    }
}

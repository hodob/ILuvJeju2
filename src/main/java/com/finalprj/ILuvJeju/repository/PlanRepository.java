package com.finalprj.ILuvJeju.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.finalprj.ILuvJeju.domain.Plan;

import java.util.Date;
import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Long> {
    List<Plan> findAllByPlannerNoAndDayBetweenOrderByPlanNo(Long plannerNo, Date start,Date end);
    List<Plan> findAllByPlannerNoOrderByPlanNo(Long plannerNo);
    @Transactional
    void deleteAllByPlannerNo(Long plannerNo);
    @Transactional
    void deleteByPlanNo(Long planNo);
}

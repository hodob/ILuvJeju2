package com.finalprj.ILuvJeju.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.finalprj.ILuvJeju.domain.Planner;

import java.util.List;

@Repository
public interface PlannerRepository extends JpaRepository<Planner, Long> {
    List<Planner> findAllByIdOrderByPlannerNoDesc(String id);
    Planner findByPlannerNo(Long plannerNo);
    @Transactional
    void deleteByPlannerNo(Long plannerNo);
}

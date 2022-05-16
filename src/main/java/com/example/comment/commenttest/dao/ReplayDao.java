package com.example.comment.commenttest.dao;

import com.example.comment.commenttest.model.Replay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplayDao extends JpaRepository<Replay,Long> {
    //找到所有对某评论的回复 或者对 某回复 的所有回复
    List<Replay> findByTorridAndTorr(Long torrid, int tr);
}

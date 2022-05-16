package com.example.comment.commenttest.service;

import com.example.comment.commenttest.dao.ReplayDao;
import com.example.comment.commenttest.model.Replay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplayService {
    @Autowired
    ReplayDao replayDao;
    //插入一条回复
    public Replay InsertOneReplay(Replay r){
        return replayDao.save(r);
    }
    //找到对某个评论的所有回复
    public List<Replay> FindAllByTid(Long tid){
        return replayDao.findByTorridAndTorr(tid,1);
    }
    //找到对某个回复的所有回复
    public List<Replay> FindAllByRid(Long rid){
        return replayDao.findByTorridAndTorr(rid,0);
    }

}

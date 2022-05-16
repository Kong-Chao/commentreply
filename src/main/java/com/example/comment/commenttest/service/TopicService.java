package com.example.comment.commenttest.service;

import com.example.comment.commenttest.dao.TopicDao;
import com.example.comment.commenttest.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
    @Autowired
    TopicDao topicDao;
    //存入一条评论
    public Topic InsertOneTopic(Topic t){
        return topicDao.save(t);
    }
    //查找所有评论
    public List<Topic> FindAllTopic(){
        return topicDao.findAll();
    }
}

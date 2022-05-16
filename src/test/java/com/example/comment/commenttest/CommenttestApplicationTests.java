package com.example.comment.commenttest;

import com.example.comment.commenttest.model.Replay;
import com.example.comment.commenttest.model.Topic;
import com.example.comment.commenttest.service.ReplayService;
import com.example.comment.commenttest.service.TopicService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommenttestApplicationTests {

    @Autowired
    ReplayService replayService;
    @Autowired
    TopicService topicService;

    @Test
    public void contextLoads() {
        topicService.InsertOneTopic(new Topic( 1L,"小红","1.jpg","这是第一个评论","2018-01-02"));
        topicService.InsertOneTopic(new Topic( 2L,"小黄","1.jpg","这是第二个评论","2018-01-02"));
        topicService.InsertOneTopic(new Topic( 3L,"小绿","1.jpg","这是第三个评论","2018-01-02"));
        topicService.InsertOneTopic(new Topic( 4L,"小黑","1.jpg","这是第四个评论","2018-01-02"));
        topicService.InsertOneTopic(new Topic( 1L,"小红","1.jpg","这是第五个评论","2018-01-02"));
        replayService.InsertOneReplay(new Replay(1L,1,2L,1L,"小黄","小红","1.jpg","这是第一条回复","2018-01-02"));
        replayService.InsertOneReplay(new Replay(1L,1,3L,1L,"小绿","小红","1.jpg","这是第二条回复","2018-01-02"));
        replayService.InsertOneReplay(new Replay(1L,0,4L,2L,"小黑","小黄","1.jpg","这是第一.一条回复","2018-01-02"));
        replayService.InsertOneReplay(new Replay(3L,0,2L,4L,"小黄","小黑","1.jpg","这是第一.一.一条回复","2018-01-02"));
        replayService.InsertOneReplay(new Replay(4L,0,4L,2L,"小黑","小黄","1.jpg","这是第一.一.一.一条回复","2018-01-02"));
        replayService.InsertOneReplay(new Replay(4L,0,1L,1L,"小红","小黄","1.jpg","这也是第一.一.一.一条回复","2018-01-02"));
        replayService.InsertOneReplay(new Replay(3L,1,2L,3L,"小黄","小绿","1.jpg","这是第三条回复","2018-01-02"));
    }
}

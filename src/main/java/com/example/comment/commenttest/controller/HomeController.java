package com.example.comment.commenttest.controller;

import com.example.comment.commenttest.model.Replay;
import com.example.comment.commenttest.model.Topic;
import com.example.comment.commenttest.node.ReplayNode;
import com.example.comment.commenttest.node.TopicNode;
import com.example.comment.commenttest.service.ReplayService;
import com.example.comment.commenttest.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class HomeController {

    @Autowired
    ReplayService replayService;
    @Autowired
    TopicService topicService;
    //插入链表 参数分别代表需要待插入的节点list 和这些节点的父亲是谁
    public boolean AddReplayNode(List<Replay> relists,ReplayNode freplay){
        //为空就直接返回
        if(relists.size()==0)return false;
        //挨个遍历list中的节点信息，然后如果节点还有孩子就继续递归
        for(Replay re:relists){
            ReplayNode newreplaynode = new ReplayNode();
            newreplaynode.setReplay(re);
            freplay.getListreplay().add(newreplaynode);
            List<Replay> replayList = new ArrayList<>();
            replayList = replayService.FindAllByRid(re.getRid());
            //有孩子就继续递归，有没有孩子这里是统一进入递归才判断，也可以来个if else
            AddReplayNode(replayList,newreplaynode);
        }
        return false;
    }
    //展示出来 参数表示需要展示的节点list
    public void ShowReplayNodes(List<ReplayNode> replayNodes){
        if(replayNodes.size()==0)return;
        for(ReplayNode temp: replayNodes){
            System.out.println(temp.getReplay().toString());
            ShowReplayNodes(temp.getListreplay());
        }
    }
    @GetMapping(value = "/test")
    public String getHomePostsByPage(Model model) {
        List<Topic> topics = new ArrayList<>();
        topics = topicService.FindAllTopic();//得到所有评论
        List<TopicNode> topicNodes = new ArrayList<>();//装下所有评论的List
        for(Topic temp : topics){
            TopicNode topicNode = new TopicNode();
            topicNode.setTopic(temp);//把每个Topic变成TopicNode
            Long tid = temp.getTid();
            //找到是这个评论的所有回复
            List<Replay> thisreplays = new ArrayList<>();
            thisreplays = replayService.FindAllByTid(tid);
            //遍历每个第一层回复
            for(Replay re:thisreplays){
                ReplayNode replayNode = new ReplayNode();
                replayNode.setReplay(re);
                topicNode.getReplays().add(replayNode);
                //得到回复的回复
                List<Replay> replayList = new ArrayList<>();
                replayList = replayService.FindAllByRid(re.getRid());
                //递归
                AddReplayNode(replayList,replayNode);
            }
            topicNodes.add(topicNode);
        }
        //输出
        for(TopicNode tnode:topicNodes){
            //得到评论
            System.out.println(tnode.getTopic().toString());
            ShowReplayNodes(tnode.getReplays());
        }
        model.addAttribute("topics",topicNodes);
       return "index";
    }
}

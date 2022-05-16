package com.example.comment.commenttest.node;

import com.example.comment.commenttest.model.Topic;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TopicNode {
    private Topic topic;
    private List<ReplayNode> replays = new ArrayList<>();
}

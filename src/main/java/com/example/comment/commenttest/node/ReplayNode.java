package com.example.comment.commenttest.node;

import com.example.comment.commenttest.model.Replay;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ReplayNode {
    private Replay replay;
    private List<ReplayNode> listreplay = new ArrayList<>();
}

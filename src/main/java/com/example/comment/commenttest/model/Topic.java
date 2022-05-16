package com.example.comment.commenttest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "topic")
@AllArgsConstructor
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long tid;//主键ID
    private Long uid;//用户ID
    @Column(length = 50)
    private String uname;//用户名
    @Column(length = 255)
    private String uheadurl;//用户头像
    @Column(length = 800)
    private String tcontent;//评论内容
    @Column(length = 20)
    private String ttime;//评论时间

    public Topic() {
    }
    public Topic(Long uid, String uname, String uheadurl, String tcontent, String ttime) {
        this.uid = uid;
        this.uname = uname;
        this.uheadurl = uheadurl;
        this.tcontent = tcontent;
        this.ttime = ttime;
    }
}

package com.example.comment.commenttest.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "replay")
//@AllArgsConstructor  //有参构造
//@NoArgsConstructor  //无参构造
public class Replay {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long rid;
    private Long torrid;//评论id或者回复id  就是有可能是回复评论，也可能是给回复的回复
    private int torr;//用来判断上面的哪种情况：1表示回复评论 0表示回复回复
    private Long uid;//用户ID
    private Long touid;//目标用户id 给谁回复
    @Column(length = 50)
    private String uname;//用户名
    @Column(length = 50)
    private String touname;//目标用户名
    @Column(length = 255)
    private String uheadurl;//用户头像
    @Column(length = 800)
    private String rcontent;//回复内容
    @Column(length = 20)
    private String rtime;//回复时间

    public Replay() {
    }
    public Replay(Long torrid, int torr, Long uid, Long touid, String uname, String touname, String uheadurl, String rcontent, String rtime) {
        this.torrid = torrid;
        this.torr = torr;
        this.uid = uid;
        this.touid = touid;
        this.uname = uname;
        this.touname = touname;
        this.uheadurl = uheadurl;
        this.rcontent = rcontent;
        this.rtime = rtime;
    }
}

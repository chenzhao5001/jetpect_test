package com.cz.jetpack.study.model;
import java.io.Serializable;

public class User implements Serializable {
    public int id;
    public long userId;
    public String name;
    public String avatar;
    public String description;
    public int likeCount;
    public int topCommentCount;
    public int followCount;
    public int followerCount;
    public String qqOpenId;
    public long expires_time;
    public int score;
    public int historyCount;
    public int commentCount;
    public int favoriteCount;
    public int feedCount;
    public boolean hasFollow;
}

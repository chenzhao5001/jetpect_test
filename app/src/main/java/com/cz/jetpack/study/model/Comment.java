package com.cz.jetpack.study.model;

import java.io.Serializable;

public class Comment implements Serializable {
    public static final int COMMENT_TYPE_VIDEO = 3;
    public static final int COMMENT_TYPE_IMAGE_TEXT = 2;
    public int id;
    public long itemId;
    public long commentId;
    public long userId;
    public int commentType;
    public long createTime;
    public int commentCount;
    public int likeCount;
    public String commentText;
    public String imageUrl;
    public String videoUrl;
    public int width;
    public int height;
    public boolean hasLiked;
    public User author;
    public Ugc ugc;

}

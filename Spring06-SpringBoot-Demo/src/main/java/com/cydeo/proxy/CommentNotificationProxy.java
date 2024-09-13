package com.cydeo.proxy;

import com.cydeo.model.Comment;

//@Component
public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}

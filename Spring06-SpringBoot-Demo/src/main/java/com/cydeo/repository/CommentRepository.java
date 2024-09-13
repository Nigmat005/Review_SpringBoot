package com.cydeo.repository;

import com.cydeo.model.Comment;

//@Component
public interface CommentRepository {
    void storeComment(Comment comment);
}

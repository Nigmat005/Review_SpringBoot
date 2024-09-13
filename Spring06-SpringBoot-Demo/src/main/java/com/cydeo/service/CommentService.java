package com.cydeo.service;

import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Data
@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
@Lazy
// LAzy annotation will only help you create Object(Beans) only after object or dependencies are required
// instead of once creating container

public class CommentService {

    /*
    Example of assign value from properties.file to variable
     */
//    @Value("${portNum}")
//    private int port;
    private final CommentNotificationProxy commentNotificationProxy;
    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(@Qualifier("EmailComment") CommentNotificationProxy commentNotificationProxy, CommentRepository commentRepository){
        this.commentNotificationProxy=commentNotificationProxy;
        this.commentRepository=commentRepository;
        System.out.println("Comment Service Is Instantiated");
    }

    public void publishComment(Comment comment){
        commentNotificationProxy.sendComment(comment);
        commentRepository.storeComment(comment);
    }

//    public Integer portInfo(){
//        return port;
//    }



}

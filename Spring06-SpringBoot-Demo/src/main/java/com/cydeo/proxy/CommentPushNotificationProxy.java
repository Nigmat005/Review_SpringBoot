package com.cydeo.proxy;

import com.cydeo.model.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("pushNotification")
//@Lazy
public class CommentPushNotificationProxy implements CommentNotificationProxy{
//    public CommentPushNotificationProxy() {
//        System.out.println("Hello Spring");
//    }
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending push notification for comment: "+comment.getText());
    }
}

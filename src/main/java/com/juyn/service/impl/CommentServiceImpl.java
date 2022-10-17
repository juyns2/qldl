package com.juyn.service.impl;

import com.juyn.pojo.Comment;
import com.juyn.pojo.Tour;
import com.juyn.pojo.User;
import com.juyn.repository.CommentRepository;
import com.juyn.repository.TourRepository;
import com.juyn.repository.UserRepository;
import com.juyn.service.CommentService;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private TourRepository tourRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment addComment(String content, int tourId, int userId) {
        Tour t = this.tourRepository.getTourIndex(tourId);
        User u = this.userRepository.getUserById(userId);
        //SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        Comment c = new Comment();
        c.setContent(content);
        c.setIdTour(t);
        c.setIdUser(u);
        c.setPostDate(new Date());
        //c.setPostDateFormat(ft.format(c.getPostDate()));
        return this.commentRepository.addComment(c);
    }
}
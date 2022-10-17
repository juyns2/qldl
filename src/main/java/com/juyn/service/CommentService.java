package com.juyn.service;

import com.juyn.pojo.Comment;

public interface CommentService {
    Comment addComment(String content, int tourId, int userId);
}

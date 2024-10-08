package com.example.springbootnewsportal.mapper;

import com.example.springbootnewsportal.model.Posts;
import com.example.springbootnewsportal.web.model.posts.PostListResponse;
import com.example.springbootnewsportal.web.model.posts.PostRequest;
import com.example.springbootnewsportal.web.model.posts.PostResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface PostMapper
{
    Posts requestToPost(PostRequest request);

    @Mapping(source = "postId", target = "id")
    Posts requestToPost(Long postId, PostRequest request);

    PostResponse postToResponse(Posts post);

    List<PostResponse> postListToResponseList(List<Posts> posts);

    default PostListResponse postsListToResponse(List<Posts> posts)
    {
        PostListResponse response = new PostListResponse();
        response.setPostResponses(postListToResponseList(posts));
        return response;
    }
}

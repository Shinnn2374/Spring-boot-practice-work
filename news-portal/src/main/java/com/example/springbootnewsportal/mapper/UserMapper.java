package com.example.springbootnewsportal.mapper;

import com.example.springbootnewsportal.model.User;
import com.example.springbootnewsportal.web.model.user.UserListResponse;
import com.example.springbootnewsportal.web.model.user.UserRequest;
import com.example.springbootnewsportal.web.model.user.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface UserMapper
{
    User requestToUser(UserRequest request);
    @Mapping(source = "userId", target = "id")
    User requestToUser(Long userId, UserRequest request);
    UserResponse userToResponse(User user);
    default UserListResponse userListToUserResponseList(List<User> users)
    {
        UserListResponse response = new UserListResponse();
        response.setUserResponses(users.stream().map(this::userToResponse)
                .collect(Collectors.toList()));
        return response;
    }
}

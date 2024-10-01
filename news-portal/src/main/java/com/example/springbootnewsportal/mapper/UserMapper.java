package com.example.springbootnewsportal.mapper;

import com.example.springbootnewsportal.model.User;
import com.example.springbootnewsportal.web.model.user.UpsertUserRequest;
import com.example.springbootnewsportal.web.model.user.UserListResponse;
import com.example.springbootnewsportal.web.model.user.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {CommentMapper.class, NewsMapper.class})
public interface UserMapper
{
    User requestToUser(UpsertUserRequest request);
    @Mapping(source = "id", target = "id")
    User requestToUser(Long id, UpsertUserRequest request);
    UserResponse userToResponse(User user);
    default UserListResponse userListToUserResponseList(List<User> users)
    {
        UserListResponse response = new UserListResponse();
        response.setUsers(users.stream().map(this::userToResponse)
                .collect(Collectors.toList()));
        return response;
    }
}

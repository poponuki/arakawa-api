package com.arakawa.api.web.rest.vm.mapstruct.mapper;

import com.arakawa.api.entity.User;
import com.arakawa.api.web.rest.vm.UserVM;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    UserVM toUserVM(User user);
    User toUser(UserVM user);
}

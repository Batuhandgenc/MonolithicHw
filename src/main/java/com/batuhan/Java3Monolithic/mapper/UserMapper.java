package com.batuhan.Java3Monolithic.mapper;

import com.batuhan.Java3Monolithic.dto.request.LoginRequestDto;
import com.batuhan.Java3Monolithic.dto.request.UserSaveRequestDto;
import com.batuhan.Java3Monolithic.dto.response.UserFindAllResponseDto;
import com.batuhan.Java3Monolithic.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring" , unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    User toUserFromLogin(final LoginRequestDto dto);

    List<UserFindAllResponseDto> toUserFindAllResponseDto(final List<User> users);
    User toUser(final UserSaveRequestDto requestDto);

}

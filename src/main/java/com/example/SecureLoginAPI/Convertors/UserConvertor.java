package com.example.SecureLoginAPI.Convertors;

import com.example.SecureLoginAPI.Dtos.UserResponseDto;
import com.example.SecureLoginAPI.Models.User;

public class UserConvertor {
    public static UserResponseDto EntityToDto(User user){
            UserResponseDto userResponseDto = UserResponseDto.builder()
                    .name(user.getName())
                    .email(user.getEmail())
                    .userInfo(user.getUserInfo())
                    .build();

        return userResponseDto;
    }
}

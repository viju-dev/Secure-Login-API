package com.example.SecureLoginAPI.Dtos;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UserResponseDto {
//    private String id;
    private String name;
    private String email;
    private String userInfo;

}

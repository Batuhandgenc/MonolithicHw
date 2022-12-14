package com.batuhan.Java3Monolithic.dto.request;


import com.batuhan.Java3Monolithic.repository.entity.EGender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserSaveRequestDto {
    private String name;
    private String surname;
    private String username;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private EGender gender;
}

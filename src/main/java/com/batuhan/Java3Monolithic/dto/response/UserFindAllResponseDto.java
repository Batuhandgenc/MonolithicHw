package com.batuhan.Java3Monolithic.dto.response;

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
public class UserFindAllResponseDto {

    private String name;
    private String surname;
    @Enumerated
            (
            EnumType.STRING
            )
    private EGender gender;
}

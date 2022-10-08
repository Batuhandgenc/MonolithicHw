package com.batuhan.Java3Monolithic.exception;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {
    private int code;
    private String message;
    private List<String> fields;
}

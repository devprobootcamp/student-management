package com.devprobootcamp.student_management.dto;

import lombok.Data;

@Data
public class CountryNameDTO {
    public Name name;

    @Data
    public static class Name {
        private String common;
        private String official;
    }

}

package org.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(setterPrefix = "with")
//@AllArgsConstructor
//@NoArgsConstructor
public class VersionDto {
    private String version;
}

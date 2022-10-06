package org.example;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "with")
public class ExampleDto {
    private String first;
}

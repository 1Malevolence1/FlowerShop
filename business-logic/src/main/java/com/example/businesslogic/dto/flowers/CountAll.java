package com.example.businesslogic.dto.flowers;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
public class CountAll {
    private long count;

    public CountAll(long count) {
        this.count = count;
    }
}

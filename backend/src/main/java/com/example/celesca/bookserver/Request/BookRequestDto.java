package com.example.celesca.bookserver.Request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookRequestDto {

    @NotNull
    private String title;

    @NotNull
    private String author;

    @NotNull
    private String image;
}

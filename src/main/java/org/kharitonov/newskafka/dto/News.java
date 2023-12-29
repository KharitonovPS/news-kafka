package org.kharitonov.newskafka.dto;

import lombok.Data;

@Data
public class News {

    private Long id;

    private String title;

    private String publisher;
}

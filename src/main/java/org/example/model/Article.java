package org.example.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class Article {

    /**
     * 文章id
     */
    private Integer articleId;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章内容
     */
    private String content;



}

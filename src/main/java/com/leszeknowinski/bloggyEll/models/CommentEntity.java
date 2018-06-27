package com.leszeknowinski.bloggyEll.models;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comment")
@NoArgsConstructor
@Getter @Setter
public class CommentEntity {
    @Id
    @GeneratedValue
    private int id;
    private String content;
    private String author;
    private LocalDateTime date;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private PostEntity post;

    @Override
    public String toString() {
        return "CommentEntity{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", date=" + date +
                '}';
    }
}

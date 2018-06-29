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
    @Column(name = "author_id")
    private int authorId;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private PostEntity post;
//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name = "author_id")
//    private UserEntity user;

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

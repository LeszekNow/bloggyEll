package com.leszeknowinski.bloggyEll.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "post")
@NoArgsConstructor
@Getter @Setter
public class PostEntity {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String article;
    private String author;
    private LocalDateTime date;
    @Column(name = "sender_ip")
    private String userIp;
    @Column(name = "author_id")
    private int authorId;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL) //parameter determines how content from server is downloaded - lazy - partially, eager - allAtOnce
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CommentEntity> comments;
//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name = "author_id")
//    private UserEntity user;

    @Override
    public String toString() {
        return "PostEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", article='" + article + '\'' +
                ", author='" + author + '\'' +
                ", date=" + date +
                ", category=" + category +
                '}';
    }
}

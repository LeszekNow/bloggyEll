package com.leszeknowinski.bloggyEll.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@Data
public class UserEntity {
    @Id
    @GeneratedValue
    private int id;
    private String login;
    private String password;
    @Column(name = "has_admin")
    private boolean hasAdmin;

//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    List<PostEntity> posts;
//
//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    List<CommentEntity>comments;

}

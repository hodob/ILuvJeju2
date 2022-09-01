package com.finalprj.ILuvJeju.domain;

import lombok.*;
import javax.persistence.*;

<<<<<<< HEAD
import com.finalprj.ILuvJeju.domain.crew.Crew;

import java.util.Date;

/*
 * 멤버 Entity
 *
 * @Author 백정연
 * @Date 2021/08/03
 */
=======

import java.util.Date;


>>>>>>> mergetodoldolseo

@Entity
@Table(name="MEMBER_TBL")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
public class Member {
    @Id
    private String id;
    private String password;
    private String name;
    private String nickname;
    private String member_img;
    private Date birth;
    private String gender;
    private String email;
    private String phone;
<<<<<<< HEAD
    private Character crleader;
=======
>>>>>>> mergetodoldolseo
}

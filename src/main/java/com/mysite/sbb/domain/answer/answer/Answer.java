package com.mysite.sbb.domain.answer.answer;

import com.mysite.sbb.domain.question.question.Question;
import com.mysite.sbb.global.jpa.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Answer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "TEXT")
    private String content;

    //Answer : Question = N : 1 -> N에 외래키
    //ManyToOne의 fetch default는 EAGER -> LAZY로 바꿔둬야 함
    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "question_id")
    private Question question;
}

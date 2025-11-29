package com.mysite.sbb.domain.question.question;

import com.mysite.sbb.domain.answer.answer.Answer;
import com.mysite.sbb.global.jpa.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
public class Question extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    //question이 삭제되면 answer도 자동 삭제, 저장되면 answer도 자동 저장
    //OneToMany의 fetch default는 LAZY

    @OneToMany(mappedBy = "question", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<Answer> answers = new ArrayList<>();
    //new ArrayList로 초기화 해주는 이유
    //1. NullPointerException 방지
    //2. 즉시 사용가능

    public Answer addAnswer(String content) {
        Answer answer = new Answer();

        answer.setContent(content);
        answer.setQuestion(this);
        answers.add(answer);

        return answer;
    }
}

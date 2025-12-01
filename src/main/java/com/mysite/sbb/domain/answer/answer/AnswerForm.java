package com.mysite.sbb.domain.answer.answer;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AnswerForm {

    @NotEmpty(message="내용은 필수항목입니다.")
    @Size(max = 200, message = "내용은 200자 이하로 입력가능합니다.")
    private String content;
}

package com.mysite.sbb.domain.question.question;

import com.mysite.sbb.domain.answer.answer.AnswerController;
import com.mysite.sbb.domain.answer.answer.AnswerForm;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/question")
@Controller
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Question> questionList = questionService.getList();
        model.addAttribute("questionList", questionList);

        return "question_list";
    }
    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
        Question question = questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }

    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm) {
        return "question_form";
    }


    @AllArgsConstructor
    @Getter
    public static class QuestionForm {

        @NotEmpty(message="제목은 필수항목입니다.")
        @Size(min = 2, max = 200 , message = "제목은 2자 이상, 200자 이하로 입력가능합니다.")
        private String subject;

        @NotEmpty(message="내용은 필수항목입니다.")
        @Size(min = 2, max = 500, message = "내용은 2자 이상, 500자 이하로 입력가능합니다.")
        private String content;
    }
    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "question_form";
        }
        questionService.create(questionForm.getSubject(), questionForm.getContent());
        return "redirect:/question/list";
    }
}

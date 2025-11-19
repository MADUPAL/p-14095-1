package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 액션메서드를 만들기 위해 붙임
public class MainController {
    @GetMapping("/") //아래 메서드를 액션메서드로 만든다.
    @ResponseBody    //아래 메서드의 리턴값을 브라우저로 보낸다.
    public String index() {
        System.out.println("index() 메서드 호출됨!");
        return "SBB";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        System.out.println("hihi");
        return "안녕하세요";
    }
}

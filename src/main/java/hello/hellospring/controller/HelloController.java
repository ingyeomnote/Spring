package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    // mvc 방식-1
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    // mvc 방식-2
    // 파라미터 추가
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = true) String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }


    // api 방식
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam(value = "name", required = true) String name){
        return "hello " + name; // body 영역에 데이터를 직접 넣는다.
        // 템플릿 엔진과의 차이점은, view 같은 게 없이 문자 그대로 전송된다.
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam(value = "name", required=true) String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    // inner static class
    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}

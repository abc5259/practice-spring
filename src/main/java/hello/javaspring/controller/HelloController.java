package hello.javaspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller()
public class HelloController {
    //Static
    // /hello로 가면 이 controller가 실행된다.
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return  "hello"; // resources/templates/hello.html 을 찾아간다 viewResolver가 찾아줌!
    }

    //MVC
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name",name);
        return  "hello-template";
    }

    //API
    @GetMapping("hello-string")
    @ResponseBody // response body에 넣어준다는 뜻
    public String helloString(@RequestParam("name") String name) {
        return  "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloAPI(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello; //객체를 return 하면 json 형태로 반환한다.
    }

    static class Hello { //static으로 하면 class안에서 class사용 가능
        private String name;
        public String getName() {
            return  name;
        }
        public void setName(String name) {
            this.name = name;
        }

    }
}

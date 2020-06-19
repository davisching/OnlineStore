package pers.dc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.dc.TestService;
import pers.dc.bean.Stu;

@RestController
public class HelloController {

    final TestService testService;

    public HelloController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Server is online!";
    }

    @GetMapping("/stu/{id}")
    public Stu getStuInfoById(@PathVariable("id") Long id) {
        return testService.getStuInfoById(id);
    }

}
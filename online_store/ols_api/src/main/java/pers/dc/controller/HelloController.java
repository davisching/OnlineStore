package pers.dc.controller;

import org.springframework.web.bind.annotation.*;
import pers.dc.service.TestService;
import pers.dc.bean.Stu;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
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

    @PostMapping("/stu")
    public void addStu(@RequestBody Stu stu) {
        testService.addStu(stu);
    }

    @PutMapping("/stu")
    public void updateStu(@RequestBody Stu stu) {
        testService.updateStu(stu);
    }

    @DeleteMapping("/stu")
    public void deleteStu(Long id) {
        testService.deleteStu(id);
    }

}
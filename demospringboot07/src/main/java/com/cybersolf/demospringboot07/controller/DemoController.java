package com.cybersolf.demospringboot07.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Controller: thông báo cho springboot biết đây là nơi định nghĩa đường dẫn
 * đó sẽ là file html
 *
 * @ResponseBody: định nghĩa nội dung đường dẫn là string
 *
 * @RestController: thông báo cho springboot biết đây là nơi định nghĩa đường dẫn
 * đó sẽ là String data (JSON)
 *
 * @RequestMapping: định nghĩa đường dẫn
 */

@RestController
@RequestMapping("/demo")
public class DemoController {
    //Nếu người dùng gọi đường dẫn /demo với phương thức Get sẽ kích hoạt code
    @GetMapping
    public String demo(){
        return "Hello World";
    }
    @GetMapping("/hello")
    public String hello() {
        return "Hello World 2";
    }
}

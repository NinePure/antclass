package com.gjs.antclass;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller
 *
 * @author gujiashun
 * @date 2021/3/11
 */
@RestController
@RequestMapping("index")
public class Controller {

    @GetMapping("/jMeter")
    public Object jMeter() {
        return "123";
    }

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            Thread.sleep(1000L);
            System.out.println(1);
        }
    }


}

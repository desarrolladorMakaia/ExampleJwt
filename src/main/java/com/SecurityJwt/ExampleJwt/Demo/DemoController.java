package com.SecurityJwt.ExampleJwt.Demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class DemoController {

    @GetMapping("/demo")
    public String welcome(){
        return "Bienvenido a la seguridad del endpoint";
    }

}

package com.ysc.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Desc: TODO
 * @Author: yinqf【yinqf7437@gmail.com】
 * @Date: 2018-04-12 15:31
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class ProviderApplication {

    private final AuthorConfig authorConfig;

    @Autowired
    public ProviderApplication(AuthorConfig authorConfig) {
        this.authorConfig = authorConfig;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }

    @Value("${server.port}")
    String port;
    @RequestMapping("/hi")
    public String home(@RequestParam String name) {
        return "hi "+name+",i am from port:" +port;
    }



    @RequestMapping("/getAuthorInfo")
    public String getAuthorInfo(){
        return " author信息是丛git上加载下来的 ：" + authorConfig.getName();
    }
}

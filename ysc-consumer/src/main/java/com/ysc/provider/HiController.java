package com.ysc.provider;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Desc: TODO
 * @Author: yinqf【yinqf7437@gmail.com】
 * @Date: 2018-04-12 15:49
 */
@RestController
public class HiController {

    @Resource
    private ScheduleServiceHi scheduleServiceHi;

    @HystrixCommand(fallbackMethod = "sayHiFromClientOneFallback")
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHi(@RequestParam String name){
        return scheduleServiceHi.sayHiFromClientOne(name);
    }

    public String sayHiFromClientOneFallback(String companyName){
        return "this is fallBack, company name is " + companyName;
    }
}

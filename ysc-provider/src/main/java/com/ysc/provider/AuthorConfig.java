package com.ysc.provider;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Desc: TODO
 * @Author: yinqf【yinqf7437@gmail.com】
 * @Date: 2018-04-13 13:27
 */
@Component
@ConfigurationProperties(prefix = "spring.zzf")
public class AuthorConfig {

    private String name;
    private Integer age;
    private Integer sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}

package cn.atomc.learing.springboot.thymeleaf;

import lombok.Builder;
import lombok.Data;

/**
 * @author Eric
 * @create 2019-06-06
 */
@Data
@Builder
public class User {
    private String name;
    private int age;
    private String pass;
}

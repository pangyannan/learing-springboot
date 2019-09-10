package cn.atomc.learing.springboot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearingSpringbootWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearingSpringbootWebApplication.class, args);



        //匿名内部类
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World");
            }
        };
        //Lambda表达式
        Runnable r2 = () -> System.out.println("Hello Lambda!");

    }

}

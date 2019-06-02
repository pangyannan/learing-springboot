package cn.atomc.learing.springboot.web.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author Eric
 * @create 2019-06-02
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AtomcPropertiesTest {
    @Resource
    private AtomcProperties atomcProperties;
    @Test
    public void testMore() {
        System.out.println("title:"+atomcProperties.getTitle());
        System.out.println("description:"+atomcProperties.getDescription());
    }


    @Resource
    private OtherProperties otherProperties;
    @Test
    public void otherPropertiesTest() {
        System.out.println("title:"+otherProperties.getTitle());
        System.out.println("description:"+otherProperties.getBlog());
    }

}
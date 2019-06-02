package cn.atomc.learing.springboot.web.propertiesTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Eric
 * @create 2019-06-02
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesTest {
    @Value("${atomc.title}")
    private String title;
    @Test
    public void testSingle() {
        Assert.assertEquals(title,"艾瑞克");
    }
}

package cn.atomc.learing.springboot.web.web;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author Eric
 * @create 2019-06-02
 */
@Data
@Component
@ConfigurationProperties(prefix="other")
@PropertySource("classpath:other.properties")
public class OtherProperties {
    private String title;
    private String blog;
}

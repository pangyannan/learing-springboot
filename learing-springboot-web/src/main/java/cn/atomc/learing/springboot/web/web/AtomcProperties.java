package cn.atomc.learing.springboot.web.web;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Eric
 * @create 2019-06-02
 */
@Data
@Component
@ConfigurationProperties(prefix="atomc")
public class AtomcProperties {
    private String title;
    private String description;
}

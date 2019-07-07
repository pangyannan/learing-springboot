package cn.atomc.learing.springboot.fastdfs.fastdfs;

import lombok.Builder;
import lombok.Data;

/**
 * @author Eric
 * @create 2019-07-07
 */
@Data
@Builder
public class FastDFSFile {
    private String name;
    private byte[] content;
    private String ext;
    private String md5;
    private String author;

}

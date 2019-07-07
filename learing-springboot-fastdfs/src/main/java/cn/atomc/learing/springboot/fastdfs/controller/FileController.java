package cn.atomc.learing.springboot.fastdfs.controller;

import cn.atomc.learing.springboot.fastdfs.fastdfs.FastDFSClient;
import cn.atomc.learing.springboot.fastdfs.fastdfs.FastDFSFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Eric
 * @create 2019-06-30
 */
@Controller
@Slf4j
public class FileController {
    //定义附件上传的根目录
    private final  static  String UPLOADED_FOLDER = "E:\\uploadFile\\";

    /**
     * 上传页面
     * @return
     */
    @GetMapping("/")
    public String index() {
        return "upload";
    }

    /**
     * 上传状态回显
     * @return
     */
    @GetMapping("uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }

    /**
     * 上传业务处理
     * @param file
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) throws IOException {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }
        String path=saveFile(file);
        redirectAttributes.addFlashAttribute("message","You successfully uploaded '" + file.getOriginalFilename() + "'");
        redirectAttributes.addFlashAttribute("path", "file path url '" + path + "'");
        return "redirect:/uploadStatus";
    }


    /**
     * 批量上传页面
     * @return
     */
    @GetMapping("/more")
    public String more() {
        return "uploadMore";
    }

    /**
     * 批量上传逻辑
     * @param files
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/uploadMore")
    public String moreFileUpload(@RequestParam("file") MultipartFile[] files,
                                 RedirectAttributes redirectAttributes) {
        if (files.length==0) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }
        for(MultipartFile file:files){
            try {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
                Files.write(path, bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        redirectAttributes.addFlashAttribute("message", "You successfully uploaded all");
        return "redirect:/uploadStatus";
    }


    private String saveFile(MultipartFile multipartFile) throws IOException {
        String[] fileAbsolutePath={};
        String fileName=multipartFile.getOriginalFilename();
        String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
        byte[] file_buff = null;
        InputStream inputStream=multipartFile.getInputStream();
        if(inputStream!=null){
            int len1 = inputStream.available();
            file_buff = new byte[len1];
            inputStream.read(file_buff);
        }
        inputStream.close();
        FastDFSFile file = FastDFSFile.builder()
                .name(fileName)
                .content(file_buff)
                .ext(ext)
                .build();
        try {
            fileAbsolutePath = FastDFSClient.upload(file); //upload to fastdfs
        } catch (Exception e) {
            log.error("upload file Exception!",e);
        }
        if (fileAbsolutePath==null) {
            log.error("upload file failed,please upload again!");
        }
        String path=FastDFSClient.getTrackerUrl()+fileAbsolutePath[0]+ "/"+fileAbsolutePath[1];
        return path;
    }
}

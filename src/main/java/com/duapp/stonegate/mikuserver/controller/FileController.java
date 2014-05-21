package com.duapp.stonegate.mikuserver.controller;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.io.Closer;
import com.google.common.io.Files;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;
/**
 * Created by chao.zhu 14-4-28 上午12:55
 */
@Controller
@RequestMapping("/download")
public class FileController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/version")
    public void version(HttpServletResponse response ){
        File file=new File(getClass().getResource("/file/version.cfg").getFile());
        PrintWriter writer=null;
        Closer closer=Closer.create();
        try {
            List<String> list=Files.readLines(file, Charsets.UTF_8);
            logger.debug("list:={}",list);
            writer=response.getWriter();
            closer.register(writer);
            response.setHeader("version",list.get(0));
            writer.flush();
        } catch (IOException e) {
            logger.error("versionError",e);
        }finally {
            try {
                closer.close();
            } catch (IOException e) {
                logger.error("versionError",e);
            }
        }
    }
    @RequestMapping(value = "/{filePath}/{fileName}.{extension}", method = RequestMethod.GET, produces = org.springframework.http.MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public FileSystemResource download(@PathVariable String filePath, @PathVariable String fileName,
            @PathVariable String extension, HttpServletRequest request, HttpServletResponse response) throws Exception {

        logger.info("download:{}/{}", filePath, fileName);
        File file = new File(getClass().getResource("/" + filePath + "/" + fileName + "." + extension).getFile());
        String attachStr = "attachment;fileName=" + URLEncoder.encode("MikuZone.apk", "UTF-8");
        // urlencode 会把空格处理成 '+' 对此做订正
        // fileName = fileName.replace("+", "%20");
        response.setHeader("Content-Disposition", attachStr);
        FileSystemResource fileSystemResource = new FileSystemResource(file);

        if (!fileSystemResource.exists()) {
            throw new NoSuchRequestHandlingMethodException(request);
        }
        return fileSystemResource;
    }
}

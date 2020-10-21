package com.example.edu.controller;

import cn.hutool.json.JSONArray;
import com.example.edu.bean.AttachFile;
import com.example.edu.bean.Teacher;
import com.example.edu.service.webService;
import com.example.edu.utils.Result;
import com.example.edu.utils.ResultUtils;
import com.example.edu.utils.StatusCode;
import com.example.edu.utils.table;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @ProjectName: edu
 * @PackageName: com.example.edu.controller
 * @ClassName: WebController
 * @Date: 2020年04月14日 23:24
 * @Author: zhanggeyang
 * @Description:
 **/
@RestController
@RequestMapping(value = "/web")
public class WebController {
    @Autowired
    private webService webService;
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/hello")
    public String getHello() {
        return "hello";
    }

    @PostMapping(value = "/register")
    public Result register(@RequestBody @Validated Teacher teacher, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResultUtils.failure(bindingResult.getFieldError().getDefaultMessage());
        }
        //Assert.notNull(teacher.getMobile(),"手机不能为空");
        //Assert.notNull(teacher.getName(),"姓名不能为空");
        //Assert.notNull(teacher.getPassword(),"密码不能为空");
        boolean result = webService.getTeacher(teacher);
        if (result) {
            return ResultUtils.failure(StatusCode.haveRegister);
        }

        System.out.println(teacher);
        webService.insertTeacher(teacher);
        return ResultUtils.successful(StatusCode.registerSuccess);
    }

    @PostMapping(value = "/test")
    public Result test(@RequestParam(value = "multipartFile") MultipartFile multipartFile, HttpServletRequest request) {
        System.out.println(request.getLocalAddr());
        String aaaa = request.getParameter("aaaa");
        System.out.println(aaaa);
        System.out.println("1" + multipartFile.getOriginalFilename());
        System.out.println("2" + multipartFile.getResource());
        System.out.println("3" + multipartFile.getName());
        System.out.println("4" + multipartFile.getContentType());
        try {
            System.out.println("5" + multipartFile.getBytes().toString());
            System.out.println("6" + multipartFile.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("7" + multipartFile.getSize());

        ArrayList<Object> tablelist = new ArrayList<>();

        table table = new table();

        for (int i = 0; i < 5; i++) {
            table.setTablename(i + "");
            table.setTablenamecontent(i + "--" + i);
            tablelist.add(table);
        }

        ArrayList<AttachFile> arrayList = new ArrayList<>();
        AttachFile attachFile = new AttachFile();
        for (int i = 0; i < 5; i++) {
            attachFile.setName("文件" + i);
            attachFile.setType("aa" + i);
            arrayList.add(attachFile);
        }

        JSONArray objects = new JSONArray();
        objects.add(tablelist);
        objects.add(arrayList);
        return ResultUtils.successful(objects);
        //System.out.println("applyid是"+applyid);
    }

    @PostMapping(value = "test1")
    public Result test1(HttpServletRequest request) {
        ArrayList<Object> tablelist = new ArrayList<>();
        table table = new table();
        for (int i = 0; i < 5; i++) {

            table.setTablename(i + "");
            table.setTablenamecontent(i + "--" + i);
            tablelist.add(table);
        }

        ArrayList<AttachFile> arrayList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            AttachFile attachFile = new AttachFile();
            attachFile.setName("文件" + i);
            attachFile.setType("aa" + i);
            arrayList.add(attachFile);
        }

        JSONArray objects = new JSONArray();
        objects.add(arrayList);
        objects.add(tablelist);
        HashMap<String, Object> hashMap = new HashMap<>();

        hashMap.put("arraylist", arrayList);
        hashMap.put("tablelist", tablelist);


        return ResultUtils.successful(hashMap);
        //System.out.println("applyid是"+applyid);
    }

    @GetMapping(value = "/downloadxls")
    public void download(HttpServletResponse res) throws Exception {


        HSSFWorkbook workbook = new HSSFWorkbook();

        HSSFSheet sheet = workbook.createSheet("测试");
        sheet.createRow(0).createCell(0).setCellValue("测试");

        res.setContentType("application/octet-stream");
        //默认Excel名称
        res.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode("模板.xls", "UTF-8"));

        //res.setContentType("application/vnd.ms-excel");
        //res.setHeader("Content-Disposition","attachment;filename="+new String("工资模版".getBytes("UTF-8"),"ISO-8859-1")+".xls");

        //res.addHeader("Content-Disposition","attachment;filename=" + URLDecoder.decode("测试.xls", "UTF-8"));
        try {
            res.flushBuffer();
            workbook.write(res.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping(value = "/downloadtemplate")
    public void downloadtemplate(HttpServletResponse response) throws Exception {

        try {
            Resource resource = new ClassPathResource("templates/模板.xls");
            File file = resource.getFile();
            String filename = resource.getFilename();
            InputStream inputStream = new FileInputStream(file);


            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            //强制下载不打开
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            OutputStream out = response.getOutputStream();
            //使用URLEncoder来防止文件名乱码或者读取错误
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));

            workbook.write(out);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @PostMapping(value = "/uploadTemplate")
    public Result uploadTemplate(@RequestParam MultipartFile file, HttpServletRequest request) throws Exception {


        String filename = file.getOriginalFilename();

        File file1 = new File("templates" + File.separator + filename);

        System.out.println(file1.getPath());
        FileUtils.writeByteArrayToFile(file1, file.getBytes());
        return ResultUtils.successful("上传成功");
    }
}

package com.example.edu.utils;


import com.sun.image.codec.jpeg.JPEGCodec;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ProjectName: edu
 * @PackageName: com.example.edu.utils
 * @ClassName: test1
 * @Date: 2020年04月26日 22:43
 * @Author: zhanggeyang
 * @Description:
 **/

public class test1 {
    public static void main(String[] args) throws Exception {

        //根路径
        String rootPath = "/Users/zhanggeyang/Desktop/";

        //原始图片
        String oringal = "11.jpg";
        //水印图片
        String watermark = "watermark.jpeg";
        //水印x坐标
        int x = 100;
        int y = 100;
        //水印y坐标

        addWatermark(rootPath, oringal, watermark, x, y);
        //changeFormat(rootPath);
        //return;


    }

    //格式转换
    private static void changeFormat(String rootPath) throws IOException {
        BufferedImage beforeImage = ImageIO.read(new File(rootPath + "1.jpg"));

        BufferedImage bufferedImage = new BufferedImage(beforeImage.getWidth(), beforeImage.getHeight(), BufferedImage.TYPE_INT_RGB);

        bufferedImage.createGraphics().drawImage(beforeImage, 0, 0, Color.white, null);

        ImageIO.write(bufferedImage, "png", new File(rootPath + "2.png"));
    }

    //添加水印
    private static void addWatermark(String root, String orignal, String watermark, int x, int y) throws Exception {
        //创建文件
        File before = new File(root + orignal);
        //读取文件
        BufferedImage read = ImageIO.read(before);
        //获取宽高
        int height = read.getHeight();
        int width = read.getWidth();

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics graphics = bufferedImage.createGraphics();

        graphics.drawImage(read, 0, 0, width, height, null);

        //获取水印
        File watermarkimage = new File(root + watermark);

        BufferedImage watermarkbuffer = ImageIO.read(watermarkimage);

        int width1 = watermarkbuffer.getWidth();
        int height1 = watermarkbuffer.getHeight();

        graphics.drawImage(watermarkbuffer, x, y, width1, height1, null);

        graphics.dispose();
        FileOutputStream fileOutputStream = new FileOutputStream(root + "after." + before.getName());
        JPEGCodec.createJPEGEncoder(fileOutputStream).encode(bufferedImage);
        fileOutputStream.close();

    }
}

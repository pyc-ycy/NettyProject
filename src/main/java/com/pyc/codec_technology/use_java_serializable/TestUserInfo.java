package com.pyc.codec_technology.use_java_serializable;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author 御承扬
 * @product IntelliJ IDEA
 * @project NettyProject
 * @file TestUserInfo
 * @pack com.pyc.codec_technology.use_java_serializable
 * @date 2021/1/19
 * @time 10:00
 * @E-mail 2923616405@qq.com
 **/


public class TestUserInfo {

    /**
    * @param args
     * @throws IOException
    **/
    public static void main(String[] args) throws IOException {
        UserInfo info = new UserInfo();
        info.buildUserID(100).buildUserName("Welcome to Netty");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(bos);
        os.writeObject(info);
        os.flush();
        os.close();
        byte[] b = bos.toByteArray();
        System.out.println("The jdk serializable length is :" + b.length);
        bos.close();
        System.out.println("-----------------------------------------------");
        System.out.println("The byte array serializable length is :" + info.codeC().length);
    }
}

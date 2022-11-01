package com;

import com.Servcie.RedisServe;
import com.Tools.HttpConfigure;
import com.Tools.StringTools;
import com.entity.AllInterfaces;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

@SpringBootTest
class QqRobotApplicationTests {
    @Autowired
    RedisServe redisServe;
    @Autowired
    HttpConfigure configure;
    @Autowired
    AllInterfaces allInterfaces;
    @Test
    void contextLoads() {
        redisServe.set("你好","我是");
        if(redisServe.exists("你好")){
            redisServe.remove("你好");
            System.out.println("测试");
        }
        System.out.println(redisServe.get("你好"));
    }
     @Autowired
    StringTools stringTools;
    @Test
    void  Test01(){
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        if(i%400==0||i%4==0&&i%100!=0){
            System.out.println("闰年");
        }
    }
    @Test
    void  Test03(){
        String Msg=null;
        switch (stringTools.DataTack()){
            case 19:
                System.out.println("111");Msg="你好";break;
            case 12:
                System.out.println("1113");Msg="你好";break;
            default:
                System.out.println("你好");
        }    System.out.println(Msg);
    }
    @Test
    void  Test04(){
        System.out.println(configure.GetReptileString(allInterfaces.getGuShiCi(), 2));
    }
}

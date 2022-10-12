package com.Tools;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class StringTools {
    public String GetFunctionMenu(){
        return "\uD83D\uDC68\u200D\uD83D\uDCBB\uD83D\uDC68\u200D\uD83D\uDCBB\uD83D\uDC68\u200D\uD83D\uDCBB\uD83D\uDC68\u200D\uD83D\uDCBB\uD83D\uDC68\u200D\uD83D\uDCBB\uD83D\uDC68\u200D\uD83D\uDCBB"
                +"\n"
                +"\uD83C\uDFAD1."+"表情"+"\n"
                +"\uD83C\uDFAD2."+"绿茶"+"\n"
                +"\uD83C\uDFAD3."+"舔狗"+"\n"
                +"\uD83C\uDFAD4."+"csdn{{关键字}}"+"\n"
                +"\uD83C\uDFAD5."+"语音包{{人物}}"+"\n"
                +"\uD83C\uDFAD6."+"聚合{{图片名称}}"+"\n"
                +"\uD83C\uDFAD7."+"{{城市}}天气"+"\n"
                +"\uD83C\uDFAD8."+"青年大学习"+"\n"
                +"\uD83C\uDFAD9."+"翻译{{文本}}"+"\n"
                +"\uD83C\uDFAD10."+"搜歌{{关键字}}"+"\n"
                +"\uD83C\uDFAD11."+"{{图片名称}}图片关键字"+"\n"
                +"\uD83C\uDFAD12."+"文章"+"\n"
                +"\uD83C\uDFAD13."+"测运气{{名字}}"+"\n"
                +"\uD83C\uDFAD14."+"搜图{{名字}}"+"\n"
                +"\uD83C\uDFAD15."+"GitHub{{项目名称}}"+"\n";
    }

    public String GetEmoJiMenu(){
        return"\uD83D\uDDBC\uD83D\uDDBC\uD83D\uDDBC表情菜单\uD83D\uDDBC\uD83D\uDDBC\uD83D\uDDBC"+"\n"+
                "拍拍,高质量,膜拜,撕,遗照,光棍证,老司机证,屌丝证,高富帅证,帅哥证,全群最帅,摩擦";
    }

    public String pictureMenu(){
        return "\uD83D\uDC68\u200D\uD83E\uDDB2\uD83D\uDC68\u200D\uD83E\uDDB2\uD83D\uDC68\u200D\uD83E\uDDB2\uD83D\uDC68\u200D\uD83E\uDDB2\uD83D\uDC68\u200D\uD83E\uDDB2\uD83D\uDC68\u200D\uD83E\uDDB2"
                +"\n"+"美腿,古风,二次元,CosPlay,写真(1-6)+P站"+"\n"+"前面填文字关键字后面跟一个数字,数字为发送几张图片,上限是5张！写真则是第一个数字为写真第几个系列！第二个数字则是发送几张！";
    }

    public int DataTack(){
        String[] strNow3 = new SimpleDateFormat("HH:mm:ss").format(new Date()).toString().split(":");
        return Integer.parseInt(strNow3[0]);
    }

    public boolean IsMy(String NumberCode){
        return NumberCode=="1963470712";
    }

}

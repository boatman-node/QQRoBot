package com.Listener;

import com.Servcie.RedisServe;
import com.Tools.CatCode;
import com.Tools.HttpConfigure;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.entity.AllInterfaces;
import love.forte.simbot.annotation.*;
import love.forte.simbot.api.message.events.GroupMsg;
import love.forte.simbot.api.sender.MsgSender;
import love.forte.simbot.filter.AtDetection;
import love.forte.simbot.filter.MatchType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;

@OnGroup
@Component

public class GroupListening implements com.Monitor.GroupListening {
    @Autowired
    HttpConfigure httpConfigure;
    @Resource
    AllInterfaces allInterfaces;
    @Autowired
    CatCode catCode;
    @Autowired
    RedisServe redisTools;
    @Async
    @Filters(value = {
            @Filter(value = "拍拍",matchType = MatchType.STARTS_WITH),
            @Filter(value = "高质量",matchType = MatchType.STARTS_WITH),
            @Filter(value = "膜拜",matchType = MatchType.STARTS_WITH),
            @Filter(value = "撕",matchType = MatchType.STARTS_WITH),
            @Filter(value = "遗照",matchType = MatchType.STARTS_WITH),
            @Filter(value = "警官证",matchType = MatchType.STARTS_WITH),
            @Filter(value = "光棍证",matchType = MatchType.STARTS_WITH),
            @Filter(value = "老司机",matchType = MatchType.STARTS_WITH),
            @Filter(value = "屌丝证",matchType = MatchType.STARTS_WITH),
            @Filter(value = "帅哥证",matchType = MatchType.STARTS_WITH),
            @Filter(value = "高富帅证",matchType = MatchType.STARTS_WITH),
            @Filter(value = "摩擦",matchType = MatchType.STARTS_WITH),
            @Filter(value = "想看",matchType = MatchType.STARTS_WITH),
            @Filter(value = "全群最帅",matchType = MatchType.STARTS_WITH)
    })
    @Override
    public void Emoji(GroupMsg privateMsg, MsgSender sender) {
        String Url="";
        switch (privateMsg.getMsg().toString()){
            case "摩擦":Url=allInterfaces.getFriction();break;
            case "拍拍":Url=allInterfaces.getTouch();break;
            case "高质量":Url=allInterfaces.getHighQuality();break;
            case "膜拜":Url=allInterfaces.getWorship();break;
            case "撕":Url= allInterfaces.getRip();break;
            case "遗照":Url=allInterfaces.getPosthumousPhoto();break;
            case "光棍证":Url=allInterfaces.getBachelor();break;
            case "老司机":Url=allInterfaces.getDriver();break;
            case "屌丝证":Url=allInterfaces.getDiaoSi();break;
            case "高富帅证":Url=allInterfaces.getHandsomeGuy();break;
            case "帅哥":Url=allInterfaces.getHandsome();break;
            case "全群最帅":Url=allInterfaces.getMostHandsome();break;
            case "想看":Url=allInterfaces.getWantSee();break;
        }   sender.SENDER.sendGroupMsg(privateMsg,catCode.CatPicture(Url+privateMsg.getAccountInfo().getAccountCode()));
    }
    @Async
    @Override
    public void chatWith(GroupMsg privateMsg, MsgSender sender, AtDetection atDetection) {
        if(atDetection.atBot()){
            JSONObject run = null;
            try {
                run = httpConfigure.run(allInterfaces.getWoodenFish()+privateMsg.getText().replace("小木与","菲菲"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            sender.SENDER.sendGroupMsg(privateMsg,run.getString("content").replace("菲菲", "小木鱼"));
        }
    }
    @Filter(value = "绿茶",matchType = MatchType.STARTS_WITH)
    @Override
    public void greenTea(GroupMsg privateMsg, MsgSender sender) {
        sender.SENDER.sendGroupMsg(privateMsg,catCode.voiceCat(allInterfaces.getGreenTea()));
    }
    @Filter(value = "舔狗日记",matchType = MatchType.STARTS_WITH)
    @Override
    public void dogLicking(GroupMsg privateMsg, MsgSender sender) {
        sender.SENDER.sendGroupMsg(privateMsg,httpConfigure.GetReptileString(allInterfaces.getDogLicking(),3));
    }
    @Async
    @Filter(value = "csdn{{Msg}}",   matchType = MatchType.REGEX_MATCHES)
    @Override
    public void csDnApi(GroupMsg privateMsg, MsgSender sender,@FilterValue("Msg") String Msg) {
        String Url= allInterfaces.getCsDnApi()+Msg;
        redisTools.SetString("Type","csDn");
        redisTools.SetString("Url",Url);
        sender.SENDER.sendGroupMsg(privateMsg,httpConfigure.GetReptileString(Url,3).replace(" ","\n"+"\uD83C\uDF3E"));
    }
    @Async
    @Filter(value = "语音包{{Msg}}",   matchType = MatchType.REGEX_MATCHES)
    @Override
    public void voicePack(GroupMsg privateMsg, MsgSender sender,@FilterValue("Msg") String Msg) {
        sender.SENDER.sendGroupMsg(privateMsg,catCode.voiceCat(allInterfaces.getVoicePack( )+Msg));
    }
    @Async
    @Filter(value = "聚合{{Msg}}",   matchType = MatchType.REGEX_MATCHES)
    @Override
    public void polymerization(GroupMsg privateMsg, MsgSender sender, @FilterValue("Msg") String Msg) {
        System.out.println(Msg);
        try {
            sender.SENDER.sendGroupMsg(privateMsg,catCode.CatPicture(httpConfigure.GetReptileString(allInterfaces.getImageSearch()+Msg,5)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Async
    @Filter(value = "{{City}}天气",   matchType = MatchType.REGEX_MATCHES)
    @Override
    public void weather(GroupMsg groupMsg, MsgSender sender, @FilterValue("City") String City) {
        try {
            String WeatherStatus = httpConfigure.run(allInterfaces.getWeather() + City).getString("Weatherstatus");
            sender.SENDER.sendGroupMsg(groupMsg,WeatherStatus.substring(1,WeatherStatus.length()-1).replace(" ","\uD83C\uDF3E"+"\n").replace("\"",""));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Async
    @Filter(value = "青年大学习", matchType = MatchType.STARTS_WITH)
    @Override
    public void YouthStudy(GroupMsg privateMsg, MsgSender sender) {
        sender.SENDER.sendGroupMsg(privateMsg,httpConfigure.GetReptileString(allInterfaces.getYouthStudy(),4).replace(" ","\n"));
    }
    @Filter(value = "翻译{{Text}}",   matchType = MatchType.REGEX_MATCHES)
    @Override
    public void Translate(GroupMsg groupMsg, MsgSender sender,@FilterValue("Text") String Text) {
      sender.SENDER.sendGroupMsg(groupMsg,httpConfigure.GetReptileString(allInterfaces.getTranslate()+Text,3))
      ;
    }
    @Async
    @Filter(value = "搜歌{{Song}}",   matchType = MatchType.REGEX_MATCHES)
    @Override
    public void NetEaseCloud(GroupMsg privateMsg, MsgSender sender,@FilterValue("Song") String Song) {
        String stringBuilder="";
        try {
            String Url=allInterfaces.getQqMusic()+Song;
            JSONArray jsonArray = httpConfigure.run(Url).getJSONArray("Msg");
            redisTools.SetString("Type","歌曲");
            redisTools.SetString("Url",Url);
            for (int u=0;u<jsonArray.size();u++){
                stringBuilder=stringBuilder+(u+1)+": "+jsonArray.get(u)+"\n";}
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            sender.SENDER.sendGroupMsg(privateMsg,stringBuilder.toString());
        }
    }
    @Async
    @Filter(value = "-{{search}}",   matchType = MatchType.REGEX_MATCHES)
    @Override
    public void SearchChoose(GroupMsg groupMsg, MsgSender msgSender,@FilterValue("search") String search)   {
        if (!redisTools.isBlank("U"+groupMsg.getAccountInfo().getAccountCode())){
            try {
                if (search.matches("\\d")&&Integer.parseInt(search)<11&Integer.parseInt(search)>0){
                    String Url="";
                    JSONObject jsonObject ;
                    switch ((String) redisTools.GetString("Type")){
                        case "歌曲":
                            try {
                                jsonObject= httpConfigure.run(redisTools.get("Url") + "&n=" + search).getJSONObject("data");
                                msgSender.SENDER.sendGroupMsg(groupMsg,jsonObject.getString("song")+"\n"+jsonObject.getString("singer")+"\n"+jsonObject.getString("url")+catCode.CatPicture(jsonObject.getString("picture")));
                                msgSender.SENDER.sendGroupMsg(groupMsg,catCode.voiceCat(jsonObject.getString("music")));
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            break;
                        case "csDn":
                            try {
                                String string = httpConfigure.run(redisTools.GetString("Url") + "&n=" + search).getString("url_location");
                                System.out.println(string);
                                msgSender.SENDER.sendGroupMsg(groupMsg,"网站：   "+string);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            break;
                        case "电影":
                            String url = httpConfigure.GetReptileString(redisTools.get("Url") + search, 20);
                            msgSender.SENDER.sendGroupMsg(groupMsg,url.replace("$","").replace("1080P","").replace("链接:","\n").replace("图片:","\n"));
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + (String) redisTools.GetString("Type"));
                    }
                }else {
                    String accountCode = groupMsg.getAccountInfo().getAccountCode();
                    if(redisTools.isBlank("Y"+accountCode)){
                        msgSender.SENDER.sendGroupMsg(groupMsg,"账号:"+accountCode+"被来黑,请稍后再试！");
                        redisTools.set("U"+accountCode,accountCode,60L);
                        redisTools.remove("Y"+accountCode);
                    }else {
                        msgSender.SENDER.sendGroupMsg(groupMsg,"如果在一分钟内乱输入则拉黑一小时");
                        redisTools.set("Y"+accountCode,accountCode,1L);
                    }
                }
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }}else {
            msgSender.SENDER.sendGroupMsg(groupMsg,groupMsg.getAccountInfo().getAccountCode()+"正在拉黑中,稍后再试");
        }

    }
    @Async
    @Filters(value = {
            @Filter(value = "快手{{Number}}", matchType = MatchType.REGEX_MATCHES),
            @Filter(value = "美腿{{Number}}", matchType = MatchType.REGEX_MATCHES),
            @Filter(value = "古风{{Number}}", matchType = MatchType.REGEX_MATCHES),
            @Filter(value = "美女{{Number}}", matchType = MatchType.REGEX_MATCHES),
            @Filter(value = "二次元{{Number}}", matchType = MatchType.REGEX_MATCHES),
            @Filter(value = "CosPlay{{Number}}", matchType = MatchType.REGEX_MATCHES),
            @Filter(value = "写真1{{Number}}", matchType = MatchType.REGEX_MATCHES),
            @Filter(value = "写真2{{Number}}", matchType = MatchType.REGEX_MATCHES),
            @Filter(value = "写真3{{Number}}", matchType = MatchType.REGEX_MATCHES),
            @Filter(value = "写真4{{Number}}", matchType = MatchType.REGEX_MATCHES),
            @Filter(value = "写真5{{Number}}", matchType = MatchType.REGEX_MATCHES),
            @Filter(value = "写真6{{Number}}", matchType = MatchType.REGEX_MATCHES),
            @Filter(value = "P站{{Number}}", matchType = MatchType.REGEX_MATCHES),
            @Filter(value = "涩图{{Number}}", matchType = MatchType.REGEX_MATCHES),
    })
    @Override
    public void menuListener(GroupMsg privateMsg, MsgSender sender, @FilterValue("Number") String Number) {
        if(!redisTools.isBlank("transfer")){
            String Url=null;
            switch (privateMsg.getText().substring(0,privateMsg.getMsg().length()-1)){
                case "快手":
                    Url=httpConfigure.GetReptileString(allInterfaces.getQuickWorker(),3);
                    break;
                case "美腿":
                    Url=allInterfaces.getBeautifulLegs();break;
                case "美女":
                    Url=allInterfaces.getBeauty();break;
                case "古风":
                    Url=allInterfaces.getAntiquity();break;
                case "二次元":
                    Url=allInterfaces.getTwoDimensional();break;
                case "CosPlay":
                    Url=allInterfaces.getCosPlay();break;
                case "写真1":
                    Url=allInterfaces.getPhoto1();break;
                case "写真2":
                    Url=allInterfaces.getPhoto2();break;
                case "写真3":
                    Url=allInterfaces.getPhoto3();break;
                case "写真4":
                    Url=allInterfaces.getPhoto4();break;
                case "写真5":
                    Url=allInterfaces.getPhoto5();break;
                case "写真6":
                    Url=allInterfaces.getPhoto6();break;
                case "P站":
                    Url=allInterfaces.getStationP();break;
                case "涩图":
                    if(privateMsg.getAccountInfo().getAccountCode().equals("1963470712")){
                        try {
                            Url= httpConfigure.run(allInterfaces.getShiBuTto()).getString("url");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }  break;
                    }else {
                        sender.SENDER.sendGroupMsg(privateMsg,"此功能只提供开发者使用,如果要使用叫开授权！");
                    }
            }
            if(Url!=Number){
                int Number1 = Integer.parseInt(Number);
                if (Number1>0&Number1<=5){
                    for (int i= 0; i<Number1; i++) {
                        sender.SENDER.sendGroupMsg(privateMsg,catCode.CatPicture(Url));
                    }
                }else {
                    sender.SENDER.sendGroupMsg(privateMsg,"你个鸡巴少看几张！");
                }}
            redisTools.set("transfer","他妈的!", 1L);
        }else sender.SENDER.sendGroupMsg(privateMsg,redisTools.GetString("transfer"));
    }
    @Async
    @Filter(value = "文章", matchType = MatchType.STARTS_WITH)
    @Override
    public void onePerDay(GroupMsg privateMsg, MsgSender sender) {
        JSONObject data =null;
        try {
            data= httpConfigure.run(allInterfaces.getOnePerDay()).getJSONObject("data");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            sender.SENDER.sendGroupMsg(privateMsg,"名称:  "+data.getString("title")+"\n"+"作者：  "+data.getString("author")+
                    "\n"+data.getString("content")+catCode.CatPicture(data.getString("image"))+"\n"+data.getString("time"));
        }
    }
    @Async
    @Filter(value = "测运气{{Name}}", matchType = MatchType.REGEX_MATCHES)
    @Override
    public void Luck(GroupMsg privateMsg, MsgSender sender, @FilterValue("Name") String Name) {
        JSONObject data =null;
        try {
            data=httpConfigure.run(allInterfaces.getLuck()+Name);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            sender.SENDER.sendGroupMsg(privateMsg,data.getString("text"));
        }
    }
    @Async
    @Filter(value = "搜图{{Name}}", matchType = MatchType.REGEX_MATCHES)
    @Override
    public void searchImages(GroupMsg privateMsg, MsgSender sender,@FilterValue("Name")String Name) {
        sender.SENDER.sendGroupMsg(privateMsg,catCode.CatPicture( httpConfigure.GetReptileString(allInterfaces.getSearchImages()+Name,3)));
    }
    @Async
    @Filter(value = "搜视频{{Name}}", matchType = MatchType.REGEX_MATCHES)
    @Override
    public void videoPlayBack(GroupMsg privateMsg, MsgSender sender,@FilterValue("Name")String Name) {
        String s = null;
        try {
            s = httpConfigure.GetReptileString(allInterfaces.getVideoPlayBack()+Name.trim(), 20).replace(" ","\n");
        } catch (Exception e) {
            sender.SENDER.sendGroupMsg(privateMsg,privateMsg.getBotInfo().getAccountNickname()+"请求超时!");
            throw new RuntimeException(e);
        }
        if(!s.isEmpty()){
            redisTools.SetString("Type","电影");
            redisTools.SetString("Url",allInterfaces.getVideoPlayBack()+Name+"&n=");
            sender.SENDER.sendGroupMsg(privateMsg,s);
        }
    }
    @Async
    @Filter(value = "github{{Name}}", matchType = MatchType.REGEX_MATCHES)
    @Override
    public void GitHub(GroupMsg privateMsg, MsgSender sender,@FilterValue("Name")String Name) {
        sender.SENDER.sendGroupMsg(privateMsg, httpConfigure.GetReptileString(allInterfaces.getGitHub() + Name, 20).replace("名字：", "\n")
                .replace("类型：", "\n").replace("时间：", "\n").replace("链接：", "\n"));
    }
    @Async
    @Filter(value = "快手", matchType = MatchType.STARTS_WITH)
    @Override
    public void twistWaist(GroupMsg groupMsg, MsgSender sender) {
         sender.SENDER.sendGroupMsg(groupMsg,allInterfaces.getTwistWaist());
    }
    @Async
    @Filter(value = "美女视频", matchType = MatchType.STARTS_WITH)
    @Override
    public void videoBeauties(GroupMsg groupMsg, MsgSender sender) {
        sender.SENDER.sendGroupMsg(groupMsg,allInterfaces.getVideoBeauties());
    }
    @Async
    @Filter(value = "星期四", matchType = MatchType.STARTS_WITH)
    @Override
    public void KDJ(GroupMsg groupMsg, MsgSender sender) {
        sender.SENDER.sendGroupMsg(groupMsg,catCode.voiceCat(allInterfaces.getKDJ()));
    }
}

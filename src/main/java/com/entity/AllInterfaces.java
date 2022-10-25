package com.entity;

import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
@Getter
public class AllInterfaces {
    /**时间报时*/
    private String DateTask="http://ovooa.com/API/BaoShi/api.php?msg=";
    /**疫情查询*/
    private String epidemicInquiry="https://xiaobai.klizi.cn/API/other/yiqing.php?city=";
    /**全球ip查询*/
    private String ipSelect="https://xiaobai.klizi.cn/API/other/IP.php?IP=";
    /**60秒懂得世界*/
    private String sixtySeconds="https://xiaobai.klizi.cn/API/other/60s.php";
    /**摸鱼日历*/
    private String calendar="https://api.vvhan.com/api/moyu";
    /**搜图*/
    private String searchImages="https://api.yuxli.cn/api/st.php?ty=";
    /**美腿*/
    private String beautifulLegs="https://ovooa.com/API/meizi/api.php?type=image";
    /**美女*/
    private String Beauty="http://api.5yzs.cn/api/mnt";
    /**古风*/
    private String antiquity="https://cdn.seovx.com/ha/?mom=302";
    /**Image Search*/
    private String ImageSearch="http://api.infatuation.top/test/b_sst.php?msg=";
    /**二次元*/
    private String twoDimensional="https://cdn.seovx.com/d/?mom=302";
    /**CosPlay*/
    private String CosPlay="https://api.r10086.com/img-api.php?type=日本COS中国COS";
    /**涩图*/
    private String ShiBuTto="https://misaka-api.com/API/setu_mix.php";
    /**美女*/
    private String belle="http://ovooa.com/API/meinv/api.php";
    /**写真1*/
    private String Photo1="https://api.r10086.com/img-api.php?type=少女写真1";
    /**写真2*/
    private String Photo2="https://api.r10086.com/img-api.php?type=少女写真2";
    /**写真3*/
    private String Photo3="https://api.r10086.com/img-api.php?type=少女写真3";
    /**写真4*/
    private String Photo4="https://api.r10086.com/img-api.php?type=少女写真4";
    /**写真5*/
    private String Photo5="https://api.r10086.com/img-api.php?type=少女写真5";
    /**写真6*/
    private String Photo6="https://api.r10086.com/img-api.php?type=少女写真6";
    /**P站*/
    private String StationP="https://api.r10086.com/img-api.php?type=P站系列1";
    /**快手*/
    private String quickWorker="http://www.xiaoqiandtianyi.tk/api/ksxjjtp.php";
    /**网络快照*/
    private String networkSnapshot="http://ovooa.com/API/Website_snapshot/?url=";
    /**QQ音乐*/
    private String qqMusic="https://ovooa.com/API/QQ_Music/?Skey=&uin=&msg=";
    /**二维码生成*/
    private String codeGeneration="https://api.xiao-xin.top/API/QRcode.php?msg=";
    /**青年大学习*/
    private String YouthStudy="https://xiaobai.klizi.cn/API/other/youth.php";
    /**万能翻译*/
    private String  Translate = "http://ovooa.com/API/qqfy/api.php?msg=";
    /**GitHub*/
    private String  GitHub = "http://bg.suol.cc/API/github/?msg=";
    /**天气预报*/
    private String  weather = "https://api.linhun.vip/api/theweather?city=";
    /**Csdn*/
    private String  CsDnApi = "https://xiaobai.klizi.cn/API/other/csdn.php?msg=";
    /**每天一篇*/
    private String  onePerDay = "https://xiaobapi.top/api/xb/api/article_of_the_day.php?type=json";
    /**每天运气*/
    private String  luck = "http://ovooa.com/API/Ren/?name=";
    /**舔狗日记*/
    private String  dogLicking = "https://ovooa.com/API/tgrj/api.php";
    /**小木鱼*/
    private String  woodenFish = "http://api.qingyunke.com/api.php?key=free&appid=0&msg=";
    /**绿茶*/
    private String greenTea="http://yysk.yitzu.cn.qingf.top/api/xb/api/lvcha.php";
    /**语音包*/
    private String voicePack="https://xiaobapi.top/api/xb/api/voice_packet.php?msg=";
    /**搜视频*/
    private String   videoPlayBack="http://api.xn--7gqa009h.top/api/dy?msg=";
    /*----------------------------------------------------------表情包*/
    /**拍拍*/
    private String  touch="http://ovooa.com/API/face_petpet/?QQ=";
    /**高质量*/
    private String  highQuality="http://ovooa.com/API/face_gao/?QQ=";
    /**膜拜*/
    private String worship="http://ovooa.com/API/face_worship/?QQ=";
    /**撕*/
    private String rip="http://ovooa.com/API/si/?QQ=";
    /**爬*/
    private String climb="http://ovooa.com/API/pa/api.php?QQ=";
    /**遗照*/
    private String posthumousPhoto="http://ovooa.com/API/yi/?QQ=";
    /**警官证*/
    private String policeOfficerCard="http://api.pan-jian.cn/liebiao/jingguan.php?qq=";
    /**光棍证*/
    private String bachelor="http://yysk.yitzu.cn.qingf.top/api/xb/api/stickers_certificate_11.php?qq=";
    /**老司机*/
    private String driver="http://yysk.yitzu.cn.qingf.top/api/xb/api/stickers_certificate_10.php?qq=";
    /**屌丝证*/
    private String DiaoSi="http://yysk.yitzu.cn.qingf.top/api/xb/api/stickers_certificate_8.php?qq=";
    /**帅哥证*/
    private String handsomeGuy="http://yysk.yitzu.cn.qingf.top/api/xb/api/stickers_certificate_6.php?qq=";
    /**高富帅证*/
    private String handsome="http://yysk.yitzu.cn.qingf.top/api/xb/api/stickers_certificate_2.php?qq=";
    /**全群最帅*/
    private String mostHandsome="http://yysk.yitzu.cn.qingf.top/api/xb/api/zuishuai.php?qq=";
    /**摩擦*/
    private String friction="http://ovooa.com/API/face_moca/?QQ=";
    /**想看*/
    private String wantSee="http://ovooa.com/API/face_thsee/?QQ=";
    /*--------------------- -------------------------------------表情包*/
}

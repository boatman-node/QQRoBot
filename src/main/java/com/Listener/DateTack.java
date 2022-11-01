package com.Listener;

import com.Tools.CatCode;
import com.Tools.HttpConfigure;
import com.Tools.StringTools;
import com.entity.AllInterfaces;
import love.forte.simbot.bot.BotManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class                                                                                                                                                                                                      DateTack implements com.Monitor.DateTack {
    @Autowired
    CatCode catCode;
    @Autowired
    AllInterfaces allInterfaces;
    @Autowired
    HttpConfigure httpConfigure;
    @Autowired
    BotManager botManager;
    @Autowired
    StringTools stringTools;

    /**语音报时*/
    @Scheduled(cron = "0 0 8,12,20 * * ? ")
    @Override
    public void TackVoice() {
        String Number[]={"120520629","809947186","873506537","913168658","810449108"};
        String Msg=null;
        int i = stringTools.DataTack();
        switch (i) {
            case 8:
                Msg = httpConfigure.GetReptileString(allInterfaces.getGuShiCi(),1000)+ "\n今天你给船夫github点赞了吗？\n会努力写代码吗？" + catCode.CatPicture(allInterfaces.getCalendar());
                break;
            case 12:
                Msg =  httpConfigure.GetReptileString(allInterfaces.getGuShiCi(),1000)+"\n午安！";
                break;
            case 20:
                Msg =  httpConfigure.GetReptileString(allInterfaces.getGuShiCi(),1000)+"\n晚安";
                break;
        }
        for (int j = 0; j <Number.length; j++) {
            botManager.getDefaultBot().getSender().SENDER.sendGroupMsg(Number[j],Msg);
        }
        }
    @Scheduled(cron = "0 0 0/6 * * ?")
    @Override
    public void TackPicture() {
        String Number[]={"120520629","809947186","913168658"};
        String CatCode ;
        try {
            CatCode = httpConfigure.run(allInterfaces.getBelle()).getJSONObject("data").getString("image");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < Number.length; i++) {
            botManager.getDefaultBot().getSender().SENDER.sendGroupMsg(Number[i],catCode.CatPicture(CatCode)+catCode.CatPicture(allInterfaces.getBeauty()));
        }
    }

}

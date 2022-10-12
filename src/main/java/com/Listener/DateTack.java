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
    @Scheduled(cron = "0 0 7,12,20 * * ? ")
    @Override
    public void TackVoice() {
        String Number[]={"120520629","809947186","873506537","913168658","810449108"};
        String Msg=null;
        int i = stringTools.DataTack();
        switch (i) {
            case 19:
                Msg = "早上起来,面向太阳,付出就会有收获，或大或小，或迟或早，始终不会辜负你的努力！早安!" + "\n今天你给船夫github点赞了吗？\n会努力写代码吗？" + catCode.CatPicture(allInterfaces.getCalendar());
                break;
            case 12:
                Msg = "清水煮岁月，不悲不喜，做个远离尘世，安安静静的女子，是毕生的愿望，但凡尘浮华众多，怎也无法远离俗世，身处大染缸，脚怎有不湿的道理？\n午安！";
                break;
            case 20:
                Msg = "生活总是这样，不能叫人处处都满意。但我们还要热情地活下去。人活一生，值得爱的东西很多，不要因为一个不满意，就灰心。\n晚安！";
                break;
        }
        for (int j = 0; j <Number.length; j++) {
            botManager.getDefaultBot().getSender().SENDER.sendGroupMsg(Number[j],Msg);
        }
        }
    @Scheduled(cron = "0 0 0/2 * * ?")
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

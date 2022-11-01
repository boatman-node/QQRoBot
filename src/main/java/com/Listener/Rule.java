package com.Listener;

import com.Servcie.RedisServe;
import com.Tools.StringTools;
import com.configuration.RedisConfigure;
import love.forte.simbot.annotation.Async;
import love.forte.simbot.annotation.Filter;
import love.forte.simbot.annotation.OnGroup;
import love.forte.simbot.api.message.events.GroupMsg;
import love.forte.simbot.api.sender.MsgSender;
import love.forte.simbot.filter.MatchType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
@OnGroup
public class Rule {
    @Autowired
    StringTools stringTools;
    @Async
    @Filter(value = "菜单",matchType = MatchType.STARTS_WITH)
    public void GetMenu(GroupMsg groupMsg,MsgSender msgSender){
        msgSender.SENDER.sendGroupMsg(groupMsg,stringTools.GetFunctionMenu());

    }
    @Async
    @Filter(value = "图片菜单",matchType = MatchType.STARTS_WITH)
    public void GetPicTureMenu(GroupMsg groupMsg,MsgSender msgSender){
        msgSender.SENDER.sendGroupMsg(groupMsg,stringTools.pictureMenu());

    }
    @Async
    @Filter(value = "表情包菜单",matchType = MatchType.STARTS_WITH)
    public void GetEmoJiMenu(GroupMsg groupMsg,MsgSender msgSender){
        msgSender.SENDER.sendGroupMsg(groupMsg,stringTools.GetEmoJiMenu());

    }

}

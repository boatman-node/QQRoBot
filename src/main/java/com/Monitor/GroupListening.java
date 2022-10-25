package com.Monitor;

import love.forte.simbot.api.message.events.GroupMsg;
import love.forte.simbot.api.message.events.PrivateMsg;
import love.forte.simbot.api.sender.MsgSender;
import love.forte.simbot.filter.AtDetection;

public interface GroupListening {
    void  Emoji(GroupMsg privateMsg, MsgSender sender);
    void  chatWith(GroupMsg privateMsg, MsgSender sender, AtDetection atDetection);
    void greenTea(GroupMsg privateMsg, MsgSender sender);
    void  dogLicking(GroupMsg privateMsg, MsgSender sender);
    void  csDnApi(GroupMsg privateMsg, MsgSender sender,String Msg);
    void  voicePack(GroupMsg privateMsg, MsgSender sender,String Msg);
    void  polymerization(GroupMsg privateMsg, MsgSender sender,String Msg);
    void weather(GroupMsg groupMsg,MsgSender sender,String City);
    void YouthStudy(GroupMsg privateMsg, MsgSender sender);
    void Translate(GroupMsg groupMsg,MsgSender sender,String Text);
    void NetEaseCloud(GroupMsg privateMsg, MsgSender sender, String Song);
    void SearchChoose(GroupMsg groupMsg,MsgSender msgSender,String search);
    void menuListener(GroupMsg privateMsg, MsgSender sender,String Number);
    void onePerDay(GroupMsg privateMsg, MsgSender sender);
    void Luck(GroupMsg privateMsg, MsgSender sender,String Name);
    void searchImages(GroupMsg privateMsg, MsgSender sender,String Name);
    void videoPlayBack(GroupMsg privateMsg, MsgSender sender,String Name);
    void GitHub(GroupMsg privateMsg, MsgSender sender,String Name);
    void twistWaist(GroupMsg groupMsg,MsgSender sender);
    void videoBeauties(GroupMsg groupMsg,MsgSender sender);
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cnaude.purpleirc.IRC;

import com.cnaude.purpleirc.PurpleBot;
import com.cnaude.purpleirc.PurpleIRC;
import org.pircbotx.Channel;
import org.pircbotx.PircBotX;
import org.pircbotx.User;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.JoinEvent;

/**
 *
 * @author cnaude
 */
public class JoinListener extends ListenerAdapter {
    
    PurpleIRC plugin;
    PurpleBot ircBot;

    public JoinListener(PurpleIRC plugin, PurpleBot ircBot) {
        this.plugin = plugin;
        this.ircBot = ircBot;
    }
    
    @Override
    public void onJoin(JoinEvent event) {                
        Channel channel = event.getChannel();
        User user = event.getUser();
        PircBotX bot = event.getBot();
        
        if (!ircBot.botChannels.contains(channel.getName())) {
            return;
        }
        if (ircBot.enabledMessages.get(channel.getName()).contains("irc-join")) {
            plugin.getServer().broadcast(plugin.colorConverter.ircColorsToGame(plugin.ircJoin)
                    .replace("%NAME%", user.getNick())
                    .replace("%CHANNEL%", channel.getName()), "irc.message.join");
        }
        ircBot.opFriends(channel, user);
        if (user.getNick().equals(ircBot.botNick)) {
            plugin.logDebug("Setting channel modes: " + channel.getName() + " => " 
                    + ircBot.channelModes.get(channel.getName()));
            bot.setMode(channel, ircBot.channelModes.get(channel.getName()));
            ircBot.fixTopic(channel, channel.getTopic(), channel.getTopicSetter());
        }
    }
}

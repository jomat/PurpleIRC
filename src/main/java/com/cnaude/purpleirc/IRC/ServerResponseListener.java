/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cnaude.purpleirc.IRC;

import com.cnaude.purpleirc.PurpleIRC;
import com.cnaude.purpleirc.PurpleBot;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.ServerResponseEvent;
import org.pircbotx.ReplyConstants;

/**
 *
 * @author cnaude
 */
public class ServerResponseListener extends ListenerAdapter {

    PurpleIRC plugin;
    PurpleBot ircBot;

    public ServerResponseListener(PurpleIRC plugin, PurpleBot ircBot) {
        this.plugin = plugin;
        this.ircBot = ircBot;
    }

    @Override
    public void onServerResponse(ServerResponseEvent event) {
        int serverReply = event.getCode();
        
        if (serverReply == ReplyConstants.ERR_BADCHANNELKEY) {
            plugin.logInfo("Bad channel password.");
        }
        
        if (serverReply == ReplyConstants.ERR_BANNEDFROMCHAN) {
            plugin.logInfo("Banned from the channel.");
        }        
    }
}

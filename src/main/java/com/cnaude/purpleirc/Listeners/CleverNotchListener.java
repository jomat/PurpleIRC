/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cnaude.purpleirc.Listeners;

import com.cnaude.purpleirc.PurpleIRC;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.dotGaming.Endain.CleverNotch.CleverEvent;

/**
 *
 * @author cnaude
 */
public class CleverNotchListener implements Listener {

    private final PurpleIRC plugin;

    public CleverNotchListener(PurpleIRC plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onCleverEvent(CleverEvent event) {
        for (String botName : plugin.ircBots.keySet()) {
            if (plugin.botConnected.get(botName)) {
                plugin.ircBots.get(botName).cleverChat(event.getName(),event.getMessage());
            }
        }
    }
}

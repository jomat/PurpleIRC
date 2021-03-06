/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cnaude.purpleirc.IRC;

import com.cnaude.purpleirc.PurpleIRC;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.VersionEvent;

/**
 *
 * @author cnaude
 */
public class VersionListener extends ListenerAdapter {
    
    PurpleIRC plugin;    

    public VersionListener(PurpleIRC plugin) {
        this.plugin = plugin;        
    }
    
    @Override
    public void onVersion(VersionEvent event) {
        event.respond("[Name: " + plugin.getDescription().getFullName() + "]"
                + "[Desc: " + plugin.getDescription().getDescription() + "]"
                + "[Version: " + plugin.getDescription().getVersion() + "]"                
                + "[URL: " + plugin.getDescription().getWebsite() + "]");
    }
}

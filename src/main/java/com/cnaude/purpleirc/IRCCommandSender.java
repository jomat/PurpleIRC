package com.cnaude.purpleirc;

import java.util.Set;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import org.pircbotx.PircBotX;

/**
 *
 * @author Chris Naude
 * We have to implement our own CommandSender so that we can
 * receive output from the command dispatcher.
 */
public class IRCCommandSender implements CommandSender {
    private final PircBotX bot;
    private String target;
    private final PurpleIRC plugin;
    
    @Override
    public void sendMessage(String message) {             
        bot.sendMessage(target, plugin.colorConverter.gameColorsToIrc(message));                
    }
    
    @Override 
    public void sendMessage(String[] messages) {  
        for (String message : messages) {
            bot.sendMessage(target, plugin.colorConverter.gameColorsToIrc(message));  
        }
    }
    
    public IRCCommandSender(PircBotX bot, String target, PurpleIRC plugin) {        
        this.target = target;
        this.bot = bot;
        this.plugin = plugin;
    }
    
    @Override 
    public Server getServer() {
        return Bukkit.getServer();
    }
    
    @Override 
    public String getName() {
        return "";
    }
    
    @Override
    public Set<PermissionAttachmentInfo> getEffectivePermissions() {
        return null;
    }

    @Override
    public boolean hasPermission(final String arg0) {
        return true;
    }

    @Override
    public boolean hasPermission(final Permission arg0) {
        return true;
    }

    @Override
    public boolean isPermissionSet(final String arg0) {
        return true;
    }

    @Override
    public boolean isPermissionSet(final Permission arg0) {
        return true;
    }

    @Override
    public void recalculatePermissions() {
    }

    @Override
    public void removeAttachment(final PermissionAttachment arg0) {
    }

    @Override
    public boolean isOp() {
        return true;
    }

    @Override
    public void setOp(final boolean op) {
    }

    @Override
    public PermissionAttachment addAttachment(final Plugin arg0) {
        return null;
    }

    @Override
    public PermissionAttachment addAttachment(final Plugin arg0, final int arg1) {
        return null;
    }

    @Override
    public PermissionAttachment addAttachment(final Plugin arg0, final String arg1, final boolean arg2) {
        return null;
    }

    @Override
    public PermissionAttachment addAttachment(final Plugin arg0, final String arg1, final boolean arg2, final int arg3) {
        return null;
    }
}

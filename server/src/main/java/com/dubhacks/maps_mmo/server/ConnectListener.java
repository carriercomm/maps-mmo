package com.dubhacks.maps_mmo.server;

import com.dubhacks.maps_mmo.net.SocketPlayer;
import com.dubhacks.maps_mmo.event.EventHandler;
import com.dubhacks.maps_mmo.event.Listener;
import com.dubhacks.maps_mmo.packets.ConnectPacket;
import com.dubhacks.maps_mmo.packets.MapPacket;

public class ConnectListener implements Listener {
    private final Server server;

    public ConnectListener(Server server) {
        this.server = server;
    }

    @EventHandler
    public void handleConnect(SocketPlayer player, ConnectPacket packet) {
        server.getConnectionManager().addPlayer(new ServerPlayer(player, packet.name));
        System.out.println("Received connect from: " + packet.name);
        player.sendPacket(new MapPacket(this.server.getMap().tiles));
    }
}

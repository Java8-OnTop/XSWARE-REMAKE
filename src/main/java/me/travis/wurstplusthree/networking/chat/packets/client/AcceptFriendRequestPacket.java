package me.travis.wurstplusthree.networking.chat.packets.client;

import me.travis.wurstplusthree.networking.chat.Packet;
import me.travis.wurstplusthree.networking.chat.Sockets;

import java.io.IOException;
import java.net.Socket;

/**
 * @author Madmegsox1
 * @since 20/05/2021
 */

public class AcceptFriendRequestPacket extends Packet {
    @Override
    public String[] run(String key, String... arguments) throws IOException {
        String client = mc.player.getName() + ":" + mc.player.getUniqueID();
        Socket s = Sockets.createConnection();
        Sockets.sendData(s, "client:acceptfriendrq:"+client+":"+key+":"+arguments[0]);
        String[] data = Sockets.getData(s);
        s.close();
        return data;
    }
}

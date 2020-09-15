package org.junge;

import tel.schich.javacan.CanChannels;
import tel.schich.javacan.RawCanChannel;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CanMessages {

    public List<RecentMessage> fetchRecentMessages(String interfaceName) {
        try {
            RawCanChannel rawCanChannel = CanChannels.newRawChannel(interfaceName);
            List<RecentMessage> messages = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                messages.add(new RecentMessage(rawCanChannel.read()));
            }
            return messages;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

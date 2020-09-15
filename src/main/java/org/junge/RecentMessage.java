package org.junge;

import io.quarkus.runtime.annotations.RegisterForReflection;
import tel.schich.javacan.CanFrame;

@RegisterForReflection
public class RecentMessage {

    private final int id;

    public RecentMessage(CanFrame canFrame) {
        id = canFrame.getId();
    }

    public int getId() {
        return id;
    }
}

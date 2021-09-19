package com.destructor.destructor2lit.utils.packetWrappers;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Client;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.WrappedChatComponent;

public class WrapperPlayClientUpdateSign extends AbstractPacket {
    public static final PacketType TYPE;

    static {
        TYPE = Client.UPDATE_SIGN;
    }

    public WrapperPlayClientUpdateSign() {
        super(new PacketContainer(TYPE), TYPE);
        this.handle.getModifier().writeDefaults();
    }

    public WrapperPlayClientUpdateSign(PacketContainer packet) {
        super(packet, TYPE);
    }

    public BlockPosition getLocation() {
        return (BlockPosition)this.handle.getBlockPositionModifier().read(0);
    }

    public void setLocation(BlockPosition value) {
        this.handle.getBlockPositionModifier().write(0, value);
    }

    public WrappedChatComponent[] getLines() {
        return (WrappedChatComponent[])this.handle.getChatComponentArrays().read(0);
    }

    public void setLines(WrappedChatComponent[] value) {
        if (value == null) {
            throw new IllegalArgumentException("value cannot be null!");
        } else if (value.length != 4) {
            throw new IllegalArgumentException("value must have 4 elements!");
        } else {
            this.handle.getChatComponentArrays().write(0, value);
        }
    }
}

package io.netty.channel.unix;

import defpackage.ad0;
import io.netty.util.internal.ObjectUtil;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class RawUnixChannelOption extends GenericUnixChannelOption<ByteBuffer> {
    private final int length;

    public RawUnixChannelOption(String str, int i, int i2, int i3) {
        super(str, i, i2);
        this.length = ObjectUtil.checkPositive(i3, "length");
    }

    public int length() {
        return this.length;
    }

    @Override // io.netty.channel.ChannelOption
    public void validate(ByteBuffer byteBuffer) {
        super.validate(byteBuffer);
        if (byteBuffer.remaining() == this.length) {
            return;
        }
        ad0.e(this.length, byteBuffer.remaining(), ", but got ", "Length of value does not match. Expected ");
    }
}

package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
final class UnsafeHeapSwappedByteBuf extends AbstractUnsafeSwappedByteBuf {
    public UnsafeHeapSwappedByteBuf(AbstractByteBuf abstractByteBuf) {
        super(abstractByteBuf);
    }

    private static int idx(ByteBuf byteBuf, int i) {
        return byteBuf.arrayOffset() + i;
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    public int _getInt(AbstractByteBuf abstractByteBuf, int i) {
        return PlatformDependent.getInt(abstractByteBuf.array(), idx(abstractByteBuf, i));
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    public long _getLong(AbstractByteBuf abstractByteBuf, int i) {
        return PlatformDependent.getLong(abstractByteBuf.array(), idx(abstractByteBuf, i));
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    public short _getShort(AbstractByteBuf abstractByteBuf, int i) {
        return PlatformDependent.getShort(abstractByteBuf.array(), idx(abstractByteBuf, i));
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    public void _setInt(AbstractByteBuf abstractByteBuf, int i, int i2) {
        PlatformDependent.putInt(abstractByteBuf.array(), idx(abstractByteBuf, i), i2);
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    public void _setLong(AbstractByteBuf abstractByteBuf, int i, long j) {
        PlatformDependent.putLong(abstractByteBuf.array(), idx(abstractByteBuf, i), j);
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    public void _setShort(AbstractByteBuf abstractByteBuf, int i, short s) {
        PlatformDependent.putShort(abstractByteBuf.array(), idx(abstractByteBuf, i), s);
    }
}

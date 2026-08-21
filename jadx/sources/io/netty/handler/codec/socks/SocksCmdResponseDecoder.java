package io.netty.handler.codec.socks;

import io.netty.handler.codec.ReplayingDecoder;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class SocksCmdResponseDecoder extends ReplayingDecoder<State> {
    private SocksAddressType addressType;
    private SocksCmdStatus cmdStatus;

    /* JADX INFO: renamed from: io.netty.handler.codec.socks.SocksCmdResponseDecoder$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$socks$SocksAddressType;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$socks$SocksCmdResponseDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$socks$SocksCmdResponseDecoder$State = iArr;
            try {
                iArr[State.CHECK_PROTOCOL_VERSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksCmdResponseDecoder$State[State.READ_CMD_HEADER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksCmdResponseDecoder$State[State.READ_CMD_ADDRESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[SocksAddressType.values().length];
            $SwitchMap$io$netty$handler$codec$socks$SocksAddressType = iArr2;
            try {
                iArr2[SocksAddressType.IPv4.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksAddressType[SocksAddressType.DOMAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksAddressType[SocksAddressType.IPv6.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksAddressType[SocksAddressType.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public enum State {
        CHECK_PROTOCOL_VERSION,
        READ_CMD_HEADER,
        READ_CMD_ADDRESS
    }

    public SocksCmdResponseDecoder() {
        super(State.CHECK_PROTOCOL_VERSION);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a2  */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void decode(io.netty.channel.ChannelHandlerContext r6, io.netty.buffer.ByteBuf r7, java.util.List<java.lang.Object> r8) throws java.lang.Throwable {
        /*
            r5 = this;
            int[] r0 = io.netty.handler.codec.socks.SocksCmdResponseDecoder.AnonymousClass1.$SwitchMap$io$netty$handler$codec$socks$SocksCmdResponseDecoder$State
            java.lang.Object r1 = r5.state()
            io.netty.handler.codec.socks.SocksCmdResponseDecoder$State r1 = (io.netty.handler.codec.socks.SocksCmdResponseDecoder.State) r1
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 3
            r2 = 2
            r3 = 1
            if (r0 == r3) goto L1c
            if (r0 == r2) goto L34
            if (r0 != r1) goto L18
            goto L50
        L18:
            defpackage.zo2.g()
            return
        L1c:
            byte r0 = r7.readByte()
            io.netty.handler.codec.socks.SocksProtocolVersion r4 = io.netty.handler.codec.socks.SocksProtocolVersion.SOCKS5
            byte r4 = r4.byteValue()
            if (r0 == r4) goto L2f
            io.netty.handler.codec.socks.SocksResponse r7 = io.netty.handler.codec.socks.SocksCommonUtils.UNKNOWN_SOCKS_RESPONSE
            r8.add(r7)
            goto Lba
        L2f:
            io.netty.handler.codec.socks.SocksCmdResponseDecoder$State r0 = io.netty.handler.codec.socks.SocksCmdResponseDecoder.State.READ_CMD_HEADER
            r5.checkpoint(r0)
        L34:
            byte r0 = r7.readByte()
            io.netty.handler.codec.socks.SocksCmdStatus r0 = io.netty.handler.codec.socks.SocksCmdStatus.valueOf(r0)
            r5.cmdStatus = r0
            r7.skipBytes(r3)
            byte r0 = r7.readByte()
            io.netty.handler.codec.socks.SocksAddressType r0 = io.netty.handler.codec.socks.SocksAddressType.valueOf(r0)
            r5.addressType = r0
            io.netty.handler.codec.socks.SocksCmdResponseDecoder$State r0 = io.netty.handler.codec.socks.SocksCmdResponseDecoder.State.READ_CMD_ADDRESS
            r5.checkpoint(r0)
        L50:
            int[] r0 = io.netty.handler.codec.socks.SocksCmdResponseDecoder.AnonymousClass1.$SwitchMap$io$netty$handler$codec$socks$SocksAddressType
            io.netty.handler.codec.socks.SocksAddressType r4 = r5.addressType
            int r4 = r4.ordinal()
            r0 = r0[r4]
            if (r0 == r3) goto La2
            if (r0 == r2) goto L89
            if (r0 == r1) goto L6d
            r7 = 4
            if (r0 != r7) goto L69
            io.netty.handler.codec.socks.SocksResponse r7 = io.netty.handler.codec.socks.SocksCommonUtils.UNKNOWN_SOCKS_RESPONSE
            r8.add(r7)
            goto Lba
        L69:
            defpackage.zo2.g()
            return
        L6d:
            r0 = 16
            byte[] r0 = new byte[r0]
            r7.readBytes(r0)
            java.lang.String r0 = io.netty.handler.codec.socks.SocksCommonUtils.ipv6toStr(r0)
            int r7 = r7.readUnsignedShort()
            io.netty.handler.codec.socks.SocksCmdResponse r1 = new io.netty.handler.codec.socks.SocksCmdResponse
            io.netty.handler.codec.socks.SocksCmdStatus r2 = r5.cmdStatus
            io.netty.handler.codec.socks.SocksAddressType r3 = r5.addressType
            r1.<init>(r2, r3, r0, r7)
            r8.add(r1)
            goto Lba
        L89:
            byte r0 = r7.readByte()
            java.lang.String r0 = io.netty.handler.codec.socks.SocksCommonUtils.readUsAscii(r7, r0)
            int r7 = r7.readUnsignedShort()
            io.netty.handler.codec.socks.SocksCmdResponse r1 = new io.netty.handler.codec.socks.SocksCmdResponse
            io.netty.handler.codec.socks.SocksCmdStatus r2 = r5.cmdStatus
            io.netty.handler.codec.socks.SocksAddressType r3 = r5.addressType
            r1.<init>(r2, r3, r0, r7)
            r8.add(r1)
            goto Lba
        La2:
            int r0 = r7.readInt()
            java.lang.String r0 = io.netty.util.NetUtil.intToIpAddress(r0)
            int r7 = r7.readUnsignedShort()
            io.netty.handler.codec.socks.SocksCmdResponse r1 = new io.netty.handler.codec.socks.SocksCmdResponse
            io.netty.handler.codec.socks.SocksCmdStatus r2 = r5.cmdStatus
            io.netty.handler.codec.socks.SocksAddressType r3 = r5.addressType
            r1.<init>(r2, r3, r0, r7)
            r8.add(r1)
        Lba:
            io.netty.channel.ChannelPipeline r6 = r6.pipeline()
            r6.remove(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.socks.SocksCmdResponseDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }
}

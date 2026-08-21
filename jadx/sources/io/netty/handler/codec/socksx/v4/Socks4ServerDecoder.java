package io.netty.handler.codec.socksx.v4;

import defpackage.ha0;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.util.CharsetUtil;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class Socks4ServerDecoder extends ReplayingDecoder<State> {
    private static final int MAX_FIELD_LENGTH = 255;
    private String dstAddr;
    private int dstPort;
    private Socks4CommandType type;
    private String userId;

    /* JADX INFO: renamed from: io.netty.handler.codec.socksx.v4.Socks4ServerDecoder$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$socksx$v4$Socks4ServerDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$socksx$v4$Socks4ServerDecoder$State = iArr;
            try {
                iArr[State.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socksx$v4$Socks4ServerDecoder$State[State.READ_USERID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socksx$v4$Socks4ServerDecoder$State[State.READ_DOMAIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socksx$v4$Socks4ServerDecoder$State[State.SUCCESS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socksx$v4$Socks4ServerDecoder$State[State.FAILURE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public enum State {
        START,
        READ_USERID,
        READ_DOMAIN,
        SUCCESS,
        FAILURE
    }

    public Socks4ServerDecoder() {
        super(State.START);
        setSingleDecode(true);
    }

    private void fail(List<Object> list, Exception exc) {
        if (!(exc instanceof DecoderException)) {
            exc = new DecoderException(exc);
        }
        Socks4CommandType socks4CommandType = this.type;
        if (socks4CommandType == null) {
            socks4CommandType = Socks4CommandType.CONNECT;
        }
        String str = this.dstAddr;
        if (str == null) {
            str = "";
        }
        int i = this.dstPort;
        if (i == 0) {
            i = 65535;
        }
        String str2 = this.userId;
        DefaultSocks4CommandRequest defaultSocks4CommandRequest = new DefaultSocks4CommandRequest(socks4CommandType, str, i, str2 != null ? str2 : "");
        defaultSocks4CommandRequest.setDecoderResult(DecoderResult.failure(exc));
        list.add(defaultSocks4CommandRequest);
        checkpoint(State.FAILURE);
    }

    private static String readString(String str, ByteBuf byteBuf) {
        int iBytesBefore = byteBuf.bytesBefore(256, (byte) 0);
        if (iBytesBefore < 0) {
            throw new DecoderException(ha0.o("field '", str, "' longer than 255 chars"));
        }
        String string = byteBuf.readSlice(iBytesBefore).toString(CharsetUtil.US_ASCII);
        byteBuf.skipBytes(1);
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x009b A[Catch: Exception -> 0x0029, TryCatch #0 {Exception -> 0x0029, blocks: (B:3:0x0002, B:14:0x0021, B:28:0x0095, B:30:0x009b, B:22:0x0064, B:24:0x006e, B:26:0x0078, B:27:0x0080, B:21:0x0057, B:18:0x002c, B:20:0x0038, B:32:0x00a3, B:33:0x00b4), top: B:36:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void decode(io.netty.channel.ChannelHandlerContext r5, io.netty.buffer.ByteBuf r6, java.util.List<java.lang.Object> r7) {
        /*
            r4 = this;
            java.lang.String r5 = "unsupported protocol version: "
            int[] r0 = io.netty.handler.codec.socksx.v4.Socks4ServerDecoder.AnonymousClass1.$SwitchMap$io$netty$handler$codec$socksx$v4$Socks4ServerDecoder$State     // Catch: java.lang.Exception -> L29
            java.lang.Object r1 = r4.state()     // Catch: java.lang.Exception -> L29
            io.netty.handler.codec.socksx.v4.Socks4ServerDecoder$State r1 = (io.netty.handler.codec.socksx.v4.Socks4ServerDecoder.State) r1     // Catch: java.lang.Exception -> L29
            int r1 = r1.ordinal()     // Catch: java.lang.Exception -> L29
            r0 = r0[r1]     // Catch: java.lang.Exception -> L29
            r1 = 1
            if (r0 == r1) goto L2c
            r5 = 2
            if (r0 == r5) goto L57
            r5 = 3
            if (r0 == r5) goto L64
            r5 = 4
            if (r0 == r5) goto L95
            r5 = 5
            if (r0 == r5) goto L21
            goto La2
        L21:
            int r5 = r4.actualReadableBytes()     // Catch: java.lang.Exception -> L29
            r6.skipBytes(r5)     // Catch: java.lang.Exception -> L29
            return
        L29:
            r5 = move-exception
            goto Lb5
        L2c:
            short r0 = r6.readUnsignedByte()     // Catch: java.lang.Exception -> L29
            io.netty.handler.codec.socksx.SocksVersion r1 = io.netty.handler.codec.socksx.SocksVersion.SOCKS4a     // Catch: java.lang.Exception -> L29
            byte r1 = r1.byteValue()     // Catch: java.lang.Exception -> L29
            if (r0 != r1) goto La3
            byte r5 = r6.readByte()     // Catch: java.lang.Exception -> L29
            io.netty.handler.codec.socksx.v4.Socks4CommandType r5 = io.netty.handler.codec.socksx.v4.Socks4CommandType.valueOf(r5)     // Catch: java.lang.Exception -> L29
            r4.type = r5     // Catch: java.lang.Exception -> L29
            int r5 = r6.readUnsignedShort()     // Catch: java.lang.Exception -> L29
            r4.dstPort = r5     // Catch: java.lang.Exception -> L29
            int r5 = r6.readInt()     // Catch: java.lang.Exception -> L29
            java.lang.String r5 = io.netty.util.NetUtil.intToIpAddress(r5)     // Catch: java.lang.Exception -> L29
            r4.dstAddr = r5     // Catch: java.lang.Exception -> L29
            io.netty.handler.codec.socksx.v4.Socks4ServerDecoder$State r5 = io.netty.handler.codec.socksx.v4.Socks4ServerDecoder.State.READ_USERID     // Catch: java.lang.Exception -> L29
            r4.checkpoint(r5)     // Catch: java.lang.Exception -> L29
        L57:
            java.lang.String r5 = "userid"
            java.lang.String r5 = readString(r5, r6)     // Catch: java.lang.Exception -> L29
            r4.userId = r5     // Catch: java.lang.Exception -> L29
            io.netty.handler.codec.socksx.v4.Socks4ServerDecoder$State r5 = io.netty.handler.codec.socksx.v4.Socks4ServerDecoder.State.READ_DOMAIN     // Catch: java.lang.Exception -> L29
            r4.checkpoint(r5)     // Catch: java.lang.Exception -> L29
        L64:
            java.lang.String r5 = "0.0.0.0"
            java.lang.String r0 = r4.dstAddr     // Catch: java.lang.Exception -> L29
            boolean r5 = r5.equals(r0)     // Catch: java.lang.Exception -> L29
            if (r5 != 0) goto L80
            java.lang.String r5 = r4.dstAddr     // Catch: java.lang.Exception -> L29
            java.lang.String r0 = "0.0.0."
            boolean r5 = r5.startsWith(r0)     // Catch: java.lang.Exception -> L29
            if (r5 == 0) goto L80
            java.lang.String r5 = "dstAddr"
            java.lang.String r5 = readString(r5, r6)     // Catch: java.lang.Exception -> L29
            r4.dstAddr = r5     // Catch: java.lang.Exception -> L29
        L80:
            io.netty.handler.codec.socksx.v4.DefaultSocks4CommandRequest r5 = new io.netty.handler.codec.socksx.v4.DefaultSocks4CommandRequest     // Catch: java.lang.Exception -> L29
            io.netty.handler.codec.socksx.v4.Socks4CommandType r0 = r4.type     // Catch: java.lang.Exception -> L29
            java.lang.String r1 = r4.dstAddr     // Catch: java.lang.Exception -> L29
            int r2 = r4.dstPort     // Catch: java.lang.Exception -> L29
            java.lang.String r3 = r4.userId     // Catch: java.lang.Exception -> L29
            r5.<init>(r0, r1, r2, r3)     // Catch: java.lang.Exception -> L29
            r7.add(r5)     // Catch: java.lang.Exception -> L29
            io.netty.handler.codec.socksx.v4.Socks4ServerDecoder$State r5 = io.netty.handler.codec.socksx.v4.Socks4ServerDecoder.State.SUCCESS     // Catch: java.lang.Exception -> L29
            r4.checkpoint(r5)     // Catch: java.lang.Exception -> L29
        L95:
            int r5 = r4.actualReadableBytes()     // Catch: java.lang.Exception -> L29
            if (r5 <= 0) goto La2
            io.netty.buffer.ByteBuf r5 = r6.readRetainedSlice(r5)     // Catch: java.lang.Exception -> L29
            r7.add(r5)     // Catch: java.lang.Exception -> L29
        La2:
            return
        La3:
            io.netty.handler.codec.DecoderException r6 = new io.netty.handler.codec.DecoderException     // Catch: java.lang.Exception -> L29
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L29
            r1.<init>(r5)     // Catch: java.lang.Exception -> L29
            r1.append(r0)     // Catch: java.lang.Exception -> L29
            java.lang.String r5 = r1.toString()     // Catch: java.lang.Exception -> L29
            r6.<init>(r5)     // Catch: java.lang.Exception -> L29
            throw r6     // Catch: java.lang.Exception -> L29
        Lb5:
            r4.fail(r7, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.socksx.v4.Socks4ServerDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }
}

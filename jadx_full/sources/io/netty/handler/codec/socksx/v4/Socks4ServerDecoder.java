package io.netty.handler.codec.socksx.v4;

import defpackage.ha0;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.handler.codec.socksx.SocksVersion;
import io.netty.util.CharsetUtil;
import io.netty.util.NetUtil;
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
    */
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        int iActualReadableBytes;
        try {
            int i = AnonymousClass1.$SwitchMap$io$netty$handler$codec$socksx$v4$Socks4ServerDecoder$State[state().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return;
                            }
                            byteBuf.skipBytes(actualReadableBytes());
                            return;
                        }
                    }
                    iActualReadableBytes = actualReadableBytes();
                    if (iActualReadableBytes > 0) {
                        list.add(byteBuf.readRetainedSlice(iActualReadableBytes));
                        return;
                    }
                    return;
                }
                if (!"0.0.0.0".equals(this.dstAddr) && this.dstAddr.startsWith("0.0.0.")) {
                    this.dstAddr = readString("dstAddr", byteBuf);
                }
                list.add(new DefaultSocks4CommandRequest(this.type, this.dstAddr, this.dstPort, this.userId));
                checkpoint(State.SUCCESS);
                iActualReadableBytes = actualReadableBytes();
                if (iActualReadableBytes > 0) {
                }
            } else {
                short unsignedByte = byteBuf.readUnsignedByte();
                if (unsignedByte != SocksVersion.SOCKS4a.byteValue()) {
                    throw new DecoderException("unsupported protocol version: " + ((int) unsignedByte));
                }
                this.type = Socks4CommandType.valueOf(byteBuf.readByte());
                this.dstPort = byteBuf.readUnsignedShort();
                this.dstAddr = NetUtil.intToIpAddress(byteBuf.readInt());
                checkpoint(State.READ_USERID);
            }
            this.userId = readString("userid", byteBuf);
            checkpoint(State.READ_DOMAIN);
            if (!"0.0.0.0".equals(this.dstAddr)) {
                this.dstAddr = readString("dstAddr", byteBuf);
            }
            list.add(new DefaultSocks4CommandRequest(this.type, this.dstAddr, this.dstPort, this.userId));
            checkpoint(State.SUCCESS);
            iActualReadableBytes = actualReadableBytes();
            if (iActualReadableBytes > 0) {
            }
        } catch (Exception e) {
            fail(list, e);
        }
    }
}

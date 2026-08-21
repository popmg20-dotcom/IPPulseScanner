package io.netty.handler.codec.http.websocketx;

import defpackage.dw2;
import defpackage.ha0;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteOrder;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class WebSocket08FrameDecoder extends ByteToMessageDecoder implements WebSocketFrameDecoder {
    private static final byte OPCODE_BINARY = 2;
    private static final byte OPCODE_CLOSE = 8;
    private static final byte OPCODE_CONT = 0;
    private static final byte OPCODE_PING = 9;
    private static final byte OPCODE_PONG = 10;
    private static final byte OPCODE_TEXT = 1;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) WebSocket08FrameDecoder.class);
    private final WebSocketDecoderConfig config;
    private int fragmentedFramesCount;
    private boolean frameFinalFlag;
    private boolean frameMasked;
    private int frameOpcode;
    private int framePayloadLen1;
    private long framePayloadLength;
    private int frameRsv;
    private int mask;
    private boolean receivedClosingHandshake;
    private State state;

    /* JADX INFO: renamed from: io.netty.handler.codec.http.websocketx.WebSocket08FrameDecoder$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http$websocketx$WebSocket08FrameDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$http$websocketx$WebSocket08FrameDecoder$State = iArr;
            try {
                iArr[State.READING_FIRST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$websocketx$WebSocket08FrameDecoder$State[State.READING_SECOND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$websocketx$WebSocket08FrameDecoder$State[State.READING_SIZE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$websocketx$WebSocket08FrameDecoder$State[State.MASKING_KEY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$websocketx$WebSocket08FrameDecoder$State[State.PAYLOAD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$websocketx$WebSocket08FrameDecoder$State[State.CORRUPT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public enum State {
        READING_FIRST,
        READING_SECOND,
        READING_SIZE,
        MASKING_KEY,
        PAYLOAD,
        CORRUPT
    }

    public WebSocket08FrameDecoder(boolean z, boolean z2, int i, boolean z3) {
        this(WebSocketDecoderConfig.newBuilder().expectMaskedFrames(z).allowExtensions(z2).maxFramePayloadLength(i).allowMaskMismatch(z3).build());
    }

    private void protocolViolation(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, CorruptedWebSocketFrameException corruptedWebSocketFrameException) {
        Object closeWebSocketFrame;
        this.state = State.CORRUPT;
        int i = byteBuf.readableBytes();
        if (i > 0) {
            byteBuf.skipBytes(i);
        }
        if (!channelHandlerContext.channel().isActive() || !this.config.closeOnProtocolViolation()) {
            throw corruptedWebSocketFrameException;
        }
        if (this.receivedClosingHandshake) {
            closeWebSocketFrame = Unpooled.EMPTY_BUFFER;
        } else {
            WebSocketCloseStatus webSocketCloseStatusCloseStatus = corruptedWebSocketFrameException.closeStatus();
            String message = corruptedWebSocketFrameException.getMessage();
            if (message == null) {
                message = webSocketCloseStatusCloseStatus.reasonText();
            }
            closeWebSocketFrame = new CloseWebSocketFrame(webSocketCloseStatusCloseStatus, message);
        }
        channelHandlerContext.writeAndFlush(closeWebSocketFrame).addListener2((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE);
        throw corruptedWebSocketFrameException;
    }

    private static int toFrameLength(long j) {
        if (j <= 2147483647L) {
            return (int) j;
        }
        throw new TooLongFrameException(ha0.j(j, "Length:"));
    }

    private void unmask(ByteBuf byteBuf) {
        int i = byteBuf.readerIndex();
        int iWriterIndex = byteBuf.writerIndex();
        ByteOrder byteOrderOrder = byteBuf.order();
        int iReverseBytes = this.mask;
        long j = ((long) iReverseBytes) & 4294967295L;
        long j2 = j | (j << 32);
        int i2 = iWriterIndex - 7;
        while (i < i2) {
            byteBuf.setLong(i, byteBuf.getLong(i) ^ j2);
            i += 8;
        }
        if (i < iWriterIndex - 3) {
            byteBuf.setInt(i, ((int) j2) ^ byteBuf.getInt(i));
            i += 4;
        }
        if (byteOrderOrder == ByteOrder.LITTLE_ENDIAN) {
            iReverseBytes = Integer.reverseBytes(iReverseBytes);
        }
        int i3 = 0;
        while (i < iWriterIndex) {
            byteBuf.setByte(i, WebSocketUtil.byteAtIndex(iReverseBytes, i3 & 3) ^ byteBuf.getByte(i));
            i++;
            i3++;
        }
    }

    public void checkCloseFrameBody(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) {
        if (byteBuf == null || !byteBuf.isReadable()) {
            return;
        }
        if (byteBuf.readableBytes() < 2) {
            protocolViolation(channelHandlerContext, byteBuf, WebSocketCloseStatus.INVALID_PAYLOAD_DATA, "Invalid close frame body");
        }
        short s = byteBuf.getShort(byteBuf.readerIndex());
        if (!WebSocketCloseStatus.isValidStatusCode(s)) {
            protocolViolation(channelHandlerContext, byteBuf, dw2.A(s, "Invalid close frame getStatus code: "));
        }
        if (byteBuf.readableBytes() > 2) {
            try {
                new Utf8Validator().check(byteBuf, byteBuf.readerIndex() + 2, byteBuf.readableBytes() - 2);
            } catch (CorruptedWebSocketFrameException e) {
                protocolViolation(channelHandlerContext, byteBuf, e);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:165:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:167:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x016e  */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        long j;
        int i;
        long unsignedShort;
        long j2;
        long j3;
        if (this.receivedClosingHandshake) {
            byteBuf.skipBytes(actualReadableBytes());
            return;
        }
        switch (AnonymousClass1.$SwitchMap$io$netty$handler$codec$http$websocketx$WebSocket08FrameDecoder$State[this.state.ordinal()]) {
            case 1:
                if (byteBuf.isReadable()) {
                    this.framePayloadLength = 0L;
                    byte b = byteBuf.readByte();
                    j = 0;
                    this.frameFinalFlag = (b & 128) != 0;
                    this.frameRsv = (b & 112) >> 4;
                    this.frameOpcode = b & 15;
                    InternalLogger internalLogger = logger;
                    if (internalLogger.isTraceEnabled()) {
                        internalLogger.trace("Decoding WebSocket Frame opCode={}", Integer.valueOf(this.frameOpcode));
                    }
                    this.state = State.READING_SECOND;
                    if (byteBuf.isReadable()) {
                        return;
                    }
                    byte b2 = byteBuf.readByte();
                    this.frameMasked = (b2 & 128) != 0;
                    this.framePayloadLen1 = b2 & 127;
                    if (this.frameRsv != 0 && !this.config.allowExtensions()) {
                        protocolViolation(channelHandlerContext, byteBuf, "RSV != 0 and no extension negotiated, RSV:" + this.frameRsv);
                        return;
                    }
                    if (!this.config.allowMaskMismatch() && this.config.expectMaskedFrames() != this.frameMasked) {
                        protocolViolation(channelHandlerContext, byteBuf, "received a frame that is not masked as expected");
                        return;
                    }
                    int i2 = this.frameOpcode;
                    if (i2 > 7) {
                        if (!this.frameFinalFlag) {
                            protocolViolation(channelHandlerContext, byteBuf, "fragmented control frame");
                            return;
                        }
                        int i3 = this.framePayloadLen1;
                        if (i3 > 125) {
                            protocolViolation(channelHandlerContext, byteBuf, "control frame with payload length > 125 octets");
                            return;
                        }
                        if (i2 != 8 && i2 != 9 && i2 != 10) {
                            protocolViolation(channelHandlerContext, byteBuf, "control frame using reserved opcode " + this.frameOpcode);
                            return;
                        } else if (i2 == 8 && i3 == 1) {
                            protocolViolation(channelHandlerContext, byteBuf, "received close control frame with payload len 1");
                            return;
                        }
                    } else {
                        if (i2 != 0 && i2 != 1 && i2 != 2) {
                            protocolViolation(channelHandlerContext, byteBuf, "data frame using reserved opcode " + this.frameOpcode);
                            return;
                        }
                        int i4 = this.fragmentedFramesCount;
                        if (i4 == 0 && i2 == 0) {
                            protocolViolation(channelHandlerContext, byteBuf, "received continuation data frame outside fragmented message");
                            return;
                        } else if (i4 != 0 && i2 != 0) {
                            protocolViolation(channelHandlerContext, byteBuf, "received non-continuation data frame while inside fragmented message");
                            return;
                        }
                    }
                    this.state = State.READING_SIZE;
                    i = this.framePayloadLen1;
                    if (i != 126) {
                        if (byteBuf.readableBytes() < 2) {
                            return;
                        }
                        unsignedShort = byteBuf.readUnsignedShort();
                        this.framePayloadLength = unsignedShort;
                        if (unsignedShort < 126) {
                            protocolViolation(channelHandlerContext, byteBuf, "invalid data frame length (not using minimal length encoding)");
                            return;
                        }
                    } else if (i != 127) {
                        unsignedShort = i;
                        this.framePayloadLength = unsignedShort;
                    } else {
                        if (byteBuf.readableBytes() < 8) {
                            return;
                        }
                        unsignedShort = byteBuf.readLong();
                        this.framePayloadLength = unsignedShort;
                        if (unsignedShort < j) {
                            protocolViolation(channelHandlerContext, byteBuf, "invalid data frame length (negative length)");
                            return;
                        } else if (unsignedShort < 65536) {
                            protocolViolation(channelHandlerContext, byteBuf, "invalid data frame length (not using minimal length encoding)");
                            return;
                        }
                    }
                    if (unsignedShort <= this.config.maxFramePayloadLength()) {
                        protocolViolation(channelHandlerContext, byteBuf, WebSocketCloseStatus.MESSAGE_TOO_BIG, "Max frame length of " + this.config.maxFramePayloadLength() + " has been exceeded.");
                        return;
                    }
                    InternalLogger internalLogger2 = logger;
                    if (internalLogger2.isTraceEnabled()) {
                        internalLogger2.trace("Decoding WebSocket Frame length={}", Long.valueOf(this.framePayloadLength));
                    }
                    this.state = State.MASKING_KEY;
                    if (this.frameMasked) {
                        if (byteBuf.readableBytes() < 4) {
                            return;
                        } else {
                            this.mask = byteBuf.readInt();
                        }
                    }
                    this.state = State.PAYLOAD;
                    j2 = byteBuf.readableBytes();
                    j3 = this.framePayloadLength;
                    if (j2 < j3) {
                        return;
                    }
                    ByteBuf bytes = Unpooled.EMPTY_BUFFER;
                    if (j3 > j) {
                        try {
                            bytes = ByteBufUtil.readBytes(channelHandlerContext.alloc(), byteBuf, toFrameLength(this.framePayloadLength));
                        } catch (Throwable th) {
                            if (bytes != null) {
                                bytes.release();
                            }
                            throw th;
                        }
                    }
                    this.state = State.READING_FIRST;
                    if (this.frameMasked & (this.framePayloadLength > j)) {
                        unmask(bytes);
                    }
                    int i5 = this.frameOpcode;
                    if (i5 == 9) {
                        list.add(new PingWebSocketFrame(this.frameFinalFlag, this.frameRsv, bytes));
                        return;
                    }
                    if (i5 == 10) {
                        list.add(new PongWebSocketFrame(this.frameFinalFlag, this.frameRsv, bytes));
                        return;
                    }
                    if (i5 == 8) {
                        this.receivedClosingHandshake = true;
                        checkCloseFrameBody(channelHandlerContext, bytes);
                        list.add(new CloseWebSocketFrame(this.frameFinalFlag, this.frameRsv, bytes));
                        return;
                    }
                    boolean z = this.frameFinalFlag;
                    if (z) {
                        this.fragmentedFramesCount = 0;
                    } else {
                        this.fragmentedFramesCount++;
                    }
                    if (i5 == 1) {
                        list.add(new TextWebSocketFrame(z, this.frameRsv, bytes));
                        return;
                    }
                    if (i5 == 2) {
                        list.add(new BinaryWebSocketFrame(z, this.frameRsv, bytes));
                        return;
                    } else if (i5 == 0) {
                        list.add(new ContinuationWebSocketFrame(z, this.frameRsv, bytes));
                        return;
                    } else {
                        throw new UnsupportedOperationException("Cannot decode web socket frame with opcode: " + this.frameOpcode);
                    }
                }
                return;
            case 2:
                j = 0;
                if (byteBuf.isReadable()) {
                }
                break;
            case 3:
                j = 0;
                i = this.framePayloadLen1;
                if (i != 126) {
                }
                if (unsignedShort <= this.config.maxFramePayloadLength()) {
                }
                break;
            case 4:
                j = 0;
                if (this.frameMasked) {
                }
                this.state = State.PAYLOAD;
                j2 = byteBuf.readableBytes();
                j3 = this.framePayloadLength;
                if (j2 < j3) {
                }
                break;
            case 5:
                j = 0;
                j2 = byteBuf.readableBytes();
                j3 = this.framePayloadLength;
                if (j2 < j3) {
                }
                break;
            case 6:
                if (byteBuf.isReadable()) {
                    byteBuf.readByte();
                    return;
                }
                return;
            default:
                throw new Error("Shouldn't reach here.");
        }
    }

    public WebSocket08FrameDecoder(boolean z, boolean z2, int i) {
        this(z, z2, i, false);
    }

    public WebSocket08FrameDecoder(WebSocketDecoderConfig webSocketDecoderConfig) {
        this.state = State.READING_FIRST;
        this.config = (WebSocketDecoderConfig) ObjectUtil.checkNotNull(webSocketDecoderConfig, "decoderConfig");
    }

    private void protocolViolation(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, WebSocketCloseStatus webSocketCloseStatus, String str) {
        protocolViolation(channelHandlerContext, byteBuf, new CorruptedWebSocketFrameException(webSocketCloseStatus, str));
    }

    private void protocolViolation(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, String str) {
        protocolViolation(channelHandlerContext, byteBuf, WebSocketCloseStatus.PROTOCOL_ERROR, str);
    }
}

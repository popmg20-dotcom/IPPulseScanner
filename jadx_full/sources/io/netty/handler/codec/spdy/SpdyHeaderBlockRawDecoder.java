package io.netty.handler.codec.spdy;

import com.tencent.mars.xlog.Xlog;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.util.internal.ObjectUtil;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class SpdyHeaderBlockRawDecoder extends SpdyHeaderBlockDecoder {
    private static final int LENGTH_FIELD_SIZE = 4;
    private ByteBuf cumulation;
    private int headerSize;
    private int length;
    private final int maxHeaderSize;
    private String name;
    private int numHeaders;
    private State state;

    /* JADX INFO: renamed from: io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$spdy$SpdyHeaderBlockRawDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$spdy$SpdyHeaderBlockRawDecoder$State = iArr;
            try {
                iArr[State.READ_NUM_HEADERS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyHeaderBlockRawDecoder$State[State.READ_NAME_LENGTH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyHeaderBlockRawDecoder$State[State.READ_NAME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyHeaderBlockRawDecoder$State[State.SKIP_NAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyHeaderBlockRawDecoder$State[State.READ_VALUE_LENGTH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyHeaderBlockRawDecoder$State[State.READ_VALUE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyHeaderBlockRawDecoder$State[State.SKIP_VALUE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyHeaderBlockRawDecoder$State[State.END_HEADER_BLOCK.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyHeaderBlockRawDecoder$State[State.ERROR.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public enum State {
        READ_NUM_HEADERS,
        READ_NAME_LENGTH,
        READ_NAME,
        SKIP_NAME,
        READ_VALUE_LENGTH,
        READ_VALUE,
        SKIP_VALUE,
        END_HEADER_BLOCK,
        ERROR
    }

    public SpdyHeaderBlockRawDecoder(SpdyVersion spdyVersion, int i) {
        ObjectUtil.checkNotNull(spdyVersion, "spdyVersion");
        this.maxHeaderSize = i;
        this.state = State.READ_NUM_HEADERS;
    }

    private static int readLengthField(ByteBuf byteBuf) {
        int signedInt = SpdyCodecUtil.getSignedInt(byteBuf, byteBuf.readerIndex());
        byteBuf.skipBytes(4);
        return signedInt;
    }

    private void releaseBuffer() {
        ByteBuf byteBuf = this.cumulation;
        if (byteBuf != null) {
            byteBuf.release();
            this.cumulation = null;
        }
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeaderBlockDecoder
    public void decode(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, SpdyHeadersFrame spdyHeadersFrame) {
        ObjectUtil.checkNotNull(byteBuf, "headerBlock");
        ObjectUtil.checkNotNull(spdyHeadersFrame, "frame");
        ByteBuf byteBuf2 = this.cumulation;
        if (byteBuf2 == null) {
            decodeHeaderBlock(byteBuf, spdyHeadersFrame);
            if (byteBuf.isReadable()) {
                ByteBuf byteBufBuffer = byteBufAllocator.buffer(byteBuf.readableBytes());
                this.cumulation = byteBufBuffer;
                byteBufBuffer.writeBytes(byteBuf);
                return;
            }
            return;
        }
        byteBuf2.writeBytes(byteBuf);
        decodeHeaderBlock(this.cumulation, spdyHeadersFrame);
        if (this.cumulation.isReadable()) {
            this.cumulation.discardReadBytes();
        } else {
            releaseBuffer();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x00b6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0000 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void decodeHeaderBlock(ByteBuf byteBuf, SpdyHeadersFrame spdyHeadersFrame) {
        int i;
        int i2;
        int i3;
        while (byteBuf.isReadable()) {
            switch (AnonymousClass1.$SwitchMap$io$netty$handler$codec$spdy$SpdyHeaderBlockRawDecoder$State[this.state.ordinal()]) {
                case 1:
                    if (byteBuf.readableBytes() < 4) {
                        return;
                    }
                    int lengthField = readLengthField(byteBuf);
                    this.numHeaders = lengthField;
                    if (lengthField < 0) {
                        this.state = State.ERROR;
                        spdyHeadersFrame.setInvalid();
                    } else if (lengthField != 0) {
                        this.state = State.READ_NAME_LENGTH;
                    } else {
                        this.state = State.END_HEADER_BLOCK;
                    }
                    break;
                case 2:
                    if (byteBuf.readableBytes() < 4) {
                        return;
                    }
                    int lengthField2 = readLengthField(byteBuf);
                    this.length = lengthField2;
                    if (lengthField2 > 0) {
                        int i4 = this.maxHeaderSize;
                        if (lengthField2 <= i4 && (i = this.headerSize) <= i4 - lengthField2) {
                            this.headerSize = i + lengthField2;
                            this.state = State.READ_NAME;
                        } else {
                            this.headerSize = i4 + 1;
                            this.state = State.SKIP_NAME;
                            spdyHeadersFrame.setTruncated();
                        }
                    } else {
                        this.state = State.ERROR;
                        spdyHeadersFrame.setInvalid();
                    }
                    break;
                case 3:
                    int i5 = byteBuf.readableBytes();
                    int i6 = this.length;
                    if (i5 < i6) {
                        return;
                    }
                    byte[] bArr = new byte[i6];
                    byteBuf.readBytes(bArr);
                    this.name = new String(bArr, "UTF-8");
                    if (!spdyHeadersFrame.headers().contains(this.name)) {
                        this.state = State.READ_VALUE_LENGTH;
                    } else {
                        this.state = State.ERROR;
                        spdyHeadersFrame.setInvalid();
                    }
                    break;
                case 4:
                    int iMin = Math.min(byteBuf.readableBytes(), this.length);
                    byteBuf.skipBytes(iMin);
                    int i7 = this.length - iMin;
                    this.length = i7;
                    if (i7 == 0) {
                        this.state = State.READ_VALUE_LENGTH;
                    }
                    break;
                case 5:
                    if (byteBuf.readableBytes() < 4) {
                        return;
                    }
                    int lengthField3 = readLengthField(byteBuf);
                    this.length = lengthField3;
                    if (lengthField3 < 0) {
                        this.state = State.ERROR;
                        spdyHeadersFrame.setInvalid();
                    } else if (lengthField3 != 0) {
                        int i8 = this.maxHeaderSize;
                        if (lengthField3 <= i8 && (i2 = this.headerSize) <= i8 - lengthField3) {
                            this.headerSize = i2 + lengthField3;
                            this.state = State.READ_VALUE;
                        } else {
                            this.headerSize = i8 + 1;
                            this.name = null;
                            this.state = State.SKIP_VALUE;
                            spdyHeadersFrame.setTruncated();
                        }
                    } else {
                        if (!spdyHeadersFrame.isTruncated()) {
                            spdyHeadersFrame.headers().add(this.name, "");
                        }
                        this.name = null;
                        int i9 = this.numHeaders - 1;
                        this.numHeaders = i9;
                        if (i9 != 0) {
                            this.state = State.READ_NAME_LENGTH;
                        } else {
                            this.state = State.END_HEADER_BLOCK;
                        }
                    }
                    break;
                case 6:
                    int i10 = byteBuf.readableBytes();
                    int i11 = this.length;
                    if (i10 < i11) {
                        return;
                    }
                    byte[] bArr2 = new byte[i11];
                    byteBuf.readBytes(bArr2);
                    int i12 = 0;
                    if (bArr2[0] == 0) {
                        this.state = State.ERROR;
                        spdyHeadersFrame.setInvalid();
                        break;
                    } else {
                        int i13 = 0;
                        while (i12 < this.length) {
                            while (i12 < i11 && bArr2[i12] != 0) {
                                i12++;
                            }
                            if (i12 < i11 && ((i3 = i12 + 1) == i11 || bArr2[i3] == 0)) {
                                this.state = State.ERROR;
                                spdyHeadersFrame.setInvalid();
                                this.name = null;
                                if (this.state == State.ERROR) {
                                    int i14 = this.numHeaders - 1;
                                    this.numHeaders = i14;
                                    if (i14 != 0) {
                                        this.state = State.READ_NAME_LENGTH;
                                    } else {
                                        this.state = State.END_HEADER_BLOCK;
                                    }
                                }
                                break;
                            } else {
                                try {
                                    spdyHeadersFrame.headers().add(this.name, new String(bArr2, i13, i12 - i13, "UTF-8"));
                                    i13 = i12 + 1;
                                    i12 = i13;
                                } catch (IllegalArgumentException unused) {
                                    this.state = State.ERROR;
                                    spdyHeadersFrame.setInvalid();
                                }
                            }
                        }
                        this.name = null;
                        if (this.state == State.ERROR) {
                        }
                    }
                    break;
                case 7:
                    int iMin2 = Math.min(byteBuf.readableBytes(), this.length);
                    byteBuf.skipBytes(iMin2);
                    int i15 = this.length - iMin2;
                    this.length = i15;
                    if (i15 == 0) {
                        int i16 = this.numHeaders - 1;
                        this.numHeaders = i16;
                        if (i16 != 0) {
                            this.state = State.READ_NAME_LENGTH;
                        } else {
                            this.state = State.END_HEADER_BLOCK;
                        }
                    }
                    break;
                case 8:
                    this.state = State.ERROR;
                    spdyHeadersFrame.setInvalid();
                    break;
                case Xlog.COMPRESS_LEVEL9 /* 9 */:
                    byteBuf.skipBytes(byteBuf.readableBytes());
                    return;
                default:
                    throw new Error("Shouldn't reach here.");
            }
        }
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeaderBlockDecoder
    public void end() {
        releaseBuffer();
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeaderBlockDecoder
    public void endHeaderBlock(SpdyHeadersFrame spdyHeadersFrame) {
        if (this.state != State.END_HEADER_BLOCK) {
            spdyHeadersFrame.setInvalid();
        }
        releaseBuffer();
        this.headerSize = 0;
        this.name = null;
        this.state = State.READ_NUM_HEADERS;
    }
}

package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;
import java.util.zip.Adler32;
import java.util.zip.Checksum;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class FastLzFrameDecoder extends ByteToMessageDecoder {
    private final ByteBufChecksum checksum;
    private int chunkLength;
    private int currentChecksum;
    private State currentState;
    private boolean hasChecksum;
    private boolean isCompressed;
    private int originalLength;

    /* JADX INFO: renamed from: io.netty.handler.codec.compression.FastLzFrameDecoder$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$FastLzFrameDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$compression$FastLzFrameDecoder$State = iArr;
            try {
                iArr[State.INIT_BLOCK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$FastLzFrameDecoder$State[State.INIT_BLOCK_PARAMS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$FastLzFrameDecoder$State[State.DECOMPRESS_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$FastLzFrameDecoder$State[State.CORRUPTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public enum State {
        INIT_BLOCK,
        INIT_BLOCK_PARAMS,
        DECOMPRESS_DATA,
        CORRUPTED
    }

    public FastLzFrameDecoder(Checksum checksum) {
        this.currentState = State.INIT_BLOCK;
        this.checksum = checksum == null ? null : ByteBufChecksum.wrapChecksum(checksum);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0092 A[Catch: Exception -> 0x001f, TRY_LEAVE, TryCatch #0 {Exception -> 0x001f, blocks: (B:2:0x0000, B:8:0x0017, B:12:0x0023, B:13:0x0028, B:46:0x0089, B:49:0x0092, B:80:0x0133, B:81:0x0136, B:28:0x0055, B:32:0x0060, B:36:0x0067, B:40:0x006d, B:42:0x0073, B:44:0x007f, B:45:0x0083, B:14:0x0029, B:17:0x0031, B:19:0x003a, B:23:0x0045, B:27:0x004f, B:82:0x0137, B:83:0x013e), top: B:86:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int i;
        Throwable th;
        ByteBuf byteBuf2;
        ByteBuf byteBufRetainedSlice;
        try {
            int i2 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$compression$FastLzFrameDecoder$State[this.currentState.ordinal()];
            int i3 = 4;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            throw new IllegalStateException();
                        }
                        byteBuf.skipBytes(byteBuf.readableBytes());
                        return;
                    }
                }
                i = this.chunkLength;
                if (byteBuf.readableBytes() >= i) {
                    return;
                }
                int i4 = byteBuf.readerIndex();
                int i5 = this.originalLength;
                ByteBuf byteBuf3 = null;
                try {
                    if (this.isCompressed) {
                        byteBufRetainedSlice = channelHandlerContext.alloc().buffer(i5);
                        try {
                            byteBuf2 = byteBuf;
                            int iDecompress = FastLz.decompress(byteBuf2, i4, i, byteBufRetainedSlice, byteBufRetainedSlice.writerIndex(), i5);
                            if (i5 != iDecompress) {
                                throw new DecompressionException(String.format("stream corrupted: originalLength(%d) and actual length(%d) mismatch", Integer.valueOf(i5), Integer.valueOf(iDecompress)));
                            }
                            byteBufRetainedSlice.writerIndex(byteBufRetainedSlice.writerIndex() + iDecompress);
                        } catch (Throwable th2) {
                            th = th2;
                            byteBuf3 = byteBufRetainedSlice;
                            if (byteBuf3 == null) {
                                throw th;
                            }
                            byteBuf3.release();
                            throw th;
                        }
                    } else {
                        byteBuf2 = byteBuf;
                        byteBufRetainedSlice = byteBuf2.retainedSlice(i4, i);
                    }
                    ByteBufChecksum byteBufChecksum = this.checksum;
                    if (this.hasChecksum && byteBufChecksum != null) {
                        byteBufChecksum.reset();
                        byteBufChecksum.update(byteBufRetainedSlice, byteBufRetainedSlice.readerIndex(), byteBufRetainedSlice.readableBytes());
                        int value = (int) byteBufChecksum.getValue();
                        if (value != this.currentChecksum) {
                            throw new DecompressionException(String.format("stream corrupted: mismatching checksum: %d (expected: %d)", Integer.valueOf(value), Integer.valueOf(this.currentChecksum)));
                        }
                    }
                    if (byteBufRetainedSlice.readableBytes() > 0) {
                        list.add(byteBufRetainedSlice);
                    } else {
                        byteBufRetainedSlice.release();
                    }
                    byteBuf2.skipBytes(i);
                    this.currentState = State.INIT_BLOCK;
                    return;
                } catch (Throwable th3) {
                    th = th3;
                }
            } else {
                if (byteBuf.readableBytes() < 4) {
                    return;
                }
                if (byteBuf.readUnsignedMedium() != 4607066) {
                    throw new DecompressionException("unexpected block identifier");
                }
                byte b = byteBuf.readByte();
                this.isCompressed = (b & 1) == 1;
                this.hasChecksum = (b & 16) == 16;
                this.currentState = State.INIT_BLOCK_PARAMS;
            }
            int i6 = byteBuf.readableBytes();
            int i7 = (this.isCompressed ? 2 : 0) + 2;
            boolean z = this.hasChecksum;
            if (!z) {
                i3 = 0;
            }
            if (i6 < i7 + i3) {
                return;
            }
            this.currentChecksum = z ? byteBuf.readInt() : 0;
            int unsignedShort = byteBuf.readUnsignedShort();
            this.chunkLength = unsignedShort;
            if (this.isCompressed) {
                unsignedShort = byteBuf.readUnsignedShort();
            }
            this.originalLength = unsignedShort;
            this.currentState = State.DECOMPRESS_DATA;
            i = this.chunkLength;
            if (byteBuf.readableBytes() >= i) {
            }
        } catch (Exception e) {
            this.currentState = State.CORRUPTED;
            throw e;
        }
    }

    public FastLzFrameDecoder(boolean z) {
        this(z ? new Adler32() : null);
    }

    public FastLzFrameDecoder() {
        this(false);
    }
}

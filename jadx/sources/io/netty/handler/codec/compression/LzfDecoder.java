package io.netty.handler.codec.compression;

import com.ning.compress.BufferRecycler;
import com.ning.compress.lzf.ChunkDecoder;
import com.ning.compress.lzf.util.ChunkDecoderFactory;
import io.netty.handler.codec.ByteToMessageDecoder;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class LzfDecoder extends ByteToMessageDecoder {
    private static final short MAGIC_NUMBER = 23126;
    private int chunkLength;
    private State currentState;
    private ChunkDecoder decoder;
    private boolean isCompressed;
    private int originalLength;
    private BufferRecycler recycler;

    /* JADX INFO: renamed from: io.netty.handler.codec.compression.LzfDecoder$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$LzfDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$compression$LzfDecoder$State = iArr;
            try {
                iArr[State.INIT_BLOCK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$LzfDecoder$State[State.INIT_ORIGINAL_LENGTH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$LzfDecoder$State[State.DECOMPRESS_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$LzfDecoder$State[State.CORRUPTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public enum State {
        INIT_BLOCK,
        INIT_ORIGINAL_LENGTH,
        DECOMPRESS_DATA,
        CORRUPTED
    }

    public LzfDecoder(boolean z) {
        this.currentState = State.INIT_BLOCK;
        this.decoder = z ? ChunkDecoderFactory.safeInstance() : ChunkDecoderFactory.optimalInstance();
        this.recycler = BufferRecycler.instance();
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x009c A[Catch: Exception -> 0x0026, TryCatch #0 {Exception -> 0x0026, blocks: (B:3:0x0007, B:9:0x001e, B:13:0x002a, B:14:0x002f, B:37:0x0093, B:40:0x009c, B:42:0x00a2, B:44:0x00ac, B:47:0x00c3, B:49:0x00d1, B:60:0x0107, B:62:0x010d, B:67:0x0120, B:63:0x0113, B:64:0x0116, B:51:0x00e2, B:46:0x00b8, B:66:0x0119, B:31:0x0080, B:34:0x0087, B:36:0x008f, B:69:0x0125, B:70:0x013c, B:15:0x0030, B:18:0x0038, B:20:0x0040, B:23:0x0048, B:27:0x0075, B:71:0x013d, B:72:0x0152, B:24:0x004f, B:25:0x006e, B:26:0x006f, B:73:0x0153, B:74:0x015a, B:53:0x00e5, B:55:0x00f2, B:59:0x0101, B:58:0x00fe), top: B:77:0x0007, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void decode(io.netty.channel.ChannelHandlerContext r13, io.netty.buffer.ByteBuf r14, java.util.List<java.lang.Object> r15) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 357
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.LzfDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }

    public LzfDecoder() {
        this(false);
    }
}

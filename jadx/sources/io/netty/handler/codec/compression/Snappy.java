package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.dns.DnsRecord;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class Snappy {
    private static final int COPY_1_BYTE_OFFSET = 1;
    private static final int COPY_2_BYTE_OFFSET = 2;
    private static final int COPY_4_BYTE_OFFSET = 3;
    private static final int LITERAL = 0;
    private static final int MAX_HT_SIZE = 16384;
    private static final int MIN_COMPRESSIBLE_BYTES = 15;
    private static final int NOT_ENOUGH_INPUT = -1;
    private static final int PREAMBLE_NOT_FULL = -1;
    private State state = State.READING_PREAMBLE;
    private byte tag;
    private int written;

    /* JADX INFO: renamed from: io.netty.handler.codec.compression.Snappy$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$Snappy$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$compression$Snappy$State = iArr;
            try {
                iArr[State.READING_PREAMBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Snappy$State[State.READING_TAG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Snappy$State[State.READING_LITERAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Snappy$State[State.READING_COPY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public enum State {
        READING_PREAMBLE,
        READING_TAG,
        READING_LITERAL,
        READING_COPY
    }

    private static int bitsToEncode(int i) {
        int iHighestOneBit = Integer.highestOneBit(i);
        int i2 = 0;
        while (true) {
            iHighestOneBit >>= 1;
            if (iHighestOneBit == 0) {
                return i2;
            }
            i2++;
        }
    }

    public static int calculateChecksum(ByteBuf byteBuf, int i, int i2) {
        Crc32c crc32c = new Crc32c();
        try {
            crc32c.update(byteBuf, i, i2);
            return maskChecksum(crc32c.getValue());
        } finally {
            crc32c.reset();
        }
    }

    private static int decodeCopyWith1ByteOffset(byte b, ByteBuf byteBuf, ByteBuf byteBuf2, int i) {
        if (!byteBuf.isReadable()) {
            return -1;
        }
        int iWriterIndex = byteBuf2.writerIndex();
        int i2 = ((b & 28) >> 2) + 4;
        int unsignedByte = (((b & 224) << 8) >> 5) | byteBuf.readUnsignedByte();
        validateOffset(unsignedByte, i);
        byteBuf2.markReaderIndex();
        if (unsignedByte < i2) {
            for (int i3 = i2 / unsignedByte; i3 > 0; i3--) {
                byteBuf2.readerIndex(iWriterIndex - unsignedByte);
                byteBuf2.readBytes(byteBuf2, unsignedByte);
            }
            int i4 = i2 % unsignedByte;
            if (i4 != 0) {
                byteBuf2.readerIndex(iWriterIndex - unsignedByte);
                byteBuf2.readBytes(byteBuf2, i4);
            }
        } else {
            byteBuf2.readerIndex(iWriterIndex - unsignedByte);
            byteBuf2.readBytes(byteBuf2, i2);
        }
        byteBuf2.resetReaderIndex();
        return i2;
    }

    private static int decodeCopyWith2ByteOffset(byte b, ByteBuf byteBuf, ByteBuf byteBuf2, int i) {
        if (byteBuf.readableBytes() < 2) {
            return -1;
        }
        int iWriterIndex = byteBuf2.writerIndex();
        int i2 = ((b >> 2) & 63) + 1;
        int unsignedShortLE = byteBuf.readUnsignedShortLE();
        validateOffset(unsignedShortLE, i);
        byteBuf2.markReaderIndex();
        if (unsignedShortLE < i2) {
            for (int i3 = i2 / unsignedShortLE; i3 > 0; i3--) {
                byteBuf2.readerIndex(iWriterIndex - unsignedShortLE);
                byteBuf2.readBytes(byteBuf2, unsignedShortLE);
            }
            int i4 = i2 % unsignedShortLE;
            if (i4 != 0) {
                byteBuf2.readerIndex(iWriterIndex - unsignedShortLE);
                byteBuf2.readBytes(byteBuf2, i4);
            }
        } else {
            byteBuf2.readerIndex(iWriterIndex - unsignedShortLE);
            byteBuf2.readBytes(byteBuf2, i2);
        }
        byteBuf2.resetReaderIndex();
        return i2;
    }

    private static int decodeCopyWith4ByteOffset(byte b, ByteBuf byteBuf, ByteBuf byteBuf2, int i) {
        if (byteBuf.readableBytes() < 4) {
            return -1;
        }
        int iWriterIndex = byteBuf2.writerIndex();
        int i2 = ((b >> 2) & 63) + 1;
        int intLE = byteBuf.readIntLE();
        validateOffset(intLE, i);
        byteBuf2.markReaderIndex();
        if (intLE < i2) {
            for (int i3 = i2 / intLE; i3 > 0; i3--) {
                byteBuf2.readerIndex(iWriterIndex - intLE);
                byteBuf2.readBytes(byteBuf2, intLE);
            }
            int i4 = i2 % intLE;
            if (i4 != 0) {
                byteBuf2.readerIndex(iWriterIndex - intLE);
                byteBuf2.readBytes(byteBuf2, i4);
            }
        } else {
            byteBuf2.readerIndex(iWriterIndex - intLE);
            byteBuf2.readBytes(byteBuf2, i2);
        }
        byteBuf2.resetReaderIndex();
        return i2;
    }

    public static int decodeLiteral(byte b, ByteBuf byteBuf, ByteBuf byteBuf2) {
        byteBuf.markReaderIndex();
        int unsignedByte = (b >> 2) & 63;
        switch (unsignedByte) {
            case 60:
                if (!byteBuf.isReadable()) {
                    return -1;
                }
                unsignedByte = byteBuf.readUnsignedByte();
                break;
                break;
            case 61:
                if (byteBuf.readableBytes() < 2) {
                    return -1;
                }
                unsignedByte = byteBuf.readUnsignedShortLE();
                break;
            case 62:
                if (byteBuf.readableBytes() < 3) {
                    return -1;
                }
                unsignedByte = byteBuf.readUnsignedMediumLE();
                break;
            case 63:
                if (byteBuf.readableBytes() < 4) {
                    return -1;
                }
                unsignedByte = byteBuf.readIntLE();
                break;
        }
        int i = unsignedByte + 1;
        if (byteBuf.readableBytes() < i) {
            byteBuf.resetReaderIndex();
            return -1;
        }
        byteBuf2.writeBytes(byteBuf, i);
        return i;
    }

    private static void encodeCopy(ByteBuf byteBuf, int i, int i2) {
        while (i2 >= 68) {
            encodeCopyWithOffset(byteBuf, i, 64);
            i2 -= 64;
        }
        if (i2 > 64) {
            encodeCopyWithOffset(byteBuf, i, 60);
            i2 -= 60;
        }
        encodeCopyWithOffset(byteBuf, i, i2);
    }

    private static void encodeCopyWithOffset(ByteBuf byteBuf, int i, int i2) {
        if (i2 < 12 && i < 2048) {
            byteBuf.writeByte(((i2 - 4) << 2) | 1 | ((i >> 8) << 5));
            byteBuf.writeByte(i & DnsRecord.CLASS_ANY);
        } else {
            byteBuf.writeByte(((i2 - 1) << 2) | 2);
            byteBuf.writeByte(i & DnsRecord.CLASS_ANY);
            byteBuf.writeByte((i >> 8) & DnsRecord.CLASS_ANY);
        }
    }

    public static void encodeLiteral(ByteBuf byteBuf, ByteBuf byteBuf2, int i) {
        if (i < 61) {
            byteBuf2.writeByte((i - 1) << 2);
        } else {
            int i2 = i - 1;
            int iBitsToEncode = bitsToEncode(i2) / 8;
            int i3 = iBitsToEncode + 1;
            byteBuf2.writeByte((iBitsToEncode + 60) << 2);
            for (int i4 = 0; i4 < i3; i4++) {
                byteBuf2.writeByte((i2 >> (i4 * 8)) & DnsRecord.CLASS_ANY);
            }
        }
        byteBuf2.writeBytes(byteBuf, i);
    }

    private static int findMatchingLength(ByteBuf byteBuf, int i, int i2, int i3) {
        int i4 = 0;
        while (i2 <= i3 - 4 && byteBuf.getInt(i2) == byteBuf.getInt(i + i4)) {
            i2 += 4;
            i4 += 4;
        }
        while (i2 < i3 && byteBuf.getByte(i + i4) == byteBuf.getByte(i2)) {
            i2++;
            i4++;
        }
        return i4;
    }

    private static short[] getHashTable(int i) {
        int i2 = 256;
        while (i2 < MAX_HT_SIZE && i2 < i) {
            i2 <<= 1;
        }
        return new short[i2];
    }

    private static int hash(ByteBuf byteBuf, int i, int i2) {
        return (byteBuf.getInt(i) * 506832829) >>> i2;
    }

    public static int maskChecksum(long j) {
        return (int) (((j << 17) | (j >> 15)) - 1568478504);
    }

    private static int readPreamble(ByteBuf byteBuf) {
        int i = 0;
        int i2 = 0;
        while (byteBuf.isReadable()) {
            short unsignedByte = byteBuf.readUnsignedByte();
            int i3 = i2 + 1;
            i |= (unsignedByte & 127) << (i2 * 7);
            if ((unsignedByte & 128) == 0) {
                return i;
            }
            if (i3 >= 4) {
                throw new DecompressionException("Preamble is greater than 4 bytes");
            }
            i2 = i3;
        }
        return 0;
    }

    public static void validateChecksum(int i, ByteBuf byteBuf, int i2, int i3) {
        int iCalculateChecksum = calculateChecksum(byteBuf, i2, i3);
        if (iCalculateChecksum == i) {
            return;
        }
        throw new DecompressionException("mismatching checksum: " + Integer.toHexString(iCalculateChecksum) + " (expected: " + Integer.toHexString(i) + ')');
    }

    private static void validateOffset(int i, int i2) {
        if (i == 0) {
            throw new DecompressionException("Offset is less than minimum permissible value");
        }
        if (i < 0) {
            throw new DecompressionException("Offset is greater than maximum value supported by this implementation");
        }
        if (i > i2) {
            throw new DecompressionException("Offset exceeds size of chunk");
        }
    }

    public void decode(ByteBuf byteBuf, ByteBuf byteBuf2) {
        while (byteBuf.isReadable()) {
            int i = AnonymousClass1.$SwitchMap$io$netty$handler$codec$compression$Snappy$State[this.state.ordinal()];
            if (i == 1) {
                int preamble = readPreamble(byteBuf);
                if (preamble == -1 || preamble == 0) {
                    return;
                }
                byteBuf2.ensureWritable(preamble);
                this.state = State.READING_TAG;
            } else if (i != 2) {
                if (i == 3) {
                    int iDecodeLiteral = decodeLiteral(this.tag, byteBuf, byteBuf2);
                    if (iDecodeLiteral == -1) {
                        return;
                    }
                    this.state = State.READING_TAG;
                    this.written += iDecodeLiteral;
                } else if (i == 4) {
                    byte b = this.tag;
                    int i2 = b & 3;
                    if (i2 == 1) {
                        int iDecodeCopyWith1ByteOffset = decodeCopyWith1ByteOffset(b, byteBuf, byteBuf2, this.written);
                        if (iDecodeCopyWith1ByteOffset == -1) {
                            return;
                        }
                        this.state = State.READING_TAG;
                        this.written += iDecodeCopyWith1ByteOffset;
                    } else if (i2 == 2) {
                        int iDecodeCopyWith2ByteOffset = decodeCopyWith2ByteOffset(b, byteBuf, byteBuf2, this.written);
                        if (iDecodeCopyWith2ByteOffset == -1) {
                            return;
                        }
                        this.state = State.READING_TAG;
                        this.written += iDecodeCopyWith2ByteOffset;
                    } else if (i2 == 3) {
                        int iDecodeCopyWith4ByteOffset = decodeCopyWith4ByteOffset(b, byteBuf, byteBuf2, this.written);
                        if (iDecodeCopyWith4ByteOffset == -1) {
                            return;
                        }
                        this.state = State.READING_TAG;
                        this.written += iDecodeCopyWith4ByteOffset;
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            if (!byteBuf.isReadable()) {
                return;
            }
            byte b2 = byteBuf.readByte();
            this.tag = b2;
            int i3 = b2 & 3;
            if (i3 == 0) {
                this.state = State.READING_LITERAL;
            } else if (i3 == 1 || i3 == 2 || i3 == 3) {
                this.state = State.READING_COPY;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0055, code lost:
    
        encodeLiteral(r12, r13, r2 - r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005a, code lost:
    
        r3 = findMatchingLength(r12, r9 + 4, r2 + 4, r14) + 4;
        r4 = r2 + r3;
        encodeCopy(r13, r2 - r9, r3);
        r12.readerIndex(r12.readerIndex() + r3);
        r2 = r4 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0074, code lost:
    
        if (r4 < r7) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0077, code lost:
    
        r3 = r4 - r11;
        r0[hash(r12, r2, r1)] = (short) (r3 - 1);
        r2 = hash(r12, r4, r1);
        r9 = r11 + r0[r2];
        r0[r2] = (short) r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0095, code lost:
    
        if (r12.getInt(r4) == r12.getInt(r9)) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a0, code lost:
    
        r2 = r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void encode(io.netty.buffer.ByteBuf r12, io.netty.buffer.ByteBuf r13, int r14) {
        /*
            r11 = this;
            r11 = 0
        L1:
            int r0 = r11 * 7
            int r0 = r14 >>> r0
            r1 = r0 & (-128(0xffffffffffffff80, float:NaN))
            if (r1 == 0) goto L13
            r0 = r0 & 127(0x7f, float:1.78E-43)
            r0 = r0 | 128(0x80, float:1.8E-43)
            r13.writeByte(r0)
            int r11 = r11 + 1
            goto L1
        L13:
            r13.writeByte(r0)
            int r11 = r12.readerIndex()
            short[] r0 = getHashTable(r14)
            int r1 = r0.length
            int r1 = java.lang.Integer.numberOfLeadingZeros(r1)
            int r1 = r1 + 1
            int r2 = r14 - r11
            r3 = 15
            if (r2 < r3) goto La6
            int r2 = r11 + 1
            int r3 = hash(r12, r2, r1)
            r4 = r11
        L32:
            r5 = 32
        L34:
            int r6 = r5 + 1
            int r5 = r5 >> 5
            int r5 = r5 + r2
            int r7 = r14 + (-4)
            if (r5 <= r7) goto L3f
        L3d:
            r11 = r4
            goto La6
        L3f:
            int r8 = hash(r12, r5, r1)
            short r9 = r0[r3]
            int r9 = r9 + r11
            int r10 = r2 - r11
            short r10 = (short) r10
            r0[r3] = r10
            int r3 = r12.getInt(r2)
            int r10 = r12.getInt(r9)
            if (r3 != r10) goto La2
            int r3 = r2 - r4
            encodeLiteral(r12, r13, r3)
        L5a:
            int r3 = r9 + 4
            int r4 = r2 + 4
            int r3 = findMatchingLength(r12, r3, r4, r14)
            int r3 = r3 + 4
            int r4 = r2 + r3
            int r2 = r2 - r9
            encodeCopy(r13, r2, r3)
            int r2 = r12.readerIndex()
            int r2 = r2 + r3
            r12.readerIndex(r2)
            int r2 = r4 + (-1)
            if (r4 < r7) goto L77
            goto L3d
        L77:
            int r2 = hash(r12, r2, r1)
            int r3 = r4 - r11
            int r5 = r3 + (-1)
            short r5 = (short) r5
            r0[r2] = r5
            int r2 = hash(r12, r4, r1)
            short r5 = r0[r2]
            int r9 = r11 + r5
            short r3 = (short) r3
            r0[r2] = r3
            int r2 = r12.getInt(r4)
            int r3 = r12.getInt(r9)
            if (r2 == r3) goto La0
            int r2 = r4 + 1
            int r3 = hash(r12, r2, r1)
            int r2 = r4 + 1
            goto L32
        La0:
            r2 = r4
            goto L5a
        La2:
            r2 = r5
            r5 = r6
            r3 = r8
            goto L34
        La6:
            if (r11 >= r14) goto Lac
            int r14 = r14 - r11
            encodeLiteral(r12, r13, r14)
        Lac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.Snappy.encode(io.netty.buffer.ByteBuf, io.netty.buffer.ByteBuf, int):void");
    }

    public int getPreamble(ByteBuf byteBuf) {
        if (this.state != State.READING_PREAMBLE) {
            return 0;
        }
        int i = byteBuf.readerIndex();
        try {
            return readPreamble(byteBuf);
        } finally {
            byteBuf.readerIndex(i);
        }
    }

    public void reset() {
        this.state = State.READING_PREAMBLE;
        this.tag = (byte) 0;
        this.written = 0;
    }

    public static int calculateChecksum(ByteBuf byteBuf) {
        return calculateChecksum(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    public static void validateChecksum(int i, ByteBuf byteBuf) {
        validateChecksum(i, byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }
}

package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.HttpConstants;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
final class FastLz {
    static final byte BLOCK_TYPE_COMPRESSED = 1;
    static final byte BLOCK_TYPE_NON_COMPRESSED = 0;
    static final byte BLOCK_WITHOUT_CHECKSUM = 0;
    static final byte BLOCK_WITH_CHECKSUM = 16;
    static final int CHECKSUM_OFFSET = 4;
    private static final int HASH_LOG = 13;
    private static final int HASH_MASK = 8191;
    private static final int HASH_SIZE = 8192;
    static final int LEVEL_1 = 1;
    static final int LEVEL_2 = 2;
    static final int LEVEL_AUTO = 0;
    static final int MAGIC_NUMBER = 4607066;
    static final int MAX_CHUNK_LENGTH = 65535;
    private static final int MAX_COPY = 32;
    private static final int MAX_DISTANCE = 8191;
    private static final int MAX_FARDISTANCE = 73725;
    private static final int MAX_LEN = 264;
    static final int MIN_LENGTH_TO_COMPRESSION = 32;
    private static final int MIN_RECOMENDED_LENGTH_FOR_LEVEL_2 = 65536;
    static final int OPTIONS_OFFSET = 3;

    private FastLz() {
    }

    public static int calculateOutputBufferLength(int i) {
        return Math.max((int) (((double) i) * 1.06d), 66);
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int compress(ByteBuf byteBuf, int i, int i2, ByteBuf byteBuf2, int i3, int i4) {
        int i5;
        long j;
        int i6;
        boolean z;
        int i7;
        long j2;
        boolean z2;
        int i8;
        int i9;
        int i10;
        char c;
        int i11 = 2;
        boolean z3 = true;
        int i12 = i4 == 0 ? i2 < MIN_RECOMENDED_LENGTH_FOR_LEVEL_2 ? 1 : 2 : i4;
        int i13 = i2 - 2;
        int i14 = i2 - 12;
        int[] iArr = new int[8192];
        if (i2 < 4) {
            if (i2 == 0) {
                return 0;
            }
            byteBuf2.setByte(i3, (byte) (i2 - 1));
            int i15 = i2 - 1;
            int i16 = 1;
            for (int i17 = 0; i17 <= i15; i17++) {
                byteBuf2.setByte(i16 + i3, byteBuf.getByte(i + i17));
                i16++;
            }
            return i2 + 1;
        }
        for (int i18 = 0; i18 < 8192; i18++) {
            iArr[i18] = 0;
        }
        byteBuf2.setByte(i3, 31);
        byteBuf2.setByte(i3 + 1, byteBuf.getByte(i));
        byteBuf2.setByte(i3 + 2, byteBuf.getByte(i + 1));
        int i19 = 2;
        int i20 = 2;
        int i21 = 3;
        while (i19 < i14) {
            if (i12 == i11) {
                int i22 = i + i19;
                int i23 = i22 - 1;
                if (byteBuf.getByte(i22) == byteBuf.getByte(i23) && readU16(byteBuf, i23) == readU16(byteBuf, i22 + 1)) {
                    i5 = i19 + 3;
                    i6 = i19 + 2;
                    z = z3;
                    j = 1;
                } else {
                    i5 = i19;
                    j = 0;
                    i6 = 0;
                    z = false;
                }
            }
            if (!z) {
                int i24 = i + i5;
                int iHashFunction = hashFunction(byteBuf, i24);
                int i25 = iArr[iHashFunction];
                int i26 = i5;
                long j3 = i19 - i25;
                iArr[iHashFunction] = i19;
                if (j3 == 0 || (i12 != 1 ? j3 >= 73725 : j3 >= 8191)) {
                    i9 = i21 + 1;
                    i10 = i19 + 1;
                    byteBuf2.setByte(i3 + i21, byteBuf.getByte(i + i19));
                    i20++;
                    if (i20 == 32) {
                        i21 += 2;
                        c = 31;
                        byteBuf2.setByte(i9 + i3, 31);
                        i19 = i10;
                        i11 = 2;
                        z3 = true;
                        i20 = 0;
                    } else {
                        i21 = i9;
                        i19 = i10;
                        i11 = 2;
                        z3 = true;
                    }
                } else {
                    int i27 = i25 + 1;
                    int i28 = i26 + 1;
                    if (byteBuf.getByte(i + i25) == byteBuf.getByte(i24)) {
                        int i29 = i25 + 2;
                        byte b = byteBuf.getByte(i + i27);
                        int i30 = i26 + 2;
                        if (b == byteBuf.getByte(i + i28)) {
                            i6 = i25 + 3;
                            int i31 = i26 + 3;
                            if (byteBuf.getByte(i + i29) == byteBuf.getByte(i + i30)) {
                                if (i12 != 2 || j3 < 8191) {
                                    j = j3;
                                } else {
                                    int i32 = i26 + 4;
                                    byte b2 = byteBuf.getByte(i + i31);
                                    int i33 = i25 + 4;
                                    if (b2 == byteBuf.getByte(i + i6)) {
                                        i6 = i25 + 5;
                                        if (byteBuf.getByte(i + i32) == byteBuf.getByte(i + i33)) {
                                            i7 = 5;
                                            j = j3;
                                            int i34 = i7 + i19;
                                            j2 = j - 1;
                                            if (j2 != 0) {
                                                byte b3 = byteBuf.getByte((i + i34) - 1);
                                                while (i34 < i13) {
                                                    int i35 = i6 + 1;
                                                    if (byteBuf.getByte(i + i6) != b3) {
                                                        break;
                                                    }
                                                    i34++;
                                                    i6 = i35;
                                                }
                                            } else {
                                                int i36 = 0;
                                                while (true) {
                                                    if (i36 >= 8) {
                                                        z2 = false;
                                                        break;
                                                    }
                                                    int i37 = i6 + 1;
                                                    int i38 = i34 + 1;
                                                    if (byteBuf.getByte(i + i6) != byteBuf.getByte(i + i34)) {
                                                        i6 = i37;
                                                        i34 = i38;
                                                        z2 = true;
                                                        break;
                                                    }
                                                    i36++;
                                                    i6 = i37;
                                                    i34 = i38;
                                                }
                                                if (!z2) {
                                                    while (true) {
                                                        if (i34 >= i13) {
                                                            break;
                                                        }
                                                        int i39 = i6 + 1;
                                                        int i40 = i34 + 1;
                                                        if (byteBuf.getByte(i + i6) != byteBuf.getByte(i + i34)) {
                                                            i34 = i40;
                                                            break;
                                                        }
                                                        i6 = i39;
                                                        i34 = i40;
                                                    }
                                                }
                                            }
                                            if (i20 == 0) {
                                                byteBuf2.setByte(((i3 + i21) - i20) - 1, (byte) (i20 - 1));
                                            } else {
                                                i21--;
                                            }
                                            int i41 = i34 - 3;
                                            int i42 = i41 - i19;
                                            int i43 = 7;
                                            if (i12 == 2) {
                                                int i44 = 262;
                                                if (i42 > 262) {
                                                    while (i42 > i44) {
                                                        byteBuf2.setByte(i3 + i21, (byte) ((j2 >>> 8) + 224));
                                                        byteBuf2.setByte(i3 + i21 + 1, -3);
                                                        byteBuf2.setByte(i21 + 2 + i3, (byte) (j2 & 255));
                                                        i42 -= 262;
                                                        i21 += 3;
                                                        i44 = 262;
                                                        i43 = 7;
                                                    }
                                                }
                                                if (i42 < i43) {
                                                    int i45 = i21 + 1;
                                                    byteBuf2.setByte(i3 + i21, (byte) (((long) (i42 << 5)) + (j2 >>> 8)));
                                                    i8 = i21 + 2;
                                                    byteBuf2.setByte(i45 + i3, (byte) (j2 & 255));
                                                } else {
                                                    byteBuf2.setByte(i3 + i21, (byte) ((j2 >>> 8) + 224));
                                                    int i46 = i21 + 2;
                                                    byteBuf2.setByte(i21 + 1 + i3, (byte) (i42 - 7));
                                                    i8 = i21 + 3;
                                                    byteBuf2.setByte(i3 + i46, (byte) (j2 & 255));
                                                }
                                            } else if (j2 < 8191) {
                                                if (i42 < 7) {
                                                    int i47 = i21 + 1;
                                                    byteBuf2.setByte(i3 + i21, (byte) (((long) (i42 << 5)) + (j2 >>> 8)));
                                                    i8 = i21 + 2;
                                                    byteBuf2.setByte(i3 + i47, (byte) (j2 & 255));
                                                } else {
                                                    int i48 = i21 + 1;
                                                    byteBuf2.setByte(i3 + i21, (byte) ((j2 >>> 8) + 224));
                                                    int i49 = i42 - 7;
                                                    while (i49 >= 255) {
                                                        byteBuf2.setByte(i48 + i3, -1);
                                                        i49 -= 255;
                                                        i48++;
                                                    }
                                                    byteBuf2.setByte(i3 + i48, (byte) i49);
                                                    i8 = i48 + 2;
                                                    byteBuf2.setByte(i3 + i48 + 1, (byte) (j2 & 255));
                                                }
                                            } else if (i42 < 7) {
                                                long j4 = j - 8192;
                                                byteBuf2.setByte(i3 + i21, (byte) ((i42 << 5) + 31));
                                                byteBuf2.setByte(i21 + 1 + i3, -1);
                                                int i50 = i21 + 3;
                                                byteBuf2.setByte(i21 + 2 + i3, (byte) (j4 >>> 8));
                                                i8 = i21 + 4;
                                                byteBuf2.setByte(i50 + i3, (byte) (j4 & 255));
                                            } else {
                                                long j5 = j - 8192;
                                                int i51 = i21 + 1;
                                                byteBuf2.setByte(i3 + i21, -1);
                                                int i52 = i42 - 7;
                                                while (i52 >= 255) {
                                                    byteBuf2.setByte(i51 + i3, -1);
                                                    i52 -= 255;
                                                    i51++;
                                                }
                                                byteBuf2.setByte(i3 + i51, (byte) i52);
                                                byteBuf2.setByte(i51 + 1 + i3, -1);
                                                byteBuf2.setByte(i51 + 2 + i3, (byte) (j5 >>> 8));
                                                i8 = i51 + 4;
                                                byteBuf2.setByte(i3 + i51 + 3, (byte) (j5 & 255));
                                            }
                                            int i53 = i34 - 2;
                                            iArr[hashFunction(byteBuf, i + i41)] = i41;
                                            i19 = i34 - 1;
                                            iArr[hashFunction(byteBuf, i + i53)] = i53;
                                            byteBuf2.setByte(i3 + i8, 31);
                                            i21 = i8 + 1;
                                            i11 = 2;
                                            z3 = true;
                                            i20 = 0;
                                        }
                                    }
                                    i9 = i21 + 1;
                                    i10 = i19 + 1;
                                    byteBuf2.setByte(i3 + i21, byteBuf.getByte(i + i19));
                                    i20++;
                                    if (i20 == 32) {
                                        i21 += 2;
                                        c = 31;
                                        byteBuf2.setByte(i9 + i3, 31);
                                        i19 = i10;
                                        i11 = 2;
                                        z3 = true;
                                        i20 = 0;
                                    } else {
                                        i21 = i9;
                                        i19 = i10;
                                        i11 = 2;
                                        z3 = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            i7 = 3;
            int i342 = i7 + i19;
            j2 = j - 1;
            if (j2 != 0) {
            }
            if (i20 == 0) {
            }
            int i412 = i342 - 3;
            int i422 = i412 - i19;
            int i432 = 7;
            if (i12 == 2) {
            }
            int i532 = i342 - 2;
            iArr[hashFunction(byteBuf, i + i412)] = i412;
            i19 = i342 - 1;
            iArr[hashFunction(byteBuf, i + i532)] = i532;
            byteBuf2.setByte(i3 + i8, 31);
            i21 = i8 + 1;
            i11 = 2;
            z3 = true;
            i20 = 0;
        }
        int i54 = i2 - 1;
        while (i19 <= i54) {
            int i55 = i21 + 1;
            int i56 = i19 + 1;
            byteBuf2.setByte(i3 + i21, byteBuf.getByte(i + i19));
            i20++;
            if (i20 == 32) {
                i21 += 2;
                byteBuf2.setByte(i55 + i3, 31);
                i19 = i56;
                i20 = 0;
            } else {
                i21 = i55;
                i19 = i56;
            }
        }
        if (i20 != 0) {
            byteBuf2.setByte(((i3 + i21) - i20) - 1, (byte) (i20 - 1));
        } else {
            i21--;
        }
        if (i12 == 2) {
            byteBuf2.setByte(i3, byteBuf2.getByte(i3) | HttpConstants.SP);
        }
        return i21;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int decompress(ByteBuf byteBuf, int i, int i2, ByteBuf byteBuf2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int unsignedByte;
        short unsignedByte2;
        char c = 5;
        int i10 = 1;
        int i11 = (byteBuf.getByte(i) >> 5) + 1;
        int i12 = 0;
        if (i11 != 1 && i11 != 2) {
            throw new DecompressionException(String.format("invalid level: %d (expected: %d or %d)", Integer.valueOf(i11), 1, 2));
        }
        long unsignedByte3 = byteBuf.getByte(i) & 31;
        int i13 = 1;
        int i14 = 1;
        int i15 = 0;
        while (true) {
            long j = unsignedByte3 >> c;
            long j2 = (31 & unsignedByte3) << 8;
            if (unsignedByte3 >= 32) {
                long unsignedByte4 = j - 1;
                i7 = i12;
                long j3 = unsignedByte3;
                long j4 = i15;
                int i16 = (int) (j4 - j2);
                if (unsignedByte4 != 6) {
                    i8 = i15;
                } else if (i11 == 1) {
                    i8 = i15;
                    unsignedByte4 += (long) byteBuf.getUnsignedByte(i + i13);
                    i13++;
                } else {
                    i8 = i15;
                    do {
                        unsignedByte2 = byteBuf.getUnsignedByte(i + i13);
                        unsignedByte4 += (long) unsignedByte2;
                        i13++;
                    } while (unsignedByte2 == 255);
                }
                if (i11 == 1) {
                    i9 = i13 + 1;
                    unsignedByte = i16 - byteBuf.getUnsignedByte(i + i13);
                } else {
                    i9 = i13 + 1;
                    short unsignedByte5 = byteBuf.getUnsignedByte(i + i13);
                    unsignedByte = i16 - unsignedByte5;
                    if (unsignedByte5 == 255 && j2 == 7936) {
                        long unsignedByte6 = byteBuf.getUnsignedByte(i + i9) << 8;
                        i9 = i13 + 3;
                        i5 = i11;
                        unsignedByte = (int) ((j4 - (unsignedByte6 + ((long) byteBuf.getUnsignedByte(i + (i13 + 2))))) - 8191);
                    }
                    if (j4 + unsignedByte4 + 3 <= i4) {
                        return i7;
                    }
                    if (unsignedByte - 1 < 0) {
                        return i7;
                    }
                    if (i9 < i2) {
                        unsignedByte3 = byteBuf.getUnsignedByte(i + i9);
                        i9++;
                    } else {
                        i14 = i7;
                        unsignedByte3 = j3;
                    }
                    int i17 = i8;
                    if (unsignedByte == i17) {
                        i6 = 1;
                        byte b = byteBuf2.getByte((i3 + unsignedByte) - 1);
                        byteBuf2.setByte(i3 + i17, b);
                        byteBuf2.setByte(i3 + i17 + 1, b);
                        i15 = i17 + 3;
                        byteBuf2.setByte(i3 + i17 + 2, b);
                        while (unsignedByte4 != 0) {
                            byteBuf2.setByte(i3 + i15, b);
                            unsignedByte4--;
                            i15++;
                        }
                    } else {
                        i6 = 1;
                        byteBuf2.setByte(i3 + i17, byteBuf2.getByte(i3 + (unsignedByte - 1)));
                        int i18 = unsignedByte + 1;
                        byteBuf2.setByte(i3 + i17 + 1, byteBuf2.getByte(i3 + unsignedByte));
                        i15 = i17 + 3;
                        int i19 = unsignedByte + 2;
                        byteBuf2.setByte(i3 + i17 + 2, byteBuf2.getByte(i3 + i18));
                        while (unsignedByte4 != 0) {
                            byteBuf2.setByte(i3 + i15, byteBuf2.getByte(i3 + i19));
                            unsignedByte4--;
                            i15++;
                            i19++;
                        }
                    }
                    i13 = i9;
                }
                i5 = i11;
                if (j4 + unsignedByte4 + 3 <= i4) {
                }
            } else {
                i5 = i11;
                i6 = i10;
                i7 = i12;
                long j5 = unsignedByte3;
                int i20 = i15;
                long j6 = j5 + 1;
                if (((long) i20) + j6 > i4) {
                    return i7;
                }
                if (((long) i13) + j6 > i2) {
                    return i7;
                }
                i15 = i20 + 1;
                int i21 = i13 + 1;
                byteBuf2.setByte(i3 + i20, byteBuf.getByte(i + i13));
                unsignedByte3 = j5;
                while (unsignedByte3 != 0) {
                    byteBuf2.setByte(i3 + i15, byteBuf.getByte(i + i21));
                    unsignedByte3--;
                    i15++;
                    i21++;
                }
                int i22 = i21 < i2 ? i6 : i7;
                if (i22 != 0) {
                    i13 = i21 + 1;
                    i14 = i22;
                    unsignedByte3 = byteBuf.getUnsignedByte(i + i21);
                } else {
                    i13 = i21;
                    i14 = i22;
                }
            }
            if (i14 == 0) {
                return i15;
            }
            i11 = i5;
            i12 = i7;
            i10 = i6;
            c = 5;
        }
    }

    private static int hashFunction(ByteBuf byteBuf, int i) {
        int u16 = readU16(byteBuf, i);
        return ((readU16(byteBuf, i + 1) ^ (u16 >> 3)) ^ u16) & 8191;
    }

    private static int readU16(ByteBuf byteBuf, int i) {
        int i2 = i + 1;
        if (i2 >= byteBuf.readableBytes()) {
            return byteBuf.getUnsignedByte(i);
        }
        return byteBuf.getUnsignedByte(i) | (byteBuf.getUnsignedByte(i2) << 8);
    }
}

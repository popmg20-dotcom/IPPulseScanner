package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.util.CharsetUtil;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
final class DnsCodecUtil {
    private DnsCodecUtil() {
    }

    public static String decodeDomainName(ByteBuf byteBuf) {
        int iWriterIndex = byteBuf.writerIndex();
        int i = byteBuf.readableBytes();
        if (i == 0) {
            return ".";
        }
        StringBuilder sb = new StringBuilder(i << 1);
        int i2 = 0;
        int i3 = -1;
        while (byteBuf.isReadable()) {
            short unsignedByte = byteBuf.readUnsignedByte();
            if ((unsignedByte & 192) != 192) {
                if (unsignedByte == 0) {
                    break;
                }
                if (!byteBuf.isReadable(unsignedByte)) {
                    throw new CorruptedFrameException("truncated label in a name");
                }
                sb.append(byteBuf.toString(byteBuf.readerIndex(), unsignedByte, CharsetUtil.UTF_8));
                sb.append('.');
                byteBuf.skipBytes(unsignedByte);
            } else {
                if (i3 == -1) {
                    i3 = byteBuf.readerIndex() + 1;
                }
                if (!byteBuf.isReadable()) {
                    throw new CorruptedFrameException("truncated pointer in a name");
                }
                int unsignedByte2 = ((unsignedByte & 63) << 8) | byteBuf.readUnsignedByte();
                if (unsignedByte2 >= iWriterIndex) {
                    throw new CorruptedFrameException("name has an out-of-range pointer");
                }
                byteBuf.readerIndex(unsignedByte2);
                i2 += 2;
                if (i2 >= iWriterIndex) {
                    throw new CorruptedFrameException("name contains a loop.");
                }
            }
        }
        if (i3 != -1) {
            byteBuf.readerIndex(i3);
        }
        if (sb.length() == 0) {
            return ".";
        }
        if (sb.charAt(sb.length() - 1) != '.') {
            sb.append('.');
        }
        return sb.toString();
    }

    public static ByteBuf decompressDomainName(ByteBuf byteBuf) {
        String strDecodeDomainName = decodeDomainName(byteBuf);
        ByteBuf byteBufBuffer = byteBuf.alloc().buffer(strDecodeDomainName.length() << 1);
        encodeDomainName(strDecodeDomainName, byteBufBuffer);
        return byteBufBuffer;
    }

    public static void encodeDomainName(String str, ByteBuf byteBuf) {
        if (".".equals(str)) {
            byteBuf.writeByte(0);
            return;
        }
        for (String str2 : str.split("\\.")) {
            int length = str2.length();
            if (length == 0) {
                break;
            }
            byteBuf.writeByte(length);
            ByteBufUtil.writeAscii(byteBuf, str2);
        }
        byteBuf.writeByte(0);
    }
}

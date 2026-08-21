package org.conscrypt.ct;

import defpackage.dw2;
import defpackage.xe;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class Serialization {
    private static final int DER_LENGTH_LONG_FORM_FLAG = 128;
    private static final int DER_TAG_MASK = 63;
    private static final int DER_TAG_OCTET_STRING = 4;

    private Serialization() {
    }

    public static byte readByte(InputStream inputStream) throws SerializationException {
        try {
            int i = inputStream.read();
            if (i != -1) {
                return (byte) i;
            }
            throw new SerializationException("Premature end of input, could not read byte.");
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }

    public static byte[] readDEROctetString(InputStream inputStream) throws SerializationException {
        int i = readByte(inputStream) & 63;
        if (i != 4) {
            throw new SerializationException(dw2.A(i, "Wrong DER tag, expected OCTET STRING, got "));
        }
        int number = readNumber(inputStream, 1);
        if ((number & 128) != 0) {
            number = readNumber(inputStream, number & (-129));
        }
        return readFixedBytes(inputStream, number);
    }

    public static byte[] readFixedBytes(InputStream inputStream, int i) throws SerializationException {
        try {
            if (i < 0) {
                throw new SerializationException("Negative length: " + i);
            }
            byte[] bArr = new byte[i];
            int i2 = inputStream.read(bArr);
            if (i2 >= i) {
                return bArr;
            }
            throw new SerializationException("Premature end of input, expected " + i + " bytes, only read " + i2);
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }

    public static byte[][] readList(InputStream inputStream, int i, int i2) throws SerializationException {
        ArrayList arrayList = new ArrayList();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(readVariableBytes(inputStream, i));
        while (byteArrayInputStream.available() > 0) {
            try {
                arrayList.add(readVariableBytes(byteArrayInputStream, i2));
            } catch (IOException e) {
                throw new SerializationException(e);
            }
        }
        return (byte[][]) arrayList.toArray(new byte[arrayList.size()][]);
    }

    public static long readLong(InputStream inputStream, int i) {
        if (i > 8 || i < 0) {
            xe.k(dw2.A(i, "Invalid width: "));
            return 0L;
        }
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | ((long) (readByte(inputStream) & 255));
        }
        return j;
    }

    public static int readNumber(InputStream inputStream, int i) throws SerializationException {
        if (i > 4 || i < 0) {
            throw new SerializationException(dw2.A(i, "Invalid width: "));
        }
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 = (i2 << 8) | (readByte(inputStream) & 255);
        }
        return i2;
    }

    public static byte[] readVariableBytes(InputStream inputStream, int i) {
        return readFixedBytes(inputStream, readNumber(inputStream, i));
    }

    public static void writeFixedBytes(OutputStream outputStream, byte[] bArr) {
        try {
            outputStream.write(bArr);
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }

    public static void writeNumber(OutputStream outputStream, long j, int i) {
        if (i < 0) {
            throw new SerializationException(dw2.A(i, "Negative width: "));
        }
        if (i < 8 && j >= (1 << (i * 8))) {
            throw new SerializationException("Number too large, " + j + " does not fit in " + i + " bytes");
        }
        while (i > 0) {
            if (((long) (i - 1)) * 8 < 64) {
                try {
                    outputStream.write((byte) ((j >> ((int) r0)) & 255));
                } catch (IOException e) {
                    throw new SerializationException(e);
                }
            } else {
                outputStream.write(0);
            }
            i--;
        }
    }

    public static void writeVariableBytes(OutputStream outputStream, byte[] bArr, int i) {
        writeNumber(outputStream, bArr.length, i);
        writeFixedBytes(outputStream, bArr);
    }

    public static byte[] readDEROctetString(byte[] bArr) {
        return readDEROctetString(new ByteArrayInputStream(bArr));
    }

    public static byte[][] readList(byte[] bArr, int i, int i2) {
        return readList(new ByteArrayInputStream(bArr), i, i2);
    }
}

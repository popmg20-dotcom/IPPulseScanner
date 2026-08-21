package io.sentry;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d0 implements w0 {
    public static final Charset b = Charset.forName("UTF-8");
    public final l1 a;

    public d0(l1 l1Var) {
        this.a = l1Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00aa, code lost:
    
        r11 = new io.sentry.internal.debugmeta.c(r1, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00af, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b2, code lost:
    
        return r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x010b, code lost:
    
        throw new java.lang.IllegalArgumentException("Item header at index '" + r3.size() + "' is null or empty.");
     */
    @Override // io.sentry.w0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final io.sentry.internal.debugmeta.c a(BufferedInputStream bufferedInputStream) throws IOException {
        l1 l1Var = this.a;
        Charset charset = b;
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        int i2 = -1;
        while (true) {
            try {
                int i3 = bufferedInputStream.read(bArr);
                if (i3 <= 0) {
                    break;
                }
                int i4 = 0;
                while (true) {
                    if (i2 != -1 || i4 >= i3) {
                        break;
                    }
                    if (bArr[i4] == 10) {
                        i2 = i + i4;
                        break;
                    }
                    i4++;
                }
                byteArrayOutputStream.write(bArr, 0, i3);
                i += i3;
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (byteArray.length == 0) {
            throw new IllegalArgumentException("Empty stream.");
        }
        if (i2 == -1) {
            throw new IllegalArgumentException("Envelope contains no header.");
        }
        StringReader stringReader = new StringReader(new String(byteArray, 0, i2, charset));
        try {
            y4 y4Var = (y4) l1Var.b(stringReader, y4.class);
            stringReader.close();
            if (y4Var == null) {
                throw new IllegalArgumentException("Envelope header is null.");
            }
            int i5 = i2 + 1;
            ArrayList arrayList = new ArrayList();
            while (true) {
                int i6 = i5;
                while (true) {
                    if (i6 >= byteArray.length) {
                        i6 = -1;
                        break;
                    }
                    if (byteArray[i6] == 10) {
                        break;
                    }
                    i6++;
                }
                if (i6 == -1) {
                    throw new IllegalArgumentException("Invalid envelope. Item at index '" + arrayList.size() + "'. has no header delimiter.");
                }
                stringReader = new StringReader(new String(byteArray, i5, i6 - i5, charset));
                try {
                    e5 e5Var = (e5) l1Var.b(stringReader, e5.class);
                    stringReader.close();
                    if (e5Var == null || e5Var.a() <= 0) {
                        break;
                    }
                    int iA = e5Var.a() + i6;
                    int i7 = iA + 1;
                    if (i7 > byteArray.length) {
                        throw new IllegalArgumentException("Invalid length for item at index '" + arrayList.size() + "'. Item is '" + i7 + "' bytes. There are '" + byteArray.length + "' in the buffer.");
                    }
                    arrayList.add(new d5(e5Var, Arrays.copyOfRange(byteArray, i6 + 1, i7)));
                    if (i7 == byteArray.length) {
                        break;
                    }
                    i5 = iA + 2;
                    if (i5 == byteArray.length) {
                        if (byteArray[i7] != 10) {
                            throw new IllegalArgumentException("Envelope has invalid data following an item.");
                        }
                    }
                } finally {
                }
            }
        } finally {
        }
    }
}

package defpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class le1 extends fx3 {
    public static String S(File file) {
        file.getClass();
        String name = file.getName();
        name.getClass();
        return p44.P0(name, '.', "");
    }

    public static byte[] T(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new OutOfMemoryError("File " + file + " is too big (" + length + " bytes) to fit in memory.");
            }
            int i = (int) length;
            byte[] bArrCopyOf = new byte[i];
            int i2 = i;
            int i3 = 0;
            while (i2 > 0) {
                int i4 = fileInputStream.read(bArrCopyOf, i3, i2);
                if (i4 < 0) {
                    break;
                }
                i2 -= i4;
                i3 += i4;
            }
            if (i2 > 0) {
                bArrCopyOf = Arrays.copyOf(bArrCopyOf, i3);
            } else {
                int i5 = fileInputStream.read();
                if (i5 != -1) {
                    y81 y81Var = new y81(8193);
                    y81Var.write(i5);
                    l72.h(fileInputStream, y81Var);
                    int size = y81Var.size() + i;
                    if (size < 0) {
                        throw new OutOfMemoryError("File " + file + " is too big to fit in memory.");
                    }
                    byte[] bArrN = y81Var.n();
                    bArrCopyOf = Arrays.copyOf(bArrCopyOf, size);
                    qe.d0(bArrN, i, 0, bArrCopyOf, y81Var.size());
                }
            }
            fileInputStream.close();
            return bArrCopyOf;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                ez4.l(fileInputStream, th);
                throw th2;
            }
        }
    }

    public static String U(File file) throws IOException {
        Charset charset = y30.a;
        charset.getClass();
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        try {
            String strT = l72.T(inputStreamReader);
            inputStreamReader.close();
            return strT;
        } finally {
        }
    }

    public static File V(File file) {
        int iU0;
        File file2 = new File("image_cache");
        String path = file2.getPath();
        path.getClass();
        char c = File.separatorChar;
        int length = 0;
        int iU02 = p44.u0(path, c, 0, 4);
        if (iU02 == 0) {
            if (path.length() <= 1 || path.charAt(1) != c || (iU0 = p44.u0(path, c, 2, 4)) < 0) {
                length = 1;
            } else {
                int iU03 = p44.u0(path, c, iU0 + 1, 4);
                length = iU03 >= 0 ? iU03 + 1 : path.length();
            }
        } else if (iU02 > 0 && path.charAt(iU02 - 1) == ':') {
            length = iU02 + 1;
        } else if (iU02 == -1 && p44.r0(path, ':')) {
            length = path.length();
        }
        if (length > 0) {
            return file2;
        }
        String string = file.toString();
        string.getClass();
        if (string.length() == 0 || p44.r0(string, c)) {
            return new File(string + file2);
        }
        return new File(string + c + file2);
    }

    public static void W(File file, String str) throws IOException {
        Charset charset = y30.a;
        str.getClass();
        charset.getClass();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            X(fileOutputStream, str, charset);
            fileOutputStream.close();
        } finally {
        }
    }

    public static final void X(FileOutputStream fileOutputStream, String str, Charset charset) throws IOException {
        str.getClass();
        if (str.length() < 16384) {
            byte[] bytes = str.getBytes(charset);
            bytes.getClass();
            fileOutputStream.write(bytes);
            return;
        }
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPLACE;
        CharsetEncoder charsetEncoderOnUnmappableCharacter = charsetEncoderNewEncoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction);
        CharBuffer charBufferAllocate = CharBuffer.allocate(8192);
        charsetEncoderOnUnmappableCharacter.getClass();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8192 * ((int) Math.ceil(charsetEncoderOnUnmappableCharacter.maxBytesPerChar())));
        byteBufferAllocate.getClass();
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            int iMin = Math.min(8192 - i2, str.length() - i);
            int i3 = i + iMin;
            char[] cArrArray = charBufferAllocate.array();
            cArrArray.getClass();
            str.getChars(i, i3, cArrArray, i2);
            charBufferAllocate.limit(iMin + i2);
            i2 = 1;
            if (!charsetEncoderOnUnmappableCharacter.encode(charBufferAllocate, byteBufferAllocate, i3 == str.length()).isUnderflow()) {
                xe.q("Check failed.");
                return;
            }
            fileOutputStream.write(byteBufferAllocate.array(), 0, byteBufferAllocate.position());
            if (charBufferAllocate.position() != charBufferAllocate.limit()) {
                charBufferAllocate.put(0, charBufferAllocate.get());
            } else {
                i2 = 0;
            }
            charBufferAllocate.clear();
            byteBufferAllocate.clear();
            i = i3;
        }
    }
}

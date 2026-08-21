package io.sentry.util;

import java.io.Writer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class c extends Writer {
    public long b = 0;

    public static int g(char c) {
        if (c <= 127) {
            return 1;
        }
        return (c > 2047 && !Character.isSurrogate(c)) ? 3 : 2;
    }

    @Override // java.io.Writer
    public final void write(String str, int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            this.b += (long) g(str.charAt(i3));
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
    }

    @Override // java.io.Writer
    public final void write(int i) {
        this.b += (long) g((char) i);
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            this.b += (long) g(cArr[i3]);
        }
    }
}

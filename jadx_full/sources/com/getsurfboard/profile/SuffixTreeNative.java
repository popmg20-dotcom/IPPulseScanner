package com.getsurfboard.profile;

import defpackage.uj0;
import defpackage.vw0;
import defpackage.y30;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class SuffixTreeNative implements AutoCloseable {
    public static volatile boolean X;
    public final long b;
    public volatile boolean f;
    public final vw0 z = new vw0(512, 0.75f, true, 1);
    public final uj0 A = new uj0(4);

    public SuffixTreeNative(long j) {
        this.b = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final native boolean nativeBuild(String[] strArr, String str);

    private final native void nativeClose(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static final native long nativeLoad(String str);

    private final native boolean nativeSearch(long j, String str);

    private final native boolean nativeSearchBuffer(long j, ByteBuffer byteBuffer, int i);

    @Override // java.lang.AutoCloseable
    public final void close() {
        if (this.f) {
            return;
        }
        synchronized (this) {
            if (this.f) {
                return;
            }
            this.f = true;
            synchronized (this.z) {
                this.z.clear();
            }
            nativeClose(this.b);
        }
    }

    public final boolean s(String str) {
        boolean zNativeSearchBuffer;
        str.getClass();
        if (this.f) {
            return false;
        }
        synchronized (this.z) {
            Boolean bool = (Boolean) this.z.get(str);
            if (bool != null) {
                return bool.booleanValue();
            }
            long j = this.b;
            byte[] bytes = str.getBytes(y30.a);
            bytes.getClass();
            if (bytes.length >= 257) {
                zNativeSearchBuffer = nativeSearch(j, str);
            } else {
                Object obj = this.A.get();
                obj.getClass();
                ByteBuffer byteBuffer = (ByteBuffer) obj;
                byteBuffer.clear();
                byteBuffer.put(bytes);
                byteBuffer.put(bytes.length, (byte) 0);
                zNativeSearchBuffer = nativeSearchBuffer(j, byteBuffer, bytes.length);
            }
            synchronized (this.z) {
                this.z.put(str, Boolean.valueOf(zNativeSearchBuffer));
            }
            return zNativeSearchBuffer;
        }
    }
}

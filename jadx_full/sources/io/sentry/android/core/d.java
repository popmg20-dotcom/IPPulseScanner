package io.sentry.android.core;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Build;
import android.os.Handler;
import android.util.SparseIntArray;
import android.view.Surface;
import androidx.core.app.FrameMetricsAggregator;
import defpackage.dw2;
import defpackage.ek0;
import defpackage.fw;
import defpackage.l9;
import defpackage.o73;
import defpackage.p44;
import defpackage.st4;
import defpackage.v10;
import defpackage.zo2;
import io.sentry.ILogger;
import io.sentry.p5;
import io.sentry.p6;
import j$.util.concurrent.ConcurrentHashMap;
import java.nio.ByteBuffer;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public final Object a;
    public final Object b;
    public final Object c;
    public final Object d;
    public final Object e;
    public final Object f;
    public Object g;

    public d(p6 p6Var, io.sentry.android.replay.video.a aVar) {
        p6Var.getClass();
        this.a = p6Var;
        this.b = aVar;
        MediaCodec mediaCodecCreateByCodecName = ((Boolean) ((l9) ek0.v(io.sentry.android.replay.video.c.f)).getValue()).booleanValue() ? MediaCodec.createByCodecName("c2.android.avc.encoder") : MediaCodec.createEncoderByType(aVar.f);
        mediaCodecCreateByCodecName.getClass();
        this.c = mediaCodecCreateByCodecName;
        this.d = ek0.v(new v10(10, this));
        this.e = new MediaCodec.BufferInfo();
        String absolutePath = aVar.a.getAbsolutePath();
        absolutePath.getClass();
        this.f = new io.sentry.android.replay.video.b(aVar.d, absolutePath);
    }

    public void a(Activity activity) {
        io.sentry.util.a aVar = (io.sentry.util.a) this.g;
        aVar.g();
        try {
            if (!e()) {
                aVar.close();
                return;
            }
            g(new b(this, activity, 0), "FrameMetricsAggregator.add");
            c cVarB = b();
            if (cVarB != null) {
                ((WeakHashMap) this.e).put(activity, cVarB);
            }
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public c b() {
        int i;
        int i2;
        SparseIntArray sparseIntArray;
        if (!e() || !((Boolean) ((io.sentry.util.f) this.b).a()).booleanValue()) {
            return null;
        }
        SparseIntArray[] sparseIntArrayArrQ = ((FrameMetricsAggregator) ((io.sentry.util.f) this.a).a()).a.q();
        int i3 = 0;
        if (sparseIntArrayArrQ == null || sparseIntArrayArrQ.length <= 0 || (sparseIntArray = sparseIntArrayArrQ[0]) == null) {
            i = 0;
            i2 = 0;
        } else {
            int i4 = 0;
            i = 0;
            i2 = 0;
            while (i3 < sparseIntArray.size()) {
                int iKeyAt = sparseIntArray.keyAt(i3);
                int iValueAt = sparseIntArray.valueAt(i3);
                i4 += iValueAt;
                if (iKeyAt > 700) {
                    i2 += iValueAt;
                } else if (iKeyAt > 16) {
                    i += iValueAt;
                }
                i3++;
            }
            i3 = i4;
        }
        return new c(i3, i, i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x017a, code lost:
    
        defpackage.zo2.w(defpackage.ha0.k("encoderOutputBuffer ", r5, " was null"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0185, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(boolean z) {
        ByteBuffer byteBuffer;
        io.sentry.android.replay.video.b bVar = (io.sentry.android.replay.video.b) this.f;
        MediaCodec.BufferInfo bufferInfo = (MediaCodec.BufferInfo) this.e;
        MediaCodec mediaCodec = (MediaCodec) this.c;
        p6 p6Var = (p6) this.a;
        if (p6Var.getSessionReplay().m) {
            p6Var.getLogger().h(p5.DEBUG, "[Encoder]: drainCodec(" + z + ')', new Object[0]);
        }
        if (z) {
            if (p6Var.getSessionReplay().m) {
                p6Var.getLogger().h(p5.DEBUG, "[Encoder]: sending EOS to encoder", new Object[0]);
            }
            mediaCodec.signalEndOfInputStream();
        }
        ByteBuffer[] outputBuffers = mediaCodec.getOutputBuffers();
        while (true) {
            int iDequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, 100000L);
            if (iDequeueOutputBuffer == -1) {
                if (!z) {
                    return;
                }
                if (p6Var.getSessionReplay().m) {
                    p6Var.getLogger().h(p5.DEBUG, "[Encoder]: no output available, spinning to await EOS", new Object[0]);
                }
            } else if (iDequeueOutputBuffer == -3) {
                outputBuffers = mediaCodec.getOutputBuffers();
            } else if (iDequeueOutputBuffer == -2) {
                if (bVar.c) {
                    zo2.w("format changed twice");
                    return;
                }
                MediaFormat outputFormat = mediaCodec.getOutputFormat();
                outputFormat.getClass();
                if (p6Var.getSessionReplay().m) {
                    p6Var.getLogger().h(p5.DEBUG, "[Encoder]: encoder output format changed: " + outputFormat, new Object[0]);
                }
                MediaMuxer mediaMuxer = bVar.b;
                bVar.d = mediaMuxer.addTrack(outputFormat);
                mediaMuxer.start();
                bVar.c = true;
            } else if (iDequeueOutputBuffer < 0) {
                if (p6Var.getSessionReplay().m) {
                    p6Var.getLogger().h(p5.DEBUG, dw2.A(iDequeueOutputBuffer, "[Encoder]: unexpected result from encoder.dequeueOutputBuffer: "), new Object[0]);
                }
            } else {
                if (outputBuffers == null || (byteBuffer = outputBuffers[iDequeueOutputBuffer]) == null) {
                    break;
                }
                if ((bufferInfo.flags & 2) != 0) {
                    if (p6Var.getSessionReplay().m) {
                        p6Var.getLogger().h(p5.DEBUG, "[Encoder]: ignoring BUFFER_FLAG_CODEC_CONFIG", new Object[0]);
                    }
                    bufferInfo.size = 0;
                }
                if (bufferInfo.size != 0) {
                    if (!bVar.c) {
                        zo2.w("muxer hasn't started");
                        return;
                    }
                    long j = bVar.a;
                    int i = bVar.e;
                    bVar.e = i + 1;
                    long j2 = j * ((long) i);
                    bVar.f = j2;
                    bufferInfo.presentationTimeUs = j2;
                    bVar.b.writeSampleData(bVar.d, byteBuffer, bufferInfo);
                    if (p6Var.getSessionReplay().m) {
                        p6Var.getLogger().h(p5.DEBUG, fw.w(" bytes to muxer", new StringBuilder("[Encoder]: sent "), bufferInfo.size), new Object[0]);
                    }
                }
                mediaCodec.releaseOutputBuffer(iDequeueOutputBuffer, false);
                if ((bufferInfo.flags & 4) != 0) {
                    if (p6Var.getSessionReplay().m) {
                        if (z) {
                            p6Var.getLogger().h(p5.DEBUG, "[Encoder]: end of stream reached", new Object[0]);
                            return;
                        } else {
                            p6Var.getLogger().h(p5.DEBUG, "[Encoder]: reached end of stream unexpectedly", new Object[0]);
                            return;
                        }
                    }
                    return;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(Bitmap bitmap) {
        Canvas canvasLockCanvas;
        String str = Build.MANUFACTURER;
        str.getClass();
        if (p44.o0(str, "xiaomi", true) || p44.o0(str, "motorola", true)) {
            Surface surface = (Surface) this.g;
            canvasLockCanvas = surface != null ? surface.lockCanvas(null) : null;
        } else {
            io.sentry.android.replay.util.k kVar = io.sentry.android.replay.util.k.SOC_MANUFACTURER;
            if (!io.sentry.android.replay.util.m.a(kVar).equalsIgnoreCase("spreadtrum") && !io.sentry.android.replay.util.m.a(kVar).equalsIgnoreCase("unisoc")) {
                Surface surface2 = (Surface) this.g;
                if (surface2 != null) {
                    canvasLockCanvas = surface2.lockHardwareCanvas();
                }
            }
        }
        if (canvasLockCanvas != null) {
            canvasLockCanvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
        Surface surface3 = (Surface) this.g;
        if (surface3 != null) {
            surface3.unlockCanvasAndPost(canvasLockCanvas);
        }
        c(false);
    }

    public boolean e() {
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) this.c;
        return ((Boolean) ((io.sentry.util.f) this.b).a()).booleanValue() && sentryAndroidOptions.isEnableFramesTracking() && !sentryAndroidOptions.isEnablePerformanceV2();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v5 */
    public void f() {
        ?? r4;
        Object obj;
        ?? r42;
        ?? r3;
        ?? r43;
        Object obj2;
        ?? r44;
        ?? r32;
        io.sentry.android.replay.video.b bVar = (io.sentry.android.replay.video.b) this.f;
        String str = "Failed to release Surface";
        String str2 = "Failed to release MediaCodec";
        MediaCodec mediaCodec = (MediaCodec) this.c;
        p6 p6Var = (p6) this.a;
        try {
            try {
                c(true);
                mediaCodec.stop();
                try {
                    mediaCodec.release();
                    r43 = mediaCodec;
                } catch (RuntimeException e) {
                    p6Var.getLogger().d(p5.DEBUG, "Failed to release MediaCodec", e);
                    r43 = e;
                }
                try {
                    Surface surface = (Surface) this.g;
                    r32 = str2;
                    r44 = r43;
                    obj2 = surface;
                    if (surface != null) {
                        surface.release();
                        r32 = str2;
                        r44 = r43;
                        obj2 = surface;
                    }
                } catch (RuntimeException e2) {
                    ILogger logger = p6Var.getLogger();
                    p5 p5Var = p5.DEBUG;
                    logger.d(p5Var, "Failed to release Surface", e2);
                    r32 = logger;
                    r44 = p5Var;
                    obj2 = e2;
                }
                try {
                    bVar.a();
                    bVar = bVar;
                    str = str;
                    str2 = r32;
                    mediaCodec = r44;
                    this = obj2;
                } catch (RuntimeException e3) {
                    ILogger logger2 = p6Var.getLogger();
                    p5 p5Var2 = p5.DEBUG;
                    logger2.d(p5Var2, "Failed to release MediaMuxer", e3);
                    bVar = logger2;
                    str = p5Var2;
                    str2 = r32;
                    mediaCodec = r44;
                    this = e3;
                }
            } catch (Throwable th) {
                try {
                    mediaCodec.release();
                } catch (RuntimeException e4) {
                    p6Var.getLogger().d(p5.DEBUG, str2, e4);
                }
                try {
                    Surface surface2 = (Surface) this.g;
                    if (surface2 != null) {
                        surface2.release();
                    }
                } catch (RuntimeException e5) {
                    p6Var.getLogger().d(p5.DEBUG, str, e5);
                }
                try {
                    bVar.a();
                    throw th;
                } catch (RuntimeException e6) {
                    p6Var.getLogger().d(p5.DEBUG, "Failed to release MediaMuxer", e6);
                    throw th;
                }
            }
        } catch (RuntimeException e7) {
            p6Var.getLogger().d(p5.DEBUG, "Failed to properly release video encoder", e7);
            try {
                mediaCodec.release();
                r4 = mediaCodec;
            } catch (RuntimeException e8) {
                p6Var.getLogger().d(p5.DEBUG, "Failed to release MediaCodec", e8);
                r4 = e8;
            }
            try {
                Surface surface3 = (Surface) this.g;
                r3 = str2;
                r42 = r4;
                obj = surface3;
                if (surface3 != null) {
                    surface3.release();
                    r3 = str2;
                    r42 = r4;
                    obj = surface3;
                }
            } catch (RuntimeException e9) {
                ILogger logger3 = p6Var.getLogger();
                p5 p5Var3 = p5.DEBUG;
                logger3.d(p5Var3, "Failed to release Surface", e9);
                r3 = logger3;
                r42 = p5Var3;
                obj = e9;
            }
            try {
                bVar.a();
                bVar = bVar;
                str = str;
                str2 = r3;
                mediaCodec = r42;
                this = obj;
            } catch (RuntimeException e10) {
                ILogger logger4 = p6Var.getLogger();
                p5 p5Var4 = p5.DEBUG;
                logger4.d(p5Var4, "Failed to release MediaMuxer", e10);
                bVar = logger4;
                str = p5Var4;
                str2 = r3;
                mediaCodec = r42;
                this = e10;
            }
        }
    }

    public void g(Runnable runnable, String str) {
        try {
            if (io.sentry.android.core.internal.util.d.a.c()) {
                runnable.run();
                return;
            }
            q0 q0Var = (q0) this.f;
            ((Handler) q0Var.b).post(new p1(1, this, runnable, str));
        } catch (Throwable unused) {
            if (str != null) {
                ((SentryAndroidOptions) this.c).getLogger().h(p5.WARNING, "Failed to execute ".concat(str), new Object[0]);
            }
        }
    }

    public d(io.sentry.util.g gVar, SentryAndroidOptions sentryAndroidOptions) {
        q0 q0Var = new q0(4);
        this.d = new ConcurrentHashMap();
        this.e = new WeakHashMap();
        this.g = new io.sentry.util.a();
        this.b = new io.sentry.util.f(new o73(29, gVar, sentryAndroidOptions.getLogger()));
        this.a = new io.sentry.util.f(new st4(20));
        this.c = sentryAndroidOptions;
        this.f = q0Var;
    }
}

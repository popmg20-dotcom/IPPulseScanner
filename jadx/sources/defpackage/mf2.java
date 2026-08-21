package defpackage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.view.PixelCopy;
import android.view.View;
import android.widget.PopupWindow;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.sentry.ILogger;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.android.core.a1;
import io.sentry.android.replay.screenshot.i;
import io.sentry.android.replay.util.j;
import io.sentry.android.replay.util.o;
import io.sentry.android.replay.viewhierarchy.h;
import io.sentry.config.a;
import io.sentry.p5;
import io.sentry.t6;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class mf2 implements PixelCopy.OnPixelCopyFinishedListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ mf2(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
    public final void onPixelCopyFinished(int i) {
        switch (this.a) {
            case 0:
                nf2 nf2Var = (nf2) this.b;
                Bitmap bitmap = (Bitmap) this.c;
                CodeEditor codeEditor = nf2Var.a;
                Paint paint = nf2Var.d;
                PopupWindow popupWindow = nf2Var.b;
                if (i != 0) {
                    a1.n("Magnifier", "Failed to copy pixels, error = " + i);
                } else {
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(popupWindow.getWidth(), popupWindow.getHeight(), Bitmap.Config.ARGB_8888);
                    Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, popupWindow.getWidth(), popupWindow.getHeight(), true);
                    bitmap.recycle();
                    Canvas canvas = new Canvas(bitmapCreateBitmap);
                    paint.reset();
                    paint.setAntiAlias(true);
                    canvas.drawARGB(0, 0, 0, 0);
                    canvas.drawRoundRect(0.0f, 0.0f, popupWindow.getWidth(), popupWindow.getHeight(), codeEditor.getDpUnit() * 6.0f, codeEditor.getDpUnit() * 6.0f, paint);
                    paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                    canvas.drawBitmap(bitmapCreateScaledBitmap, 0.0f, 0.0f, paint);
                    bitmapCreateScaledBitmap.recycle();
                    nf2Var.c.setImageBitmap(bitmapCreateBitmap);
                }
                break;
            case 1:
                AtomicBoolean atomicBoolean = (AtomicBoolean) this.b;
                CountDownLatch countDownLatch = (CountDownLatch) this.c;
                atomicBoolean.set(i == 0);
                countDownLatch.countDown();
                break;
            default:
                final i iVar = (i) this.b;
                final View view = (View) this.c;
                AtomicBoolean atomicBoolean2 = iVar.m;
                AtomicBoolean atomicBoolean3 = iVar.i;
                AtomicInteger atomicInteger = iVar.l;
                SentryAndroidOptions sentryAndroidOptions = iVar.b;
                if (atomicBoolean2.get()) {
                    sentryAndroidOptions.getLogger().h(p5.DEBUG, "PixelCopyStrategy is closed, ignoring capture result", new Object[0]);
                    iVar.h();
                } else if (i == 0) {
                    final boolean z = iVar.k.get();
                    if (z && atomicInteger.incrementAndGet() <= 1) {
                        sentryAndroidOptions.getLogger().h(p5.INFO, "Failed to determine view hierarchy, not capturing", new Object[0]);
                        atomicBoolean3.set(false);
                        iVar.h();
                    } else {
                        try {
                            t6 sessionReplay = sentryAndroidOptions.getSessionReplay();
                            sessionReplay.getClass();
                            final h hVarE = a.e(view, null, sessionReplay);
                            ArrayList arrayList = sentryAndroidOptions.getSessionReplay().o ? new ArrayList() : null;
                            t6 sessionReplay2 = sentryAndroidOptions.getSessionReplay();
                            sessionReplay2.getClass();
                            ILogger logger = sentryAndroidOptions.getLogger();
                            logger.getClass();
                            o.b(view, hVarE, sessionReplay2, logger, arrayList);
                            if (arrayList != null && !arrayList.isEmpty()) {
                                iVar.d.a();
                                iVar.e(view, arrayList, hVarE, !z);
                            }
                            if (iVar.e.submit(new j(new Runnable() { // from class: io.sentry.android.replay.screenshot.d
                                @Override // java.lang.Runnable
                                public final void run() {
                                    i iVar2 = iVar;
                                    try {
                                        iVar2.d(view, hVarE, !z);
                                    } finally {
                                        iVar2.h();
                                    }
                                }
                            }, "screenshot_recorder.mask")) == null) {
                                iVar.h();
                            }
                        } catch (RuntimeException e) {
                            sentryAndroidOptions.getLogger().d(p5.WARNING, "Failed to process replay frame", e);
                            iVar.h();
                        }
                    }
                } else {
                    sentryAndroidOptions.getLogger().h(p5.INFO, "Failed to capture replay recording: %d", Integer.valueOf(i));
                    atomicInteger.set(0);
                    atomicBoolean3.set(false);
                    iVar.h();
                }
                break;
        }
    }
}

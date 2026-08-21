package defpackage;

import android.os.Process;
import android.os.Trace;
import android.util.Log;
import com.tencent.mars.xlog.Xlog;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class pp1 implements Runnable {
    public final /* synthetic */ int b;
    public static final pp1 f = new pp1(0);
    public static final /* synthetic */ pp1 z = new pp1(2);
    public static final /* synthetic */ pp1 A = new pp1(3);

    public /* synthetic */ pp1(int i) {
        this.b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.b) {
            case 0:
                if (fy4.b) {
                    Xlog.logWrite2(0L, 1, "GoogleApiCheckDialogFragment", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "GoogleApiCheckDialogFragment removed");
                }
                if (!((Boolean) le2.a.a()).booleanValue() || fy4.b) {
                    return;
                }
                Log.d("GoogleApiCheckDialogFragment", "GoogleApiCheckDialogFragment removed", null);
                return;
            case 1:
                try {
                    Method method = zf4.b;
                    Trace.beginSection("EmojiCompat.EmojiCompatInitializer.run");
                    if (k31.k != null) {
                        k31.a().c();
                        break;
                    }
                    Trace.endSection();
                    return;
                } catch (Throwable th) {
                    Method method2 = zf4.b;
                    Trace.endSection();
                    throw th;
                }
            case 2:
                oa5.i.incrementAndGet();
                return;
            default:
                oa5.i.incrementAndGet();
                return;
        }
    }
}

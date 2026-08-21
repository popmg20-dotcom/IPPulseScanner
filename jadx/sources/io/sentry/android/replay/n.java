package io.sentry.android.replay;

import android.graphics.Bitmap;
import defpackage.bh3;
import defpackage.n12;
import defpackage.r82;
import defpackage.xl4;
import io.sentry.android.core.SentryAndroidOptions;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class n extends r82 implements Function2 {
    public final /* synthetic */ bh3 A;
    public final /* synthetic */ ReplayIntegration f;
    public final /* synthetic */ Bitmap z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(ReplayIntegration replayIntegration, Bitmap bitmap, bh3 bh3Var) {
        super(2);
        this.f = replayIntegration;
        this.z = bitmap;
        this.A = bh3Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) throws IOException {
        j jVar = (j) obj;
        long jLongValue = ((Number) obj2).longValue();
        jVar.getClass();
        SentryAndroidOptions sentryAndroidOptions = this.f.A;
        if (sentryAndroidOptions == null) {
            n12.T("options");
            throw null;
        }
        sentryAndroidOptions.getSessionReplay().getClass();
        Bitmap bitmap = this.z;
        String str = (String) this.A.b;
        bitmap.getClass();
        if (jVar.s() != null && !bitmap.isRecycled()) {
            File fileS = jVar.s();
            if (fileS != null) {
                fileS.mkdirs();
            }
            File file = new File(jVar.s(), jLongValue + ".jpg");
            file.createNewFile();
            synchronized (bitmap) {
                if (!bitmap.isRecycled()) {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        bitmap.compress(Bitmap.CompressFormat.JPEG, jVar.b.getSessionReplay().f.screenshotQuality, fileOutputStream);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        jVar.g(file, jLongValue, str);
                    } finally {
                    }
                }
            }
        }
        return xl4.a;
    }
}

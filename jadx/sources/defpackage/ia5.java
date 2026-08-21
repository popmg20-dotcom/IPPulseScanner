package defpackage;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ia5 implements Runnable {
    public final /* synthetic */ boolean A;
    public final /* synthetic */ Object X;
    public final /* synthetic */ Object Y;
    public final /* synthetic */ int b = 2;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object z;

    public ia5(ib5 ib5Var, AtomicReference atomicReference, String str, String str2, boolean z) {
        this.X = atomicReference;
        this.f = str;
        this.z = str2;
        this.A = z;
        Objects.requireNonNull(ib5Var);
        this.Y = ib5Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0149 A[Catch: RuntimeException -> 0x00dc, TryCatch #1 {RuntimeException -> 0x00dc, blocks: (B:19:0x006c, B:50:0x00fc, B:52:0x0107, B:55:0x0114, B:57:0x011a, B:59:0x0134, B:62:0x0141, B:65:0x0149, B:68:0x0160, B:70:0x016f, B:69:0x0167, B:71:0x0182, B:73:0x0188, B:75:0x018e, B:77:0x0194, B:79:0x019c, B:81:0x01a4, B:83:0x01ac, B:85:0x01b2, B:86:0x01c4, B:23:0x008d, B:25:0x0093, B:27:0x009b, B:29:0x00a1, B:31:0x00a7, B:33:0x00ad, B:35:0x00b5, B:37:0x00bd, B:39:0x00c5, B:41:0x00cd, B:44:0x00df, B:46:0x00ed), top: B:96:0x006c }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 576
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ia5.run():void");
    }

    public ia5(a55 a55Var, boolean z, Uri uri, String str, String str2) {
        this.A = z;
        this.X = uri;
        this.f = str;
        this.z = str2;
        this.Y = a55Var;
    }

    public ia5(AppMeasurementDynamiteService appMeasurementDynamiteService, v35 v35Var, String str, String str2, boolean z) {
        this.X = v35Var;
        this.f = str;
        this.z = str2;
        this.A = z;
        this.Y = appMeasurementDynamiteService;
    }

    public ia5(dd5 dd5Var, tg5 tg5Var, boolean z, y25 y25Var, Bundle bundle) {
        this.X = tg5Var;
        this.A = z;
        this.f = y25Var;
        this.z = bundle;
        Objects.requireNonNull(dd5Var);
        this.Y = dd5Var;
    }
}

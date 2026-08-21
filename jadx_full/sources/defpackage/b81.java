package defpackage;

import android.app.ApplicationExitInfo;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b81 extends r25 {
    public static final b81 k = new b81();

    @Override // defpackage.r25
    public final boolean a(Object obj, Object obj2) {
        ApplicationExitInfo applicationExitInfoA = a71.a(obj);
        ApplicationExitInfo applicationExitInfoA2 = a71.a(obj2);
        applicationExitInfoA.getClass();
        applicationExitInfoA2.getClass();
        return true;
    }

    @Override // defpackage.r25
    public final boolean b(Object obj, Object obj2) {
        ApplicationExitInfo applicationExitInfoA = a71.a(obj);
        ApplicationExitInfo applicationExitInfoA2 = a71.a(obj2);
        applicationExitInfoA.getClass();
        applicationExitInfoA2.getClass();
        return applicationExitInfoA.getTimestamp() == applicationExitInfoA2.getTimestamp() && applicationExitInfoA.getPid() == applicationExitInfoA2.getPid();
    }
}

package defpackage;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ia implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ Context f;

    public /* synthetic */ ia(Context context, int i) {
        this.b = i;
        this.f = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006f  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r10 = this;
            int r0 = r10.b
            r1 = 1
            android.content.Context r10 = r10.f
            switch(r0) {
                case 0: goto L32;
                case 1: goto L2e;
                case 2: goto L14;
                default: goto L8;
            }
        L8:
            qd r0 = new qd
            r0.<init>(r1)
            pr1 r1 = defpackage.b73.a
            r2 = 0
            defpackage.b73.b(r10, r0, r1, r2)
            return
        L14:
            java.util.concurrent.ThreadPoolExecutor r3 = new java.util.concurrent.ThreadPoolExecutor
            java.util.concurrent.LinkedBlockingQueue r9 = new java.util.concurrent.LinkedBlockingQueue
            r9.<init>()
            r4 = 0
            r5 = 1
            r6 = 0
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.MILLISECONDS
            r3.<init>(r4, r5, r6, r8, r9)
            ia r0 = new ia
            r1 = 3
            r0.<init>(r10, r1)
            r3.execute(r0)
            return
        L2e:
            defpackage.ma.p(r10)
            return
        L32:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 33
            if (r0 < r2) goto L89
            android.content.ComponentName r3 = new android.content.ComponentName
            java.lang.String r4 = "androidx.appcompat.app.AppLocalesMetadataHolderService"
            r3.<init>(r10, r4)
            android.content.pm.PackageManager r4 = r10.getPackageManager()
            int r4 = r4.getComponentEnabledSetting(r3)
            if (r4 == r1) goto L89
            if (r0 < r2) goto L60
            java.lang.Object r0 = defpackage.ma.b()
            if (r0 == 0) goto L65
            android.os.LocaleList r0 = defpackage.ka.a(r0)
            rd2 r2 = new rd2
            ud2 r4 = new ud2
            r4.<init>(r0)
            r2.<init>(r4)
            goto L67
        L60:
            rd2 r2 = defpackage.ma.z
            if (r2 == 0) goto L65
            goto L67
        L65:
            rd2 r2 = defpackage.rd2.b
        L67:
            td2 r0 = r2.a
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L82
            java.lang.String r0 = defpackage.ji0.M(r10)
            java.lang.String r2 = "locale"
            java.lang.Object r2 = r10.getSystemService(r2)
            if (r2 == 0) goto L82
            android.os.LocaleList r0 = defpackage.ja.a(r0)
            defpackage.ka.b(r2, r0)
        L82:
            android.content.pm.PackageManager r10 = r10.getPackageManager()
            r10.setComponentEnabledSetting(r3, r1, r1)
        L89:
            defpackage.ma.Y = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ia.run():void");
    }
}

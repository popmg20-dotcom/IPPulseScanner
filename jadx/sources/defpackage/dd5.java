package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class dd5 extends u55 {
    public ScheduledExecutorService A0;
    public final de5 B0;
    public final ArrayList C0;
    public final jc5 D0;
    public final yc5 Y;
    public v55 Z;
    public volatile Boolean y0;
    public final jc5 z0;

    public dd5(k85 k85Var) {
        super(k85Var);
        this.C0 = new ArrayList();
        this.B0 = new de5(k85Var.B0);
        this.Y = new yc5(this);
        this.z0 = new jc5(this, k85Var, 0);
        this.D0 = new jc5(this, k85Var, 1);
    }

    @Override // defpackage.u55
    public final boolean Y0() {
        return false;
    }

    public final void Z0(AtomicReference atomicReference) {
        V0();
        W0();
        j1(new g33(this, atomicReference, l1(false)));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a1(android.os.Bundle r8) {
        /*
            r7 = this;
            r7.V0()
            r7.W0()
            y25 r4 = new y25
            r4.<init>(r8)
            r7.h1()
            java.lang.Object r0 = r7.f
            k85 r0 = (defpackage.k85) r0
            x15 r1 = r0.A
            r2 = 0
            q55 r3 = defpackage.r55.c1
            boolean r1 = r1.f1(r2, r3)
            r2 = 0
            if (r1 == 0) goto L59
            i65 r0 = r0.i()
            java.lang.Object r1 = r0.f
            k85 r1 = (defpackage.k85) r1
            qf5 r3 = r1.z0
            t65 r1 = r1.Y
            defpackage.k85.f(r3)
            byte[] r3 = defpackage.qf5.B1(r4)
            if (r3 != 0) goto L3f
            defpackage.k85.h(r1)
            q65 r0 = r1.A0
            java.lang.String r1 = "Null default event parameters; not writing to database"
            r0.a(r1)
        L3d:
            r0 = r2
            goto L54
        L3f:
            int r5 = r3.length
            r6 = 131072(0x20000, float:1.83671E-40)
            if (r5 <= r6) goto L4f
            defpackage.k85.h(r1)
            q65 r0 = r1.A0
            java.lang.String r1 = "Default event parameters too long for local database. Sending directly to service"
            r0.a(r1)
            goto L3d
        L4f:
            r1 = 4
            boolean r0 = r0.c1(r1, r3)
        L54:
            if (r0 == 0) goto L59
            r0 = 1
            r3 = r0
            goto L5a
        L59:
            r3 = r2
        L5a:
            tg5 r2 = r7.l1(r2)
            ia5 r0 = new ia5
            r1 = r7
            r5 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            r1.j1(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dd5.a1(android.os.Bundle):void");
    }

    public final void b1() {
        V0();
        W0();
        if (m1()) {
            return;
        }
        if (c1()) {
            this.Y.d();
            return;
        }
        k85 k85Var = (k85) this.f;
        if (k85Var.A.Y0()) {
            return;
        }
        List<ResolveInfo> listQueryIntentServices = k85Var.b.getPackageManager().queryIntentServices(new Intent().setClassName(k85Var.b, "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            t65Var.z0.a("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            return;
        }
        Intent intent = new Intent("com.google.android.gms.measurement.START");
        intent.setComponent(new ComponentName(k85Var.b, "com.google.android.gms.measurement.AppMeasurementService"));
        yc5 yc5Var = this.Y;
        dd5 dd5Var = yc5Var.z;
        dd5Var.V0();
        Context context = ((k85) dd5Var.f).b;
        fb0 fb0VarA = fb0.a();
        synchronized (yc5Var) {
            try {
                boolean z = yc5Var.b;
                dd5 dd5Var2 = yc5Var.z;
                k85 k85Var2 = (k85) dd5Var2.f;
                if (z) {
                    t65 t65Var2 = k85Var2.Y;
                    k85.h(t65Var2);
                    t65Var2.H0.a("Connection attempt already in progress");
                } else {
                    t65 t65Var3 = k85Var2.Y;
                    k85.h(t65Var3);
                    t65Var3.H0.a("Using local app measurement service");
                    yc5Var.b = true;
                    fb0VarA.c(context, context.getClass().getName(), intent, dd5Var2.Y, 129, null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0111  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c1() {
        /*
            Method dump skipped, instruction units count: 309
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dd5.c1():boolean");
    }

    public final void d1() {
        V0();
        W0();
        yc5 yc5Var = this.Y;
        if (yc5Var.f != null && (yc5Var.f.isConnected() || yc5Var.f.c())) {
            yc5Var.f.n();
        }
        yc5Var.f = null;
        try {
            fb0.a().b(((k85) this.f).b, yc5Var);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.Z = null;
    }

    public final boolean e1() {
        V0();
        W0();
        if (!c1()) {
            return true;
        }
        qf5 qf5Var = ((k85) this.f).z0;
        k85.f(qf5Var);
        return qf5Var.D1() >= ((Integer) r55.K0.a(null)).intValue();
    }

    public final boolean f1() {
        V0();
        W0();
        if (!c1()) {
            return true;
        }
        qf5 qf5Var = ((k85) this.f).z0;
        k85.f(qf5Var);
        return qf5Var.D1() >= 241200;
    }

    public final void g1(ComponentName componentName) {
        V0();
        if (this.Z != null) {
            this.Z = null;
            t65 t65Var = ((k85) this.f).Y;
            k85.h(t65Var);
            t65Var.H0.b(componentName, "Disconnected from device MeasurementService");
            V0();
            b1();
        }
    }

    public final void h1() {
        ((k85) this.f).getClass();
    }

    public final void i1() {
        V0();
        de5 de5Var = this.B0;
        de5Var.getClass();
        de5Var.a = SystemClock.elapsedRealtime();
        x15 x15Var = ((k85) this.f).A;
        this.z0.b(((Long) r55.Z.a(null)).longValue());
    }

    public final void j1(Runnable runnable) {
        V0();
        if (m1()) {
            runnable.run();
            return;
        }
        ArrayList arrayList = this.C0;
        long size = arrayList.size();
        k85 k85Var = (k85) this.f;
        x15 x15Var = k85Var.A;
        if (size >= 1000) {
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            t65Var.z0.a("Discarding data. Max runnable queue size reached");
        } else {
            arrayList.add(runnable);
            this.D0.b(60000L);
            b1();
        }
    }

    public final void k1() {
        V0();
        k85 k85Var = (k85) this.f;
        t65 t65Var = k85Var.Y;
        k85.h(t65Var);
        q65 q65Var = t65Var.H0;
        ArrayList arrayList = this.C0;
        q65Var.b(Integer.valueOf(arrayList.size()), "Processing queued up service tasks");
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                ((Runnable) it.next()).run();
            } catch (RuntimeException e) {
                t65 t65Var2 = k85Var.Y;
                k85.h(t65Var2);
                t65Var2.z0.b(e, "Task exception while flushing queue");
            }
        }
        arrayList.clear();
        this.D0.c();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.tg5 l1(boolean r10) {
        /*
            Method dump skipped, instruction units count: 201
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dd5.l1(boolean):tg5");
    }

    public final boolean m1() {
        V0();
        W0();
        return this.Z != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:274:0x04a7 A[Catch: all -> 0x04e5, TRY_ENTER, TryCatch #42 {all -> 0x04e5, blocks: (B:284:0x04d5, B:274:0x04a7, B:276:0x04ad, B:277:0x04b0, B:294:0x04f8, B:220:0x03c4, B:222:0x03ce, B:227:0x03df), top: B:412:0x04d5 }] */
    /* JADX WARN: Removed duplicated region for block: B:279:0x04bf  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x04dc  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x04e1 A[PHI: r5 r6 r23 r24 r26 r27 r36 r37
      0x04e1: PHI (r5v15 android.database.sqlite.SQLiteDatabase) = 
      (r5v12 android.database.sqlite.SQLiteDatabase)
      (r5v13 android.database.sqlite.SQLiteDatabase)
      (r5v16 android.database.sqlite.SQLiteDatabase)
     binds: [B:280:0x04c2, B:297:0x050a, B:288:0x04df] A[DONT_GENERATE, DONT_INLINE]
      0x04e1: PHI (r6v5 int) = (r6v3 int), (r6v3 int), (r6v6 int) binds: [B:280:0x04c2, B:297:0x050a, B:288:0x04df] A[DONT_GENERATE, DONT_INLINE]
      0x04e1: PHI (r23v9 int) = (r23v6 int), (r23v7 int), (r23v10 int) binds: [B:280:0x04c2, B:297:0x050a, B:288:0x04df] A[DONT_GENERATE, DONT_INLINE]
      0x04e1: PHI (r24v9 java.lang.String) = (r24v6 java.lang.String), (r24v7 java.lang.String), (r24v10 java.lang.String) binds: [B:280:0x04c2, B:297:0x050a, B:288:0x04df] A[DONT_GENERATE, DONT_INLINE]
      0x04e1: PHI (r26v9 java.lang.String) = (r26v6 java.lang.String), (r26v7 java.lang.String), (r26v10 java.lang.String) binds: [B:280:0x04c2, B:297:0x050a, B:288:0x04df] A[DONT_GENERATE, DONT_INLINE]
      0x04e1: PHI (r27v11 x15) = (r27v8 x15), (r27v9 x15), (r27v12 x15) binds: [B:280:0x04c2, B:297:0x050a, B:288:0x04df] A[DONT_GENERATE, DONT_INLINE]
      0x04e1: PHI (r36v9 int) = (r36v6 int), (r36v7 int), (r36v10 int) binds: [B:280:0x04c2, B:297:0x050a, B:288:0x04df] A[DONT_GENERATE, DONT_INLINE]
      0x04e1: PHI (r37v9 java.lang.String) = (r37v6 java.lang.String), (r37v7 java.lang.String), (r37v10 java.lang.String) binds: [B:280:0x04c2, B:297:0x050a, B:288:0x04df] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0507  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x051d  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0522  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0540  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x0549  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x056c  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x0609  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x06ab  */
    /* JADX WARN: Removed duplicated region for block: B:479:0x050d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:480:0x050d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:482:0x050d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n1(defpackage.v55 r67, defpackage.y1 r68, defpackage.tg5 r69) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1880
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dd5.n1(v55, y1, tg5):void");
    }

    public final void o1(q15 q15Var) {
        boolean zC1;
        V0();
        W0();
        k85 k85Var = (k85) this.f;
        k85Var.getClass();
        i65 i65VarI = k85Var.i();
        k85 k85Var2 = (k85) i65VarI.f;
        k85.f(k85Var2.z0);
        byte[] bArrB1 = qf5.B1(q15Var);
        if (bArrB1.length > 131072) {
            t65 t65Var = k85Var2.Y;
            k85.h(t65Var);
            t65Var.A0.a("Conditional user property too long for local database. Sending directly to service");
            zC1 = false;
        } else {
            zC1 = i65VarI.c1(2, bArrB1);
        }
        j1(new ec5(this, l1(true), zC1, new q15(q15Var)));
    }
}

package defpackage;

import android.widget.FrameLayout;
import androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks;
import androidx.fragment.app.o;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class hk1 extends FragmentManager$FragmentLifecycleCallbacks {
    public final /* synthetic */ o a;
    public final /* synthetic */ FrameLayout b;

    public hk1(kk1 kk1Var, o oVar, FrameLayout frameLayout) {
        this.a = oVar;
        this.b = frameLayout;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0027, code lost:
    
        ((java.util.concurrent.CopyOnWriteArrayList) r4.z).remove(r1);
     */
    @Override // androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(androidx.fragment.app.u r4, androidx.fragment.app.o r5, android.view.View r6) {
        /*
            r3 = this;
            androidx.fragment.app.o r0 = r3.a
            if (r5 != r0) goto L3d
            eg0 r4 = r4.p
            r4.getClass()
            java.lang.Object r5 = r4.z
            java.util.concurrent.CopyOnWriteArrayList r5 = (java.util.concurrent.CopyOnWriteArrayList) r5
            monitor-enter(r5)
            java.lang.Object r0 = r4.z     // Catch: java.lang.Throwable -> L2f
            java.util.concurrent.CopyOnWriteArrayList r0 = (java.util.concurrent.CopyOnWriteArrayList) r0     // Catch: java.lang.Throwable -> L2f
            int r0 = r0.size()     // Catch: java.lang.Throwable -> L2f
            r1 = 0
        L17:
            if (r1 >= r0) goto L34
            java.lang.Object r2 = r4.z     // Catch: java.lang.Throwable -> L2f
            java.util.concurrent.CopyOnWriteArrayList r2 = (java.util.concurrent.CopyOnWriteArrayList) r2     // Catch: java.lang.Throwable -> L2f
            java.lang.Object r2 = r2.get(r1)     // Catch: java.lang.Throwable -> L2f
            qj1 r2 = (defpackage.qj1) r2     // Catch: java.lang.Throwable -> L2f
            androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks r2 = r2.a     // Catch: java.lang.Throwable -> L2f
            if (r2 != r3) goto L31
            java.lang.Object r4 = r4.z     // Catch: java.lang.Throwable -> L2f
            java.util.concurrent.CopyOnWriteArrayList r4 = (java.util.concurrent.CopyOnWriteArrayList) r4     // Catch: java.lang.Throwable -> L2f
            r4.remove(r1)     // Catch: java.lang.Throwable -> L2f
            goto L34
        L2f:
            r3 = move-exception
            goto L3b
        L31:
            int r1 = r1 + 1
            goto L17
        L34:
            monitor-exit(r5)
            android.widget.FrameLayout r3 = r3.b
            defpackage.kk1.q(r6, r3)
            return
        L3b:
            monitor-exit(r5)
            throw r3
        L3d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hk1.j(androidx.fragment.app.u, androidx.fragment.app.o, android.view.View):void");
    }
}

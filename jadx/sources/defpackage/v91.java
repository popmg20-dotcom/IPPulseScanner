package defpackage;

import android.content.Context;
import androidx.window.extensions.layout.WindowLayoutComponent;
import java.util.LinkedHashMap;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class v91 extends u91 {
    public final ReentrantLock g;
    public final LinkedHashMap h;
    public final LinkedHashMap i;

    public v91(WindowLayoutComponent windowLayoutComponent, cp1 cp1Var) {
        super(windowLayoutComponent, cp1Var);
        this.g = new ReentrantLock();
        this.h = new LinkedHashMap();
        this.i = new LinkedHashMap();
    }

    @Override // defpackage.u91, defpackage.s91, defpackage.ot4
    public final void a(Context context, qd qdVar, e74 e74Var) {
        LinkedHashMap linkedHashMap = this.h;
        ReentrantLock reentrantLock = this.g;
        reentrantLock.lock();
        try {
            en2 en2Var = (en2) linkedHashMap.get(context);
            LinkedHashMap linkedHashMap2 = this.i;
            if (en2Var != null) {
                en2Var.a(e74Var);
                linkedHashMap2.put(e74Var, context);
            } else {
                en2 en2Var2 = new en2(context);
                linkedHashMap.put(context, en2Var2);
                linkedHashMap2.put(e74Var, context);
                en2Var2.a(e74Var);
                this.a.addWindowLayoutInfoListener(context, en2Var2);
            }
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // defpackage.u91, defpackage.s91, defpackage.ot4
    public final void b(e74 e74Var) {
        LinkedHashMap linkedHashMap = this.h;
        LinkedHashMap linkedHashMap2 = this.i;
        ReentrantLock reentrantLock = this.g;
        reentrantLock.lock();
        try {
            Context context = (Context) linkedHashMap2.get(e74Var);
            if (context == null) {
                return;
            }
            en2 en2Var = (en2) linkedHashMap.get(context);
            if (en2Var == null) {
                return;
            }
            ReentrantLock reentrantLock2 = en2Var.b;
            reentrantLock2.lock();
            try {
                en2Var.d.remove(e74Var);
                reentrantLock2.unlock();
                linkedHashMap2.remove(e74Var);
                if (en2Var.d.isEmpty()) {
                    linkedHashMap.remove(context);
                    this.a.removeWindowLayoutInfoListener(en2Var);
                }
            } catch (Throwable th) {
                reentrantLock2.unlock();
                throw th;
            }
        } finally {
            reentrantLock.unlock();
        }
    }
}

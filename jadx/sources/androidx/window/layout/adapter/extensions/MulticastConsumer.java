package androidx.window.layout.adapter.extensions;

import android.content.Context;
import androidx.window.extensions.layout.WindowLayoutInfo;
import defpackage.dd0;
import defpackage.e74;
import defpackage.iv4;
import defpackage.z91;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class MulticastConsumer implements dd0 {
    public final Context a;
    public iv4 c;
    public final ReentrantLock b = new ReentrantLock();
    public final LinkedHashSet d = new LinkedHashSet();

    public MulticastConsumer(Context context) {
        this.a = context;
    }

    public final void a(e74 e74Var) {
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            iv4 iv4Var = this.c;
            if (iv4Var != null) {
                e74Var.accept(iv4Var);
            }
            this.d.add(e74Var);
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // defpackage.dd0
    public void accept(WindowLayoutInfo windowLayoutInfo) {
        windowLayoutInfo.getClass();
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            iv4 iv4VarC = z91.c(this.a, windowLayoutInfo);
            this.c = iv4VarC;
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                ((dd0) it.next()).accept(iv4VarC);
            }
        } finally {
            reentrantLock.unlock();
        }
    }
}

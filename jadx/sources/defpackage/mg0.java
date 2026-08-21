package defpackage;

import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Handler;
import j$.util.Objects;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class mg0 extends ContentObserver {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ Object b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mg0(p54 p54Var) {
        super(new Handler());
        this.b = p54Var;
    }

    @Override // android.database.ContentObserver
    public boolean deliverSelfNotifications() {
        switch (this.a) {
            case 0:
                return true;
            default:
                return super.deliverSelfNotifications();
        }
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        Cursor cursor;
        switch (this.a) {
            case 0:
                p54 p54Var = (p54) this.b;
                if (!p54Var.f || (cursor = p54Var.z) == null || cursor.isClosed()) {
                    return;
                }
                p54Var.b = p54Var.z.requery();
                return;
            case 1:
                ((AtomicBoolean) ((r90) this.b).d).set(true);
                return;
            default:
                x95 x95Var = (x95) this.b;
                synchronized (x95Var.f) {
                    x95Var.g = null;
                    x95Var.c.run();
                    break;
                }
                synchronized (x95Var) {
                    try {
                        Iterator it = x95Var.h.iterator();
                        if (it.hasNext()) {
                            if (it.next() != null) {
                                throw new ClassCastException();
                            }
                            throw null;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mg0(x95 x95Var) {
        super(null);
        this.b = x95Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mg0(r90 r90Var) {
        super(null);
        Objects.requireNonNull(r90Var);
        this.b = r90Var;
    }
}

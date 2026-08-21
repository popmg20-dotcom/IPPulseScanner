package defpackage;

import java.util.ArrayList;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class c42 implements oz1 {
    public static final /* synthetic */ long A;
    public static final /* synthetic */ long f;
    public static final /* synthetic */ long z;
    private volatile /* synthetic */ Object _exceptionsHolder$volatile;
    private volatile /* synthetic */ int _isCompleting$volatile = 0;
    private volatile /* synthetic */ Object _rootCause$volatile;
    public final gs2 b;

    static {
        Unsafe unsafe = re.a;
        z = unsafe.objectFieldOffset(c42.class.getDeclaredField("_isCompleting$volatile"));
        A = unsafe.objectFieldOffset(c42.class.getDeclaredField("_rootCause$volatile"));
        f = unsafe.objectFieldOffset(c42.class.getDeclaredField("_exceptionsHolder$volatile"));
    }

    public c42(gs2 gs2Var, Throwable th) {
        this.b = gs2Var;
        this._rootCause$volatile = th;
    }

    public final void a(Throwable th) {
        Throwable thC = c();
        if (thC == null) {
            re.a.putObjectVolatile(this, A, th);
            return;
        }
        if (th == thC) {
            return;
        }
        Unsafe unsafe = re.a;
        long j = f;
        Object objectVolatile = unsafe.getObjectVolatile(this, j);
        if (objectVolatile == null) {
            unsafe.putObjectVolatile(this, j, th);
            return;
        }
        if (!(objectVolatile instanceof Throwable)) {
            if (objectVolatile instanceof ArrayList) {
                ((ArrayList) objectVolatile).add(th);
                return;
            } else {
                ad0.o(objectVolatile, "State is ");
                return;
            }
        }
        if (th == objectVolatile) {
            return;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(objectVolatile);
        arrayList.add(th);
        unsafe.putObjectVolatile(this, j, arrayList);
    }

    @Override // defpackage.oz1
    public final gs2 b() {
        return this.b;
    }

    public final Throwable c() {
        return (Throwable) re.a.getObjectVolatile(this, A);
    }

    public final boolean d() {
        return c() != null;
    }

    public final boolean e() {
        return re.a.getIntVolatile(this, z) == 1;
    }

    public final ArrayList f(Throwable th) {
        ArrayList arrayList;
        Unsafe unsafe = re.a;
        long j = f;
        Object objectVolatile = unsafe.getObjectVolatile(this, j);
        if (objectVolatile == null) {
            arrayList = new ArrayList(4);
        } else if (objectVolatile instanceof Throwable) {
            ArrayList arrayList2 = new ArrayList(4);
            arrayList2.add(objectVolatile);
            arrayList = arrayList2;
        } else {
            if (!(objectVolatile instanceof ArrayList)) {
                ad0.o(objectVolatile, "State is ");
                return null;
            }
            arrayList = (ArrayList) objectVolatile;
        }
        Throwable thC = c();
        if (thC != null) {
            arrayList.add(0, thC);
        }
        if (th != null && !th.equals(thC)) {
            arrayList.add(th);
        }
        unsafe.putObjectVolatile(this, j, f42.e);
        return arrayList;
    }

    @Override // defpackage.oz1
    public final boolean isActive() {
        return c() == null;
    }

    public final String toString() {
        return "Finishing[cancelling=" + d() + ", completing=" + e() + ", rootCause=" + c() + ", exceptions=" + re.a.getObjectVolatile(this, f) + ", list=" + this.b + ']';
    }
}

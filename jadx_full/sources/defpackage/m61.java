package defpackage;

import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class m61 implements we2 {
    public String b;
    public j54 f;
    public LinkedBlockingQueue z;

    public final void a(Object[] objArr) {
        k54 k54Var = new k54();
        System.currentTimeMillis();
        k54Var.a = this.f;
        Thread.currentThread().getName();
        k54Var.b = objArr;
        this.z.add(k54Var);
    }

    public final void b(Object obj, Object obj2) {
        if (obj2 instanceof Throwable) {
            a(new Object[]{obj});
        } else {
            a(new Object[]{obj, obj2});
        }
    }

    public final void c(Object[] objArr) {
        Throwable th = null;
        if (objArr != null && objArr.length != 0) {
            Object obj = objArr[objArr.length - 1];
            if (obj instanceof Throwable) {
                th = (Throwable) obj;
            }
        }
        if (th == null) {
            a(objArr);
            return;
        }
        if (objArr == null || objArr.length == 0) {
            xe.q("non-sensical empty or null argument array");
            return;
        }
        int length = objArr.length - 1;
        Object[] objArr2 = new Object[length];
        if (length > 0) {
            System.arraycopy(objArr, 0, objArr2, 0, length);
        }
        a(objArr2);
    }

    @Override // defpackage.we2
    public final void debug(String str, Object obj) {
        a(new Object[]{obj});
    }

    @Override // defpackage.we2
    public final void error(String str, Object obj) {
        a(new Object[]{obj});
    }

    @Override // defpackage.we2
    public final String getName() {
        return this.b;
    }

    @Override // defpackage.we2
    public final void info(String str, Object obj) {
        a(new Object[]{obj});
    }

    @Override // defpackage.we2
    public final boolean isDebugEnabled() {
        return true;
    }

    @Override // defpackage.we2
    public final boolean isErrorEnabled() {
        return true;
    }

    @Override // defpackage.we2
    public final boolean isInfoEnabled() {
        return true;
    }

    @Override // defpackage.we2
    public final boolean isTraceEnabled() {
        return true;
    }

    @Override // defpackage.we2
    public final boolean isWarnEnabled() {
        return true;
    }

    @Override // defpackage.we2
    public final void trace(String str, Object obj) {
        a(new Object[]{obj});
    }

    @Override // defpackage.we2
    public final void warn(String str, Object obj) {
        a(new Object[]{obj});
    }

    @Override // defpackage.we2
    public final void debug(String str, Object... objArr) {
        c(objArr);
    }

    @Override // defpackage.we2
    public final void error(String str, Object... objArr) {
        c(objArr);
    }

    @Override // defpackage.we2
    public final void info(String str, Object... objArr) {
        c(objArr);
    }

    @Override // defpackage.we2
    public final void trace(String str, Object... objArr) {
        c(objArr);
    }

    @Override // defpackage.we2
    public final void warn(String str, Object... objArr) {
        c(objArr);
    }

    @Override // defpackage.we2
    public final void debug(String str) {
        a(null);
    }

    @Override // defpackage.we2
    public final void error(String str) {
        a(null);
    }

    @Override // defpackage.we2
    public final void info(String str) {
        a(null);
    }

    @Override // defpackage.we2
    public final void trace(String str) {
        a(null);
    }

    @Override // defpackage.we2
    public final void warn(String str) {
        a(null);
    }

    @Override // defpackage.we2
    public final void debug(String str, Throwable th) {
        a(null);
    }

    @Override // defpackage.we2
    public final void error(String str, Throwable th) {
        a(null);
    }

    @Override // defpackage.we2
    public final void info(String str, Throwable th) {
        a(null);
    }

    @Override // defpackage.we2
    public final void trace(String str, Throwable th) {
        a(null);
    }

    @Override // defpackage.we2
    public final void warn(String str, Throwable th) {
        a(null);
    }

    @Override // defpackage.we2
    public final void debug(String str, Object obj, Object obj2) {
        b(obj, obj2);
    }

    @Override // defpackage.we2
    public final void error(String str, Object obj, Object obj2) {
        b(obj, obj2);
    }

    @Override // defpackage.we2
    public final void info(String str, Object obj, Object obj2) {
        b(obj, obj2);
    }

    @Override // defpackage.we2
    public final void trace(String str, Object obj, Object obj2) {
        b(obj, obj2);
    }

    @Override // defpackage.we2
    public final void warn(String str, Object obj, Object obj2) {
        b(obj, obj2);
    }
}

package defpackage;

import java.io.InterruptedIOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class wk0 extends k70 {
    public final String X;
    public final Object Y;
    public Object Z;
    public Object y0;

    public wk0(String str, Object obj) {
        this.X = str;
        this.Y = obj;
    }

    public final wk0 W0(e14 e14Var) {
        boolean z;
        synchronized (this.Y) {
            try {
                z = true;
                if (this.y0 == null) {
                    Object obj = this.Z;
                    if (obj == null) {
                        this.Z = e14Var;
                    } else if (obj instanceof e14) {
                        this.Z = new Object[]{obj, e14Var};
                    } else {
                        Object[] objArr = (Object[]) obj;
                        int length = objArr.length;
                        Object[] objArr2 = new Object[length + 1];
                        System.arraycopy(objArr, 0, objArr2, 0, length);
                        objArr2[length] = e14Var;
                        this.Z = objArr2;
                    }
                    z = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            a1(e14Var);
        }
        return this;
    }

    public final boolean X0(long j, u00... u00VarArr) {
        Object obj;
        int i = 0;
        n12.j("Negative timeout N/A: %d", j >= 0, j);
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = Long.MAX_VALUE - j >= jCurrentTimeMillis ? jCurrentTimeMillis + j : Long.MAX_VALUE;
        synchronized (this.Y) {
            try {
                obj = this.y0;
                if (obj == null) {
                    obj = null;
                    if (j <= 0) {
                        Arrays.asList(u00VarArr).contains(u00.b);
                        this.y0 = null;
                    } else {
                        long jCurrentTimeMillis2 = jCurrentTimeMillis;
                        while (true) {
                            try {
                                this.Y.wait(j2 - jCurrentTimeMillis2);
                                Object obj2 = this.y0;
                                if (obj2 != null) {
                                    obj = obj2;
                                    break;
                                }
                                jCurrentTimeMillis2 = System.currentTimeMillis();
                                if (jCurrentTimeMillis2 >= j2) {
                                    Arrays.asList(u00VarArr).contains(u00.b);
                                    this.y0 = null;
                                    break;
                                }
                            } catch (InterruptedException e) {
                                InterruptedIOException interruptedIOException = (InterruptedIOException) Y0(new um0(i, e), Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                                if (this.y0 == null) {
                                    Arrays.asList(u00VarArr).contains(u00.f);
                                }
                                throw interruptedIOException;
                            }
                        }
                    }
                }
            } finally {
            }
        }
        return obj != null;
    }

    public final Throwable Y0(um0 um0Var, Object... objArr) {
        return (Throwable) um0Var.apply(getClass().getSimpleName() + "[" + ((Object) this.X) + "]: " + String.format("Interrupted after %d msec.", objArr));
    }

    public final Object Z0() {
        Object obj;
        synchronized (this.Y) {
            obj = this.y0;
            if (obj == ga5.d) {
                obj = null;
            }
        }
        return obj;
    }

    public final void a1(e14 e14Var) {
        try {
            Boolean bool = Boolean.TRUE;
            ThreadLocal threadLocal = xd4.a;
            if (bool.equals(threadLocal.get())) {
                e14Var.s(this);
                return;
            }
            try {
                threadLocal.set(bool);
                e14Var.s(this);
            } finally {
                threadLocal.remove();
            }
        } catch (Throwable th) {
            String simpleName = th.getClass().getSimpleName();
            String message = th.getMessage();
            we2 we2Var = (we2) this.f;
            Set set = ye2.a;
            if (we2Var.isDebugEnabled()) {
                we2Var.warn("notifyListener({}) failed ({}) to invoke {}: {}", this, simpleName, e14Var, message, th);
            } else {
                we2Var.warn("notifyListener({}) failed ({}) to invoke {}: {}", this, simpleName, e14Var, message);
            }
        }
    }

    public final void b1() {
        Boolean bool = Boolean.TRUE;
        synchronized (this.Y) {
            try {
                if (this.y0 != null) {
                    return;
                }
                this.y0 = bool;
                this.Y.notifyAll();
                Object obj = this.Z;
                if (obj != null) {
                    if (obj instanceof e14) {
                        a1((e14) obj);
                        return;
                    }
                    int length = Array.getLength(obj);
                    for (int i = 0; i < length; i++) {
                        e14 e14Var = (e14) Array.get(this.Z, i);
                        if (e14Var != null) {
                            a1(e14Var);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String c1() {
        return getClass().getSimpleName() + "[id=" + ((Object) this.X) + "]";
    }

    @Override // defpackage.k70
    public final String toString() {
        return c1() + "[value=" + this.y0 + "]";
    }
}

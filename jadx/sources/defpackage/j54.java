package defpackage;

import java.lang.reflect.Method;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class j54 implements we2 {
    public Method A;
    public m61 X;
    public final LinkedBlockingQueue Y;
    public final boolean Z;
    public final String b;
    public volatile we2 f;
    public Boolean z;

    public j54(String str, LinkedBlockingQueue linkedBlockingQueue, boolean z) {
        this.b = str;
        this.Y = linkedBlockingQueue;
        this.Z = z;
    }

    public final we2 a() {
        if (this.f != null) {
            return this.f;
        }
        if (this.Z) {
            return fo2.f;
        }
        m61 m61Var = this.X;
        if (m61Var != null) {
            return m61Var;
        }
        LinkedBlockingQueue linkedBlockingQueue = this.Y;
        m61 m61Var2 = new m61();
        m61Var2.f = this;
        m61Var2.b = this.b;
        m61Var2.z = linkedBlockingQueue;
        this.X = m61Var2;
        return m61Var2;
    }

    public final boolean b() {
        Boolean bool;
        Boolean bool2 = this.z;
        if (bool2 != null) {
            return bool2.booleanValue();
        }
        try {
            this.A = this.f.getClass().getMethod("log", k54.class);
            bool = Boolean.TRUE;
            this.z = bool;
        } catch (NoSuchMethodException unused) {
            bool = Boolean.FALSE;
            this.z = bool;
        }
        return bool.booleanValue();
    }

    @Override // defpackage.we2
    public final void debug(String str) {
        a().debug(str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && j54.class == obj.getClass() && this.b.equals(((j54) obj).b);
    }

    @Override // defpackage.we2
    public final void error(String str) {
        a().error(str);
    }

    @Override // defpackage.we2
    public final String getName() {
        return this.b;
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    @Override // defpackage.we2
    public final void info(String str) {
        a().info(str);
    }

    @Override // defpackage.we2
    public final boolean isDebugEnabled() {
        return a().isDebugEnabled();
    }

    @Override // defpackage.we2
    public final boolean isErrorEnabled() {
        return a().isErrorEnabled();
    }

    @Override // defpackage.we2
    public final boolean isInfoEnabled() {
        return a().isInfoEnabled();
    }

    @Override // defpackage.we2
    public final boolean isTraceEnabled() {
        return a().isTraceEnabled();
    }

    @Override // defpackage.we2
    public final boolean isWarnEnabled() {
        return a().isWarnEnabled();
    }

    @Override // defpackage.we2
    public final void trace(String str) {
        a().trace(str);
    }

    @Override // defpackage.we2
    public final void warn(String str) {
        a().warn(str);
    }

    @Override // defpackage.we2
    public final void debug(String str, Object obj) {
        a().debug(str, obj);
    }

    @Override // defpackage.we2
    public final void error(String str, Object obj) {
        a().error(str, obj);
    }

    @Override // defpackage.we2
    public final void info(String str, Object obj) {
        a().info(str, obj);
    }

    @Override // defpackage.we2
    public final void trace(String str, Object obj) {
        a().trace(str, obj);
    }

    @Override // defpackage.we2
    public final void warn(String str, Object obj) {
        a().warn(str, obj);
    }

    @Override // defpackage.we2
    public final void debug(String str, Object obj, Object obj2) {
        a().debug(str, obj, obj2);
    }

    @Override // defpackage.we2
    public final void error(String str, Object obj, Object obj2) {
        a().error(str, obj, obj2);
    }

    @Override // defpackage.we2
    public final void info(String str, Object obj, Object obj2) {
        a().info(str, obj, obj2);
    }

    @Override // defpackage.we2
    public final void trace(String str, Object obj, Object obj2) {
        a().trace(str, obj, obj2);
    }

    @Override // defpackage.we2
    public final void warn(String str, Object obj, Object obj2) {
        a().warn(str, obj, obj2);
    }

    @Override // defpackage.we2
    public final void debug(String str, Object... objArr) {
        a().debug(str, objArr);
    }

    @Override // defpackage.we2
    public final void error(String str, Object... objArr) {
        a().error(str, objArr);
    }

    @Override // defpackage.we2
    public final void info(String str, Object... objArr) {
        a().info(str, objArr);
    }

    @Override // defpackage.we2
    public final void trace(String str, Object... objArr) {
        a().trace(str, objArr);
    }

    @Override // defpackage.we2
    public final void warn(String str, Object... objArr) {
        a().warn(str, objArr);
    }

    @Override // defpackage.we2
    public final void debug(String str, Throwable th) {
        a().debug(str, th);
    }

    @Override // defpackage.we2
    public final void error(String str, Throwable th) {
        a().error(str, th);
    }

    @Override // defpackage.we2
    public final void info(String str, Throwable th) {
        a().info(str, th);
    }

    @Override // defpackage.we2
    public final void trace(String str, Throwable th) {
        a().trace(str, th);
    }

    @Override // defpackage.we2
    public final void warn(String str, Throwable th) {
        a().warn(str, th);
    }
}

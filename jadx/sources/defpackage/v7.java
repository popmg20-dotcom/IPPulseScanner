package defpackage;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class v7 extends hh2 {
    public final void a(int i, String str, Object... objArr) {
        if (Log.isLoggable(this.b, i)) {
            ti1 ti1VarA = ye.a(str, objArr);
            c(i, ti1VarA.a, ti1VarA.b);
        }
    }

    public final void b(int i, String str, Throwable th) {
        if (Log.isLoggable(this.b, i)) {
            c(i, str, th);
        }
    }

    public final void c(int i, String str, Throwable th) {
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        Log.println(i, this.b, str);
    }

    @Override // defpackage.we2
    public final void debug(String str, Object obj, Object obj2) {
        a(3, str, obj, obj2);
    }

    @Override // defpackage.we2
    public final void error(String str, Object obj, Object obj2) {
        a(6, str, obj, obj2);
    }

    @Override // defpackage.we2
    public final void info(String str, Object obj, Object obj2) {
        a(4, str, obj, obj2);
    }

    @Override // defpackage.we2
    public final boolean isDebugEnabled() {
        return Log.isLoggable(this.b, 3);
    }

    @Override // defpackage.we2
    public final boolean isErrorEnabled() {
        return Log.isLoggable(this.b, 6);
    }

    @Override // defpackage.we2
    public final boolean isInfoEnabled() {
        return Log.isLoggable(this.b, 4);
    }

    @Override // defpackage.we2
    public final boolean isTraceEnabled() {
        return Log.isLoggable(this.b, 2);
    }

    @Override // defpackage.we2
    public final boolean isWarnEnabled() {
        return Log.isLoggable(this.b, 5);
    }

    @Override // defpackage.we2
    public final void trace(String str, Object obj, Object obj2) {
        a(2, str, obj, obj2);
    }

    @Override // defpackage.we2
    public final void warn(String str, Object obj, Object obj2) {
        a(5, str, obj, obj2);
    }

    @Override // defpackage.we2
    public final void trace(String str, Object obj) {
        a(2, str, obj);
    }

    @Override // defpackage.we2
    public final void debug(String str, Object obj) {
        a(3, str, obj);
    }

    @Override // defpackage.we2
    public final void error(String str, Object obj) {
        a(6, str, obj);
    }

    @Override // defpackage.we2
    public final void info(String str, Object obj) {
        a(4, str, obj);
    }

    @Override // defpackage.we2
    public final void trace(String str) {
        b(2, str, null);
    }

    @Override // defpackage.we2
    public final void warn(String str, Object obj) {
        a(5, str, obj);
    }

    @Override // defpackage.we2
    public final void debug(String str) {
        b(3, str, null);
    }

    @Override // defpackage.we2
    public final void error(String str) {
        b(6, str, null);
    }

    @Override // defpackage.we2
    public final void info(String str) {
        b(4, str, null);
    }

    @Override // defpackage.we2
    public final void trace(String str, Object... objArr) {
        a(2, str, objArr);
    }

    @Override // defpackage.we2
    public final void warn(String str) {
        b(5, str, null);
    }

    @Override // defpackage.we2
    public final void debug(String str, Object... objArr) {
        a(3, str, objArr);
    }

    @Override // defpackage.we2
    public final void error(String str, Object... objArr) {
        a(6, str, objArr);
    }

    @Override // defpackage.we2
    public final void info(String str, Object... objArr) {
        a(4, str, objArr);
    }

    @Override // defpackage.we2
    public final void trace(String str, Throwable th) {
        b(2, str, th);
    }

    @Override // defpackage.we2
    public final void warn(String str, Object... objArr) {
        a(5, str, objArr);
    }

    @Override // defpackage.we2
    public final void debug(String str, Throwable th) {
        b(2, str, th);
    }

    @Override // defpackage.we2
    public final void error(String str, Throwable th) {
        b(6, str, th);
    }

    @Override // defpackage.we2
    public final void info(String str, Throwable th) {
        b(4, str, th);
    }

    @Override // defpackage.we2
    public final void warn(String str, Throwable th) {
        b(5, str, th);
    }
}

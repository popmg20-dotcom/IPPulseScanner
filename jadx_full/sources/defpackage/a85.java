package defpackage;

import java.lang.Thread;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a85 implements Thread.UncaughtExceptionHandler {
    public final String b;
    public final /* synthetic */ f85 f;

    public a85(f85 f85Var, String str) {
        this.f = f85Var;
        this.b = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        t65 t65Var = ((k85) this.f.f).Y;
        k85.h(t65Var);
        t65Var.z0.b(th, this.b);
    }
}

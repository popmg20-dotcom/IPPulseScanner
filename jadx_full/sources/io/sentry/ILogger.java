package io.sentry;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public interface ILogger {
    void b(p5 p5Var, Throwable th, String str, Object... objArr);

    void d(p5 p5Var, String str, Throwable th);

    void h(p5 p5Var, String str, Object... objArr);

    boolean i(p5 p5Var);
}

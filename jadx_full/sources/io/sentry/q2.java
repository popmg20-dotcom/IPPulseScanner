package io.sentry;

import io.sentry.android.core.SentryAndroidOptions;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class q2 implements q0, v0, x0, z3, q1, r1, ILogger {
    public static final q2 b = new q2();
    public static final q2 f = new q2();
    public static final q2 z = new q2();
    public static final q2 A = new q2();
    public static final q2 X = new q2();

    @Override // io.sentry.z3
    public y3 X() {
        return y2.a;
    }

    @Override // io.sentry.x0
    public io.sentry.protocol.w a(io.sentry.protocol.k kVar) {
        return io.sentry.protocol.w.f;
    }

    @Override // io.sentry.ILogger
    public void b(p5 p5Var, Throwable th, String str, Object... objArr) {
        PrintStream printStream = System.out;
        String str2 = String.format(str, objArr);
        String string = th.toString();
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        printStream.println(p5Var + ": " + str2 + " \n " + string + "\n" + stringWriter.toString());
    }

    @Override // io.sentry.ILogger
    public void d(p5 p5Var, String str, Throwable th) {
        if (th == null) {
            h(p5Var, str, new Object[0]);
            return;
        }
        PrintStream printStream = System.out;
        String str2 = String.format(str, th.toString());
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        printStream.println(p5Var + ": " + str2 + "\n" + stringWriter.toString());
    }

    @Override // io.sentry.q1
    public v3 e(x6 x6Var, List list, p6 p6Var) {
        return null;
    }

    @Override // io.sentry.r1
    public io.sentry.transport.g f(SentryAndroidOptions sentryAndroidOptions, io.sentry.internal.debugmeta.c cVar) {
        return new io.sentry.transport.c(sentryAndroidOptions, new io.sentry.android.core.internal.tombstone.c(sentryAndroidOptions), sentryAndroidOptions.getTransportGate(), cVar);
    }

    @Override // io.sentry.z3
    public io.sentry.protocol.w g() {
        return io.sentry.protocol.w.f;
    }

    @Override // io.sentry.ILogger
    public void h(p5 p5Var, String str, Object... objArr) {
        System.out.println(p5Var + ": " + String.format(str, objArr));
    }

    @Override // io.sentry.ILogger
    public boolean i(p5 p5Var) {
        return true;
    }

    @Override // io.sentry.q1
    public boolean isRunning() {
        return false;
    }

    @Override // io.sentry.z3
    public void I() {
    }

    @Override // io.sentry.z3
    public void Q() {
    }

    @Override // io.sentry.q1
    public void close() {
    }

    @Override // io.sentry.q1
    public void start() {
    }

    @Override // io.sentry.z3
    public void stop() {
    }

    @Override // io.sentry.z3
    public void x() {
    }

    @Override // io.sentry.z3
    public void C(io.sentry.protocol.w wVar) {
    }

    @Override // io.sentry.z3
    public void F(io.sentry.android.replay.b bVar) {
    }

    @Override // io.sentry.z3
    public void U(String str) {
    }

    @Override // io.sentry.q1
    public void c(p1 p1Var) {
    }

    @Override // io.sentry.z3
    public void n(Boolean bool) {
    }
}

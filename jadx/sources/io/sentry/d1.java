package io.sentry;

import java.util.List;
import java.util.Map;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public interface d1 {
    io.sentry.protocol.e A();

    x3 B(c4 c4Var);

    String C();

    void D(e4 e4Var);

    void E(io.sentry.protocol.w wVar);

    void F(p1 p1Var);

    List G();

    io.sentry.protocol.j0 H();

    io.sentry.protocol.r I();

    List J();

    String K();

    void L(x3 x3Var);

    void c(g gVar, l0 l0Var);

    void clear();

    d1 clone();

    io.sentry.protocol.j d();

    io.sentry.protocol.w g();

    Map getAttributes();

    Map getExtras();

    p6 getOptions();

    void h(io.sentry.protocol.w wVar);

    p1 i();

    void j(String str, String str2);

    z6 k();

    io.sentry.internal.debugmeta.c l();

    void m();

    io.sentry.featureflags.b n();

    n1 o();

    z6 p();

    Queue q();

    p5 r();

    x3 s();

    z6 t(d4 d4Var);

    void u(String str);

    i1 v();

    Map w();

    List x();

    List y();

    void z(f5 f5Var);
}

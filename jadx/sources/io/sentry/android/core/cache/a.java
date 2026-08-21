package io.sentry.android.core.cache;

import defpackage.pc5;
import io.sentry.clientreport.d;
import io.sentry.d1;
import io.sentry.h4;
import io.sentry.o;
import io.sentry.protocol.w;
import io.sentry.util.e;
import io.sentry.util.q;
import j$.util.DesugarCollections;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements h4, e {
    public final /* synthetic */ int b;

    public static /* synthetic */ void a(int i, int i2) {
        StringBuilder sb = new StringBuilder(i);
        sb.append((Object) "serialized size must be non-negative, was ");
        sb.append(i2);
        throw new IllegalStateException(sb.toString());
    }

    public static /* synthetic */ void b(int i, int i2, Object obj) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(obj);
        sb.append(i2);
        throw new IllegalArgumentException(sb.toString());
    }

    public static /* synthetic */ void c(Object obj, String str) {
        throw new IllegalArgumentException(str + obj);
    }

    public static /* synthetic */ void d(String str) throws pc5 {
        throw new pc5(str);
    }

    public static /* synthetic */ void f(Object obj, String str) throws IOException {
        throw new IOException(str + obj);
    }

    @Override // io.sentry.util.e
    public Object e() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (d dVar : d.values()) {
            for (o oVar : o.values()) {
                concurrentHashMap.put(new io.sentry.clientreport.c(dVar.getReason(), oVar.getCategory()), new AtomicLong(0L));
            }
        }
        return DesugarCollections.unmodifiableMap(concurrentHashMap);
    }

    @Override // io.sentry.h4
    public void m(d1 d1Var) {
        switch (this.b) {
            case 3:
                d1Var.getClass();
                d1Var.h(w.f);
                break;
            default:
                d1Var.B(new q(d1Var));
                break;
        }
    }
}

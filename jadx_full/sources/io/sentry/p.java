package io.sentry;

import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class p implements f0 {
    public final /* synthetic */ int b;
    public final Object f;
    public final Object z;

    public p(p6 p6Var, int i) {
        this.b = i;
        switch (i) {
            case 1:
                this.f = DesugarCollections.synchronizedMap(new WeakHashMap());
                this.z = p6Var;
                break;
            default:
                this.f = DesugarCollections.synchronizedMap(new HashMap());
                this.z = p6Var;
                break;
        }
    }

    public void a(t4 t4Var) {
        io.sentry.protocol.e eVar = t4Var.f;
        if (eVar.h() == null) {
            eVar.t(new io.sentry.protocol.y());
        }
        io.sentry.protocol.y yVarH = eVar.h();
        if (yVarH != null && yVarH.b == null && yVarH.f == null) {
            yVarH.b = (String) this.z;
            yVarH.f = (String) this.f;
        }
    }

    @Override // io.sentry.f0
    public final r6 g(r6 r6Var, l0 l0Var) {
        int i = this.b;
        return r6Var;
    }

    @Override // io.sentry.f0
    public final f5 n(f5 f5Var, l0 l0Var) {
        io.sentry.protocol.v vVarF;
        String str;
        Long l;
        int i = this.b;
        Object obj = this.z;
        Object obj2 = this.f;
        switch (i) {
            case 0:
                Map map = (Map) obj2;
                if (l7.class.isInstance(l0Var.b("sentry:typeCheckHint")) && (vVarF = f5Var.f()) != null && (str = vVarF.b) != null && (l = vVarF.A) != null) {
                    Long l2 = (Long) map.get(str);
                    if (l2 == null || l2.equals(l)) {
                        map.put(str, l);
                    } else {
                        ((p6) obj).getLogger().h(p5.INFO, "Event %s has been dropped due to multi-threaded deduplication", f5Var.b);
                        l0Var.d(io.sentry.hints.e.MULTITHREADED_DEDUPLICATION, "sentry:eventDropReason");
                    }
                }
                break;
            case 1:
                Map map2 = (Map) obj2;
                p6 p6Var = (p6) obj;
                if (p6Var.isEnableDeduplication()) {
                    Throwable thA = f5Var.a();
                    if (thA != null) {
                        if (!map2.containsKey(thA)) {
                            ArrayList arrayList = new ArrayList();
                            for (Throwable cause = thA; cause.getCause() != null; cause = cause.getCause()) {
                                arrayList.add(cause.getCause());
                            }
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                if (map2.containsKey(it.next())) {
                                }
                            }
                            map2.put(thA, null);
                        }
                        p6Var.getLogger().h(p5.DEBUG, "Duplicate Exception detected. Event %s will be discarded.", f5Var.b);
                    }
                } else {
                    p6Var.getLogger().h(p5.DEBUG, "Event deduplication is disabled.", new Object[0]);
                }
                break;
            default:
                a(f5Var);
                break;
        }
        return f5Var;
    }

    @Override // io.sentry.f0
    public final io.sentry.protocol.f0 s(io.sentry.protocol.f0 f0Var, l0 l0Var) {
        switch (this.b) {
            default:
                a(f0Var);
            case 0:
            case 1:
                return f0Var;
        }
    }

    @Override // io.sentry.f0
    public final r5 x(r5 r5Var) {
        int i = this.b;
        return r5Var;
    }

    public p() {
        this.b = 2;
        String property = System.getProperty("java.version");
        String property2 = System.getProperty("java.vendor");
        this.f = property;
        this.z = property2;
    }
}

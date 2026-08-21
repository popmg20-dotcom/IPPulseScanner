package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class l35 {
    public final ih4 a;
    public ih4 b;
    public final n02 c;
    public final ca5 d;

    public l35() {
        ih4 ih4Var = new ih4(5);
        this.a = ih4Var;
        this.b = ((ih4) ih4Var.b).k();
        this.c = new n02(27);
        this.d = new ca5();
        final int i = 1;
        Callable callable = new Callable(this) { // from class: v05
            public final /* synthetic */ l35 b;

            {
                this.b = this;
            }

            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                int i2 = i;
                l35 l35Var = this.b;
                switch (i2) {
                    case 0:
                        return new ha5(l35Var.c);
                    default:
                        return new ha5(l35Var.d);
                }
            }
        };
        HashMap map = (HashMap) ((jf4) ih4Var.d).f;
        map.put("internal.registerCallback", callable);
        final int i2 = 0;
        map.put("internal.eventLogger", new Callable(this) { // from class: v05
            public final /* synthetic */ l35 b;

            {
                this.b = this;
            }

            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                int i22 = i2;
                l35 l35Var = this.b;
                switch (i22) {
                    case 0:
                        return new ha5(l35Var.c);
                    default:
                        return new ha5(l35Var.d);
                }
            }
        });
    }

    public final boolean a(y05 y05Var) throws c45 {
        n02 n02Var = this.c;
        try {
            n02Var.f = y05Var;
            n02Var.z = y05Var.clone();
            ((ArrayList) n02Var.A).clear();
            ((ih4) this.a.c).m("runtime.counter", new p15(Double.valueOf(0.0d)));
            this.d.d(this.b.k(), n02Var);
            if (((y05) n02Var.z).equals((y05) n02Var.f)) {
                return !((ArrayList) n02Var.A).isEmpty();
            }
            return true;
        } catch (Throwable th) {
            throw new c45(th);
        }
    }

    public final void b(h95 h95Var) {
        s15 s15Var;
        try {
            ih4 ih4Var = this.a;
            this.b = ((ih4) ih4Var.b).k();
            if (ih4Var.g(this.b, (j95[]) h95Var.n().toArray(new j95[0])) instanceof n15) {
                throw new IllegalStateException("Program loading failed");
            }
            for (d95 d95Var : h95Var.o().n()) {
                List listO = d95Var.o();
                String strN = d95Var.n();
                Iterator it = listO.iterator();
                while (it.hasNext()) {
                    d25 d25VarG = ih4Var.g(this.b, (j95) it.next());
                    if (!(d25VarG instanceof y15)) {
                        throw new IllegalArgumentException("Invalid rule definition");
                    }
                    ih4 ih4Var2 = this.b;
                    if (ih4Var2.l(strN)) {
                        d25 d25VarO = ih4Var2.o(strN);
                        if (!(d25VarO instanceof s15)) {
                            throw new IllegalStateException("Invalid function name: ".concat(String.valueOf(strN)));
                        }
                        s15Var = (s15) d25VarO;
                    } else {
                        s15Var = null;
                    }
                    if (s15Var == null) {
                        throw new IllegalStateException("Rule function is undefined: ".concat(String.valueOf(strN)));
                    }
                    s15Var.j(this.b, Collections.singletonList(d25VarG));
                }
            }
        } catch (Throwable th) {
            throw new c45(th);
        }
    }
}

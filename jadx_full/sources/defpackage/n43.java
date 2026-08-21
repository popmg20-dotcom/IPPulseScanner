package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class n43 implements du2 {
    public final kz a;
    public final on2 b;
    public s43 c;
    public final t43 d;
    public pm1 e;
    public boolean f = false;

    public n43(kz kzVar, on2 on2Var, t43 t43Var) {
        this.a = kzVar;
        this.b = on2Var;
        this.d = t43Var;
        synchronized (this) {
            this.c = (s43) on2Var.d();
        }
    }

    @Override // defpackage.du2
    public final void a(Object obj) {
        lz lzVar = (lz) obj;
        lz lzVar2 = lz.CLOSING;
        s43 s43Var = s43.b;
        if (lzVar == lzVar2 || lzVar == lz.CLOSED || lzVar == lz.RELEASING || lzVar == lz.RELEASED) {
            b(s43Var);
            if (this.f) {
                this.f = false;
                pm1 pm1Var = this.e;
                if (pm1Var != null) {
                    pm1Var.cancel(false);
                    this.e = null;
                    return;
                }
                return;
            }
            return;
        }
        if ((lzVar == lz.OPENING || lzVar == lz.OPEN || lzVar == lz.PENDING_OPEN) && !this.f) {
            kz kzVar = this.a;
            b(s43Var);
            ArrayList arrayList = new ArrayList();
            vv vvVar = new vv();
            vvVar.c = new wj3();
            yv yvVar = new yv(vvVar);
            vvVar.b = yvVar;
            vvVar.a = fw.class;
            try {
                kw kwVar = new kw(vvVar, kzVar);
                arrayList.add(kwVar);
                kzVar.g(yu0.a(), kwVar);
                vvVar.a = "waitForCaptureResult";
            } catch (Exception e) {
                yvVar.b(e);
            }
            r20 r20VarW = n12.W(pm1.b(yvVar), new m43(this), yu0.a());
            m43 m43Var = new m43(this);
            r20 r20VarW2 = n12.W(r20VarW, new ha1(7, m43Var), yu0.a());
            this.e = r20VarW2;
            n02 n02Var = new n02(this, arrayList, kzVar);
            r20VarW2.a(new um1(0, r20VarW2, n02Var), yu0.a());
            this.f = true;
        }
    }

    public final void b(s43 s43Var) {
        synchronized (this) {
            try {
                if (this.c.equals(s43Var)) {
                    return;
                }
                this.c = s43Var;
                ez4.o("StreamStateObserver", "Update Preview stream state to " + s43Var);
                this.b.i(s43Var);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.du2
    public final void onError(Throwable th) {
        pm1 pm1Var = this.e;
        if (pm1Var != null) {
            pm1Var.cancel(false);
            this.e = null;
        }
        b(s43.b);
    }
}

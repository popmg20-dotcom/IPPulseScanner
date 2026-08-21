package defpackage;

import j$.util.Optional;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class s03 implements Iterator {
    public static final HashMap y0;
    public final aq3 b;
    public final uf4 f;
    public Optional X = Optional.empty();
    public HashMap Z = new HashMap(y0);
    public final vd1 z = new vd1(100);
    public final vd1 A = new vd1(10);
    public Optional Y = Optional.of(new o03(this, 19));

    static {
        HashMap map = new HashMap();
        y0 = map;
        map.put("!", "!");
        map.put("!!", "tag:yaml.org,2002:");
    }

    public s03(uf4 uf4Var, w34 w34Var) {
        this.b = new aq3(uf4Var, w34Var);
        this.f = uf4Var;
    }

    public static op3 f(Optional optional) {
        return new op3(Optional.empty(), Optional.empty(), new dt0(true, false, 2), "", qp3.Y, optional, optional);
    }

    public static c80 g(f80 f80Var) {
        return new c80(f80Var.c, f80Var.d, f80Var.a, f80Var.b);
    }

    public final boolean a(int i) {
        e();
        return this.X.isPresent() && ((x51) this.X.get()).a() == i;
    }

    public final Optional b() {
        return (Optional) this.A.b();
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final x51 next() {
        x51 x51VarE = e();
        this.X = Optional.empty();
        return x51VarE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final fs2 d(boolean z, boolean z2) {
        Optional optional;
        Optional optional2;
        Optional optional3;
        Optional optional4;
        Optional optional5;
        Optional optionalEmpty = Optional.empty();
        Optional optionalEmpty2 = Optional.empty();
        Optional optionalEmpty3 = Optional.empty();
        aq3 aq3Var = this.b;
        boolean z3 = true;
        boolean zC = aq3Var.c(1);
        vd1 vd1Var = this.z;
        if (zC) {
            x6 x6Var = (x6) aq3Var.next();
            w6 w6Var = new w6(Optional.of(x6Var.c), x6Var.a, x6Var.b);
            this.Y = Optional.of((r53) vd1Var.b());
            return w6Var;
        }
        Optional optionalEmpty4 = Optional.empty();
        int i = 2;
        zp3 zp3Var = null;
        if (aq3Var.c(2)) {
            h7 h7Var = (h7) aq3Var.next();
            Optional optional6 = h7Var.a;
            Optional optional7 = h7Var.b;
            Optional optionalOf = Optional.of(h7Var.c);
            if (aq3Var.c(19)) {
                qa4 qa4Var = (qa4) aq3Var.next();
                Optional optional8 = qa4Var.a;
                Optional optional9 = qa4Var.b;
                zp3Var = qa4Var.c;
                optionalEmpty3 = optional8;
                optional7 = optional9;
            }
            optional3 = optionalOf;
            optional = optional6;
            optional2 = optionalEmpty3;
            optionalEmpty2 = optional7;
        } else {
            if (aq3Var.c(19)) {
                qa4 qa4Var2 = (qa4) aq3Var.next();
                Optional optional10 = qa4Var2.a;
                Optional optional11 = qa4Var2.b;
                zp3Var = qa4Var2.c;
                if (aq3Var.c(2)) {
                    h7 h7Var2 = (h7) aq3Var.next();
                    optional11 = h7Var2.b;
                    optionalEmpty4 = Optional.of(h7Var2.c);
                }
                optional = optional10;
                optional2 = optional;
                optionalEmpty2 = optional11;
            } else {
                optional = optionalEmpty;
                optional2 = optionalEmpty3;
            }
            optional3 = optionalEmpty4;
        }
        Optional optionalEmpty5 = Optional.empty();
        if (zp3Var != null) {
            Optional optional12 = zp3Var.a;
            String str = zp3Var.b;
            if (optional12.isPresent()) {
                String str2 = (String) optional12.get();
                if (!this.Z.containsKey(str2)) {
                    throw new v90("while parsing a node", optional, ha0.n("found undefined tag handle ", str2), optional2, null);
                }
                optionalEmpty5 = Optional.of(((String) this.Z.get(str2)) + str);
            } else {
                optionalEmpty5 = Optional.of(str);
            }
        }
        Optional optional13 = optionalEmpty5;
        if (optional.isEmpty()) {
            optional5 = aq3Var.o().a;
            optional4 = optional5;
        } else {
            optional4 = optionalEmpty2;
            optional5 = optional;
        }
        boolean zIsEmpty = optional13.isEmpty();
        if (z2 && aq3Var.c(4)) {
            vs3 vs3Var = new vs3(optional3, optional13, zIsEmpty, 2, optional5, aq3Var.o().b);
            this.Y = Optional.of(new o03(this, 18));
            return vs3Var;
        }
        int i2 = 16;
        boolean z4 = false;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        if (aq3Var.c(16)) {
            rp3 rp3Var = (rp3) aq3Var.next();
            op3 op3Var = new op3(optional3, optional13, (rp3Var.d && optional13.isEmpty()) ? new dt0(z3, z4, i) : optional13.isEmpty() ? new dt0(objArr5 == true ? 1 : 0, z3, i) : new dt0(objArr4 == true ? 1 : 0, objArr3 == true ? 1 : 0, i), rp3Var.c, rp3Var.e, optional5, rp3Var.b);
            this.Y = Optional.of((r53) vd1Var.b());
            return op3Var;
        }
        if (aq3Var.c(14)) {
            vs3 vs3Var2 = new vs3(optional3, optional13, zIsEmpty, 1, optional5, aq3Var.o().b);
            this.Y = Optional.of(new o03(this, i2));
            return vs3Var2;
        }
        if (aq3Var.c(12)) {
            eh2 eh2Var = new eh2(optional3, optional13, zIsEmpty, 1, optional5, aq3Var.o().b);
            this.Y = Optional.of(new o03(this, 11));
            return eh2Var;
        }
        int i3 = 5;
        if (z && aq3Var.c(6)) {
            vs3 vs3Var3 = new vs3(optional3, optional13, zIsEmpty, 2, optional5, aq3Var.o().a);
            this.Y = Optional.of(new o03(this, i3));
            return vs3Var3;
        }
        if (z && aq3Var.c(5)) {
            eh2 eh2Var2 = new eh2(optional3, optional13, zIsEmpty, 2, optional5, aq3Var.o().a);
            this.Y = Optional.of(new o03(this, objArr2 == true ? 1 : 0));
            return eh2Var2;
        }
        if (optional3.isPresent() || optional13.isPresent()) {
            op3 op3Var2 = new op3(optional3, optional13, new dt0(zIsEmpty, objArr == true ? 1 : 0, i), "", qp3.Y, optional5, optional4);
            this.Y = Optional.of((r53) vd1Var.b());
            return op3Var2;
        }
        re4 re4VarO = aq3Var.o();
        throw new v90(ha0.o("while parsing a ", z ? "block" : "flow", " node"), optional5, "expected the node content, but found '" + qe4.u(re4VarO.a()) + "'", re4VarO.a, null);
    }

    public final x51 e() {
        if (this.X.isEmpty()) {
            this.Y.ifPresent(new dg(11, this));
        }
        return (x51) this.X.orElseThrow(new v6(3));
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.X.isEmpty()) {
            this.Y.ifPresent(new dg(11, this));
        }
        return this.X.isPresent();
    }
}

package defpackage;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gt0 extends it0 {
    public final zs0[] A;
    public volatile boolean A0;
    public final lt0[] X;
    public final ft0[] Y;
    public final gt0[] Z;
    public final hr0 f;
    public final gt0[] y0;
    public final ws0[] z;
    public final fa5 z0;

    public gt0(hr0 hr0Var, gt0[] gt0VarArr, fa5 fa5Var) throws xs0 {
        this.z0 = fa5Var;
        this.f = hr0Var;
        this.Z = (gt0[]) gt0VarArr.clone();
        this.A0 = false;
        HashMap map = new HashMap();
        for (gt0 gt0Var : gt0VarArr) {
            map.put(gt0Var.f.H(), gt0Var);
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            x02 x02Var = hr0Var.z0;
            if (i >= x02Var.z) {
                gt0[] gt0VarArr2 = new gt0[arrayList.size()];
                this.y0 = gt0VarArr2;
                arrayList.toArray(gt0VarArr2);
                fa5Var.a(this, this.f.K());
                this.z = hr0Var.C0.size() > 0 ? new ws0[hr0Var.C0.size()] : mt0.c;
                for (int i2 = 0; i2 < hr0Var.C0.size(); i2++) {
                    this.z[i2] = new ws0((yo0) hr0Var.C0.get(i2), this, null);
                }
                this.A = hr0Var.D0.size() > 0 ? new zs0[hr0Var.D0.size()] : mt0.e;
                for (int i3 = 0; i3 < hr0Var.D0.size(); i3++) {
                    this.A[i3] = new zs0((fp0) hr0Var.D0.get(i3), this, null);
                }
                this.X = hr0Var.E0.size() > 0 ? new lt0[hr0Var.E0.size()] : mt0.f;
                for (int i4 = 0; i4 < hr0Var.E0.size(); i4++) {
                    this.X[i4] = new lt0((es0) hr0Var.E0.get(i4), this);
                }
                this.Y = hr0Var.F0.size() > 0 ? new ft0[hr0Var.F0.size()] : mt0.d;
                for (int i5 = 0; i5 < hr0Var.F0.size(); i5++) {
                    this.Y[i5] = new ft0((rq0) hr0Var.F0.get(i5), this, null, i5, true);
                }
                return;
            }
            int iF = x02Var.f(i);
            if (iF < 0 || iF >= hr0Var.y0.f.size()) {
                break;
            }
            gt0 gt0Var2 = (gt0) map.get(hr0Var.y0.get(iF));
            if (gt0Var2 != null) {
                arrayList.add(gt0Var2);
            }
            i++;
        }
        throw new xs0(this, "Invalid public dependency index.");
    }

    public static gt0 j(hr0 hr0Var, gt0[] gt0VarArr) throws xs0 {
        gt0 gt0Var = new gt0(hr0Var, gt0VarArr, new fa5(gt0VarArr));
        for (ws0 ws0Var : gt0Var.z) {
            ws0Var.j();
        }
        for (lt0 lt0Var : gt0Var.X) {
            for (jt0 jt0Var : lt0Var.X) {
                gt0 gt0Var2 = jt0Var.A.A;
                fa5 fa5Var = gt0Var2.z0;
                rr0 rr0Var = jt0Var.f;
                if (!(fa5Var.q(jt0Var, rr0Var.H()) instanceof ws0)) {
                    throw new xs0(jt0Var, "\"" + rr0Var.H() + "\" is not a message type.");
                }
                if (!(gt0Var2.z0.q(jt0Var, rr0Var.L()) instanceof ws0)) {
                    throw new xs0(jt0Var, "\"" + rr0Var.L() + "\" is not a message type.");
                }
            }
        }
        for (ft0 ft0Var : gt0Var.Y) {
            at0 at0Var = ft0.F0;
            ft0Var.j();
        }
        return gt0Var;
    }

    public static gt0 l(String[] strArr, gt0[] gt0VarArr) {
        byte[] bytes;
        if (strArr.length == 1) {
            bytes = strArr[0].getBytes(i12.b);
        } else {
            StringBuilder sb = new StringBuilder();
            for (String str : strArr) {
                sb.append(str);
            }
            bytes = sb.toString().getBytes(i12.b);
        }
        try {
            fr0 fr0Var = hr0.M0;
            fr0Var.getClass();
            hr0 hr0Var = (hr0) fr0Var.c(bytes, 0, bytes.length, i1.a);
            try {
                return j(hr0Var, gt0VarArr);
            } catch (xs0 e) {
                s53.o("Invalid embedded descriptor for \"", hr0Var.H(), "\".", e);
                return null;
            }
        } catch (s12 e2) {
            st4.l("Failed to parse protocol buffer descriptor for generated code.", e2);
            return null;
        }
    }

    @Override // defpackage.it0
    public final String d() {
        return this.f.H();
    }

    @Override // defpackage.it0
    public final it0 e() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // defpackage.it0
    public final gq0 f() {
        Object objB;
        int i = k().b;
        zo0 zo0Var = zo0.EDITION_UNKNOWN;
        if (i >= 1000) {
            return gq0.G0;
        }
        xp0 xp0Var = null;
        if (k() == zo0.EDITION_PROTO2 && this.f.J().B0) {
            xp0 xp0VarU = gq0.G0.u();
            xn1 xn1Var = h32.A0;
            d32 d32VarN = g32.C0.u();
            f32 f32Var = f32.UTF8_VALIDATION_UNKNOWN;
            d32VarN.X |= 2;
            d32VarN.Z = 2;
            d32VarN.S();
            g32 g32VarU = d32VarN.q();
            if (!g32VarU.c()) {
                throw a1.C(g32VarU);
            }
            int i2 = yn1.A;
            xn1Var.getClass();
            Method method = xn1Var.d;
            if (xn1Var.b().B0 != xp0VarU.f()) {
                StringBuilder sb = new StringBuilder("Extension is for type \"");
                sb.append(xn1Var.b().B0.A);
                sb.append("\" which does not match message type \"");
                xe.k(fw.y(sb, xp0VarU.f().A, "\"."));
                return null;
            }
            xp0VarU.U();
            ft0 ft0VarB = xn1Var.b();
            jd1 jd1Var = xp0VarU.X;
            ft0 ft0VarB2 = xn1Var.b();
            if (ft0VarB2.y()) {
                objB = g32VarU;
                if (ft0VarB2.r().b == ct0.ENUM) {
                    ArrayList arrayList = new ArrayList();
                    for (Object objB2 : (List) g32VarU) {
                        if (xn1Var.b().n().ordinal() == 7) {
                            objB2 = yn1.B(objB2, method, new Object[0]);
                        }
                        arrayList.add(objB2);
                    }
                    objB = arrayList;
                }
            } else {
                objB = g32VarU;
                if (xn1Var.b().n().ordinal() == 7) {
                    objB = yn1.B(g32VarU, method, new Object[0]);
                }
            }
            jd1Var.n(ft0VarB, objB);
            xp0VarU.S();
            xp0Var = xp0VarU;
        }
        return xp0Var != null ? xp0Var.p() : gq0.G0;
    }

    @Override // defpackage.it0
    public final String getName() {
        return this.f.H();
    }

    @Override // defpackage.it0
    public final c1 h() {
        return this.f;
    }

    public final zo0 k() {
        hr0 hr0Var = this.f;
        String strN = hr0Var.N();
        if (strN.equals("proto3")) {
            return zo0.EDITION_PROTO3;
        }
        if (!strN.equals("editions")) {
            return zo0.EDITION_PROTO2;
        }
        zo0 zo0VarB = zo0.b(hr0Var.J0);
        return zo0VarB == null ? zo0.EDITION_UNKNOWN : zo0VarB;
    }

    public final void m() {
        try {
            n();
        } catch (xs0 e) {
            s53.o("Invalid features for \"", this.f.H(), "\".", e);
        }
    }

    public final void n() {
        if (this.A0) {
            return;
        }
        synchronized (this) {
            try {
                if (this.A0) {
                    return;
                }
                g(this.f.J().L());
                for (ws0 ws0Var : this.z) {
                    ws0Var.o();
                }
                for (zs0 zs0Var : this.A) {
                    zs0Var.k();
                }
                for (lt0 lt0Var : this.X) {
                    lt0Var.g(lt0Var.f.J().K());
                    for (jt0 jt0Var : lt0Var.X) {
                        jt0Var.g(jt0Var.f.K().K());
                    }
                }
                for (ft0 ft0Var : this.Y) {
                    at0 at0Var = ft0.F0;
                    ft0Var.g(ft0Var.z.N().L());
                }
                this.A0 = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.it0
    public final gt0 c() {
        return this;
    }

    public gt0(String str, ws0 ws0Var) throws xs0 {
        fa5 fa5Var = new fa5(new gt0[0]);
        this.z0 = fa5Var;
        gr0 gr0VarT = hr0.L0.u();
        gr0VarT.Y = fw.y(new StringBuilder(), ws0Var.A, ".placeholder.proto");
        gr0VarT.X |= 1;
        gr0VarT.S();
        gr0VarT.Z = str;
        gr0VarT.X |= 2;
        gr0VarT.S();
        yo0 yo0Var = ws0Var.f;
        yo0Var.getClass();
        gr0VarT.V();
        gr0VarT.C0.add(yo0Var);
        gr0VarT.S();
        hr0 hr0VarU = gr0VarT.q();
        if (hr0VarU.c()) {
            this.f = hr0VarU;
            this.Z = new gt0[0];
            this.y0 = new gt0[0];
            this.A0 = false;
            this.z = new ws0[]{ws0Var};
            this.A = mt0.e;
            this.X = mt0.f;
            this.Y = mt0.d;
            fa5Var.a(this, str);
            fa5Var.e(ws0Var);
            return;
        }
        throw a1.C(hr0VarU);
    }
}

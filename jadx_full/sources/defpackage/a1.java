package defpackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class a1 implements ml2, ql2 {
    public static vl4 C(c1 c1Var) {
        ArrayList<String> arrayList = new ArrayList();
        vo.o(c1Var, "", arrayList);
        StringBuilder sb = new StringBuilder("Message missing required fields: ");
        boolean z = true;
        for (String str : arrayList) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(str);
        }
        return new vl4(sb.toString());
    }

    public void A(cm4 cm4Var) {
        cm4 cm4VarI = i();
        cm4 cm4Var2 = cm4.f;
        yl4 yl4VarP = yl4.p();
        yl4VarP.w(cm4VarI);
        yl4VarP.w(cm4Var);
        G(yl4VarP.p());
    }

    public abstract a1 B(ft0 ft0Var);

    public abstract a1 D(ft0 ft0Var, Object obj);

    public void E(yl4 yl4Var) {
        G(yl4Var.p());
    }

    @Override // defpackage.ml2
    public final ml2 F(byte[] bArr, int i, int i2, o91 o91Var) throws s12 {
        try {
            m60 m60VarD = m60.d(bArr, i, i2, false);
            y(m60VarD, o91Var);
            m60VarD.a(0);
            return this;
        } catch (s12 e) {
            throw e;
        } catch (IOException e2) {
            zo2.o(t("byte array"), e2);
            return null;
        }
    }

    public abstract a1 G(cm4 cm4Var);

    @Override // defpackage.ql2
    public abstract ws0 f();

    public abstract a1 o(ft0 ft0Var, Object obj);

    public abstract c1 p();

    public abstract c1 q();

    public a1 r(ft0 ft0Var) {
        throw new UnsupportedOperationException("getFieldBuilder() called on an unsupported message type.");
    }

    @Override // defpackage.ml2
    public final ml2 s(int i, int i2, byte[] bArr) throws s12 {
        try {
            m60 m60VarD = m60.d(bArr, i, i2, false);
            M(m60VarD, l91.h);
            m60VarD.a(0);
            return this;
        } catch (s12 e) {
            throw e;
        } catch (IOException e2) {
            zo2.o(t("byte array"), e2);
            return null;
        }
    }

    public final String t(String str) {
        return "Reading " + getClass().getName() + " from a " + str + " threw an IOException (should never happen).";
    }

    public final String toString() {
        return sb4.a().d(this);
    }

    public yl4 u() {
        cm4 cm4VarI = i();
        cm4 cm4Var = cm4.f;
        yl4 yl4VarP = yl4.p();
        yl4VarP.w(cm4VarI);
        return yl4VarP;
    }

    public a1 v(c1 c1Var) {
        Map mapL = c1Var.l();
        if (c1Var.f() != f()) {
            xe.k("mergeFrom(Message) can only merge messages of the same type.");
            return null;
        }
        for (Map.Entry entry : mapL.entrySet()) {
            ft0 ft0Var = (ft0) entry.getKey();
            if (ft0Var.y()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    o(ft0Var, it.next());
                }
            } else if (ft0Var.r().b == ct0.MESSAGE) {
                c1 c1Var2 = (c1) n(ft0Var);
                if (c1Var2 == c1Var2.a()) {
                    D(ft0Var, entry.getValue());
                } else {
                    D(ft0Var, c1Var2.r().x(c1Var2).x((c1) entry.getValue()).p());
                }
            } else {
                D(ft0Var, entry.getValue());
            }
        }
        A(c1Var.i());
        return this;
    }

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public a1 M(m60 m60Var, o91 o91Var) {
        m60Var.getClass();
        yl4 yl4VarU = u();
        sn snVar = new sn();
        snVar.b = true;
        snVar.f = this;
        ws0 ws0VarF = f();
        while (true) {
            int iS = m60Var.s();
            if (iS == 0) {
                break;
            }
            m60 m60Var2 = m60Var;
            o91 o91Var2 = o91Var;
            if (!vo.D(m60Var2, yl4VarU, o91Var2, ws0VarF, snVar, iS)) {
                break;
            }
            m60Var = m60Var2;
            o91Var = o91Var2;
        }
        if (yl4VarU != null) {
            E(yl4VarU);
        }
        return this;
    }

    public /* bridge */ a1 x(c1 c1Var) {
        return v(c1Var);
    }

    public /* bridge */ void y(m60 m60Var, o91 o91Var) {
        M(m60Var, o91Var);
    }

    public final void z(zt ztVar, o91 o91Var) {
        try {
            m60 m60VarD = m60.d(ztVar.f, ztVar.e(), ztVar.size(), true);
            y(m60VarD, o91Var);
            m60VarD.a(0);
        } catch (s12 e) {
            throw e;
        } catch (IOException e2) {
            zo2.o(t("ByteString"), e2);
        }
    }
}

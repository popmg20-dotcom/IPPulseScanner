package defpackage;

import java.util.Iterator;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class it0 {
    public volatile gq0 b;

    public final gq0 b() {
        if (this.b == null && (c().k() == zo0.EDITION_PROTO2 || c().k() == zo0.EDITION_PROTO3)) {
            c().m();
        }
        if (this.b != null) {
            return this.b;
        }
        zo2.n(ha0.o("Features not yet loaded for ", d(), "."));
        return null;
    }

    public abstract gt0 c();

    public abstract String d();

    public abstract it0 e();

    public gq0 f() {
        return gq0.G0;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g(gq0 gq0Var) {
        gq0 gq0VarF;
        boolean z;
        boolean z2;
        xp0 xp0VarU;
        it0 it0VarE = e();
        lq0 lq0Var = null;
        if (it0VarE != null) {
            gq0 gq0Var2 = gq0.G0;
            if (gq0Var.equals(gq0Var2)) {
                gq0VarF = f();
                if (gq0VarF.equals(gq0Var2)) {
                    this.b = it0VarE.b;
                    i();
                    return;
                }
            } else {
                gq0VarF = null;
            }
        }
        Iterator it = gq0Var.X.f().keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            ft0 ft0Var = (ft0) it.next();
            int i = ft0Var.z.Z;
            xn1 xn1Var = h32.A0;
            if (i == xn1Var.b().z.Z && ft0Var != xn1Var.b()) {
                z = true;
                break;
            }
        }
        if (!gq0Var.z.b.isEmpty()) {
            z2 = gq0Var.z.b.containsKey(Integer.valueOf(h32.A0.b().z.Z));
        }
        if (z || z2) {
            l91 l91Var = new l91();
            l91Var.b(h32.A0);
            zt ztVarG = gq0Var.g();
            try {
                wp0 wp0Var = gq0.H0;
                wp0Var.getClass();
                m60 m60VarD = m60.d(ztVarG.f, 0, ztVarG.size(), true);
                nl2 nl2Var = (nl2) wp0Var.a(m60VarD, l91Var);
                m60VarD.a(0);
                i1.b(nl2Var);
                gq0Var = (gq0) nl2Var;
            } catch (s12 e) {
                xs0 xs0Var = new xs0(this, "Failed to parse features with Java feature extension registry.");
                xs0Var.initCause(e);
                throw xs0Var;
            }
        }
        if (it0VarE == null) {
            zo0 zo0VarK = c().k();
            Logger logger = mt0.a;
            mq0 mq0Var = mq0.A0;
            ws0 ws0Var = vs0.A0;
            xn1 xn1Var2 = h32.A0;
            if (mt0.i == null) {
                synchronized (mt0.class) {
                    if (mt0.i == null) {
                        try {
                            l91 l91Var2 = new l91();
                            l91Var2.b(h32.A0);
                            byte[] bytes = "\n'\u0018\u0084\u0007\"\u0003Ê>\u0000*\u001d\b\u0001\u0010\u0002\u0018\u0002 \u0003(\u00010\u00028\u0002@\u0001Ê>\n\b\u0001\u0010\u0001\u0018\u0000 \u0001(\u0003\n'\u0018ç\u0007\"\u0003Ê>\u0000*\u001d\b\u0002\u0010\u0001\u0018\u0001 \u0002(\u00010\u00018\u0002@\u0001Ê>\n\b\u0000\u0010\u0001\u0018\u0000 \u0001(\u0003\n'\u0018è\u0007\"\u0013\b\u0001\u0010\u0001\u0018\u0001 \u0002(\u00010\u0001Ê>\u0004\b\u0000\u0010\u0001*\r8\u0002@\u0001Ê>\u0006\u0018\u0000 \u0001(\u0003\n'\u0018é\u0007\"\u001b\b\u0001\u0010\u0001\u0018\u0001 \u0002(\u00010\u00018\u0001@\u0002Ê>\b\b\u0000\u0010\u0001\u0018\u0000(\u0001*\u0005Ê>\u0002 \u0000 æ\u0007(é\u0007".getBytes(i12.b);
                            hq0 hq0Var = mq0.B0;
                            hq0Var.getClass();
                            mt0.i = (mq0) hq0Var.c(bytes, 0, bytes.length, l91Var2);
                        } catch (Exception e2) {
                            throw new AssertionError(e2);
                        }
                    }
                }
            }
            mq0 mq0Var2 = mt0.i;
            int i2 = zo0VarK.b;
            zo0 zo0VarB = zo0.b(mq0Var2.Z);
            if (zo0VarB == null) {
                zo0VarB = zo0.EDITION_UNKNOWN;
            }
            if (i2 < zo0VarB.b) {
                StringBuilder sb = new StringBuilder("Edition ");
                sb.append(zo0VarK);
                sb.append(" is lower than the minimum supported edition ");
                zo0 zo0VarB2 = zo0.b(mq0Var2.Z);
                if (zo0VarB2 == null) {
                    zo0VarB2 = zo0.EDITION_UNKNOWN;
                }
                sb.append(zo0VarB2);
                sb.append("!");
                throw new IllegalArgumentException(sb.toString());
            }
            int i3 = zo0VarK.b;
            zo0 zo0VarB3 = zo0.b(mq0Var2.y0);
            if (zo0VarB3 == null) {
                zo0VarB3 = zo0.EDITION_UNKNOWN;
            }
            if (i3 > zo0VarB3.b && zo0VarK != zo0.EDITION_UNSTABLE) {
                StringBuilder sb2 = new StringBuilder("Edition ");
                sb2.append(zo0VarK);
                sb2.append(" is greater than the maximum supported edition ");
                zo0 zo0VarB4 = zo0.b(mq0Var2.y0);
                if (zo0VarB4 == null) {
                    zo0VarB4 = zo0.EDITION_UNKNOWN;
                }
                sb2.append(zo0VarB4);
                sb2.append("!");
                throw new IllegalArgumentException(sb2.toString());
            }
            for (lq0 lq0Var2 : mq0Var2.Y) {
                zo0 zo0VarB5 = zo0.b(lq0Var2.Y);
                if (zo0VarB5 == null) {
                    zo0VarB5 = zo0.EDITION_UNKNOWN;
                }
                if (zo0VarB5.b > zo0VarK.b) {
                    break;
                } else {
                    lq0Var = lq0Var2;
                }
            }
            if (lq0Var == null) {
                st4.p("Edition ", zo0VarK, " does not have a valid default FeatureSet!");
                return;
            } else {
                xp0 xp0VarU2 = lq0Var.H().u();
                xp0VarU2.b0(lq0Var.J());
                xp0VarU = xp0VarU2.p().u();
            }
        } else {
            xp0VarU = it0VarE.b.u();
        }
        if (gq0VarF == null) {
            gq0VarF = f();
        }
        xp0VarU.b0(gq0VarF);
        xp0VarU.b0(gq0Var);
        gq0 gq0VarZ = xp0VarU.p();
        gq0 gq0Var3 = (gq0) mt0.h.putIfAbsent(gq0VarZ, gq0VarZ);
        if (gq0Var3 != null) {
            gq0VarZ = gq0Var3;
        }
        this.b = gq0VarZ;
        i();
    }

    public abstract String getName();

    public abstract c1 h();

    public void i() {
    }
}

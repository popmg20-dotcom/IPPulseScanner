package defpackage;

import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import j$.util.Objects;
import j$.util.Optional;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class o03 implements r53 {
    public final /* synthetic */ int a;
    public final /* synthetic */ s03 b;

    public /* synthetic */ o03(s03 s03Var, int i) {
        this.a = i;
        this.b = s03Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.r53
    public final x51 a() {
        Optional optional;
        int i = this.a;
        int i2 = 3;
        int i3 = 4;
        int i4 = 13;
        int i5 = 17;
        int i6 = 7;
        int i7 = 8;
        boolean z = false;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        Object[] objArr6 = 0;
        Object[] objArr7 = 0;
        Object[] objArr8 = 0;
        Object[] objArr9 = 0;
        Object[] objArr10 = 0;
        Object[] objArr11 = 0;
        int i8 = 1;
        char c = 1;
        char c2 = 1;
        char c3 = 1;
        char c4 = 1;
        char c5 = 1;
        char c6 = 1;
        char c7 = 1;
        char c8 = 1;
        char c9 = 1;
        char c10 = 1;
        s03 s03Var = this.b;
        switch (i) {
            case 0:
                s03Var.A.c(s03Var.b.next().a);
                return new o03(s03Var, c == true ? 1 : 0).a();
            case 1:
                vd1 vd1Var = s03Var.z;
                aq3 aq3Var = s03Var.b;
                if (aq3Var.c(20)) {
                    s03Var.Y = Optional.of(new o03(s03Var, c2 == true ? 1 : 0));
                    return s03.g((f80) aq3Var.next());
                }
                if (aq3Var.c(15)) {
                    re4 next = aq3Var.next();
                    if (aq3Var.d(15, 21, 3)) {
                        s03Var.Y = Optional.of(new o03(s03Var, 2));
                        return s03.f(next.b);
                    }
                    vd1Var.c(new o03(s03Var, 2));
                    return s03Var.d(true, true);
                }
                if (aq3Var.c(3)) {
                    re4 next2 = aq3Var.next();
                    bh2 bh2Var = new bh2(next2.a, next2.b, 0);
                    s03Var.Y = Optional.of((r53) vd1Var.b());
                    s03Var.b();
                    return bh2Var;
                }
                re4 re4VarO = aq3Var.o();
                throw new v90("while parsing a block mapping", s03Var.b(), "expected <block end>, but found '" + qe4.u(re4VarO.a()) + "'", re4VarO.a, null);
            case 2:
                vd1 vd1Var2 = s03Var.z;
                aq3 aq3Var2 = s03Var.b;
                if (!aq3Var2.c(21)) {
                    if (aq3Var2.c(16)) {
                        vd1Var2.c(new o03(s03Var, c4 == true ? 1 : 0));
                        return s03Var.d(true, true);
                    }
                    s03Var.Y = Optional.of(new o03(s03Var, c3 == true ? 1 : 0));
                    return s03.f(aq3Var2.o().a);
                }
                re4 next3 = aq3Var2.next();
                if (aq3Var2.c(20)) {
                    p03 p03Var = new p03(s03Var);
                    s03Var.Y = Optional.of(p03Var);
                    return p03Var.a();
                }
                if (aq3Var2.d(15, 21, 3)) {
                    s03Var.Y = Optional.of(new o03(s03Var, c5 == true ? 1 : 0));
                    return s03.f(next3.b);
                }
                vd1Var2.c(new o03(s03Var, c6 == true ? 1 : 0));
                return s03Var.d(true, true);
            case 3:
                HashMap map = s03.y0;
                return s03Var.d(true, false);
            case 4:
                aq3 aq3Var3 = s03Var.b;
                if (aq3Var3.c(20)) {
                    s03Var.Y = Optional.of(new o03(s03Var, i3));
                    return s03.g((f80) aq3Var3.next());
                }
                if (aq3Var3.c(4)) {
                    return new q03(s03Var, (nn) aq3Var3.next(), objArr == true ? 1 : 0).a();
                }
                if (aq3Var3.c(3)) {
                    re4 next4 = aq3Var3.next();
                    bh2 bh2Var2 = new bh2(next4.a, next4.b, 1);
                    s03Var.Y = Optional.of((r53) s03Var.z.b());
                    s03Var.b();
                    return bh2Var2;
                }
                re4 re4VarO2 = aq3Var3.o();
                throw new v90("while parsing a block collection", s03Var.b(), "expected <block end>, but found '" + qe4.u(re4VarO2.a()) + "'", re4VarO2.a, null);
            case 5:
                s03Var.A.c(s03Var.b.next().a);
                return new o03(s03Var, i3).a();
            case 6:
                aq3 aq3Var4 = s03Var.b;
                if (aq3Var4.c(20)) {
                    s03Var.Y = Optional.of(new o03(s03Var, 6));
                    return s03.g((f80) aq3Var4.next());
                }
                if (!aq3Var4.d(7, 9, 8, 17)) {
                    HashMap map2 = s03.y0;
                    return s03Var.d(true, false);
                }
                op3 op3VarF = s03.f(aq3Var4.o().a);
                s03Var.Y = Optional.of((r53) s03Var.z.b());
                return op3VarF;
            case 7:
                aq3 aq3Var5 = s03Var.b;
                Optional optional2 = aq3Var5.o().a;
                if (aq3Var5.c(8)) {
                    optional = aq3Var5.next().b;
                    z = true;
                } else {
                    if (aq3Var5.c(7)) {
                        throw new v90(2, "expected '<document end>' before directives, but found '" + qe4.u(aq3Var5.o().a()) + "'", aq3Var5.o().a);
                    }
                    optional = optional2;
                }
                s03Var.Z.clear();
                dx0 dx0Var = new dx0(z, optional2, optional);
                s03Var.Y = Optional.of(new o03(s03Var, i7));
                return dx0Var;
            case 8:
                vd1 vd1Var3 = s03Var.A;
                vd1 vd1Var4 = s03Var.z;
                aq3 aq3Var6 = s03Var.b;
                if (aq3Var6.c(20)) {
                    s03Var.Y = Optional.of(new o03(s03Var, i7));
                    return s03.g((f80) aq3Var6.next());
                }
                while (aq3Var6.c(8)) {
                    aq3Var6.next();
                }
                if (aq3Var6.c(20)) {
                    s03Var.Y = Optional.of(new o03(s03Var, i7));
                    return s03.g((f80) aq3Var6.next());
                }
                if (aq3Var6.c(17)) {
                    v34 v34Var = (v34) aq3Var6.next();
                    u34 u34Var = new u34(v34Var.a, v34Var.b, 0);
                    if (!vd1Var4.a.isEmpty()) {
                        zo2.t(vd1Var4, "Unexpected end of stream. States left: ");
                    } else {
                        if (vd1Var3.a.isEmpty()) {
                            s03Var.Y = Optional.empty();
                            return u34Var;
                        }
                        zo2.t(vd1Var3, "Unexpected end of stream. Marks left: ");
                    }
                    return null;
                }
                aq3Var6.b.h = 0;
                Optional optional3 = aq3Var6.o().a;
                Optional optionalEmpty = Optional.empty();
                HashMap map3 = new HashMap();
                while (true) {
                    Optional optional4 = optionalEmpty;
                    while (aq3Var6.c(7)) {
                        cv0 cv0Var = (cv0) aq3Var6.next();
                        Optional optional5 = cv0Var.d;
                        Optional optional6 = cv0Var.a;
                        String str = cv0Var.c;
                        if (optional5.isPresent()) {
                            List list = (List) optional5.get();
                            if (str.equals("YAML")) {
                                if (optional4.isPresent()) {
                                    throw new v90(2, "found duplicate YAML directive", optional6);
                                }
                                optionalEmpty = Optional.of((uz3) ((bd2) s03Var.f.e).apply(new uz3(((Integer) list.get(0)).intValue(), ((Integer) list.get(1)).intValue())));
                            } else if (str.equals("TAG")) {
                                String str2 = (String) list.get(0);
                                String str3 = (String) list.get(1);
                                if (map3.containsKey(str2)) {
                                    throw new v90(2, ha0.n("duplicate tag handle ", str2), optional6);
                                }
                                map3.put(str2, str3);
                            } else {
                                continue;
                            }
                        }
                    }
                    HashMap map4 = new HashMap();
                    if (!map3.isEmpty()) {
                        map4.putAll(map3);
                    }
                    for (Map.Entry entry : s03.y0.entrySet()) {
                        if (!map3.containsKey(entry.getKey())) {
                            map3.put((String) entry.getKey(), (String) entry.getValue());
                        }
                    }
                    s03Var.Z = map3;
                    Objects.requireNonNull(optional4);
                    while (aq3Var6.c(20)) {
                        aq3Var6.next();
                    }
                    if (aq3Var6.c(17)) {
                        throw new v90(2, "expected '<document start>', but found '" + qe4.u(aq3Var6.o().a()) + "'", aq3Var6.o().a);
                    }
                    if (aq3Var6.c(9)) {
                        ex0 ex0Var = new ex0(true, optional4, map4, optional3, aq3Var6.next().b);
                        vd1Var4.c(new o03(s03Var, i6));
                        s03Var.Y = Optional.of(new o03(s03Var, 6));
                        return ex0Var;
                    }
                    throw new v90(2, "expected '<document start>', but found '" + qe4.u(aq3Var6.o().a()) + "'", aq3Var6.o().a);
                }
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                aq3 aq3Var7 = s03Var.b;
                c80 c80VarG = s03.g((f80) aq3Var7.next());
                if (!aq3Var7.c(20)) {
                    s03Var.Y = Optional.of((r53) s03Var.z.b());
                }
                return c80VarG;
            case 10:
                s03Var.Y = Optional.of(new r03(s03Var, objArr3 == true ? 1 : 0, objArr2 == true ? 1 : 0));
                return s03.f(s03Var.b.o().a);
            case 11:
                s03Var.A.c(s03Var.b.next().a);
                return new r03(s03Var, c7 == true ? 1 : 0, objArr4 == true ? 1 : 0).a();
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                aq3 aq3Var8 = s03Var.b;
                if (!aq3Var8.c(21)) {
                    s03Var.Y = Optional.of(new r03(s03Var, objArr6 == true ? 1 : 0, objArr5 == true ? 1 : 0));
                    return s03.f(aq3Var8.o().a);
                }
                re4 next5 = aq3Var8.next();
                if (aq3Var8.d(10, 11)) {
                    s03Var.Y = Optional.of(new r03(s03Var, objArr8 == true ? 1 : 0, objArr7 == true ? 1 : 0));
                    return s03.f(next5.b);
                }
                s03Var.z.c(new r03(s03Var, objArr10 == true ? 1 : 0, objArr9 == true ? 1 : 0));
                return s03Var.d(false, false);
            case 13:
                s03Var.Y = Optional.of(new r03(s03Var, objArr11 == true ? 1 : 0, c8 == true ? 1 : 0));
                re4 re4VarO3 = s03Var.b.o();
                return new bh2(re4VarO3.a, re4VarO3.b, 0);
            case 14:
                aq3 aq3Var9 = s03Var.b;
                re4 next6 = aq3Var9.next();
                if (aq3Var9.d(21, 10, 13)) {
                    s03Var.Y = Optional.of(new o03(s03Var, 15));
                    return s03.f(next6.b);
                }
                s03Var.z.c(new o03(s03Var, 15));
                return s03Var.d(false, false);
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                aq3 aq3Var10 = s03Var.b;
                if (!aq3Var10.c(21)) {
                    s03Var.Y = Optional.of(new o03(s03Var, i4));
                    return s03.f(aq3Var10.o().a);
                }
                re4 next7 = aq3Var10.next();
                if (aq3Var10.d(10, 13)) {
                    s03Var.Y = Optional.of(new o03(s03Var, i4));
                    return s03.f(next7.b);
                }
                s03Var.z.c(new o03(s03Var, i4));
                return s03Var.d(false, false);
            case 16:
                s03Var.A.c(s03Var.b.next().a);
                return new r03(s03Var, c10 == true ? 1 : 0, c9 == true ? 1 : 0).a();
            case 17:
                aq3 aq3Var11 = s03Var.b;
                if (aq3Var11.c(20)) {
                    s03Var.Y = Optional.of(new o03(s03Var, i5));
                    return s03.g((f80) aq3Var11.next());
                }
                if (aq3Var11.d(7, 9, 17)) {
                    return new o03(s03Var, i7).a();
                }
                Optional optional7 = aq3Var11.o().a;
                ex0 ex0Var2 = new ex0(false, Optional.empty(), Collections.EMPTY_MAP, optional7, optional7);
                s03Var.z.c(new o03(s03Var, i6));
                s03Var.Y = Optional.of(new o03(s03Var, i2));
                return ex0Var2;
            case 18:
                aq3 aq3Var12 = s03Var.b;
                if (aq3Var12.c(20)) {
                    s03Var.Y = Optional.of(new o03(s03Var, 18));
                    return s03.g((f80) aq3Var12.next());
                }
                if (aq3Var12.c(4)) {
                    return new q03(s03Var, (nn) aq3Var12.next(), i8).a();
                }
                re4 re4VarO4 = aq3Var12.o();
                bh2 bh2Var3 = new bh2(re4VarO4.a, re4VarO4.b, 1);
                s03Var.Y = Optional.of((r53) s03Var.z.b());
                return bh2Var3;
            default:
                c44 c44Var = (c44) s03Var.b.next();
                u34 u34Var2 = new u34(c44Var.a, c44Var.b, 1);
                s03Var.Y = Optional.of(new o03(s03Var, i5));
                return u34Var2;
        }
    }
}

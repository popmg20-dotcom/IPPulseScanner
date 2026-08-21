package defpackage;

import io.netty.channel.internal.ChannelUtils;
import java.util.ArrayList;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b30 implements nm1 {
    public final cf0 b;
    public final int f;
    public final jp z;

    public b30(cf0 cf0Var, int i, jp jpVar) {
        this.b = cf0Var;
        this.f = i;
        this.z = jpVar;
    }

    @Override // defpackage.zf1
    public Object a(ag1 ag1Var, ge0 ge0Var) {
        Object objH = p95.h(new uf(ag1Var, this, null, 3), ge0Var);
        return objH == mf0.b ? objH : xl4.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0015  */
    @Override // defpackage.nm1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zf1 b(cf0 cf0Var, int i, jp jpVar) {
        cf0 cf0Var2 = this.b;
        cf0 cf0VarX = cf0Var.X(cf0Var2);
        jp jpVar2 = jp.b;
        jp jpVar3 = this.z;
        int i2 = this.f;
        if (jpVar == jpVar2) {
            if (i2 != -3) {
                if (i != -3) {
                    if (i2 != -2) {
                        if (i == -2) {
                            i = i2;
                        } else {
                            i += i2;
                            if (i < 0) {
                                i = ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
                            }
                        }
                    }
                }
            }
            jpVar = jpVar3;
        }
        return (n12.c(cf0VarX, cf0Var2) && i == i2 && jpVar == jpVar3) ? this : e(cf0VarX, i, jpVar);
    }

    public String c() {
        return null;
    }

    public abstract Object d(q53 q53Var, ge0 ge0Var);

    public abstract b30 e(cf0 cf0Var, int i, jp jpVar);

    public zf1 f() {
        return null;
    }

    public y20 g(lf0 lf0Var) {
        int i = this.f;
        if (i == -3) {
            i = -2;
        }
        Function2 hjVar = new hj(this, null, 5);
        q53 q53Var = new q53(co4.I(lf0Var, this.b), uf2.a(i, this.z, null, 4));
        q53Var.l0(of0.z, q53Var, hjVar);
        return q53Var;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String strC = c();
        if (strC != null) {
            arrayList.add(strC);
        }
        c41 c41Var = c41.b;
        cf0 cf0Var = this.b;
        if (cf0Var != c41Var) {
            arrayList.add("context=" + cf0Var);
        }
        int i = this.f;
        if (i != -3) {
            arrayList.add("capacity=" + i);
        }
        jp jpVar = jp.b;
        jp jpVar2 = this.z;
        if (jpVar2 != jpVar) {
            arrayList.add("onBufferOverflow=" + jpVar2);
        }
        StringBuilder sb = new StringBuilder(getClass().getSimpleName());
        sb.append('[');
        return fw.x(sb, d70.j0(arrayList, ", ", null, null, null, 62), ']');
    }
}

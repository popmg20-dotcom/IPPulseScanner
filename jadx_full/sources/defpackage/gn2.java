package defpackage;

import io.netty.channel.internal.ChannelUtils;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gn2 {
    public final kz2 a;
    public final v92 b;

    public gn2(z50 z50Var, kz2 kz2Var) {
        kz2Var.getClass();
        this.a = kz2Var;
        zf1 zf1Var = kz2Var.a;
        v92 v92Var = new v92();
        v92Var.b = new qt((byte) 0, 9);
        hv3 hv3VarA = iv3.a(1, ChannelUtils.WRITE_STATUS_SNDBUF_FULL, jp.b);
        v92Var.f = hv3VarA;
        ge0 ge0Var = null;
        v92Var.z = new f54(hv3VarA, new uf(v92Var, ge0Var, 1));
        int i = 4;
        z14 z14VarB = ji0.B(z50Var, null, of0.f, new hj(zf1Var, v92Var, ge0Var, i), 1);
        z14VarB.M(new f0(i, v92Var));
        v92Var.A = z14VarB;
        v92Var.X = new av(7, new hj(v92Var, ge0Var, 3));
        this.b = v92Var;
    }
}

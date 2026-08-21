package defpackage;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class gj3 implements am1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ sl3 f;

    public /* synthetic */ gj3(sl3 sl3Var, int i) {
        this.b = i;
        this.f = sl3Var;
    }

    @Override // defpackage.am1
    public final Object g(Object obj) throws Exception {
        int i = this.b;
        sl3 sl3Var = this.f;
        switch (i) {
            case 0:
                go3 go3Var = (go3) obj;
                go3Var.getClass();
                io3 io3VarD0 = go3Var.D0(sl3Var.a);
                sl3Var.b.g(io3VarD0);
                try {
                    int iP = p95.p(io3VarD0, "id");
                    int iP2 = p95.p(io3VarD0, RtspHeaders.Values.TIME);
                    int iP3 = p95.p(io3VarD0, "packageName");
                    int iP4 = p95.p(io3VarD0, "proxy");
                    int iP5 = p95.p(io3VarD0, "rule");
                    int iP6 = p95.p(io3VarD0, "server");
                    ArrayList arrayList = new ArrayList();
                    while (io3VarD0.C0()) {
                        arrayList.add(new zi3((int) io3VarD0.getLong(iP), io3VarD0.getLong(iP2), io3VarD0.e0(iP3), io3VarD0.e0(iP4), io3VarD0.e0(iP5), io3VarD0.e0(iP6)));
                        break;
                    }
                    return arrayList;
                } finally {
                    io3VarD0.close();
                }
            default:
                io3 io3Var = (io3) obj;
                sl3Var.b.g(io3Var);
                return Integer.valueOf(io3Var.C0() ? io3Var.v0() : 0);
        }
    }
}

package defpackage;

import com.tencent.mars.xlog.Xlog;
import java.util.ArrayList;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class sw implements wv {
    public final /* synthetic */ int b;
    public final /* synthetic */ ex f;

    public /* synthetic */ sw(ex exVar, int i) {
        this.b = i;
        this.f = exVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.wv
    public Object n(final vv vvVar) {
        int i = this.b;
        Object[] objArr = 0;
        final int i2 = 1;
        final ex exVar = this.f;
        switch (i) {
            case 0:
                at3 at3Var = exVar.z;
                final Object[] objArr2 = objArr == true ? 1 : 0;
                at3Var.execute(new Runnable() { // from class: ww
                    @Override // java.lang.Runnable
                    public final void run() {
                        ed4 ed4Var;
                        switch (objArr2) {
                            case 0:
                                ex exVar2 = exVar;
                                vv vvVar2 = vvVar;
                                nc2 nc2VarM = exVar2.E0;
                                if (nc2VarM == null) {
                                    if (exVar2.c1 != 1) {
                                        nc2VarM = fx3.m(new sw(exVar2, 3));
                                        exVar2.E0 = nc2VarM;
                                    } else {
                                        nc2VarM = zy1.z;
                                        exVar2.E0 = nc2VarM;
                                    }
                                }
                                switch (fw.G(exVar2.c1)) {
                                    case 1:
                                    case 5:
                                    case 6:
                                    case 7:
                                    case 8:
                                        if (exVar2.y0.a() || ((ed4Var = (ed4) exVar2.b1.f) != null && !((AtomicBoolean) ed4Var.z).get())) {
                                            z = true;
                                        }
                                        exVar2.b1.n();
                                        exVar2.G(2);
                                        if (z) {
                                            r25.j(null, exVar2.G0.isEmpty());
                                            exVar2.u();
                                        }
                                        break;
                                    case 2:
                                    case 3:
                                    case 4:
                                        r25.j(null, exVar2.A0 == null);
                                        exVar2.G(2);
                                        r25.j(null, exVar2.G0.isEmpty());
                                        exVar2.u();
                                        break;
                                    case Xlog.COMPRESS_LEVEL9 /* 9 */:
                                    case 10:
                                        exVar2.G(2);
                                        exVar2.t();
                                        break;
                                    default:
                                        exVar2.w("release() ignored due to being in state: ".concat(fw.H(exVar2.c1)), null);
                                        break;
                                }
                                n12.N(nc2VarM, vvVar2);
                                break;
                            default:
                                ex exVar3 = exVar;
                                vv vvVar3 = vvVar;
                                cm2 cm2Var = exVar3.R0;
                                vvVar3.b(Boolean.valueOf(cm2Var != null ? exVar3.b.v(ex.z(cm2Var)) : false));
                                break;
                        }
                    }
                });
                return "Release[request=" + exVar.D0.getAndIncrement() + "]";
            case 1:
                try {
                    ArrayList arrayList = new ArrayList(exVar.b.r().b().c);
                    arrayList.add((ez) exVar.S0.Z);
                    arrayList.add(new xw(exVar, vvVar));
                    exVar.f.a.F(exVar.z0.a, exVar.z, co4.l(arrayList));
                    return "configAndCloseTask";
                } catch (RuntimeException | xx e) {
                    exVar.w("Unable to open camera for configAndClose: " + e.getMessage(), e);
                    vvVar.d(e);
                    return "configAndCloseTask";
                }
            case 2:
            default:
                try {
                    exVar.z.execute(new Runnable() { // from class: ww
                        @Override // java.lang.Runnable
                        public final void run() {
                            ed4 ed4Var;
                            switch (i2) {
                                case 0:
                                    ex exVar2 = exVar;
                                    vv vvVar2 = vvVar;
                                    nc2 nc2VarM = exVar2.E0;
                                    if (nc2VarM == null) {
                                        if (exVar2.c1 != 1) {
                                            nc2VarM = fx3.m(new sw(exVar2, 3));
                                            exVar2.E0 = nc2VarM;
                                        } else {
                                            nc2VarM = zy1.z;
                                            exVar2.E0 = nc2VarM;
                                        }
                                    }
                                    switch (fw.G(exVar2.c1)) {
                                        case 1:
                                        case 5:
                                        case 6:
                                        case 7:
                                        case 8:
                                            if (exVar2.y0.a() || ((ed4Var = (ed4) exVar2.b1.f) != null && !((AtomicBoolean) ed4Var.z).get())) {
                                                z = true;
                                            }
                                            exVar2.b1.n();
                                            exVar2.G(2);
                                            if (z) {
                                                r25.j(null, exVar2.G0.isEmpty());
                                                exVar2.u();
                                            }
                                            break;
                                        case 2:
                                        case 3:
                                        case 4:
                                            r25.j(null, exVar2.A0 == null);
                                            exVar2.G(2);
                                            r25.j(null, exVar2.G0.isEmpty());
                                            exVar2.u();
                                            break;
                                        case Xlog.COMPRESS_LEVEL9 /* 9 */:
                                        case 10:
                                            exVar2.G(2);
                                            exVar2.t();
                                            break;
                                        default:
                                            exVar2.w("release() ignored due to being in state: ".concat(fw.H(exVar2.c1)), null);
                                            break;
                                    }
                                    n12.N(nc2VarM, vvVar2);
                                    break;
                                default:
                                    ex exVar3 = exVar;
                                    vv vvVar3 = vvVar;
                                    cm2 cm2Var = exVar3.R0;
                                    vvVar3.b(Boolean.valueOf(cm2Var != null ? exVar3.b.v(ex.z(cm2Var)) : false));
                                    break;
                            }
                        }
                    });
                    return "isMeteringRepeatingAttached";
                } catch (RejectedExecutionException unused) {
                    vvVar.d(new RuntimeException("Unable to check if MeteringRepeating is attached. Camera executor shut down."));
                    return "isMeteringRepeatingAttached";
                }
            case 3:
                r25.j("Camera can only be released once, so release completer should be null on creation.", exVar.F0 == null);
                exVar.F0 = vvVar;
                return "Release[camera=" + exVar + "]";
        }
    }
}

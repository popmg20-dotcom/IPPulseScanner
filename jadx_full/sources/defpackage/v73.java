package defpackage;

import android.content.Context;
import com.getsurfboard.R;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class v73 extends v74 implements Function2 {
    public Iterator A0;
    public e03 B0;
    public int C0;
    public int D0;
    public final /* synthetic */ d83 E0;
    public final /* synthetic */ List F0;
    public d83 X;
    public Object Y;
    public Context Z;
    public List y0;
    public bh3 z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v73(d83 d83Var, List list, ge0 ge0Var) {
        super(2, ge0Var);
        this.E0 = d83Var;
        this.F0 = list;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        return ((v73) n((ge0) obj2, (lf0) obj)).p(xl4.a);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        return new v73(this.E0, this.F0, ge0Var);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0119, code lost:
    
        if (r4 == r14) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01ff, code lost:
    
        if (defpackage.ji0.V(r0, r1, r4, r3, r4, r23) == r14) goto L67;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x016e A[Catch: all -> 0x005c, TRY_LEAVE, TryCatch #0 {all -> 0x005c, blocks: (B:12:0x0057, B:46:0x016a, B:48:0x016e, B:43:0x0149), top: B:70:0x0057 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0180  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0166 -> B:46:0x016a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x017c -> B:51:0x017a). Please report as a decompilation issue!!! */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object p(Object obj) {
        List list;
        d83 d83Var;
        List list2;
        int i;
        Context context;
        d83 d83Var2;
        Object objH;
        Context context2;
        List list3;
        int i2;
        d83 d83Var3;
        Iterator it;
        bh3 bh3Var;
        int i3 = this.D0;
        q92 q92Var = q92.b;
        q92 q92Var2 = q92.X;
        cf0 cf0Var = this.f;
        int i4 = 1;
        ge0 ge0Var = null;
        mf0 mf0Var = mf0.b;
        if (i3 == 0) {
            n12.S(obj);
            d83 d83Var4 = this.E0;
            Context context3 = d83Var4.getContext();
            if (context3 != null) {
                r92 lifecycle = d83Var4.getLifecycle();
                gm0 gm0Var = qv0.a;
                tq1 tq1Var = qf2.a.X;
                cf0Var.getClass();
                boolean zQ0 = tq1Var.q0(cf0Var);
                list = this.F0;
                if (!zQ0) {
                    if (lifecycle.b() == q92Var) {
                        vp1.m();
                        return null;
                    }
                    if (lifecycle.b().compareTo(q92Var2) >= 0) {
                        y3 y3Var = d83Var4.b;
                        y3Var.getClass();
                        ((LinearProgressIndicator) y3Var.g).e();
                        d83Var2 = d83Var4;
                        i = 0;
                        context = context3;
                    }
                }
                s73 s73Var = new s73(d83Var4, i4);
                this.X = d83Var4;
                this.Y = list;
                this.Z = context3;
                this.y0 = null;
                this.z0 = null;
                this.A0 = null;
                this.B0 = null;
                this.C0 = 0;
                this.D0 = 1;
                if (ji0.V(lifecycle, q92Var2, zQ0, tq1Var, s73Var, this) != mf0Var) {
                    d83Var = d83Var4;
                    list2 = list;
                    i = 0;
                    context = context3;
                    d83 d83Var5 = d83Var;
                    list = list2;
                    d83Var2 = d83Var5;
                }
                return mf0Var;
            }
            return xl4.a;
        }
        if (i3 != 1) {
            if (i3 == 2) {
                i = this.C0;
                context = (Context) this.Y;
                d83Var2 = this.X;
                n12.S(obj);
                objH = obj;
                ArrayList arrayList = new ArrayList();
                bh3 bh3Var2 = new bh3();
                context2 = context;
                list3 = arrayList;
                i2 = i;
                d83Var3 = d83Var2;
                it = ((List) objH).iterator();
                bh3Var = bh3Var2;
                if (it.hasNext()) {
                }
                return mf0Var;
            }
            if (i3 != 3) {
                if (i3 != 4) {
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(obj);
                return xl4.a;
            }
            i2 = this.C0;
            e03 e03Var = this.B0;
            it = this.A0;
            bh3Var = this.z0;
            list3 = this.y0;
            context2 = (Context) this.Y;
            d83Var3 = this.X;
            try {
                n12.S(obj);
            } catch (Throwable th) {
                list3.add(th);
                i4 = 1;
                if (it.hasNext()) {
                }
                return mf0Var;
            }
            if (bh3Var.b == null) {
                bh3Var.b = ((t53) e03Var.b).b;
            }
            i4 = 1;
            if (it.hasNext()) {
                Object obj2 = ((uk3) it.next()).b;
                Throwable thA = uk3.a(obj2);
                if (thA == null) {
                    e03Var = (e03) obj2;
                    e1 e1Var = d73.a;
                    e03[] e03VarArr = new e03[i4];
                    e03VarArr[0] = e03Var;
                    this.X = d83Var3;
                    this.Y = context2;
                    this.Z = null;
                    this.y0 = list3;
                    this.z0 = bh3Var;
                    this.A0 = it;
                    this.B0 = e03Var;
                    this.C0 = i2;
                    this.D0 = 3;
                    if (d73.j(e03VarArr, this) == mf0Var) {
                    }
                    if (bh3Var.b == null) {
                    }
                    i4 = 1;
                    if (it.hasNext()) {
                    }
                } else {
                    list3.add(thA);
                    i4 = 1;
                    if (it.hasNext()) {
                    }
                }
            } else {
                d83Var3.A.g = (String) bh3Var.b;
                r92 lifecycle2 = d83Var3.getLifecycle();
                gm0 gm0Var2 = qv0.a;
                tq1 tq1Var2 = qf2.a.X;
                cf0Var.getClass();
                boolean zQ02 = tq1Var2.q0(cf0Var);
                if (!zQ02) {
                    if (lifecycle2.b() == q92Var) {
                        vp1.m();
                        return null;
                    }
                    if (lifecycle2.b().compareTo(q92Var2) >= 0) {
                        y3 y3Var2 = d83Var3.b;
                        y3Var2.getClass();
                        ((LinearProgressIndicator) y3Var2.g).b();
                        if (!list3.isEmpty()) {
                            Throwable th2 = (Throwable) d70.d0(list3);
                            CharSequence text = context2.getText(R.string.profile_decode_error);
                            text.getClass();
                            d83Var3.o(th2, text, null, null, null);
                        }
                    }
                    return xl4.a;
                }
                nt ntVar = new nt(3, d83Var3, list3, context2);
                this.X = null;
                this.Y = null;
                this.Z = null;
                this.y0 = null;
                this.z0 = null;
                this.A0 = null;
                this.B0 = null;
                this.C0 = i2;
                this.D0 = 4;
            }
            return mf0Var;
        }
        i = this.C0;
        context = this.Z;
        list2 = (List) this.Y;
        d83Var = this.X;
        n12.S(obj);
        d83 d83Var52 = d83Var;
        list = list2;
        d83Var2 = d83Var52;
        li0 li0Var = new li0(list, ge0Var, i4);
        this.X = d83Var2;
        this.Y = context;
        this.Z = null;
        this.y0 = null;
        this.z0 = null;
        this.A0 = null;
        this.B0 = null;
        this.C0 = i;
        this.D0 = 2;
        objH = p95.h(li0Var, this);
    }
}

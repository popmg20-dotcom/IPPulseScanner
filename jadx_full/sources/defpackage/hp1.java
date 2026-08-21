package defpackage;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class hp1 extends tk implements t9 {
    public final Set P0;

    /* JADX WARN: Illegal instructions before constructor call */
    public hp1(Context context, Looper looper, int i, uf4 uf4Var, rp1 rp1Var, sp1 sp1Var) {
        bg5 bg5VarA = bg5.a(context);
        lp1 lp1Var = lp1.d;
        tj4.i(rp1Var);
        tj4.i(sp1Var);
        super(context, looper, bg5VarA, lp1Var, i, new ub4(rp1Var), new jf4(4, sp1Var), (String) uf4Var.e);
        Set set = (Set) uf4Var.a;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (!set.contains((Scope) it.next())) {
                xe.q("Expanding scopes is not permitted, use implied scopes instead");
                throw null;
            }
        }
        this.P0 = set;
    }

    @Override // defpackage.t9
    public final Set a() {
        return j() ? this.P0 : Collections.EMPTY_SET;
    }

    @Override // defpackage.tk
    public final Account o() {
        return null;
    }

    @Override // defpackage.tk
    public final Set r() {
        return this.P0;
    }
}

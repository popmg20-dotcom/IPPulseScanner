package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ov3 {
    public final gd a;
    public final pv3 b;
    public final Context c;
    public final String d;
    public final n84 e;
    public final Set f;

    public ov3(Context context, String str, Set set, gd gdVar, pv3 pv3Var) {
        set.getClass();
        ig0 ig0Var = new ig0(6, context, str);
        this.a = gdVar;
        this.b = pv3Var;
        this.c = context;
        this.d = str;
        this.e = new n84(ig0Var);
        this.f = set == rv3.a ? null : d70.B0(set);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(Object obj, ie0 ie0Var) throws Throwable {
        nv3 nv3Var;
        if (ie0Var instanceof nv3) {
            nv3Var = (nv3) ie0Var;
            int i = nv3Var.Z;
            if ((i & Integer.MIN_VALUE) != 0) {
                nv3Var.Z = i - Integer.MIN_VALUE;
            } else {
                nv3Var = new nv3(this, ie0Var);
            }
        }
        Object objK = nv3Var.X;
        int i2 = nv3Var.Z;
        boolean z = true;
        if (i2 == 0) {
            n12.S(objK);
            nv3Var.A = this;
            nv3Var.Z = 1;
            objK = this.a.k(obj, nv3Var);
            mf0 mf0Var = mf0.b;
            if (objK == mf0Var) {
                return mf0Var;
            }
        } else {
            if (i2 != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            this = nv3Var.A;
            n12.S(objK);
        }
        if (!((Boolean) objK).booleanValue()) {
            return Boolean.FALSE;
        }
        Set set = this.f;
        n84 n84Var = this.e;
        if (set == null) {
            Map<String, ?> all = ((SharedPreferences) n84Var.getValue()).getAll();
            all.getClass();
            if (all.isEmpty()) {
                z = false;
            }
        } else {
            SharedPreferences sharedPreferences = (SharedPreferences) n84Var.getValue();
            if (!set.isEmpty()) {
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    if (sharedPreferences.contains((String) it.next())) {
                        break;
                    }
                }
                z = false;
            }
        }
        return Boolean.valueOf(z);
    }
}

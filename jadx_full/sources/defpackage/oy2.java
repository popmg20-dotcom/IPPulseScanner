package defpackage;

import android.os.Build;
import android.util.Log;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class oy2 {
    public final gz2 a;
    public final ue2 b;
    public final lb c = new lb(27);
    public final lb d = new lb(27);
    public final zf1 e = ez4.U(new hj(this, null, 25));

    public oy2(gz2 gz2Var, ue2 ue2Var) {
        this.a = gz2Var;
        this.b = ue2Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(hj3 hj3Var, ie0 ie0Var) {
        ny2 ny2Var;
        if (ie0Var instanceof ny2) {
            ny2Var = (ny2) ie0Var;
            int i = ny2Var.Z;
            if ((i & Integer.MIN_VALUE) != 0) {
                ny2Var.Z = i - Integer.MIN_VALUE;
            } else {
                ny2Var = new ny2(this, ie0Var);
            }
        }
        Object objG = ny2Var.X;
        mf0 mf0Var = mf0.b;
        int i2 = ny2Var.Z;
        if (i2 == 0) {
            n12.S(objG);
            gz2 gz2Var = this.a;
            ny2Var.A = hj3Var;
            ny2Var.Z = 1;
            objG = gz2Var.g(ny2Var);
            if (objG == mf0Var) {
                return mf0Var;
            }
        } else {
            if (i2 != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            hj3Var = ny2Var.A;
            n12.S(objG);
        }
        hj3 hj3Var2 = (hj3) objG;
        if (hj3Var2 == hj3Var) {
            xe.q("An instance of PagingSource was re-used when Pager expected to create a new\ninstance. Ensure that the pagingSourceFactory passed to Pager always returns a\nnew instance of PagingSource.");
            return null;
        }
        Class<oy2> cls = oy2.class;
        hj3Var2.b(new ly2(0, this, cls, "invalidate", "invalidate()V", 0, 1));
        if (hj3Var != null) {
            ly2 ly2Var = new ly2(0, this, cls, "invalidate", "invalidate()V", 0, 2);
            ue1 ue1Var = hj3Var.a;
            synchronized (((o84) ue1Var.A)) {
                ((ArrayList) ue1Var.z).remove(ly2Var);
            }
        }
        if (hj3Var != null) {
            hj3Var.a();
        }
        if (Build.ID != null && Log.isLoggable("Paging", 3)) {
            Log.d("Paging", "Generated new PagingSource " + hj3Var2, null);
        }
        return hj3Var2;
    }
}

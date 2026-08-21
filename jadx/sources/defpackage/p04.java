package defpackage;

import android.os.IBinder;
import androidx.window.extensions.embedding.SplitInfo;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class p04 {
    public final a5 a;
    public final a5 b;
    public final n04 c;
    public final IBinder d;
    public final SplitInfo.Token e;

    public p04(a5 a5Var, a5 a5Var2, n04 n04Var, IBinder iBinder, SplitInfo.Token token) {
        this.a = a5Var;
        this.b = a5Var2;
        this.c = n04Var;
        this.d = iBinder;
        this.e = token;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p04)) {
            return false;
        }
        p04 p04Var = (p04) obj;
        return n12.c(this.a, p04Var.a) && n12.c(this.b, p04Var.b) && n12.c(this.c, p04Var.c) && n12.c(this.e, p04Var.e) && n12.c(this.d, p04Var.d);
    }

    public final int hashCode() {
        int iHashCode = (this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31;
        SplitInfo.Token token = this.e;
        int iHashCode2 = (iHashCode + (token != null ? token.hashCode() : 0)) * 31;
        IBinder iBinder = this.d;
        return iHashCode2 + (iBinder != null ? iBinder.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SplitInfo:{");
        sb.append("primaryActivityStack=" + this.a + ", ");
        sb.append("secondaryActivityStack=" + this.b + ", ");
        sb.append("splitAttributes=" + this.c + ", ");
        if (this.e != null) {
            sb.append("token=" + this.e);
        }
        IBinder iBinder = this.d;
        if (iBinder != null) {
            sb.append("binder=" + iBinder);
        }
        sb.append("}");
        return sb.toString();
    }
}

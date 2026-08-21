package defpackage;

import androidx.window.extensions.embedding.ActivityStack;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a5 {
    public final List a;
    public final boolean b;
    public final ActivityStack.Token c;

    public a5(List list, boolean z, ActivityStack.Token token) {
        this.a = list;
        this.b = z;
        this.c = token;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a5)) {
            return false;
        }
        a5 a5Var = (a5) obj;
        return this.a.equals(a5Var.a) && this.b == a5Var.b && n12.c(this.c, a5Var.c);
    }

    public final int hashCode() {
        int iHashCode = ((this.a.hashCode() * 31) + (this.b ? 1231 : 1237)) * 31;
        ActivityStack.Token token = this.c;
        return iHashCode + (token != null ? token.hashCode() : 0);
    }

    public final String toString() {
        return "ActivityStack{activitiesInProcess=" + this.a + ", isEmpty=" + this.b + ", token=" + this.c + '}';
    }
}

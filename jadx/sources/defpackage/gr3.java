package defpackage;

import com.getsurfboard.backup.model.BackupSection;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gr3 {
    public final BackupSection a;
    public int b;
    public final List c;
    public String d;
    public transient Exception e;

    public gr3(BackupSection backupSection) {
        ArrayList arrayList = new ArrayList();
        backupSection.getClass();
        this.a = backupSection;
        this.b = 0;
        this.c = arrayList;
        this.d = null;
        this.e = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof gr3)) {
            return false;
        }
        gr3 gr3Var = (gr3) obj;
        return this.a == gr3Var.a && this.b == gr3Var.b && this.c.equals(gr3Var.c) && n12.c(this.d, gr3Var.d) && n12.c(this.e, gr3Var.e);
    }

    public final int hashCode() {
        int iHashCode = (this.c.hashCode() + (((this.a.hashCode() * 31) + this.b) * 31)) * 31;
        String str = this.d;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Exception exc = this.e;
        return iHashCode2 + (exc != null ? exc.hashCode() : 0);
    }

    public final String toString() {
        return "SectionReport(section=" + this.a + ", successCount=" + this.b + ", skipped=" + this.c + ", error=" + this.d + ", exception=" + this.e + ")";
    }
}

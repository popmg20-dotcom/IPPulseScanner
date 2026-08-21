package j$.time.chrono;

import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class h implements j$.time.temporal.p, Serializable {
    public static final /* synthetic */ int e = 0;
    private static final long serialVersionUID = 57387258289L;
    public final a a;
    public final int b;
    public final int c;
    public final int d;

    static {
        j$.time.a.L(new Object[]{j$.time.temporal.b.YEARS, j$.time.temporal.b.MONTHS, j$.time.temporal.b.DAYS});
    }

    public h(a aVar, int i, int i2, int i3) {
        Objects.requireNonNull(aVar, "chrono");
        this.a = aVar;
        this.b = i;
        this.c = i2;
        this.d = i3;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.b == hVar.b && this.c == hVar.c && this.d == hVar.d && this.a.equals(hVar.a);
    }

    @Override // j$.time.temporal.p
    public final j$.time.temporal.m h(j$.time.temporal.m mVar) {
        Objects.requireNonNull(mVar, "temporal");
        a aVar = (a) mVar.m(j$.time.temporal.r.b);
        if (aVar != null && !this.a.equals(aVar)) {
            j$.time.h.g("Chronology mismatch, expected: ", this.a.C(), ", actual: ", aVar.C());
            return null;
        }
        if (this.c == 0) {
            int i = this.b;
            if (i != 0) {
                mVar = mVar.d(i, j$.time.temporal.b.YEARS);
            }
        } else {
            j$.time.temporal.u uVarG = this.a.G(j$.time.temporal.a.MONTH_OF_YEAR);
            long j = (uVarG.a == uVarG.b && uVarG.c == uVarG.d && uVarG.d()) ? (uVarG.d - uVarG.a) + 1 : -1L;
            int i2 = this.b;
            if (j > 0) {
                mVar = mVar.d((((long) i2) * j) + ((long) this.c), j$.time.temporal.b.MONTHS);
            } else {
                if (i2 != 0) {
                    mVar = mVar.d(i2, j$.time.temporal.b.YEARS);
                }
                mVar = mVar.d(this.c, j$.time.temporal.b.MONTHS);
            }
        }
        int i3 = this.d;
        return i3 != 0 ? mVar.d(i3, j$.time.temporal.b.DAYS) : mVar;
    }

    public final int hashCode() {
        return this.a.hashCode() ^ (Integer.rotateLeft(this.d, 16) + (Integer.rotateLeft(this.c, 8) + this.b));
    }

    public final String toString() {
        if (this.b == 0 && this.c == 0 && this.d == 0) {
            return this.a.toString() + " P0D";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.a.toString());
        sb.append(" P");
        int i = this.b;
        if (i != 0) {
            sb.append(i);
            sb.append('Y');
        }
        int i2 = this.c;
        if (i2 != 0) {
            sb.append(i2);
            sb.append('M');
        }
        int i3 = this.d;
        if (i3 != 0) {
            sb.append(i3);
            sb.append('D');
        }
        return sb.toString();
    }

    public Object writeReplace() {
        return new e0((byte) 9, this);
    }
}

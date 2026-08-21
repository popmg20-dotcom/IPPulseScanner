package j$.time.zone;

import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.rtsp.RtspHeaders;
import j$.time.ZoneOffset;
import j$.time.l;
import j$.time.n;
import j$.util.Objects;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class e implements Serializable {
    private static final long serialVersionUID = 6889046316657758795L;
    public final n a;
    public final byte b;
    public final j$.time.e c;
    public final l d;
    public final boolean e;
    public final d f;
    public final ZoneOffset g;
    public final ZoneOffset h;
    public final ZoneOffset i;

    public e(n nVar, int i, j$.time.e eVar, l lVar, boolean z, d dVar, ZoneOffset zoneOffset, ZoneOffset zoneOffset2, ZoneOffset zoneOffset3) {
        this.a = nVar;
        this.b = (byte) i;
        this.c = eVar;
        this.d = lVar;
        this.e = z;
        this.f = dVar;
        this.g = zoneOffset;
        this.h = zoneOffset2;
        this.i = zoneOffset3;
    }

    public static e a(DataInput dataInput) {
        n nVar;
        e eVar;
        l lVarB;
        int i = dataInput.readInt();
        n nVarD = n.D(i >>> 28);
        int i2 = ((264241152 & i) >>> 22) - 32;
        int i3 = (3670016 & i) >>> 19;
        j$.time.e eVarA = i3 == 0 ? null : j$.time.e.A(i3);
        int i4 = (507904 & i) >>> 14;
        d dVar = d.values()[(i & 12288) >>> 12];
        int i5 = (i & 4080) >>> 4;
        int i6 = (i & 12) >>> 2;
        int i7 = i & 3;
        if (i4 == 31) {
            long j = dataInput.readInt();
            l lVar = l.e;
            j$.time.temporal.a.SECOND_OF_DAY.s(j);
            int i8 = (int) (j / 3600);
            nVar = nVarD;
            eVar = null;
            long j2 = j - ((long) (i8 * 3600));
            int i9 = (int) (j2 / 60);
            lVarB = l.B(i8, i9, (int) (j2 - ((long) (i9 * 60))), 0);
        } else {
            nVar = nVarD;
            eVar = null;
            int i10 = i4 % 24;
            l lVar2 = l.e;
            j$.time.temporal.a.HOUR_OF_DAY.s(i10);
            lVarB = l.h[i10];
        }
        ZoneOffset zoneOffsetJ = i5 == 255 ? ZoneOffset.J(dataInput.readInt()) : ZoneOffset.J((i5 - 128) * 900);
        ZoneOffset zoneOffsetJ2 = i6 == 3 ? ZoneOffset.J(dataInput.readInt()) : ZoneOffset.J((i6 * 1800) + zoneOffsetJ.b);
        ZoneOffset zoneOffsetJ3 = ZoneOffset.J(i7 == 3 ? dataInput.readInt() : (i7 * 1800) + zoneOffsetJ.b);
        boolean z = i4 == 24;
        n nVar2 = nVar;
        Objects.requireNonNull(nVar2, "month");
        Objects.requireNonNull(lVarB, RtspHeaders.Values.TIME);
        Objects.requireNonNull(dVar, "timeDefnition");
        Objects.requireNonNull(zoneOffsetJ, "standardOffset");
        Objects.requireNonNull(zoneOffsetJ2, "offsetBefore");
        Objects.requireNonNull(zoneOffsetJ3, "offsetAfter");
        if (i2 < -28 || i2 > 31 || i2 == 0) {
            j$.time.h.c("Day of month indicator must be between -28 and 31 inclusive excluding zero");
            return eVar;
        }
        if (z && !lVarB.equals(l.g)) {
            j$.time.h.c("Time must be midnight when end of day flag is true");
            return eVar;
        }
        if (lVarB.d == 0) {
            return new e(nVar2, i2, eVarA, lVarB, z, dVar, zoneOffsetJ, zoneOffsetJ2, zoneOffsetJ3);
        }
        j$.time.h.c("Time's nano-of-second must be zero");
        return eVar;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a((byte) 3, this);
    }

    public final void b(DataOutput dataOutput) {
        int iN = this.e ? 86400 : this.d.N();
        int i = this.g.b;
        int i2 = this.h.b - i;
        int i3 = this.i.b - i;
        byte b = iN % 3600 == 0 ? this.e ? (byte) 24 : this.d.a : (byte) 31;
        int i4 = i % 900 == 0 ? (i / 900) + 128 : 255;
        int i5 = (i2 == 0 || i2 == 1800 || i2 == 3600) ? i2 / 1800 : 3;
        int i6 = (i3 == 0 || i3 == 1800 || i3 == 3600) ? i3 / 1800 : 3;
        j$.time.e eVar = this.c;
        dataOutput.writeInt((this.a.getValue() << 28) + ((this.b + HttpConstants.SP) << 22) + ((eVar == null ? 0 : eVar.getValue()) << 19) + (b << 14) + (this.f.ordinal() << 12) + (i4 << 4) + (i5 << 2) + i6);
        if (b == 31) {
            dataOutput.writeInt(iN);
        }
        if (i4 == 255) {
            dataOutput.writeInt(i);
        }
        if (i5 == 3) {
            dataOutput.writeInt(this.h.b);
        }
        if (i6 == 3) {
            dataOutput.writeInt(this.i.b);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.a == eVar.a && this.b == eVar.b && this.c == eVar.c && this.f == eVar.f && this.d.equals(eVar.d) && this.e == eVar.e && this.g.equals(eVar.g) && this.h.equals(eVar.h) && this.i.equals(eVar.i);
    }

    public final int hashCode() {
        int iN = ((this.d.N() + (this.e ? 1 : 0)) << 15) + (this.a.ordinal() << 11) + ((this.b + HttpConstants.SP) << 5);
        j$.time.e eVar = this.c;
        return this.i.b ^ ((this.g.b ^ (this.f.ordinal() + (iN + ((eVar == null ? 7 : eVar.ordinal()) << 2)))) ^ this.h.b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TransitionRule[");
        sb.append(this.i.b - this.h.b > 0 ? "Gap " : "Overlap ");
        sb.append(this.h);
        sb.append(" to ");
        sb.append(this.i);
        sb.append(", ");
        j$.time.e eVar = this.c;
        if (eVar != null) {
            byte b = this.b;
            if (b == -1) {
                sb.append(eVar.name());
                sb.append(" on or before last day of ");
                sb.append(this.a.name());
            } else if (b < 0) {
                sb.append(eVar.name());
                sb.append(" on or before last day minus ");
                sb.append((-this.b) - 1);
                sb.append(" of ");
                sb.append(this.a.name());
            } else {
                sb.append(eVar.name());
                sb.append(" on or after ");
                sb.append(this.a.name());
                sb.append(' ');
                sb.append((int) this.b);
            }
        } else {
            sb.append(this.a.name());
            sb.append(' ');
            sb.append((int) this.b);
        }
        sb.append(" at ");
        sb.append(this.e ? "24:00" : this.d.toString());
        sb.append(" ");
        sb.append(this.f);
        sb.append(", standard offset ");
        sb.append(this.g);
        sb.append(']');
        return sb.toString();
    }
}

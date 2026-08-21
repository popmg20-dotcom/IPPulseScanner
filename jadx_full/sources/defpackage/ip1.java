package defpackage;

import j$.time.ZoneId;
import j$.util.DesugarTimeZone;
import j$.util.TimeZoneRetargetInterface;
import java.util.Date;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class ip1 extends TimeZone implements TimeZoneRetargetInterface {
    public final int b;
    public final String f;

    public ip1(boolean z, int i, int i2) {
        if (i >= 24) {
            a71.d(i, " hours out of range");
            throw null;
        }
        if (i2 >= 60) {
            a71.d(i2, " minutes out of range");
            throw null;
        }
        int iP = fw.p(i, 60, i2, 60000);
        this.b = z ? -iP : iP;
        StringBuilder sbB = fw.B(9, "GMT");
        sbB.append(z ? '-' : '+');
        sbB.append((char) ((i / 10) + 48));
        sbB.append((char) ((i % 10) + 48));
        sbB.append(':');
        sbB.append((char) ((i2 / 10) + 48));
        sbB.append((char) ((i2 % 10) + 48));
        this.f = sbB.toString();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ip1) {
            return this.f == ((ip1) obj).f;
        }
        return false;
    }

    @Override // java.util.TimeZone
    public final String getID() {
        return this.f;
    }

    @Override // java.util.TimeZone
    public final int getOffset(int i, int i2, int i3, int i4, int i5, int i6) {
        return this.b;
    }

    @Override // java.util.TimeZone
    public final int getRawOffset() {
        return this.b;
    }

    public final int hashCode() {
        return this.b;
    }

    @Override // java.util.TimeZone
    public final boolean inDaylightTime(Date date) {
        return false;
    }

    @Override // java.util.TimeZone
    public final void setRawOffset(int i) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[GmtTimeZone id=\"");
        sb.append(this.f);
        sb.append("\",offset=");
        return ha0.p(sb, this.b, ']');
    }

    @Override // java.util.TimeZone, j$.util.TimeZoneRetargetInterface
    public /* synthetic */ ZoneId toZoneId() {
        return DesugarTimeZone.toZoneId(this);
    }

    @Override // java.util.TimeZone
    public final boolean useDaylightTime() {
        return false;
    }
}

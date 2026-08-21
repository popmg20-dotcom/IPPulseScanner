package j$.time;

import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import j$.time.temporal.TemporalAccessor;
import j$.util.Objects;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class l implements j$.time.temporal.m, j$.time.temporal.n, Comparable, Serializable {
    public static final l e;
    public static final l f;
    public static final l g;
    public static final l[] h = new l[24];
    private static final long serialVersionUID = 6414437269572265201L;
    public final byte a;
    public final byte b;
    public final byte c;
    public final int d;

    static {
        int i = 0;
        while (true) {
            l[] lVarArr = h;
            if (i >= lVarArr.length) {
                l lVar = lVarArr[0];
                g = lVar;
                l lVar2 = lVarArr[12];
                e = lVar;
                f = new l(23, 59, 59, 999999999);
                return;
            }
            lVarArr[i] = new l(i, 0, 0, 0);
            i++;
        }
    }

    public l(int i, int i2, int i3, int i4) {
        this.a = (byte) i;
        this.b = (byte) i2;
        this.c = (byte) i3;
        this.d = i4;
    }

    public static l B(int i, int i2, int i3, int i4) {
        return ((i2 | i3) | i4) == 0 ? h[i] : new l(i, i2, i3, i4);
    }

    public static l C(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        l lVar = (l) temporalAccessor.m(j$.time.temporal.r.g);
        if (lVar != null) {
            return lVar;
        }
        h.g("Unable to obtain LocalTime from TemporalAccessor: ", temporalAccessor, " of type ", temporalAccessor.getClass().getName());
        return null;
    }

    public static l E(int i, int i2, int i3, int i4) {
        j$.time.temporal.a.HOUR_OF_DAY.s(i);
        j$.time.temporal.a.MINUTE_OF_HOUR.s(i2);
        j$.time.temporal.a.SECOND_OF_MINUTE.s(i3);
        j$.time.temporal.a.NANO_OF_SECOND.s(i4);
        return B(i, i2, i3, i4);
    }

    public static l F(long j) {
        j$.time.temporal.a.NANO_OF_DAY.s(j);
        int i = (int) (j / 3600000000000L);
        long j2 = j - (((long) i) * 3600000000000L);
        int i2 = (int) (j2 / 60000000000L);
        long j3 = j2 - (((long) i2) * 60000000000L);
        int i3 = (int) (j3 / 1000000000);
        return B(i, i2, i3, (int) (j3 - (((long) i3) * 1000000000)));
    }

    public static l L(DataInput dataInput) throws IOException {
        int i;
        int i2;
        int i3 = dataInput.readByte();
        int i4 = 0;
        if (i3 < 0) {
            i3 = ~i3;
            i2 = 0;
            i = 0;
        } else {
            byte b = dataInput.readByte();
            if (b < 0) {
                int i5 = ~b;
                i = 0;
                i4 = i5;
                i2 = 0;
            } else {
                byte b2 = dataInput.readByte();
                if (b2 < 0) {
                    i2 = ~b2;
                    i = 0;
                    i4 = b;
                } else {
                    i = dataInput.readInt();
                    i4 = b;
                    i2 = b2;
                }
            }
        }
        return E(i3, i4, i2, i);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new t((byte) 4, this);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public final int compareTo(l lVar) {
        int iCompare = Integer.compare(this.a, lVar.a);
        return (iCompare == 0 && (iCompare = Integer.compare(this.b, lVar.b)) == 0 && (iCompare = Integer.compare(this.c, lVar.c)) == 0) ? Integer.compare(this.d, lVar.d) : iCompare;
    }

    public final int D(j$.time.temporal.q qVar) {
        switch (k.a[((j$.time.temporal.a) qVar).ordinal()]) {
            case 1:
                return this.d;
            case 2:
                throw new j$.time.temporal.t("Invalid field 'NanoOfDay' for get() method, use getLong() instead");
            case 3:
                return this.d / 1000;
            case 4:
                throw new j$.time.temporal.t("Invalid field 'MicroOfDay' for get() method, use getLong() instead");
            case 5:
                return this.d / 1000000;
            case 6:
                return (int) (M() / 1000000);
            case 7:
                return this.c;
            case 8:
                return N();
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return this.b;
            case 10:
                return (this.a * 60) + this.b;
            case 11:
                return this.a % 12;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                int i = this.a % 12;
                if (i % 12 == 0) {
                    return 12;
                }
                return i;
            case 13:
                return this.a;
            case 14:
                byte b = this.a;
                if (b == 0) {
                    return 24;
                }
                return b;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                return this.a / 12;
            default:
                throw new j$.time.temporal.t(d.a("Unsupported field: ", qVar));
        }
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public final l d(long j, j$.time.temporal.s sVar) {
        if (!(sVar instanceof j$.time.temporal.b)) {
            return (l) sVar.h(this, j);
        }
        switch (k.b[((j$.time.temporal.b) sVar).ordinal()]) {
            case 1:
                return J(j);
            case 2:
                return J((j % 86400000000L) * 1000);
            case 3:
                return J((j % 86400000) * 1000000);
            case 4:
                return K(j);
            case 5:
                return I(j);
            case 6:
                return H(j);
            case 7:
                return H((j % 2) * 12);
            default:
                h.b(sVar, "Unsupported unit: ");
                return null;
        }
    }

    public final l H(long j) {
        return j == 0 ? this : B(((((int) (j % 24)) + this.a) + 24) % 24, this.b, this.c, this.d);
    }

    public final l I(long j) {
        if (j != 0) {
            int i = (this.a * 60) + this.b;
            int i2 = ((((int) (j % 1440)) + i) + 1440) % 1440;
            if (i != i2) {
                return B(i2 / 60, i2 % 60, this.c, this.d);
            }
        }
        return this;
    }

    public final l J(long j) {
        if (j != 0) {
            long jM = M();
            long j2 = (((j % 86400000000000L) + jM) + 86400000000000L) % 86400000000000L;
            if (jM != j2) {
                return B((int) (j2 / 3600000000000L), (int) ((j2 / 60000000000L) % 60), (int) ((j2 / 1000000000) % 60), (int) (j2 % 1000000000));
            }
        }
        return this;
    }

    public final l K(long j) {
        if (j != 0) {
            int i = (this.b * 60) + (this.a * 3600) + this.c;
            int i2 = ((((int) (j % 86400)) + i) + 86400) % 86400;
            if (i != i2) {
                return B(i2 / 3600, (i2 / 60) % 60, i2 % 60, this.d);
            }
        }
        return this;
    }

    public final long M() {
        return (((long) this.c) * 1000000000) + (((long) this.b) * 60000000000L) + (((long) this.a) * 3600000000000L) + ((long) this.d);
    }

    public final int N() {
        return (this.b * 60) + (this.a * 3600) + this.c;
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public final l c(long j, j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return (l) qVar.p(this, j);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        aVar.s(j);
        switch (k.a[aVar.ordinal()]) {
            case 1:
                return P((int) j);
            case 2:
                return F(j);
            case 3:
                return P(((int) j) * 1000);
            case 4:
                return F(j * 1000);
            case 5:
                return P(((int) j) * 1000000);
            case 6:
                return F(j * 1000000);
            case 7:
                int i = (int) j;
                if (this.c != i) {
                    j$.time.temporal.a.SECOND_OF_MINUTE.s(i);
                    return B(this.a, this.b, i, this.d);
                }
                return this;
            case 8:
                return K(j - ((long) N()));
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                int i2 = (int) j;
                if (this.b != i2) {
                    j$.time.temporal.a.MINUTE_OF_HOUR.s(i2);
                    return B(this.a, i2, this.c, this.d);
                }
                return this;
            case 10:
                return I(j - ((long) ((this.a * 60) + this.b)));
            case 11:
                return H(j - ((long) (this.a % 12)));
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                if (j == 12) {
                    j = 0;
                }
                return H(j - ((long) (this.a % 12)));
            case 13:
                int i3 = (int) j;
                if (this.a != i3) {
                    j$.time.temporal.a.HOUR_OF_DAY.s(i3);
                    return B(i3, this.b, this.c, this.d);
                }
                return this;
            case 14:
                if (j == 24) {
                    j = 0;
                }
                int i4 = (int) j;
                if (this.a != i4) {
                    j$.time.temporal.a.HOUR_OF_DAY.s(i4);
                    return B(i4, this.b, this.c, this.d);
                }
                return this;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                return H((j - ((long) (this.a / 12))) * 12);
            default:
                throw new j$.time.temporal.t(d.a("Unsupported field: ", qVar));
        }
    }

    public final l P(int i) {
        if (this.d == i) {
            return this;
        }
        j$.time.temporal.a.NANO_OF_SECOND.s(i);
        return B(this.a, this.b, this.c, i);
    }

    public final void Q(DataOutput dataOutput) throws IOException {
        if (this.d != 0) {
            dataOutput.writeByte(this.a);
            dataOutput.writeByte(this.b);
            dataOutput.writeByte(this.c);
            dataOutput.writeInt(this.d);
            return;
        }
        if (this.c != 0) {
            dataOutput.writeByte(this.a);
            dataOutput.writeByte(this.b);
            dataOutput.writeByte(~this.c);
            return;
        }
        byte b = this.b;
        byte b2 = this.a;
        if (b == 0) {
            dataOutput.writeByte(~b2);
        } else {
            dataOutput.writeByte(b2);
            dataOutput.writeByte(~this.b);
        }
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean e(j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) qVar).A() : qVar != null && qVar.h(this);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (this.a == lVar.a && this.b == lVar.b && this.c == lVar.c && this.d == lVar.d) {
                return true;
            }
        }
        return false;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int h(j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.a ? D(qVar) : j$.time.temporal.r.a(this, qVar);
    }

    public final int hashCode() {
        long jM = M();
        return (int) (jM ^ (jM >>> 32));
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: i */
    public final j$.time.temporal.m o(i iVar) {
        return (l) a.a(iVar, this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u j(j$.time.temporal.q qVar) {
        return j$.time.temporal.r.d(this, qVar);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m k(j$.time.temporal.m mVar) {
        return mVar.c(M(), j$.time.temporal.a.NANO_OF_DAY);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object m(z zVar) {
        if (zVar == j$.time.temporal.r.b || zVar == j$.time.temporal.r.a || zVar == j$.time.temporal.r.e || zVar == j$.time.temporal.r.d) {
            return null;
        }
        if (zVar == j$.time.temporal.r.g) {
            return this;
        }
        if (zVar == j$.time.temporal.r.f) {
            return null;
        }
        return zVar == j$.time.temporal.r.c ? j$.time.temporal.b.NANOS : zVar.g(this);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m p(long j, j$.time.temporal.b bVar) {
        long j2;
        if (j == Long.MIN_VALUE) {
            this = d(Long.MAX_VALUE, bVar);
            j2 = 1;
        } else {
            j2 = -j;
        }
        return this.d(j2, bVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long s(j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.a ? qVar == j$.time.temporal.a.NANO_OF_DAY ? M() : qVar == j$.time.temporal.a.MICRO_OF_DAY ? M() / 1000 : D(qVar) : qVar.m(this);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(18);
        byte b = this.a;
        byte b2 = this.b;
        byte b3 = this.c;
        int i = this.d;
        sb.append(b < 10 ? "0" : "");
        sb.append((int) b);
        sb.append(b2 < 10 ? ":0" : ":");
        sb.append((int) b2);
        if (b3 > 0 || i > 0) {
            sb.append(b3 < 10 ? ":0" : ":");
            sb.append((int) b3);
            if (i > 0) {
                sb.append('.');
                if (i % 1000000 == 0) {
                    sb.append(Integer.toString((i / 1000000) + 1000).substring(1));
                } else if (i % 1000 == 0) {
                    sb.append(Integer.toString((i / 1000) + 1000000).substring(1));
                } else {
                    sb.append(Integer.toString(i + 1000000000).substring(1));
                }
            }
        }
        return sb.toString();
    }
}

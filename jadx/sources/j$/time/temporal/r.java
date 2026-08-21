package j$.time.temporal;

import j$.time.z;
import j$.util.Objects;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public abstract class r {
    public static final z a = new z(3);
    public static final z b = new z(4);
    public static final z c = new z(5);
    public static final z d = new z(6);
    public static final z e = new z(7);
    public static final z f = new z(8);
    public static final z g = new z(9);

    public static int a(TemporalAccessor temporalAccessor, q qVar) {
        u uVarJ = temporalAccessor.j(qVar);
        if (!uVarJ.d()) {
            throw new t("Invalid field " + qVar + " for get() method, use getLong() instead");
        }
        long jS = temporalAccessor.s(qVar);
        if (uVarJ.e(jS)) {
            return (int) jS;
        }
        throw new j$.time.c("Invalid value for " + qVar + " (valid values " + uVarJ + "): " + jS);
    }

    public static m b(m mVar, long j, s sVar) {
        long j2;
        if (j == Long.MIN_VALUE) {
            mVar = mVar.d(Long.MAX_VALUE, sVar);
            j2 = 1;
        } else {
            j2 = -j;
        }
        return mVar.d(j2, sVar);
    }

    public static Object c(TemporalAccessor temporalAccessor, z zVar) {
        if (zVar == a || zVar == b || zVar == c) {
            return null;
        }
        return zVar.g(temporalAccessor);
    }

    public static u d(TemporalAccessor temporalAccessor, q qVar) {
        if (!(qVar instanceof a)) {
            Objects.requireNonNull(qVar, "field");
            return qVar.i(temporalAccessor);
        }
        if (temporalAccessor.e(qVar)) {
            return ((a) qVar).b;
        }
        throw new t(j$.time.d.a("Unsupported field: ", qVar));
    }
}

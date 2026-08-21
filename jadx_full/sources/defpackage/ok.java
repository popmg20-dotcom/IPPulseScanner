package defpackage;

import j$.util.Objects;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class ok implements Comparable {
    public String A;
    public final String b;
    public final int f;
    public int z;

    public ok(String str, int i) {
        this.b = n12.g(str, "No algorithm");
        n12.j("Invalid block size: %d", i > 0, i);
        this.f = i;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        ok okVar = (ok) obj;
        int iCompareToIgnoreCase = -1;
        if (okVar == null) {
            return -1;
        }
        if (this != okVar) {
            String str = okVar.b;
            String str2 = this.b;
            if (str2 == str) {
                iCompareToIgnoreCase = 0;
            } else if (str2 == null) {
                iCompareToIgnoreCase = 1;
            } else if (str != null) {
                iCompareToIgnoreCase = str2.compareToIgnoreCase(str);
            }
            if (iCompareToIgnoreCase != 0) {
                return iCompareToIgnoreCase;
            }
            int iCompare = Integer.compare(this.f, okVar.f);
            if (iCompare != 0) {
                return iCompare;
            }
        }
        return 0;
    }

    public final boolean equals(Object obj) {
        int iCompareToIgnoreCase;
        if (obj != null) {
            if (obj != this) {
                if (ok.class == obj.getClass()) {
                    ok okVar = (ok) obj;
                    if (this != okVar) {
                        String str = okVar.b;
                        String str2 = this.b;
                        iCompareToIgnoreCase = str2 == str ? 0 : str2 == null ? 1 : str == null ? -1 : str2.compareToIgnoreCase(str);
                        if (iCompareToIgnoreCase == 0 && (iCompareToIgnoreCase = Integer.compare(this.f, okVar.f)) == 0) {
                        }
                        if (iCompareToIgnoreCase != 0) {
                        }
                    }
                    iCompareToIgnoreCase = 0;
                    if (iCompareToIgnoreCase != 0) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode;
        synchronized (this) {
            try {
                iHashCode = this.z;
                if (iHashCode == 0) {
                    iHashCode = Objects.hashCode(this.b) + this.f;
                    this.z = iHashCode;
                    if (iHashCode == 0) {
                        iHashCode = 1;
                        this.z = 1;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return iHashCode;
    }

    public final String toString() {
        String str;
        synchronized (this) {
            try {
                str = this.A;
                if (str == null) {
                    str = ok.class.getSimpleName() + "[" + this.b + ":" + this.f + "]";
                    this.A = str;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }
}

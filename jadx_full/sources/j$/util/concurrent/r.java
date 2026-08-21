package j$.util.concurrent;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class r extends l {
    public r e;
    public r f;
    public r g;
    public r h;
    public boolean i;

    public r(int i, Object obj, Object obj2, l lVar, r rVar) {
        super(i, obj, obj2, lVar);
        this.e = rVar;
    }

    @Override // j$.util.concurrent.l
    public final l a(int i, Object obj) {
        return b(i, obj, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0046 A[PHI: r7
      0x0046: PHI (r7v5 java.lang.Class) = (r7v4 java.lang.Class), (r7v6 java.lang.Class) binds: [B:28:0x003f, B:20:0x0029] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final r b(int i, Object obj, Class cls) {
        if (obj == null) {
            return null;
        }
        do {
            r rVar = this.f;
            r rVar2 = this.g;
            int i2 = this.a;
            if (i2 <= i) {
                if (i2 >= i) {
                    Object obj2 = this.b;
                    if (obj2 == obj || (obj2 != null && obj.equals(obj2))) {
                        return this;
                    }
                    if (rVar != null) {
                        if (rVar2 != null) {
                            if (cls != null || (cls = ConcurrentHashMap.c(obj)) != null) {
                                int i3 = ConcurrentHashMap.g;
                                int iCompareTo = (obj2 == null || obj2.getClass() != cls) ? 0 : ((Comparable) obj).compareTo(obj2);
                                if (iCompareTo == 0) {
                                    r rVarB = rVar2.b(i, obj, cls);
                                    if (rVarB != null) {
                                        return rVarB;
                                    }
                                } else if (iCompareTo >= 0) {
                                    rVar = rVar2;
                                }
                            }
                        }
                        this = rVar;
                    }
                }
                this = rVar2;
            } else {
                this = rVar;
            }
        } while (this != null);
        return null;
    }
}

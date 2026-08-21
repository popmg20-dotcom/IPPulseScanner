package io.netty.util;

import defpackage.dw2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class IllegalReferenceCountException extends IllegalStateException {
    private static final long serialVersionUID = -2507492394288153468L;

    /* JADX WARN: Illegal instructions before constructor call */
    public IllegalReferenceCountException(int i, int i2) {
        String strA;
        StringBuilder sbD = dw2.D("refCnt: ", i, ", ");
        if (i2 > 0) {
            strA = dw2.A(i2, "increment: ");
        } else {
            strA = "decrement: " + (-i2);
        }
        sbD.append(strA);
        this(sbD.toString());
    }

    public IllegalReferenceCountException(int i) {
        this(dw2.A(i, "refCnt: "));
    }

    public IllegalReferenceCountException() {
    }

    public IllegalReferenceCountException(String str) {
        super(str);
    }

    public IllegalReferenceCountException(String str, Throwable th) {
        super(str, th);
    }

    public IllegalReferenceCountException(Throwable th) {
        super(th);
    }
}

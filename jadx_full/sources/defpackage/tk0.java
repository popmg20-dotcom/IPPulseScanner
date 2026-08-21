package defpackage;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tk0 extends b10 {
    public final Set d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tk0(bt3 bt3Var, w8 w8Var) {
        super(bt3Var, null);
        String[] strArr = null;
        Class cls = w8Var.C0;
        RuntimeException runtimeException = n22.e;
        if (runtimeException != null) {
            throw runtimeException;
        }
        n22 n22Var = n22.d;
        Object[] objArrA = n22Var.a(cls);
        if (objArrA != null) {
            String[] strArr2 = new String[objArrA.length];
            for (int i = 0; i < objArrA.length; i++) {
                try {
                    strArr2[i] = (String) n22Var.b.invoke(objArrA[i], null);
                } catch (Exception e) {
                    throw new IllegalArgumentException(String.format("Failed to access name of field #%d (of %d) of Record type %s", Integer.valueOf(i), Integer.valueOf(objArrA.length), n50.t(cls)), e);
                }
            }
            strArr = strArr2;
        }
        this.d = strArr == null ? Collections.EMPTY_SET : new HashSet(Arrays.asList(strArr));
    }

    @Override // defpackage.b10
    public final String d(d9 d9Var, String str) {
        return this.d.contains(str) ? str : super.d(d9Var, str);
    }
}

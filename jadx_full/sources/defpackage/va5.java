package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class va5 {
    protected int zza;

    public final byte[] a() {
        try {
            dc5 dc5Var = (dc5) this;
            int i = dc5Var.i();
            byte[] bArr = new byte[i];
            kb5 kb5Var = new kb5(bArr, i);
            dc5Var.c(kb5Var);
            if (i - kb5Var.d == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            String name = getClass().getName();
            zo2.o(fw.z(new StringBuilder(name.length() + 72), "Serializing ", name, " to a byte array threw an IOException (should never happen)."), e);
            return null;
        }
    }

    public abstract int b(sd5 sd5Var);
}

package defpackage;

import java.io.DataInputStream;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class sl4 {
    public final int[] a;

    public sl4(DataInputStream dataInputStream) {
        int i = dataInputStream.readInt() & 7;
        this.a = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.a[i2] = dataInputStream.readInt();
        }
    }
}

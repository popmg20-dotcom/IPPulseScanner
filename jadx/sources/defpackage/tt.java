package defpackage;

import android.graphics.Bitmap;
import java.lang.reflect.Array;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tt {
    public final /* synthetic */ int a;
    public int b;
    public int c;
    public Object d;

    public tt(int i, int i2, int i3) {
        this.a = i3;
        switch (i3) {
            case 2:
                this.d = null;
                this.b = i;
                int i4 = i2 & 7;
                this.c = i4 == 0 ? 8 : i4;
                break;
            default:
                this.d = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i2, i);
                this.b = i;
                this.c = i2;
                break;
        }
    }

    public void a(tt ttVar) {
        tt[] ttVarArr = (tt[]) this.d;
        if (ttVarArr == null) {
            ttVarArr = new tt[8];
            this.d = ttVarArr;
        } else if (this.c >= ttVarArr.length) {
            tt[] ttVarArr2 = new tt[ttVarArr.length << 1];
            System.arraycopy(ttVarArr, 0, ttVarArr2, 0, ttVarArr.length);
            this.d = ttVarArr2;
            ttVarArr = ttVarArr2;
        }
        int i = this.c;
        ttVarArr[i] = ttVar;
        this.c = i + 1;
    }

    public tt b() {
        tt ttVar = new tt(1);
        for (int i = 0; i < this.c; i++) {
            ttVar.a(((tt[]) this.d)[i].b());
        }
        return ttVar;
    }

    public byte c(int i, int i2) {
        return ((byte[][]) this.d)[i2][i];
    }

    public void d(int i, int i2, int i3) {
        ((byte[][]) this.d)[i2][i] = (byte) i3;
    }

    public String toString() {
        switch (this.a) {
            case 0:
                int i = this.b;
                int i2 = this.c;
                StringBuilder sb = new StringBuilder((i * 2 * i2) + 2);
                for (int i3 = 0; i3 < i2; i3++) {
                    byte[] bArr = ((byte[][]) this.d)[i3];
                    for (int i4 = 0; i4 < i; i4++) {
                        byte b = bArr[i4];
                        if (b == 0) {
                            sb.append(" 0");
                        } else if (b != 1) {
                            sb.append("  ");
                        } else {
                            sb.append(" 1");
                        }
                    }
                    sb.append('\n');
                }
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public tt(int i) {
        this.a = i;
        switch (i) {
            case 2:
                this.d = new tt[256];
                this.b = 0;
                this.c = 0;
                break;
            default:
                this.b = -1;
                break;
        }
    }

    public tt(Bitmap bitmap, int i, int i2) {
        this.a = 3;
        bitmap.getClass();
        this.d = bitmap;
        this.b = i;
        this.c = i2;
    }
}

package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class o70 {
    public final q70 a;
    public final p70 b;
    public final r70 c;
    public final r70 d;
    public final lw2 e;

    public o70(p70 p70Var, List list) {
        String[] strArr;
        int i;
        this.b = p70Var;
        if (list.isEmpty()) {
            strArr = new String[0];
        } else {
            int i2 = ((n70) list.get(0)).b;
            strArr = new String[i2];
            int i3 = 0;
            while (true) {
                i = i2 - 1;
                if (i3 >= i) {
                    break;
                }
                StringBuilder sb = new StringBuilder("?");
                int i4 = i3 + 1;
                sb.append(i4);
                strArr[i3] = sb.toString();
                i3 = i4;
            }
            strArr[i] = "color";
        }
        this.c = new r70(false, strArr);
        String[] strArr2 = new String[list.size()];
        for (int i5 = 0; i5 < list.size(); i5++) {
            strArr2[i5] = ((n70) list.get(i5)).d;
        }
        this.d = new r70(true, strArr2);
        this.e = new lw2(list);
        this.a = new q70((short) 512, (short) 288, a());
    }

    public final int a() {
        int i = this.c.l + 288 + this.d.l;
        lw2 lw2Var = this.e;
        int i2 = (lw2Var.b * 4) + 16;
        j40 j40Var = (j40) lw2Var.e;
        return (((hm2[]) j40Var.f).length * 16) + (((int[]) j40Var.e).length * 4) + 84 + i2 + i;
    }
}

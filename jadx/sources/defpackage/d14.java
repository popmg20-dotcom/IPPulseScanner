package defpackage;

import defpackage.y04;
import defpackage.z04;
import java.sql.Date;
import java.sql.Timestamp;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class d14 {
    public static final boolean a;
    public static final y04.a b;
    public static final z04.a c;
    public static final a14 d;

    static {
        boolean z;
        try {
            Class.forName("java.sql.Date");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        a = z;
        if (!z) {
            b = null;
            c = null;
            d = null;
        } else {
            new c14(Date.class, 0);
            new c14(Timestamp.class, 1);
            b = y04.b;
            c = z04.b;
            d = b14.b;
        }
    }
}

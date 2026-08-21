package defpackage;

import androidx.recyclerview.widget.RecyclerView;
import java.io.File;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class x10 extends r82 implements am1 {
    public static final x10 A;
    public static final x10 X;
    public static final x10 Y;
    public static final x10 Z;
    public static final x10 z;
    public final /* synthetic */ int f;

    static {
        int i = 1;
        z = new x10(i, 0);
        A = new x10(i, 1);
        X = new x10(i, 2);
        Y = new x10(i, 3);
        Z = new x10(i, 4);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ x10(int i, int i2) {
        super(i);
        this.f = i2;
    }

    @Override // defpackage.am1
    public final Object g(Object obj) {
        String strValueOf;
        int i = this.f;
        xl4 xl4Var = xl4.a;
        switch (i) {
            case 0:
                ((RecyclerView) obj).getClass();
                return xl4Var;
            case 1:
                ((pk2) obj).getClass();
                return xl4Var;
            case 2:
                ((tk2) obj).getClass();
                return xl4Var;
            case 3:
                File file = (File) obj;
                file.getClass();
                String absolutePath = file.getCanonicalFile().getAbsolutePath();
                absolutePath.getClass();
                return new nx3(absolutePath);
            default:
                Map.Entry entry = (Map.Entry) obj;
                entry.getClass();
                Object value = entry.getValue();
                if (value instanceof byte[]) {
                    StringBuilder sb = new StringBuilder();
                    sb.append((CharSequence) "[");
                    int i2 = 0;
                    for (byte b : (byte[]) value) {
                        i2++;
                        if (i2 > 1) {
                            sb.append((CharSequence) ", ");
                        }
                        sb.append((CharSequence) String.valueOf((int) b));
                    }
                    sb.append((CharSequence) "]");
                    strValueOf = sb.toString();
                } else {
                    strValueOf = String.valueOf(entry.getValue());
                }
                return fw.z(new StringBuilder("  "), ((u33) entry.getKey()).a, " = ", strValueOf);
        }
    }
}

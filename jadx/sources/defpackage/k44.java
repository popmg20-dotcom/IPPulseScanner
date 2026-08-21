package defpackage;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class k44 extends aj3 {
    public final Object E0;
    public pk3 F0;

    public k44(String str, pk3 pk3Var, pk3 pk3Var2) {
        super(str, pk3Var2);
        this.E0 = new Object();
        this.F0 = pk3Var;
    }

    @Override // defpackage.aj3
    public final void b() {
        super.b();
        synchronized (this.E0) {
            this.F0 = null;
        }
    }

    @Override // defpackage.aj3
    public final void c(Object obj) {
        pk3 pk3Var;
        String str = (String) obj;
        synchronized (this.E0) {
            pk3Var = this.F0;
        }
        if (pk3Var != null) {
            pk3Var.p(str);
        }
    }

    @Override // defpackage.aj3
    public ue1 j(jr2 jr2Var) {
        String str;
        byte[] bArr = (byte[]) jr2Var.c;
        try {
            str = new String(bArr, ji0.H("ISO-8859-1", (Map) jr2Var.d));
        } catch (UnsupportedEncodingException unused) {
            str = new String(bArr);
        }
        return new ue1(str, ji0.G(jr2Var));
    }
}

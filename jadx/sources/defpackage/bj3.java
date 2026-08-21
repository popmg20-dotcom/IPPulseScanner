package defpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class bj3 extends ej3 {
    public final /* synthetic */ pj2 b;
    public final /* synthetic */ File c;

    public bj3(pj2 pj2Var, File file) {
        this.b = pj2Var;
        this.c = file;
    }

    @Override // defpackage.ej3
    public final long a() {
        return this.c.length();
    }

    @Override // defpackage.ej3
    public final pj2 b() {
        return this.b;
    }

    @Override // defpackage.ej3
    public final void c(bq bqVar) throws IOException {
        q02 q02Var = new q02(new FileInputStream(this.c), de4.d);
        try {
            bqVar.A(q02Var);
            q02Var.close();
        } finally {
        }
    }
}

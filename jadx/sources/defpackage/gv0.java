package defpackage;

import io.netty.handler.codec.http.multipart.DiskFileUpload;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gv0 {
    public final String a;
    public final long[] b = new long[2];
    public final ArrayList c = new ArrayList(2);
    public final ArrayList d = new ArrayList(2);
    public boolean e;
    public boolean f;
    public ue1 g;
    public int h;
    public final /* synthetic */ jv0 i;

    public gv0(jv0 jv0Var, String str) {
        this.i = jv0Var;
        this.a = str;
        StringBuilder sb = new StringBuilder(str);
        sb.append('.');
        int length = sb.length();
        for (int i = 0; i < 2; i++) {
            sb.append(i);
            this.c.add(this.i.b.d(sb.toString()));
            sb.append(DiskFileUpload.postfix);
            this.d.add(this.i.b.d(sb.toString()));
            sb.setLength(length);
        }
    }

    public final hv0 a() {
        if (!this.e || this.g != null || this.f) {
            return null;
        }
        ArrayList arrayList = this.c;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            jv0 jv0Var = this.i;
            if (i >= size) {
                this.h++;
                return new hv0(jv0Var, this);
            }
            if (!jv0Var.G0.F((u03) arrayList.get(i))) {
                try {
                    jv0Var.Q(this);
                } catch (IOException unused) {
                }
                return null;
            }
            i++;
        }
    }
}

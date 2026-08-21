package defpackage;

import io.sentry.d1;
import io.sentry.h4;
import java.io.ByteArrayInputStream;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class bd0 implements st2, yd3, h4 {
    public final /* synthetic */ int b;
    public final /* synthetic */ String f;

    public /* synthetic */ bd0(String str, int i) {
        this.b = i;
        this.f = str;
    }

    @Override // defpackage.st2
    public Object a() {
        int i = this.b;
        String str = this.f;
        switch (i) {
            case 0:
                throw new l52(str);
            case 1:
                throw new l52(str);
            default:
                throw new l52(str);
        }
    }

    @Override // io.sentry.h4
    public void m(d1 d1Var) {
        int i = this.b;
        String str = this.f;
        switch (i) {
            case 4:
                d1Var.u(str);
                break;
            default:
                d1Var.getClass();
                d1Var.u(str);
                break;
        }
    }

    @Override // defpackage.yd3
    public ByteArrayInputStream read() {
        byte[] bytes = this.f.getBytes(y30.a);
        bytes.getClass();
        return new ByteArrayInputStream(bytes);
    }
}

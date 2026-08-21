package defpackage;

import android.text.TextUtils;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ip4 extends cg2 {
    public final /* synthetic */ int X;

    public ip4(int i, Class cls, int i2, int i3, int i4) {
        this.X = i4;
        this.b = i;
        this.A = cls;
        this.z = i2;
        this.f = i3;
    }

    @Override // defpackage.cg2
    public final Object c(View view) {
        switch (this.X) {
            case 0:
                return Boolean.valueOf(qp4.c(view));
            case 1:
                return qp4.a(view);
            case 2:
                return sp4.b(view);
            default:
                return Boolean.valueOf(qp4.b(view));
        }
    }

    @Override // defpackage.cg2
    public final void d(View view, Object obj) {
        switch (this.X) {
            case 0:
                qp4.f(view, ((Boolean) obj).booleanValue());
                break;
            case 1:
                qp4.e(view, (CharSequence) obj);
                break;
            case 2:
                sp4.c(view, (CharSequence) obj);
                break;
            default:
                qp4.d(view, ((Boolean) obj).booleanValue());
                break;
        }
    }

    @Override // defpackage.cg2
    public final boolean g(Object obj, Object obj2) {
        boolean zEquals;
        switch (this.X) {
            case 0:
                Boolean bool = (Boolean) obj;
                Boolean bool2 = (Boolean) obj2;
                return !((bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue()));
            case 1:
                zEquals = TextUtils.equals((CharSequence) obj, (CharSequence) obj2);
                break;
            case 2:
                zEquals = TextUtils.equals((CharSequence) obj, (CharSequence) obj2);
                break;
            default:
                Boolean bool3 = (Boolean) obj;
                Boolean bool4 = (Boolean) obj2;
                return !((bool3 != null && bool3.booleanValue()) == (bool4 != null && bool4.booleanValue()));
        }
        return !zEquals;
    }
}

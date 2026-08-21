package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class w4 extends r4 {
    public final /* synthetic */ int a;
    public final /* synthetic */ x4 b;
    public final /* synthetic */ String c;
    public final /* synthetic */ m4 d;

    public /* synthetic */ w4(x4 x4Var, String str, m4 m4Var, int i) {
        this.a = i;
        this.b = x4Var;
        this.c = str;
        this.d = m4Var;
    }

    @Override // defpackage.r4
    public final void a(Object obj) {
        int i = this.a;
        m4 m4Var = this.d;
        String str = this.c;
        x4 x4Var = this.b;
        switch (i) {
            case 0:
                ArrayList arrayList = x4Var.d;
                Object obj2 = x4Var.b.get(str);
                if (obj2 == null) {
                    s53.n("Attempting to launch an unregistered ActivityResultLauncher with contract ", m4Var, " and input ", obj, ". You must ensure the ActivityResultLauncher is registered before calling launch().");
                    return;
                }
                int iIntValue = ((Number) obj2).intValue();
                arrayList.add(str);
                try {
                    x4Var.b(iIntValue, m4Var, obj);
                    return;
                } catch (Exception e) {
                    arrayList.remove(str);
                    throw e;
                }
            default:
                ArrayList arrayList2 = x4Var.d;
                Object obj3 = x4Var.b.get(str);
                if (obj3 == null) {
                    s53.n("Attempting to launch an unregistered ActivityResultLauncher with contract ", m4Var, " and input ", obj, ". You must ensure the ActivityResultLauncher is registered before calling launch().");
                    return;
                }
                int iIntValue2 = ((Number) obj3).intValue();
                arrayList2.add(str);
                try {
                    x4Var.b(iIntValue2, m4Var, obj);
                    return;
                } catch (Exception e2) {
                    arrayList2.remove(str);
                    throw e2;
                }
        }
    }

    public void b() {
        this.b.f(this.c);
    }
}

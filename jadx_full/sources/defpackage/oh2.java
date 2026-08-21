package defpackage;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class oh2 implements nh2 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ oh2(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // defpackage.nh2
    public final boolean a(Object obj) {
        int i = this.a;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                Iterator it = ((ArrayList) obj2).iterator();
                while (it.hasNext()) {
                    if (!((nh2) it.next()).a(obj)) {
                        break;
                    }
                }
                break;
            case 1:
                Iterator it2 = ((ArrayList) obj2).iterator();
                while (it2.hasNext()) {
                    if (((nh2) it2.next()).a(obj)) {
                        break;
                    }
                }
                break;
            default:
                nh2 nh2Var = (nh2) obj2;
                if (nh2Var != null && !nh2Var.a(obj)) {
                    break;
                }
                break;
        }
        return true;
    }
}

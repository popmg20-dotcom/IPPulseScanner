package defpackage;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class zv implements Runnable {
    public final /* synthetic */ int b;
    public final int f;
    public final Object z;

    public zv(List list, int i, Throwable th) {
        this.b = 1;
        r25.i(list, "initCallbacks cannot be null");
        this.z = new ArrayList(list);
        this.f = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        int i2 = this.f;
        Object obj = this.z;
        switch (i) {
            case 0:
                ji0 ji0Var = (ji0) ((ub4) obj).b;
                if (ji0Var != null) {
                    ji0Var.E(i2);
                }
                break;
            case 1:
                ArrayList arrayList = (ArrayList) obj;
                int size = arrayList.size();
                int i3 = 0;
                if (i2 == 1) {
                    while (i3 < size) {
                        ((i31) arrayList.get(i3)).b();
                        i3++;
                    }
                } else {
                    while (i3 < size) {
                        ((i31) arrayList.get(i3)).a();
                        i3++;
                    }
                }
                break;
            case 2:
                ((ip2) obj).j(i2);
                break;
            case 3:
                ((RecyclerView) obj).o0(i2);
                break;
            default:
                ((sz4) obj).i(i2);
                break;
        }
    }

    public zv(int i, yq4 yq4Var) {
        this.b = 3;
        this.f = i;
        this.z = yq4Var;
    }

    public /* synthetic */ zv(int i, int i2, Object obj) {
        this.b = i2;
        this.z = obj;
        this.f = i;
    }
}

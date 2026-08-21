package defpackage;

import android.app.Activity;
import android.content.Intent;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l21 implements am1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ Set f;

    public /* synthetic */ l21(Set set, int i) {
        this.b = i;
        this.f = set;
    }

    @Override // defpackage.am1
    public final Object g(Object obj) {
        int i = this.b;
        boolean z = true;
        Set set = this.f;
        switch (i) {
            case 0:
                Intent intent = (Intent) obj;
                intent.getClass();
                if (set.isEmpty()) {
                    z = false;
                } else {
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        if (((g4) it.next()).b(intent)) {
                        }
                    }
                    z = false;
                }
                return Boolean.valueOf(z);
            default:
                Activity activity = (Activity) obj;
                activity.getClass();
                if (set.isEmpty()) {
                    z = false;
                } else {
                    Iterator it2 = set.iterator();
                    while (it2.hasNext()) {
                        if (((g4) it2.next()).a(activity)) {
                        }
                    }
                    z = false;
                }
                return Boolean.valueOf(z);
        }
    }
}

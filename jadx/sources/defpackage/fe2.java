package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fe2 extends ArrayList implements e93 {
    @Override // defpackage.e93
    public void a(Object obj, String str) {
        int i = Integer.parseInt(str);
        if (i == size()) {
            add(obj);
        } else {
            set(i, obj);
        }
    }
}

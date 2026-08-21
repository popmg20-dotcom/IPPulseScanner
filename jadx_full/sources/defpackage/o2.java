package defpackage;

import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class o2 {
    public final Object a;

    public /* synthetic */ o2(Object obj) {
        this.a = obj;
    }

    public static o2 a(int i, int i2, int i3, boolean z, int i4, boolean z2) {
        return new o2(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2));
    }
}

package defpackage;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class x01 {
    public final Context a;
    public String b = "";
    public boolean c = true;
    public int d;
    public w01 e;

    public x01(Context context) {
        this.a = context;
    }

    public final void a(int i) {
        String string = this.a.getString(i);
        string.getClass();
        this.b = string;
    }
}

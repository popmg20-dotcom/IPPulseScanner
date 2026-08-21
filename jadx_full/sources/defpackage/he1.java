package defpackage;

import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class he1 implements FilenameFilter {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;

    public /* synthetic */ he1(String str, int i) {
        this.a = i;
        this.b = str;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        int i = this.a;
        String str2 = this.b;
        switch (i) {
            case 0:
                return str.startsWith(str2.concat("."));
            default:
                return str.startsWith(str2);
        }
    }
}

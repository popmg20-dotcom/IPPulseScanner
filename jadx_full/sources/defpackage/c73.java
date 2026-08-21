package defpackage;

import com.getsurfboard.ui.provider.ProfilesProvider;
import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c73 implements FilenameFilter {
    public final /* synthetic */ int a;

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        switch (this.a) {
            case 0:
                if (str != null) {
                    return w44.d0(str, ".conf", false);
                }
                return false;
            case 1:
                int i = ProfilesProvider.z;
                if (str != null) {
                    return w44.d0(str, ".conf", false);
                }
                return false;
            case 2:
                int i2 = ProfilesProvider.z;
                if (str != null) {
                    return w44.d0(str, ".conf", false);
                }
                return false;
            case 3:
                int i3 = ProfilesProvider.z;
                if (str != null) {
                    return w44.d0(str, ".conf", false);
                }
                return false;
            case 4:
                if (str != null) {
                    return w44.d0(str, ".conf", false);
                }
                return false;
            default:
                return str.endsWith(".envelope");
        }
    }
}

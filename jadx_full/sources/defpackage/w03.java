package defpackage;

import j$.util.Objects;
import java.nio.file.Path;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class w03 implements Comparator {
    public final /* synthetic */ int b;

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        Path path = (Path) obj;
        Path path2 = (Path) obj2;
        switch (this.b) {
            case 0:
                if (path == path2) {
                    return 0;
                }
                if (path != null) {
                    if (path2 != null) {
                        String string = Objects.toString(path.getFileName(), null);
                        String string2 = Objects.toString(path2.getFileName(), null);
                        if (string == string2) {
                            return 0;
                        }
                        if (string != null) {
                            if (string2 != null) {
                                return string.compareToIgnoreCase(string2);
                            }
                        }
                    }
                    return -1;
                }
                return 1;
            default:
                if (path == path2) {
                    return 0;
                }
                if (path != null) {
                    if (path2 != null) {
                        String string3 = Objects.toString(path.getFileName(), null);
                        String string4 = Objects.toString(path2.getFileName(), null);
                        if (string3 == string4) {
                            return 0;
                        }
                        if (string3 != null) {
                            if (string4 != null) {
                                return string3.compareTo(string4);
                            }
                        }
                    }
                    return -1;
                }
                return 1;
        }
    }
}

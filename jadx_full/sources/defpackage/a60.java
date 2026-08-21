package defpackage;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class a60 extends IOException {
    public a60(File file, File file2, String str) {
        StringBuilder sb = new StringBuilder(file.toString());
        if (file2 != null) {
            sb.append(" -> " + file2);
        }
        sb.append(": ".concat(str));
        super(sb.toString());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public a60(long j, long j2, int i, IndexOutOfBoundsException indexOutOfBoundsException) {
        Locale locale = Locale.US;
        StringBuilder sbC = fw.C("Pos: ", ", limit: ", j);
        sbC.append(j2);
        sbC.append(", len: ");
        sbC.append(i);
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(sbC.toString()), indexOutOfBoundsException);
    }

    public /* synthetic */ a60(IndexOutOfBoundsException indexOutOfBoundsException) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", indexOutOfBoundsException);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public a60(int i, int i2, int i3, IndexOutOfBoundsException indexOutOfBoundsException) {
        Locale locale = Locale.US;
        StringBuilder sbC = fw.C("Pos: ", ", limit: ", i);
        sbC.append(i2);
        sbC.append(", len: ");
        sbC.append(i3);
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(sbC.toString()), indexOutOfBoundsException);
    }
}

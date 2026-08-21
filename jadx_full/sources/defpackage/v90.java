package defpackage;

import j$.util.Objects;
import j$.util.Optional;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class v90 extends hy4 {
    public final Optional A;
    public final String b;
    public final Optional f;
    public final String z;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public v90(int i, String str, Optional optional) {
        this("", Optional.empty(), str, optional, null);
        switch (i) {
            case 2:
                this(null, Optional.empty(), str, optional, null);
                break;
            case 3:
                this(null, Optional.empty(), str, optional, null);
                break;
            default:
                break;
        }
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return toString();
    }

    @Override // java.lang.Throwable
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        String str = this.b;
        if (str != null) {
            sb.append(str);
            sb.append("\n");
        }
        Optional optional = this.f;
        boolean zIsPresent = optional.isPresent();
        String str2 = this.z;
        Optional optional2 = this.A;
        if (zIsPresent) {
            if (str2 != null && !optional2.isEmpty()) {
                ((gh2) optional.get()).getClass();
                ((gh2) optional2.get()).getClass();
            }
            sb.append(optional.get());
            sb.append("\n");
        }
        if (str2 != null) {
            sb.append(str2);
            sb.append("\n");
        }
        if (optional2.isPresent()) {
            sb.append(optional2.get());
            sb.append("\n");
        }
        return sb.toString();
    }

    public v90(String str, Optional optional, String str2, Optional optional2, Exception exc) {
        super(str + "; " + str2 + "; " + optional2, exc);
        Objects.requireNonNull(optional, "contextMark must be provided");
        Objects.requireNonNull(optional2, "problemMark must be provided");
        this.b = str;
        this.f = optional;
        this.z = str2;
        this.A = optional2;
    }
}

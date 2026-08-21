package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class g7 extends es2 {
    public final int a;
    public final boolean b;
    public es2 c;
    public int d;

    public g7(int i, boolean z) {
        super(7);
        this.a = i;
        this.d = -1;
        this.b = z;
    }

    public final boolean a(int i) {
        return (this.a & i) != 0;
    }

    @Override // defpackage.es2
    public final String getName() {
        return "Anchor";
    }

    @Override // defpackage.es2
    public final void setChild(es2 es2Var) {
        this.c = es2Var;
    }

    @Override // defpackage.es2
    public final String toString(int i) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder("\n  type: ");
        StringBuilder sb3 = new StringBuilder();
        if (a(1)) {
            sb3.append("BEGIN_BUF ");
        }
        if (a(2)) {
            sb3.append("BEGIN_LINE ");
        }
        if (a(4)) {
            sb3.append("BEGIN_POSITION ");
        }
        if (a(8)) {
            sb3.append("END_BUF ");
        }
        if (a(16)) {
            sb3.append("SEMI_END_BUF ");
        }
        if (a(32)) {
            sb3.append("END_LINE ");
        }
        if (a(64)) {
            sb3.append("WORD_BOUND ");
        }
        if (a(128)) {
            sb3.append("NOT_WORD_BOUND ");
        }
        if (a(256)) {
            sb3.append("WORD_BEGIN ");
        }
        if (a(512)) {
            sb3.append("WORD_END ");
        }
        if (a(1024)) {
            sb3.append("PREC_READ ");
        }
        if (a(2048)) {
            sb3.append("PREC_READ_NOT ");
        }
        if (a(4096)) {
            sb3.append("LOOK_BEHIND ");
        }
        if (a(8192)) {
            sb3.append("LOOK_BEHIND_NOT ");
        }
        if (a(16384)) {
            sb3.append("ANYCHAR_STAR ");
        }
        if (a(32768)) {
            sb3.append("ANYCHAR_STAR_ML ");
        }
        sb2.append(sb3.toString());
        sb.append(sb2.toString());
        sb.append(", ascii: " + this.b);
        sb.append("\n  target: " + es2.pad(this.c, 1));
        return sb.toString();
    }
}

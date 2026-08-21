package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class es2 {
    public es2 parent;
    protected int type;

    public es2(int i) {
        this.type = i;
    }

    public static cs2 newTop(es2 es2Var) {
        cs2 cs2Var = new cs2(-1);
        es2Var.parent = cs2Var;
        cs2Var.a = es2Var;
        return cs2Var;
    }

    public static String pad(Object obj, int i) {
        if (obj == null) {
            return "NULL";
        }
        StringBuilder sb = new StringBuilder("  ");
        for (int i2 = 0; i2 < i; i2++) {
            sb.append((CharSequence) sb);
        }
        return obj.toString().replace("\n", "\n" + ((Object) sb));
    }

    public String getAddressName() {
        return getName() + ":0x" + Integer.toHexString(System.identityHashCode(this));
    }

    public abstract String getName();

    public final int getType() {
        return this.type;
    }

    public final int getType2Bit() {
        return 1 << getType();
    }

    public final boolean isSimple() {
        return (getType2Bit() & 31) != 0;
    }

    public void replaceWith(es2 es2Var) {
        es2Var.parent = this.parent;
        this.parent.setChild(es2Var);
        this.parent = null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(getAddressName());
        sb.append(" (");
        es2 es2Var = this.parent;
        return fw.y(sb, es2Var == null ? "NULL" : es2Var.getAddressName(), ")>") + toString(0);
    }

    public abstract String toString(int i);

    public void setChild(es2 es2Var) {
    }
}

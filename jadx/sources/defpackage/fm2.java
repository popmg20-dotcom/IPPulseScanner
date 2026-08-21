package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class fm2 {
    public final int a;
    public final int b;

    public fm2(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public void a(gl1 gl1Var) {
        gl1Var.getClass();
        throw new ss2("Migration functionality with a SupportSQLiteDatabase (without a provided SQLiteDriver) requires overriding the migrate(SupportSQLiteDatabase) function.");
    }

    public void b(go3 go3Var) {
        go3Var.getClass();
        if (!(go3Var instanceof c64)) {
            throw new ss2("Migration functionality with a provided SQLiteDriver requires overriding the migrate(SQLiteConnection) function.");
        }
        a(((c64) go3Var).b);
    }
}

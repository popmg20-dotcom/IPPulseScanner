package j$.util.stream;

import java.util.concurrent.CountedCompleter;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public class s3 extends CountedCompleter {
    public final e2 a;
    public final int b;
    public final /* synthetic */ int c;
    public final Object d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public s3(s3 s3Var, e2 e2Var, int i) {
        this(s3Var, e2Var, i, (byte) 0);
        this.c = 1;
        this.d = (Object[]) s3Var.d;
    }

    public final s3 a(int i, int i2) {
        switch (this.c) {
            case 0:
                return new s3(this, ((d2) this.a).a(i), i2);
            default:
                return new s3(this, this.a.a(i), i2);
        }
    }

    @Override // java.util.concurrent.CountedCompleter
    public final void compute() {
        int i;
        while (this.a.o() != 0) {
            this.setPendingCount(this.a.o() - 1);
            int i2 = 0;
            int iCount = 0;
            while (true) {
                int iO = this.a.o() - 1;
                i = this.b;
                if (i2 < iO) {
                    s3 s3VarA = this.a(i2, i + iCount);
                    iCount = (int) (s3VarA.a.count() + ((long) iCount));
                    s3VarA.fork();
                    i2++;
                }
            }
            this = this.a(i2, i + iCount);
        }
        switch (this.c) {
            case 0:
                ((d2) this.a).f(this.b, this.d);
                break;
            default:
                this.a.k((Object[]) this.d, this.b);
                break;
        }
        this.propagateCompletion();
    }

    public s3(s3 s3Var, e2 e2Var, int i, byte b) {
        super(s3Var);
        this.a = e2Var;
        this.b = i;
    }

    public s3(e2 e2Var, Object obj, int i) {
        this.c = i;
        this.a = e2Var;
        this.b = 0;
        this.d = obj;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public s3(s3 s3Var, d2 d2Var, int i) {
        this(s3Var, d2Var, i, (byte) 0);
        this.c = 0;
        this.d = s3Var.d;
    }
}

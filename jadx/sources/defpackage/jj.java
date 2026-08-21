package defpackage;

import androidx.fragment.app.o;
import com.getsurfboard.R;
import com.getsurfboard.backup.model.BackupSection;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jj {
    public final o a;
    public final r4 b;

    public jj(o oVar) {
        this.a = oVar;
        r4 r4VarRegisterForActivityResult = oVar.registerForActivityResult(new n4(2), new jd(1, this));
        r4VarRegisterForActivityResult.getClass();
        this.b = r4VarRegisterForActivityResult;
    }

    public static int b(BackupSection backupSection) {
        int i = zi.a[backupSection.ordinal()];
        if (i == 1) {
            return R.string.backup_section_profiles;
        }
        if (i == 2) {
            return R.string.backup_section_settings;
        }
        if (i == 3) {
            return R.string.backup_section_metadata;
        }
        if (i == 4) {
            return R.string.backup_section_hosts;
        }
        g.d();
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(android.net.Uri r12, defpackage.ie0 r13) {
        /*
            Method dump skipped, instruction units count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jj.a(android.net.Uri, ie0):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(android.net.Uri r8, char[] r9, defpackage.ie0 r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof defpackage.ij
            if (r0 == 0) goto L13
            r0 = r10
            ij r0 = (defpackage.ij) r0
            int r1 = r0.Y
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.Y = r1
            goto L18
        L13:
            ij r0 = new ij
            r0.<init>(r7, r10)
        L18:
            java.lang.Object r10 = r0.A
            int r1 = r0.Y
            r2 = 0
            androidx.fragment.app.o r3 = r7.a
            r4 = 1
            vi r5 = defpackage.vi.a
            r6 = 0
            if (r1 == 0) goto L35
            if (r1 != r4) goto L2f
            defpackage.n12.S(r10)     // Catch: java.lang.Exception -> L2b defpackage.nj -> L2d defpackage.ki -> L77 defpackage.oj -> L94
            goto L4c
        L2b:
            r7 = move-exception
            goto L54
        L2d:
            r7 = move-exception
            goto L80
        L2f:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r7)
            return r6
        L35:
            defpackage.n12.S(r10)
            gm0 r10 = defpackage.qv0.a     // Catch: java.lang.Exception -> L2b defpackage.nj -> L2d defpackage.ki -> L77 defpackage.oj -> L94
            pl0 r10 = defpackage.pl0.z     // Catch: java.lang.Exception -> L2b defpackage.nj -> L2d defpackage.ki -> L77 defpackage.oj -> L94
            ej r1 = new ej     // Catch: java.lang.Exception -> L2b defpackage.nj -> L2d defpackage.ki -> L77 defpackage.oj -> L94
            r1.<init>(r7, r8, r9, r6)     // Catch: java.lang.Exception -> L2b defpackage.nj -> L2d defpackage.ki -> L77 defpackage.oj -> L94
            r0.Y = r4     // Catch: java.lang.Exception -> L2b defpackage.nj -> L2d defpackage.ki -> L77 defpackage.oj -> L94
            java.lang.Object r10 = defpackage.ji0.b0(r10, r1, r0)     // Catch: java.lang.Exception -> L2b defpackage.nj -> L2d defpackage.ki -> L77 defpackage.oj -> L94
            mf0 r7 = defpackage.mf0.b
            if (r10 != r7) goto L4c
            return r7
        L4c:
            k03 r10 = (defpackage.k03) r10     // Catch: java.lang.Exception -> L2b defpackage.nj -> L2d defpackage.ki -> L77 defpackage.oj -> L94
            wi r7 = new wi     // Catch: java.lang.Exception -> L2b defpackage.nj -> L2d defpackage.ki -> L77 defpackage.oj -> L94
            r7.<init>(r10)     // Catch: java.lang.Exception -> L2b defpackage.nj -> L2d defpackage.ki -> L77 defpackage.oj -> L94
            return r7
        L54:
            defpackage.xb5.L(r7)
            java.lang.String r8 = r7.getMessage()
            if (r8 != 0) goto L65
            java.lang.Class r7 = r7.getClass()
            java.lang.String r8 = r7.getSimpleName()
        L65:
            java.lang.Object[] r7 = new java.lang.Object[r4]
            r7[r2] = r8
            r8 = 2131951669(0x7f130035, float:1.953976E38)
            java.lang.String r7 = r3.getString(r8, r7)
            r7.getClass()
            defpackage.p95.D(r7)
            goto L96
        L77:
            r7 = 2131951663(0x7f13002f, float:1.9539747E38)
            java.lang.Object[] r8 = new java.lang.Object[r2]
            defpackage.p95.C(r7, r8)
            goto L96
        L80:
            java.lang.Object[] r8 = new java.lang.Object[r4]
            java.lang.String r7 = r7.b
            r8[r2] = r7
            r7 = 2131951683(0x7f130043, float:1.9539787E38)
            java.lang.String r7 = r3.getString(r7, r8)
            r7.getClass()
            defpackage.p95.D(r7)
            goto L96
        L94:
            xi r5 = defpackage.xi.a
        L96:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jj.c(android.net.Uri, char[], ie0):java.lang.Object");
    }
}

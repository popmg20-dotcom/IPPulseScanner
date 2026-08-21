package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class zs2 extends l34 {
    public static final zs2 A = new zs2(0);
    public static final zs2 X = new zs2(1);
    public final /* synthetic */ int z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zs2(int i) {
        super(Object.class);
        this.z = i;
        switch (i) {
            case 1:
                super(w62.class);
                break;
            case 2:
                super(byte[].class);
                break;
            case 3:
                super(Object.class);
                break;
            case 4:
            case 5:
            default:
                break;
            case 6:
                super(char[].class);
                break;
            case 7:
                super(String.class, 0);
                break;
        }
    }

    @Override // defpackage.b72
    public boolean c(gt3 gt3Var, Object obj) {
        switch (this.z) {
            case 1:
                return false;
            case 2:
                return ((byte[]) obj).length == 0;
            case 6:
                return ((char[]) obj).length == 0;
            case 8:
                return true;
            default:
                return super.c(gt3Var, obj);
        }
    }

    @Override // defpackage.b72
    public void e(Object obj, i52 i52Var, gt3 gt3Var) {
        switch (this.z) {
            case 0:
                i52Var.U();
                return;
            case 1:
                i52Var.G0(((nj4) ((w62) obj)).V());
                return;
            case 2:
                byte[] bArr = (byte[]) obj;
                i52Var.C(gt3Var.b.f.Z, bArr, 0, bArr.length);
                return;
            case 3:
                gt3Var.getClass();
                throw new a62(((hm0) gt3Var).F0, "Null key for a Map not allowed in JSON (use a converting NullKeySerializer?)", null);
            case 4:
                Map.Entry entry = (Map.Entry) obj;
                i52Var.z0(entry);
                gt3Var.g("key", entry.getKey(), i52Var);
                gt3Var.g("value", entry.getValue(), i52Var);
                i52Var.M();
                return;
            case 5:
                String string = obj.toString();
                eo1 eo1Var = (eo1) i52Var;
                eo1Var.L0("write raw value");
                eo1Var.n0(string);
                return;
            case 6:
                char[] cArr = (char[]) obj;
                if (!gt3Var.b.h(dt3.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS)) {
                    i52Var.H0(cArr, 0, cArr.length);
                    return;
                }
                int length = cArr.length;
                i52Var.r0(cArr);
                int length2 = cArr.length;
                for (int i = 0; i < length2; i++) {
                    i52Var.H0(cArr, i, 1);
                }
                i52Var.I();
                return;
            case 7:
                i52Var.Q((String) obj);
                return;
            default:
                ((dy4) i52Var).z0(obj);
                i52Var.M();
                return;
        }
    }

    @Override // defpackage.b72
    public void f(Object obj, i52 i52Var, gt3 gt3Var, zj4 zj4Var) {
        e10 e10VarE;
        switch (this.z) {
            case 0:
                i52Var.U();
                break;
            case 1:
                nj4 nj4Var = (nj4) ((w62) obj);
                nj4Var.getClass();
                e10 e10Var = new e10(nj4Var, g72.Z);
                zj4Var.e(i52Var, e10Var);
                i52Var.G0(nj4Var.V());
                zj4Var.f(i52Var, e10Var);
                break;
            case 2:
                byte[] bArr = (byte[]) obj;
                e10 e10VarE2 = zj4Var.e(i52Var, zj4Var.d(bArr, g72.Y));
                i52Var.C(gt3Var.b.f.Z, bArr, 0, bArr.length);
                zj4Var.f(i52Var, e10VarE2);
                break;
            case 3:
            case 4:
            case 7:
            default:
                super.f(obj, i52Var, gt3Var, zj4Var);
                break;
            case 5:
                e10 e10VarE3 = zj4Var.e(i52Var, zj4Var.d(obj, g72.Y));
                e(obj, i52Var, gt3Var);
                zj4Var.f(i52Var, e10VarE3);
                break;
            case 6:
                char[] cArr = (char[]) obj;
                if (gt3Var.b.h(dt3.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS)) {
                    e10VarE = zj4Var.e(i52Var, zj4Var.d(cArr, g72.X));
                    int length = cArr.length;
                    for (int i = 0; i < length; i++) {
                        i52Var.H0(cArr, i, 1);
                    }
                } else {
                    e10VarE = zj4Var.e(i52Var, zj4Var.d(cArr, g72.Z));
                    i52Var.H0(cArr, 0, cArr.length);
                }
                zj4Var.f(i52Var, e10VarE);
                break;
            case 8:
                zj4Var.f(i52Var, zj4Var.e(i52Var, zj4Var.d(obj, g72.A)));
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ zs2(nj4 nj4Var, int i) {
        super(nj4Var);
        this.z = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ zs2(int i, int i2, Class cls) {
        super(cls, i);
        this.z = i2;
    }
}

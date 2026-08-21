package defpackage;

import com.getsurfboard.vpn.Jni;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class x12 extends mm1 implements am1 {
    public final /* synthetic */ int y0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ x12(int i, Object obj, Class cls, String str, String str2, int i2, int i3) {
        super(i, obj, cls, str, str2, i2);
        this.y0 = i3;
    }

    @Override // defpackage.am1
    public final Object g(Object obj) {
        int i = this.y0;
        xl4 xl4Var = xl4.a;
        Object obj2 = this.f;
        switch (i) {
            case 0:
                Set set = (Set) obj;
                set.getClass();
                y12 y12Var = (y12) obj2;
                ReentrantLock reentrantLock = y12Var.d;
                reentrantLock.lock();
                try {
                    List<iu2> listY0 = d70.y0(y12Var.c.values());
                    reentrantLock.unlock();
                    for (iu2 iu2Var : listY0) {
                        iu2Var.getClass();
                        int[] iArr = iu2Var.b;
                        int length = iArr.length;
                        Set setB = k41.b;
                        if (length != 0) {
                            int i2 = 0;
                            if (length != 1) {
                                cu3 cu3Var = new cu3();
                                int length2 = iArr.length;
                                int i3 = 0;
                                while (i2 < length2) {
                                    int i4 = i3 + 1;
                                    if (set.contains(Integer.valueOf(iArr[i2]))) {
                                        cu3Var.add(iu2Var.c[i3]);
                                    }
                                    i2++;
                                    i3 = i4;
                                }
                                setB = yr2.b(cu3Var);
                            } else if (set.contains(Integer.valueOf(iArr[0]))) {
                                setB = iu2Var.d;
                            }
                        }
                        if (!setB.isEmpty()) {
                            iu2Var.a.a(setB);
                        }
                    }
                    return xl4Var;
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            case 1:
                return ((Jni) obj2).d(((Number) obj).intValue());
            default:
                ((y32) obj2).m((Throwable) obj);
                return xl4Var;
        }
    }
}

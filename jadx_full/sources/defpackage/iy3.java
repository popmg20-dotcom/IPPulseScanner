package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class iy3 extends sk3 implements Function2 {
    public int A;
    public int X;
    public int Y;
    public /* synthetic */ Object Z;
    public Object f;
    public final /* synthetic */ Iterator y0;
    public Iterator z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public iy3(Iterator it, ge0 ge0Var) {
        super(ge0Var);
        this.y0 = it;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        return ((iy3) n((ge0) obj2, (ts3) obj)).p(xl4.a);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        iy3 iy3Var = new iy3(this.y0, ge0Var);
        iy3Var.Z = obj;
        return iy3Var;
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        int i;
        int i2;
        int i3;
        ArrayList arrayList;
        Iterator it;
        int i4;
        int i5;
        int i6;
        il3 il3Var;
        ts3 ts3Var = (ts3) this.Z;
        int i7 = this.Y;
        boolean z = true;
        mf0 mf0Var = mf0.b;
        if (i7 == 0) {
            i = 1;
            n12.S(obj);
            i2 = 0;
            i3 = 0;
            arrayList = new ArrayList(4);
            it = this.y0;
            i4 = 4;
        } else {
            if (i7 != 1) {
                if (i7 != 2) {
                    if (i7 == 3) {
                        i5 = this.X;
                        int i8 = this.A;
                        Iterator it2 = this.z;
                        il3 il3Var2 = (il3) this.f;
                        n12.S(obj);
                        il3Var2.b();
                        while (true) {
                            int i9 = il3Var2.f;
                            Object[] objArr = il3Var2.b;
                            if (!it2.hasNext()) {
                                i6 = i8;
                                il3Var = il3Var2;
                                break;
                            }
                            Object next = it2.next();
                            if (il3Var2.a() == i9) {
                                xe.q("ring buffer is full");
                                return null;
                            }
                            int i10 = il3Var2.z;
                            boolean z2 = z;
                            int i11 = il3Var2.A;
                            objArr[(i10 + i11) % i9] = next;
                            il3Var2.A = i11 + 1;
                            if (il3Var2.a() == i9) {
                                if (il3Var2.A >= 4) {
                                    ArrayList arrayList2 = new ArrayList(il3Var2);
                                    this.Z = ts3Var;
                                    this.f = il3Var2;
                                    this.z = it2;
                                    this.A = i8;
                                    this.X = i5;
                                    this.Y = 3;
                                    ts3Var.b(arrayList2, this);
                                    return mf0Var;
                                }
                                int i12 = i9 + (i9 >> 1) + 1;
                                if (i12 > 4) {
                                    i12 = 4;
                                }
                                il3Var2 = new il3(il3Var2.A, il3Var2.z == 0 ? Arrays.copyOf(objArr, i12) : il3Var2.toArray(new Object[i12]));
                            }
                            z = z2;
                        }
                    } else if (i7 == 4) {
                        i5 = this.X;
                        i6 = this.A;
                        il3Var = (il3) this.f;
                        n12.S(obj);
                        il3Var.b();
                    } else {
                        if (i7 != 5) {
                            xe.q("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                    }
                    if (il3Var.A > 4) {
                        ArrayList arrayList3 = new ArrayList(il3Var);
                        this.Z = ts3Var;
                        this.f = il3Var;
                        this.z = null;
                        this.A = i6;
                        this.X = i5;
                        this.Y = 4;
                        ts3Var.b(arrayList3, this);
                        return mf0Var;
                    }
                    if (!il3Var.isEmpty()) {
                        this.Z = null;
                        this.f = null;
                        this.z = null;
                        this.A = i6;
                        this.X = i5;
                        this.Y = 5;
                        ts3Var.b(il3Var, this);
                        return mf0Var;
                    }
                    return xl4.a;
                }
                n12.S(obj);
                return xl4.a;
            }
            i = 1;
            i2 = this.X;
            int i13 = this.A;
            Iterator it3 = this.z;
            n12.S(obj);
            arrayList = new ArrayList(4);
            it = it3;
            i4 = i13;
            i3 = i2;
        }
        while (it.hasNext()) {
            Object next2 = it.next();
            if (i2 > 0) {
                i2--;
            } else {
                arrayList.add(next2);
                if (arrayList.size() == 4) {
                    this.Z = ts3Var;
                    this.f = arrayList;
                    this.z = it;
                    this.A = i4;
                    this.X = i3;
                    this.Y = i;
                    ts3Var.b(arrayList, this);
                    return mf0Var;
                }
            }
        }
        if (!arrayList.isEmpty()) {
            this.Z = null;
            this.f = null;
            this.z = null;
            this.A = i4;
            this.X = i3;
            this.Y = 2;
            ts3Var.b(arrayList, this);
            return mf0Var;
        }
        return xl4.a;
    }
}

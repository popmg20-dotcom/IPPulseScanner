package defpackage;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ec implements Runnable {
    public final /* synthetic */ Object A;
    public final /* synthetic */ int b;
    public final int f;
    public final Object z;

    public ec(yb2 yb2Var, int i, nc2 nc2Var) {
        this.b = 2;
        this.A = yb2Var;
        this.f = i;
        this.z = nc2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        vv vvVar;
        ArrayList arrayList;
        int iDecrementAndGet;
        e53 e53Var;
        int i = this.b;
        Object obj = this.z;
        int i2 = this.f;
        Object obj2 = this.A;
        switch (i) {
            case 0:
                ((TextView) obj).setTypeface((Typeface) obj2, i2);
                return;
            case 1:
                ((BottomSheetBehavior) obj2).Q((View) obj, i2, false);
                return;
            case 2:
                yb2 yb2Var = (yb2) obj2;
                nc2 nc2Var = (nc2) obj;
                boolean z = yb2Var.z;
                AtomicInteger atomicInteger = yb2Var.A;
                ArrayList arrayList2 = yb2Var.f;
                if (yb2Var.isDone() || arrayList2 == null) {
                    r25.j("Future was done before all dependencies completed", z);
                    return;
                }
                try {
                    try {
                        try {
                            try {
                                r25.j("Tried to set value from future which is not done", nc2Var.isDone());
                                arrayList2.set(i2, n12.E(nc2Var));
                                iDecrementAndGet = atomicInteger.decrementAndGet();
                                r25.j("Less than 0 remaining futures", iDecrementAndGet >= 0);
                            } catch (RuntimeException e) {
                                if (z) {
                                    yb2Var.Y.d(e);
                                }
                                int iDecrementAndGet2 = atomicInteger.decrementAndGet();
                                r25.j("Less than 0 remaining futures", iDecrementAndGet2 >= 0);
                                if (iDecrementAndGet2 == 0) {
                                    ArrayList arrayList3 = yb2Var.f;
                                    if (arrayList3 != null) {
                                        vvVar = yb2Var.Y;
                                        arrayList = new ArrayList(arrayList3);
                                    }
                                    r25.j(null, yb2Var.isDone());
                                    return;
                                }
                                return;
                            }
                        } catch (ExecutionException e2) {
                            if (z) {
                                yb2Var.Y.d(e2.getCause());
                            }
                            int iDecrementAndGet3 = atomicInteger.decrementAndGet();
                            r25.j("Less than 0 remaining futures", iDecrementAndGet3 >= 0);
                            if (iDecrementAndGet3 == 0) {
                                ArrayList arrayList4 = yb2Var.f;
                                if (arrayList4 != null) {
                                    vvVar = yb2Var.Y;
                                    arrayList = new ArrayList(arrayList4);
                                }
                                r25.j(null, yb2Var.isDone());
                                return;
                            }
                            return;
                        }
                    } catch (Error e3) {
                        yb2Var.Y.d(e3);
                        int iDecrementAndGet4 = atomicInteger.decrementAndGet();
                        r25.j("Less than 0 remaining futures", iDecrementAndGet4 >= 0);
                        if (iDecrementAndGet4 == 0) {
                            ArrayList arrayList5 = yb2Var.f;
                            if (arrayList5 != null) {
                                vvVar = yb2Var.Y;
                                arrayList = new ArrayList(arrayList5);
                            }
                            r25.j(null, yb2Var.isDone());
                            return;
                        }
                        return;
                    } catch (CancellationException unused) {
                        if (z) {
                            yb2Var.cancel(false);
                        }
                        int iDecrementAndGet5 = atomicInteger.decrementAndGet();
                        r25.j("Less than 0 remaining futures", iDecrementAndGet5 >= 0);
                        if (iDecrementAndGet5 == 0) {
                            ArrayList arrayList6 = yb2Var.f;
                            if (arrayList6 != null) {
                                vvVar = yb2Var.Y;
                                arrayList = new ArrayList(arrayList6);
                            }
                            r25.j(null, yb2Var.isDone());
                            return;
                        }
                        return;
                    }
                    if (iDecrementAndGet == 0) {
                        ArrayList arrayList7 = yb2Var.f;
                        if (arrayList7 != null) {
                            vvVar = yb2Var.Y;
                            arrayList = new ArrayList(arrayList7);
                            vvVar.b(arrayList);
                            return;
                        }
                        r25.j(null, yb2Var.isDone());
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    int iDecrementAndGet6 = atomicInteger.decrementAndGet();
                    r25.j("Less than 0 remaining futures", iDecrementAndGet6 >= 0);
                    if (iDecrementAndGet6 == 0) {
                        ArrayList arrayList8 = yb2Var.f;
                        if (arrayList8 != null) {
                            yb2Var.Y.b(new ArrayList(arrayList8));
                        } else {
                            r25.j(null, yb2Var.isDone());
                        }
                    }
                    throw th;
                }
            default:
                i53 i53Var = (i53) obj2;
                AtomicLong atomicLong = i53Var.A;
                atomicLong.lazySet(atomicLong.get() + ((long) i2));
                e53 e53Var2 = (e53) obj;
                kb2 kb2Var = i53Var.z;
                if (kb2Var.b(e53Var2) && e53Var2 != (e53Var = kb2Var.f)) {
                    e53 e53Var3 = e53Var2.f;
                    e53 e53Var4 = e53Var2.z;
                    if (e53Var3 == null) {
                        kb2Var.b = e53Var4;
                    } else {
                        e53Var3.z = e53Var4;
                        e53Var2.f = null;
                    }
                    if (e53Var4 == null) {
                        kb2Var.f = e53Var3;
                        e53Var = e53Var3;
                    } else {
                        e53Var4.f = e53Var3;
                        e53Var2.z = null;
                    }
                    kb2Var.f = e53Var2;
                    if (e53Var == null) {
                        kb2Var.b = e53Var2;
                    } else {
                        e53Var.z = e53Var2;
                        e53Var2.f = e53Var;
                    }
                }
                i53Var.d();
                return;
        }
    }

    public /* synthetic */ ec(Object obj, Object obj2, int i, int i2) {
        this.b = i2;
        this.A = obj;
        this.z = obj2;
        this.f = i;
    }

    public ec(TextView textView, Typeface typeface, int i) {
        this.b = 0;
        this.z = textView;
        this.A = typeface;
        this.f = i;
    }
}

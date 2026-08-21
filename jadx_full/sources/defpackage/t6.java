package defpackage;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.sentry.android.core.a1;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class t6 implements z2, uv2 {
    public final /* synthetic */ int b;
    public int f;
    public Object z;

    public t6(int i, int i2) {
        this.b = i2;
        switch (i2) {
            case 11:
                if (i < 0) {
                    xe.k(dw2.A(i, "invalid size: "));
                    throw null;
                }
                this.f = i;
                int i3 = (262143 + i) / 262144;
                this.z = new float[i3][];
                int i4 = 0;
                while (i4 < i3) {
                    int i5 = i3 - 1;
                    ((float[][]) this.z)[i4] = new float[(i4 == i5 ? i - (i5 * 262144) : 262144) + 1];
                    i4++;
                }
                return;
            default:
                this.f = i;
                return;
        }
    }

    public static void i(String str) {
        if (str.equalsIgnoreCase(":memory:")) {
            return;
        }
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = n12.l(str.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                } else {
                    length--;
                }
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        if (str.subSequence(i, length + 1).toString().length() == 0) {
            return;
        }
        a1.n("SupportSQLite", "deleting the database file: ".concat(str));
        try {
            SQLiteDatabase.deleteDatabase(new File(str));
        } catch (Exception e) {
            a1.o("SupportSQLite", "delete failed: ", e);
        }
    }

    @Override // defpackage.uv2
    public int a(int i) {
        k70 k70Var = (k70) this.z;
        int iN0 = k70Var.N0(i) - k70Var.M0(i);
        if (iN0 > 0) {
            return iN0;
        }
        return 0;
    }

    @Override // defpackage.uv2
    public int b() {
        return this.f;
    }

    @Override // defpackage.uv2
    public int c(int i) {
        int iM0 = ((k70) this.z).M0(i);
        if (iM0 > 0) {
            return iM0;
        }
        return 0;
    }

    @Override // defpackage.uv2
    public int count() {
        return ((k70) this.z).O0();
    }

    @Override // defpackage.z2
    public boolean d(View view) {
        ((BottomSheetBehavior) this.z).N(this.f);
        return true;
    }

    public void e(long j) {
        long[] jArr = (long[]) this.z;
        int i = this.f;
        int i2 = i + 1;
        this.f = i2;
        jArr[i] = j;
        if (jArr.length == i2) {
            long[] jArr2 = new long[i2 << 1];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            this.z = jArr2;
        }
    }

    public void f(MotionEvent motionEvent) {
        d21 d21Var = (d21) this.z;
        v11 v11Var = d21Var.b;
        CodeEditor codeEditor = d21Var.a;
        int i = this.f;
        gs3 insertHandleDescriptor = i != 1 ? i != 2 ? codeEditor.getInsertHandleDescriptor() : codeEditor.getRightHandleDescriptor() : codeEditor.getLeftHandleDescriptor();
        gs3 rightHandleDescriptor = this.f == 1 ? codeEditor.getRightHandleDescriptor() : codeEditor.getLeftHandleDescriptor();
        float x = motionEvent.getX() + v11Var.b.getCurrX();
        int i2 = insertHandleDescriptor.b;
        RectF rectF = insertHandleDescriptor.a;
        float fWidth = ((i2 != 0 ? rectF.width() : 0.0f) * (insertHandleDescriptor.b == 1 ? 1 : -1)) + x;
        float y = (motionEvent.getY() + v11Var.b.getCurrY()) - rectF.height();
        int iK = (int) (codeEditor.D0.k(0.0f - codeEditor.T(), y) >> 32);
        if (iK < 0 || iK >= codeEditor.getLineCount()) {
            return;
        }
        int iK2 = (int) (codeEditor.D0.k(fWidth - codeEditor.T(), y) & 4294967295L);
        int i3 = (this.f == 2 ? codeEditor.getCursor().d : codeEditor.getCursor().c).b;
        int i4 = (this.f == 2 ? codeEditor.getCursor().d : codeEditor.getCursor().c).c;
        int i5 = (this.f != 2 ? codeEditor.getCursor().d : codeEditor.getCursor().c).b;
        int i6 = this.f != 2 ? codeEditor.getCursor().d.c : codeEditor.getCursor().c.c;
        if (iK == i3 && iK2 == i4) {
            return;
        }
        int i7 = this.f;
        if (i7 != 0 && iK == i5 && iK2 == i6) {
            return;
        }
        if (i7 == 0) {
            codeEditor.Q1 = System.currentTimeMillis();
            codeEditor.j0(iK, iK2, 2, false);
            return;
        }
        if (i7 == 1) {
            gs3 gs3Var = rightHandleDescriptor;
            int i8 = i6;
            if (i5 >= iK && (i5 != iK || i8 >= iK2)) {
                codeEditor.l0(iK, iK2, i5, i8, 2, false);
                return;
            }
            if (RectF.intersects(rectF, gs3Var.a)) {
                return;
            }
            d21Var.c(d21Var.e, false);
            d21Var.e = 2;
            d21Var.c(2, true);
            this.f = 2;
            t6 t6Var = d21Var.v;
            t6Var.f = 1;
            d21Var.v = d21Var.u;
            d21Var.u = t6Var;
            codeEditor.l0(i5, i8, iK, iK2, 2, false);
            return;
        }
        if (i7 != 2) {
            return;
        }
        if (i5 <= iK && (i5 != iK || i6 <= iK2)) {
            codeEditor.l0(i5, i6, iK, iK2, 2, false);
            return;
        }
        gs3 gs3Var2 = rightHandleDescriptor;
        int i9 = i6;
        if (RectF.intersects(rectF, gs3Var2.a)) {
            return;
        }
        d21Var.c(d21Var.e, false);
        d21Var.e = 1;
        d21Var.c(1, true);
        this.f = 1;
        t6 t6Var2 = d21Var.u;
        t6Var2.f = 2;
        t6 t6Var3 = d21Var.v;
        d21Var.v = t6Var2;
        d21Var.u = t6Var3;
        codeEditor.l0(iK, iK2, i5, i9, 2, false);
    }

    public void g() {
        this.f = 0;
        Iterator it = ((LinkedHashMap) this.z).values().iterator();
        while (it.hasNext()) {
            ArrayList arrayList = (ArrayList) it.next();
            if (arrayList.size() <= 1) {
                df3 df3Var = (df3) d70.e0(arrayList);
                if ((df3Var != null ? (Bitmap) df3Var.b.get() : null) == null) {
                    it.remove();
                }
            } else {
                int size = arrayList.size();
                int i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    int i3 = i2 - i;
                    if (((df3) arrayList.get(i3)).b.get() == null) {
                        arrayList.remove(i3);
                        i++;
                    }
                }
                if (arrayList.isEmpty()) {
                    it.remove();
                }
            }
        }
    }

    public u6 h() {
        ListAdapter r6Var;
        p6 p6Var = (p6) this.z;
        ContextThemeWrapper contextThemeWrapper = p6Var.a;
        ContextThemeWrapper contextThemeWrapper2 = p6Var.a;
        u6 u6Var = new u6(contextThemeWrapper, this.f);
        View view = p6Var.f;
        s6 s6Var = u6Var.Z;
        if (view != null) {
            s6Var.y = view;
        } else {
            CharSequence charSequence = p6Var.e;
            if (charSequence != null) {
                s6Var.d = charSequence;
                TextView textView = s6Var.w;
                if (textView != null) {
                    textView.setText(charSequence);
                }
            }
            Drawable drawable = p6Var.d;
            if (drawable != null) {
                s6Var.u = drawable;
                s6Var.t = 0;
                ImageView imageView = s6Var.v;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    s6Var.v.setImageDrawable(drawable);
                }
            }
            int i = p6Var.c;
            if (i != 0) {
                s6Var.u = null;
                s6Var.t = i;
                ImageView imageView2 = s6Var.v;
                if (imageView2 != null) {
                    if (i != 0) {
                        imageView2.setVisibility(0);
                        s6Var.v.setImageResource(s6Var.t);
                    } else {
                        imageView2.setVisibility(8);
                    }
                }
            }
        }
        CharSequence charSequence2 = p6Var.g;
        if (charSequence2 != null) {
            s6Var.e = charSequence2;
            TextView textView2 = s6Var.x;
            if (textView2 != null) {
                textView2.setText(charSequence2);
            }
        }
        CharSequence charSequence3 = p6Var.h;
        if (charSequence3 != null) {
            s6Var.c(-1, charSequence3, p6Var.i);
        }
        CharSequence charSequence4 = p6Var.j;
        if (charSequence4 != null) {
            s6Var.c(-2, charSequence4, p6Var.k);
        }
        CharSequence charSequence5 = p6Var.l;
        if (charSequence5 != null) {
            s6Var.c(-3, charSequence5, p6Var.m);
        }
        if (p6Var.r != null || p6Var.s != null) {
            AlertController$RecycleListView alertController$RecycleListView = (AlertController$RecycleListView) p6Var.b.inflate(s6Var.C, (ViewGroup) null);
            if (p6Var.x) {
                r6Var = new m6(p6Var, contextThemeWrapper2, s6Var.D, p6Var.r, alertController$RecycleListView);
            } else {
                int i2 = p6Var.y ? s6Var.E : s6Var.F;
                r6Var = p6Var.s;
                if (r6Var == null) {
                    r6Var = new r6(contextThemeWrapper2, i2, R.id.text1, p6Var.r);
                }
            }
            s6Var.z = r6Var;
            s6Var.A = p6Var.z;
            if (p6Var.t != null) {
                alertController$RecycleListView.setOnItemClickListener(new n6(p6Var, s6Var));
            } else if (p6Var.A != null) {
                alertController$RecycleListView.setOnItemClickListener(new o6(p6Var, alertController$RecycleListView, s6Var));
            }
            if (p6Var.y) {
                alertController$RecycleListView.setChoiceMode(1);
            } else if (p6Var.x) {
                alertController$RecycleListView.setChoiceMode(2);
            }
            s6Var.f = alertController$RecycleListView;
        }
        View view2 = p6Var.v;
        if (view2 != null) {
            s6Var.g = view2;
            s6Var.h = 0;
            s6Var.i = false;
        } else {
            int i3 = p6Var.u;
            if (i3 != 0) {
                s6Var.g = null;
                s6Var.h = i3;
                s6Var.i = false;
            }
        }
        u6Var.setCancelable(p6Var.n);
        if (p6Var.n) {
            u6Var.setCanceledOnTouchOutside(true);
        }
        u6Var.setOnCancelListener(p6Var.o);
        u6Var.setOnDismissListener(p6Var.p);
        ok2 ok2Var = p6Var.q;
        if (ok2Var != null) {
            u6Var.setOnKeyListener(ok2Var);
        }
        return u6Var;
    }

    public long j(int i) {
        if (i >= this.f || i < 0) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        return ((long[]) this.z)[i];
    }

    public float k(int i, int i2) {
        float[][] fArr = (float[][]) this.z;
        if (fArr.length == 1) {
            float[] fArr2 = fArr[0];
            return fArr2[i2] - fArr2[i];
        }
        int i3 = i / 262144;
        int i4 = i2 / 262144;
        float f = 0.0f;
        while (i3 <= i4) {
            int i5 = i3 * 262144;
            int i6 = i3 + 1;
            int iMin = Math.min(i6 * 262144, this.f);
            int iMax = Math.max(i, i5);
            int iMin2 = Math.min(i2, iMin);
            if (iMax < iMin2) {
                float[] fArr3 = fArr[i3];
                f = (fArr3[iMin2 - i5] - fArr3[iMax - i5]) + f;
            }
            i3 = i6;
        }
        return f;
    }

    public void l(int i, xf xfVar) {
        while (true) {
            int i2 = i >> 1;
            if (i2 == 0) {
                break;
            }
            xf xfVar2 = ((xf[]) this.z)[i2];
            xfVar2.getClass();
            if (n12.m(0L, xfVar.g - xfVar2.g) <= 0) {
                break;
            }
            xfVar2.f = i;
            ((xf[]) this.z)[i] = xfVar2;
            i = i2;
        }
        ((xf[]) this.z)[i] = xfVar;
        xfVar.f = i;
    }

    public int m(int i) {
        int i2 = this.f - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            long j = (int) (((long[]) this.z)[i4] >> 32);
            long j2 = i;
            if (j < j2) {
                i3 = i4 + 1;
            } else {
                if (j <= j2) {
                    return i4;
                }
                i2 = i4 - 1;
            }
        }
        return i3;
    }

    public void n(gl1 gl1Var, int i, int i2) {
        ((ew) this.z).f(new c64(gl1Var), i, i2);
    }

    public void o(xf xfVar) {
        xf xfVar2;
        int i = xfVar.f;
        if (i == -1) {
            xe.k("Failed requirement.");
            return;
        }
        int i2 = this.f;
        xf xfVar3 = ((xf[]) this.z)[i2];
        xfVar3.getClass();
        xfVar.f = -1;
        ((xf[]) this.z)[i2] = null;
        this.f = i2 - 1;
        if (xfVar == xfVar3) {
            return;
        }
        int iM = n12.m(0L, xfVar3.g - xfVar.g);
        if (iM == 0) {
            ((xf[]) this.z)[i] = xfVar3;
            xfVar3.f = i;
            return;
        }
        if (iM >= 0) {
            l(i, xfVar3);
            return;
        }
        while (true) {
            int i3 = i << 1;
            int i4 = i3 + 1;
            int i5 = this.f;
            if (i4 > i5) {
                if (i3 > i5) {
                    break;
                }
                xfVar2 = ((xf[]) this.z)[i3];
                xfVar2.getClass();
            } else {
                xfVar2 = ((xf[]) this.z)[i3];
                xfVar2.getClass();
                xf xfVar4 = ((xf[]) this.z)[i4];
                xfVar4.getClass();
                if (n12.m(0L, xfVar4.g - xfVar2.g) >= 0) {
                    xfVar2 = xfVar4;
                }
            }
            if (n12.m(0L, xfVar2.g - xfVar3.g) <= 0) {
                break;
            }
            int i6 = xfVar2.f;
            xfVar2.f = i;
            ((xf[]) this.z)[i] = xfVar2;
            i = i6;
        }
        ((xf[]) this.z)[i] = xfVar3;
        xfVar3.f = i;
    }

    public synchronized void p(tj2 tj2Var, Bitmap bitmap, Map map, int i) {
        try {
            LinkedHashMap linkedHashMap = (LinkedHashMap) this.z;
            Object arrayList = linkedHashMap.get(tj2Var);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(tj2Var, arrayList);
            }
            ArrayList arrayList2 = (ArrayList) arrayList;
            int iIdentityHashCode = System.identityHashCode(bitmap);
            df3 df3Var = new df3(iIdentityHashCode, new WeakReference(bitmap), map, i);
            int size = arrayList2.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    arrayList2.add(df3Var);
                    break;
                }
                df3 df3Var2 = (df3) arrayList2.get(i2);
                if (i < df3Var2.d) {
                    i2++;
                } else if (df3Var2.a == iIdentityHashCode && df3Var2.b.get() == bitmap) {
                    arrayList2.set(i2, df3Var);
                } else {
                    arrayList2.add(i2, df3Var);
                }
            }
            int i3 = this.f;
            this.f = i3 + 1;
            if (i3 >= 10) {
                g();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void q(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        p6 p6Var = (p6) this.z;
        p6Var.h = charSequence;
        p6Var.i = onClickListener;
    }

    public u6 r() {
        u6 u6VarH = h();
        u6VarH.show();
        return u6VarH;
    }

    public synchronized void s(int i) {
        if (i >= 10 && i != 20) {
            g();
        }
    }

    public String toString() {
        switch (this.b) {
            case 5:
                return "OnigResult [indexInScanner=" + this.f + ", region=" + ((k70) this.z) + "]";
            default:
                return super.toString();
        }
    }

    public /* synthetic */ t6(int i, int i2, Object obj) {
        this.b = i2;
        this.z = obj;
        this.f = i;
    }

    public t6(ab0 ab0Var, int i) {
        this.b = 14;
        tj4.i(ab0Var);
        this.z = ab0Var;
        this.f = i;
    }

    public t6(k70 k70Var) {
        this.b = 5;
        this.z = k70Var;
        this.f = -1;
    }

    public /* synthetic */ t6(char c, int i) {
        this.b = i;
    }

    public t6(int i, hm2 hm2Var) {
        this.b = 13;
        this.f = i;
        this.z = new hm2[]{hm2Var};
    }

    public t6(hm2 hm2Var, hm2 hm2Var2) {
        this.b = 13;
        this.f = 62;
        this.z = new hm2[]{hm2Var, hm2Var2};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public t6(ew ewVar, int i) {
        this(i, 9);
        this.b = 9;
        this.z = ewVar;
    }

    public t6(int i, hm2[] hm2VarArr) {
        this.b = 12;
        this.f = i;
        this.z = hm2VarArr;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public t6(Context context) {
        this(context, u6.f(context, 0));
        this.b = 0;
    }

    public t6(Context context, int i) {
        this.b = 0;
        this.z = new p6(new ContextThemeWrapper(context, u6.f(context, i)));
        this.f = i;
    }

    public t6(byte b, int i) {
        this.b = i;
        switch (i) {
            case 6:
                this.z = new long[64];
                break;
            case 7:
            default:
                this.f = 1;
                this.z = Collections.singletonList(null);
                break;
            case 8:
                this.z = new LinkedHashMap();
                break;
        }
    }

    public t6(ArrayList arrayList, int i) {
        this.b = i;
        switch (i) {
            case 10:
                this.z = arrayList;
                break;
            default:
                this.f = 0;
                this.z = arrayList;
                break;
        }
    }
}

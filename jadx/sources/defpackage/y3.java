package defpackage;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentContainerView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.divider.MaterialDivider;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.loadingindicator.LoadingIndicator;
import com.google.android.material.materialswitch.MaterialSwitch;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.google.android.material.textview.MaterialTextView;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class y3 {
    public final Object a;
    public Object b;
    public final Object c;
    public final Object d;
    public final Object e;
    public final Object f;
    public final Object g;
    public final Object h;
    public final Object i;
    public final Object j;
    public final Object k;

    public y3() {
        this.a = new xu3[4];
        this.d = new Matrix[4];
        this.e = new Matrix[4];
        this.f = new PointF();
        this.g = new Path();
        this.h = new Path();
        this.i = new xu3();
        this.j = new float[2];
        this.b = new float[2];
        this.c = new Path();
        this.k = new Path();
        for (int i = 0; i < 4; i++) {
            ((xu3[]) this.a)[i] = new xu3();
            ((Matrix[]) this.d)[i] = new Matrix();
            ((Matrix[]) this.e)[i] = new Matrix();
        }
    }

    public void a(aj3 aj3Var) {
        aj3Var.Z = this;
        synchronized (((HashSet) this.d)) {
            ((HashSet) this.d).add(aj3Var);
        }
        aj3Var.Y = Integer.valueOf(((AtomicInteger) this.a).incrementAndGet());
        aj3Var.a("add-to-queue");
        f();
        ((PriorityBlockingQueue) this.e).add(aj3Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void b(ou3 ou3Var, float[] fArr, float f, RectF rectF, ha1 ha1Var, Path path) {
        int i;
        char c;
        float f2;
        ha1 ha1Var2;
        char c2;
        ha1 ha1Var3 = ha1Var;
        Matrix[] matrixArr = (Matrix[]) this.e;
        float[] fArr2 = (float[]) this.j;
        xu3[] xu3VarArr = (xu3[]) this.a;
        Matrix[] matrixArr2 = (Matrix[]) this.d;
        path.rewind();
        Path path2 = (Path) this.g;
        path2.rewind();
        Path path3 = (Path) this.h;
        path3.rewind();
        path3.addRect(rectF, Path.Direction.CW);
        int i2 = 0;
        while (true) {
            c = 0;
            if (i2 >= 4) {
                break;
            }
            PointF pointF = (PointF) this.f;
            ye0 e50Var = fArr == null ? i2 != 1 ? i2 != 2 ? i2 != 3 ? ou3Var.f : ou3Var.e : ou3Var.h : ou3Var.g : new e50(fArr[i2]);
            fx3 fx3Var = i2 != 1 ? i2 != 2 ? i2 != 3 ? ou3Var.b : ou3Var.a : ou3Var.d : ou3Var.c;
            xu3 xu3Var = xu3VarArr[i2];
            fx3Var.getClass();
            Matrix[] matrixArr3 = matrixArr;
            fx3Var.l(xu3Var, f, e50Var.a(rectF));
            int i3 = i2 + 1;
            float f3 = (i3 % 4) * 90;
            matrixArr2[i2].reset();
            if (i2 == 1) {
                pointF.set(rectF.right, rectF.bottom);
            } else if (i2 == 2) {
                pointF.set(rectF.left, rectF.bottom);
            } else if (i2 != 3) {
                pointF.set(rectF.right, rectF.top);
            } else {
                pointF.set(rectF.left, rectF.top);
            }
            matrixArr2[i2].setTranslate(pointF.x, pointF.y);
            matrixArr2[i2].preRotate(f3);
            xu3 xu3Var2 = xu3VarArr[i2];
            fArr2[0] = xu3Var2.b;
            fArr2[1] = xu3Var2.c;
            matrixArr2[i2].mapPoints(fArr2);
            matrixArr3[i2].reset();
            matrixArr3[i2].setTranslate(fArr2[0], fArr2[1]);
            matrixArr3[i2].preRotate(f3);
            i2 = i3;
            matrixArr = matrixArr3;
        }
        Matrix[] matrixArr4 = matrixArr;
        int i4 = 0;
        for (i = 4; i4 < i; i = 4) {
            xu3 xu3Var3 = xu3VarArr[i4];
            xu3Var3.getClass();
            fArr2[c] = 0.0f;
            fArr2[1] = xu3Var3.a;
            matrixArr2[i4].mapPoints(fArr2);
            if (i4 == 0) {
                path.moveTo(fArr2[c], fArr2[1]);
            } else {
                path.lineTo(fArr2[c], fArr2[1]);
            }
            xu3VarArr[i4].b(matrixArr2[i4], path);
            if (ha1Var3 != null) {
                xu3 xu3Var4 = xu3VarArr[i4];
                Matrix matrix = matrixArr2[i4];
                yi2 yi2Var = (yi2) ha1Var3.f;
                BitSet bitSet = yi2Var.X;
                xu3Var4.getClass();
                f2 = 0.0f;
                bitSet.set(i4, (boolean) c);
                wu3[] wu3VarArr = yi2Var.z;
                xu3Var4.a(xu3Var4.e);
                wu3VarArr[i4] = new qu3(new ArrayList(xu3Var4.g), new Matrix(matrix));
            } else {
                f2 = 0.0f;
            }
            Path path4 = (Path) this.c;
            xu3 xu3Var5 = (xu3) this.i;
            int i5 = i4 + 1;
            int i6 = i5 % 4;
            xu3 xu3Var6 = xu3VarArr[i4];
            fArr2[0] = xu3Var6.b;
            fArr2[1] = xu3Var6.c;
            matrixArr2[i4].mapPoints(fArr2);
            float[] fArr3 = (float[]) this.b;
            xu3 xu3Var7 = xu3VarArr[i6];
            xu3Var7.getClass();
            fArr3[0] = f2;
            fArr3[1] = xu3Var7.a;
            matrixArr2[i6].mapPoints(fArr3);
            xu3[] xu3VarArr2 = xu3VarArr;
            Matrix[] matrixArr5 = matrixArr2;
            float fMax = Math.max(((float) Math.hypot(fArr2[0] - fArr3[0], fArr2[1] - fArr3[1])) - 0.001f, f2);
            xu3 xu3Var8 = xu3VarArr2[i4];
            fArr2[0] = xu3Var8.b;
            fArr2[1] = xu3Var8.c;
            matrixArr5[i4].mapPoints(fArr2);
            if (i4 == 1 || i4 == 3) {
                Math.abs(rectF.centerX() - fArr2[0]);
            } else {
                Math.abs(rectF.centerY() - fArr2[1]);
            }
            xu3Var5.d(0.0f, 270.0f, 0.0f);
            (i4 != 1 ? i4 != 2 ? i4 != 3 ? ou3Var.j : ou3Var.i : ou3Var.l : ou3Var.k).getClass();
            xu3Var5.c(fMax, 0.0f);
            path4.reset();
            xu3Var5.b(matrixArr4[i4], path4);
            if (e(path4, i4) || e(path4, i6)) {
                path4.op(path4, path3, Path.Op.DIFFERENCE);
                fArr2[0] = 0.0f;
                fArr2[1] = xu3Var5.a;
                matrixArr4[i4].mapPoints(fArr2);
                path2.moveTo(fArr2[0], fArr2[1]);
                xu3Var5.b(matrixArr4[i4], path2);
            } else {
                xu3Var5.b(matrixArr4[i4], path);
            }
            if (ha1Var != null) {
                Matrix matrix2 = matrixArr4[i4];
                ha1Var2 = ha1Var;
                yi2 yi2Var2 = (yi2) ha1Var2.f;
                c2 = 0;
                yi2Var2.X.set(i4 + 4, false);
                wu3[] wu3VarArr2 = yi2Var2.A;
                xu3Var5.a(xu3Var5.e);
                wu3VarArr2[i4] = new qu3(new ArrayList(xu3Var5.g), new Matrix(matrix2));
            } else {
                ha1Var2 = ha1Var;
                c2 = 0;
            }
            c = c2;
            ha1Var3 = ha1Var2;
            i4 = i5;
            xu3VarArr = xu3VarArr2;
            matrixArr2 = matrixArr5;
        }
        path.close();
        path2.close();
        if (path2.isEmpty()) {
            return;
        }
        path.op(path2, Path.Op.UNION);
    }

    public void c(s53 s53Var) {
        synchronized (((HashSet) this.d)) {
            try {
                Iterator it = ((HashSet) this.d).iterator();
                while (it.hasNext()) {
                    ((aj3) it.next()).b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void d(Object obj) {
        if (obj == null) {
            xe.k("Cannot cancelAll with a null tag");
            return;
        }
        synchronized (((HashSet) this.d)) {
            try {
                for (aj3 aj3Var : (HashSet) this.d) {
                    if (aj3Var.C0 == obj) {
                        aj3Var.b();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean e(Path path, int i) {
        Path path2 = (Path) this.k;
        path2.reset();
        ((xu3[]) this.a)[i].b(((Matrix[]) this.d)[i], path2);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        path2.computeBounds(rectF, true);
        path.op(path2, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        return !rectF.isEmpty() || (rectF.width() > 1.0f && rectF.height() > 1.0f);
    }

    public void f() {
        synchronized (((ArrayList) this.k)) {
            try {
                Iterator it = ((ArrayList) this.k).iterator();
                if (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public y3(CoordinatorLayout coordinatorLayout, MaterialTextView materialTextView, LinearLayoutCompat linearLayoutCompat, MaterialButton materialButton, TextView textView, RecyclerView recyclerView, LoadingIndicator loadingIndicator, ConstraintLayout constraintLayout, Button button, ExtendedFloatingActionButton extendedFloatingActionButton, Toolbar toolbar) {
        this.a = coordinatorLayout;
        this.d = materialTextView;
        this.b = linearLayoutCompat;
        this.e = materialButton;
        this.f = textView;
        this.g = recyclerView;
        this.h = loadingIndicator;
        this.i = constraintLayout;
        this.j = button;
        this.k = extendedFloatingActionButton;
        this.c = toolbar;
    }

    public y3(FloatingActionButton floatingActionButton, FragmentContainerView fragmentContainerView, LinearLayoutCompat linearLayoutCompat, MaterialButton materialButton, LinearProgressIndicator linearProgressIndicator, MaterialButton materialButton2, View view, RecyclerView recyclerView, CoordinatorLayout coordinatorLayout, Toolbar toolbar, MaterialDivider materialDivider) {
        this.d = floatingActionButton;
        this.e = fragmentContainerView;
        this.b = linearLayoutCompat;
        this.f = materialButton;
        this.g = linearProgressIndicator;
        this.h = materialButton2;
        this.i = view;
        this.j = recyclerView;
        this.a = coordinatorLayout;
        this.c = toolbar;
        this.k = materialDivider;
    }

    public y3(CoordinatorLayout coordinatorLayout, MaterialCardView materialCardView, MaterialCardView materialCardView2, HorizontalScrollView horizontalScrollView, MaterialCardView materialCardView3, MaterialSwitch materialSwitch, NestedScrollView nestedScrollView, LinearLayoutCompat linearLayoutCompat, HorizontalScrollView horizontalScrollView2, Toolbar toolbar, MaterialDivider materialDivider) {
        this.a = coordinatorLayout;
        this.d = materialCardView;
        this.e = materialCardView2;
        this.g = horizontalScrollView;
        this.f = materialCardView3;
        this.i = materialSwitch;
        this.j = nestedScrollView;
        this.b = linearLayoutCompat;
        this.h = horizontalScrollView2;
        this.c = toolbar;
        this.k = materialDivider;
    }

    public y3(fv0 fv0Var, lb lbVar) {
        w7 w7Var = new w7(new Handler(Looper.getMainLooper()));
        this.a = new AtomicInteger();
        this.d = new HashSet();
        this.e = new PriorityBlockingQueue();
        this.f = new PriorityBlockingQueue();
        this.c = new ArrayList();
        this.k = new ArrayList();
        this.g = fv0Var;
        this.h = lbVar;
        this.j = new dr2[4];
        this.i = w7Var;
    }
}

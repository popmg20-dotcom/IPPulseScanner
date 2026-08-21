package defpackage;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.getsurfboard.R;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xa1 extends vg4 {
    public static final String[] Y0 = {"android:visibility:visibility", "android:visibility:parent"};
    public final int X0;

    public xa1() {
        this.X0 = 3;
    }

    public static void U(hh4 hh4Var) {
        int visibility = hh4Var.b.getVisibility();
        HashMap map = hh4Var.a;
        map.put("android:visibility:visibility", Integer.valueOf(visibility));
        map.put("android:visibility:parent", hh4Var.b.getParent());
        int[] iArr = new int[2];
        hh4Var.b.getLocationOnScreen(iArr);
        map.put("android:visibility:screenLocation", iArr);
    }

    public static float W(hh4 hh4Var, float f) {
        Float f2;
        return (hh4Var == null || (f2 = (Float) hh4Var.a.get("android:fade:transitionAlpha")) == null) ? f : f2.floatValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static js4 X(hh4 hh4Var, hh4 hh4Var2) {
        js4 js4Var = new js4();
        js4Var.a = false;
        js4Var.b = false;
        if (hh4Var != null) {
            HashMap map = hh4Var.a;
            if (map.containsKey("android:visibility:visibility")) {
                js4Var.c = ((Integer) map.get("android:visibility:visibility")).intValue();
                js4Var.e = (ViewGroup) map.get("android:visibility:parent");
            } else {
                js4Var.c = -1;
                js4Var.e = null;
            }
        }
        if (hh4Var2 != null) {
            HashMap map2 = hh4Var2.a;
            if (map2.containsKey("android:visibility:visibility")) {
                js4Var.d = ((Integer) map2.get("android:visibility:visibility")).intValue();
                js4Var.f = (ViewGroup) map2.get("android:visibility:parent");
            } else {
                js4Var.d = -1;
                js4Var.f = null;
            }
        }
        if (hh4Var != null && hh4Var2 != null) {
            int i = js4Var.c;
            int i2 = js4Var.d;
            if (i != i2 || js4Var.e != js4Var.f) {
                if (i != i2) {
                    if (i == 0) {
                        js4Var.b = false;
                        js4Var.a = true;
                        return js4Var;
                    }
                    if (i2 == 0) {
                        js4Var.b = true;
                        js4Var.a = true;
                        return js4Var;
                    }
                } else {
                    if (js4Var.f == null) {
                        js4Var.b = false;
                        js4Var.a = true;
                        return js4Var;
                    }
                    if (js4Var.e == null) {
                        js4Var.b = true;
                        js4Var.a = true;
                        return js4Var;
                    }
                }
            }
        } else {
            if (hh4Var == null && js4Var.d == 0) {
                js4Var.b = true;
                js4Var.a = true;
                return js4Var;
            }
            if (hh4Var2 == null && js4Var.c == 0) {
                js4Var.b = false;
                js4Var.a = true;
            }
        }
        return js4Var;
    }

    public final ObjectAnimator V(View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        or4.a.V(view, f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, or4.b, f2);
        wa1 wa1Var = new wa1(view);
        objectAnimatorOfFloat.addListener(wa1Var);
        r().a(wa1Var);
        return objectAnimatorOfFloat;
    }

    @Override // defpackage.vg4
    public final void e(hh4 hh4Var) {
        U(hh4Var);
    }

    @Override // defpackage.vg4
    public final void h(hh4 hh4Var) {
        U(hh4Var);
        Float fValueOf = (Float) hh4Var.b.getTag(R.id.transition_pause_alpha);
        if (fValueOf == null) {
            if (hh4Var.b.getVisibility() == 0) {
                fValueOf = Float.valueOf(or4.a.B(hh4Var.b));
            } else {
                fValueOf = Float.valueOf(0.0f);
            }
        }
        hh4Var.a.put("android:fade:transitionAlpha", fValueOf);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0047, code lost:
    
        if (X(q(r1, false), v(r1, false)).a != false) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0215  */
    @Override // defpackage.vg4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Animator l(ViewGroup viewGroup, hh4 hh4Var, hh4 hh4Var2) {
        boolean z;
        View view;
        int i;
        char c;
        int i2;
        View view2;
        Animator animator;
        View view3;
        boolean z2;
        ViewGroup viewGroup2;
        int i3;
        Bitmap bitmapCreateBitmap;
        js4 js4VarX = X(hh4Var, hh4Var2);
        if (js4VarX.a && (js4VarX.e != null || js4VarX.f != null)) {
            boolean z3 = js4VarX.b;
            int i4 = this.X0;
            int i5 = 1;
            if (!z3) {
                int i6 = js4VarX.d;
                if ((i4 & 2) == 2 && hh4Var != null) {
                    View view4 = hh4Var.b;
                    View view5 = hh4Var2 != null ? hh4Var2.b : null;
                    View view6 = (View) view4.getTag(R.id.save_overlay_view);
                    if (view6 != null) {
                        i = i6;
                        c = 1;
                        i2 = 0;
                        view3 = null;
                        animator = null;
                    } else {
                        if (view5 == null || view5.getParent() == null) {
                            if (view5 != null) {
                                z = false;
                            }
                            view = null;
                            if (!z) {
                                i = i6;
                                c = 1;
                                i2 = 0;
                                view2 = view;
                                animator = null;
                                view6 = view5;
                                i5 = i2;
                                view3 = view2;
                            } else if (view4.getParent() == null) {
                                i = i6;
                                c = 1;
                                i5 = 0;
                                i2 = 0;
                                view3 = view;
                                animator = null;
                                view6 = view4;
                            } else {
                                if (view4.getParent() instanceof View) {
                                    View view7 = (View) view4.getParent();
                                    animator = null;
                                    i2 = 0;
                                    if (X(v(view7, true), q(view7, true)).a) {
                                        i = i6;
                                        c = 1;
                                        view2 = view;
                                        int id = view7.getId();
                                        if (view7.getParent() == null && id != -1) {
                                            viewGroup.findViewById(id);
                                        }
                                    } else {
                                        boolean z4 = gh4.a;
                                        Matrix matrix = new Matrix();
                                        matrix.setTranslate(-view7.getScrollX(), -view7.getScrollY());
                                        ur4 ur4Var = or4.a;
                                        ur4Var.j0(view4, matrix);
                                        ur4Var.k0(viewGroup, matrix);
                                        RectF rectF = new RectF(0.0f, 0.0f, view4.getWidth(), view4.getHeight());
                                        matrix.mapRect(rectF);
                                        int iRound = Math.round(rectF.left);
                                        int iRound2 = Math.round(rectF.top);
                                        c = 1;
                                        int iRound3 = Math.round(rectF.right);
                                        int iRound4 = Math.round(rectF.bottom);
                                        ImageView imageView = new ImageView(view4.getContext());
                                        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                                        boolean zIsAttachedToWindow = view4.isAttachedToWindow();
                                        boolean z5 = viewGroup != null && viewGroup.isAttachedToWindow();
                                        if (zIsAttachedToWindow) {
                                            z2 = zIsAttachedToWindow;
                                            viewGroup2 = null;
                                            i3 = 0;
                                        } else if (z5) {
                                            viewGroup2 = (ViewGroup) view4.getParent();
                                            int iIndexOfChild = viewGroup2.indexOfChild(view4);
                                            z2 = zIsAttachedToWindow;
                                            viewGroup.getOverlay().add(view4);
                                            i3 = iIndexOfChild;
                                        } else {
                                            i = i6;
                                            view2 = view;
                                            bitmapCreateBitmap = null;
                                            if (bitmapCreateBitmap != null) {
                                                imageView.setImageBitmap(bitmapCreateBitmap);
                                            }
                                            imageView.measure(View.MeasureSpec.makeMeasureSpec(iRound3 - iRound, Pow2.MAX_POW2), View.MeasureSpec.makeMeasureSpec(iRound4 - iRound2, Pow2.MAX_POW2));
                                            imageView.layout(iRound, iRound2, iRound3, iRound4);
                                            view6 = imageView;
                                            i5 = i2;
                                            view3 = view2;
                                        }
                                        view2 = view;
                                        int iRound5 = Math.round(rectF.width());
                                        i = i6;
                                        int iRound6 = Math.round(rectF.height());
                                        if (iRound5 <= 0 || iRound6 <= 0) {
                                            bitmapCreateBitmap = null;
                                        } else {
                                            float fMin = Math.min(1.0f, 1048576.0f / (iRound5 * iRound6));
                                            int iRound7 = Math.round(iRound5 * fMin);
                                            int iRound8 = Math.round(iRound6 * fMin);
                                            matrix.postTranslate(-rectF.left, -rectF.top);
                                            matrix.postScale(fMin, fMin);
                                            if (gh4.a) {
                                                Picture picture = new Picture();
                                                Canvas canvasBeginRecording = picture.beginRecording(iRound7, iRound8);
                                                canvasBeginRecording.concat(matrix);
                                                view4.draw(canvasBeginRecording);
                                                picture.endRecording();
                                                bitmapCreateBitmap = dh4.a(picture);
                                            } else {
                                                bitmapCreateBitmap = Bitmap.createBitmap(iRound7, iRound8, Bitmap.Config.ARGB_8888);
                                                Canvas canvas = new Canvas(bitmapCreateBitmap);
                                                canvas.concat(matrix);
                                                view4.draw(canvas);
                                            }
                                        }
                                        if (!z2) {
                                            viewGroup.getOverlay().remove(view4);
                                            viewGroup2.addView(view4, i3);
                                        }
                                        if (bitmapCreateBitmap != null) {
                                        }
                                        imageView.measure(View.MeasureSpec.makeMeasureSpec(iRound3 - iRound, Pow2.MAX_POW2), View.MeasureSpec.makeMeasureSpec(iRound4 - iRound2, Pow2.MAX_POW2));
                                        imageView.layout(iRound, iRound2, iRound3, iRound4);
                                        view6 = imageView;
                                        i5 = i2;
                                        view3 = view2;
                                    }
                                }
                                view6 = view5;
                                i5 = i2;
                                view3 = view2;
                            }
                        } else if (i6 == 4 || view4 == view5) {
                            z = false;
                            view = view5;
                            view5 = null;
                            if (!z) {
                            }
                        }
                        z = true;
                        view5 = null;
                        view = null;
                        if (!z) {
                        }
                    }
                    if (view6 == null) {
                        if (view3 == null) {
                            return animator;
                        }
                        int visibility = view3.getVisibility();
                        or4.b(view3, i2);
                        ur4 ur4Var2 = or4.a;
                        ur4Var2.getClass();
                        ObjectAnimator objectAnimatorV = V(view3, W(hh4Var, 1.0f), 0.0f);
                        if (objectAnimatorV == null) {
                            ur4Var2.V(view3, W(hh4Var2, 1.0f));
                        }
                        if (objectAnimatorV == null) {
                            or4.b(view3, visibility);
                            return objectAnimatorV;
                        }
                        hs4 hs4Var = new hs4(view3, i);
                        objectAnimatorV.addListener(hs4Var);
                        r().a(hs4Var);
                        return objectAnimatorV;
                    }
                    if (i5 == 0) {
                        int[] iArr = (int[]) hh4Var.a.get("android:visibility:screenLocation");
                        int i7 = iArr[i2];
                        int i8 = iArr[c];
                        int[] iArr2 = new int[2];
                        viewGroup.getLocationOnScreen(iArr2);
                        view6.offsetLeftAndRight((i7 - iArr2[i2]) - view6.getLeft());
                        view6.offsetTopAndBottom((i8 - iArr2[c]) - view6.getTop());
                        viewGroup.getOverlay().add(view6);
                    }
                    ur4 ur4Var3 = or4.a;
                    ur4Var3.getClass();
                    ObjectAnimator objectAnimatorV2 = V(view6, W(hh4Var, 1.0f), 0.0f);
                    if (objectAnimatorV2 == null) {
                        ur4Var3.V(view6, W(hh4Var2, 1.0f));
                    }
                    if (i5 == 0) {
                        if (objectAnimatorV2 == null) {
                            viewGroup.getOverlay().remove(view6);
                            return objectAnimatorV2;
                        }
                        view4.setTag(R.id.save_overlay_view, view6);
                        is4 is4Var = new is4(this, viewGroup, view6, view4);
                        objectAnimatorV2.addListener(is4Var);
                        objectAnimatorV2.addPauseListener(is4Var);
                        r().a(is4Var);
                    }
                    return objectAnimatorV2;
                }
            } else if ((i4 & 1) == 1 && hh4Var2 != null) {
                if (hh4Var == null) {
                    View view8 = (View) hh4Var2.b.getParent();
                }
                View view9 = hh4Var2.b;
                or4.a.getClass();
                return V(view9, W(hh4Var, 0.0f), 1.0f);
            }
        }
        return null;
    }

    @Override // defpackage.vg4
    public final String[] u() {
        return Y0;
    }

    @Override // defpackage.vg4
    public final boolean x() {
        return true;
    }

    @Override // defpackage.vg4
    public final boolean y(hh4 hh4Var, hh4 hh4Var2) {
        if (hh4Var == null && hh4Var2 == null) {
            return false;
        }
        if (hh4Var != null && hh4Var2 != null && hh4Var2.a.containsKey("android:visibility:visibility") != hh4Var.a.containsKey("android:visibility:visibility")) {
            return false;
        }
        js4 js4VarX = X(hh4Var, hh4Var2);
        if (js4VarX.a) {
            return js4VarX.c == 0 || js4VarX.d == 0;
        }
        return false;
    }

    public xa1(int i) {
        this();
        this.X0 = i;
    }
}

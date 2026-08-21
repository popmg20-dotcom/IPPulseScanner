package defpackage;

import android.content.ClipDescription;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.BlendMode;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.DragEvent;
import android.view.View;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class dy0 {
    public final View b;
    public final jd c;
    public final GradientDrawable d;
    public final GradientDrawable e;
    public Drawable g;
    public BlendMode i;
    public ColorStateList j;
    public PorterDuff.Mode k;
    public boolean a = false;
    public final HashSet f = new HashSet();
    public int h = 119;

    public dy0(View view, jd jdVar, int i, int i2) {
        this.b = view;
        this.c = jdVar;
        int iA = a(i, 0.2f);
        int iA2 = a(i, 0.65f);
        int iA3 = a(i, 0.4f);
        int iA4 = a(i, 1.0f);
        Context context = view.getContext();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(iA);
        gradientDrawable.setStroke(b(context, 3), iA3);
        float f = i2;
        gradientDrawable.setCornerRadius(f);
        this.d = gradientDrawable;
        Context context2 = view.getContext();
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setColor(iA2);
        gradientDrawable2.setStroke(b(context2, 3), iA4);
        gradientDrawable2.setCornerRadius(f);
        this.e = gradientDrawable2;
    }

    public static int a(int i, float f) {
        return (i & 16777215) | (((int) (f * 255.0f)) << 24);
    }

    public static int b(Context context, int i) {
        return Math.round(Math.max(0, i) * context.getResources().getDisplayMetrics().density);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00bd A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean c(View view, DragEvent dragEvent) {
        if (dragEvent.getLocalState() == null) {
            int action = dragEvent.getAction();
            if (action != 4) {
                ClipDescription clipDescription = dragEvent.getClipDescription();
                String[] strArr = (String[]) this.c.f;
                if (clipDescription != null) {
                    for (String str : strArr) {
                        if (clipDescription.hasMimeType(str)) {
                            View view2 = this.b;
                            HashSet hashSet = this.f;
                            if (action == 1) {
                                if (action != 4) {
                                    if (action == 5) {
                                        hashSet.add(view);
                                    } else if (action == 6) {
                                        hashSet.remove(view);
                                    }
                                } else if (this.a) {
                                    this.a = false;
                                    view2.setForeground(this.g);
                                    view2.setForegroundGravity(this.h);
                                    view2.setForegroundTintList(this.j);
                                    view2.setForegroundTintMode(this.k);
                                    this.g = null;
                                    this.h = 119;
                                    this.j = null;
                                    this.k = null;
                                    if (Build.VERSION.SDK_INT >= 29) {
                                        cy0.a(this);
                                    }
                                    hashSet.clear();
                                }
                            } else if (!this.a) {
                                this.a = true;
                                this.g = view2.getForeground();
                                this.h = view2.getForegroundGravity();
                                this.j = view2.getForegroundTintList();
                                this.k = view2.getForegroundTintMode();
                                view2.setForegroundGravity(119);
                                view2.setForegroundTintList(null);
                                view2.setForegroundTintMode(null);
                                if (Build.VERSION.SDK_INT >= 29) {
                                    by0.a(this);
                                }
                            }
                            if (this.a) {
                                if (hashSet.isEmpty()) {
                                    view2.setForeground(this.d);
                                } else {
                                    view2.setForeground(this.e);
                                }
                            }
                            if (action != 1) {
                                return true;
                            }
                        }
                    }
                }
            } else {
                View view22 = this.b;
                HashSet hashSet2 = this.f;
                if (action == 1) {
                }
                if (this.a) {
                }
                if (action != 1) {
                }
            }
        }
        return false;
    }
}

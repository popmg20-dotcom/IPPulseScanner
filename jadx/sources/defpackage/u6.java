package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;
import androidx.core.widget.NestedScrollView;
import com.getsurfboard.R;
import io.netty.handler.codec.dns.DnsRecord;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class u6 extends bb implements DialogInterface {
    public final s6 Z;

    public u6(ContextThemeWrapper contextThemeWrapper, int i) {
        super(contextThemeWrapper, f(contextThemeWrapper, i));
        this.Z = new s6(getContext(), this, getWindow());
    }

    public static int f(Context context, int i) {
        if (((i >>> 24) & DnsRecord.CLASS_ANY) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // defpackage.bb, defpackage.l90, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        int i;
        ListAdapter listAdapter;
        View viewFindViewById;
        super.onCreate(bundle);
        s6 s6Var = this.Z;
        s6Var.b.setContentView(s6Var.B);
        Context context = s6Var.a;
        Window window = s6Var.c;
        View viewFindViewById2 = window.findViewById(R.id.parentPanel);
        View viewFindViewById3 = viewFindViewById2.findViewById(R.id.topPanel);
        View viewFindViewById4 = viewFindViewById2.findViewById(R.id.contentPanel);
        View viewFindViewById5 = viewFindViewById2.findViewById(R.id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById2.findViewById(R.id.customPanel);
        View viewInflate = s6Var.g;
        if (viewInflate == null) {
            viewInflate = s6Var.h != 0 ? LayoutInflater.from(context).inflate(s6Var.h, viewGroup, false) : null;
        }
        boolean z = viewInflate != null;
        if (!z || !s6.a(viewInflate)) {
            window.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) window.findViewById(R.id.custom);
            frameLayout.addView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
            if (s6Var.i) {
                frameLayout.setPadding(0, 0, 0, 0);
            }
            if (s6Var.f != null) {
                ((LinearLayout.LayoutParams) ((za2) viewGroup.getLayoutParams())).weight = 0.0f;
            }
        } else {
            viewGroup.setVisibility(8);
        }
        View viewFindViewById6 = viewGroup.findViewById(R.id.topPanel);
        View viewFindViewById7 = viewGroup.findViewById(R.id.contentPanel);
        View viewFindViewById8 = viewGroup.findViewById(R.id.buttonPanel);
        ViewGroup viewGroupB = s6.b(viewFindViewById6, viewFindViewById3);
        ViewGroup viewGroupB2 = s6.b(viewFindViewById7, viewFindViewById4);
        ViewGroup viewGroupB3 = s6.b(viewFindViewById8, viewFindViewById5);
        NestedScrollView nestedScrollView = (NestedScrollView) window.findViewById(R.id.scrollView);
        s6Var.s = nestedScrollView;
        nestedScrollView.setFocusable(false);
        s6Var.s.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroupB2.findViewById(android.R.id.message);
        s6Var.x = textView;
        if (textView != null) {
            CharSequence charSequence = s6Var.e;
            if (charSequence != null) {
                textView.setText(charSequence);
            } else {
                textView.setVisibility(8);
                s6Var.s.removeView(s6Var.x);
                if (s6Var.f != null) {
                    ViewGroup viewGroup2 = (ViewGroup) s6Var.s.getParent();
                    int iIndexOfChild = viewGroup2.indexOfChild(s6Var.s);
                    viewGroup2.removeViewAt(iIndexOfChild);
                    viewGroup2.addView(s6Var.f, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
                } else {
                    viewGroupB2.setVisibility(8);
                }
            }
        }
        Button button = (Button) viewGroupB3.findViewById(android.R.id.button1);
        s6Var.j = button;
        c3 c3Var = s6Var.I;
        button.setOnClickListener(c3Var);
        boolean zIsEmpty = TextUtils.isEmpty(s6Var.k);
        Button button2 = s6Var.j;
        if (zIsEmpty) {
            button2.setVisibility(8);
            i = 0;
        } else {
            button2.setText(s6Var.k);
            s6Var.j.setVisibility(0);
            i = 1;
        }
        Button button3 = (Button) viewGroupB3.findViewById(android.R.id.button2);
        s6Var.m = button3;
        button3.setOnClickListener(c3Var);
        boolean zIsEmpty2 = TextUtils.isEmpty(s6Var.n);
        Button button4 = s6Var.m;
        if (zIsEmpty2) {
            button4.setVisibility(8);
        } else {
            button4.setText(s6Var.n);
            s6Var.m.setVisibility(0);
            i |= 2;
        }
        Button button5 = (Button) viewGroupB3.findViewById(android.R.id.button3);
        s6Var.p = button5;
        button5.setOnClickListener(c3Var);
        boolean zIsEmpty3 = TextUtils.isEmpty(s6Var.q);
        Button button6 = s6Var.p;
        if (zIsEmpty3) {
            button6.setVisibility(8);
        } else {
            button6.setText(s6Var.q);
            s6Var.p.setVisibility(0);
            i |= 4;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            if (i == 1) {
                Button button7 = s6Var.j;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button7.getLayoutParams();
                layoutParams.gravity = 1;
                layoutParams.weight = 0.5f;
                button7.setLayoutParams(layoutParams);
            } else if (i == 2) {
                Button button8 = s6Var.m;
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) button8.getLayoutParams();
                layoutParams2.gravity = 1;
                layoutParams2.weight = 0.5f;
                button8.setLayoutParams(layoutParams2);
            } else if (i == 4) {
                Button button9 = s6Var.p;
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) button9.getLayoutParams();
                layoutParams3.gravity = 1;
                layoutParams3.weight = 0.5f;
                button9.setLayoutParams(layoutParams3);
            }
        }
        if (i == 0) {
            viewGroupB3.setVisibility(8);
        }
        if (s6Var.y != null) {
            viewGroupB.addView(s6Var.y, 0, new ViewGroup.LayoutParams(-1, -2));
            window.findViewById(R.id.title_template).setVisibility(8);
        } else {
            s6Var.v = (ImageView) window.findViewById(android.R.id.icon);
            if (TextUtils.isEmpty(s6Var.d) || !s6Var.G) {
                window.findViewById(R.id.title_template).setVisibility(8);
                s6Var.v.setVisibility(8);
                viewGroupB.setVisibility(8);
            } else {
                TextView textView2 = (TextView) window.findViewById(R.id.alertTitle);
                s6Var.w = textView2;
                textView2.setText(s6Var.d);
                int i2 = s6Var.t;
                if (i2 != 0) {
                    s6Var.v.setImageResource(i2);
                } else {
                    Drawable drawable = s6Var.u;
                    if (drawable != null) {
                        s6Var.v.setImageDrawable(drawable);
                    } else {
                        s6Var.w.setPadding(s6Var.v.getPaddingLeft(), s6Var.v.getPaddingTop(), s6Var.v.getPaddingRight(), s6Var.v.getPaddingBottom());
                        s6Var.v.setVisibility(8);
                    }
                }
            }
        }
        boolean z2 = viewGroup.getVisibility() != 8;
        int i3 = (viewGroupB == null || viewGroupB.getVisibility() == 8) ? 0 : 1;
        boolean z3 = viewGroupB3.getVisibility() != 8;
        if (!z3 && (viewFindViewById = viewGroupB2.findViewById(R.id.textSpacerNoButtons)) != null) {
            viewFindViewById.setVisibility(0);
        }
        if (i3 != 0) {
            NestedScrollView nestedScrollView2 = s6Var.s;
            if (nestedScrollView2 != null) {
                nestedScrollView2.setClipToPadding(true);
            }
            View viewFindViewById9 = (s6Var.e == null && s6Var.f == null) ? null : viewGroupB.findViewById(R.id.titleDividerNoCustom);
            if (viewFindViewById9 != null) {
                viewFindViewById9.setVisibility(0);
            }
        } else {
            View viewFindViewById10 = viewGroupB2.findViewById(R.id.textSpacerNoTitle);
            if (viewFindViewById10 != null) {
                viewFindViewById10.setVisibility(0);
            }
        }
        AlertController$RecycleListView alertController$RecycleListView = s6Var.f;
        if (alertController$RecycleListView != null) {
            alertController$RecycleListView.getClass();
            if (!z3 || i3 == 0) {
                alertController$RecycleListView.setPadding(alertController$RecycleListView.getPaddingLeft(), i3 != 0 ? alertController$RecycleListView.getPaddingTop() : alertController$RecycleListView.b, alertController$RecycleListView.getPaddingRight(), z3 ? alertController$RecycleListView.getPaddingBottom() : alertController$RecycleListView.f);
            }
        }
        if (!z2) {
            View view = s6Var.f;
            if (view == null) {
                view = s6Var.s;
            }
            if (view != null) {
                int i4 = z3 ? 2 : 0;
                View viewFindViewById11 = window.findViewById(R.id.scrollIndicatorUp);
                View viewFindViewById12 = window.findViewById(R.id.scrollIndicatorDown);
                WeakHashMap weakHashMap = wp4.a;
                view.setScrollIndicators(i3 | i4, 3);
                if (viewFindViewById11 != null) {
                    viewGroupB2.removeView(viewFindViewById11);
                }
                if (viewFindViewById12 != null) {
                    viewGroupB2.removeView(viewFindViewById12);
                }
            }
        }
        AlertController$RecycleListView alertController$RecycleListView2 = s6Var.f;
        if (alertController$RecycleListView2 == null || (listAdapter = s6Var.z) == null) {
            return;
        }
        alertController$RecycleListView2.setAdapter(listAdapter);
        int i5 = s6Var.A;
        if (i5 > -1) {
            alertController$RecycleListView2.setItemChecked(i5, true);
            alertController$RecycleListView2.setSelection(i5);
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.Z.s;
        if (nestedScrollView == null || !nestedScrollView.i(keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.Z.s;
        if (nestedScrollView == null || !nestedScrollView.i(keyEvent)) {
            return super.onKeyUp(i, keyEvent);
        }
        return true;
    }

    @Override // defpackage.bb, android.app.Dialog
    public final void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        s6 s6Var = this.Z;
        s6Var.d = charSequence;
        TextView textView = s6Var.w;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }
}

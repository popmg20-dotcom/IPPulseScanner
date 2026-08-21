package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.widget.ListView;
import android.widget.ProgressBar;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class r01 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ t01 f;

    public /* synthetic */ r01(t01 t01Var, int i) {
        this.b = i;
        this.f = t01Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        final t01 t01Var = this.f;
        int i2 = 0;
        switch (i) {
            case 0:
                iv1 iv1Var = t01Var.O0;
                ((ListView) iv1Var.f).post(new yk0(iv1Var, i2, i2, i2));
                break;
            case 1:
                if (t01Var.U0) {
                    ((ProgressBar) t01Var.O0.z).setVisibility(0);
                }
                break;
            case 2:
                xk0 xk0Var = t01Var.N0;
                CodeEditor codeEditor = t01Var.F0;
                ArrayList<ax3> arrayList = t01Var.K0.a;
                if (t01Var.V0) {
                    u01 colorScheme = codeEditor.getColorScheme();
                    if (colorScheme == null) {
                        colorScheme = u01.c;
                        colorScheme.getClass();
                    }
                    int iE = colorScheme.e(67);
                    for (ax3 ax3Var : arrayList) {
                        kz3 kz3Var = ax3Var.e;
                        if (kz3Var != null && !(ax3Var.b instanceof Spannable)) {
                            List list = kz3Var.b.b;
                            SpannableString spannableString = new SpannableString(ax3Var.b);
                            int size = list.size() - 1;
                            if (size >= 0) {
                                while (true) {
                                    int i3 = size - 1;
                                    int iIntValue = ((Number) list.get(size)).intValue();
                                    if (iIntValue >= 0 && iIntValue < spannableString.length()) {
                                        int i4 = iIntValue + 1;
                                        int length = spannableString.length();
                                        if (i4 > length) {
                                            i4 = length;
                                        }
                                        if (i4 > iIntValue) {
                                            try {
                                                spannableString.setSpan(new ForegroundColorSpan(iE), iIntValue, i4, 33);
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }
                                    if (i3 >= 0) {
                                        size = i3;
                                    }
                                }
                            }
                            ax3Var.b = spannableString;
                            break;
                        }
                    }
                }
                WeakReference weakReference = t01Var.L0;
                if (weakReference == null || weakReference.get() != arrayList) {
                    xk0Var.b = t01Var;
                    xk0Var.f = arrayList;
                    xk0Var.notifyDataSetInvalidated();
                    t01Var.L0 = new WeakReference(arrayList);
                } else {
                    xk0Var.notifyDataSetChanged();
                }
                codeEditor.getProps().getClass();
                Context context = codeEditor.getContext();
                if (context != null) {
                    Configuration configuration = context.getResources().getConfiguration();
                    if ((configuration.keyboard != 1 || configuration.hardKeyboardHidden == 1) && t01Var.M0 == -1) {
                        t01Var.g();
                    }
                }
                float count = xk0Var.getCount() * ((int) TypedValue.applyDimension(1, 45.0f, xk0Var.b.F0.getContext().getResources().getDisplayMetrics()));
                if (count == 0.0f) {
                    t01Var.f();
                }
                t01Var.k(true);
                int i5 = t01Var.D0;
                int iMin = (int) Math.min(count, t01Var.I0);
                t01Var.D0 = i5;
                t01Var.E0 = iMin;
                t01Var.a(false);
                codeEditor.a0(new r01(t01Var, i2), 10L);
                if (!t01Var.b.isShowing() && !t01Var.G0 && t01Var.T0) {
                    t01Var.R0 = System.currentTimeMillis();
                    final long j = t01Var.H0;
                    codeEditor.a0(new Runnable() { // from class: q01
                        @Override // java.lang.Runnable
                        public final void run() {
                            t01 t01Var2 = t01Var;
                            if (t01Var2.S0 >= t01Var2.R0 || t01Var2.H0 != j || t01Var2.b.isShowing()) {
                                return;
                            }
                            t01Var2.a(true);
                        }
                    }, 70L);
                    break;
                }
                break;
            default:
                t01Var.f();
                break;
        }
    }
}

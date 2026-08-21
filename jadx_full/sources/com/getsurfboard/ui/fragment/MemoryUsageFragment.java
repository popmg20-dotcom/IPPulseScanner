package com.getsurfboard.ui.fragment;

import android.os.Bundle;
import android.os.Debug;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.o;
import com.getsurfboard.R;
import com.getsurfboard.ui.widget.SparklineView;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.chip.Chip;
import com.google.android.material.textview.MaterialTextView;
import defpackage.d70;
import defpackage.dk1;
import defpackage.eu;
import defpackage.f33;
import defpackage.gb4;
import defpackage.ji0;
import defpackage.mk;
import defpackage.mt;
import defpackage.uf2;
import defpackage.vf2;
import defpackage.w3;
import defpackage.zo2;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class MemoryUsageFragment extends o {
    public dk1 b;
    public final Debug.MemoryInfo f = new Debug.MemoryInfo();
    public final f33 z = new f33(18, this);
    public final ArrayList A = new ArrayList();

    public static String j(String str, Debug.MemoryInfo memoryInfo) {
        String memoryStat = memoryInfo.getMemoryStat(str);
        try {
            memoryStat.getClass();
            eu euVarQ = ji0.q(((long) Integer.parseInt(memoryStat)) * 1024, false);
            return euVarQ.a + " " + euVarQ.b;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return memoryStat + "kB";
        }
    }

    @Override // androidx.fragment.app.o
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View viewInflate = layoutInflater.inflate(R.layout.fragment_memory_usage, viewGroup, false);
        int i = R.id.code_title;
        if (((TextView) vf2.l(viewInflate, R.id.code_title)) != null) {
            i = R.id.code_value;
            TextView textView = (TextView) vf2.l(viewInflate, R.id.code_value);
            if (textView != null) {
                i = R.id.gc;
                Chip chip = (Chip) vf2.l(viewInflate, R.id.gc);
                if (chip != null) {
                    i = R.id.graphic_title;
                    if (((TextView) vf2.l(viewInflate, R.id.graphic_title)) != null) {
                        i = R.id.graphic_value;
                        TextView textView2 = (TextView) vf2.l(viewInflate, R.id.graphic_value);
                        if (textView2 != null) {
                            i = R.id.java_heap_title;
                            if (((TextView) vf2.l(viewInflate, R.id.java_heap_title)) != null) {
                                i = R.id.java_heap_value;
                                TextView textView3 = (TextView) vf2.l(viewInflate, R.id.java_heap_value);
                                if (textView3 != null) {
                                    i = R.id.native_heap_title;
                                    if (((TextView) vf2.l(viewInflate, R.id.native_heap_title)) != null) {
                                        i = R.id.native_heap_value;
                                        TextView textView4 = (TextView) vf2.l(viewInflate, R.id.native_heap_value);
                                        if (textView4 != null) {
                                            i = R.id.private_other_title;
                                            if (((TextView) vf2.l(viewInflate, R.id.private_other_title)) != null) {
                                                i = R.id.private_other_value;
                                                TextView textView5 = (TextView) vf2.l(viewInflate, R.id.private_other_value);
                                                if (textView5 != null) {
                                                    i = R.id.share_hprof;
                                                    Chip chip2 = (Chip) vf2.l(viewInflate, R.id.share_hprof);
                                                    if (chip2 != null) {
                                                        i = R.id.share_oom;
                                                        Chip chip3 = (Chip) vf2.l(viewInflate, R.id.share_oom);
                                                        if (chip3 != null) {
                                                            i = R.id.spark;
                                                            SparklineView sparklineView = (SparklineView) vf2.l(viewInflate, R.id.spark);
                                                            if (sparklineView != null) {
                                                                i = R.id.stack_title;
                                                                if (((TextView) vf2.l(viewInflate, R.id.stack_title)) != null) {
                                                                    i = R.id.stack_value;
                                                                    TextView textView6 = (TextView) vf2.l(viewInflate, R.id.stack_value);
                                                                    if (textView6 != null) {
                                                                        i = R.id.system_title;
                                                                        if (((TextView) vf2.l(viewInflate, R.id.system_title)) != null) {
                                                                            i = R.id.system_value;
                                                                            TextView textView7 = (TextView) vf2.l(viewInflate, R.id.system_value);
                                                                            if (textView7 != null) {
                                                                                i = R.id.title;
                                                                                if (((MaterialTextView) vf2.l(viewInflate, R.id.title)) != null) {
                                                                                    i = R.id.total_pss_title;
                                                                                    if (((TextView) vf2.l(viewInflate, R.id.total_pss_title)) != null) {
                                                                                        i = R.id.total_pss_value;
                                                                                        TextView textView8 = (TextView) vf2.l(viewInflate, R.id.total_pss_value);
                                                                                        if (textView8 != null) {
                                                                                            i = R.id.total_swap_title;
                                                                                            if (((TextView) vf2.l(viewInflate, R.id.total_swap_title)) != null) {
                                                                                                i = R.id.total_swap_value;
                                                                                                TextView textView9 = (TextView) vf2.l(viewInflate, R.id.total_swap_value);
                                                                                                if (textView9 != null) {
                                                                                                    MaterialCardView materialCardView = (MaterialCardView) viewInflate;
                                                                                                    this.b = new dk1(materialCardView, textView, chip, textView2, textView3, textView4, textView5, chip2, chip3, sparklineView, textView6, textView7, textView8, textView9);
                                                                                                    materialCardView.getClass();
                                                                                                    return materialCardView;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        return null;
    }

    @Override // androidx.fragment.app.o
    public final void onDestroyView() {
        requireView().removeCallbacks(this.z);
        super.onDestroyView();
        this.b = null;
    }

    @Override // androidx.fragment.app.o
    public final void onViewCreated(View view, Bundle bundle) {
        view.getClass();
        int i = 0;
        int iX = d70.X(gb4.d0(0, 90));
        while (true) {
            ArrayList arrayList = this.A;
            if (i >= iX) {
                dk1 dk1Var = this.b;
                dk1Var.getClass();
                ((SparklineView) dk1Var.m).setValues(arrayList);
                view.post(this.z);
                dk1 dk1Var2 = this.b;
                dk1Var2.getClass();
                dk1Var2.b.setOnClickListener(new w3(4));
                dk1 dk1Var3 = this.b;
                dk1Var3.getClass();
                int i2 = 13;
                dk1Var3.f.setOnClickListener(new mk(i2, this));
                ji0.B(uf2.t(this), null, null, new mt(this, null, i2), 3);
                return;
            }
            arrayList.add(Float.valueOf(0.0f));
            i++;
        }
    }
}

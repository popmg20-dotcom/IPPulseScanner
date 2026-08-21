package defpackage;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class t40 implements ViewGroup.OnHierarchyChangeListener {
    public ViewGroup.OnHierarchyChangeListener b;
    public final /* synthetic */ ChipGroup f;

    public t40(ChipGroup chipGroup) {
        this.f = chipGroup;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public final void onChildViewAdded(View view, View view2) {
        ChipGroup chipGroup = this.f;
        if (view == chipGroup && (view2 instanceof Chip)) {
            if (view2.getId() == -1) {
                view2.setId(View.generateViewId());
            }
            a40 a40Var = chipGroup.B0;
            Chip chip = (Chip) view2;
            ((HashMap) a40Var.z).put(Integer.valueOf(chip.getId()), chip);
            if (chip.isChecked()) {
                a40Var.a(chip);
            }
            chip.setInternalOnCheckedChangeListener(new zf2(13, a40Var));
        }
        ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.b;
        if (onHierarchyChangeListener != null) {
            onHierarchyChangeListener.onChildViewAdded(view, view2);
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public final void onChildViewRemoved(View view, View view2) {
        ChipGroup chipGroup = this.f;
        if (view == chipGroup && (view2 instanceof Chip)) {
            a40 a40Var = chipGroup.B0;
            Chip chip = (Chip) view2;
            a40Var.getClass();
            chip.setInternalOnCheckedChangeListener(null);
            ((HashMap) a40Var.z).remove(Integer.valueOf(chip.getId()));
            ((HashSet) a40Var.A).remove(Integer.valueOf(chip.getId()));
        }
        ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.b;
        if (onHierarchyChangeListener != null) {
            onHierarchyChangeListener.onChildViewRemoved(view, view2);
        }
    }
}

package defpackage;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import androidx.work.impl.WorkDatabase;
import com.getsurfboard.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.chip.Chip;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textview.MaterialTextView;
import j$.util.DesugarCollections;
import j$.util.Optional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class uf4 {
    public final Object a;
    public final Object b;
    public final Object c;
    public final Object d;
    public final Object e;
    public final Object f;
    public Object g;

    public uf4(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.d = layoutParams;
        this.e = new Rect();
        this.f = new int[2];
        this.g = new int[2];
        this.b = context;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.abc_tooltip, (ViewGroup) null);
        this.a = viewInflate;
        this.c = (TextView) viewInflate.findViewById(R.id.message);
        layoutParams.setTitle(uf4.class.getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R.style.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }

    public uf4(TextView textView, HorizontalScrollView horizontalScrollView, ImageView imageView, TextView textView2, Chip chip, ConstraintLayout constraintLayout, Chip chip2) {
        this.c = textView;
        this.b = horizontalScrollView;
        this.a = imageView;
        this.d = textView2;
        this.e = chip;
        this.f = constraintLayout;
        this.g = chip2;
    }

    public uf4(FragmentContainerView fragmentContainerView, FloatingActionButton floatingActionButton, MaterialTextView materialTextView, View view, RecyclerView recyclerView, CoordinatorLayout coordinatorLayout, MaterialToolbar materialToolbar) {
        this.b = fragmentContainerView;
        this.c = floatingActionButton;
        this.d = materialTextView;
        this.a = view;
        this.e = recyclerView;
        this.f = coordinatorLayout;
        this.g = materialToolbar;
    }

    public uf4(CoordinatorLayout coordinatorLayout, TextView textView, ViewPager2 viewPager2, TabLayout tabLayout, FloatingActionButton floatingActionButton, Toolbar toolbar, ImageButton imageButton) {
        this.b = coordinatorLayout;
        this.c = textView;
        this.a = viewPager2;
        this.d = tabLayout;
        this.e = floatingActionButton;
        this.f = toolbar;
        this.g = imageButton;
    }

    public uf4(String str, String str2, Set set) {
        Set setUnmodifiableSet = set == null ? Collections.EMPTY_SET : DesugarCollections.unmodifiableSet(set);
        this.b = setUnmodifiableSet;
        Map map = Collections.EMPTY_MAP;
        this.c = map;
        this.d = str;
        this.e = str2;
        this.f = lw3.a;
        HashSet hashSet = new HashSet(setUnmodifiableSet);
        Iterator it = map.values().iterator();
        if (!it.hasNext()) {
            this.a = DesugarCollections.unmodifiableSet(hashSet);
            return;
        }
        throw dw2.z(it);
    }

    public uf4(HashMap map, cm cmVar, cm cmVar2, cm cmVar3, bd2 bd2Var, HashMap map2, Optional optional, v62 v62Var) {
        this.b = map;
        this.a = cmVar;
        this.c = cmVar2;
        this.d = cmVar3;
        this.e = bd2Var;
        this.f = optional;
        this.g = v62Var;
    }

    public uf4(Context context, na0 na0Var, ih4 ih4Var, n53 n53Var, WorkDatabase workDatabase, gx4 gx4Var, ArrayList arrayList) {
        context.getClass();
        n53Var.getClass();
        this.a = na0Var;
        this.c = ih4Var;
        this.d = n53Var;
        this.e = workDatabase;
        this.f = gx4Var;
        this.g = arrayList;
        Context applicationContext = context.getApplicationContext();
        applicationContext.getClass();
        this.b = applicationContext;
    }
}

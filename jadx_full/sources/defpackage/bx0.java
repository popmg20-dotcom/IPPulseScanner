package defpackage;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.ui.activity.ProfileEditorActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import com.google.android.material.textview.MaterialTextView;
import io.netty.handler.codec.http.multipart.HttpPostBodyUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bx0 extends rb2 {
    public final /* synthetic */ int e = 2;
    public final Object f;
    public Object g;

    public bx0(cd cdVar) {
        super(bg4.a);
        this.f = cdVar;
        this.g = new HashMap();
    }

    public static void t(View view, zk zkVar, boolean z) {
        xf2 xf2VarJ;
        Uri uriC = g73.c(zkVar.getName());
        if (uriC != null) {
            if (!t23.c(R.string.setting_use_external_editor_key, false)) {
                int i = ProfileEditorActivity.Y0;
                k01.v(view, zkVar.getName(), uriC, z, false);
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(uriC, HttpPostBodyUtil.DEFAULT_TEXT_CONTENT_TYPE);
            intent.addFlags(1);
            if (zkVar.j() == null || ((xf2VarJ = zkVar.j()) != null && xf2VarJ.a())) {
                intent.addFlags(2);
            }
            try {
                view.getContext().startActivity(intent);
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
                int i2 = ProfileEditorActivity.Y0;
                k01.v(view, zkVar.getName(), uriC, z, false);
            }
        }
    }

    public static void v(Context context, h03 h03Var) {
        wh2 wh2Var = new wh2(context);
        p6 p6Var = (p6) wh2Var.z;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        layoutInflaterFrom.getClass();
        View viewInflate = layoutInflaterFrom.inflate(R.layout.layout_autolink_dialog, (ViewGroup) null, false);
        if (viewInflate == null) {
            zo2.n("rootView");
            return;
        }
        TextView textView = (TextView) viewInflate;
        textView.setText(h03Var.z);
        p6Var.e = h03Var.f;
        Integer numV = ji0.v(h03Var.A);
        if (numV != null) {
            p6Var.c = numV.intValue();
        }
        wh2Var.y(textView);
        wh2Var.w(R.string.i_got_it, null);
        wh2Var.r();
    }

    @Override // defpackage.rf3
    public final void g(rg3 rg3Var, final int i) {
        boolean z;
        Object obj;
        w0 w0Var;
        Object obj2;
        w0 w0Var2;
        int i2 = 5;
        int i3 = 2;
        switch (this.e) {
            case 0:
                final ax0 ax0Var = (ax0) rg3Var;
                final String str = (String) q(i);
                n02 n02Var = ax0Var.u;
                ((MaterialTextView) n02Var.A).setText(str);
                ((ConstraintLayout) n02Var.f).setOnClickListener(new yw0(i, 0, this, str));
                ((MaterialButton) n02Var.z).setOnClickListener(new View.OnClickListener() { // from class: zw0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        el1 el1Var = (el1) this.b.g;
                        view.getClass();
                        ConstraintLayout constraintLayout = (ConstraintLayout) ax0Var.u.f;
                        constraintLayout.getClass();
                        Integer numValueOf = Integer.valueOf(i);
                        String str2 = str;
                        str2.getClass();
                        el1Var.i(view, constraintLayout, numValueOf, str2);
                    }
                });
                return;
            case 1:
                z63 z63Var = (z63) rg3Var;
                final zk zkVar = (zk) q(i);
                final dk1 dk1Var = z63Var.u;
                ImageView imageView = (ImageView) dk1Var.l;
                ConstraintLayout constraintLayout = (ConstraintLayout) dk1Var.j;
                FrameLayout frameLayout = (FrameLayout) dk1Var.m;
                String name = zkVar.getName();
                String[] strArr = t23.a;
                name.getClass();
                if (t23.k().contains(name)) {
                    Context context = frameLayout.getContext();
                    context.getClass();
                    constraintLayout.setBackgroundColor(u70.e(ContextUtilsKt.d(context, R.attr.colorSecondaryContainer), 64));
                    imageView.setVisibility(0);
                } else {
                    constraintLayout.setBackgroundColor(0);
                    imageView.setVisibility(8);
                }
                TextView textView = dk1Var.e;
                ImageView imageView2 = (ImageView) dk1Var.k;
                TextView textView2 = dk1Var.a;
                RadioButton radioButton = (RadioButton) dk1Var.i;
                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) dk1Var.h;
                Chip chip = dk1Var.g;
                Chip chip2 = dk1Var.f;
                Chip chip3 = dk1Var.b;
                boolean z2 = false;
                textView.setVisibility(n12.c(zkVar.getName(), (String) this.g) ? 0 : 8);
                radioButton.setOnCheckedChangeListener(null);
                radioButton.setChecked(n12.c(zkVar.getName(), i73.a()));
                dk1Var.d.setText(zkVar.getName());
                boolean z3 = zkVar instanceof t53;
                if (z3) {
                    t53 t53Var = (t53) zkVar;
                    Integer numValueOf = Integer.valueOf(t53Var.D0.size());
                    Integer numValueOf2 = Integer.valueOf(t53Var.F0.size());
                    int size = t53Var.G0.size();
                    HashSet hashSet = new HashSet();
                    z = z3;
                    Collection collectionValues = t53Var.H0.values();
                    collectionValues.getClass();
                    for (Iterator it = collectionValues.iterator(); it.hasNext(); it = it) {
                        hashSet.addAll(((na3) it.next()).y().values());
                    }
                    Integer numValueOf3 = Integer.valueOf(hashSet.size() + size);
                    HashSet hashSet2 = new HashSet();
                    int iD = 0;
                    for (Iterator it2 = t53Var.J0.iterator(); it2.hasNext(); it2 = it2) {
                        iD = t53.d((tn3) it2.next(), hashSet2) + iD;
                    }
                    textView2.setText(ContextUtilsKt.l(R.string.profile_desc_template, numValueOf, numValueOf2, numValueOf3, Integer.valueOf(iD)));
                    frameLayout.getClass();
                    Iterator w0Var3 = new w0(3, frameLayout);
                    ArrayList arrayList = new ArrayList();
                    while (w0Var3.hasNext()) {
                        Object next = w0Var3.next();
                        View view = (View) next;
                        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
                        if (viewGroup != null) {
                            obj2 = next;
                            w0Var2 = new w0(3, viewGroup);
                        } else {
                            obj2 = next;
                            w0Var2 = null;
                        }
                        if (w0Var2 == null || !w0Var2.hasNext()) {
                            while (!w0Var3.hasNext() && !arrayList.isEmpty()) {
                                w0Var3 = (Iterator) d70.k0(arrayList);
                                d70.p0(arrayList);
                            }
                        } else {
                            arrayList.add(w0Var3);
                            w0Var3 = w0Var2;
                        }
                        ((View) obj2).setEnabled(true);
                    }
                    frameLayout.setOnClickListener(new mk(17, dk1Var));
                } else {
                    z = z3;
                    if (zkVar instanceof p12) {
                        String strK = ((p12) zkVar).X;
                        if (strK == null) {
                            strK = ContextUtilsKt.k(R.string.invalid_profile);
                        }
                        textView2.setText(strK);
                        frameLayout.getClass();
                        Iterator w0Var4 = new w0(3, frameLayout);
                        ArrayList arrayList2 = new ArrayList();
                        while (w0Var4.hasNext()) {
                            Object next2 = w0Var4.next();
                            View view2 = (View) next2;
                            ViewGroup viewGroup2 = view2 instanceof ViewGroup ? (ViewGroup) view2 : null;
                            if (viewGroup2 != null) {
                                obj = next2;
                                w0Var = new w0(3, viewGroup2);
                            } else {
                                obj = next2;
                                w0Var = null;
                            }
                            if (w0Var == null || !w0Var.hasNext()) {
                                while (!w0Var4.hasNext() && !arrayList2.isEmpty()) {
                                    w0Var4 = (Iterator) d70.k0(arrayList2);
                                    d70.p0(arrayList2);
                                }
                            } else {
                                arrayList2.add(w0Var4);
                                w0Var4 = w0Var;
                            }
                            View view3 = (View) obj;
                            if (!n12.c(view3, imageView2)) {
                                view3.setEnabled(z2);
                            }
                            z2 = false;
                        }
                        frameLayout.setOnClickListener(new mk(18, this));
                    }
                }
                if (!t23.c(R.string.setting_profile_list_actions_key, true) || (zkVar instanceof p12)) {
                    chip3.setVisibility(8);
                    chip.setVisibility(8);
                    chip2.setVisibility(8);
                } else {
                    if (zkVar.j() != null) {
                        final int i4 = 0;
                        chip.setVisibility(0);
                        chip3.setVisibility(8);
                        chip.setOnClickListener(new View.OnClickListener(this) { // from class: l73
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view4) {
                                int i5 = i4;
                                zk zkVar2 = zkVar;
                                dk1 dk1Var2 = dk1Var;
                                switch (i5) {
                                    case 0:
                                        FrameLayout frameLayout2 = (FrameLayout) dk1Var2.m;
                                        frameLayout2.getClass();
                                        bx0.t(frameLayout2, zkVar2, false);
                                        break;
                                    default:
                                        FrameLayout frameLayout3 = (FrameLayout) dk1Var2.m;
                                        frameLayout3.getClass();
                                        bx0.t(frameLayout3, zkVar2, true);
                                        break;
                                }
                            }
                        });
                        chip2.setVisibility(0);
                        chip2.setOnClickListener(new kd(5, this, zkVar));
                    } else {
                        chip.setVisibility(8);
                        chip3.setVisibility(0);
                        final int i5 = 1;
                        chip3.setOnClickListener(new View.OnClickListener(this) { // from class: l73
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view4) {
                                int i52 = i5;
                                zk zkVar2 = zkVar;
                                dk1 dk1Var2 = dk1Var;
                                switch (i52) {
                                    case 0:
                                        FrameLayout frameLayout2 = (FrameLayout) dk1Var2.m;
                                        frameLayout2.getClass();
                                        bx0.t(frameLayout2, zkVar2, false);
                                        break;
                                    default:
                                        FrameLayout frameLayout3 = (FrameLayout) dk1Var2.m;
                                        frameLayout3.getClass();
                                        bx0.t(frameLayout3, zkVar2, true);
                                        break;
                                }
                            }
                        });
                        chip2.setVisibility(8);
                    }
                    int i6 = 0;
                    while (i6 < linearLayoutCompat.getChildCount()) {
                        int i7 = i6 + 1;
                        View childAt = linearLayoutCompat.getChildAt(i6);
                        if (childAt == null) {
                            throw new IndexOutOfBoundsException();
                        }
                        if (!childAt.equals(chip) && !childAt.equals(chip3) && !childAt.equals(chip2)) {
                            linearLayoutCompat.removeView(childAt);
                        }
                        i6 = i7;
                    }
                    if (z) {
                        for (h03 h03Var : ((t53) zkVar).L0) {
                            frameLayout.getClass();
                            View viewInflate = ContextUtilsKt.f(frameLayout).inflate(R.layout.item_profile_panel, (ViewGroup) linearLayoutCompat, false);
                            if (viewInflate == null) {
                                zo2.n("rootView");
                                return;
                            }
                            Chip chip4 = (Chip) viewInflate;
                            Integer numV = ji0.v(h03Var.A);
                            chip4.setChipIconResource(numV != null ? numV.intValue() : R.drawable.ic_round_info_24);
                            chip4.setText(h03Var.f);
                            chip4.setOnClickListener(new mk(19, this, h03Var));
                            linearLayoutCompat.addView(chip4);
                        }
                    }
                }
                long jW = zkVar.W();
                z63Var.v = jW;
                dk1Var.c.setText(ContextUtilsKt.l(R.string.last_modified_template, DateUtils.getRelativeTimeSpanString(jW)));
                imageView2.setOnClickListener(new d81(3, this, dk1Var, zkVar));
                radioButton.setOnCheckedChangeListener(new ni(i3, this, zkVar));
                frameLayout.setOnLongClickListener(new View.OnLongClickListener() { // from class: m73
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view4) {
                        xb5.c("profile item long clicked");
                        this.b.u(dk1Var, zkVar);
                        return true;
                    }
                });
                return;
            default:
                Integer numValueOf4 = Integer.valueOf(android.R.drawable.sym_def_app_icon);
                e22 e22Var = ((js1) rg3Var).u;
                ConstraintLayout constraintLayout2 = e22Var.a;
                TextView textView3 = e22Var.c;
                ImageView imageView3 = e22Var.b;
                Context context2 = constraintLayout2.getContext();
                pd pdVar = (pd) q(i);
                HashMap map = (HashMap) this.g;
                Integer numValueOf5 = Integer.valueOf(pdVar.a);
                Object nameForUid = map.get(numValueOf5);
                if (nameForUid == null) {
                    nameForUid = ContextUtilsKt.h().getNameForUid(pdVar.a);
                    if (nameForUid == null) {
                        nameForUid = "Unknown";
                    }
                    map.put(numValueOf5, nameForUid);
                }
                String str2 = (String) nameForUid;
                PackageInfo packageInfoG = ContextUtilsKt.g(str2);
                if (packageInfoG != null) {
                    context2.getClass();
                    te3 te3VarO = t60.o(context2);
                    qy1 qy1Var = new qy1(context2);
                    qy1Var.c = packageInfoG;
                    qy1Var.d(imageView3);
                    qy1Var.i = numValueOf4;
                    qy1Var.c();
                    te3VarO.a(qy1Var.a());
                    ApplicationInfo applicationInfo = packageInfoG.applicationInfo;
                    textView3.setText(applicationInfo != null ? ContextUtilsKt.h().getApplicationLabel(applicationInfo) : packageInfoG.packageName);
                    str2 = packageInfoG.packageName;
                } else {
                    te3 te3VarO2 = t60.o(imageView3.getContext());
                    qy1 qy1Var2 = new qy1(imageView3.getContext());
                    qy1Var2.c = numValueOf4;
                    qy1Var2.d(imageView3);
                    te3VarO2.a(qy1Var2.a());
                    textView3.setText(str2);
                }
                str2.getClass();
                TextView textView4 = e22Var.d;
                eu euVarQ = ji0.q(pdVar.d, true);
                String strConcat = euVarQ.a.concat(euVarQ.b);
                eu euVarQ2 = ji0.q(pdVar.e, true);
                textView4.setText(ContextUtilsKt.l(R.string.traffic_list_speed_template, strConcat, euVarQ2.a.concat(euVarQ2.b)));
                TextView textView5 = e22Var.e;
                eu euVarQ3 = ji0.q(pdVar.b, true);
                String strConcat2 = euVarQ3.a.concat(euVarQ3.b);
                eu euVarQ4 = ji0.q(pdVar.c, true);
                textView5.setText(ContextUtilsKt.l(R.string.traffic_list_traffic_template, strConcat2, euVarQ4.a.concat(euVarQ4.b)));
                constraintLayout2.setOnClickListener(new d81(i2, this, pdVar, str2));
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x011f A[PHI: r5
      0x011f: PHI (r5v4 int) = (r5v3 int), (r5v5 int), (r5v6 int), (r5v7 int), (r5v8 int), (r5v9 int), (r5v10 int), (r5v11 int) binds: [B:17:0x007f, B:19:0x008a, B:21:0x0096, B:23:0x00a2, B:25:0x00ae, B:27:0x00ba, B:29:0x00c6, B:31:0x00d2] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // defpackage.rf3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final rg3 i(ViewGroup viewGroup, int i) {
        int i2 = this.e;
        int i3 = R.id.name;
        switch (i2) {
            case 0:
                View viewInflate = ContextUtilsKt.f(viewGroup).inflate(R.layout.item_doh_server, viewGroup, false);
                int i4 = R.id.btn_menu;
                MaterialButton materialButton = (MaterialButton) vf2.l(viewInflate, R.id.btn_menu);
                if (materialButton != null) {
                    i4 = R.id.url;
                    MaterialTextView materialTextView = (MaterialTextView) vf2.l(viewInflate, R.id.url);
                    if (materialTextView != null) {
                    }
                }
                zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i4)));
                break;
            case 1:
                View viewInflate2 = ContextUtilsKt.f(viewGroup).inflate(R.layout.item_profile, viewGroup, false);
                int i5 = R.id.actions_container;
                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) vf2.l(viewInflate2, R.id.actions_container);
                if (linearLayoutCompat != null) {
                    i5 = R.id.actions_scrollview;
                    if (((HorizontalScrollView) vf2.l(viewInflate2, R.id.actions_scrollview)) != null) {
                        i5 = R.id.check;
                        RadioButton radioButton = (RadioButton) vf2.l(viewInflate2, R.id.check);
                        if (radioButton != null) {
                            i5 = R.id.constraint;
                            ConstraintLayout constraintLayout = (ConstraintLayout) vf2.l(viewInflate2, R.id.constraint);
                            if (constraintLayout != null) {
                                i5 = R.id.desc;
                                TextView textView = (TextView) vf2.l(viewInflate2, R.id.desc);
                                if (textView != null) {
                                    i5 = R.id.edit;
                                    Chip chip = (Chip) vf2.l(viewInflate2, R.id.edit);
                                    if (chip != null) {
                                        i5 = R.id.last_modify;
                                        TextView textView2 = (TextView) vf2.l(viewInflate2, R.id.last_modify);
                                        if (textView2 != null) {
                                            i5 = R.id.more;
                                            ImageView imageView = (ImageView) vf2.l(viewInflate2, R.id.more);
                                            if (imageView != null) {
                                                TextView textView3 = (TextView) vf2.l(viewInflate2, R.id.name);
                                                if (textView3 != null) {
                                                    i3 = R.id.new_icon;
                                                    TextView textView4 = (TextView) vf2.l(viewInflate2, R.id.new_icon);
                                                    if (textView4 != null) {
                                                        i3 = R.id.pin;
                                                        ImageView imageView2 = (ImageView) vf2.l(viewInflate2, R.id.pin);
                                                        if (imageView2 != null) {
                                                            FrameLayout frameLayout = (FrameLayout) viewInflate2;
                                                            i3 = R.id.update;
                                                            Chip chip2 = (Chip) vf2.l(viewInflate2, R.id.update);
                                                            if (chip2 != null) {
                                                                i3 = R.id.view;
                                                                Chip chip3 = (Chip) vf2.l(viewInflate2, R.id.view);
                                                                if (chip3 != null) {
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            } else {
                                                i3 = i5;
                                            }
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                zo2.n("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(i3)));
                break;
            default:
                View viewInflate3 = ContextUtilsKt.f(viewGroup).inflate(R.layout.item_traffic_list, viewGroup, false);
                ImageView imageView3 = (ImageView) vf2.l(viewInflate3, R.id.icon);
                if (imageView3 != null) {
                    TextView textView5 = (TextView) vf2.l(viewInflate3, R.id.name);
                    if (textView5 != null) {
                        i3 = R.id.speed;
                        TextView textView6 = (TextView) vf2.l(viewInflate3, R.id.speed);
                        if (textView6 != null) {
                            i3 = R.id.traffic;
                            TextView textView7 = (TextView) vf2.l(viewInflate3, R.id.traffic);
                            if (textView7 != null) {
                            }
                        }
                    }
                } else {
                    i3 = R.id.icon;
                }
                zo2.n("Missing required view with ID: ".concat(viewInflate3.getResources().getResourceName(i3)));
                break;
        }
        return null;
    }

    public void u(dk1 dk1Var, zk zkVar) {
        Context context = ((FrameLayout) dk1Var.m).getContext();
        context.getClass();
        z10 z10Var = new z10(context, (ImageView) dk1Var.k, new iv1(new fn(15, dk1Var), 14));
        Context context2 = z10Var.a;
        a64 a64Var = new a64(context2);
        nk2 nk2Var = z10Var.g;
        a64Var.inflate(R.menu.profile_menu, nk2Var);
        xf2 xf2VarJ = zkVar.j();
        HashMap map = new HashMap();
        if (zkVar instanceof p12) {
            nk2Var.findItem(R.id.view).setVisible(false);
            if (xf2VarJ == null) {
                nk2Var.findItem(R.id.update).setVisible(false);
                nk2Var.findItem(R.id.copy_url).setVisible(false);
                nk2Var.findItem(R.id.qrcode).setVisible(false);
            }
        } else {
            nk2Var.findItem(R.id.copy_invalid_reason).setVisible(false);
            if (xf2VarJ != null) {
                nk2Var.findItem(R.id.edit).setVisible(false);
            } else {
                nk2Var.findItem(R.id.view).setVisible(false);
                nk2Var.findItem(R.id.update).setVisible(false);
                nk2Var.findItem(R.id.copy_url).setVisible(false);
                nk2Var.findItem(R.id.qrcode).setVisible(false);
            }
            if (zkVar instanceof t53) {
                Iterator it = ((t53) zkVar).L0.iterator();
                it.getClass();
                while (it.hasNext()) {
                    h03 h03Var = (h03) it.next();
                    int iGenerateViewId = View.generateViewId();
                    sk2 sk2VarA = nk2Var.a(0, iGenerateViewId, 0, h03Var.f);
                    Integer numV = ji0.v(h03Var.A);
                    sk2VarA.setIcon(numV != null ? numV.intValue() : R.drawable.ic_round_info_24);
                    map.put(Integer.valueOf(iGenerateViewId), h03Var);
                }
            }
        }
        String name = zkVar.getName();
        String[] strArr = t23.a;
        name.getClass();
        if (t23.k().contains(name)) {
            nk2Var.findItem(R.id.pin).setVisible(false);
            nk2Var.findItem(R.id.unpin).setVisible(true);
        } else {
            nk2Var.findItem(R.id.pin).setVisible(true);
            nk2Var.findItem(R.id.unpin).setVisible(false);
        }
        nk2Var.e = new jf4(1, new ka2(this, dk1Var, zkVar, xf2VarJ, map));
        int i = z10Var.d;
        a20 a20Var = z10Var.f;
        a20Var.setWidth(i);
        Rect rect = a20Var.b;
        a20Var.setHeight(-2);
        int iE = ek0.e(context2, 4);
        int iE2 = ek0.e(context2, 4);
        int iE3 = ek0.e(context2, 4);
        int i2 = rect.top;
        if (a20Var.isShowing()) {
            xe.q("Can't change once the popup is already visible.");
            return;
        }
        rect.set(iE, i2, iE2, iE3);
        Drawable drawable = (Drawable) ((pl1) z10Var.c.f).a();
        if (drawable != null) {
            a20Var.getContentView().setBackground(drawable);
        }
        z10Var.a(nk2Var, true);
        a20Var.showAsDropDown(z10Var.b, 0, 0, 0);
    }

    public bx0(op opVar, el1 el1Var) {
        super(cx0.a);
        this.f = opVar;
        this.g = el1Var;
    }

    public bx0(wn1 wn1Var) {
        super(d63.l);
        this.f = wn1Var;
    }
}

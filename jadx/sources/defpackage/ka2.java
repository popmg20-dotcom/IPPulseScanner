package defpackage;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import io.netty.handler.codec.http.multipart.HttpPostBodyUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ka2 implements jd0, f23 {
    public final /* synthetic */ Object A;
    public final /* synthetic */ Object X;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object z;

    public /* synthetic */ ka2(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        this.b = obj;
        this.f = obj2;
        this.z = obj3;
        this.A = obj4;
        this.X = obj5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.f23
    public boolean a(sk2 sk2Var) {
        bx0 bx0Var = (bx0) this.b;
        wn1 wn1Var = (wn1) bx0Var.f;
        FrameLayout frameLayout = (FrameLayout) ((dk1) this.f).m;
        zk zkVar = (zk) this.z;
        xf2 xf2Var = (xf2) this.A;
        HashMap map = (HashMap) this.X;
        int i = sk2Var.a;
        final int i2 = 1;
        if (i == R.id.edit) {
            xb5.c("profile item edit clicked");
            frameLayout.getClass();
            bx0.t(frameLayout, zkVar, true);
            return true;
        }
        boolean z = false;
        Object[] objArr = 0;
        if (i == R.id.view) {
            xb5.c("profile item view clicked");
            frameLayout.getClass();
            bx0.t(frameLayout, zkVar, false);
            return true;
        }
        if (i == R.id.share_file) {
            xb5.c("profile item share_file clicked");
            Context context = frameLayout.getContext();
            context.getClass();
            Uri uriC = g73.c(zkVar.getName());
            if (uriC != null) {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.STREAM", uriC);
                intent.setType(HttpPostBodyUtil.DEFAULT_TEXT_CONTENT_TYPE);
                intent.addFlags(1);
                try {
                    context.startActivity(Intent.createChooser(intent, ContextUtilsKt.k(R.string.share)));
                } catch (ActivityNotFoundException e) {
                    e.printStackTrace();
                    p95.C(R.string.share_failed, new Object[0]);
                }
            }
        } else if (i == R.id.delete) {
            xb5.c("profile item delete clicked");
            if (wn1Var != null) {
                String name = zkVar.getName();
                name.getClass();
                d83 d83Var = (d83) wn1Var.f;
                if (d83Var.getContext() != null) {
                    wh2 wh2Var = new wh2(d83Var.requireContext());
                    p6 p6Var = (p6) wh2Var.z;
                    p6Var.e = d83Var.getString(R.string.confirm_delete_profile_template, name);
                    wh2Var.w(R.string.delete, new li(9, d83Var, name));
                    wh2Var.u(R.string.cancel, new ph0(6));
                    p6Var.p = new ja1(3);
                    p6Var.o = new ka1(2);
                    u6 u6VarH = wh2Var.h();
                    u6VarH.setOnShowListener(new ai0(3));
                    u6VarH.show();
                    return true;
                }
            }
        } else {
            ge0 ge0Var = null;
            if (i == R.id.clone) {
                xb5.c("profile item clone clicked");
                if (wn1Var != null) {
                    String name2 = zkVar.getName();
                    name2.getClass();
                    d83 d83Var2 = (d83) wn1Var.f;
                    ji0.B(uf2.t(d83Var2), null, null, new uf(d83Var2, name2, ge0Var, 20), 3);
                    return true;
                }
            } else if (i == R.id.update) {
                xb5.c("profile item update clicked");
                if (wn1Var != null) {
                    String name3 = zkVar.getName();
                    xf2Var.getClass();
                    wn1Var.C(name3, xf2Var);
                    return true;
                }
            } else {
                if (i == R.id.rename) {
                    xb5.c("profile item rename clicked");
                    Context context2 = frameLayout.getContext();
                    context2.getClass();
                    new v62(17, context2, zkVar.getName(), z).O(new ed(14, bx0Var, zkVar));
                    return true;
                }
                if (i == R.id.copy_url) {
                    xb5.c("profile item copy_url clicked");
                    xf2Var.getClass();
                    co4.k(xf2Var.b);
                    p95.C(R.string.url_copied, new Object[0]);
                    return true;
                }
                if (i == R.id.qrcode) {
                    xb5.c("profile item qrcode clicked");
                    if (wn1Var != null) {
                        String name4 = zkVar.getName();
                        xf2Var.getClass();
                        String str = xf2Var.b;
                        name4.getClass();
                        str.getClass();
                        Bundle bundle = new Bundle();
                        bundle.putString("title", name4);
                        bundle.putString("content", str);
                        zb3 zb3Var = new zb3();
                        zb3Var.setArguments(bundle);
                        zb3Var.m(((d83) wn1Var.f).getChildFragmentManager(), null);
                        return true;
                    }
                } else if (i == R.id.copy_invalid_reason) {
                    xb5.c("profile item copy_invalid_reason clicked");
                    if (zkVar instanceof p12) {
                        String strK = ((p12) zkVar).X;
                        if (strK == null) {
                            strK = ContextUtilsKt.k(R.string.invalid_profile);
                        }
                        co4.k(strK);
                        p95.C(R.string.invalid_reason_copied, new Object[0]);
                        return true;
                    }
                } else {
                    List list = g41.b;
                    if (i == R.id.pin) {
                        xb5.c("profile item pin clicked");
                        if (wn1Var != null) {
                            final String name5 = zkVar.getName();
                            name5.getClass();
                            SharedPreferences.Editor editorEdit = t23.l().edit();
                            HashSet hashSet = new HashSet(t23.k());
                            hashSet.add(name5);
                            editorEdit.putStringSet("pinned_profile_list", hashSet);
                            editorEdit.apply();
                            final d83 d83Var3 = (d83) wn1Var.f;
                            List list2 = (List) d73.b.d();
                            if (list2 != null) {
                                list = list2;
                            }
                            final ArrayList arrayListN = d83.n(list);
                            d83Var3.A.s(arrayListN, new Runnable() { // from class: c83
                                @Override // java.lang.Runnable
                                public final void run() {
                                    int i3 = i2;
                                    int i4 = -1;
                                    int i5 = 0;
                                    String str2 = name5;
                                    d83 d83Var4 = d83Var3;
                                    ArrayList arrayList = arrayListN;
                                    switch (i3) {
                                        case 0:
                                            Iterator it = arrayList.iterator();
                                            while (true) {
                                                if (it.hasNext()) {
                                                    if (n12.c(((zk) it.next()).getName(), str2)) {
                                                        i4 = i5;
                                                    } else {
                                                        i5++;
                                                    }
                                                }
                                            }
                                            d83Var4.A.e(i4);
                                            break;
                                        default:
                                            Iterator it2 = arrayList.iterator();
                                            int i6 = 0;
                                            while (true) {
                                                if (it2.hasNext()) {
                                                    if (n12.c(((zk) it2.next()).getName(), str2)) {
                                                        i4 = i6;
                                                    } else {
                                                        i6++;
                                                    }
                                                }
                                            }
                                            d83Var4.A.e(i4);
                                            y3 y3Var = d83Var4.b;
                                            y3Var.getClass();
                                            ((RecyclerView) y3Var.j).l0(0);
                                            break;
                                    }
                                }
                            });
                            return true;
                        }
                    } else if (i == R.id.unpin) {
                        xb5.c("profile item unpin clicked");
                        if (wn1Var != null) {
                            final String name6 = zkVar.getName();
                            name6.getClass();
                            t23.F(name6);
                            final d83 d83Var4 = (d83) wn1Var.f;
                            List list3 = (List) d73.b.d();
                            if (list3 != null) {
                                list = list3;
                            }
                            final ArrayList arrayListN2 = d83.n(list);
                            bx0 bx0Var2 = d83Var4.A;
                            final Object[] objArr2 = objArr == true ? 1 : 0;
                            bx0Var2.s(arrayListN2, new Runnable() { // from class: c83
                                @Override // java.lang.Runnable
                                public final void run() {
                                    int i3 = objArr2;
                                    int i4 = -1;
                                    int i5 = 0;
                                    String str2 = name6;
                                    d83 d83Var42 = d83Var4;
                                    ArrayList arrayList = arrayListN2;
                                    switch (i3) {
                                        case 0:
                                            Iterator it = arrayList.iterator();
                                            while (true) {
                                                if (it.hasNext()) {
                                                    if (n12.c(((zk) it.next()).getName(), str2)) {
                                                        i4 = i5;
                                                    } else {
                                                        i5++;
                                                    }
                                                }
                                            }
                                            d83Var42.A.e(i4);
                                            break;
                                        default:
                                            Iterator it2 = arrayList.iterator();
                                            int i6 = 0;
                                            while (true) {
                                                if (it2.hasNext()) {
                                                    if (n12.c(((zk) it2.next()).getName(), str2)) {
                                                        i4 = i6;
                                                    } else {
                                                        i6++;
                                                    }
                                                }
                                            }
                                            d83Var42.A.e(i4);
                                            y3 y3Var = d83Var42.b;
                                            y3Var.getClass();
                                            ((RecyclerView) y3Var.j).l0(0);
                                            break;
                                    }
                                }
                            });
                            return true;
                        }
                    } else {
                        h03 h03Var = (h03) map.get(Integer.valueOf(i));
                        if (h03Var != null) {
                            Context context3 = frameLayout.getContext();
                            context3.getClass();
                            bx0.v(context3, h03Var);
                        }
                    }
                }
            }
        }
        return true;
    }

    @Override // defpackage.jd0
    public void b(int i, ud0 ud0Var, id0 id0Var) {
        la2 la2Var = (la2) this.b;
        jr2 jr2Var = (jr2) this.f;
        c03 c03Var = (c03) this.z;
        qn qnVar = (qn) this.A;
        qn qnVar2 = (qn) this.X;
        int iB = (int) jr2Var.b(ud0Var, 0, ud0Var.f, c03Var);
        la2Var.y0.c();
        List list = Collections.EMPTY_LIST;
        na2.f();
        if (!la2Var.b()) {
            id0Var.b = true;
        } else {
            qnVar.a(qnVar.e, iB);
            qnVar2.a(qnVar2.e, 0);
        }
    }
}

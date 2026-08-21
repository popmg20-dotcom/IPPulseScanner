package com.getsurfboard.ui.fragment.card;

import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.getsurfboard.R;
import com.getsurfboard.ui.fragment.card.PublicIPFragment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.loadingindicator.LoadingIndicator;
import com.google.android.material.textview.MaterialTextView;
import defpackage.am1;
import defpackage.cr2;
import defpackage.d73;
import defpackage.ek;
import defpackage.em2;
import defpackage.iv1;
import defpackage.mk;
import defpackage.p10;
import defpackage.rj2;
import defpackage.t23;
import defpackage.vf2;
import defpackage.w3;
import defpackage.yh0;
import defpackage.zo2;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class PublicIPFragment extends ek {
    public boolean A;
    public rj2 X;
    public iv1 f;
    public CharSequence z;

    public PublicIPFragment() {
        super(p10.z);
        this.z = "";
    }

    public final void j() {
        iv1 iv1Var = this.f;
        iv1Var.getClass();
        MaterialTextView materialTextView = (MaterialTextView) iv1Var.f;
        iv1 iv1Var2 = this.f;
        iv1Var2.getClass();
        materialTextView.setText(((MaterialTextView) iv1Var2.X).isActivated() ? this.z : "*.*.*.*");
        View view = getView();
        ViewParent parent = view != null ? view.getParent() : null;
        View view2 = parent instanceof View ? (View) parent : null;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams == null) {
                zo2.n("null cannot be cast to non-null type com.getsurfboard.ui.widget.MetroLayout.LayoutParams");
                return;
            }
            em2 em2Var = (em2) layoutParams;
            iv1 iv1Var3 = this.f;
            iv1Var3.getClass();
            em2Var.a = ((MaterialTextView) iv1Var3.f).getText().length() > 15 ? 2 : 1;
            view2.setLayoutParams(em2Var);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void k(boolean z) {
        iv1 iv1Var = this.f;
        int i = R.drawable.anim_to_visible;
        if (z) {
            iv1Var.getClass();
            if (((MaterialTextView) iv1Var.X).isActivated()) {
                i = R.drawable.anim_to_invisible;
            }
        } else {
            iv1Var.getClass();
            if (!((MaterialTextView) iv1Var.X).isActivated()) {
            }
        }
        iv1 iv1Var2 = this.f;
        iv1Var2.getClass();
        ((MaterialTextView) iv1Var2.X).setCompoundDrawablesRelativeWithIntrinsicBounds(i, 0, 0, 0);
    }

    @Override // androidx.fragment.app.o
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View viewInflate = layoutInflater.inflate(R.layout.fragment_public_ip, viewGroup, false);
        int i = R.id.ip;
        MaterialTextView materialTextView = (MaterialTextView) vf2.l(viewInflate, R.id.ip);
        if (materialTextView != null) {
            i = R.id.loading;
            LoadingIndicator loadingIndicator = (LoadingIndicator) vf2.l(viewInflate, R.id.loading);
            if (loadingIndicator != null) {
                i = R.id.retry;
                MaterialButton materialButton = (MaterialButton) vf2.l(viewInflate, R.id.retry);
                if (materialButton != null) {
                    i = R.id.title;
                    MaterialTextView materialTextView2 = (MaterialTextView) vf2.l(viewInflate, R.id.title);
                    if (materialTextView2 != null) {
                        MaterialCardView materialCardView = (MaterialCardView) viewInflate;
                        this.f = new iv1(materialCardView, materialTextView, loadingIndicator, materialButton, materialTextView2, 18);
                        materialCardView.getClass();
                        return materialCardView;
                    }
                }
            }
        }
        zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        return null;
    }

    @Override // androidx.fragment.app.o
    public final void onDestroyView() {
        super.onDestroyView();
        this.f = null;
    }

    @Override // androidx.fragment.app.o
    public final void onResume() {
        super.onResume();
        cr2.e();
    }

    @Override // defpackage.ek, androidx.fragment.app.o
    public final void onViewCreated(View view, Bundle bundle) {
        view.getClass();
        super.onViewCreated(view, bundle);
        iv1 iv1Var = this.f;
        iv1Var.getClass();
        final int i = 0;
        ((MaterialTextView) iv1Var.X).setActivated(t23.d("public_ip_visible", false));
        final int i2 = 1;
        k(true);
        j();
        view.setOnClickListener(new mk(21, this));
        iv1 iv1Var2 = this.f;
        iv1Var2.getClass();
        ((MaterialButton) iv1Var2.A).setOnClickListener(new w3(8));
        d73.c.e(getViewLifecycleOwner(), new yh0(6, new am1(this) { // from class: pb3
            public final /* synthetic */ PublicIPFragment f;

            {
                this.f = this;
            }

            @Override // defpackage.am1
            public final Object g(Object obj) throws UnknownHostException {
                int i3 = i;
                xl4 xl4Var = xl4.a;
                PublicIPFragment publicIPFragment = this.f;
                switch (i3) {
                    case 0:
                        t53 t53Var = (t53) obj;
                        rj2 rj2Var = publicIPFragment.X;
                        if (rj2Var != null) {
                            rj2Var.k(publicIPFragment.getViewLifecycleOwner());
                        }
                        if (t53Var != null) {
                            rj2 rj2VarX = ji0.x(t53Var.b);
                            rj2VarX.e(publicIPFragment.getViewLifecycleOwner(), new yh0(6, new ji(26)));
                            publicIPFragment.X = rj2VarX;
                        }
                        break;
                    default:
                        ei0 ei0Var = (ei0) obj;
                        int iOrdinal = ei0Var.a.ordinal();
                        if (iOrdinal == 0) {
                            publicIPFragment.A = false;
                            publicIPFragment.z = "";
                            iv1 iv1Var3 = publicIPFragment.f;
                            iv1Var3.getClass();
                            ((MaterialTextView) iv1Var3.X).setText(R.string.public_ip);
                            iv1 iv1Var4 = publicIPFragment.f;
                            iv1Var4.getClass();
                            ((LoadingIndicator) iv1Var4.z).setVisibility(0);
                            iv1 iv1Var5 = publicIPFragment.f;
                            iv1Var5.getClass();
                            ((MaterialButton) iv1Var5.A).setVisibility(8);
                            iv1 iv1Var6 = publicIPFragment.f;
                            iv1Var6.getClass();
                            ((MaterialTextView) iv1Var6.f).setVisibility(8);
                            publicIPFragment.j();
                            iv1 iv1Var7 = publicIPFragment.f;
                            iv1Var7.getClass();
                            ((MaterialTextView) iv1Var7.f).setOnLongClickListener(null);
                        } else if (iOrdinal == 1) {
                            Object obj2 = ei0Var.b;
                            if (obj2 == null) {
                                publicIPFragment.A = false;
                                CharSequence text = publicIPFragment.getText(R.string.no_network);
                                text.getClass();
                                publicIPFragment.z = text;
                                iv1 iv1Var8 = publicIPFragment.f;
                                iv1Var8.getClass();
                                ((MaterialTextView) iv1Var8.X).setText(R.string.public_ip);
                                iv1 iv1Var9 = publicIPFragment.f;
                                iv1Var9.getClass();
                                ((LoadingIndicator) iv1Var9.z).setVisibility(8);
                                iv1 iv1Var10 = publicIPFragment.f;
                                iv1Var10.getClass();
                                ((MaterialButton) iv1Var10.A).setVisibility(8);
                                iv1 iv1Var11 = publicIPFragment.f;
                                iv1Var11.getClass();
                                ((MaterialTextView) iv1Var11.f).setVisibility(0);
                                publicIPFragment.j();
                                iv1 iv1Var12 = publicIPFragment.f;
                                iv1Var12.getClass();
                                ((MaterialTextView) iv1Var12.f).setOnLongClickListener(null);
                            } else {
                                String str = (String) obj2;
                                publicIPFragment.A = true;
                                Spanned spannedP = vo.p(0, w44.i0(p44.C0(str), " ", "&nbsp;"));
                                spannedP.getClass();
                                publicIPFragment.z = spannedP;
                                try {
                                    InetAddress byName = InetAddress.getByName(str);
                                    zm1 zm1Var = an1.a;
                                    byName.getClass();
                                    String strD = zm1Var.d(byName);
                                    if (strD != null) {
                                        iv1 iv1Var13 = publicIPFragment.f;
                                        iv1Var13.getClass();
                                        ((MaterialTextView) iv1Var13.X).setText(publicIPFragment.getString(R.string.public_ip) + " " + ji0.g(strD));
                                    }
                                } catch (NetworkOnMainThreadException e) {
                                    e.printStackTrace();
                                }
                                iv1 iv1Var14 = publicIPFragment.f;
                                iv1Var14.getClass();
                                ((LoadingIndicator) iv1Var14.z).setVisibility(8);
                                iv1 iv1Var15 = publicIPFragment.f;
                                iv1Var15.getClass();
                                ((MaterialButton) iv1Var15.A).setVisibility(8);
                                iv1 iv1Var16 = publicIPFragment.f;
                                iv1Var16.getClass();
                                ((MaterialTextView) iv1Var16.f).setVisibility(0);
                                publicIPFragment.j();
                                iv1 iv1Var17 = publicIPFragment.f;
                                iv1Var17.getClass();
                                ((MaterialTextView) iv1Var17.f).setOnLongClickListener(new ow0(2, str));
                            }
                            break;
                        } else if (iOrdinal != 2) {
                            g.d();
                        } else if (!publicIPFragment.A) {
                            publicIPFragment.A = false;
                            publicIPFragment.z = "";
                            iv1 iv1Var18 = publicIPFragment.f;
                            iv1Var18.getClass();
                            ((MaterialTextView) iv1Var18.X).setText(R.string.public_ip);
                            iv1 iv1Var19 = publicIPFragment.f;
                            iv1Var19.getClass();
                            ((LoadingIndicator) iv1Var19.z).setVisibility(8);
                            iv1 iv1Var20 = publicIPFragment.f;
                            iv1Var20.getClass();
                            ((MaterialButton) iv1Var20.A).setVisibility(0);
                            iv1 iv1Var21 = publicIPFragment.f;
                            iv1Var21.getClass();
                            ((MaterialTextView) iv1Var21.f).setVisibility(8);
                            publicIPFragment.j();
                            iv1 iv1Var22 = publicIPFragment.f;
                            iv1Var22.getClass();
                            ((MaterialTextView) iv1Var22.f).setOnLongClickListener(null);
                        }
                        break;
                }
                return xl4Var;
            }
        }));
        cr2.a.e(getViewLifecycleOwner(), new yh0(6, new am1(this) { // from class: pb3
            public final /* synthetic */ PublicIPFragment f;

            {
                this.f = this;
            }

            @Override // defpackage.am1
            public final Object g(Object obj) throws UnknownHostException {
                int i3 = i2;
                xl4 xl4Var = xl4.a;
                PublicIPFragment publicIPFragment = this.f;
                switch (i3) {
                    case 0:
                        t53 t53Var = (t53) obj;
                        rj2 rj2Var = publicIPFragment.X;
                        if (rj2Var != null) {
                            rj2Var.k(publicIPFragment.getViewLifecycleOwner());
                        }
                        if (t53Var != null) {
                            rj2 rj2VarX = ji0.x(t53Var.b);
                            rj2VarX.e(publicIPFragment.getViewLifecycleOwner(), new yh0(6, new ji(26)));
                            publicIPFragment.X = rj2VarX;
                        }
                        break;
                    default:
                        ei0 ei0Var = (ei0) obj;
                        int iOrdinal = ei0Var.a.ordinal();
                        if (iOrdinal == 0) {
                            publicIPFragment.A = false;
                            publicIPFragment.z = "";
                            iv1 iv1Var3 = publicIPFragment.f;
                            iv1Var3.getClass();
                            ((MaterialTextView) iv1Var3.X).setText(R.string.public_ip);
                            iv1 iv1Var4 = publicIPFragment.f;
                            iv1Var4.getClass();
                            ((LoadingIndicator) iv1Var4.z).setVisibility(0);
                            iv1 iv1Var5 = publicIPFragment.f;
                            iv1Var5.getClass();
                            ((MaterialButton) iv1Var5.A).setVisibility(8);
                            iv1 iv1Var6 = publicIPFragment.f;
                            iv1Var6.getClass();
                            ((MaterialTextView) iv1Var6.f).setVisibility(8);
                            publicIPFragment.j();
                            iv1 iv1Var7 = publicIPFragment.f;
                            iv1Var7.getClass();
                            ((MaterialTextView) iv1Var7.f).setOnLongClickListener(null);
                        } else if (iOrdinal == 1) {
                            Object obj2 = ei0Var.b;
                            if (obj2 == null) {
                                publicIPFragment.A = false;
                                CharSequence text = publicIPFragment.getText(R.string.no_network);
                                text.getClass();
                                publicIPFragment.z = text;
                                iv1 iv1Var8 = publicIPFragment.f;
                                iv1Var8.getClass();
                                ((MaterialTextView) iv1Var8.X).setText(R.string.public_ip);
                                iv1 iv1Var9 = publicIPFragment.f;
                                iv1Var9.getClass();
                                ((LoadingIndicator) iv1Var9.z).setVisibility(8);
                                iv1 iv1Var10 = publicIPFragment.f;
                                iv1Var10.getClass();
                                ((MaterialButton) iv1Var10.A).setVisibility(8);
                                iv1 iv1Var11 = publicIPFragment.f;
                                iv1Var11.getClass();
                                ((MaterialTextView) iv1Var11.f).setVisibility(0);
                                publicIPFragment.j();
                                iv1 iv1Var12 = publicIPFragment.f;
                                iv1Var12.getClass();
                                ((MaterialTextView) iv1Var12.f).setOnLongClickListener(null);
                            } else {
                                String str = (String) obj2;
                                publicIPFragment.A = true;
                                Spanned spannedP = vo.p(0, w44.i0(p44.C0(str), " ", "&nbsp;"));
                                spannedP.getClass();
                                publicIPFragment.z = spannedP;
                                try {
                                    InetAddress byName = InetAddress.getByName(str);
                                    zm1 zm1Var = an1.a;
                                    byName.getClass();
                                    String strD = zm1Var.d(byName);
                                    if (strD != null) {
                                        iv1 iv1Var13 = publicIPFragment.f;
                                        iv1Var13.getClass();
                                        ((MaterialTextView) iv1Var13.X).setText(publicIPFragment.getString(R.string.public_ip) + " " + ji0.g(strD));
                                    }
                                } catch (NetworkOnMainThreadException e) {
                                    e.printStackTrace();
                                }
                                iv1 iv1Var14 = publicIPFragment.f;
                                iv1Var14.getClass();
                                ((LoadingIndicator) iv1Var14.z).setVisibility(8);
                                iv1 iv1Var15 = publicIPFragment.f;
                                iv1Var15.getClass();
                                ((MaterialButton) iv1Var15.A).setVisibility(8);
                                iv1 iv1Var16 = publicIPFragment.f;
                                iv1Var16.getClass();
                                ((MaterialTextView) iv1Var16.f).setVisibility(0);
                                publicIPFragment.j();
                                iv1 iv1Var17 = publicIPFragment.f;
                                iv1Var17.getClass();
                                ((MaterialTextView) iv1Var17.f).setOnLongClickListener(new ow0(2, str));
                            }
                            break;
                        } else if (iOrdinal != 2) {
                            g.d();
                        } else if (!publicIPFragment.A) {
                            publicIPFragment.A = false;
                            publicIPFragment.z = "";
                            iv1 iv1Var18 = publicIPFragment.f;
                            iv1Var18.getClass();
                            ((MaterialTextView) iv1Var18.X).setText(R.string.public_ip);
                            iv1 iv1Var19 = publicIPFragment.f;
                            iv1Var19.getClass();
                            ((LoadingIndicator) iv1Var19.z).setVisibility(8);
                            iv1 iv1Var20 = publicIPFragment.f;
                            iv1Var20.getClass();
                            ((MaterialButton) iv1Var20.A).setVisibility(0);
                            iv1 iv1Var21 = publicIPFragment.f;
                            iv1Var21.getClass();
                            ((MaterialTextView) iv1Var21.f).setVisibility(8);
                            publicIPFragment.j();
                            iv1 iv1Var22 = publicIPFragment.f;
                            iv1Var22.getClass();
                            ((MaterialTextView) iv1Var22.f).setOnLongClickListener(null);
                        }
                        break;
                }
                return xl4Var;
            }
        }));
    }
}

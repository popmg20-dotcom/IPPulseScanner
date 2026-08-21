package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.getsurfboard.R;
import defpackage.cd3;
import defpackage.hl2;
import defpackage.n02;
import defpackage.nk2;
import defpackage.sk2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements hl2, AbsListView.SelectionBoundsAdjuster {
    public TextView A;
    public ImageView A0;
    public ImageView B0;
    public LinearLayout C0;
    public final Drawable D0;
    public final int E0;
    public final Context F0;
    public boolean G0;
    public final Drawable H0;
    public final boolean I0;
    public LayoutInflater J0;
    public boolean K0;
    public sk2 b;
    public ImageView f;
    public CheckBox y0;
    public RadioButton z;
    public TextView z0;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        n02 n02VarY = n02.y(getContext(), attributeSet, cd3.r, R.attr.listMenuViewStyle);
        this.D0 = n02VarY.o(5);
        TypedArray typedArray = (TypedArray) n02VarY.z;
        this.E0 = typedArray.getResourceId(1, -1);
        this.G0 = typedArray.getBoolean(7, false);
        this.F0 = context;
        this.H0 = n02VarY.o(8);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{android.R.attr.divider}, R.attr.dropDownListViewStyle, 0);
        this.I0 = typedArrayObtainStyledAttributes.hasValue(0);
        n02VarY.K();
        typedArrayObtainStyledAttributes.recycle();
    }

    private LayoutInflater getInflater() {
        LayoutInflater layoutInflater = this.J0;
        if (layoutInflater != null) {
            return layoutInflater;
        }
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        this.J0 = layoutInflaterFrom;
        return layoutInflaterFrom;
    }

    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView = this.A0;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public final void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.B0;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.B0.getLayoutParams();
        rect.top = this.B0.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin + rect.top;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0053  */
    @Override // defpackage.hl2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(sk2 sk2Var) {
        boolean z;
        String string;
        this.b = sk2Var;
        boolean zIsVisible = sk2Var.isVisible();
        nk2 nk2Var = sk2Var.n;
        int i = 0;
        setVisibility(zIsVisible ? 0 : 8);
        setTitle(sk2Var.e);
        setCheckable(sk2Var.isCheckable());
        if (nk2Var.q()) {
            if ((nk2Var.p() ? sk2Var.j : sk2Var.h) != 0) {
                z = true;
            }
        } else {
            z = false;
        }
        nk2Var.p();
        if (z) {
            sk2 sk2Var2 = this.b;
            nk2 nk2Var2 = sk2Var2.n;
            if (nk2Var2.q()) {
                if ((nk2Var2.p() ? sk2Var2.j : sk2Var2.h) == 0) {
                }
            } else {
                i = 8;
            }
        }
        if (i == 0) {
            TextView textView = this.z0;
            sk2 sk2Var3 = this.b;
            nk2 nk2Var3 = sk2Var3.n;
            Context context = nk2Var3.a;
            char c = nk2Var3.p() ? sk2Var3.j : sk2Var3.h;
            if (c == 0) {
                string = "";
            } else {
                Resources resources = context.getResources();
                StringBuilder sb = new StringBuilder();
                if (ViewConfiguration.get(context).hasPermanentMenuKey()) {
                    sb.append(resources.getString(R.string.abc_prepend_shortcut_label));
                }
                int i2 = nk2Var3.p() ? sk2Var3.k : sk2Var3.i;
                sk2.b(i2, 65536, resources.getString(R.string.abc_menu_meta_shortcut_label), sb);
                sk2.b(i2, 4096, resources.getString(R.string.abc_menu_ctrl_shortcut_label), sb);
                sk2.b(i2, 2, resources.getString(R.string.abc_menu_alt_shortcut_label), sb);
                sk2.b(i2, 1, resources.getString(R.string.abc_menu_shift_shortcut_label), sb);
                sk2.b(i2, 4, resources.getString(R.string.abc_menu_sym_shortcut_label), sb);
                sk2.b(i2, 8, resources.getString(R.string.abc_menu_function_shortcut_label), sb);
                if (c == '\b') {
                    sb.append(resources.getString(R.string.abc_menu_delete_shortcut_label));
                } else if (c == '\n') {
                    sb.append(resources.getString(R.string.abc_menu_enter_shortcut_label));
                } else if (c != ' ') {
                    sb.append(c);
                } else {
                    sb.append(resources.getString(R.string.abc_menu_space_shortcut_label));
                }
                string = sb.toString();
            }
            textView.setText(string);
        }
        if (this.z0.getVisibility() != i) {
            this.z0.setVisibility(i);
        }
        setIcon(sk2Var.getIcon());
        setEnabled(sk2Var.isEnabled());
        setSubMenuArrowVisible(sk2Var.hasSubMenu());
        setContentDescription(sk2Var.q);
    }

    @Override // defpackage.hl2
    public sk2 getItemData() {
        return this.b;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        setBackground(this.D0);
        TextView textView = (TextView) findViewById(R.id.title);
        this.A = textView;
        int i = this.E0;
        if (i != -1) {
            textView.setTextAppearance(this.F0, i);
        }
        this.z0 = (TextView) findViewById(R.id.shortcut);
        ImageView imageView = (ImageView) findViewById(R.id.submenuarrow);
        this.A0 = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.H0);
        }
        this.B0 = (ImageView) findViewById(R.id.group_divider);
        this.C0 = (LinearLayout) findViewById(R.id.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        if (this.f != null && this.G0) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f.getLayoutParams();
            int i3 = layoutParams.height;
            if (i3 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i3;
            }
        }
        super.onMeasure(i, i2);
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        CompoundButton compoundButton3;
        if (!z && this.z == null && this.y0 == null) {
            return;
        }
        if ((this.b.x & 4) != 0) {
            if (this.z == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.z = radioButton;
                LinearLayout linearLayout = this.C0;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.z;
            compoundButton2 = this.y0;
            compoundButton3 = compoundButton2;
        } else {
            if (this.y0 == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.y0 = checkBox;
                LinearLayout linearLayout2 = this.C0;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.y0;
            compoundButton2 = this.z;
            compoundButton3 = compoundButton;
        }
        if (!z) {
            if (compoundButton3 != null) {
                compoundButton3.setVisibility(8);
            }
            RadioButton radioButton2 = this.z;
            if (radioButton2 != null) {
                radioButton2.setVisibility(8);
                return;
            }
            return;
        }
        compoundButton.setChecked(this.b.isChecked());
        if (compoundButton.getVisibility() != 0) {
            compoundButton.setVisibility(0);
        }
        if (compoundButton2 == null || compoundButton2.getVisibility() == 8) {
            return;
        }
        compoundButton2.setVisibility(8);
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if ((this.b.x & 4) != 0) {
            if (this.z == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.z = radioButton;
                LinearLayout linearLayout = this.C0;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.z;
        } else {
            if (this.y0 == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.y0 = checkBox;
                LinearLayout linearLayout2 = this.C0;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.y0;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.K0 = z;
        this.G0 = z;
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView = this.B0;
        if (imageView != null) {
            imageView.setVisibility((this.I0 || !z) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.b.n.s || this.K0;
        if (z || this.G0) {
            ImageView imageView = this.f;
            if (imageView == null && drawable == null && !this.G0) {
                return;
            }
            if (imageView == null) {
                ImageView imageView2 = (ImageView) getInflater().inflate(R.layout.abc_list_menu_item_icon, (ViewGroup) this, false);
                this.f = imageView2;
                LinearLayout linearLayout = this.C0;
                if (linearLayout != null) {
                    linearLayout.addView(imageView2, 0);
                } else {
                    addView(imageView2, 0);
                }
            }
            if (drawable == null && !this.G0) {
                this.f.setVisibility(8);
                return;
            }
            ImageView imageView3 = this.f;
            if (!z) {
                drawable = null;
            }
            imageView3.setImageDrawable(drawable);
            if (this.f.getVisibility() != 0) {
                this.f.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        TextView textView = this.A;
        if (charSequence == null) {
            if (textView.getVisibility() != 8) {
                this.A.setVisibility(8);
            }
        } else {
            textView.setText(charSequence);
            if (this.A.getVisibility() != 0) {
                this.A.setVisibility(0);
            }
        }
    }
}

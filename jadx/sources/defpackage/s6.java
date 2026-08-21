package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;
import androidx.core.widget.NestedScrollView;
import com.getsurfboard.R;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class s6 {
    public final int B;
    public final int C;
    public final int D;
    public final int E;
    public final int F;
    public final boolean G;
    public final q6 H;
    public final Context a;
    public final u6 b;
    public final Window c;
    public CharSequence d;
    public CharSequence e;
    public AlertController$RecycleListView f;
    public View g;
    public int h;
    public Button j;
    public CharSequence k;
    public Message l;
    public Button m;
    public CharSequence n;
    public Message o;
    public Button p;
    public CharSequence q;
    public Message r;
    public NestedScrollView s;
    public Drawable u;
    public ImageView v;
    public TextView w;
    public TextView x;
    public View y;
    public ListAdapter z;
    public boolean i = false;
    public int t = 0;
    public int A = -1;
    public final c3 I = new c3(1, this);

    public s6(Context context, u6 u6Var, Window window) {
        this.a = context;
        this.b = u6Var;
        this.c = window;
        q6 q6Var = new q6();
        q6Var.b = new WeakReference(u6Var);
        this.H = q6Var;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, cd3.e, R.attr.alertDialogStyle, 0);
        this.B = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.getResourceId(2, 0);
        this.C = typedArrayObtainStyledAttributes.getResourceId(4, 0);
        this.D = typedArrayObtainStyledAttributes.getResourceId(5, 0);
        this.E = typedArrayObtainStyledAttributes.getResourceId(7, 0);
        this.F = typedArrayObtainStyledAttributes.getResourceId(3, 0);
        this.G = typedArrayObtainStyledAttributes.getBoolean(6, true);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        u6Var.d().i(1);
    }

    public static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public static ViewGroup b(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    public final void c(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        Message messageObtainMessage = onClickListener != null ? this.H.obtainMessage(i, onClickListener) : null;
        if (i == -3) {
            this.q = charSequence;
            this.r = messageObtainMessage;
        } else if (i == -2) {
            this.n = charSequence;
            this.o = messageObtainMessage;
        } else if (i != -1) {
            xe.k("Button does not exist");
        } else {
            this.k = charSequence;
            this.l = messageObtainMessage;
        }
    }
}

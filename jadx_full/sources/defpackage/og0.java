package defpackage;

import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import com.getsurfboard.R;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class og0 extends BaseAdapter implements Filterable {
    public int A;
    public mg0 X;
    public ng0 Y;
    public rg0 Z;
    public boolean b;
    public boolean f;
    public Cursor z;

    public abstract void a(View view, Cursor cursor);

    public void b(Cursor cursor) {
        Cursor cursor2 = this.z;
        if (cursor == cursor2) {
            cursor2 = null;
        } else {
            if (cursor2 != null) {
                mg0 mg0Var = this.X;
                if (mg0Var != null) {
                    cursor2.unregisterContentObserver(mg0Var);
                }
                ng0 ng0Var = this.Y;
                if (ng0Var != null) {
                    cursor2.unregisterDataSetObserver(ng0Var);
                }
            }
            this.z = cursor;
            if (cursor != null) {
                mg0 mg0Var2 = this.X;
                if (mg0Var2 != null) {
                    cursor.registerContentObserver(mg0Var2);
                }
                ng0 ng0Var2 = this.Y;
                if (ng0Var2 != null) {
                    cursor.registerDataSetObserver(ng0Var2);
                }
                this.A = cursor.getColumnIndexOrThrow("_id");
                this.b = true;
                notifyDataSetChanged();
            } else {
                this.A = -1;
                this.b = false;
                notifyDataSetInvalidated();
            }
        }
        if (cursor2 != null) {
            cursor2.close();
        }
    }

    public abstract String c(Cursor cursor);

    @Override // android.widget.Adapter
    public final int getCount() {
        Cursor cursor;
        if (!this.b || (cursor = this.z) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.b) {
            return null;
        }
        this.z.moveToPosition(i);
        if (view == null) {
            p54 p54Var = (p54) this;
            view = p54Var.A0.inflate(p54Var.z0, viewGroup, false);
        }
        a(view, this.z);
        return view;
    }

    @Override // android.widget.Filterable
    public final Filter getFilter() {
        rg0 rg0Var = this.Z;
        if (rg0Var != null) {
            return rg0Var;
        }
        rg0 rg0Var2 = new rg0();
        rg0Var2.a = this;
        this.Z = rg0Var2;
        return rg0Var2;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        Cursor cursor;
        if (!this.b || (cursor = this.z) == null) {
            return null;
        }
        cursor.moveToPosition(i);
        return this.z;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        Cursor cursor;
        if (this.b && (cursor = this.z) != null && cursor.moveToPosition(i)) {
            return this.z.getLong(this.A);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.b) {
            xe.q("this should only be called when the cursor is valid");
            return null;
        }
        if (!this.z.moveToPosition(i)) {
            xe.q(dw2.A(i, "couldn't move cursor to position "));
            return null;
        }
        if (view == null) {
            p54 p54Var = (p54) this;
            view = p54Var.A0.inflate(p54Var.y0, viewGroup, false);
            view.setTag(new o54(view));
            ((ImageView) view.findViewById(R.id.edit_query)).setImageResource(p54Var.F0);
        }
        a(view, this.z);
        return view;
    }
}

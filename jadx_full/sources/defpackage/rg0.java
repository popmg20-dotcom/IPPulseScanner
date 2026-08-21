package defpackage;

import android.database.Cursor;
import android.widget.Filter;
import androidx.appcompat.widget.SearchView;
import io.sentry.android.core.a1;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class rg0 extends Filter {
    public og0 a;

    @Override // android.widget.Filter
    public final CharSequence convertResultToString(Object obj) {
        return this.a.c((Cursor) obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0031  */
    @Override // android.widget.Filter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor cursorF;
        p54 p54Var = (p54) this.a;
        SearchView searchView = p54Var.B0;
        String string = charSequence == null ? "" : charSequence.toString();
        if (searchView.getVisibility() == 0 && searchView.getWindowVisibility() == 0) {
            try {
                cursorF = p54Var.f(p54Var.C0, string);
                if (cursorF != null) {
                    cursorF.getCount();
                }
            } catch (RuntimeException e) {
                a1.o("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
            }
        } else {
            cursorF = null;
        }
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (cursorF != null) {
            filterResults.count = cursorF.getCount();
            filterResults.values = cursorF;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    @Override // android.widget.Filter
    public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        og0 og0Var = this.a;
        Cursor cursor = og0Var.z;
        Object obj = filterResults.values;
        if (obj == null || obj == cursor) {
            return;
        }
        og0Var.b((Cursor) obj);
    }
}

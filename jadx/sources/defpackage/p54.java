package defpackage;

import android.app.SearchableInfo;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.SearchView;
import com.getsurfboard.R;
import io.sentry.android.core.a1;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class p54 extends og0 implements View.OnClickListener {
    public static final /* synthetic */ int O0 = 0;
    public final LayoutInflater A0;
    public final SearchView B0;
    public final SearchableInfo C0;
    public final Context D0;
    public final WeakHashMap E0;
    public final int F0;
    public int G0;
    public ColorStateList H0;
    public int I0;
    public int J0;
    public int K0;
    public int L0;
    public int M0;
    public int N0;
    public final int y0;
    public final int z0;

    public p54(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap weakHashMap) {
        int suggestionRowLayout = searchView.getSuggestionRowLayout();
        this.f = true;
        this.z = null;
        this.b = false;
        this.A = -1;
        this.X = new mg0(this);
        this.Y = new ng0(0, this);
        this.z0 = suggestionRowLayout;
        this.y0 = suggestionRowLayout;
        this.A0 = (LayoutInflater) context.getSystemService("layout_inflater");
        this.G0 = 1;
        this.I0 = -1;
        this.J0 = -1;
        this.K0 = -1;
        this.L0 = -1;
        this.M0 = -1;
        this.N0 = -1;
        this.B0 = searchView;
        this.C0 = searchableInfo;
        this.F0 = searchView.getSuggestionCommitIconResId();
        this.D0 = context;
        this.E0 = weakHashMap;
    }

    public static String g(Cursor cursor, int i) {
        if (i == -1) {
            return null;
        }
        try {
            return cursor.getString(i);
        } catch (Exception e) {
            a1.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0134  */
    @Override // defpackage.og0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(android.view.View r21, android.database.Cursor r22) {
        /*
            Method dump skipped, instruction units count: 423
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.p54.a(android.view.View, android.database.Cursor):void");
    }

    @Override // defpackage.og0
    public final void b(Cursor cursor) {
        try {
            super.b(cursor);
            if (cursor != null) {
                this.I0 = cursor.getColumnIndex("suggest_text_1");
                this.J0 = cursor.getColumnIndex("suggest_text_2");
                this.K0 = cursor.getColumnIndex("suggest_text_2_url");
                this.L0 = cursor.getColumnIndex("suggest_icon_1");
                this.M0 = cursor.getColumnIndex("suggest_icon_2");
                this.N0 = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e) {
            a1.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    @Override // defpackage.og0
    public final String c(Cursor cursor) {
        String strG;
        String strG2;
        if (cursor == null) {
            return null;
        }
        String strG3 = g(cursor, cursor.getColumnIndex("suggest_intent_query"));
        if (strG3 != null) {
            return strG3;
        }
        SearchableInfo searchableInfo = this.C0;
        if (searchableInfo.shouldRewriteQueryFromData() && (strG2 = g(cursor, cursor.getColumnIndex("suggest_intent_data"))) != null) {
            return strG2;
        }
        if (!searchableInfo.shouldRewriteQueryFromText() || (strG = g(cursor, cursor.getColumnIndex("suggest_text_1"))) == null) {
            return null;
        }
        return strG;
    }

    public final Drawable d(Uri uri) throws FileNotFoundException {
        int identifier;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            a71.f(uri, "No authority: ");
            return null;
        }
        try {
            Resources resourcesForApplication = this.D0.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                a71.f(uri, "No path: ");
                return null;
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    identifier = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    a71.f(uri, "Single path segment is not a resource ID: ");
                    return null;
                }
            } else {
                if (size != 2) {
                    a71.f(uri, "More than two path segments: ");
                    return null;
                }
                identifier = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            }
            if (identifier != 0) {
                return resourcesForApplication.getDrawable(identifier);
            }
            a71.f(uri, "No resource found for: ");
            return null;
        } catch (PackageManager.NameNotFoundException unused2) {
            a71.f(uri, "No package found for authority: ");
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x010c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.drawable.Drawable e(java.lang.String r11) {
        /*
            Method dump skipped, instruction units count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.p54.e(java.lang.String):android.graphics.drawable.Drawable");
    }

    public final Cursor f(SearchableInfo searchableInfo, String str) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder builderFragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            builderFragment.appendEncodedPath(suggestPath);
        }
        builderFragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            builderFragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        builderFragment.appendQueryParameter("limit", String.valueOf(50));
        return this.D0.getContentResolver().query(builderFragment.build(), null, suggestSelection, strArr2, null);
    }

    @Override // defpackage.og0, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public final View getDropDownView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i, view, viewGroup);
        } catch (RuntimeException e) {
            a1.o("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View viewInflate = this.A0.inflate(this.z0, viewGroup, false);
            if (viewInflate != null) {
                ((o54) viewInflate.getTag()).a.setText(e.toString());
            }
            return viewInflate;
        }
    }

    @Override // defpackage.og0, android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (RuntimeException e) {
            a1.o("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View viewInflate = this.A0.inflate(this.y0, viewGroup, false);
            viewInflate.setTag(new o54(viewInflate));
            ((ImageView) viewInflate.findViewById(R.id.edit_query)).setImageResource(this.F0);
            ((o54) viewInflate.getTag()).a.setText(e.toString());
            return viewInflate;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        Cursor cursor = this.z;
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        Cursor cursor = this.z;
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.B0.p((CharSequence) tag);
        }
    }
}

package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import com.getsurfboard.R;
import defpackage.ar3;
import defpackage.br3;
import defpackage.cd3;
import defpackage.co;
import defpackage.cr3;
import defpackage.da;
import defpackage.dr3;
import defpackage.er3;
import defpackage.fr3;
import defpackage.ky0;
import defpackage.n02;
import defpackage.nm2;
import defpackage.og0;
import defpackage.p54;
import defpackage.u41;
import defpackage.u60;
import defpackage.wb;
import defpackage.wp4;
import defpackage.ye;
import defpackage.yq3;
import defpackage.zq3;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import io.sentry.android.core.a1;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class SearchView extends LinearLayoutCompat implements u60 {
    public static final nm2 A1;
    public final SearchAutoComplete J0;
    public final View K0;
    public final View L0;
    public final View M0;
    public final ImageView N0;
    public final ImageView O0;
    public final ImageView P0;
    public final ImageView Q0;
    public final View R0;
    public fr3 S0;
    public final Rect T0;
    public final Rect U0;
    public final int[] V0;
    public final int[] W0;
    public final ImageView X0;
    public final Drawable Y0;
    public final int Z0;
    public final int a1;
    public final Intent b1;
    public final Intent c1;
    public final CharSequence d1;
    public cr3 e1;
    public br3 f1;
    public View.OnFocusChangeListener g1;
    public View.OnClickListener h1;
    public boolean i1;
    public boolean j1;
    public og0 k1;
    public boolean l1;
    public CharSequence m1;
    public boolean n1;
    public boolean o1;
    public int p1;
    public boolean q1;
    public String r1;
    public CharSequence s1;
    public boolean t1;
    public int u1;
    public SearchableInfo v1;
    public Bundle w1;
    public final yq3 x1;
    public final yq3 y1;
    public final WeakHashMap z1;

    static {
        nm2 nm2Var = null;
        if (Build.VERSION.SDK_INT < 29) {
            nm2 nm2Var2 = new nm2();
            nm2Var2.a = null;
            nm2Var2.b = null;
            nm2Var2.c = null;
            nm2.a();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", null);
                nm2Var2.a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", null);
                nm2Var2.b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                nm2Var2.c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
            nm2Var = nm2Var2;
        }
        A1 = nm2Var;
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.searchViewStyle);
        this.T0 = new Rect();
        this.U0 = new Rect();
        this.V0 = new int[2];
        this.W0 = new int[2];
        this.x1 = new yq3(this, 0);
        this.y1 = new yq3(this, 1);
        this.z1 = new WeakHashMap();
        a aVar = new a(this);
        b bVar = new b(this);
        ar3 ar3Var = new ar3(this);
        wb wbVar = new wb(2, this);
        int i = 3;
        ky0 ky0Var = new ky0(i, this);
        u41 u41Var = new u41(i, this);
        int[] iArr = cd3.u;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, R.attr.searchViewStyle, 0);
        n02 n02Var = new n02(context, typedArrayObtainStyledAttributes);
        wp4.m(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, R.attr.searchViewStyle);
        LayoutInflater.from(context).inflate(typedArrayObtainStyledAttributes.getResourceId(21, R.layout.abc_search_view), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(R.id.search_src_text);
        this.J0 = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.K0 = findViewById(R.id.search_edit_frame);
        View viewFindViewById = findViewById(R.id.search_plate);
        this.L0 = viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.submit_area);
        this.M0 = viewFindViewById2;
        ImageView imageView = (ImageView) findViewById(R.id.search_button);
        this.N0 = imageView;
        ImageView imageView2 = (ImageView) findViewById(R.id.search_go_btn);
        this.O0 = imageView2;
        ImageView imageView3 = (ImageView) findViewById(R.id.search_close_btn);
        this.P0 = imageView3;
        ImageView imageView4 = (ImageView) findViewById(R.id.search_voice_btn);
        this.Q0 = imageView4;
        ImageView imageView5 = (ImageView) findViewById(R.id.search_mag_icon);
        this.X0 = imageView5;
        viewFindViewById.setBackground(n02Var.o(22));
        viewFindViewById2.setBackground(n02Var.o(27));
        imageView.setImageDrawable(n02Var.o(25));
        imageView2.setImageDrawable(n02Var.o(17));
        imageView3.setImageDrawable(n02Var.o(12));
        imageView4.setImageDrawable(n02Var.o(30));
        imageView5.setImageDrawable(n02Var.o(25));
        this.Y0 = n02Var.o(24);
        ye.H(imageView, getResources().getString(R.string.abc_searchview_description_search));
        this.Z0 = typedArrayObtainStyledAttributes.getResourceId(28, R.layout.abc_search_dropdown_item_icons_2line);
        this.a1 = typedArrayObtainStyledAttributes.getResourceId(13, 0);
        imageView.setOnClickListener(aVar);
        imageView3.setOnClickListener(aVar);
        imageView2.setOnClickListener(aVar);
        imageView4.setOnClickListener(aVar);
        searchAutoComplete.setOnClickListener(aVar);
        searchAutoComplete.addTextChangedListener(u41Var);
        searchAutoComplete.setOnEditorActionListener(ar3Var);
        searchAutoComplete.setOnItemClickListener(wbVar);
        searchAutoComplete.setOnItemSelectedListener(ky0Var);
        searchAutoComplete.setOnKeyListener(bVar);
        searchAutoComplete.setOnFocusChangeListener(new zq3(this));
        setIconifiedByDefault(typedArrayObtainStyledAttributes.getBoolean(20, true));
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, -1);
        if (dimensionPixelSize != -1) {
            setMaxWidth(dimensionPixelSize);
        }
        this.d1 = typedArrayObtainStyledAttributes.getText(15);
        this.m1 = typedArrayObtainStyledAttributes.getText(23);
        int i2 = typedArrayObtainStyledAttributes.getInt(6, -1);
        if (i2 != -1) {
            setImeOptions(i2);
        }
        int i3 = typedArrayObtainStyledAttributes.getInt(5, -1);
        if (i3 != -1) {
            setInputType(i3);
        }
        setFocusable(typedArrayObtainStyledAttributes.getBoolean(1, true));
        n02Var.K();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.b1 = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.c1 = intent2;
        intent2.addFlags(268435456);
        View viewFindViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.R0 = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.addOnLayoutChangeListener(new co(2, this));
        }
        x(this.i1);
        u();
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
    }

    private void setQuery(CharSequence charSequence) {
        SearchAutoComplete searchAutoComplete = this.J0;
        searchAutoComplete.setText(charSequence);
        searchAutoComplete.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void clearFocus() {
        this.o1 = true;
        super.clearFocus();
        SearchAutoComplete searchAutoComplete = this.J0;
        searchAutoComplete.clearFocus();
        searchAutoComplete.setImeVisibility(false);
        this.o1 = false;
    }

    public int getImeOptions() {
        return this.J0.getImeOptions();
    }

    public int getInputType() {
        return this.J0.getInputType();
    }

    public int getMaxWidth() {
        return this.p1;
    }

    public CharSequence getQuery() {
        return this.J0.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.m1;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.v1;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.d1 : getContext().getText(this.v1.getHintId());
    }

    public int getSuggestionCommitIconResId() {
        return this.a1;
    }

    public int getSuggestionRowLayout() {
        return this.Z0;
    }

    public og0 getSuggestionsAdapter() {
        return this.k1;
    }

    public final Intent j(String str, Uri uri, String str2, String str3) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.s1);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.w1;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        intent.setComponent(this.v1.getSearchActivity());
        return intent;
    }

    public final Intent k(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.w1;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    public final void l() {
        int i = Build.VERSION.SDK_INT;
        SearchAutoComplete searchAutoComplete = this.J0;
        if (i >= 29) {
            c.a(searchAutoComplete);
            return;
        }
        nm2 nm2Var = A1;
        nm2Var.getClass();
        nm2.a();
        Method method = nm2Var.a;
        if (method != null) {
            try {
                method.invoke(searchAutoComplete, null);
            } catch (Exception unused) {
            }
        }
        nm2Var.getClass();
        nm2.a();
        Method method2 = nm2Var.b;
        if (method2 != null) {
            try {
                method2.invoke(searchAutoComplete, null);
            } catch (Exception unused2) {
            }
        }
    }

    public final void m() {
        SearchAutoComplete searchAutoComplete = this.J0;
        if (!TextUtils.isEmpty(searchAutoComplete.getText())) {
            searchAutoComplete.setText("");
            searchAutoComplete.requestFocus();
            searchAutoComplete.setImeVisibility(true);
        } else if (this.i1) {
            br3 br3Var = this.f1;
            if (br3Var != null) {
                br3Var.a();
            }
            clearFocus();
            x(true);
        }
    }

    public final void n(int i) {
        int position;
        String strG;
        Cursor cursor = this.k1.z;
        if (cursor != null && cursor.moveToPosition(i)) {
            Intent intentJ = null;
            try {
                int i2 = p54.O0;
                String strG2 = p54.g(cursor, cursor.getColumnIndex("suggest_intent_action"));
                if (strG2 == null) {
                    strG2 = this.v1.getSuggestIntentAction();
                }
                if (strG2 == null) {
                    strG2 = "android.intent.action.SEARCH";
                }
                String strG3 = p54.g(cursor, cursor.getColumnIndex("suggest_intent_data"));
                if (strG3 == null) {
                    strG3 = this.v1.getSuggestIntentData();
                }
                if (strG3 != null && (strG = p54.g(cursor, cursor.getColumnIndex("suggest_intent_data_id"))) != null) {
                    strG3 = strG3 + "/" + Uri.encode(strG);
                }
                intentJ = j(strG2, strG3 == null ? null : Uri.parse(strG3), p54.g(cursor, cursor.getColumnIndex("suggest_intent_extra_data")), p54.g(cursor, cursor.getColumnIndex("suggest_intent_query")));
            } catch (RuntimeException e) {
                try {
                    position = cursor.getPosition();
                } catch (RuntimeException unused) {
                    position = -1;
                }
                a1.o("SearchView", "Search suggestions cursor at row " + position + " returned exception.", e);
            }
            if (intentJ != null) {
                try {
                    getContext().startActivity(intentJ);
                } catch (RuntimeException e2) {
                    a1.e("SearchView", "Failed launch activity: " + intentJ, e2);
                }
            }
        }
        SearchAutoComplete searchAutoComplete = this.J0;
        searchAutoComplete.setImeVisibility(false);
        searchAutoComplete.dismissDropDown();
    }

    public final void o(int i) {
        Editable text = this.J0.getText();
        Cursor cursor = this.k1.z;
        if (cursor == null) {
            return;
        }
        if (!cursor.moveToPosition(i)) {
            setQuery(text);
            return;
        }
        String strC = this.k1.c(cursor);
        if (strC != null) {
            setQuery(strC);
        } else {
            setQuery(text);
        }
    }

    @Override // defpackage.u60
    public final void onActionViewCollapsed() {
        r(false);
        clearFocus();
        x(true);
        this.J0.setImeOptions(this.u1);
        this.t1 = false;
    }

    @Override // defpackage.u60
    public final void onActionViewExpanded() {
        if (this.t1) {
            return;
        }
        this.t1 = true;
        SearchAutoComplete searchAutoComplete = this.J0;
        int imeOptions = searchAutoComplete.getImeOptions();
        this.u1 = imeOptions;
        searchAutoComplete.setImeOptions(imeOptions | 33554432);
        searchAutoComplete.setText("");
        setIconified(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.x1);
        post(this.y1);
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            SearchAutoComplete searchAutoComplete = this.J0;
            int[] iArr = this.V0;
            searchAutoComplete.getLocationInWindow(iArr);
            int[] iArr2 = this.W0;
            getLocationInWindow(iArr2);
            int i5 = iArr[1] - iArr2[1];
            int i6 = iArr[0] - iArr2[0];
            int width = searchAutoComplete.getWidth() + i6;
            int height = searchAutoComplete.getHeight() + i5;
            Rect rect = this.T0;
            rect.set(i6, i5, width, height);
            int i7 = rect.left;
            int i8 = rect.right;
            int i9 = i4 - i2;
            Rect rect2 = this.U0;
            rect2.set(i7, 0, i8, i9);
            fr3 fr3Var = this.S0;
            if (fr3Var == null) {
                fr3 fr3Var2 = new fr3(searchAutoComplete, rect2, rect);
                this.S0 = fr3Var2;
                setTouchDelegate(fr3Var2);
            } else {
                fr3Var.b.set(rect2);
                Rect rect3 = fr3Var.d;
                rect3.set(rect2);
                int i10 = -fr3Var.e;
                rect3.inset(i10, i10);
                fr3Var.c.set(rect);
            }
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public final void onMeasure(int i, int i2) {
        int i3;
        if (this.j1) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE) {
            int i4 = this.p1;
            size = i4 > 0 ? Math.min(i4, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.p1;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i3 = this.p1) > 0) {
            size = Math.min(i3, size);
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, Pow2.MAX_POW2), View.MeasureSpec.makeMeasureSpec(size2, Pow2.MAX_POW2));
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof er3)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        er3 er3Var = (er3) parcelable;
        super.onRestoreInstanceState(er3Var.b);
        x(er3Var.z);
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        er3 er3Var = new er3(super.onSaveInstanceState());
        er3Var.z = this.j1;
        return er3Var;
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        post(this.x1);
    }

    public final void p(CharSequence charSequence) {
        setQuery(charSequence);
    }

    public final void q() {
        SearchAutoComplete searchAutoComplete = this.J0;
        Editable text = searchAutoComplete.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        cr3 cr3Var = this.e1;
        if (cr3Var == null || !cr3Var.i(text.toString())) {
            if (this.v1 != null) {
                getContext().startActivity(j("android.intent.action.SEARCH", null, null, text.toString()));
            }
            searchAutoComplete.setImeVisibility(false);
            searchAutoComplete.dismissDropDown();
        }
    }

    public final void r(boolean z) {
        SearchAutoComplete searchAutoComplete = this.J0;
        searchAutoComplete.setText("");
        searchAutoComplete.setSelection(searchAutoComplete.length());
        this.s1 = "";
        if (!z || TextUtils.isEmpty("")) {
            return;
        }
        q();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean requestFocus(int i, Rect rect) {
        if (this.o1 || !isFocusable()) {
            return false;
        }
        if (this.j1) {
            return super.requestFocus(i, rect);
        }
        boolean zRequestFocus = this.J0.requestFocus(i, rect);
        if (zRequestFocus) {
            x(false);
        }
        return zRequestFocus;
    }

    public final void s() {
        boolean zIsEmpty = TextUtils.isEmpty(this.J0.getText());
        int i = (!zIsEmpty || (this.i1 && !this.t1)) ? 0 : 8;
        ImageView imageView = this.P0;
        imageView.setVisibility(i);
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            drawable.setState(!zIsEmpty ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    public void setAppSearchData(Bundle bundle) {
        this.w1 = bundle;
    }

    public void setIconified(boolean z) {
        if (z) {
            m();
            return;
        }
        x(false);
        SearchAutoComplete searchAutoComplete = this.J0;
        searchAutoComplete.requestFocus();
        searchAutoComplete.setImeVisibility(true);
        View.OnClickListener onClickListener = this.h1;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.i1 == z) {
            return;
        }
        this.i1 = z;
        x(z);
        u();
    }

    public void setImeOptions(int i) {
        this.J0.setImeOptions(i);
    }

    public void setInputType(int i) {
        this.J0.setInputType(i);
    }

    public void setMaxWidth(int i) {
        this.p1 = i;
        requestLayout();
    }

    public void setOnCloseListener(br3 br3Var) {
        this.f1 = br3Var;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.g1 = onFocusChangeListener;
    }

    public void setOnQueryTextListener(cr3 cr3Var) {
        this.e1 = cr3Var;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.h1 = onClickListener;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.m1 = charSequence;
        u();
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.n1 = z;
        og0 og0Var = this.k1;
        if (og0Var instanceof p54) {
            ((p54) og0Var).G0 = z ? 2 : 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.v1 = searchableInfo;
        Intent intent = null;
        boolean z = true;
        SearchAutoComplete searchAutoComplete = this.J0;
        if (searchableInfo != null) {
            searchAutoComplete.setThreshold(searchableInfo.getSuggestThreshold());
            searchAutoComplete.setImeOptions(this.v1.getImeOptions());
            int inputType = this.v1.getInputType();
            if ((inputType & 15) == 1) {
                inputType &= -65537;
                if (this.v1.getSuggestAuthority() != null) {
                    inputType |= 589824;
                }
            }
            searchAutoComplete.setInputType(inputType);
            og0 og0Var = this.k1;
            if (og0Var != null) {
                og0Var.b(null);
            }
            if (this.v1.getSuggestAuthority() != null) {
                p54 p54Var = new p54(getContext(), this, this.v1, this.z1);
                this.k1 = p54Var;
                searchAutoComplete.setAdapter(p54Var);
                ((p54) this.k1).G0 = this.n1 ? 2 : 1;
            }
            u();
        }
        SearchableInfo searchableInfo2 = this.v1;
        if (searchableInfo2 == null || !searchableInfo2.getVoiceSearchEnabled()) {
            z = false;
        } else {
            if (this.v1.getVoiceSearchLaunchWebSearch()) {
                intent = this.b1;
            } else if (this.v1.getVoiceSearchLaunchRecognizer()) {
                intent = this.c1;
            }
            if (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) {
            }
        }
        this.q1 = z;
        if (z) {
            searchAutoComplete.setPrivateImeOptions("nm");
        }
        x(this.j1);
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.l1 = z;
        x(this.j1);
    }

    public void setSuggestionsAdapter(og0 og0Var) {
        this.k1 = og0Var;
        this.J0.setAdapter(og0Var);
    }

    public final void t() {
        int[] iArr = this.J0.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.L0.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.M0.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void u() {
        CharSequence queryHint = getQueryHint();
        CharSequence charSequence = queryHint;
        if (queryHint == null) {
            charSequence = "";
        }
        boolean z = this.i1;
        SearchAutoComplete searchAutoComplete = this.J0;
        CharSequence charSequence2 = charSequence;
        if (z) {
            Drawable drawable = this.Y0;
            charSequence2 = charSequence;
            if (drawable != null) {
                int textSize = (int) (((double) searchAutoComplete.getTextSize()) * 1.25d);
                drawable.setBounds(0, 0, textSize, textSize);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
                spannableStringBuilder.setSpan(new ImageSpan(drawable), 1, 2, 33);
                spannableStringBuilder.append(charSequence);
                charSequence2 = spannableStringBuilder;
            }
        }
        searchAutoComplete.setHint(charSequence2);
    }

    public final void v() {
        this.M0.setVisibility(((this.l1 || this.q1) && !this.j1 && (this.O0.getVisibility() == 0 || this.Q0.getVisibility() == 0)) ? 0 : 8);
    }

    public final void w(boolean z) {
        boolean z2 = this.l1;
        this.O0.setVisibility((!z2 || !(z2 || this.q1) || this.j1 || !hasFocus() || (!z && this.q1)) ? 8 : 0);
    }

    public final void x(boolean z) {
        this.j1 = z;
        int i = 8;
        int i2 = z ? 0 : 8;
        boolean zIsEmpty = TextUtils.isEmpty(this.J0.getText());
        this.N0.setVisibility(i2);
        w(!zIsEmpty);
        this.K0.setVisibility(z ? 8 : 0);
        ImageView imageView = this.X0;
        imageView.setVisibility((imageView.getDrawable() == null || this.i1) ? 8 : 0);
        s();
        if (this.q1 && !this.j1 && zIsEmpty) {
            this.O0.setVisibility(8);
            i = 0;
        }
        this.Q0.setVisibility(i);
        v();
    }

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static class SearchAutoComplete extends da {
        public boolean A0;
        public final d B0;
        public int y0;
        public SearchView z0;

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.B0 = new d(this);
            this.y0 = getThreshold();
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i2 = configuration.screenHeightDp;
            if (i >= 960 && i2 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i < 600) {
                return (i < 640 || i2 < 480) ? 160 : 192;
            }
            return 192;
        }

        public final void a() {
            if (Build.VERSION.SDK_INT >= 29) {
                c.b(this, 1);
                if (enoughToFilter()) {
                    showDropDown();
                    return;
                }
                return;
            }
            nm2 nm2Var = SearchView.A1;
            nm2Var.getClass();
            nm2.a();
            Method method = nm2Var.c;
            if (method != null) {
                try {
                    method.invoke(this, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public final boolean enoughToFilter() {
            return this.y0 <= 0 || super.enoughToFilter();
        }

        @Override // defpackage.da, android.widget.TextView, android.view.View
        public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.A0) {
                d dVar = this.B0;
                removeCallbacks(dVar);
                post(dVar);
            }
            return inputConnectionOnCreateInputConnection;
        }

        @Override // android.view.View
        public final void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            SearchView searchView = this.z0;
            searchView.x(searchView.j1);
            searchView.post(searchView.x1);
            if (searchView.J0.hasFocus()) {
                searchView.l();
            }
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.z0.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.z0.hasFocus() && getVisibility() == 0) {
                this.A0 = true;
                Context context = getContext();
                nm2 nm2Var = SearchView.A1;
                if (context.getResources().getConfiguration().orientation == 2) {
                    a();
                }
            }
        }

        public void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            d dVar = this.B0;
            if (!z) {
                this.A0 = false;
                removeCallbacks(dVar);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (!inputMethodManager.isActive(this)) {
                    this.A0 = true;
                    return;
                }
                this.A0 = false;
                removeCallbacks(dVar);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        public void setSearchView(SearchView searchView) {
            this.z0 = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i) {
            super.setThreshold(i);
            this.y0 = i;
        }

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        @Override // android.widget.AutoCompleteTextView
        public final void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        public final void replaceText(CharSequence charSequence) {
        }
    }

    public void setOnSuggestionListener(dr3 dr3Var) {
    }

    public SearchView(Context context) {
        this(context, null);
    }
}

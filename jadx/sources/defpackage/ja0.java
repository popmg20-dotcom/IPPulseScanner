package defpackage;

import java.io.PrintStream;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public interface ja0 {
    public static final int A;
    public static final boolean B;
    public static final boolean C;
    public static final int D;
    public static final int E;
    public static final int F;
    public static final PrintStream G;
    public static final boolean H;
    public static final boolean I;
    public static final boolean J;
    public static final boolean K;
    public static final boolean L;
    public static final boolean M;
    public static final boolean N;
    public static final int a = ek0.m("joni.regex_max_length", -1);
    public static final int b;
    public static final boolean c;
    public static final int d;
    public static final boolean e;
    public static final boolean f;
    public static final boolean g;
    public static final boolean h;
    public static final boolean i;
    public static final boolean j;
    public static final boolean k;
    public static final boolean l;
    public static final boolean m;
    public static final boolean n;
    public static final boolean o;
    public static final boolean p;
    public static final boolean q;
    public static final boolean r;
    public static final boolean s;
    public static final boolean t;
    public static final int u;
    public static final int v;
    public static final int w;
    public static final int x;
    public static final boolean y;
    public static final boolean z;

    static {
        int iM = ek0.m("joni.char_table_size", 256);
        b = iM;
        boolean z2 = true;
        c = ek0.k("joni.use_no_invalid_quantifier", true);
        d = ek0.m("joni.scanenv_memnodes_size", 8);
        e = ek0.k("joni.use_named_group", true);
        f = ek0.k("joni.use_subexp_call", true);
        g = ek0.k("joni.use_perl_subexp_call", true);
        h = ek0.k("joni.use_backref_with_level", true);
        i = ek0.k("joni.use_monomaniac_check_captures_in_endless_repeat", true);
        j = ek0.k("joni.use_newline_at_end_of_string_has_empty_line", true);
        k = ek0.k("joni.use_warning_redundant_nested_repeat_operator", true);
        l = ek0.k("joni.case_fold_is_applied_inside_negative_cclass", true);
        m = ek0.k("joni.use_match_range_must_be_inside_of_specified_range", false);
        n = ek0.k("joni.use_capture_history", false);
        o = ek0.k("joni.use_variable_meta_chars", true);
        p = ek0.k("joni.use_word_begin_end", true);
        q = ek0.k("joni.use_find_longest_search_all_of_range", true);
        r = ek0.k("joni.use_sunday_quick_search", true);
        s = ek0.k("joni.use_cec", false);
        ek0.k("joni.use_dynamic_option", false);
        t = ek0.k("joni.use_byte_map", 24 <= iM);
        ek0.k("joni.use_int_map_backward", false);
        ek0.m("joni.nregion", 10);
        u = ek0.m("joni.max_backref_num", 1000);
        v = ek0.m("joni.max_capture_group_num", 32767);
        w = ek0.m("joni.max_multi_byte_ranges_num", 100000);
        x = ek0.m("joni.max_multi_byte_ranges_num", 10000);
        y = ek0.k("joni.use_op_push_or_jump_exact", true);
        z = ek0.k("joni.use_qtfr_peek_next", true);
        A = ek0.m("joni.init_match_stack_size", 64);
        B = !ek0.k("joni.optimize", true);
        C = ek0.k("joni.use_string_templates", true);
        D = ek0.m("joni.max_capture_history_group", 31);
        E = ek0.m("joni.check_string_threshold_len", 7);
        F = ek0.m("joni.check_buff_max_size", 16384);
        G = System.out;
        boolean zK = ek0.k("joni.debug.all", false);
        H = ek0.k("joni.debug", false) || zK;
        I = ek0.k("joni.debug.parse.tree", false) || zK;
        J = ek0.k("joni.debug.parse.tree.raw", true) || zK;
        K = ek0.k("joni.debug.compile", false) || zK;
        L = ek0.k("joni.debug.compile.bytecode.info", false) || zK;
        M = ek0.k("joni.debug.search", false) || zK;
        if (!ek0.k("joni.debug.match", false) && !zK) {
            z2 = false;
        }
        N = z2;
    }
}

package defpackage;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class iu3 {
    public static final Map a = fh2.V(new e03("OutboundMode", xw2.X), new e03("ColumnSize", v70.X), new e03("ProxyListSortMode", mb3.X), new e03("BypassListSortMode", ot.Y));
    public static final List b = e70.K("webdav_server", "webdav_account", "webdav_password", "color_palette_theme_key", "dark_mode", "traffic_statistics", "lan_share_listen", "lan_share_http_port", "lan_share_socks5_port", "override_ipv6", "tls_fingerprint", "profile_fetch_timeout");
    public static final List c = p95.x("mtu");
    public static final List d = e70.K("using_white_list_mode", "hide_system_apps", "hide_offline_apps", "hide_disabled_apps", "public_ip_visible", "pure_dark", "bypass_list_compatible_mode", "bypass_list_enabled", "allow_lan", "bypass_tls_verify", "force_udp_relay", "force_remote_dns", "auto_fix_dns_poisoning", "disable_check_notification", "update_profiles_after_vpn_established", "display_network_speed_in_status_bar", "logcat_output", "use_external_editor", "lan_share", "allow_bypass", "sshdump", "enable_vpn_http_proxy", "tcp_keep_alive", "start_when_boot", "profile_list_actions", "auto_collapse_notification", "hide_status_bar_icon_and_notification", "setting_notification_chronometer", "hide_from_recent_task", "masked_from_recent_task", "accessibility_mode");
    public static final List e = e70.K("white_list", "black_list", "override_doh_v2");
    public static final List f;

    static {
        fu3 fu3Var = fu3.X;
        f = e70.K(new eu3("proxy_outbound_mode", fu3Var, "OutboundMode"), new eu3("proxy_column_size", fu3Var, "ColumnSize"), new eu3("proxy_list_sort", fu3Var, "ProxyListSortMode"), new eu3("bypass_list_sort_mode", fu3Var, "BypassListSortMode"));
    }
}

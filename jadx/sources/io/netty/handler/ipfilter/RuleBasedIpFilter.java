package io.netty.handler.ipfilter;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
@ChannelHandler.Sharable
public class RuleBasedIpFilter extends AbstractRemoteAddressFilter<InetSocketAddress> {
    private final boolean acceptIfNotFound;
    private final List<IpFilterRule> rules;

    public RuleBasedIpFilter(boolean z, IpFilterRule... ipFilterRuleArr) {
        ObjectUtil.checkNotNull(ipFilterRuleArr, "rules");
        this.acceptIfNotFound = z;
        this.rules = new ArrayList(ipFilterRuleArr.length);
        for (IpFilterRule ipFilterRule : ipFilterRuleArr) {
            if (ipFilterRule != null) {
                this.rules.add(ipFilterRule);
            }
        }
    }

    @Override // io.netty.handler.ipfilter.AbstractRemoteAddressFilter
    public boolean accept(ChannelHandlerContext channelHandlerContext, InetSocketAddress inetSocketAddress) {
        for (IpFilterRule ipFilterRule : this.rules) {
            if (ipFilterRule.matches(inetSocketAddress)) {
                return ipFilterRule.ruleType() == IpFilterRuleType.ACCEPT;
            }
        }
        return this.acceptIfNotFound;
    }

    public RuleBasedIpFilter(IpFilterRule... ipFilterRuleArr) {
        this(true, ipFilterRuleArr);
    }
}

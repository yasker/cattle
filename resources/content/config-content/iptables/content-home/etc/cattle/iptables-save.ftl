<#assign primaryNic = "eth0">

*filter
:INPUT DROP [0:0]
:FORWARD ACCEPT [0:0]
:OUTPUT ACCEPT [0:0]

# Allow established traffic
-A INPUT -i ${primaryNic} -m state --state RELATED,ESTABLISHED -j ACCEPT

# DHCP/DNS
-A INPUT -i ${primaryNic} -p udp --dport 67 -j ACCEPT
-A INPUT -i ${primaryNic} -p udp --dport 53 -j ACCEPT
-A INPUT -i ${primaryNic} -p tcp --dport 53 -j ACCEPT

# IPsec
-A INPUT -i ${primaryNic} -p udp --dport 500 -j ACCEPT
-A INPUT -i ${primaryNic} -p udp --dport 4500 -j ACCEPT

# ICMP
-A INPUT -i ${primaryNic} -p icmp -j ACCEPT

# loopback
-A INPUT -i lo -j ACCEPT

# Node Services
-A INPUT -p tcp --dport 8080 -j ACCEPT

COMMIT

*nat
:PREROUTING ACCEPT [0:0]
:INPUT ACCEPT [0:0]
:OUTPUT ACCEPT [0:0]
:POSTROUTING ACCEPT [0:0]

<#list links as linkData>
    <#assign link = linkData.link>
    <#if link.linkName?? && (link.data.fields.ports)?? >
# Links for link ${link.uuid}
        <#list link.data.fields.ports as port >
            <#if port.privatePort?? && port.publicPort?? && port.protocol?? && port.ipAddress?? && linkData.target.address?? >
-A PREROUTING -i ${primaryNic} -p ${port.protocol} --dport ${port.publicPort} -d ${port.ipAddress} -j MARK --set-mark 100
-A PREROUTING -i ${primaryNic} -p ${port.protocol} --dport ${port.publicPort} -d ${port.ipAddress} -j DNAT --to ${linkData.target.address}:${port.privatePort}
            </#if>
        </#list>
    </#if>
</#list>

-A POSTROUTING -o ${primaryNic} -m mark --mark 100 -j MASQUERADE

<#if serviceSet?seq_contains("metadataService") >
    <#list services["metadataService"].nicNames as nic >
-A PREROUTING -p tcp -m addrtype --dst-type LOCAL --dport 80 -i ${nic} -j DNAT --to :8080
        <#list vnetClients as vnetClient >
            <#if (vnetClient.ipAddress)?? && (vnetClient.macAddress)?? >
# Metadata mapping
-A INPUT -m mac --mac-source ${vnetClient.macAddress} -p tcp -m addrtype --dst-type LOCAL -i ${nic} -j SNAT --to-source ${vnetClient.ipAddress}
            </#if>

        </#list>
    </#list>
</#if>

<#list subnets as subnet >
-A POSTROUTING -s ${subnet.gateway}/32 -o ${primaryNic} -j MASQUERADE
</#list>
COMMIT

*mangle

# Fix DHCP packets
-A POSTROUTING -p udp --dport bootpc -j CHECKSUM --checksum-fill

COMMIT

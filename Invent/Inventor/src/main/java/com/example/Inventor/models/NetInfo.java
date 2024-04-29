package com.example.Inventor.models;

import jakarta.persistence.*;

@Entity
@Table(name = "NetInfo")
public class NetInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "PrefixOrigin")
    private String prefixOrigin;
    @Column(name = "SuffixOrigin")
    private String suffixOrigin;
    @Column(name = "Type")
    private String type;
    @Column(name = "Store")
    private String store;
    @Column(name = "AddressFamily")
    private String addressFamily;
    @Column(name = "AddressState")
    private String addressState;
    @Column(name = "ProtocolIFType")
    private String protocolIFType;
    @Column(name = "IPv4Address")
    private String iPv4Address;
    @Column(name = "IPv6Address")
    private String iPv6Address;
    @Column(name = "InterfaceAlias")
    private String interfaceAlias;
    @Column(name = "InterfaceIndex")
    private String interfaceIndex;
    @Column(name = "IPAddress")
    private String iPAddress;
    @ManyToOne
    @JoinColumn(name = "Report_ID")
    private Report report;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrefixOrigin() {
        return prefixOrigin;
    }

    public void setPrefixOrigin(String prefixOrigin) {
        this.prefixOrigin = prefixOrigin;
    }

    public String getSuffixOrigin() {
        return suffixOrigin;
    }

    public void setSuffixOrigin(String suffixOrigin) {
        this.suffixOrigin = suffixOrigin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getAddressFamily() {
        return addressFamily;
    }

    public void setAddressFamily(String addressFamily) {
        this.addressFamily = addressFamily;
    }

    public String getAddressState() {
        return addressState;
    }

    public void setAddressState(String addressState) {
        this.addressState = addressState;
    }

    public String getProtocolIFType() {
        return protocolIFType;
    }

    public void setProtocolIFType(String protocolIFType) {
        this.protocolIFType = protocolIFType;
    }

    public String getiPv4Address() {
        return iPv4Address;
    }

    public void setiPv4Address(String iPv4Address) {
        this.iPv4Address = iPv4Address;
    }

    public String getiPv6Address() {
        return iPv6Address;
    }

    public void setiPv6Address(String iPv6Address) {
        this.iPv6Address = iPv6Address;
    }

    public String getInterfaceAlias() {
        return interfaceAlias;
    }

    public void setInterfaceAlias(String interfaceAlias) {
        this.interfaceAlias = interfaceAlias;
    }

    public String getInterfaceIndex() {
        return interfaceIndex;
    }

    public void setInterfaceIndex(String interfaceIndex) {
        this.interfaceIndex = interfaceIndex;
    }

    public String getiPAddress() {
        return iPAddress;
    }

    public void setiPAddress(String iPAddress) {
        this.iPAddress = iPAddress;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }
}
package com.littlebug.bean;

import java.util.Date;

public class Manufacture {
    private String manufactureSn;

    private String orderId;

    private String technologyId;

    private Integer launchQuantity;

    private Date beginDate;

    private Date endDate;

    private COrder order;

    private Technology technology;

    public String getManufactureSn() {
        return manufactureSn;
    }

    public void setManufactureSn(String manufactureSn) {
        this.manufactureSn = manufactureSn == null ? null : manufactureSn.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(String technologyId) {
        this.technologyId = technologyId == null ? null : technologyId.trim();
    }

    public Integer getLaunchQuantity() {
        return launchQuantity;
    }

    public void setLaunchQuantity(Integer launchQuantity) {
        this.launchQuantity = launchQuantity;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public COrder getOrder() {
        return order;
    }

    public void setOrder(COrder order) {
        this.order = order;
    }

    public Technology getTechnology() {
        return technology;
    }

    public void setTechnology(Technology technology) {
        this.technology = technology;
    }

    @Override
    public String toString() {
        return "Manufacture{" +
                "manufactureSn='" + manufactureSn + '\'' +
                ", orderId='" + orderId + '\'' +
                ", technologyId='" + technologyId + '\'' +
                ", launchQuantity=" + launchQuantity +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", order=" + order +
                ", technology=" + technology +
                '}';
    }
}
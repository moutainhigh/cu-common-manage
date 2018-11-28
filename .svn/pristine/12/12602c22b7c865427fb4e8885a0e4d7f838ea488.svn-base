package com.aotain.cu.serviceapi.model;


import java.io.Serializable;
import java.util.Objects;

public class ServiceDomainInformation extends BaseModel implements Serializable {

    private Long domainId;

    private Long serviceId;

    private Long userId;

    private String domainName;

    private Integer operationType; // 操作类型（1-新增、2-修改(变更)，3-删除）

    public Long getDomainId() {
        return domainId;
    }

    public void setDomainId(Long domainId) {
        this.domainId = domainId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public Integer getOperationType() {
        return operationType;
    }

    public void setOperationType(Integer operationType) {
        this.operationType = operationType;
    }

    @Override
    public String toString() {
        return "ServiceDomainInformation [domainId="
               + (domainId == null ? "null" : domainId.longValue()) + ",domainName="
               + (domainName == null ? "" : domainName) + ",serviceId="
               + (serviceId == null ? "null" : serviceId.longValue()) + ",userId="
               + (userId == null ? "null" : userId.longValue()) + ",operationType="
               + (operationType == null ? "null" : operationType.intValue()) + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceDomainInformation that = (ServiceDomainInformation) o;
        return Objects.equals(domainId, that.domainId) &&
                Objects.equals(serviceId, that.serviceId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(domainId, serviceId);
    }
}

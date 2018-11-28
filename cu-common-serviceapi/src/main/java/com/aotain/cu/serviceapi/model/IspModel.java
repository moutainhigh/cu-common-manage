package com.aotain.cu.serviceapi.model;

import java.io.Serializable;

public class IspModel extends BaseModel implements Serializable{

    private Long id;
    private String unitName;
    private Byte filterMode;

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName( String unitName ) {
        this.unitName = unitName;
    }

    public Byte getFilterMode() {
        return filterMode;
    }

    public void setFilterMode( Byte filterMode ) {
        this.filterMode = filterMode;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    @Override
    public boolean equals( Object obj ) {
        IspModel o = (IspModel)obj;
        if (this.unitName!=null && o!=null && o.getUnitName()!=null){
            return this.unitName.equals((o.getUnitName()));
        }
        return false;
    }
}

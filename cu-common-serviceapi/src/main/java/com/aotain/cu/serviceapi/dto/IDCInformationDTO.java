package com.aotain.cu.serviceapi.dto;

import java.io.Serializable;

import com.aotain.cu.annotation.ExpSheet;
import com.aotain.cu.annotation.Export;
import com.aotain.cu.serviceapi.model.IdcInformation;

@ExpSheet(name="经营者信息")
public class IDCInformationDTO extends IdcInformation implements Serializable {

	private static final long serialVersionUID = -5021450653377022941L;
	
	@Export(title="*网络信息安全责任人证件类型", id=8)
	private String officerIdTypeStr;
	
	@Export(title="*应急联系人证件类型", id=14)
	private String ecIdTypeStr;

	public String getOfficerIdTypeStr() {
		return officerIdTypeStr;
	}

	public String getEcIdTypeStr() {
		return ecIdTypeStr;
	}

	public void setOfficerIdTypeStr(String officerIdTypeStr) {
		this.officerIdTypeStr = officerIdTypeStr;
	}

	public void setEcIdTypeStr(String ecIdTypeStr) {
		this.ecIdTypeStr = ecIdTypeStr;
	}
	
}

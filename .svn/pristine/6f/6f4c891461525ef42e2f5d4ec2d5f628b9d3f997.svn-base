package com.aotain.cu.serviceapi.model;

import java.io.Serializable;
import java.util.List;

import com.aotain.cu.annotation.Export;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;

@ApiModel("HouseInformation")
public class HouseInformation extends BaseModel implements Serializable {

	private static final long serialVersionUID = -7712463091602324673L;

	private Long houseSeqId;

	private Long submitId;

	private Long houseId;

	private Integer jyzId; // 经营者信息ID

	@Export(title = "机房编号(与设备定义机房ID一致)", id = 2)
	private String houseIdStr; // 机房编码，与EU设备定义机房编码一致

	@Export(title = "机房名称", id = 3)
	private String houseName; // 机房名称，与许可证上名称一致

	private Integer houseType; // 机房性质（1——租用、2——自建，999——其他）

	private Integer houseProvince; // 机房所在省或直辖市

	private Integer houseCity; // 机房所在市或区（县）

	private Integer houseCounty; // 机房所在县

	@Export(title = "机房地址", id = 6)
	private String houseAddress; // 机房地址

	private String houseZipCode; // 对应机房通信地址的邮编

	@Export(title = "网络信息安全责任人姓名", id = 7)
	private String houseOfficerName; // 机房负责人-人员姓名

	private Integer houseOfficerIdType; // 机房负责人-人员的证件类型(有效类型只有：2-身份证、7-护照、8-军官证，9-台胞证）

	@Export(title = "网络信息安全责任人证件号码", id = 9)
	private String houseOfficerId; // 机房负责人-对应的证件号码

	@Export(title = "网络信息安全责任人固定电话", id = 10)
	private String houseOfficerTelephone; // 机房负责人-固定电话

	@Export(title = "网络信息安全责任人移动电话", id = 11)
	private String houseOfficerMobile; // 机房负责人-移动电话

	@Export(title = "网络信息安全责任人Email", id = 12)
	private String houseOfficerEmail; // 机房负责人-email地址

	private List<HouseIPSegmentInformation> ipSegList;
	private List<HouseFrameInformation> frameList;
	private List<HouseGatewayInformation> gatewayInfoList;

	@JsonIgnore
	//隶属于 HouseFrameInformation 里面的字段,
	private List<HouseUserFrameInformation> userFrameList;

	@JsonIgnore
	//挂在该机房下面的用户
	private List<UserInformation> belongUsers;

	public Long getHouseId() {
		return houseId;
	}

	public Integer getJyzId() {
		return jyzId;
	}

	public String getHouseIdStr() {
		return houseIdStr;
	}

	public String getHouseName() {
		return houseName;
	}

	public Integer getHouseType() {
		return houseType;
	}

	public Integer getHouseProvince() {
		return houseProvince;
	}

	public Integer getHouseCity() {
		return houseCity;
	}

	public Integer getHouseCounty() {
		return houseCounty;
	}

	public String getHouseAddress() {
		return houseAddress;
	}

	public String getHouseZipCode() {
		return houseZipCode;
	}

	public String getHouseOfficerName() {
		return houseOfficerName;
	}

	public Integer getHouseOfficerIdType() {
		return houseOfficerIdType;
	}

	public String getHouseOfficerId() {
		return houseOfficerId;
	}

	public String getHouseOfficerTelephone() {
		return houseOfficerTelephone;
	}

	public String getHouseOfficerMobile() {
		return houseOfficerMobile;
	}

	public String getHouseOfficerEmail() {
		return houseOfficerEmail;
	}

	public List<HouseIPSegmentInformation> getIpSegList() {
		return ipSegList;
	}

	public List<HouseFrameInformation> getFrameList() {
		return frameList;
	}

	public List<HouseGatewayInformation> getGatewayInfoList() {
		return gatewayInfoList;
	}

	public void setHouseId(Long houseId) {
		this.houseId = houseId;
	}

	public void setJyzId(Integer jyzId) {
		this.jyzId = jyzId;
	}

	public void setHouseIdStr(String houseIdStr) {
		this.houseIdStr = houseIdStr;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public void setHouseType(Integer houseType) {
		this.houseType = houseType;
	}

	public void setHouseProvince(Integer houseProvince) {
		this.houseProvince = houseProvince;
	}

	public void setHouseCity(Integer houseCity) {
		this.houseCity = houseCity;
	}

	public void setHouseCounty(Integer houseCounty) {
		this.houseCounty = houseCounty;
	}

	public void setHouseAddress(String houseAddress) {
		this.houseAddress = houseAddress;
	}

	public void setHouseZipCode(String houseZipCode) {
		this.houseZipCode = houseZipCode;
	}

	public void setHouseOfficerName(String houseOfficerName) {
		this.houseOfficerName = houseOfficerName;
	}

	public void setHouseOfficerIdType(Integer houseOfficerIdType) {
		this.houseOfficerIdType = houseOfficerIdType;
	}

	public void setHouseOfficerId(String houseOfficerId) {
		this.houseOfficerId = houseOfficerId;
	}

	public void setHouseOfficerTelephone(String houseOfficerTelephone) {
		this.houseOfficerTelephone = houseOfficerTelephone;
	}

	public void setHouseOfficerMobile(String houseOfficerMobile) {
		this.houseOfficerMobile = houseOfficerMobile;
	}

	public void setHouseOfficerEmail(String houseOfficerEmail) {
		this.houseOfficerEmail = houseOfficerEmail;
	}

	public void setIpSegList(List<HouseIPSegmentInformation> ipSegList) {
		this.ipSegList = ipSegList;
	}

	public void setFrameList(List<HouseFrameInformation> frameList) {
		this.frameList = frameList;
	}

	public void setGatewayInfoList(List<HouseGatewayInformation> gatewayInfoList) {
		this.gatewayInfoList = gatewayInfoList;
	}

	public List<HouseUserFrameInformation> getUserFrameList() {
		return userFrameList;
	}

	public void setUserFrameList( List<HouseUserFrameInformation> userFrameList ) {
		this.userFrameList = userFrameList;
	}

	public Long getSubmitId() {
		return submitId;
	}

	public void setSubmitId(Long submitId) {
		this.submitId = submitId;
	}

	public Long getHouseSeqId() {
		return houseSeqId;
	}

	public void setHouseSeqId(Long houseSeqId) {
		this.houseSeqId = houseSeqId;
	}

	public List<UserInformation> getBelongUsers() {
		return belongUsers;
	}

	public void setBelongUsers( List<UserInformation> belongUsers ) {
		this.belongUsers = belongUsers;
	}
}

package com.aotain.cu.serviceapi.model;

import com.aotain.cu.serviceapi.model.permission.DataPermissionSetting;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ImportTaskModel implements Serializable {

    private Long taskId;
    //任务类型，1-经营者信息导入、2-机房信息导入、3-用户信息导入
    private Integer taskType;
    //导入类型，1-追加导入、2-覆盖导入
    private Integer importType;
    //导入文件名
    private String fileName;
    //状态，1-正在导入，2-导入成功，3-导入失败
    private Integer status;
    private String errorFileName;
    private Long createUserId;
    private Integer updateUserId;
    private Date createTime;
    private Date finishTime;
    //处理服务器IP
    private String serverIp;

    private List<String> cityCodeList;
    private List<String> userAuthHouseList;
    private List<String> userAuthIdentityList;

    /**
     * 机房的分权分域数据信息
     */
    //分权分域数据ID
    private Integer dataPermissionId;
    //系统IP
    private Integer appId;
    //分权分域字段
    private String dataPermissionToken;
    //分权分域显示名称
    private String dataPermissionName;
    //分权分域显示备注
    private String dataPermissionDesc;
    private String permissionMethodUrl;
    private String userToken;
    private List<DataPermissionSetting> dataPermissionSettingList;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId( Long taskId ) {
        this.taskId = taskId;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType( Integer taskType ) {
        this.taskType = taskType;
    }

    public Integer getImportType() {
        return importType;
    }

    public void setImportType( Integer importType ) {
        this.importType = importType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName( String fileName ) {
        this.fileName = fileName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus( Integer status ) {
        this.status = status;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId( Long createUserId ) {
        this.createUserId = createUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime( Date createTime ) {
        this.createTime = createTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime( Date finishTime ) {
        this.finishTime = finishTime;
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp( String serverIp ) {
        this.serverIp = serverIp;
    }

    public List<String> getCityCodeList() {
        return cityCodeList;
    }

    public void setCityCodeList( List<String> cityCodeList ) {
        this.cityCodeList = cityCodeList;
    }

    public String getErrorFileName() {
        return errorFileName;
    }

    public void setErrorFileName( String errorFileName ) {
        this.errorFileName = errorFileName;
    }

    public List<String> getUserAuthHouseList() {
        return userAuthHouseList;
    }

    public void setUserAuthHouseList( List<String> userAuthHouseList ) {
        this.userAuthHouseList = userAuthHouseList;
    }

    public List<String> getUserAuthIdentityList() {
        return userAuthIdentityList;
    }

    public void setUserAuthIdentityList( List<String> userAuthIdentityList ) {
        this.userAuthIdentityList = userAuthIdentityList;
    }

    public Integer getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Integer getDataPermissionId() {
        return dataPermissionId;
    }

    public void setDataPermissionId(Integer dataPermissionId) {
        this.dataPermissionId = dataPermissionId;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getDataPermissionToken() {
        return dataPermissionToken;
    }

    public void setDataPermissionToken(String dataPermissionToken) {
        this.dataPermissionToken = dataPermissionToken;
    }

    public String getDataPermissionName() {
        return dataPermissionName;
    }

    public void setDataPermissionName(String dataPermissionName) {
        this.dataPermissionName = dataPermissionName;
    }

    public String getDataPermissionDesc() {
        return dataPermissionDesc;
    }

    public void setDataPermissionDesc(String dataPermissionDesc) {
        this.dataPermissionDesc = dataPermissionDesc;
    }

    public String getPermissionMethodUrl() {
        return permissionMethodUrl;
    }

    public void setPermissionMethodUrl(String permissionMethodUrl) {
        this.permissionMethodUrl = permissionMethodUrl;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public List<DataPermissionSetting> getDataPermissionSettingList() {
        return dataPermissionSettingList;
    }

    public void setDataPermissionSettingList(List<DataPermissionSetting> dataPermissionSettingList) {
        this.dataPermissionSettingList = dataPermissionSettingList;
    }
}

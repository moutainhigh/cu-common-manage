package com.aotain.common.config.dao;


import com.aotain.common.config.annotation.MyBatisDao;
import com.aotain.common.config.model.CmdAck;

@MyBatisDao(value="cmdInfoManageMapper")
public interface CmdInfoManageMapper {
   
	void InsertCmdAckInfo(CmdAck ack); 
	
}
package com.aotain.common.policyapi.service;

import java.util.List;

import com.aotain.common.policyapi.model.BindMessage;
import com.aotain.common.utils.monitorstatistics.ExceptionCollector;
import com.aotain.common.utils.monitorstatistics.ModuleConstant;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aotain.common.policyapi.base.BaseService;
import com.aotain.common.policyapi.base.BaseVo;
import com.aotain.common.policyapi.mapper.HousePolicyBindMapper;
import com.aotain.common.policyapi.model.HousePolicyBind;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HousePolicyBindService extends BaseService{

	private static Logger logger = LoggerFactory.getLogger(EuDevicePolicyService.class);
	@Autowired
	private HousePolicyBindMapper mapper;
	public HousePolicyBindMapper getMapper() {
		return mapper;
	}

	@Autowired
	private MessageNameService messageNameService;

	@Autowired
	private ExceptionCollector exceptionCollector;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean addDb(BaseVo policy) {
		setPropertiesBeforeSaveOrUpdate(policy);

		try {
			HousePolicyBind domain=(HousePolicyBind) policy;
			List<BindMessage> bindInfo = domain.getBindInfo();
			for (int i = 0; i < bindInfo.size(); i++) {
				domain.setBindMessageNo(bindInfo.get(i).getBindMessageNo());
				domain.setBindMessageType(bindInfo.get(i).getBindMessageType());
				mapper.insertData(domain);
			}
			//添加数据到messageNo表
			messageNameService.addMessageName(domain);
			return true;
		} catch (Exception e) {
			logger.error(this.getClass().getName()+" addDb error,Param="+policy.objectToJson(),e);
			exceptionCollector.addEvent(e);
            return false;
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean modifyDb(BaseVo policy) {

		setPropertiesBeforeSaveOrUpdate(policy);

		try {
			HousePolicyBind domain=(HousePolicyBind) policy;
			List<BindMessage> bindInfo=domain.getBindInfo();
			for (int i = 0; i < bindInfo.size(); i++) {
				domain.setBindMessageNo(bindInfo.get(i).getBindMessageNo());
				domain.setBindMessageType(bindInfo.get(i).getBindMessageType());
				mapper.updateData(domain);
			}

			if ( domain.getMessageNo()==null ||domain.getMessageNo()==0) {
				HousePolicyBind result = mapper.selectByPrimaryKey(domain.getBindId());
				if ( result != null ){
					domain.setMessageNo(result.getMessageNo());

				}
			}
			return true;

		} catch (Exception e) {
			logger.error(this.getClass().getName()+" modifyDb error,Param="+policy.objectToJson(),e);
			exceptionCollector.addEvent(e);
            return false;
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean deleteDb(BaseVo policy) {
		setPropertiesBeforeSaveOrUpdate(policy);
		try {
			HousePolicyBind domain=(HousePolicyBind) policy;
			HousePolicyBind result = mapper.selectByPrimaryKey(domain.getBindId());
			// 删除时设置绑定messageNo和MessageType
			List<BindMessage> bindInfo = Lists.newArrayList();
			BindMessage bindMessage = new BindMessage();
			bindMessage.setBindMessageNo(result.getBindMessageNo());
			bindMessage.setBindMessageType(result.getBindMessageType());
			bindInfo.add(bindMessage);
			domain.setBindInfo(bindInfo);

			if ( domain.getMessageNo()==null ||domain.getMessageNo()==0) {
				if ( result != null ){
					domain.setMessageNo(result.getMessageNo());

				}
			}

			if(domain.getBindId()==null){
				mapper.deleteByMessageNo(domain);
			}else {
				mapper.deleteData(domain);
			}

			//删除数据到messageNo表
			messageNameService.deleteMessageName(domain);
			return true;
		} catch (Exception e) {
			logger.error(this.getClass().getName()+" deleteDb error,Param="+policy.objectToJson(),e);
			exceptionCollector.addEvent(e);
            return false;
		}
	}

	@Override
	public boolean addCustomLogic(BaseVo policy) {
		boolean success = setPolicyToRedisTask(policy);
		if(!success) {
			logger.error("setPolicyToRedisTask failed...");
			return false;
		}

		return strategySortAndChannelToRedis(policy);
	}

	@Override
	protected boolean modifyCustomLogic(BaseVo policy) {

		return addTaskAndChannelToRedis(policy);
	}

	@Override
	protected boolean deleteCustomLogic(BaseVo policy) {
		boolean success = setPolicyToRedisTask(policy);
		if(!success) {
			logger.error("setPolicyToRedisTask failed...");
			return false;
		}

		return strategySortAndChannelToRedis(policy);
	}
}

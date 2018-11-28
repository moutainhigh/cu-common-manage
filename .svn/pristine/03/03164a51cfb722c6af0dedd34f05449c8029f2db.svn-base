package com.aotain.common.policyapi.service;

import com.aotain.common.policyapi.constant.OperationConstants;
import com.aotain.common.utils.monitorstatistics.ExceptionCollector;
import com.aotain.common.utils.monitorstatistics.ModuleConstant;
import com.aotain.common.utils.redis.MessageNoUtil;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aotain.common.policyapi.base.BaseService;
import com.aotain.common.policyapi.base.BaseVo;
import com.aotain.common.policyapi.mapper.HouseIpMapper;
import com.aotain.common.policyapi.model.HouseIp;
import com.aotain.common.policyapi.model.HouseIpIp;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class HouseIpPolicyService extends BaseService{

	private static Logger logger = LoggerFactory.getLogger(HouseIpPolicyService.class);

	@Autowired
	private HouseIpMapper mapper;
	public HouseIpMapper getMapper() {
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
			// 新增或者修改标志
			boolean update = false;
			HouseIp houseIp=(HouseIp) policy;
			HouseIp result = null;
			if (!StringUtils.isEmpty(houseIp.getHouseId())) {
				result = mapper.selectByHouseId(houseIp.getHouseId());
				if(result!=null){
					update = true;
				}
			}
			//新增或者修改成功标志
			int success = 0;
			//新增
			if (!update){
				// 增加houseIp
				houseIp.setMessageNo(MessageNoUtil.getInstance().getMessageNo(policy.getMessageType()));
				houseIp.setOperationType(OperationConstants.OPERATION_SAVE);
				success = mapper.insertData(houseIp);
			} else {
				houseIp.setMessageNo(result.getMessageNo());
				houseIp.setOperationType(OperationConstants.OPERATION_UPDATE);
				success = mapper.updateData(houseIp);
			}
			if (success>0) {
				addHouseIpIp(houseIp,update);
				if ( !update ) {
					//添加数据到messageNo表
					messageNameService.addMessageName(houseIp);
				}
			}
			if (houseIp.getOperationType()==OperationConstants.OPERATION_UPDATE) {
				houseIp.setOperationType(OperationConstants.OPERATION_SAVE);
			}
			return true;
		} catch (Exception e) {
			logger.error(this.getClass().getName()+" addDb error,Param="+policy.objectToJson(),e);
			exceptionCollector.addEvent(e);
			return false;
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	@Deprecated
	public boolean modifyDb(BaseVo policy) {
		setPropertiesBeforeSaveOrUpdate(policy);
		return true;

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean deleteDb(BaseVo policy) {
		setPropertiesBeforeSaveOrUpdate(policy);
		try {
			HouseIp houseIp=(HouseIp) policy;
			mapper.updateData(houseIp);

			List<HouseIpIp> houseIpIpList = Lists.newArrayList();
			for (HouseIpIp houseIpIp:houseIp.getIPSegments()){
				HouseIpIp result = mapper.selectHouseIpIpBySeqId(houseIpIp.getSeqId());
				houseIpIp.setMessageSequenceNo(policy.getMessageSequenceNo());
				houseIpIp.setHouseIp(result.getHouseIp());
				houseIpIp.setHouseIpPrefix(result.getHouseIpPrefix());
				mapper.deleteHouseIpIp(houseIpIp);

				houseIpIpList.add(houseIpIp);
				houseIp.setIPSegments(houseIpIpList);
			}

			//删除message_no表中数据
			if ( houseIp.getMessageNo()==null || houseIp.getMessageNo()==0) {
				HouseIp result = mapper.selectByHouseId(houseIp.getHouseId());
				houseIp.setMessageNo(result.getMessageNo());
			}
			messageNameService.deleteMessageName(houseIp);
			return true;
		} catch (Exception e) {
			logger.error(this.getClass().getName()+" deleteDb error,Param="+policy.objectToJson(),e);
			exceptionCollector.addEvent(e);
			return false;
		}
	}

	/**
	 * 添加HouseIpIp到数据库
	 */
	private void addHouseIpIp(HouseIp houseIp,boolean update){
		try{
			if(houseIp.getIPSegments()!=null && houseIp.getIPSegments().size()>0){
				for (int j = 0; j < houseIp.getIPSegments().size(); j++) {
					// 添加houseIpIp时，只添加不存在的
					HouseIpIp ass=houseIp.getIPSegments().get(j);
					//新增时设置sequenceNo
					ass.setMessageSequenceNo(houseIp.getMessageSequenceNo());
					int a=mapper.findHouseIpIpCount(ass);
					if(a==0){
						mapper.insertHouseIpIp(ass);
					}
				}
			}
		} catch (Exception e) {
			logger.error(this.getClass().getName()+" addHouseIpIp error,Param="+houseIp.objectToJson(),e);
			exceptionCollector.addEvent(e);
		}

	}

	@Override
	public boolean addCustomLogic(BaseVo policy) {

		return addTaskAndChannelToRedis(policy);
	}

	@Override
	protected boolean modifyCustomLogic(BaseVo policy) {
		return true;
	}

	@Override
	protected boolean deleteCustomLogic(BaseVo policy) {

		return addTaskAndChannelToRedis(policy);
	}
}

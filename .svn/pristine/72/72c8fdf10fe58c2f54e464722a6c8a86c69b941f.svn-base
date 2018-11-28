package com.aotain.common.utils.monitorstatistics;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.apache.hadoop.hive.metastore.HiveMetaException;
import org.apache.hadoop.hive.service.HiveServerException;
import org.apache.hive.service.cli.HiveSQLException;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.kafka.common.KafkaException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import redis.clients.jedis.exceptions.JedisException;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 异常信息搜集处理类
 *
 * @author daiyh@aotain.com
 * @date 2017/12/14
 */
@Component
public class ExceptionCollector {

    private static Logger logger = LoggerFactory.getLogger(ExceptionCollector.class);

    public static final String EXCEPTION_REDIS_KEY = "exception_redis_key";

    private static String EXCEPTION_KEY = "%s_%s_exception";

    public static String THREAD_MONITOR_REDIS_HASH = "thread_monitor_redis";

    public  static String THREAD_MONITOR_KEY = "%s_%s_monitor";

    public static String SERVER_STATUS_KEY = "serverstatus_%s_%s";

    private static String module = "";

    public static int timeInterval = 3 * 60;

    public Map<String,String> monitorMap;

//    @Autowired
//    private BaseRedisService<String,String,String> baseRedisService;

    public ExceptionCollector(){
        monitorMap = Maps.newHashMap();
    }

    /**
     * 添加异常事件
     * @see   ModuleConstant
     * @param module   所属模块
     * @see   TypeConstant
     * @param type     异常类型
     * @param count  异常次数 当type=thread时，需填写此参数，其它情况，设置为0即可
     */
    public boolean addEvent(String module,String type,int count) {
        String key = getExceptionKeyByLocalHost();

        try {
            if ( !checkParam(module,type) ) {
                logger.error("addEvent has been failed,because the parameter is illegal"+
                        "Params[module="+module+"],[type="+type+"],[count="+count+"]");
                return false;
            }
            String field = String.format(EXCEPTION_KEY,module,type);
            if (TypeConstant.EXCEPTION_TYPE_THREAD.equals(type)) {
                monitorMap.put(field,count+"");
//                baseRedisService.putHash(key,field,count+"");

            } else {
                String existValue = monitorMap.get(field);
                int value = existValue==null?0:Integer.valueOf(existValue);
                monitorMap.put(field,++value+"");
//                baseRedisService.hincrByHash(key,field,1L);
            }

        } catch ( Exception e) {
            logger.error("add exception info to redis failed..." +
                    "Params[module="+module+"],[type="+type+"],[count="+count+"]",e);
            return false;
        }
        return true;
    }

    /**
     *
     * @param type
     * @param count
     * @return
     */
    public boolean addEvent(String type,int count){
        return addEvent(module,type,count);
    }

    /**
     * 根据异常类型添加异常监控
     * @param module
     * @param e
     * @return
     */
    public boolean addEvent(String module,Exception e) {
        String type = "";

        if (e instanceof JedisException) {
            type = TypeConstant.EXCEPTION_TYPE_REDIS;
        } else if (e instanceof KafkaException) {
            type = TypeConstant.EXCEPTION_TYPE_KAFKA;
        } else if (e instanceof HiveMetaException || e instanceof HiveSQLException || e instanceof HiveServerException) {
            type = TypeConstant.EXCEPTION_TYPE_HIVE;
        } else if (e instanceof SQLException || e instanceof PersistenceException) {
            type = TypeConstant.EXCEPTION_TYPE_DB;
        } else if (e instanceof NullPointerException || e instanceof NumberFormatException
                || e instanceof IndexOutOfBoundsException || e instanceof IllegalArgumentException
                || e instanceof IOException) {
            type = TypeConstant.EXCEPTION_TYPE_APPLICATION;
        } else {
            type = TypeConstant.EXCEPTION_TYPE_OTHER;
        }

        return addEvent(module,type,0);

    }

    /**
     * 重载方法
     * @param e
     * @return
     */
    public boolean addEvent(Exception e){
        return  addEvent(module,e);
    }

    /**
     * 检查方法参数是否有误
     * @param module
     * @param type
     * @return
     */
    private boolean checkParam(String module,String type) {
        if(StringUtils.isEmpty(module)) {
            logger.error("illegal parameter, module cannot be null or '' ");
            return false;
        }
        List<String> moduleList = addModuleContent();
        if ( !moduleList.contains(module) ) {
            logger.error("the module is not illegal,because it is not under the exception range ");
            return false;
        }
        if(StringUtils.isEmpty(type)) {
            logger.error("illegal parameter, type cannot be null or '' ");
            return false;
        }
        List<String> typeList = addTypeContent();
        if ( !typeList.contains(type) ) {
            logger.error("the type is not illegal,because it is not under the exception range ");
            return false;
        }
        return true;
    }

    /**
     * 统计需要进行异常监控的模块
     * @return
     */
    private List<String> addModuleContent(){
        List<String> moduleContent = new ArrayList<String>();
        moduleContent.add(ModuleConstant.MODULE_ISMS);
        moduleContent.add(ModuleConstant.MODULE_INTERFACE);
        moduleContent.add(ModuleConstant.MODULE_JOB_EXEC);
        moduleContent.add(ModuleConstant.MODULE_SMMSAPI_TASK_ACK);
        moduleContent.add(ModuleConstant.MODULE_SMMSAPI_TASK_QUARTZ);
        moduleContent.add(ModuleConstant.MODULE_SMMSAPI_TASK_MESSAGE_STAT);
        moduleContent.add(ModuleConstant.MODULE_TASK_MONITOR);
        moduleContent.add(ModuleConstant.MODULE_UD1_EXEC_DATA);
        moduleContent.add(ModuleConstant.MODULE_UD1_EXEC_SNAPSHOT);
        moduleContent.add(ModuleConstant.MODULE_MESSAGE_EXEC);
        moduleContent.add(ModuleConstant.MODULE_MESSAGE_COMMON);
        moduleContent.add(ModuleConstant.MODULE_3RD_INTERFACE);
        moduleContent.add(ModuleConstant.MODULE_OTHERACK_EXEC);

        return moduleContent;
    }

    /**
     * 统计需要进行异常监控的内容
     * @return
     */
    private List<String> addTypeContent(){
        List<String> typeContent = new ArrayList<String>();
        typeContent.add(TypeConstant.EXCEPTION_TYPE_DB);
        typeContent.add(TypeConstant.EXCEPTION_TYPE_REDIS);
        typeContent.add(TypeConstant.EXCEPTION_TYPE_KAFKA);
        typeContent.add(TypeConstant.EXCEPTION_TYPE_APPLICATION);
        typeContent.add(TypeConstant.EXCEPTION_TYPE_OTHER);
        typeContent.add(TypeConstant.EXCEPTION_TYPE_THREAD);
        typeContent.add(TypeConstant.EXCEPTION_TYPE_HIVE);
        return typeContent;
    }

    /**
     * 初始化模块监控项内容
     * @param moduleMonitorMap
     */
    public void initModuleMap(Map<String,String> moduleMonitorMap){

        for(Map.Entry<String,String> entry : moduleMonitorMap.entrySet()){
            String key = entry.getKey();
            module = key.split("_")[0];
            break;
        }

        if ( module==null ){
            logger.error("init module map failed..."+ JSON.toJSONString(moduleMonitorMap));
            module = "unknown";
        }

        monitorMap.putAll(moduleMonitorMap);

    }

    public static Map<String,String> monitorMap(){
        Map<String,String> moduleMap = Maps.newHashMap();
        moduleMap.put("isms_db_exception","0");
        moduleMap.put("isms_redis_exception","0");
        moduleMap.put("isms_kafka_exception","0");
        moduleMap.put("isms_thread_exception","0");
        moduleMap.put("isms_application_exception","0");
        moduleMap.put("isms_hive_exception","0");
        moduleMap.put("isms_other_exception","0");

        moduleMap.put("interface_db_exception","0");
        moduleMap.put("interface_redis_exception","0");
        moduleMap.put("interface_kafka_exception","0");
        moduleMap.put("interface_thread_exception","0");
        moduleMap.put("interface_application_exception","0");
        moduleMap.put("interface_hive_exception","0");
        moduleMap.put("interface_other_exception","0");

        moduleMap.put("smmsapitask_db_exception","0");
        moduleMap.put("smmsapitask_redis_exception","0");
        moduleMap.put("smmsapitask_kafka_exception","0");
        moduleMap.put("smmsapitask_thread_exception","0");
        moduleMap.put("smmsapitask_application_exception","0");
        moduleMap.put("smmsapitask_hive_exception","0");
        moduleMap.put("smmsapitask_other_exception","0");

        moduleMap.put("jobexec_db_exception","0");
        moduleMap.put("jobexec_redis_exception","0");
        moduleMap.put("jobexec_kafka_exception","0");
        moduleMap.put("jobexec_thread_exception","0");
        moduleMap.put("jobexec_application_exception","0");
        moduleMap.put("jobexec_hive_exception","0");
        moduleMap.put("jobexec_other_exception","0");

        moduleMap.put("taskmonitor_db_exception","0");
        moduleMap.put("taskmonitor_redis_exception","0");
        moduleMap.put("taskmonitor_kafka_exception","0");
        moduleMap.put("taskmonitor_thread_exception","0");
        moduleMap.put("taskmonitor_application_exception","0");
        moduleMap.put("taskmonitor_hive_exception","0");
        moduleMap.put("taskmonitor_other_exception","0");

        moduleMap.put("ud1exec_db_exception","0");
        moduleMap.put("ud1exec_redis_exception","0");
        moduleMap.put("ud1exec_kafka_exception","0");
        moduleMap.put("ud1exec_thread_exception","0");
        moduleMap.put("ud1exec_application_exception","0");
        moduleMap.put("ud1exec_hive_exception","0");
        moduleMap.put("ud1exec_other_exception","0");

        moduleMap.put("messageexec_db_exception","0");
        moduleMap.put("messageexec_redis_exception","0");
        moduleMap.put("messageexec_kafka_exception","0");
        moduleMap.put("messageexec_thread_exception","0");
        moduleMap.put("messageexec_application_exception","0");
        moduleMap.put("messageexec_hive_exception","0");
        moduleMap.put("messageexec_other_exception","0");

        moduleMap.put("common_db_exception","0");
        moduleMap.put("common_redis_exception","0");
        moduleMap.put("common_kafka_exception","0");
        moduleMap.put("common_thread_exception","0");
        moduleMap.put("common_application_exception","0");
        moduleMap.put("common_hive_exception","0");
        moduleMap.put("common_other_exception","0");
        return moduleMap;
    }

    /**
     * 获取当前系统的主机名
     * @return
     * @throws UnknownHostException
     */
    public static String getLocalHost() {
        try {
            InetAddress address = InetAddress.getLocalHost();
            return address.getHostAddress();
        }catch (UnknownHostException e) {
            logger.error("获取当前主机host失败",e);
            return "";
        }
    }

    /**
     * 根据当前主机确定保存异常信息的key
     * @return
     */
    public static String getExceptionKeyByLocalHost(){
        return EXCEPTION_REDIS_KEY+"_"+getLocalHost();
    }

    public static String getThreadMonitorKeyByField(String field){
        return field + "_" +getLocalHost();
    }

    public static void main(String[] args) {
        try {
            System.out.println(getLocalHost());
        }catch (Exception e) {

        }
    }

    public Map<String, String> getMonitorMap() {
        return monitorMap;
    }

    public void setMonitorMap(Map<String, String> monitorMap) {
        this.monitorMap = monitorMap;
    }
}

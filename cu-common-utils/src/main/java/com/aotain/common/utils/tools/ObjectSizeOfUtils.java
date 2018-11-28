package com.aotain.common.utils.tools;

import com.aotain.common.utils.model.smmscmd.IdcInfoManage;
import com.carrotsearch.sizeof.RamUsageEstimator;

public class ObjectSizeOfUtils {
	
	public static long sizeof(Object obj) {
		return RamUsageEstimator.sizeOf(obj);
	}
	
	public static void main(String[] args) {
		int a = 100;
		long b = 100L;
		Long c = 100000000000000000L;
		double d = 10000000000.00;
		float f = 1000.00f;
		String str = "x";
		IdcInfoManage idc = new IdcInfoManage();
		System.out.println(sizeof(a));
		System.out.println(sizeof(b));
		System.out.println(sizeof(c));
		System.out.println(sizeof(d));
		byte t = 1;
		System.out.println(sizeof(t));
		System.out.println(sizeof(str));
		System.out.println(sizeof(idc));
	}
}

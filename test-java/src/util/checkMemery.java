package util;

public class checkMemery {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**************************调用垃圾回收，查询内存***********************/
		Runtime   rt = Runtime.getRuntime();
		//查看空余内存
		long  mem = rt.freeMemory();
		System.out.println("Free Memory is : " + mem);

		//调用垃圾回收
		System.gc();
		//…

		mem = rt.freeMemory();
		System.out.println("Free Memory is : " + mem);
		/*******************************************************************/



		/************************查看当前时间，执行方法花费多少时间***************/
    	long s0 = System.currentTimeMillis();
    	
    	//do some thing 
    	
    	long s1 = System.currentTimeMillis();
    	System.out.println("do some thing cost time:"+(s1-s0));
    	/******************************************************************/

	}

	
	
}

public class SccTool {

	public static void main(String[] args) {
		/************************** 调用垃圾回收，查询内存 ***********************/
		Runtime rt = Runtime.getRuntime();
		// 查看空余内存
		long mem = rt.freeMemory();
		System.out.println("Free Memory is : " + mem);

		Runtime runtime = Runtime.getRuntime();
		System.out.printf("maxMemory : %.2fM\n", runtime.maxMemory() * 1.0 / 1024 / 1024);
		System.out.printf("totalMemory : %.2fM\n", runtime.totalMemory() * 1.0 / 1024 / 1024);
		System.out.printf("freeMemory : %.2fM\n", runtime.freeMemory() * 1.0 / 1024 / 1024);

		// 调用垃圾回收
		System.gc();
		// …

		mem = rt.freeMemory();
		System.out.println("Free Memory is : " + mem);
		/*******************************************************************/

		/************************ 查看当前时间，执行方法花费多少时间 ***************/
		long s0 = System.currentTimeMillis();
		// PlanData planData = getBasePlanData(paramObj);
		long s1 = System.currentTimeMillis();
		System.out.println("getBasePlanData() cost time:" + (s1 - s0));
		/******************************************************************/
	}
}

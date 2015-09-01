package xtlm;

import System.SystemInitor;
import mou.mongodb.MongoClientManager;
import mou.mongodb.MongoCollectionUtil;

public class XtlmManger {

	private static final String COLLECTION_NAME_LLGL = "xtlm";// 系统栏目Collection

	/****
	 * 删除所有系统栏目
	 */
	private static void clearAllLm() {
		System.out.println("删除前-------------------");
		System.out.println(MongoCollectionUtil.findBatchDBObject(
				COLLECTION_NAME_LLGL, null, null));

		MongoCollectionUtil.clearCollection(COLLECTION_NAME_LLGL);

		System.out.println("删除后-------------------");
		System.out.println(MongoCollectionUtil.findBatchDBObject(
				COLLECTION_NAME_LLGL, null, null));

		System.out.println("------------------------");
	}

	/****
	 * 创建一个根栏目
	 */
	private static void createRootLm() {

		Xtlm xtlm = new Xtlm();

		xtlm.setLevel(0);
		xtlm.setName("系统栏目");
		xtlm.setParent_id("000");

		MongoCollectionUtil.insertObj(COLLECTION_NAME_LLGL, xtlm);

		System.out.println(MongoCollectionUtil.findBatchDBObject(
				COLLECTION_NAME_LLGL, null, null));

		System.out.println("------------------------");

	}

	private static void printAllLm() {

		System.out.println(MongoCollectionUtil.findBatchDBObject(
				COLLECTION_NAME_LLGL, null, null));

	}

	public static void main(String[] args) {

		SystemInitor.init(true, true);

		clearAllLm();
		//
		createRootLm();

		printAllLm();

	}
}

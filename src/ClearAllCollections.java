import java.util.HashSet;
import java.util.Set;

import mou.mongodb.MongoCollectionUtil;
import mou.mongodb.MongoDbUtil;
import System.SystemInitor;

public class ClearAllCollections {

	public static Set<String> noClear = new HashSet<String>();

	static {
		noClear.add("unit");
		noClear.add("user");
		noClear.add("userregister");
	}

	public static void ClearAllCollections() {
		// 本地、测试库
		SystemInitor.init(false, true);

		Set<String> collectionNames = MongoDbUtil
				.getAllCollectionNames(SystemInitor.getDbName());

		System.out.println(MongoDbUtil.getDbInfoWithCollSize(SystemInitor
				.getDbName()));

		for (String collName : collectionNames) {

			if (!collName.equals("system.indexes")) {
				MongoCollectionUtil.clearCollection(collName);
				System.out.println(collName + "---cleared");
			} else {
				System.out.println(collName + "---no clear");
			}
		}

		System.out.println("清理完毕后---------------------------------------");
		System.out.println(MongoDbUtil.getDbInfoWithCollSize(SystemInitor
				.getDbName()));
	}

	public static void ClearAllCollectionsNoBase() {

		// 本地、测试库
		SystemInitor.init(false, true);

		Set<String> collectionNames = MongoDbUtil
				.getAllCollectionNames(SystemInitor.getDbName());

		System.out.println(MongoDbUtil.getDbInfoWithCollSize(SystemInitor
				.getDbName()));

		for (String collName : collectionNames) {
			if (!collName.equals("system.indexes")) {

				if (canBeClear(collName)) {
					MongoCollectionUtil.clearCollection(collName);
					System.out.println(collName + "---cleared");
				} else {
					System.out.println(collName + "---no clear");
				}
			}
		}

		System.out.println("清理完毕后---------------------------------------");
		System.out.println(MongoDbUtil.getDbInfoWithCollSize(SystemInitor
				.getDbName()));
	}

	public static boolean canBeClear(String collectionName) {
		if (noClear.toString().indexOf(collectionName) >= 0) {
			return false;
		}

		return true;
	}

	public static void main(String[] args) {

		// ClearAllCollections();
		SystemInitor.init(true, true);
		ClearAllCollectionsNoBase();
		// getDbInfo();
	}

	private static void getDbInfo() {
		SystemInitor.init(true, true);

		System.out.println(MongoDbUtil.getDbInfoWithCollSize(SystemInitor
				.getDbName()));
	}
}

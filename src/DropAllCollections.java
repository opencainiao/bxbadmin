import java.util.Set;

import mou.mongodb.MongoClientManager;
import mou.mongodb.MongoDbUtil;
import System.SystemInitor;

import com.mongodb.DB;

public class DropAllCollections {

	public static void dropAllCollections() {
		// 本地、测试库
		SystemInitor.init(false, true);

		Set<String> collectionNames = MongoDbUtil
				.getAllCollectionNames(SystemInitor.getDbName());

		System.out.println(MongoDbUtil.getDbInfoWithCollSize(SystemInitor
				.getDbName()));
		
		DB  db = MongoClientManager.getDb();

		for (String collName : collectionNames) {
			
			db.getCollection(collName).drop();
			
			System.out.println(collName + "---droped");
		}

		System.out.println("清理完毕后---------------------------------------");
		System.out.println(MongoDbUtil.getDbInfoWithCollSize(SystemInitor
				.getDbName()));
	}

	public static void main(String[] args) {

		dropAllCollections();
		// getDbInfo();
		
	}

	private static void getDbInfo() {
		SystemInitor.init(true, true);

		System.out.println(MongoDbUtil.getDbInfoWithCollSize(SystemInitor
				.getDbName()));
	}
}

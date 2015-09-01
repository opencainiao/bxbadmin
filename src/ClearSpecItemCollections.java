import mou.mongodb.MongoCollectionUtil;
import System.SystemInitor;

public class ClearSpecItemCollections {

	public static void ClearAllCollections() {
		// 本地、测试库
		SystemInitor.init(false, true);

		String collName = "spec_item";
		MongoCollectionUtil.clearCollection(collName);
		
		System.out.println("清理规格项表完毕！");
	}

	public static void main(String[] args) {

		ClearAllCollections();
	}
}

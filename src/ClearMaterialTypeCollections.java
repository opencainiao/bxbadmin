import mou.mongodb.MongoCollectionUtil;
import System.SystemInitor;

public class ClearMaterialTypeCollections {

	public static void ClearAllCollections() {
		// 本地、测试库
		SystemInitor.init(false, true);

		String collName = "materialtype";
		MongoCollectionUtil.clearCollection(collName);
		
		// String collNameSPECINMATERAIL = "specinmaterail";
		// MongoCollectionUtil.clearCollection(collNameSPECINMATERAIL);
		
		System.out.println("清理 材料 表完毕！");
	}

	public static void main(String[] args) {

		ClearAllCollections();
	}
}

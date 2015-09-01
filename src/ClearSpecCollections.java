import mou.mongodb.MongoCollectionUtil;
import System.SystemInitor;

public class ClearSpecCollections {

	public static void ClearAllCollections() {
		// 本地、测试库
		SystemInitor.init(false, true);

		
		String collNameSPECIFICATION = "specification";
		MongoCollectionUtil.clearCollection(collNameSPECIFICATION);
		
		
		String collNameMATTYPE_SPEC_RLA = "mattype_spec_rla";
		MongoCollectionUtil.clearCollection(collNameMATTYPE_SPEC_RLA);
		
		
		System.out.println("清理 材料 表完毕！");
	}

	public static void main(String[] args) {

		ClearAllCollections();
	}
}

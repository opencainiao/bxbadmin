import mou.mongodb.MongoCollectionUtil;
import System.SystemInitor;

public class ClearMattypSpecRlaCollections {

	public static void ClearAllCollections() {
		// 本地、测试库
		SystemInitor.init(false, true);

		
		String collNameMATTYPE_SPEC_RLA = "mattype_spec_rla";
		MongoCollectionUtil.clearCollection(collNameMATTYPE_SPEC_RLA);
		
		System.out.println("清理 mattype_spec_rla 表完毕！");
	}

	public static void main(String[] args) {

		ClearAllCollections();
	}
}

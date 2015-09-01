package System;

import mou.mongodb.MongoClientManager;

public class SystemInitor {

	private static final String dbTest = "bxb_test";
	private static final String dbRun = "bxb";

	private static final String remote = "182.92.114.61";
	private static final String local = "localhost";
	
	public static String getDbName(){
		return MongoClientManager.getDB_NAME();
	}

	public static void init(boolean isRemote, boolean isTest) {

		String server = null;

		String db = null;

		if (isRemote) {
			server = remote;
		} else {
			server = local;
		}

		if (isTest) {
			db = dbTest;
		} else {
			db = dbRun;
		}

		MongoClientManager.init(server, db);

	}
}

package xtlm;

import mou.mongodb.MongoObjectId;

/****
 * 系统栏目
 * 
 * @author sks
 *
 */
public class Xtlm {

	private MongoObjectId _id;
	private int level; // 栏目级别(从1开始)
	private String name; // 栏目名称
	private int ordernum; // 栏目排序序号
	private String parent_id; // 父栏目id
	private String parent_name; // 父栏目名称
	private String remark; // 栏目简介
	private String _id_m;
	private UploadedFile lmimg; // 栏目图片

	public UploadedFile getLmimg() {
		return lmimg;
	}

	public void setLmimg(UploadedFile lmimg) {
		this.lmimg = lmimg;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(int ordernum) {
		this.ordernum = ordernum;
	}

	public String getParent_id() {
		return parent_id;
	}

	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getParent_name() {
		return parent_name;
	}

	public void setParent_name(String parent_name) {
		this.parent_name = parent_name;
	}

	public String get_id_m() {
		return _id_m;
	}

	public void set_id_m(String _id_m) {
		this._id_m = _id_m;
	}

	public MongoObjectId get_id() {
		return _id;
	}

	public void set_id(MongoObjectId _id) {
		this._id = _id;
	}

	public void set_id(String _id) {
		MongoObjectId _idNew = new MongoObjectId();
		_idNew.set$oid(_id);
		this._id = _idNew;
	}
}

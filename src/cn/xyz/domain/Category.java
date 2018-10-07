package cn.xyz.domain;

public class Category {
   private String id;
   private String name;
public Category() {
	super();
}
public Category(String cid, String name) {
	super();
	this.id = id;
	this.name = name;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Override
public String toString() {
	return "Category [id=" + id + ", name=" + name + "]";
}
// 添加了新方法
public void newway() {
	System.out.println("这是一个新方法");
}
}

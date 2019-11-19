import java.io.*;
public class allUser {

	private String pass,name,email,age,addr,fname,mname,gender,pcount="0",pecount="0",rcount="0",recount="0";
	private int nid;
	static int totalUser=0;
	private boolean isAdmin;
	protected allUser() {

	}
	public String getPcount() {
		return pcount;
	}
	public void setPcount(String pcount) {
		this.pcount = pcount;
	}
	public String getPecount() {
		return pecount;
	}
	public void setPecount(String pecount) {
		this.pecount = pecount;
	}
	public String getRcount() {
		return rcount;
	}
	public void setRcount(String rcount) {
		this.rcount = rcount;
	}
	public String getRecount() {
		return recount;
	}
	public void setRecount(String recount) {
		this.recount = recount;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public boolean creatNewId(File f) throws IOException {
		File f2= new File("Users//"+Integer.toString(getNid()));
		File f3= new File("Users//"+nid+"//"+nid+"post.txt");
		if(!f2.exists())f2.mkdir();
		if(f2.exists()){
			if(!f.exists()) f.createNewFile();
			if(!f3.exists())f3.createNewFile();
			PrintWriter p= new PrintWriter(f);
			p.println(getPass());
			p.println(isAdmin());
			p.println(getName());
			p.println(getEmail());
			p.println(getNid());
			p.println(getGender());
			p.println(getAge());
			p.println(getFname());
			p.println(getMname());
			p.println(getAddr());
			p.println(getPcount());
			p.println(getRcount());
			p.println(getRecount());
			p.println(getPecount());
			p.close();
		}
		if(f.exists()&&f3.exists())return true;
		else return false;
	}

}

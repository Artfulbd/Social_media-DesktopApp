
public class user {
	private String postTime, post, reviewCount;
	cmntUser []us= new cmntUser[50];
	public user(){
		creat();

	}
	public String getPostTime() {
		return postTime;
	}
	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getReviewCount() {
		return reviewCount;
	}
	public void setReviewCount(String reviewCount) {
		this.reviewCount = reviewCount;
	}
	public void creat() {
		for(int i=0;i<50;i++) {
			this.us[i]= new cmntUser();
		}
	}

}

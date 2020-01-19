package aprsrch;

public class Article {
	String[] text;
	double negative;
	double positive;
	int length;
	boolean con;
	
	public Article(String[] t, double n, double p, int l, boolean x) {
		text = t;
		negative = n;
		positive = p;
		length = l;
		con = x;
	}
	
	public Article() {
		String[] x = {" "};
		text = x;
		negative = 0;
		positive = 0;
		length = 0;
		con = false;
	}
	
	public void setCon(boolean x){
		con = x;
	}
	
	public void setTxt(String[] t) {
		text = t;
	}
	
	public void setNeg(double n) {
		negative = n;
	}
	
	public void setPos(double p) {
		positive = p;
	}
	
	public double getNeg() {
		return negative;
	}
	
	public double getPos() {
		return positive;
	}
	
	public String[] getTxt() {
		return text;
	}
	
	public int getLength() {
		return length;
	}
	
	public boolean getCon() {
		return con;
	}
	
	public String toString() {
		return ("Negative: " + negative + "% | Positive: " + positive + "%");
	}
}

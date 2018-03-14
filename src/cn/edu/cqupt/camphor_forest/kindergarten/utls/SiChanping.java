package cn.edu.cqupt.camphor_forest.kindergarten.utls;

import java.util.List;

public class SiChanping<T>{
      @Override
	public String toString() {
		return "SiChanping [time=" + time + ", T=" + T + "]";
	}
	public SiChanping(String time, List<T> t) {
		super();
		this.time = time;
		T = t;
	}
	public SiChanping() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public List<T> getT() {
		return T;
	}
	public void setT(List<T> t) {
		T = t;
	}
	private String time;
      private List<T> T;
}

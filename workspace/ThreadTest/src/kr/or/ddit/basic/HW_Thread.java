package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HW_Thread {
static int strrank=1;
	public static void main(String[] args) {
		String hnames[] = new String[10];
		List<Horse1> harr = new ArrayList<>();
		
//		Horse[] harr = new Horse[11];
		for(int i=0; i<10; i++) {
				hnames[i] = i+"번말";
				Ho ho = new Ho(hnames[i]);
				harr.add(new Horse1(ho));
			}
		
			// 이게 맞는건지..
		harr.get(0).start();
		harr.get(1).start();
		harr.get(2).start();
		harr.get(3).start();
		harr.get(4).start();
		harr.get(5).start();
		harr.get(6).start();
		harr.get(7).start();
		harr.get(8).start();
		harr.get(9).start();
		
		for(Horse1 har : harr) {
			try {
				har.join();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		System.out.println("경기 끝...");
		
		Collections.sort(harr);
		for(Horse1 horse : harr) {
			System.out.println(horse);
		}
	}
}


class Ho {
	private String name;
	private int rank;

	@Override
	public String toString() {
		return " [name=" + name + ", rank=" + rank + "]";
	}

	public Ho(String name) {
		this.name = name;
		rank = 0;
	}
	
	public String getName() {
		return name;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public void setrank() {
		
		int sum = 0;
		int count = 0;
		String str;
		String[] arr = new String[51];

		arr[0] = ">";
		for (int i = 1; i < 50; i++) {
			arr[i] = "-";
		}
		
		str = getName();
		for (int j = 0; j < 50; j++) {
			str += arr[j];
		}
		System.out.println(str);
		
		for (long i = 1; i <= 1000000000; i++) { // 시간텀
			sum += i;				
			
			if (i % 20000000 == 0) {
				try {
					Thread.sleep((int)(Math.random()*1001+1));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				count++;
				arr[count - 1] = "-";
				arr[count] = ">";
				str = getName();
				
			
			for (int j = 0; j < 50; j++) {
				str+=arr[j];
			}
			System.out.println(str);	
			}
			
			synchronized (this) {
				if(count==49) {
					this.rank = HW_Thread.strrank;
					HW_Thread.strrank++;
					System.out.println(this.getName() +"도착");
					break;
				}
			}
		}
	}
}

class Horse1 extends Thread implements Comparable<Horse1> {
private Ho ho;
public Horse1(Ho ho) {
	this.ho = ho;
}
	public void run() {
	ho.setrank();
	}
	
	public Ho getHo() {
		return ho;
	}
	public void setHo(Ho ho) {
		this.ho = ho;
	}
	int a;
	
	@Override
	public String toString() {
		return  ho + "";
	}

	@Override
	public int compareTo(Horse1 o) {
		Integer b = (Integer)o.getHo().getRank();
		return Integer.compare(ho.getRank(),b);
	}
}	


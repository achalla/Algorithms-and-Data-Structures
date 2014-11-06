package Quartile;

import java.util.Scanner;

public class Quartile {
	
	public static void report(){
		System.out.println("hi");
	}	
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String cmd;
		
		while(true){
			cmd = sc.next();
			if(cmd.equals("i")) {
				MinHeap.insert(sc.nextInt());
				System.out.println("------------------");
				MinHeap.printTree();
			}
			if(cmd.equals("r")) report();
			if(cmd.equals("remove")) MinHeap.remove();
			if(cmd.equals("end")) break;
		}
		sc.close();

	}

}

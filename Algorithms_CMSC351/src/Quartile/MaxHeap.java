package Quartile;

import java.util.Scanner;

public class MaxHeap {
	
	final static int MAX_ELEMENTS = 500000;
	
	//static ArrayList<Integer> maxHeap; /*max*/
	static int[] maxHeap = new int[MAX_ELEMENTS];
	static int totElem = 0;
	
	public static int parentInd(int index){
		if(index == 0) return 0;
		if(index % 2 == 1) return (index/2);
		else return ((index/2) - 1);
	}
	
	public static int parentVal(int index){
		return maxHeap[parentInd(index)];
	}
	
	public static int leftI(int index){
		return 2*index + 1;
	}
	
	public static int leftVal(int index){
		return maxHeap[leftI(index)];
	}
	
	public static int rightI(int index){
		return 2*index + 2;
	}
	
	public static int rightVal(int index){
		return maxHeap[rightI(index)];
	}
	
	public static void insert(int val){
		int tempPV,index = totElem++,currVal;
		currVal = val;
		
		maxHeap[index] = val;
		printTree();
		System.out.println("parent val of "+val+" is: "+parentVal(index)+" (index "+index+")");
		
		while(currVal > parentVal(index)){/*swap*/
			System.out.println("in while");
			tempPV = parentVal(index);
			maxHeap[parentInd(index)] = currVal;
			maxHeap[index] = tempPV;
			index = parentInd(index);
			currVal = maxHeap[index];
			printTree();
		}
	}
	
	public static void remove(){
		int swapIndex = 0, tempI, tempVal;
		
		printTree();
		
		if(totElem > 0) maxHeap[0] = maxHeap[--totElem];
		else System.out.println("MIN HEAP EMPTY!");
		
		while(true){
			if(leftI(swapIndex) < totElem){
				System.out.println("a");
				System.out.println("swapIndex: "+swapIndex+" val: "+maxHeap[swapIndex]+" left: "+leftVal(swapIndex)+" right: "+rightVal(swapIndex));
				if(rightI(swapIndex) < totElem){//both
					System.out.println("b");
					if(rightVal(swapIndex) > leftVal(swapIndex) && rightVal(swapIndex) > maxHeap[swapIndex]){
						System.out.println("c");
						tempI = rightI(swapIndex);
						tempVal = maxHeap[swapIndex];
						maxHeap[swapIndex] = rightVal(swapIndex);
						maxHeap[tempI] = tempVal;
						swapIndex = tempI;
					}else if(leftVal(swapIndex) > rightVal(swapIndex) && leftVal(swapIndex) > maxHeap[swapIndex]){
						System.out.println("d");
						tempI = leftI(swapIndex);
						tempVal = maxHeap[swapIndex];
						maxHeap[swapIndex] = leftVal(swapIndex);
						maxHeap[tempI] = tempVal;
						swapIndex = tempI;
					}else{
						System.out.println("e");
						break;
					}
				}else{//left only
					System.out.println("f");
					if(leftVal(swapIndex) > maxHeap[swapIndex]){
						System.out.println("g");
						tempI = leftI(swapIndex);
						tempVal = maxHeap[swapIndex];
						maxHeap[swapIndex] = leftVal(swapIndex);
						maxHeap[tempI] = tempVal;
						swapIndex = tempI;
					}else{
						System.out.println("h");
						break;
					}
				}
			}else if(rightI(swapIndex) < totElem){ //right only
				System.out.println("i");
				if(rightVal(swapIndex) > maxHeap[swapIndex]){
					System.out.println("j");
					tempI = rightI(swapIndex);
					tempVal = maxHeap[swapIndex];
					maxHeap[swapIndex] = rightVal(swapIndex);
					maxHeap[tempI] = tempVal;
					swapIndex = tempI;
				}else{
					System.out.println("k");
					break;
				}
			}else{//neither
				System.out.println("m");
				break;
			}
		}
		
	printTree();
	}
	
	public static void printTree(){
		for(int i = 0; i < totElem; i++){
			System.out.print(maxHeap[i]+" ");
		}
		System.out.println("");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				Scanner sc = new Scanner(System.in);
				String cmd;
				
				while(true){
					cmd = sc.next();
					if(cmd.equals("i")) {
						MaxHeap.insert(sc.nextInt());
						System.out.println("------------------");
						MaxHeap.printTree();
					}
					if(cmd.equals("remove")) remove();
					if(cmd.equals("end")) break;
				}
				sc.close();
	}
	
}

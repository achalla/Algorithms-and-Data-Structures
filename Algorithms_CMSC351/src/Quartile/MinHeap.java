package Quartile;

public class MinHeap {
	
	final static int MAX_ELEMENTS = 500000;
	
	//static ArrayList<Integer> minHeap; /*min*/
	static int[] minHeap = new int[MAX_ELEMENTS];
	static int totElem = 0;
	
	public static int parentInd(int index){
		if(index == 0) return 0;
		if(index % 2 == 1) return (index/2);
		else return ((index/2) - 1);
	}
	
	public static int parentVal(int index){
		return minHeap[parentInd(index)];
	}
	
	public static int leftI(int index){
		return 2*index + 1;
	}
	
	public static int leftVal(int index){
		return minHeap[leftI(index)];
	}
	
	public static int rightI(int index){
		return 2*index + 2;
	}
	
	public static int rightVal(int index){
		return minHeap[rightI(index)];
	}
	
	public static void insert(int val){
		int tempPV,index = totElem++,currVal;
		currVal = val;
		
		minHeap[index] = val;
		printTree();
		System.out.println("parent val of "+val+" is: "+parentVal(index)+" (index "+index+")");
		
		while(currVal < parentVal(index)){/*swap*/
			System.out.println("in while");
			tempPV = parentVal(index);
			minHeap[parentInd(index)] = currVal;
			minHeap[index] = tempPV;
			index = parentInd(index);
			currVal = minHeap[index];
			printTree();
		}
	}
	
	public static void remove(){
		int swapIndex = 0, tempI, tempVal;
		
		printTree();
		
		if(totElem > 0) minHeap[0] = minHeap[--totElem];
		else System.out.println("MIN HEAP EMPTY!");
		
		while(true){
			if(leftI(swapIndex) < totElem){
				System.out.println("a");
				System.out.println("swapIndex: "+swapIndex+" val: "+minHeap[swapIndex]+" left: "+leftVal(swapIndex)+" right: "+rightVal(swapIndex));
				if(rightI(swapIndex) < totElem){//both
					System.out.println("b");
					if(rightVal(swapIndex) < leftVal(swapIndex) && rightVal(swapIndex) < minHeap[swapIndex]){
						System.out.println("c");
						tempI = rightI(swapIndex);
						tempVal = minHeap[swapIndex];
						minHeap[swapIndex] = rightVal(swapIndex);
						minHeap[tempI] = tempVal;
						swapIndex = tempI;
					}else if(leftVal(swapIndex) < rightVal(swapIndex) && leftVal(swapIndex) < minHeap[swapIndex]){
						System.out.println("d");
						tempI = leftI(swapIndex);
						tempVal = minHeap[swapIndex];
						minHeap[swapIndex] = leftVal(swapIndex);
						minHeap[tempI] = tempVal;
						swapIndex = tempI;
					}else{
						System.out.println("e");
						break;
					}
				}else{//left only
					System.out.println("f");
					if(leftVal(swapIndex) < minHeap[swapIndex]){
						System.out.println("g");
						tempI = leftI(swapIndex);
						tempVal = minHeap[swapIndex];
						minHeap[swapIndex] = leftVal(swapIndex);
						minHeap[tempI] = tempVal;
						swapIndex = tempI;
					}else{
						System.out.println("h");
						break;
					}
				}
			}else if(rightI(swapIndex) < totElem){ //right only
				System.out.println("i");
				if(rightVal(swapIndex) < minHeap[swapIndex]){
					System.out.println("j");
					tempI = rightI(swapIndex);
					tempVal = minHeap[swapIndex];
					minHeap[swapIndex] = rightVal(swapIndex);
					minHeap[tempI] = tempVal;
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
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*while(swapIndex < totElem){
			if(leftI(swapIndex) >= totElem && rightI(swapIndex) >= totElem) break; //no children
			if(leftI(swapIndex) < totElem && rightI(swapIndex) < totElem){ //both children
				System.out.println("1");
				if(leftVal(swapIndex) < rightVal(swapIndex)){
					System.out.println("A");
					tempI = leftI(swapIndex);
					minHeap[swapIndex] = leftVal(swapIndex);
					minHeap[tempI] = Integer.MAX_VALUE;
					swapIndex = tempI;
					totElem--;
				}else if(leftVal(swapIndex) > rightVal(swapIndex)){
					System.out.println("B");
					tempI = rightI(swapIndex);
					minHeap[swapIndex] = rightVal(swapIndex);
					minHeap[tempI] = Integer.MAX_VALUE;
					swapIndex = tempI;
					totElem--;
				}
			}else if(leftI(swapIndex) < totElem){ //left child
				System.out.println("2");
				if(leftVal(swapIndex) < minHeap[swapIndex]){
					System.out.println("C");
					tempI = leftI(swapIndex);
					minHeap[swapIndex] = leftVal(swapIndex);
					minHeap[tempI] = Integer.MAX_VALUE;
					swapIndex = tempI;
					totElem--;
				}
			}else{ //right child
				System.out.println("3");
				if(rightVal(swapIndex) < minHeap[swapIndex]){
					System.out.println("D");
					tempI = rightI(swapIndex);
					minHeap[swapIndex] = rightVal(swapIndex);
					minHeap[tempI] = Integer.MAX_VALUE;
					swapIndex = tempI;
					totElem--;
				}
			}
			printTree();
		}*/
		
		
		
		
		/*
		while(swapIndex < totElem){
			if(leftI(swapIndex) < totElem && leftVal(swapIndex) < rightVal(swapIndex)){
				tempI = leftI(swapIndex);
				minHeap[swapIndex] = leftVal(swapIndex);
				minHeap[tempI] = Integer.MAX_VALUE;
				swapIndex = tempI;
				totElem--;
			}else if(rightI(swapIndex) < totElem && leftVal(swapIndex) > rightVal(swapIndex)){
				tempI = rightI(swapIndex);
				minHeap[swapIndex] = rightVal(swapIndex);
				minHeap[tempI] = Integer.MAX_VALUE;
				swapIndex = tempI;
				totElem--;
			}else{//out of nodes
				break;
			}
			printTree();
		}*/
	}
	
	public static void printTree(){
		for(int i = 0; i < totElem; i++){
			System.out.print(minHeap[i]+" ");
		}
		System.out.println("");
	}
	
}

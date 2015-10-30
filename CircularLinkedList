package amcat;

public class CircularLinkedList {
	CNode first = null;
	CNode last = null;

	public void insertIntoList(CNode newNode){
		if(first == null && last == null){
			first = newNode;
			last = newNode;
			last.next = first;
		}else{
			if(first == last){
				if(newNode.value >= first.value){
					first.next = newNode;
					last = newNode;
					last.next = first;
				}else{
					first = newNode;
					first.next = last;
					last.next = first;
				}				
			}else{
				if(newNode.value <= first.value){
					newNode.next = first;
					first = newNode;
				}else if(newNode.value >= last.value){
					last.next = newNode;
					last = newNode;
					last.next = first;
				}else{
					CNode temp = first;
					CNode tempNext = first.next;
					while(tempNext != null){
						if(temp.value <= newNode.value && newNode.value <= tempNext.value){
							temp.next = newNode;
							newNode.next = tempNext;
							break;
						}
						temp = tempNext;
						tempNext = tempNext.next;
					}
				}
			}
		}
	}
	
	public void printList(){
		if(this.first == null && this.last == null){
			System.out.println("List is empty");
		}else{
			CNode curr = this.first;
			while(curr != last){
				System.out.print(curr.value+" ");
				curr = curr.next;
			}
			System.out.print(curr.value);
			System.out.println();
		}
	}
	
	public static void main(String[] args){
		CircularLinkedList list = new CircularLinkedList();
		CNode t1 = new CNode(0);
		list.insertIntoList(t1);
		list.printList();
		
		CNode t2 = new CNode(-9);
		list.insertIntoList(t2);
		list.printList();
		
		CNode t3 = new CNode(0);
		list.insertIntoList(t3);
		list.printList();
		
		CNode t4 = new CNode(0);
		list.insertIntoList(t4);
		list.printList();
		
		CNode t5 = new CNode(-8);
		list.insertIntoList(t5);
		list.printList();
		
	}
}

package assignment2;

public class SortedList<E extends List> implements SortedListInterface {
	
	private List sortedList;

	@Override
	public List insert(Data d) {
		
		if(sortedList.isEmpty() == true) {
			sortedList.insert(d);
		} else {
			sortedList.setFirst();
			
			while(d.compareTo(sortedList.list.data) < 0) {
				sortedList.list = sortedList.list.next;
			}
			
			if (sortedList.list.prior == null) {
				insertFirst(d);
			} else if (sortedList.list.next == null) {		
				insertLast(d);
			} else {
				insertInOrder(d);
			}
		}	
	return sortedList;
	}
	
	public void insertFirst(Data d) {
		sortedList.list = new Node(d, null, sortedList.list);
		sortedList.list.next.prior = sortedList.list;
	}
	
	public void insertLast(Data d) {
		sortedList.list = new Node(d, sortedList.list.prior, null);
		sortedList.list.prior.next = sortedList.list;
	}
	
	public void insertInOrder(Data d) {
		sortedList.list = new Node(d, sortedList.list.prior, sortedList.list.next);
		sortedList.list.prior.next = sortedList.list;
		sortedList.list.next.prior = sortedList.list;
	}
}

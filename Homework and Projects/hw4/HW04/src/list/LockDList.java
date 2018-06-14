package list;

public class LockDList extends DList{
	

	protected LockDListNode newNode(Object item, DListNode prev, DListNode next) {
//		super.newNode(item, prev, next);
        return new LockDListNode(item, prev, next);
}
	public void lockNode(DListNode node) {
		((LockDListNode)node).setter();
	}	
	
	public void remove(DListNode node) {
//		super.remove(node);
		if(((LockDListNode)node).getter()) {
			return;
		}
		
		}	
	}


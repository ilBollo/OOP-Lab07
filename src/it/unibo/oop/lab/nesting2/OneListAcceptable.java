package it.unibo.oop.lab.nesting2;

import java.util.Iterator;
import java.util.List;

public class OneListAcceptable<T> implements Acceptable<T> {

	private final List<T> list;
	
	public OneListAcceptable(List<T> list) {
		this.list = list;
	}
	
	
	public Acceptor<T> acceptor() {
		return new OneListAcceptor<>(this.list.iterator());
	}
	
	private static class OneListAcceptor<T> implements Acceptor<T> {
		
		private final Iterator<T> iterator;
		
		public OneListAcceptor(Iterator<T> iterator) {
			this.iterator = iterator;
		}

		
		public void accept(T newElement) throws ElementNotAcceptedException {
			if(!this.iterator.hasNext()|| !newElement.equals(this.iterator.next())) {
				throw new ElementNotAcceptedException(newElement);
			}
		}

		public void end() throws EndNotAcceptedException {
			if(this.iterator.hasNext()) {
				throw new EndNotAcceptedException();
			}
			
		}
	}

}

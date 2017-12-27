package com.falcon.io;

import java.util.PriorityQueue;

public class cc {
	public static void main(String[] args) {

		Librarian librarian = new Librarian();
		LibraryBook libraryBook1 = new LibraryBook("War and Peace", 12.99);
		LibraryBook libraryBook2 = new LibraryBook("Gravity's Rainbow", 7.99);
		LibraryBook libraryBook3 = new LibraryBook("Gravity's Rainbow", 9.99);
		LibraryBook libraryBook4 = new LibraryBook("No One Writes to the Colonel", 11.99);

		librarian.addBook(libraryBook1);
		librarian.addBook(libraryBook2);
		librarian.addBook(libraryBook3);
		librarian.addBook(libraryBook4);

		LibraryBook topBook = librarian.removeBook();
		System.out.println(topBook.toString());
	}

}

class Librarian {
	PriorityQueue<LibraryBook> pq = new PriorityQueue<LibraryBook>();

	public void addBook(LibraryBook book) {
		pq.add(book);
	}

	public LibraryBook removeBook() {
		LibraryBook book = pq.remove();

		return book;
	}
}

class LibraryBook implements Comparable<LibraryBook> {
	private String name;
	private boolean permanent;
	private double cost;

	public LibraryBook(String name, double d) {
		super();
		this.name = name;
		this.cost = d;
	}

	@Override
	public int compareTo(LibraryBook o) {
		int val = 0;

		val = name.compareTo(o.name);

		if (val == 0) {
			val = (cost > o.cost) ? 1 : -1;
		}
		return val;
	}
}
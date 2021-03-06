package com.grandcircus.library.gui;

import java.awt.GridLayout;
import javax.swing.*;

import com.grandcircus.library.service.LibraryService;

/**
 * Displays menu GUI
 */
public class MenuGUI extends JFrame {

	static {
		// Allows the GUI to display with a reasonably large font on high DPI displays.
		// This property must be set before any Swing components are initialized.

		System.setProperty("sun.java2d.uiScale", "2.5");
	}

	private static final long serialVersionUID = 1L;

	/**
	 * Displays the MenuGUI.
	 */
	public MenuGUI() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// Don't care if the theme can't be changed
		}

		LibraryService libraryApp = new LibraryService();

		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		JButton display = new JButton(String.valueOf("Display Media"));
		JButton searchByAuthor = new JButton("Search by Author/Director");
		JButton searchByTitle = new JButton("Search by Title");
		JButton checkoutBook = new JButton("Checkout an Item");
		JButton returnBook = new JButton("Return an Item");
		JButton donateBook = new JButton("Donate a Book");
		JButton donateMovie = new JButton("Donate a Movie");
		JButton exit = new JButton("Exit");

		this.setLayout(new GridLayout(8, 1));

		this.add(display);
		this.add(searchByAuthor);
		this.add(searchByTitle);
		this.add(checkoutBook);
		this.add(returnBook);
		this.add(donateBook);
		this.add(donateMovie);
		this.add(exit);

		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		// Used lambdas because the ActionListener interface only has one method in it.
		// Otherwise we could not use lambda.
		display.addActionListener(event -> {
			new DisplayGUI(libraryApp);
		});

		searchByAuthor.addActionListener(event -> {
			new SearchByAuthorGUI(libraryApp);
		});

		searchByTitle.addActionListener(event -> {
			new SearchByTitleGUI(libraryApp);
		});

		checkoutBook.addActionListener(event -> {
			new CheckoutBookGUI(libraryApp);
		});

		returnBook.addActionListener(event -> {
			new ReturnBookGUI(libraryApp);
		});

		donateBook.addActionListener(event -> {
			new DonateBookGUI(libraryApp);
		});

		donateMovie.addActionListener(event -> {
			new DonateMovieGUI(libraryApp);
		});

		exit.addActionListener(event -> {
			this.setVisible(false);
			this.dispose();
		});
	}
}

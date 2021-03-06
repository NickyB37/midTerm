package com.grandcircus.library.gui;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import com.grandcircus.library.model.Media;
import com.grandcircus.library.service.LibraryService;

/**
 * Provides a GUI for the user to return a book to the library.
 */
public class ReturnBookGUI extends JDialog {

	private static final long serialVersionUID = 1L;

	/**
	 * Displays the ReturnBookGUI.
	 * @param libraryApp An instance of 
	 * the library.
	 */
	public ReturnBookGUI(LibraryService libraryApp) {
		JComboBox bookList = new JComboBox(libraryApp.getAllBooks().toArray());
		JButton returnBookButton = new JButton("Return");

		this.setSize(800, 100);
		this.setModal(true);
		this.setTitle("Return Media");

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		this.add(bookList);
		this.add(returnBookButton);
		this.setLocationRelativeTo(null);

		returnBookButton.addActionListener(event -> {
			Media selectedBook = (Media) bookList.getSelectedItem();
			if (libraryApp.bookReturn(selectedBook)) {
				JOptionPane.showMessageDialog(this, selectedBook + " Has been successfully returned!");
			} else {
				JOptionPane.showMessageDialog(this, selectedBook + " Was never checked out");
			}
		});

		this.setVisible(true);
	}
}

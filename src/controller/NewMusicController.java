package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JOptionPane;

import View.NewMusicView;
import model.Music;
import model.Queries;

/**
 * 
 * @author Daniel Lopes
 * 
 *         Controller created to gather the information from New Music View
 *         class and Queries, so that I new Music object is created and insert
 *         into the database
 *
 */
public class NewMusicController implements ActionListener {

	NewMusicView NewMusicView;

	public NewMusicController() throws ParseException {

		this.NewMusicView = new NewMusicView(this);

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		/*
		 * The information that the user types in the screen text field is retrieved and
		 * saved within those variables. After storing them in the variable I can use
		 * each variable to create my music object *
		 */

		String title = this.NewMusicView.getTitle();
		String singer = this.NewMusicView.getSinger();
		String genre = this.NewMusicView.getGenre();
		int yearOfRelease = this.NewMusicView.getYearOfRelease();
		String format = this.NewMusicView.getFormat();
		double price = this.NewMusicView.getPrice();

		Music music = new Music(yearOfRelease, title, genre, price, singer, format);

		String action = ae.getActionCommand();

		if (action.equals("create")) {

			Queries musicQuery = new Queries(); // instance of Query in order to access its methods and inner classes

			Queries.musicClass innerMusic = musicQuery.new musicClass(); // accessing Music inner class

			boolean newMusic = innerMusic.insertNewMusic(music); /*
																	 * within music Inner class accessing the method to
																	 * insert new music that receives a music object
																	 */

			if (newMusic) {
				this.NewMusicView.dispose();
				JOptionPane.showMessageDialog(null, "New Music " + music.getTitle() + " Successfully Created!");
			}

		}
	}
}

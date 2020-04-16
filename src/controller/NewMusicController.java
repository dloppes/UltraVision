package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import View.NewMusicView;
import model.Music;
import model.Queries;

public class NewMusicController implements ActionListener{

	NewMusicView NewMusicView;
	
	public NewMusicController() {
		
		this.NewMusicView = new NewMusicView(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		
		
		String title = this.NewMusicView.getTitle();
		String singer = this.NewMusicView.getSinger();
		String genre = this.NewMusicView.getGenre();
		int yearOfRelease = this.NewMusicView.getYearOfRelease();
		String format = this.NewMusicView.getFormat();
		double price = this.NewMusicView.getPrice();
		
		
		Music music = new Music(yearOfRelease, title, genre, price, singer, format);
		
		String action = ae.getActionCommand();
		
		if(action.equals("create")){
			
			Queries musicQuery = new Queries();
			
			Queries.musicClass innerMusic = musicQuery.new musicClass();
			
			boolean newMusic = innerMusic.insertNewMusic(music);
			
			if(newMusic) {
				this.NewMusicView.dispose();
				JOptionPane.showMessageDialog(null,"New Music " +  music.getTitle() +  " Successfully Created!");
			}
			
			
		}
	}
}

package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import View.menuView;

import View.loginView;



public class menuController implements ActionListener{
	
	menuView menuView;
	
	public menuController() {
		
		menuView = new menuView(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		  String ac = e.getActionCommand();
		  
//		  if (ac.equals("newArtist")) {
//	            new newArtistController();
//	        }
//
//	        if (ac.equals("newAdmin")) {
//	            new newAdminController();
//	        }
//
//	        if (ac.equals("deleteArtist")) {
//	            new deleteArtistListView();
//	        }
//
//	        if (ac.equals("deleteAdmin")) {
//	            new deleteAdminListView();
//	        }
//
//	        
//	        if (ac.equals("updateArtist")){
//	            new updateArtistListView();
//	        }
//	        
//	        if (ac.equals("newArt")){
//	            new newArtController();
//	        }
//	        
//	        if (ac.equals("updateArt")){
//	            new updateArtListView();
//	        }
//	        
//	        if(ac.equals("deleteArt")){
//	            new deleteArtListView();
//	        }
//	        
//	        if(ac.equals("updateAdmin")){
//	            new updateAdminListView();
//	        }
//	        
//	        if(ac.equals("logout")){
//	            this.adminMenuView.dispose();
//	            new welcomeView();
	        }

	    }
	
	



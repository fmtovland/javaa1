//the graphical user interface for the application

package com.assignment1.search;

//gui elemnets
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JFrame;
//event handlers
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//other methods
import java.util.Arrays;

class Frontend extends JFrame implements ActionListener
{
	private final int NUMNO=4;	//number of search results to display on screen

	//tmp variables
	private int i;

	//attributes
	private String searchterm;		//the string the user is looking for
	private FileString[] potentials;	//possible files that might contain the filestring

	//buttons and such
	private JTextField searchbox;
	private JButton searchbutton;		//press to start looking for results
	private JLabel[] resultsbox= new JLabel[NUMNO];

	//constructor
	Frontend()
	{
		super("Searcher");	//label the window as searcher
		setSize(640,480);
		setLayout(new FlowLayout());
		setVisible(true);

		//setup the searchbox
		searchbox=new JTextField(30);
		searchbox.addActionListener(this);
		add(searchbox);

		//setup the search button
		searchbutton=new JButton("search");
		searchbutton.addActionListener(this);
		add(searchbutton);

		for(i=0; i<NUMNO; i++)
		{
			resultsbox[i]=new JLabel("");	//create 4 (or however many) empty results boxes
			add(resultsbox[i]);
		}

	}

	public void actionPerformed(ActionEvent event1)
	{
		if(event1.getSource()==searchbutton)
		{
			searchterm=searchbox.getText();
			potentials=Spiderbot.getFiles(searchterm.split("\\s+"));

			for(i=0; i<potentials.length; i++)
				SearchScore.getSearchScore(potentials[i],searchterm);

			Arrays.sort(potentials);

			for(i=0; i<NUMNO; i++)
				resultsbox[i].setText(potentials[i].getFilename()+": "+potentials[i].getBestLine());
		}
	}
}

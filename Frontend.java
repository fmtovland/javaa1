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
	private final int NUMNO=5;	//number of search results to display on screen

	//tmp variables
	private int i;

	//attributes
	private String searchterm;		//the string the user is looking for
	private FileString[] potentials;	//possible files that might contain the filestring
	private int page=-1;			//how many pages of results have been scrolled through
	private int lastpage;			//the index of the last page

	//buttons and such
	private JTextField searchbox;
	private JButton searchbutton;		//press to start looking for results
	private JButton leftButton,rightButton;	//next or previous page
	private JLabel[] resultsbox= new JLabel[NUMNO];
	private JLabel pagenum;			//a textbox to show the page of results

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

		//next and last page buttons with indicator
		leftButton=new JButton("<");
		pagenum=new JLabel("0/0");
		rightButton=new JButton(">");
		leftButton.addActionListener(this);
		rightButton.addActionListener(this);
		add(leftButton);
		add(pagenum);
		add(rightButton);

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
				if(i<potentials.length)
					resultsbox[i].setText("<html>"+potentials[i].getFilename()+": "+potentials[i].getBestLine()+"</html>");
				else
						resultsbox[i].setText("");

			page=0;
			lastpage=potentials.length/NUMNO;
			pagenum.setText((page+1)+"/"+(lastpage+1));
		}

		if(event1.getSource()==leftButton)
		{
			if(page==-1)
				return;

			if(page>0)
			{
				page--;
				pagenum.setText((page+1)+"/"+(lastpage+1));

				for(i=0; i<NUMNO; i++)
					if(i+(page*NUMNO)<potentials.length)
						resultsbox[i].setText(potentials[i+(page*NUMNO)].getFilename()+": "+potentials[i+(page*NUMNO)].getBestLine());
					else
						resultsbox[i].setText("");
			}
		}

		if(event1.getSource()==rightButton)
		{
			if(page==-1)
				return;

			if(page<lastpage)
			{
				page++;
				pagenum.setText((page+1)+"/"+(lastpage+1));

				for(i=0; i<NUMNO; i++)
					if(i+(page*NUMNO)<potentials.length)
						resultsbox[i].setText("<html>"+potentials[i+(page*NUMNO)].getFilename()+": "+potentials[i+(page*NUMNO)].getBestLine()+"</html>");
					else
						resultsbox[i].setText("");
			}
		}
	}
}

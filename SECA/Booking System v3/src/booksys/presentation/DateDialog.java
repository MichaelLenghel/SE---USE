/*
 * Restaurant Booking System: example code to accompany
 *
 * "Practical Object-oriented Design with UML"
 * Mark Priestley
 * McGraw-Hill (2004)
 */

package booksys.presentation ;

import java.awt.* ;
import javax.swing.*;
import java.awt.event.* ;
import java.sql.Date ;

class DateDialog extends JDialog
{
  JTextField tf ;
  boolean confirmed ;
  
  DateDialog(Frame owner, String title)
  {
    super(owner, title, true) ;

    addWindowListener(new WindowAdapter() {
	public void windowClosing(WindowEvent e) {
	  DateDialog.this.setVisible(false) ;
	}
      }) ;

    Label promptLabel = new Label("Enter date:", Label.RIGHT) ;
    
    tf = new JTextField("YYYY-MM-DD", 10) ;

    JButton confirm = new JButton("Ok") ;
    confirm.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	  confirmed = true ;
	  DateDialog.this.setVisible(false) ;
	}
      }) ;

    JButton cancel = new JButton("Cancel") ;
    cancel.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	  confirmed = false ;
	  DateDialog.this.setVisible(false) ;
	}
      }) ;

    setLayout( new GridLayout(0, 2) ) ;

    add(promptLabel) ;
    add(tf) ;

    add(confirm) ;
    add(cancel) ;
    
    pack() ;
  }

  boolean isConfirmed()
  {
    return confirmed ;
  }

  Date getDate()
  {
    return Date.valueOf(tf.getText()) ;
  }
}

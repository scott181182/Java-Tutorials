package BFS.diceroller.gui;

import java.awt.event.ActionListener;

public interface IClickable 
{
	public boolean addActionListener(ActionListener al);
	public boolean removeActionListener(ActionListener al);
	public void setActionCommand(String ac);
	public void click();
}

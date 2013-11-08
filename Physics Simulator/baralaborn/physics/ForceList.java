package baralaborn.physics;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

public class ForceList extends JPanel implements ListSelectionListener
{
	private static final long serialVersionUID = 1L;
	private static final String addString = "ADD", removeString = "REMOVE";
	
	public static HashMap<String, Force> forceMap = new HashMap<>();
	public static JList<String> list;
	public static DefaultListModel<String> listModel;
	
	private static JButton removeButton;
	private static JTextField forceField;
	
	public ForceList()
	{
		super(null);
		
		listModel = new DefaultListModel<>();
		listModel.addElement("Free Body");
		list = new JList<>(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setSelectedIndex(0);
		list.addListSelectionListener(this);
		list.setVisibleRowCount(JList.VERTICAL);
		list.setFont(new Font("Arial", Font.BOLD, 24));
		JScrollPane listScrollPane = new JScrollPane(list);
		
		JButton addButton = new JButton(addString);
		AddListener addListener = new AddListener(addButton);
		addButton.setActionCommand(addString);
		addButton.addActionListener(addListener);
		addButton.setEnabled(false);
		removeButton = new JButton(removeString);
		removeButton.setActionCommand(removeString);
		removeButton.addActionListener(new RemoveListener());
		
		forceField = new JTextField();
		forceField.addActionListener(addListener);
		forceField.getDocument().addDocumentListener(addListener);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
		buttonPane.add(removeButton);
		buttonPane.add(Box.createHorizontalStrut(5));
		buttonPane.add(addButton);
		
		JPanel fieldPane = new JPanel();
		fieldPane.setLayout(new BoxLayout(fieldPane, BoxLayout.Y_AXIS));
		fieldPane.add(buttonPane);
		fieldPane.add(Box.createVerticalStrut(5));
		fieldPane.add(forceField);
		fieldPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		listScrollPane.setBounds(0, 0, 200, 500);
		fieldPane.setBounds(0, 500, 200, 80);
		add(listScrollPane);
		add(fieldPane);
	}
	class AddListener implements ActionListener, DocumentListener
	{
		private JButton button;
		private boolean isEnabled = false;
		
		public AddListener(JButton button)
		{
			this.button = button;
		}
		public void insertUpdate(DocumentEvent e) { enableButton(); } 
		public void removeUpdate(DocumentEvent e) { handleEmptyField(e); } 
		public void changedUpdate(DocumentEvent e) { if(!handleEmptyField(e)) { enableButton(); } } 
		public void actionPerformed(ActionEvent e)
		{
			String name = forceField.getText();
			if(name.equals("") || name.startsWith(" ") || alreadyInList(name))
			{
				Toolkit.getDefaultToolkit().beep();
				forceField.requestFocusInWindow();
				forceField.selectAll();
				return;
			}
			int index = list.getSelectedIndex();
			if(index == -1) { index = 0; } else { index++; }
			forceMap.put(name, new Force(name));
			listModel.insertElementAt(name, index);
			forceField.requestFocusInWindow();
			forceField.setText("");
			list.setSelectedIndex(index);
			list.ensureIndexIsVisible(index);
		}
		protected boolean alreadyInList(String name) { return listModel.contains(name); }
		private void enableButton() { if(!isEnabled) { button.setEnabled(true); } }
		private boolean handleEmptyField(DocumentEvent e)
		{
			if(e.getDocument().getLength() <=0)
			{
				button.setEnabled(false);
				isEnabled = false;
				return true;
			}
			return false;
		}
	}
	class RemoveListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			int index = list.getSelectedIndex();
			String name = list.getSelectedValue();
			if(index == 0) { return; }
			if(JOptionPane.showOptionDialog(Main.frame, "Are you sure you want to delete the force '" + name + "'?", "Delete this Force?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null) == JOptionPane.NO_OPTION) { return; }
			forceMap.remove(name);
			listModel.remove(index);
			int size = listModel.getSize();
			if(size == 0) { removeButton.setEnabled(false); }
			else
			{
				if(index == listModel.getSize()) { index--; }
				list.setSelectedIndex(index);
				list.ensureIndexIsVisible(index);
			}
		}
	}
	public void valueChanged(ListSelectionEvent e)
	{
		int index = list.getSelectedIndex();
		
		Main.screenPanel.setVisible(false);
		Main.screenPanel.removeAll();
		ForcePanel forcePanel = null;
		if(index > 0)
		{
			String name = list.getSelectedValue();
			forcePanel = new ForcePanel(forceMap.get(name));
			Main.screenPanel.add(forcePanel);
		} else 
		{ 
			Main.screenPanel.add(Main.bodyPanel); 
			Main.bodyPanel.modify();
		}
		Main.screenPanel.add(new NetPanel());
		Main.screenPanel.revalidate();
		Main.screenPanel.repaint();
		Main.screenPanel.setVisible(true);
	}
}

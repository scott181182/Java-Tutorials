package baralaborn.physics;

import java.awt.event.*;
import javax.swing.*;

public class BodyPanel extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private float mass = 10, acceleration = 0;
	
	public JLabel massLabel, accelLabel;
	
	public BodyPanel()
	{
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.acceleration = (float)(Renderer.netForce / this.mass);
		
		massLabel = new JLabel("Mass = " + this.mass + " kg");
		accelLabel = new JLabel("Acceleration = " + this.acceleration + " m/s/s");
		
		JButton massButton = new JButton("edit");
		massButton.setActionCommand("MASS");
		massButton.addActionListener(this);
		
		JPanel massPanel = new JPanel();
		massPanel.setLayout(new BoxLayout(massPanel, BoxLayout.X_AXIS));
		massPanel.add(massLabel);
		massPanel.add(Box.createHorizontalGlue());
		massPanel.add(massButton);
		massPanel.setBorder(BorderFactory.createRaisedBevelBorder());
		
		JPanel accelPanel = new JPanel();
		accelPanel.setLayout(new BoxLayout(accelPanel, BoxLayout.X_AXIS));
		accelPanel.add(accelLabel);
		accelPanel.add(Box.createHorizontalGlue());
		accelPanel.setBorder(BorderFactory.createRaisedBevelBorder());
		
		add(massPanel);
		add(accelPanel);
		setBorder(BorderFactory.createTitledBorder("FREE BODY"));
		setBounds(5, 0, 300, 100);
	}
	public float getMass() { return this.mass; }
	public float getAcceleration() { return this.acceleration; }
	public void modify()
	{
		this.acceleration = (float)(Renderer.netForce / this.mass);
		massLabel.setText("Mass = " + this.mass + " kg");
		accelLabel.setText("Acceleration = " + this.acceleration + " m/s/s");
	}
	public void actionPerformed(ActionEvent e)
	{
		float oldMass = this.mass;
		float newMass = oldMass;
		try
		{
			newMass = Float.parseFloat(JOptionPane.showInputDialog(Main.frame, "Enter the Body's new Mass", "Edit Body", JOptionPane.QUESTION_MESSAGE, null, null, oldMass).toString());
			if(oldMass == newMass) { return; }
			this.mass = newMass;
			this.acceleration = (float)(Renderer.netForce / this.mass);
			massLabel.setText("Mass = " + this.mass + " kg");
			accelLabel.setText("Acceleration = " + this.acceleration + " m/s/s");
		}
		catch(NumberFormatException nfe) { JOptionPane.showMessageDialog(Main.frame, "Input was an invalid number", "Invalid Input", JOptionPane.WARNING_MESSAGE, null); }
		catch(NullPointerException npe) {  }
		finally
		{
			Main.screenPanel.setVisible(false);
			Main.screenPanel.revalidate();
			Main.screenPanel.repaint();
			Main.screenPanel.setVisible(true);	
		}
	}
}

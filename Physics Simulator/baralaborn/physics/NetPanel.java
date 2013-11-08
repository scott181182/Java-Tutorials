package baralaborn.physics;

import javax.swing.*;

public class NetPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	public static JLabel forceLabel, vectorLabel;
	
	public NetPanel()
	{
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		forceLabel = new JLabel("Net Force = " + (float)Renderer.netForce + " N");
		vectorLabel = new JLabel("Net Vector = " + (float)Renderer.netVector + "¡");
		
		add(forceLabel);
		add(vectorLabel);
		setBorder(BorderFactory.createTitledBorder("NET FORCE"));
		setBounds(300, 500, 250, 60);
	}
}

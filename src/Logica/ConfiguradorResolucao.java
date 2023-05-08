package Logica;

import java.util.Hashtable;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;

public class ConfiguradorResolucao {
	public static String configurador() {
		JFrame parent = new JFrame();
		JOptionPane optionPaneX = new JOptionPane();
		JSlider sliderX = new JSlider(0, 3, 0);

		Hashtable hTable = new Hashtable();
		hTable.put( new Integer( 0 ), new JLabel("600x400") );
		hTable.put( new Integer( 1 ), new JLabel("800x600") );
		hTable.put( new Integer( 2 ), new JLabel("1366x768") );
		hTable.put( new Integer( 3 ), new JLabel("1920x1080") );
		sliderX.setMajorTickSpacing(1);
		sliderX.setPaintTicks(true);
		sliderX.setPaintLabels(true);
		sliderX.setLabelTable(hTable);
		optionPaneX.setMessage(new Object[] { "Resolução da tela: ", sliderX });
		JDialog dialogX = optionPaneX.createDialog(parent, "Configuração da resolução");
		dialogX.setVisible(true);

		if(optionPaneX.getValue()!=null) {
			if(sliderX.getValue()==0)
				return "600x400";
			else if(sliderX.getValue()==1)
				return "800x600";
			else if(sliderX.getValue()==2)
				return "1366x768";
			else
				return "1920x1080";
		}
		else {
			parent.dispose();
			return "600x400";
		}
	}
}
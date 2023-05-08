package Interface;

import java.awt.Font;

import javax.swing.JButton;

public class JButtons extends JButton {
	private static final long serialVersionUID = 1L;

	public JButtons (String nome, int x, int y, int comp, int alt) {
		super(nome);
		setFont(new Font("Tahoma", Font.CENTER_BASELINE, 12));
		setBounds(x, y, comp, alt);
	}
}
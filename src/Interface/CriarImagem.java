package Interface;

import javax.swing.ImageIcon;

public class CriarImagem {
	public ImageIcon getImagens(String name) {
		String caminhoDaImagem = "Imagens/" + name;
		ClassLoader classLoader = this.getClass().getClassLoader();
		ImageIcon icone = new ImageIcon(classLoader.getResource(caminhoDaImagem));
		return icone;
	}
}
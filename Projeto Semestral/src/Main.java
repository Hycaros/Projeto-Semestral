import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Main {
	
	public static void main(String[] args) {
		JFrame janela = new JFrame("Projeto Semestral - João Mosconi - RM83101");
		
		JTabbedPane paineis = new JTabbedPane();
		
		JPanel painelCadastro = new JPanel();
		BorderLayout bd = new BorderLayout();
		bd.setHgap(20);
		painelCadastro.setLayout(bd);
		JLabel imagem = new JLabel(new ImageIcon(new ImageIcon("res/capa.jpg").getImage().getScaledInstance(250, 300, Image.SCALE_DEFAULT)));
		painelCadastro.add(imagem, BorderLayout.WEST);
		
		JPanel cadastro = new JPanel();
		cadastro.setLayout(new GridLayout(6,1));
		
		cadastro.add(new JLabel("Titulo"));
		JTextField textoTitulo = new JTextField();
		cadastro.add(textoTitulo);
		
		cadastro.add(new JLabel("Sinopse"));
		JTextField textoSinopse = new JTextField();
		cadastro.add(textoSinopse);
		
		cadastro.add(new JLabel("Gênero"));
		JComboBox<String> genero = new JComboBox<>();
		genero.addItem("Ação");
		genero.addItem("Drama");
		genero.addItem("Terror");
		genero.addItem("Suspense");
		genero.addItem("Romance");
		genero.addItem("Ficção");
		cadastro.add(genero);
		
		JPanel ondeAssistir = new JPanel();
		
		ondeAssistir.setLayout(new GridLayout(7,1));
		
		ondeAssistir.add(new JLabel("Onde Assistir"));
		
		ButtonGroup botaoAssistir = new ButtonGroup();
		
		JRadioButton netflix = new JRadioButton("Netflix");
		netflix.setActionCommand("Netflix");
		botaoAssistir.add(netflix);
		ondeAssistir.add(netflix);
		
		JRadioButton amazon = new JRadioButton("Prime Video");
		amazon.setActionCommand("Prime Video");
		botaoAssistir.add(amazon);
		ondeAssistir.add(amazon);
	
		
		JRadioButton pirateBay = new JRadioButton("Pirate Bay");
		pirateBay.setActionCommand("Pirate Bay");
		botaoAssistir.add(pirateBay);
		ondeAssistir.add(pirateBay);
		
		JCheckBox assistido = new JCheckBox("Assistido");
		ondeAssistir.add(assistido);
		
		ondeAssistir.add(new JLabel("Avaliação"));
		StarRater avaliacao = new StarRater(5);
		ondeAssistir.add(avaliacao);
		
		JPanel botoes = new JPanel();
		JButton salvar = new JButton("Salvar");
		salvar.addActionListener(action -> {
			Filme filme = new Filme();
			filme.setAvaliacao(avaliacao.getSelection());
			filme.setGenero((String)genero.getSelectedItem());
			filme.setAssistido(assistido.isSelected());
			filme.setOndeAssistir(botaoAssistir.getSelection().getActionCommand());
			filme.setSinopse(textoSinopse.getText());
			filme.setTitulo(textoTitulo.getText());
			System.out.println(filme);
		});
		botoes.add(salvar);
		JButton cancelar = new JButton("Cancelar");
		botoes.add(cancelar);
		
		painelCadastro.add(botoes, BorderLayout.SOUTH);
		
		painelCadastro.add(ondeAssistir, BorderLayout.EAST);
		
		
		painelCadastro.add(cadastro, BorderLayout.CENTER);
		
		paineis.add("Cadastro", painelCadastro);
		
		JPanel painelLista = new JPanel();
		paineis.add("Lista", painelLista);
		
		janela.add(paineis);
		
		janela.setSize(900,500);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

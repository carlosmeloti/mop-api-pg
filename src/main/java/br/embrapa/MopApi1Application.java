package br.embrapa;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import br.embrapa.config.property.MopApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(MopApiProperty.class)
public class MopApi1Application{

	
		
public static void main(String[] args) {
		
		MopApi1Application m = new MopApi1Application();
		
		//m.inicio();
		
		SpringApplication.run(MopApi1Application.class, args);
		
		//m.iniciada();
	}
	
	public void inicio() {
		
		JOptionPane.showMessageDialog(null, "Iniciando API.");
		
	}
	public void iniciada() {
		
		JOptionPane.showMessageDialog(null, "API do MOP iniciada. Aplicação web pode ser executada.");
	}
	
	
}

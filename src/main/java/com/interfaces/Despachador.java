package com.interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Despachador extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	public Despachador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(e -> {
			VentanaPersonas ventanaPersonas = new VentanaPersonas ();
			ventanaPersonas.setVisible(true);
		});
		btnNewButton.setBounds(174, 111, 89, 23);
		contentPane.add(btnNewButton);
	}
}

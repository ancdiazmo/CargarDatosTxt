package com.interfaces;

import java.awt.EventQueue;

public class Main {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
				try {
					Despachador frame = new Despachador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
	}
}

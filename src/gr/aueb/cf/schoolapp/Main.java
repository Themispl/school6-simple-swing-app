package gr.aueb.cf.schoolapp;

import java.awt.EventQueue;

public class Main {
	private static final MainMenuFrame mainMenuFrame = new MainMenuFrame();
	private static final TeachersMenuFrame teachersMenuFrame = new TeachersMenuFrame();
	private static final TeachersInsertFrame teachersInsertFrame = new TeachersInsertFrame();
	private static final TeachersUpdateDeleteFrame teachersUpdateDeleteFrame = new TeachersUpdateDeleteFrame();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					mainMenuFrame.setLocationRelativeTo(null);
					mainMenuFrame.setVisible(true);
					
					teachersMenuFrame.setLocationRelativeTo(null);
					teachersMenuFrame.setVisible(false);
					
					teachersInsertFrame.setLocationRelativeTo(null);
					teachersInsertFrame.setVisible(false);
					
					teachersUpdateDeleteFrame.setLocationRelativeTo(null);
					teachersUpdateDeleteFrame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static TeachersUpdateDeleteFrame getTeachersupdatedeleteframe() {
		return teachersUpdateDeleteFrame;
	}
	public static MainMenuFrame getMainmenuFrame() {
		return mainMenuFrame;
	}
	public static TeachersMenuFrame getTeachersMenuFrame() {
		return teachersMenuFrame;
	}
	public static TeachersInsertFrame getTeachersinsertframe() {
		return teachersInsertFrame;
	}
}

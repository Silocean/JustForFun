package com.hblg;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * 
 * @author Silocean
 *
 */
public class NotePad extends JFrame implements ActionListener, ItemListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static JTextArea ta;
	JMenuBar mb;
	FileDialog dialog_load, dialog_save;
	JMenu mFile, mEdit, mForm, mCheck, mHelp;
	JMenuItem open, save, exit, copy, cut, paste, search, about;
	JCheckBoxMenuItem lineWrap, state;
	FileReader fr;
	BufferedReader br;
	FileWriter fw;
	BufferedWriter bw;
	JLabel label = new JLabel("", JLabel.RIGHT);

	String copyString;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ���ý�����
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			// SwingUtilities.updateComponentTreeUI(this);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new NotePad();
	}

	public NotePad() {
		dialog_load = new FileDialog(this, "���ļ��Ի���", FileDialog.LOAD);
		dialog_save = new FileDialog(this, "�����ļ��Ի���", FileDialog.SAVE);
		open = new JMenuItem("��");
		save = new JMenuItem("����");
		exit = new JMenuItem("�˳�");
		copy = new JMenuItem("����");
		cut = new JMenuItem("����");
		paste = new JMenuItem("ճ��");
		search = new JMenuItem("����");
		about = new JMenuItem("����");
		lineWrap = new JCheckBoxMenuItem("�Զ�����");
		state = new JCheckBoxMenuItem("״̬��");
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				ActionEvent.CTRL_MASK));
		copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
				ActionEvent.CTRL_MASK));
		cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
				ActionEvent.CTRL_MASK));
		paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
				ActionEvent.CTRL_MASK));
		mFile = new JMenu("�ļ�(F)");
		mFile.setMnemonic(KeyEvent.VK_F);
		mEdit = new JMenu("�༭(E)");
		mForm = new JMenu("��ʽ(O)");
		mCheck = new JMenu("�鿴(V)", true);
		mHelp = new JMenu("����(H)");
		mb = new JMenuBar();
		ta = new JTextArea();
		ta.setFont(new Font("������Ů����W5(P)", Font.PLAIN, 12));
		label.setFont(new Font("����", Font.PLAIN, 12));
		JScrollPane sp = new JScrollPane(ta,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		mFile.add(open);
		mFile.add(save);
		mFile.add(exit);
		mEdit.add(copy);
		mEdit.add(cut);
		mEdit.add(paste);
		mEdit.add(search);
		mCheck.add(state);
		mForm.add(lineWrap);
		mHelp.add(about);
		about.addActionListener(this);
		open.addActionListener(this);
		save.addActionListener(this);
		exit.addActionListener(this);
		copy.addActionListener(this);
		cut.addActionListener(this);
		paste.addActionListener(this);
		search.addActionListener(this);
		lineWrap.addItemListener(this);
		state.addItemListener(this);
		mb.add(mFile);
		mb.add(mEdit);
		mb.add(mForm);
		mb.add(mCheck);
		mb.add(mHelp);
		this.setJMenuBar(mb);
		this.add(sp);
		// int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		// int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setTitle("���±�");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(
				NotePad.class.getClassLoader().getResource("images/Word.png")));
		this.setSize(700, 600);
		// this.setLocation((w - 600) / 2, (h - 400) / 2);
		dialog_load.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dialog_load.setVisible(false);
			}

		});
		dialog_save.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dialog_save.setVisible(false);
			}

		});
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// System.out.println(System.getProperty("line.separator"));
		new Thread(new Check()).start();
	}

	public void showState() {
		this.add(label, BorderLayout.SOUTH);
		this.setVisible(true);
		new Thread(new Show()).start();
	}

	public void checkEditable() {
		if (lineWrap.isSelected()) {
			state.setSelected(false);
			state.setEnabled(false);
		} else {
			state.setEnabled(true);
		}
	}

	// ���ڼ��״̬���Ƿ���õ��߳�
	class Check implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				checkEditable();
			}
		}

	}

	// ������ʾ״̬�����߳�
	class Show implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				int rowCount = 0;
				String str = ta.getText().substring(0, ta.getCaretPosition());
				for (int i = 0; i < str.length(); i++) {
					if (str.charAt(i) == '\n') {
						rowCount++;
					}
				}
				int columnCount = 0;
				int temp = 0;
				String strs[] = ta.getText()
						.substring(0, ta.getCaretPosition()).split("\n");
				if (strs.length > 1) {
					for (int i = 0; i < strs.length - 1; i++) {
						temp += strs[i].length();
					}
					if (ta.getCaretPosition() == temp + rowCount) {
						columnCount = 0;
					}
					columnCount = ta.getCaretPosition() - temp - rowCount;
				} else {
					columnCount = ta.getCaretPosition() + 1;
				}
				// label.setText(""+ta.getText().length());
				label.setText("����:" + ta.getText().length() + "          "
						+ "��" + (rowCount + 1) + "�У�" + "��" + (columnCount)
						+ "��" + "      ");
				// System.out.println(ta.getCaretPosition());
			}
		}

	}

	/**
	 * �������滻
	 */
	public void searchAndReplace() {
		final JDialog findDialog = new JDialog(this, "�������滻", true);
		Container con = findDialog.getContentPane();
		con.setLayout(new FlowLayout(FlowLayout.LEFT));
		// �������Һ��滻�Ի���Ĳ������
		JLabel searchContentLabel = new JLabel("��������(N) :");
		JLabel replaceContentLabel = new JLabel("�滻Ϊ(P)�� :");
		final JTextField findText = new JTextField(30);
		final JTextField replaceText = new JTextField(30);
		final JCheckBox matchcase = new JCheckBox("���ִ�Сд(C)");

		ButtonGroup bGroup = new ButtonGroup();
		final JRadioButton up = new JRadioButton("����(U)");
		final JRadioButton down = new JRadioButton("����(D)");
		down.setSelected(true); // Ĭ��Ϊ���²���
		bGroup.add(up);
		bGroup.add(down);
		JButton searchNext = new JButton("������һ��(F)");
		JButton replace = new JButton("�滻(R)");
		final JButton replaceAll = new JButton("ȫ���滻(A)");

		// "�滻"��ť���¼�����,������
		replace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (replaceText.getText().length() == 0
						&& ta.getSelectedText() != null)
					ta.replaceSelection("");
				if (replaceText.getText().length() > 0
						&& ta.getSelectedText() != null)
					ta.replaceSelection(replaceText.getText());
			}
		});

		// "�滻ȫ��"�˵�����¼�����
		replaceAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ta.setCaretPosition(0);
				int a = 0, b = 0, replaceCount = 0;

				if (findText.getText().length() == 0) {
					JOptionPane.showMessageDialog(findDialog, "����д��������!", "��ʾ",
							JOptionPane.WARNING_MESSAGE);
					findText.requestFocus(true);
					return;
				}
				while (a > -1) {

					int FindStartPos = ta.getCaretPosition();
					String str1, str2, str3, str4, strA, strB;
					str1 = ta.getText();
					str2 = str1.toLowerCase();
					str3 = findText.getText();
					str4 = str3.toLowerCase();

					if (matchcase.isSelected()) {
						strA = str1;
						strB = str3;
					} else {
						strA = str2;
						strB = str4;
					}

					// �����ϲ��Ұ�ť��ѡ��ʱ
					if (up.isSelected()) {
						if (ta.getSelectedText() == null) {
							a = strA.lastIndexOf(strB, FindStartPos - 1);
						} else {
							a = strA.lastIndexOf(strB, FindStartPos
									- findText.getText().length() - 1);
						}
					} else if (down.isSelected()) {
						if (ta.getSelectedText() == null) {
							a = strA.indexOf(strB, FindStartPos);
						} else {
							a = strA.indexOf(strB, FindStartPos
									- findText.getText().length() + 1);
						}

					}

					if (a > -1) {
						if (up.isSelected()) {
							ta.setCaretPosition(a);
							b = findText.getText().length();
							ta.select(a, a + b);
						} else if (down.isSelected()) {
							ta.setCaretPosition(a);
							b = findText.getText().length();
							ta.select(a, a + b);
						}
					} else {
						if (replaceCount == 0) {
							JOptionPane.showMessageDialog(findDialog,
									"�Ҳ�����Ҫ���ҵ�����!", "���±�",
									JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(findDialog, "�ɹ��滻"
									+ replaceCount + "��ƥ������!", "�滻�ɹ�",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}

					if (replaceText.getText().length() == 0
							&& ta.getSelectedText() != null) {
						ta.replaceSelection("");
						replaceCount++;
					}

					if (replaceText.getText().length() > 0
							&& ta.getSelectedText() != null) {
						ta.replaceSelection(replaceText.getText());
						replaceCount++;
					}
				}
			}
		});

		// "������һ��"�˵�����¼�����
		searchNext.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int a = 0, b = 0;
				int FindStartPos = ta.getCaretPosition();
				String str1, str2, str3, str4, strA, strB;
				str1 = ta.getText();
				str2 = str1.toLowerCase(); // ��STR1ת����Сд
				str3 = findText.getText();
				str4 = str3.toLowerCase(); // ��STR1ת����Сд

				// "���ִ�Сд"��CheckBox��ѡ��
				if (matchcase.isSelected()) {
					strA = str1;
					strB = str3;
				} else {
					strA = str2;
					strB = str4;
				}

				if (up.isSelected()) {

					if (ta.getSelectedText() == null) {
						a = strA.lastIndexOf(strB, FindStartPos - 1);
					} else {
						a = strA.lastIndexOf(strB, FindStartPos
								- findText.getText().length() - 1);
					}
				} else if (down.isSelected()) {

					if (ta.getSelectedText() == null) {
						a = strA.indexOf(strB, FindStartPos);
					} else {
						a = strA.indexOf(strB, FindStartPos
								- findText.getText().length() + 1);
					}

				}

				if (a > -1) {
					if (up.isSelected()) {
						ta.setCaretPosition(a);
						b = findText.getText().length();
						ta.select(a, a + b);
					} else if (down.isSelected()) {
						ta.setCaretPosition(a);
						b = findText.getText().length();
						ta.select(a, a + b);
					}
				} else {
					JOptionPane.showMessageDialog(null, "�Ҳ�����Ҫ���ҵ�����!", "���±�",
							JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});

		// "ȡ��"�˵���¼�����
		JButton cancel = new JButton("ȡ��");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findDialog.dispose();
			}
		});

		// ����"�������滻"�Ի���Ľ���
		JPanel bottomPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		JPanel topPanel = new JPanel();

		JPanel direction = new JPanel();
		direction.setBorder(BorderFactory.createTitledBorder("����"));
		direction.add(up);
		direction.add(down);

		JPanel replacePanel = new JPanel();
		replacePanel.setLayout(new GridLayout(2, 1));
		replacePanel.add(replace);
		replacePanel.add(replaceAll);

		topPanel.add(searchContentLabel);
		topPanel.add(findText);
		topPanel.add(searchNext);
		centerPanel.add(replaceContentLabel);
		centerPanel.add(replaceText);
		centerPanel.add(replacePanel);
		bottomPanel.add(matchcase);
		bottomPanel.add(direction);
		bottomPanel.add(cancel);

		con.add(topPanel);
		con.add(centerPanel);
		con.add(bottomPanel);

		// ����"�������滻"�Ի���Ĵ�С���ɸ��Ĵ�С(��)��λ�úͿɼ���
		findDialog.setSize(410, 210);
		findDialog.setResizable(false);
		findDialog.setLocation(230, 280);
		findDialog.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == open) {
			dialog_load.setVisible(true);
			String s;
			if (dialog_load.getFile() != null) {
				try {
					ta.setText(null);
					ta.setFont(new Font("����", Font.PLAIN, 16));
					File f = new File(dialog_load.getDirectory(),
							dialog_load.getFile());
					fr = new FileReader(f);
					br = new BufferedReader(fr);
					while ((s = br.readLine()) != null) {
						ta.append(s + '\n');
					}

					this.setTitle(dialog_load.getFile() + " - ���±�");
					// System.out.println(ta.getLineCount());
					fr.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		} else if (e.getActionCommand() == save.getText()) {
			dialog_save.setVisible(true);
			if (dialog_save.getFile() != null) {
				try {
					File f = new File(dialog_save.getDirectory(),
							dialog_save.getFile());
					fw = new FileWriter(f);
					bw = new BufferedWriter(fw);
					String str = ta.getText();
					String lines[] = str.split("\n");
					for (String line : lines) {
						bw.write(line + "\r\n");
					}

					bw.close();
					fw.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		} else if (e.getActionCommand() == exit.getText()) {
			System.exit(0);
		}

		if (e.getSource() == copy) {
			copyString = ta.getSelectedText();
		}
		if (e.getSource() == cut) {
			copyString = ta.getSelectedText();
			ta.replaceRange("", ta.getSelectionStart(), ta.getSelectionEnd());
		}
		if (e.getSource() == paste) {
			ta.insert(copyString, ta.getCaretPosition());
		}

		if (e.getSource() == search) {
			searchAndReplace();
		}

		if (e.getSource() == about) {
			JOptionPane.showMessageDialog(
					this,
					"һ���򵥵ļ��±�С���򣬾���һЩ�򵥵ı༭�����ҹ���",
					"^(oo)^",
					JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon(Toolkit.getDefaultToolkit().getImage(
							NotePad.class.getClassLoader().getResource(
									"images/0.gif"))));
		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if (lineWrap.isSelected()) {
			ta.setLineWrap(true);
			ta.setWrapStyleWord(true);
		} else {
			ta.setLineWrap(false);
		}
		if (state.isSelected()) {
			showState();
		} else {
			this.remove(label);
			this.setVisible(true);
		}
	}

}

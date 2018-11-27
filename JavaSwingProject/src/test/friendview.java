package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


import test.Friend;

import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Desktop.Action;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;

public class friendview extends JFrame {

	private JPanel contentPane;
	private JSplitPane splitPane;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField tfName;
	private JTextField tfBirth;
	private JTextField tfPhone;
	private JTextField tfAddr;
	private JSplitPane splitPane_1;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JPanel panel_1;
	private JComboBox comSel;
	private JTextField tfSearch;
	private JButton btnSearch;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	FriendDBAImpl dba = new FriendDBAImpl();
	private JButton btnNewButton_2;
	private JTextField tfNum;
	private JButton btnSelect;
	private JButton btnUpdate;
	private JButton btnDelete;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					friendview frame = new friendview();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public friendview() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getSplitPane(), BorderLayout.CENTER);
	}
	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setLeftComponent(getPanel());
			splitPane.setRightComponent(getSplitPane_1());
			splitPane.setDividerLocation(210);
		}
		return splitPane;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setFont(new Font("굴림", Font.BOLD, 12));
			panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "\uCE5C\uAD6C\uB4F1\uB85D", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setLayout(null);
			panel.add(getLblNewLabel_1());
			panel.add(getLblNewLabel_2());
			panel.add(getLblNewLabel_3());
			panel.add(getLblNewLabel_4());
			panel.add(getTfName());
			panel.add(getTfBirth());
			panel.add(getTfPhone());
			panel.add(getTfAddr());
			panel.add(getBtnNewButton_2());
			panel.add(getBtnNewButton_1());
			panel.add(getTfNum());
			panel.add(getBtnSelect());
			panel.add(getBtnUpdate());
			panel.add(getBtnDelete());
		}
		return panel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("이름");
			lblNewLabel_1.setBounds(33, 41, 26, 15);
			lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 12));
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("생일");
			lblNewLabel_2.setBounds(33, 77, 26, 15);
			lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 12));
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("전화번호");
			lblNewLabel_3.setBounds(12, 111, 57, 15);
			lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 12));
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("주소");
			lblNewLabel_4.setBounds(33, 148, 26, 15);
			lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 12));
		}
		return lblNewLabel_4;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setBounds(71, 38, 116, 21);
			tfName.setName("");
			tfName.setColumns(10);
		}
		return tfName;
	}
	private JTextField getTfBirth() {
		if (tfBirth == null) {
			tfBirth = new JTextField();
			tfBirth.setBounds(71, 74, 116, 21);
			tfBirth.setColumns(10);
		}
		return tfBirth;
	}
	private JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setBounds(71, 108, 116, 21);
			tfPhone.setColumns(10);
		}
		return tfPhone;
	}
	private JTextField getTfAddr() {
		if (tfAddr == null) {
			tfAddr = new JTextField();
			tfAddr.setBounds(71, 145, 116, 21);
			tfAddr.setColumns(10);
		}
		return tfAddr;
	}
	private JSplitPane getSplitPane_1() {
		if (splitPane_1 == null) {
			splitPane_1 = new JSplitPane();
			splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPane_1.setLeftComponent(getScrollPane());
			splitPane_1.setRightComponent(getPanel_1());
			splitPane_1.setDividerLocation(180);
		}
		return splitPane_1;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBorder(new TitledBorder(new LineBorder(new Color(255, 102, 0)), "\uC804\uCCB4\uBCF4\uAE30", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.add(getComSel());
			panel_1.add(getTfSearch());
			panel_1.add(getBtnSearch());
		}
		return panel_1;
	}
	private JComboBox getComSel() {
		if (comSel == null) {
			comSel = new JComboBox();
			comSel.setModel(new DefaultComboBoxModel(new String[] {"선택하세요", "이름", "주소", "생일", "전화번호"}));
			comSel.setBounds(12, 21, 54, 21);
		}
		return comSel;
	}
	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.setBounds(70, 21, 61, 21);
			tfSearch.setColumns(10);
		}
		return tfSearch;
	}
	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("검색");
			btnSearch.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					tfSearch.setText("");
					String str="";
					if(comSel.getSelectedIndex()==1) {
						str="name";
					}else if(comSel.getSelectedIndex()==2) {
						str="addr";
					}else {
						tfSearch.setText("선택오류");
						return;
					}
					ArrayList<Friend> arr = dba.friendSearch(str,tfSearch.getText());
					for( Friend f : arr) {
						textArea.append("번호 :"+f.getNum()+"\n");
						textArea.append("이름 :"+f.getName()+"\n");
						textArea.append("생일 :"+f.getBirth()+"\n");
						textArea.append("폰 :"+f.getPhone()+"\n");
						textArea.append("주소 :"+f.getAddr()+"\n");
					
				
						
					}
				}
					});
			btnSearch.setBounds(131, 20, 63, 23);
		}
		
		return btnSearch;
	}

	
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("전체 보기");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				ArrayList<Friend> arr=dba.friendView();
				for( Friend f : arr) {
					textArea.append("이름 :"+f.getName()+"\n");
					textArea.append("생일 :"+f.getBirth()+"\n");
					textArea.append("전화번호 :"+f.getPhone()+"\n");
					textArea.append("주소 :"+f.getAddr()+"\n");
					
				}
				}
			});
			
			btnNewButton_1.setBounds(12, 183, 87, 23);
		}
		
		return btnNewButton_1;
	}

	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("추가");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				if(tfName.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"입력하세요");
					return;
				}
					Friend f = new Friend();
					f.setName(tfName.getText());
					f.setBirth(tfBirth.getText());
					f.setAddr(tfAddr.getText());
					f.setPhone(tfPhone.getText());
					dba.friendInsert(f);
					
					
				}
			});
			btnNewButton_2.setBounds(110, 183, 87, 23);
		}
		return btnNewButton_2;
	}
	private JTextField getTfNum() {
		if (tfNum == null) {
			tfNum = new JTextField();
			tfNum.setBounds(12, 216, 87, 21);
			tfNum.setColumns(10);
		}
		return tfNum;
	}
	
	
	
	private JButton getBtnSelect() {
		if (btnSelect == null) {
			btnSelect = new JButton("상세보기");
			btnSelect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
					int num = Integer.parseInt(tfNum.getText());
					Friend f = dba.friendSelect(num);
					tfName.setText(f.getName());
					tfBirth.setText(f.getBirth());
					tfAddr.setText(f.getAddr());
					tfPhone.setText(f.getPhone());
					btnUpdate.setEnabled(true);
					btnDelete.setEnabled(true);
				}catch(NumberFormatException n) {
					JOptionPane.showMessageDialog(null,"숫자를 입력하세요.");
				}catch(NullPointerException e2) {
					JOptionPane.showMessageDialog(null,"찾는 친구 없습니다.");
				}
				}	
			});
			
			btnSelect.setBounds(110, 216, 87, 23);
		}
		return btnSelect;
	}
	private JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton("수정");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Friend f = new Friend();
					f.setNum(Integer.parseInt(tfNum.getText()));
					f.setName(tfName.getText());
					f.setBirth(tfBirth.getText());
					f.setAddr(tfAddr.getText());
					f.setPhone(tfPhone.getText());
					dba.friendUpdate(f);
				}
			});
			
		
			btnUpdate.setBounds(22, 249, 71, 23);
			btnUpdate.setEnabled(false);
		}
	return 	btnUpdate;
	}
	
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("삭제");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(null, "삭제할까요", "Confirm", JOptionPane.YES_NO_OPTION);
					if(result==JOptionPane.YES_OPTION) {	
					int num = Integer.parseInt(tfNum.getText());
						dba.friendDelete(num);
					}
				}			
			});
			btnDelete.setEnabled(false);
			btnDelete.setBounds(120, 249, 71, 23);
		}
		return btnDelete;	
	}
}

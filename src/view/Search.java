package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.StudentDaoImp;
import domain.Student;

public class Search extends JDialog {
	StudentDaoImp studentDaoImp = new StudentDaoImp();
	JLabel lbl_id = new JLabel("ѧ��",JLabel.CENTER);
	JLabel lbl_name = new JLabel("����",JLabel.CENTER);
	JLabel lbl_score = new JLabel("�ɼ�",JLabel.CENTER);
	JTextField jtf_id = new JTextField();
	JTextField jtf_name = new JTextField();
	JTextField jtf_score = new JTextField();
	JButton jb = new JButton("����");
	public Search(DefaultTableModel tm){
		super();
		setLocationRelativeTo(null);
		setTitle("����");
		setSize(320, 130);
		JPanel jp_main = new JPanel(new GridLayout(2, 3,20,15));
		getContentPane().setLayout(new BorderLayout());
		add("Center",jp_main);
		jp_main.add(lbl_id);
		jp_main.add(lbl_name);
		jp_main.add(lbl_score);
		jp_main.add(jtf_id);
		jp_main.add(jtf_name);
		jp_main.add(jtf_score);
		add("South",jb);
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//�����洢����ѧ�����ϵ��б�
				Vector<Student> students = new Vector<>();
				//��ò�������
				Student student = new Student();
				student.setId(jtf_id.getText());
				student.setName(jtf_name.getText());
				student.setScore(jtf_score.getText());
				//�����洢ɸѡ���ѧ�����ϵ��б�
				Vector<Student> stuList;
				//�ӱ���ȡ��Ϣ��students
				studentDaoImp.readFromTable(students, tm);
				//ɸѡѧ����stuList
				stuList = studentDaoImp.search(students,student);
				new SearchReasult();
			}
		});
		setVisible(true);
	}
}

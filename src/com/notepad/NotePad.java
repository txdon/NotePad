/**
 * �ҵļ��±�������+���ܣ�
 */

package com.notepad;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NotePad extends JFrame implements ActionListener {

	//���
	//�ı�����
	JTextArea jTextArea=null;
	//�˵���
	JMenuBar jMenuBar=null;
	//�˵�
	JMenu jMenu=null;
	//�˵���ѡ��
	JMenuItem jMenuItem1=null;
	JMenuItem jMenuItem2=null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NotePad np=new NotePad();
	}
	
	@SuppressWarnings("deprecation")
	public NotePad() {
		// TODO Auto-generated constructor stub
		
		//����һ���ı�
		jTextArea=new JTextArea();
		//����һ���˵���
		jMenuBar=new JMenuBar();
		//�ڲ˵����ϴ���һ���˵�--�ļ�
		jMenu=new JMenu("�ļ�");
		//�����Ӳ˵�ѡ��
		jMenuItem1=new JMenuItem("��");
		
		//ע�����
		jMenuItem1.addActionListener(this);
		jMenuItem1.setActionCommand("open");
		
		jMenuItem2=new JMenuItem("����");
		
		jMenuItem2.addActionListener(this);
		jMenuItem2.setActionCommand("save");
		
		//���˵������뵽JFrame
		this.setJMenuBar(jMenuBar);
		//���ļ��˵����뵽�˵���
		jMenuBar.add(jMenu);
		//���Ӳ˵�ѡ����뵽�ļ��˵���
		jMenu.add(jMenuItem1);
		jMenu.add(jMenuItem2);		
		
		//���뵽JFrame
		this.add(jTextArea);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(400,300);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("open")) {
			//�����ļ�ѡ����
			JFileChooser jFileChooser=new JFileChooser();
			//��������
			jFileChooser.setDialogTitle("��ѡ���ļ�...");
			//Ĭ����ʾ��ʽ
			jFileChooser.showOpenDialog(null);
			//��ʾ
			jFileChooser.setVisible(true);
			//��ѡ�е��ļ��ľ���·��
			String filename=jFileChooser.getSelectedFile().getAbsolutePath();
			
			//������
			FileReader fileReader=null;
			BufferedReader bufferedReader=null;
			try {
				fileReader=new FileReader(filename);
				bufferedReader=new BufferedReader(fileReader);
				
				String s="";
				while ((s=bufferedReader.readLine())!=null) {
					jTextArea.append(s+"\n");
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
				try {
					bufferedReader.close();
					fileReader.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}else if (e.getActionCommand().equals("save")) {
			JFileChooser jFileChooser=new JFileChooser();
			jFileChooser.setDialogTitle("���Ϊ...");
			jFileChooser.showSaveDialog(null);
			jFileChooser.setVisible(true);
			
			String filename=jFileChooser.getSelectedFile().getAbsolutePath();
			
			FileWriter fileWriter=null;
			BufferedWriter bufferedWriter=null;
			
			try {
				fileWriter=new FileWriter(filename);
				bufferedWriter=new BufferedWriter(fileWriter);
				
				bufferedWriter.write(jTextArea.getText());
			} catch (Exception e2) {
				// TODO: handle exception
			}finally {
				try {
					bufferedWriter.close();
					fileWriter.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			//�����˳�
			//System.exit(EXIT_ON_CLOSE);;
		}
	}

}

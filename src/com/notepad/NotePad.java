/**
 * 我的记事本（界面+功能）
 */

package com.notepad;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NotePad extends JFrame implements ActionListener {

	//组件
	//文本区域
	JTextArea jTextArea=null;
	//菜单栏
	JMenuBar jMenuBar=null;
	//菜单
	JMenu jMenu=null;
	//菜单子选项
	JMenuItem jMenuItem1=null;
	JMenuItem jMenuItem2=null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NotePad np=new NotePad();
	}
	
	@SuppressWarnings("deprecation")
	public NotePad() {
		// TODO Auto-generated constructor stub
		
		//创建一个文本
		jTextArea=new JTextArea();
		//创建一个菜单栏
		jMenuBar=new JMenuBar();
		//在菜单栏上创建一个菜单--文件
		jMenu=new JMenu("文件");
		//创建子菜单选项
		jMenuItem1=new JMenuItem("打开");
		
		//注册监听
		jMenuItem1.addActionListener(this);
		jMenuItem1.setActionCommand("open");
		
		jMenuItem2=new JMenuItem("保存");
		
		jMenuItem2.addActionListener(this);
		jMenuItem2.setActionCommand("save");
		
		//将菜单栏加入到JFrame
		this.setJMenuBar(jMenuBar);
		//将文件菜单放入到菜单栏
		jMenuBar.add(jMenu);
		//将子菜单选项加入到文件菜单里
		jMenu.add(jMenuItem1);
		jMenu.add(jMenuItem2);		
		
		//放入到JFrame
		this.add(jTextArea);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(400,300);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("open")) {
			//创建文件选择器
			JFileChooser jFileChooser=new JFileChooser();
			//设置名字
			jFileChooser.setDialogTitle("请选择文件...");
			//默认显示方式
			jFileChooser.showOpenDialog(null);
			//显示
			jFileChooser.setVisible(true);
			//被选中的文件的绝对路径
			String filename=jFileChooser.getSelectedFile().getAbsolutePath();
			
			//输入流
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
			jFileChooser.setDialogTitle("另存为...");
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
			
			//保存退出
			//System.exit(EXIT_ON_CLOSE);;
		}
	}

}

package org.example;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.script.ScriptException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.pcap4j.core.*;

class Panel extends JPanel{

    BufferedImage image = ImageIO.read(new File("background.jpg"));
    Panel() throws IOException {
    }

    public void paintComponent(Graphics g) {
        g.drawImage(image,0,0,null);
    }

}

class FPanel extends JPanel{

    BufferedImage im = ImageIO.read(new File("brain.jpg"));


    FPanel() throws IOException {
    }

   
    public void paintComponent(Graphics g) {
        g.drawImage(im,0,0,null);
    }
}

public class App{


    public static <Jlabel> void main(final String[] args ) throws PcapNativeException, NotOpenException, IOException, ScriptException {

        final JButton blogin = new JButton("Login");
        blogin.setBounds(700,350,80,40);
        blogin.setBackground(Color.black);
        blogin.setForeground(Color.WHITE);


        final JTextField txuser = new JTextField(15);
        final JPasswordField pass = new JPasswordField(15);
        txuser.setBounds(600,180,300,30);
        pass.setBounds(600,280,300,30);


        final JLabel text = new JLabel("ID");
        final JLabel pal = new JLabel("Password");
        text.setForeground(Color.WHITE);
        pal.setForeground(Color.WHITE);
        text.setBounds(580,180,20,20);
        pal.setBounds(540,280,100,20);


        FPanel p = new FPanel();
        p.setLayout(null);
        p.add(txuser);
        p.add(pass);
        p.add(blogin);
        p.add(text);
        p.add(pal);


        final JFrame login = new JFrame("Capstone Project batch -39");
        login.setSize(1000,900);
        login.setVisible(true);

        login.setPreferredSize(new Dimension(1000,900));
        login.setResizable(false);
        login.add(p);
        blogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = txuser.getText();
                String password = pass.getText();

                if (user.equals("123") && password.equals("123")) {
                    login.dispose();

                    JLabel heading = new JLabel("Intrusion Detection System");
                    heading.setFont(new Font("Arial",Font.BOLD,30));
                    heading.setForeground(Color.WHITE);
                    heading.setBounds(10,0,990,50);

                    JLabel homepage = new JLabel("Dashboard");
                    homepage.setBounds(330,270,300,50);
                    homepage.setFont(new Font("Arial",Font.BOLD,50));
                    homepage.setForeground(Color.WHITE);

                    ImageIcon center = new ImageIcon("smile.jpg");
                    JLabel cen_image = new JLabel();
                    cen_image.setIcon(center);
                    cen_image.setBounds(500,400,400,200);

                    JButton instructions = new JButton("Procedure");
                    instructions.setBackground(Color.blue);
                    instructions.setForeground(Color.WHITE);
                    instructions.setFont(new Font("Arial",Font.BOLD,19));
                    instructions.setBounds(450,440,350,70);
                    instructions.setOpaque(true);
                    instructions.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            JFrame instruction_frame = new JFrame("Procedure");
                            instruction_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            instruction_frame.setVisible(true);


                            JPanel instruction_panel = new JPanel();
                            instruction_panel.setLayout(null);

                            JLabel one = new JLabel("1. Press Capture Packets button to open capture tab ");
                            JLabel two = new JLabel("2. Press capture 100 packets  and select network interface from console");
                            JLabel three = new JLabel("3. Packet capturing starts and  wait for 5 minutes approximately");
                            JLabel four = new JLabel("4. close capture tab and check that using view packets option");
                            JLabel five = new JLabel("5. Apply the ML model and see results from the model tab");


                            one.setBounds(10,30,700,60);
                            one.setForeground(Color.blue);
                            one.setFont(new Font("Arial",Font.BOLD,20));
                            two.setBounds(10,80,700,60);
                            two.setForeground(Color.blue);
                            two.setFont(new Font("Arial",Font.BOLD,20));
                            three.setBounds(10,130,700,60);
                            three.setForeground(Color.blue);
                            three.setFont(new Font("Arial",Font.BOLD,20));
                            four.setFont(new Font("Arial",Font.BOLD,20));
                            four.setBounds(10,180,700,60);
                            four.setForeground(Color.blue);
                            five.setBounds(10,230,700,60);
                            five.setForeground(Color.blue);
                            five.setFont(new Font("Arial",Font.BOLD,20));


                            instruction_panel.add(one);
                            instruction_panel.add(two);
                            instruction_panel.add(three);
                            instruction_panel.add(four);
                            instruction_panel.add(five);

                            instruction_frame.add(instruction_panel);
                            instruction_frame.setSize(800,500);
                            instruction_frame.setPreferredSize(new Dimension(800,600));
                            instruction_frame.setResizable(false);

                        }
                    });

                    JButton ml = new JButton("Detect Intrusion using ML model");
                    ml.setFont(new Font("Arial",Font.BOLD,19));
                    ml.setBackground(Color.blue);
                    ml.setBounds(50,440,350,70);
                    ml.setForeground(Color.WHITE);
                    ml.setOpaque(true);
                    ml.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            final JLabel status= new JLabel("Apply the ML model by pressing the below button");
                            status.setBounds(10,10,900,40);
                            status.setFont(new Font("Arial",Font.TYPE1_FONT,18));
                            status.setForeground(Color.RED);


                            ImageIcon brain = new ImageIcon("data.jpg");
                            JLabel b_im = new JLabel();
                            b_im.setIcon(brain);
                            b_im.setBounds(45,100,500,500);
 
                            JButton results =new JButton("Results");
                            results.setOpaque(true);
                            results.setBackground(Color.green);
                            results.setFont(new Font("Arial",Font.TRUETYPE_FONT,20));
                            results.setBounds(400,400,200,50);
                            results.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    Desktop desktop = Desktop.getDesktop();
                                    try {
                                        desktop.open(new File("D:\\Final Year Project\\NIDS\\New WinRAR ZIP archive\\Network instrusion Detection\\Results_knn.txt"));
                                    } catch (IOException ex) {
                                        ex.printStackTrace();
                                    }
                                }
                            });


                            JButton predict = new JButton("Predict  Intrusion");
                            predict.setFont(new Font("Arial",Font.ITALIC,31));
                            predict.setForeground(Color.white);
                            predict.setBackground(Color.RED);
                            predict.setOpaque(true);
                            predict.setBounds(10,100,600,80);
                            predict.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    status.setText("Wait for the Ml model to predict and conclude results");
                                    JOptionPane.showMessageDialog(null,"Applying ML model ");
                                    try {
                                        ML_Processing.process_ml();
                                    } catch (IOException ex) {

                                        ex.printStackTrace();
                                    }
                                    status.setText("Intrusion detected");

                                }
                            });


                            JPanel b = new JPanel();

                            b.setBackground(Color.BLACK);
                            b.setLayout(null);
                            b.add(status);
                            b.add(predict);
                            b.add(b_im);
                            b.add(results);


                            final JFrame ml_frame = new JFrame("Applying ML on the dataset ");
                            ml_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            ml_frame.setVisible(true);
                            ml_frame.add(b);



                            ml_frame.setSize(600,500);
                        }
                    });

                    JButton open_dataset = new JButton("View Packets");
                    open_dataset.setFont(new Font("Arial",Font.BOLD,19));
                    open_dataset.setBounds(450,350,350,70);
                    open_dataset.setBackground(Color.blue);
                    open_dataset.setForeground(Color.WHITE);
                    open_dataset.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Desktop desktop = Desktop.getDesktop();
                            try {
                                desktop.open(new File("D:\\Final Year Project\\NIDS\\New WinRAR ZIP archive\\Network instrusion Detection\\Legitimate_Features\\Pcaps_Legitimate\\good_1.csv"));
                            } catch (IOException ex) {
                                JOptionPane.showMessageDialog(null,"File does not exist");
                                ex.printStackTrace();


                            }
                        }
                    });

                    JButton capture = new JButton("Capture Packets");
                    capture.setBackground(Color.blue);
                    capture.setForeground(Color.WHITE);
                    capture.setFont(new Font("Arial",Font.BOLD,20));
                    capture.setOpaque(true);
                    capture.setBounds(50,350,350,70);


                    capture.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            final JFrame frame = new JFrame("Capture Packets ");
                            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            frame.setVisible(true);

                            frame.setSize(1000,500);

                            final JPanel a = new JPanel();
                            a.setLayout(null);

                            frame.add(a);

                         
                            JLabel instruction = new JLabel(" SELECT NETWORK INTERFACE FROM console after pressing button");

                            instruction.setFont(new Font("Arial",Font.ITALIC,20));
                            instruction.setForeground(Color.WHITE);
                            instruction.setBounds(20,10,1300,50);

                            
                            ImageIcon image = new ImageIcon("data1.jpg");

                            JLabel data_pic = new JLabel();
                            data_pic.setIcon(image);

                            data_pic.setBounds(200,100,1200,400);


                            final JButton start_capturing = new JButton("Capture packets");
                            start_capturing.setForeground(Color.black);
                            start_capturing.setBackground(Color.YELLOW);
                            start_capturing.setFont(new Font("Arial",Font.ITALIC,30));
                            start_capturing.setOpaque(true);
                            start_capturing.setBounds(20,100,800,50);
                            start_capturing.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {

                                    try {
                                        ImageIcon loading = new ImageIcon("gear.gif");
                                        JLabel load = new JLabel();
                                        load.setIcon(loading);
                                        load.setBounds(600,200,20,10);
                                        a.add(load);
                                        frame.add(a);


                                        PcapNetworkInterface device=null;
                                        device = Get_Network_interface.getNetworkDevice();
                                        JOptionPane.showMessageDialog(null,"Capturing packets,Wait for 5 minutes");


                                        Capture_packets_and_save.Capture_and_save(device);
                                        Conversion_of_pcap_to_csv.pcap_to_test_data();


                                        JOptionPane.showMessageDialog(null,"Capturing Packets finished");
                                    } catch (IOException ex) {
                                        ex.printStackTrace();
                                    } catch (PcapNativeException ex) {
                                        ex.printStackTrace();
                                    } catch (NotOpenException ex) {
                                        ex.printStackTrace();
                                    }


                                }
                            });



                            a.add(instruction);
                            a.add(start_capturing);
                            a.setBackground(Color.BLACK
                            );

                            a.add(data_pic);


                            JButton close = new JButton("Close ");
                            close.setFont(new Font("Arial",Font.PLAIN,18));
                            close.setOpaque(true);
                            close.setBounds(600,300,100,50);
                            close.setBackground(Color.RED);
                            close.setForeground(Color.WHITE);
                            close.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    frame.dispose();

                                }
                            });
                            a.add(close);


                        }
                    });


                    Panel panel = null;
                    try {
                        panel = new Panel();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    panel.setLayout(null);
                    panel.add(heading);
                    panel.add(capture);
                    panel.add(homepage);
                    panel.add(instructions);
                    panel.add(open_dataset);
                    panel.add(ml);



                    final JFrame main_frame = new JFrame("Intrusion detection system ");
                    main_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    main_frame.setVisible(true);
                    main_frame.add(panel);
                    main_frame.setSize(1000,900);
                    main_frame.setPreferredSize(new Dimension(1600, 900));
                    main_frame.setResizable(false);



                    JButton exit = new JButton("EXIT");
                    exit.setForeground(Color.WHITE);
                    exit.setBackground(Color.BLACK);
                    exit.setFont(new Font("Arial",Font.BOLD,19));
                    exit.setBounds(830,5,100,50);
                    exit.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            main_frame.dispose();
                        }
                    });
                    panel.add(exit);


                }
                else {
                    JOptionPane.showMessageDialog(null,"Wrong Password / Username");
                    txuser.setText("");
                    pass.setText("");
                    txuser.requestFocus();
                }
            }
        });




    }



    }
/*
 *     
 * 
 */
package za.co.nemesisnet.supreme.invention.ClientPackages.view;

/**
 *
 * @author Peter B
 */
/*
 * GuiClientApp.java
 *
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */
import za.co.nemesisnet.supreme.invention.model.Message;
import za.co.nemesisnet.supreme.invention.model.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Radford
 */
public class GuiClientApp extends JFrame implements ActionListener {

    private Socket server;
    private JButton exitBtn = new JButton("EXIT");
    private JButton loginBtn = new JButton("LOGIN");
    private JLabel clientLbl = new JLabel("Enter text here");
    private JTextField clientTxt = new JTextField(20);
    private JTextArea serverTxt = new JTextArea(5, 40);
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private String response = "";
    public Object responseObject ;
    public Message responseMessage ;
    private JPanel topPanel = new JPanel();
    private JPanel bottomPanel = new JPanel();

//------------------------------------------------------------------------------------------------    
    //Define a constructor which includes your GUI design as well as establishing a connection to the server
    public GuiClientApp() {
        setupGui(); // Setup the GUI
        connectToServer();
    }

    private void setupGui() {
        //Setup the GUI
        setTitle("Client");
        setSize(500, 300);
        setLocation(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        topPanel.setLayout(new FlowLayout());
        bottomPanel.setLayout(new FlowLayout());
        topPanel.add(clientLbl);
        topPanel.add(clientTxt);
        clientTxt.addActionListener(this);
        bottomPanel.add(loginBtn);
        bottomPanel.add(exitBtn);

        add(topPanel, BorderLayout.NORTH);
        add(serverTxt, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        loginBtn.addActionListener(this);
        exitBtn.addActionListener(this);
        setVisible(true);
        clientTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                String temp = clientTxt.getText();
                serverTxt.append(temp);
             //   serverTxt.setText(temp);
                System.out.println(".mouseClicked ");
                System.out.println("clientTxt.getText()  : " + clientTxt.getText());
                try {
                    sendData(temp);
                } catch (Exception ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }
        });

//        clientTxt.addFocusListener(new java.awt.event.FocusAdapter() {
//            public void focusGained(java.awt.event.FocusEvent evt) {
//                String temp = clientTxt.getText();
//                clientTxt.setText( temp);
//            }
//        });
    }

    private void connectToServer() {
        //Establish a connection to the server
        try {
            server = new Socket("localhost", 5050);
            out = new ObjectOutputStream(server.getOutputStream());
            in = new ObjectInputStream(server.getInputStream());
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    //declare the actionPerformed method in which you send the required data to the server
    public void actionPerformed(ActionEvent e) {
        //    when the user clicks on the textfield clientTxt send the text to the server.

        //   So the code to send data is in the actionPerformed method.
        System.out.println("actionPerformed " + e.getSource());
        if (e.getSource() == clientTxt) {
            System.out.println("This is the text the user has typed in the textfield ...clientTxt.getText()  : " + clientTxt.getText());  //  this is the text the user has typed in the textfield

            try {
                Message tempMessage =  sendMessageData(new Message(clientTxt.getText()));
                serverTxt.append("Server says : "  + tempMessage.getText() + "\n");
                
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
        if (e.getSource() == exitBtn) {
            exit();
        }
        if (e.getSource() == loginBtn) {
            login();
        }
    }

    private void login() {

        User user = new User();
        user.setUserName("admin");
        user.setPassword("Admin@123456");
        Message message = new Message("LOGIN");
        LoginUserForm loginForm = new LoginUserForm(user, this);
        loginForm.setVisible(true);

    }

    //declare a method in which you write data to the server
    //comes from text feild
    public void sendData(String myMsg) {
        try {
            Message message = new Message(myMsg);
            out.writeObject(message);
           // in.readObject();
            System.out.println("Client sendData Message :" + message.getText());
            out.flush();
            out.writeObject(message);
        } catch (IOException ex) {
            System.out.println("Error writing to server: " + ex.getMessage());
        }
    }

    public Message sendMessageData(Message message) {
        try {
            out.writeObject(message);//sending mes to server
            System.out.println("Client sendData Message :" + message.getText());//prints
            out.flush();//cleans buffer
            System.out.println("Client Waiting for a Response from server..." );//prints
            // return response message  server
           // Message newMessage =  new Message(); //new object of type message  to store and receive response form server
            responseMessage = (Message) in.readObject(); //getting object input stream from server
            serverTxt.append("Server say : " + responseMessage.getText() + "\n");
          //  responseMessage = newMessage;
             System.out.println("Client received Response from server..." );
            ///responseObject =  in.readObject();

        } catch (IOException ex) {
            System.out.println("Error writing to server: " + ex.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error writing to server: " + e.getMessage());
            e.printStackTrace();
        }
        return responseMessage;
    }

    public Object sendObjectData(Object object) {
        try {
            System.out.println("Client sending Object Data :" + object.toString());
            out.writeObject(object);
            
            out.flush();
            //receive and return response object from server

            responseObject = in.readObject();
            System.out.println("Client Received Response Object Data :" + object.toString());

        } catch (IOException ex) {
            System.out.println("Error writing to server: " + ex.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return responseObject;
    }

//declare a method in which you setup the communication streams    
    private void getStreams() {
        try {
            out = new ObjectOutputStream(server.getOutputStream());

            //  out.flush();
            in = new ObjectInputStream(server.getInputStream());

        } catch (Exception ex) {
            System.out.println("Error getting streams: " + ex.getMessage());
        }

    }

//declare a method in which you continuously read from the server.
    //   public void communicate()    ;
    /*Since this is a GUI-driven client application
     * it is only necessary to continuously read from the server until the value 'terminate' is read.
     *
     */
    private void communicate() {
        try {

            do {
                getStreams();
            } while (!response.equals("terminate"));
        } catch (Exception ex) {
            System.out.println("Error communicating with server: " + ex.getMessage());
        } finally {
            closeConnection();
        }
    }

    public static void main(String[] args) {
        GuiClientApp client = new GuiClientApp();

    }
    //this method appends the text to the text area called serverTxt

    public void appendToServerTxt(String text) {
        serverTxt.append("Server says : " + text + "\n");
    }

//------------------------------------------------------------------------------------------------    
//declare a method in which you close the streams and the socket connection
    private void closeConnection() {
        try {
            out.close();
            in.close();
            server.close();
        } catch (IOException ex) {
            System.out.println("Error closing connection: " + ex.getMessage());
        }
    }

    public void exit() {
        JOptionPane.showMessageDialog(new JFrame(), "Thanks for using my program!  \n \n " + "Author : Peter Buckingham \n Student Number: ****65289 \n Date: Oct 2022", "Client System - Goodbye ", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("");
        System.out.println("Thanks for using my program!");
        System.out.println("Author : Peter Buckingham \n");
        System.err.println("");
        System.exit(0);
    }

}

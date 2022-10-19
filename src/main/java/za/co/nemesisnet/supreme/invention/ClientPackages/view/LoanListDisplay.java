/*
 *     
 * 
 */
package za.co.nemesisnet.supreme.invention.ClientPackages.view;

import java.awt.Image;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;


import za.co.nemesisnet.supreme.invention.model.*;

/**
 *
 * @author Peter Buckingham
 */
public class LoanListDisplay extends javax.swing.JFrame {
 
    ArrayList<Book> bookList;
    User user;
    Message responseMessageObject;
    Object responseDataObject;
    ArrayList<Loan> loanList;
    Book book;
    GuiClientApp guiClientApp;
    Object [][] unsortedLoanList;
    Object [][] sortedLoanList;

    /**
     * @apiNote This method is used to display the loan list. It is used to display the loan list. This method is intended to be used to display the loan list. This method is used to display the loan list. It is used to display the loan list. This method is intended to be used to display the loan list.
     * @apiNote This class Gets a list of the loans and displays them in order of due date. it checks the current date to determine the status of the loan. It is used to get a list of the loans and display them in order of due date. This class is intended to be used to get a list of the loans and display them in order of due date. This class gets a list of the loans and displays them in order of due date. It is used to get a list of the loans and display them in order of due date.
     * @apiNote each item in the list is clickable and will display the book details. It is used to display the loan details, such as the book and user and due date. This method is intended to be used to display the loan details, such as the book and user and due date. This method displays the loan details, such as the book and user and due date. It is used to display the loan details, such as the book and user and due date.
     */
    public LoanListDisplay() {
        setTitle("Client System" +" - " + "Bookshelf");
        initComponents();
    }

    public LoanListDisplay(User user, ArrayList<Book> bookList, GuiClientApp guiClientApp, ArrayList<Loan> loanList) {
        setTitle("Client System" +" - " + "Loan List" );
        initComponents();
        this.bookList = bookList;
        this.user = user;
        this.loanList = loanList;
        this.guiClientApp = guiClientApp;
          //get todays date
        //iterate through the loan list and sort by due date
        //totalPenaltyCost is calculated as follows: Every book on loan must be returned within 7 days. R0.50 penalty is
        //charged for every day after the 7 days.
        // if the loan is overdue display yes and display the days overdue in the overdue column else display not overdue. also display the total penalty cost in the total penalty cost column.
        //then display the list in the table
        //if the user clicks on a loan in the table display the loan details in a new window


//        Message message  = new Message("LISTALLBOOKS");
//        
//       responseMessageObject =  guiClientApp.sendMessageData(message);
//       responseDataObject = guiClientApp.sendObjectData(bookList);
//        bookList = (ArrayList<Book>) responseDataObject;
        
        //loop though list to populate table
        // this.userList = userList;

        Object[] columnNames = {"Number : ", "Title : ", "Sub-Title : ", "Author : ", "Description : ", "Rating : " ,"DueDate : " , "Overdue : ","Curernt Penalty : " };

    //get todays date to compare to due date
        Dates dates = new Dates();
        Date today = dates.getTodayDate();
        Date dueDate = dates.getTodayDate();
        //get the loan list
        //iterate through the loan list and sort by due date
        //totalPenaltyCost is calculated as follows: Every book on loan must be returned within 7 days. R0.50 penalty.

        Object[][] loanData = new Object[loanList.size()][5];
        for (int i = 0; i < loanList.size(); i++) {
            loanData[i][0] = loanList.get(i).getLoanNumber();
            loanData[i][1] = loanList.get(i).getDueOnDate();
            loanData[i][2] = loanList.get(i).isOverdue(dates.getDateObject(loanList.get(i).getDueOnDate()));//string
            loanData[i][3] = loanList.get(i).getDaysOverdue();//int
            loanData[i][4] = loanList.get(i).getCurrentPenaltyCost();
        }
        unsortedLoanList = loanData;
        // sort the loan list by due date and store in sortedLoanList
        sortedLoanList = sortLoanListByDueDate(unsortedLoanList);

        Object[][] bookData = new Object[bookList.size()][6];
        for (int i = 0; i < bookList.size(); i++) {

        //    data[i][0] = bookList.get(i).getBookId();
            // data[i][0] = i;
            bookData[i][1] = bookList.get(i).getTitle();
            bookData[i][2] = bookList.get(i).getSubTitle();
            bookData[i][3] = bookList.get(i).getAuthors();
            bookData[i][4] = bookList.get(i).getDescription();
     //       data[i][5] = bookList.get(i).getRating();

        }

        DefaultTableModel model = new DefaultTableModel(bookData, columnNames) {

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        jTable1.setModel(model);

// create JTable just once and pass model in the constructor
    }

    private Object[][] sortLoanListByDueDate(Object[][] unsortedLoanList) {
        //sort loanData array by due date and display in table in ascending order
        //loop through the loan list and sort by due date using getDueOnDate() and store date sorted list in sortedLoanList
        // get the due date of each loan and store in convert it to a date object
        //compare the due date and sort the loan list by due date
        for  (int i = 0; i < loanList.size(); i++) {
           for (int j = 0; j < loanList.size(); j++) {
               //convert string dates to date objects for comparison
                String dueDate1 = loanList.get(i).getDueOnDate();
                String dueDate2 = loanList.get(j).getDueOnDate();
                Date date1 = new Date();
                Date date2 = new Date();
                Dates datesTool = new Dates();
                date1 = datesTool.getDateObject(dueDate1);
                date2 = datesTool.getDateObject(dueDate2);
                //(days late) 14 / 7(fine period ) = overdue 
          
                //ovwerdue * 0.50 = penalty 
                  

                //compare dates
        //       if (loanList.get(i).getDueOnDate().compareTo(loanList.get(j).getDueOnDate()) < 0) {
    //               sortedLoanList[i][j] = unsortedLoanList[i][j];
   //            }
               if (date1.compareTo(date2) < 0) {
                   sortedLoanList[i][j] = unsortedLoanList[i][j];
               }

           }

           }

        return sortedLoanList;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMain = new javax.swing.JPanel();
        jPanelMid3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanelBottom = new javax.swing.JPanel();
        jButtonCancel = new javax.swing.JButton();
        jPanelTop = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemNewLoan = new javax.swing.JMenuItem();
        jMenuEdit = new javax.swing.JMenu();
        jMenuItemUserProfile = new javax.swing.JMenuItem();
        jMenuItemCRUD = new javax.swing.JMenuItem();
        jMenuSettings = new javax.swing.JMenu();
        jMenuItemConnectivity = new javax.swing.JMenuItem();
        jMenuItemCompanyProfile = new javax.swing.JMenuItem();
        jMenuHelp = new javax.swing.JMenu();
        jMenuItemAbout = new javax.swing.JMenuItem();
        jMenuItemHelpWiki = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(displayFrameImageIcon());
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jPanelMain.setBackground(new java.awt.Color(250, 249, 246));

        jPanelMid3.setBackground(new java.awt.Color(192, 192, 192));
        jPanelMid3.setForeground(new java.awt.Color(0, 0, 0));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Number", "Ttile", "Sub-Title", "Autor", "Description", "Rating"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanelMid3Layout = new javax.swing.GroupLayout(jPanelMid3);
        jPanelMid3.setLayout(jPanelMid3Layout);
        jPanelMid3Layout.setHorizontalGroup(
            jPanelMid3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMid3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanelMid3Layout.setVerticalGroup(
            jPanelMid3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMid3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jPanelBottom.setBackground(new java.awt.Color(192, 192, 192));
        jPanelBottom.setForeground(new java.awt.Color(0, 0, 0));

        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBottomLayout = new javax.swing.GroupLayout(jPanelBottom);
        jPanelBottom.setLayout(jPanelBottomLayout);
        jPanelBottomLayout.setHorizontalGroup(
            jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBottomLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCancel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelBottomLayout.setVerticalGroup(
            jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBottomLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButtonCancel)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanelTop.setBackground(new java.awt.Color(192, 192, 192));

        jLabel3.setBackground(new java.awt.Color(192, 192, 192));
        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Bookshelf :");

        javax.swing.GroupLayout jPanelTopLayout = new javax.swing.GroupLayout(jPanelTop);
        jPanelTop.setLayout(jPanelTopLayout);
        jPanelTopLayout.setHorizontalGroup(
            jPanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTopLayout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTopLayout.setVerticalGroup(
            jPanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTopLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addGap(63, 63, 63))
        );

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMid3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelBottom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addComponent(jPanelTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelMid3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenuFile.setMnemonic('F');
        jMenuFile.setText("File");

        jMenuItemNewLoan.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, 0));
        jMenuItemNewLoan.setMnemonic('L');
        jMenuItemNewLoan.setText("New Loan");
        jMenuItemNewLoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNewLoanActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemNewLoan);

        jMenuBar1.add(jMenuFile);

        jMenuEdit.setMnemonic('e');
        jMenuEdit.setText("Edit");

        jMenuItemUserProfile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, 0));
        jMenuItemUserProfile.setMnemonic('u');
        jMenuItemUserProfile.setText("User Profile");
        jMenuItemUserProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUserProfileActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItemUserProfile);

        jMenuItemCRUD.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, 0));
        jMenuItemCRUD.setMnemonic('c');
        jMenuItemCRUD.setText("CRUD");
        jMenuItemCRUD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCRUDActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItemCRUD);

        jMenuBar1.add(jMenuEdit);

        jMenuSettings.setMnemonic('s');
        jMenuSettings.setText("Settings");

        jMenuItemConnectivity.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, 0));
        jMenuItemConnectivity.setMnemonic('c');
        jMenuItemConnectivity.setText("Connectivity");
        jMenuItemConnectivity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConnectivityActionPerformed(evt);
            }
        });
        jMenuSettings.add(jMenuItemConnectivity);

        jMenuItemCompanyProfile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, 0));
        jMenuItemCompanyProfile.setMnemonic('P');
        jMenuItemCompanyProfile.setText("Company Profile");
        jMenuItemCompanyProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCompanyProfileActionPerformed(evt);
            }
        });
        jMenuSettings.add(jMenuItemCompanyProfile);

        jMenuBar1.add(jMenuSettings);

        jMenuHelp.setMnemonic('h');
        jMenuHelp.setText("Help");

        jMenuItemAbout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, 0));
        jMenuItemAbout.setMnemonic('a');
        jMenuItemAbout.setText("About");
        jMenuItemAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAboutActionPerformed(evt);
            }
        });
        jMenuHelp.add(jMenuItemAbout);

        jMenuItemHelpWiki.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, 0));
        jMenuItemHelpWiki.setMnemonic('w');
        jMenuItemHelpWiki.setText("Help Wiki");
        jMenuItemHelpWiki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemHelpWikiActionPerformed(evt);
            }
        });
        jMenuHelp.add(jMenuItemHelpWiki);

        jMenuBar1.add(jMenuHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        System.out.println("table prints this");// TODO add your handling code here:
        String button = "none";
        System.out.println("Event trigered : " + evt);
        if (evt.getClickCount() == 2 && jTable1.getSelectedRow() != -1) {
            // your valueChanged overridden method 

            System.out.println(jTable1.getSelectedRow());
            // DisplayBookForm displayBookForm = new DisplayBookForm(bookList.get(jTable1.getSelectedRow()));
      //      Read read = new Read();
            Book book = bookList.get(jTable1.getSelectedRow());//book

            String userId = user.getUserId();
    //        String bookId = String.valueOf(book.getBookId());///get the loan of this book to compare with this users

       //     Loan lastLoan = read.readLatestLoanByBookId(book);
          //  if (lastLoan.getReturnedDate().equalsIgnoreCase("0-0-0")) {
     //           if (lastLoan.getUserId().equalsIgnoreCase(userId)) {
     //               button ="returns";                   
     //           }
   //             System.out.println("Not alavlible , a user cutrently has this book");
  //              System.out.println("This is the return due date : " +lastLoan.getReturnedDate());
  //              System.out.println("Currnetly out on loan with User id : " +lastLoan.getUserId());
  //          } else {
 //               System.out.println("Book avalible to loan");
  //              button = "loan";
  //          }

           

       //     System.out.println("Current Book id : " +book.getBookId());
            System.out.println("Currnet User id : " +user.getUserId());
            

            System.out.println("Button is set to : "+button);

            DisplayBookForm displayBookForm = new DisplayBookForm(user, bookList.get(jTable1.getSelectedRow()), button);// means display loan buton
        }


    }//GEN-LAST:event_jTable1MouseClicked

    private void jMenuItemConnectivityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConnectivityActionPerformed
        // TODO add your handling code here:
//        SystemSettingsConectionsForm systemSettingsConectionsForm = new SystemSettingsConectionsForm();
 //       systemSettingsConectionsForm.setVisible(rootPaneCheckingEnabled);
        // systemSettingsConectionsForm.setAlwaysOnTop(rootPaneCheckingEnabled);

    }//GEN-LAST:event_jMenuItemConnectivityActionPerformed

    private void jMenuItemCompanyProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCompanyProfileActionPerformed
        // TODO add your handling code here:
//        SystemSettingsCompanyProfileForm systemSettingsCompanyProfileForm = new SystemSettingsCompanyProfileForm();
//        systemSettingsCompanyProfileForm.setVisible(rootPaneCheckingEnabled);
        // systemSettingsCompanyProfileForm.setAlwaysOnTop(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItemCompanyProfileActionPerformed

    private void jMenuItemAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAboutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemAboutActionPerformed

    private void jMenuItemHelpWikiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemHelpWikiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemHelpWikiActionPerformed

    private void jMenuItemUserProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUserProfileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemUserProfileActionPerformed

    private void jMenuItemCRUDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCRUDActionPerformed
        // TODO add your handling code here:
        int userAccessLevel = Integer.valueOf(user.getAccessLevel());
        if (userAccessLevel>0) {
 //       CRUDGui cRUDGui = new CRUDGui();
 //       cRUDGui.setVisible(rootPaneCheckingEnabled);
 //       cRUDGui.setAutoRequestFocus(true);
        }
        else
        {
        JOptionPane.showMessageDialog(new JFrame(), "Error!  \n \n " + "you Do not have sufficent privliages to acces this menu! \n  Please contact the system admin for assistance!", "Ubiquitous System - UAC ", JOptionPane.INFORMATION_MESSAGE);
        }
        
        //  cRUDGui.set
        // this.setVisible(true);
        // this.dispose();
    }//GEN-LAST:event_jMenuItemCRUDActionPerformed

    private void jMenuItemNewLoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNewLoanActionPerformed
        // TODO add your handling code here:
//        Read read = new Read();
//        //   DisplayBookForm displayBookForm = new DisplayBookForm(user, read.loanBookByTitle(), rootPaneCheckingEnabled);
//        BookingForm bookingForm = new BookingForm(user, read.loanBookByTitle());
//        bookingForm.setVisible(true);
//        bookingForm.setAutoRequestFocus(true);


    }//GEN-LAST:event_jMenuItemNewLoanActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
        SwingUtilities.updateComponentTreeUI(this);
        this.invalidate();
        this.validate();
        this.repaint();
    }//GEN-LAST:event_formFocusGained

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
        SwingUtilities.updateComponentTreeUI(this);
        this.invalidate();
        this.validate();
        this.repaint();
    }//GEN-LAST:event_formWindowGainedFocus

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseEntered

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoanListDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoanListDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoanListDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoanListDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoanListDisplay().setVisible(true);
  //              Read read = new Read();
                //read.readAllBooks();
                //bookListForm = new BookListForm(read.readAllBooks());
                //  bookListForm.setVisible(true);
                //bookListForm.setAutoRequestFocus(rootPaneCheckingEnabled);
            }
        });
    }

    public Image displayFrameImageIcon() {
    //    FrameSettings frameSettings = new FrameSettings();
        return null;
    }

    public void exit() {
        JOptionPane.showMessageDialog(new JFrame(), "Thanks for using my program!  \n \n " + "Author : Peter Buckingham \n Student Number: ****65289 \n Date: May 2022", "Ubiquitous System - CRUD ", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("");
        System.out.println("Thanks for using my program!");
        System.out.println("Author : Peter Buckingham \n");
        System.err.println("");
        System.exit(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuEdit;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenu jMenuHelp;
    private javax.swing.JMenuItem jMenuItemAbout;
    private javax.swing.JMenuItem jMenuItemCRUD;
    private javax.swing.JMenuItem jMenuItemCompanyProfile;
    private javax.swing.JMenuItem jMenuItemConnectivity;
    private javax.swing.JMenuItem jMenuItemHelpWiki;
    private javax.swing.JMenuItem jMenuItemNewLoan;
    private javax.swing.JMenuItem jMenuItemUserProfile;
    private javax.swing.JMenu jMenuSettings;
    private javax.swing.JPanel jPanelBottom;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelMid3;
    private javax.swing.JPanel jPanelTop;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

/*
 *     
 * 
 */
package za.co.nemesisnet.supreme.invention.ClientPackages.view;

/**
 *
 * @author Peter Buckingham
 */
import java.awt.Image;
import java.awt.Insets;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import za.co.nemesisnet.supreme.invention.model.Book;
import za.co.nemesisnet.supreme.invention.model.Loan;
import za.co.nemesisnet.supreme.invention.model.User;


public class DisplayBookForm extends javax.swing.JFrame {

    public static String myBookTitle, subtTitle, author, description, category, imageLink;
    public Boolean displayBookLoanButton = false;
    public Book book = null;
    public User user = null;

    /**
     * Creates new form CreateBookForm
     */
    public DisplayBookForm() {
        initComponents();
    }

    public DisplayBookForm(String titleIn, String subtTitleIn, String authorIn, String descriptionIn, String category, String imageLinkIn) {
        myBookTitle = titleIn;
        subtTitle = subtTitleIn;
        author = authorIn;
        description = descriptionIn;
        DisplayBookForm.category = category;
        imageLink = imageLinkIn;
        initComponents();
    }

    //  create.createBook( jTextFieldTitle.getText(), jTextFieldSubTitle.getText(), jTextFieldAuthor.getText(), jTextFieldISBN.getText(), jTextFieldDescription.getText(), jTextFieldRating.getText(), jTextFieldImageLink.getText() );
    //  public static DisplayBookForm displayBookForm = new DisplayBookForm(title,  subtTitle, author, description ,  category,  imageLink);
    //  public  DisplayBookForm displayBookForm = new DisplayBookForm("Hyperion ", "Space books ", "Dan Simmions", "The book that reinvented Space Opera, from the Hugo and World Fantasy Award-winning author of The Terror, which is now a chilling TV show. It is the 29th century and the universe of the Human Hegemony is under threat. Invasion by the warlike Ousters looms, and the mysterious schemes of the secessionist AI TechnoCore bring chaos ever closer. On the eve of disaster, with the entire galaxy at war, seven pilgrims set fourth on a final voyage to the legendary Time Tombs on Hyperion, home to the Shrike, a lethal creature, part god and part killing machine, whose powers transcend the limits of time and space. The pilgrims have resolved to die before discovering anything less than the secrets of the universe itself.  ", "4", "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1405546838l/77566.jpg");
    public DisplayBookForm(Book book, String displayBookButtons) {
        try {
            this.book = book;
            myBookTitle = book.getTitle();
            subtTitle = book.getSubTitle();
            author = book.getAuthors();
            description = book.getDescription();
            category = book.getCategory();
            imageLink = book.getImageLink();
            this.setVisible(true);
            initComponents();
            switch (displayBookButtons) {
                case "loan":

                    jButtonLoan.setVisible(true);
                    jButtonReturn.setVisible(false);
                    break;
                case "returns":

                    jButtonLoan.setVisible(false);
                    jButtonReturn.setVisible(true);
                    break;
                default:
                    jButtonLoan.setVisible(false);
                    jButtonReturn.setVisible(false);
                    ;
            }

            jLabelTitle.setText(myBookTitle);
            jLabelSubTitle.setText(subtTitle);
            jLabelAuthor.setText(author);
            jTextAreaDescription.setText(description);
            jLabelCategory.setText(category);

            URL url = new URL(imageLink);
            Image image = ImageIO.read(url);
            ImageIcon imageIcon;
            jLabelPicture.setIcon(imageIcon = new ImageIcon(image.getScaledInstance(jPanelImagePanel.getWidth(), jPanelImagePanel.getHeight(), Image.SCALE_SMOOTH)));

        } catch (MalformedURLException ex) {
            Logger.getLogger(DisplayBookForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DisplayBookForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DisplayBookForm(User user, Book book, String displayBookButtons) {
        try {
            this.book = book;
            this.user = user;
            myBookTitle = book.getTitle();
            subtTitle = book.getSubTitle();
            author = book.getAuthors();
            description = book.getDescription();
            category = book.getCategory();
            imageLink = book.getImageLink();

            this.setVisible(true);
            initComponents();
            switch (displayBookButtons) {
                case "loan":

                    jButtonLoan.setVisible(true);
                    jButtonReturn.setVisible(false);
                    break;
                case "returns":

                    jButtonLoan.setVisible(false);
                    jButtonReturn.setVisible(true);
                    break;
                case "none":

                    jButtonLoan.setVisible(false);
                    jButtonReturn.setVisible(false);
                    break;
                default:
                    jButtonLoan.setVisible(false);
                    jButtonReturn.setVisible(false);
                    
            }

            //jButtonLoan.setVisible(displayBookLoanButton);
            jLabelTitle.setText(myBookTitle);
            jLabelSubTitle.setText(subtTitle);
            jLabelAuthor.setText(author);
            jTextAreaDescription.setText(description);
            jLabelCategory.setText(category);

            URL url = new URL(imageLink);
            Image image = ImageIO.read(url);
            ImageIcon imageIcon;
            jLabelPicture.setIcon(imageIcon = new ImageIcon(image.getScaledInstance(jPanelImagePanel.getWidth(), jPanelImagePanel.getHeight(), Image.SCALE_SMOOTH)));

        } catch (MalformedURLException ex) {
            Logger.getLogger(DisplayBookForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DisplayBookForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String getMyBookTitle() {
        return myBookTitle;
    }

    public static void setMyBookTitle(String title) {
        DisplayBookForm.myBookTitle = title;
    }

    public static String getSubtTitle() {
        return subtTitle;
    }

    public static void setSubtTitle(String subtTitle) {
        DisplayBookForm.subtTitle = subtTitle;
    }

    public static String getAuthor() {
        return author;
    }

    public static void setAuthor(String author) {
        DisplayBookForm.author = author;
    }

    public static String getDescription() {
        return description;
    }

    public static void setDescription(String description) {
        DisplayBookForm.description = description;
    }

    public static String getCategory() {
        return category;
    }

    public static void setCategory(String category) {
        DisplayBookForm.category = category;
    }

    public static String getImageLink() {
        return imageLink;
    }

    public static void setImageLink(String imageLink) {
        DisplayBookForm.imageLink = imageLink;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMain = new javax.swing.JPanel();
        jPanelMid = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        jLabelAuthor = new javax.swing.JLabel();
        jLabelCategory = new javax.swing.JLabel();
        jLabelSubTitle = new javax.swing.JLabel();
        jPanelImagePanel = new javax.swing.JPanel();
        jLabelPicture = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescription = new javax.swing.JTextArea();
        jPanelBottom = new javax.swing.JPanel();
        jButtonClose = new javax.swing.JButton();
        jButtonLoan = new javax.swing.JButton();
        jButtonReturn = new javax.swing.JButton();
        jPanelTop = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CRUD - Opertation - Display Book ");
        setIconImage(displayFrameImageIcon());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanelMain.setBackground(new java.awt.Color(250, 249, 246));

        jPanelMid.setBackground(new java.awt.Color(192, 192, 192));
        jPanelMid.setForeground(new java.awt.Color(0, 0, 0));

        jLabelTitle.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTitle.setText("Title:");
        jLabelTitle.setToolTipText("Book Title");

        jLabelAuthor.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabelAuthor.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAuthor.setText("Author:");
        jLabelAuthor.setToolTipText("Book Author");

        jLabelCategory.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCategory.setText("Category:");
        jLabelCategory.setToolTipText("Book Rating");

        jLabelSubTitle.setFont(new java.awt.Font("Dialog", 2, 11)); // NOI18N
        jLabelSubTitle.setForeground(new java.awt.Color(0, 0, 0));
        jLabelSubTitle.setText("SubTitle: ");
        jLabelSubTitle.setToolTipText("Book Sub Title ");

        jPanelImagePanel.setMaximumSize(new java.awt.Dimension(150, 150));
        jPanelImagePanel.setMinimumSize(new java.awt.Dimension(100, 150));
        jPanelImagePanel.setPreferredSize(new java.awt.Dimension(198, 2));

        jLabelPicture.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelPicture.setToolTipText("Book Cover");
        jLabelPicture.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanelImagePanelLayout = new javax.swing.GroupLayout(jPanelImagePanel);
        jPanelImagePanel.setLayout(jPanelImagePanelLayout);
        jPanelImagePanelLayout.setHorizontalGroup(
            jPanelImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelPicture, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
        );
        jPanelImagePanelLayout.setVerticalGroup(
            jPanelImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelPicture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTextAreaDescription.setEditable(false);
        jTextAreaDescription.setColumns(20);
        jTextAreaDescription.setLineWrap(true);
        jTextAreaDescription.setRows(5);
        jTextAreaDescription.setText("Description:");
        jTextAreaDescription.setToolTipText("Book Description");
        jTextAreaDescription.setWrapStyleWord(true);
        jTextAreaDescription.setCursor(new java.awt.Cursor(java.awt.Cursor.N_RESIZE_CURSOR));
        jTextAreaDescription.setMargin(new Insets(5,5,5,5));
        jScrollPane1.setViewportView(jTextAreaDescription);

        javax.swing.GroupLayout jPanelMidLayout = new javax.swing.GroupLayout(jPanelMid);
        jPanelMid.setLayout(jPanelMidLayout);
        jPanelMidLayout.setHorizontalGroup(
            jPanelMidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMidLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelMidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTitle)
                    .addComponent(jLabelSubTitle)
                    .addComponent(jLabelAuthor)
                    .addComponent(jLabelCategory)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jPanelImagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanelMidLayout.setVerticalGroup(
            jPanelMidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMidLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanelMidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelImagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                    .addGroup(jPanelMidLayout.createSequentialGroup()
                        .addComponent(jLabelTitle)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelSubTitle)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelAuthor)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelCategory)))
                .addGap(20, 20, 20))
        );

        jPanelBottom.setBackground(new java.awt.Color(192, 192, 192));
        jPanelBottom.setForeground(new java.awt.Color(0, 0, 0));

        jButtonClose.setMnemonic('C');
        jButtonClose.setText("Close");
        jButtonClose.setToolTipText("Click to close");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        jButtonLoan.setMnemonic('C');
        jButtonLoan.setText("Loan");
        jButtonLoan.setToolTipText("Click to Loan This Book");
        jButtonLoan.setVisible(displayBookLoanButton);
        jButtonLoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoanActionPerformed(evt);
            }
        });

        jButtonReturn.setMnemonic('C');
        jButtonReturn.setText("Return");
        jButtonReturn.setToolTipText("Click to Loan This Book");
        jButtonLoan.setVisible(displayBookLoanButton);
        jButtonReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReturnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBottomLayout = new javax.swing.GroupLayout(jPanelBottom);
        jPanelBottom.setLayout(jPanelBottomLayout);
        jPanelBottomLayout.setHorizontalGroup(
            jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBottomLayout.createSequentialGroup()
                .addContainerGap(216, Short.MAX_VALUE)
                .addComponent(jButtonLoan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jButtonReturn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jButtonClose)
                .addContainerGap(210, Short.MAX_VALUE))
        );
        jPanelBottomLayout.setVerticalGroup(
            jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBottomLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonClose)
                    .addComponent(jButtonLoan)
                    .addComponent(jButtonReturn))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanelTop.setBackground(new java.awt.Color(192, 192, 192));

        jLabel4.setBackground(new java.awt.Color(192, 192, 192));
        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Book Display:");

        javax.swing.GroupLayout jPanelTopLayout = new javax.swing.GroupLayout(jPanelTop);
        jPanelTop.setLayout(jPanelTopLayout);
        jPanelTopLayout.setHorizontalGroup(
            jPanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTopLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(218, Short.MAX_VALUE))
        );
        jPanelTopLayout.setVerticalGroup(
            jPanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTopLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addGap(63, 63, 63))
        );

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBottom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelMid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addComponent(jPanelTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelMid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        this.setVisible(false);
        this.dispose();        // TODO add your handling code here:


    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:


    }//GEN-LAST:event_formWindowOpened

    private void jButtonLoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoanActionPerformed
        // TODO add your handling code here:
        BookingForm bookingForm = new BookingForm(user, book);
        bookingForm.setVisible(true);
        bookingForm.setFont(getFont());
    }//GEN-LAST:event_jButtonLoanActionPerformed

    private void jButtonReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReturnActionPerformed
        // TODO add your handling code here:
        ///return books here
        Loan loan = new Loan(user, book);
     //   Read read = new Read();
  //      loan = read.readOutstandingUserLoanByBookId(user.getUserId(), book);

 //       ReturnBookingForm returnBookingForm = new ReturnBookingForm(user, book, loan);
 //       returnBookingForm.setVisible(true);

    }//GEN-LAST:event_jButtonReturnActionPerformed

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
            java.util.logging.Logger.getLogger(DisplayBookForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DisplayBookForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DisplayBookForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DisplayBookForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
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
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonLoan;
    private javax.swing.JButton jButtonReturn;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelAuthor;
    private javax.swing.JLabel jLabelCategory;
    private javax.swing.JLabel jLabelPicture;
    private javax.swing.JLabel jLabelSubTitle;
    public static javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanelBottom;
    private static javax.swing.JPanel jPanelImagePanel;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelMid;
    private javax.swing.JPanel jPanelTop;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaDescription;
    // End of variables declaration//GEN-END:variables

    private Image displayFrameImageIcon() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    return null;
    }
}

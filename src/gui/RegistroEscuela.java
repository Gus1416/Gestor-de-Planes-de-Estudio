package gui;

import businesslogic.Escuela;
import javax.swing.JOptionPane;

/**
 * Interfaz del registro de escuela
 * 
 * @author Gustavo
 */
public class RegistroEscuela extends javax.swing.JFrame {
  private String nombreEscuela;
  private String codigo;
  
  /**
   * Crea una ventana para el registro de escuelas o áreas académicas
   */
  public RegistroEscuela() {
    initComponents();
  }
  
  /**
   * Métodos accesores
   */
  public String getNombreEscuela() {
    return nombreEscuela;
  }

  public void setNombreEscuela(String nombreEscuela) {
    this.nombreEscuela = nombreEscuela;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jPanel2 = new javax.swing.JPanel();
    jLabel2 = new javax.swing.JLabel();
    fNombreEscuela = new javax.swing.JTextField();
    jLabel3 = new javax.swing.JLabel();
    fCodigoEscuela = new javax.swing.JTextField();
    jPanel3 = new javax.swing.JPanel();
    bRegistrar = new javax.swing.JButton();
    bLimpiarCampos = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setName("RegistroEscuela"); // NOI18N
    setResizable(false);
    setSize(new java.awt.Dimension(300, 200));

    jPanel1.setBackground(new java.awt.Color(204, 204, 255));

    jLabel1.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(0, 0, 0));
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("Registro de Escuela o Área Académica");
    jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

    jPanel2.setBackground(new java.awt.Color(204, 204, 255));

    jLabel2.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
    jLabel2.setForeground(new java.awt.Color(0, 0, 0));
    jLabel2.setText("Nombre: ");

    fNombreEscuela.setBackground(new java.awt.Color(255, 255, 255));
    fNombreEscuela.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
    fNombreEscuela.setForeground(new java.awt.Color(0, 0, 0));
    fNombreEscuela.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        fNombreEscuelaActionPerformed(evt);
      }
    });
    fNombreEscuela.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(java.awt.event.KeyEvent evt) {
        fNombreEscuelaKeyTyped(evt);
      }
    });

    jLabel3.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(0, 0, 0));
    jLabel3.setText("Código: ");

    fCodigoEscuela.setBackground(new java.awt.Color(255, 255, 255));
    fCodigoEscuela.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
    fCodigoEscuela.setForeground(new java.awt.Color(0, 0, 0));
    fCodigoEscuela.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        fCodigoEscuelaActionPerformed(evt);
      }
    });
    fCodigoEscuela.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(java.awt.event.KeyEvent evt) {
        fCodigoEscuelaKeyTyped(evt);
      }
    });

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(jLabel2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(fNombreEscuela))
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(jLabel3)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
            .addComponent(fCodigoEscuela, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(198, 198, 198)))
        .addContainerGap())
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(fNombreEscuela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(fCodigoEscuela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap())
    );

    jPanel3.setBackground(new java.awt.Color(204, 204, 255));

    bRegistrar.setBackground(new java.awt.Color(204, 204, 255));
    bRegistrar.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
    bRegistrar.setForeground(new java.awt.Color(0, 0, 0));
    bRegistrar.setText("Registrar");
    bRegistrar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bRegistrarActionPerformed(evt);
      }
    });

    bLimpiarCampos.setBackground(new java.awt.Color(204, 204, 255));
    bLimpiarCampos.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
    bLimpiarCampos.setForeground(new java.awt.Color(0, 0, 0));
    bLimpiarCampos.setText("Limpiar campos");
    bLimpiarCampos.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bLimpiarCamposActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addComponent(bRegistrar)
        .addGap(18, 18, 18)
        .addComponent(bLimpiarCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );
    jPanel3Layout.setVerticalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
        .addGap(0, 0, Short.MAX_VALUE)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(bLimpiarCampos)
          .addComponent(bRegistrar)))
    );

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(94, 94, 94))
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(52, 52, 52)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel1))
        .addContainerGap(35, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(23, 23, 23)
        .addComponent(jLabel1)
        .addGap(26, 26, 26)
        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(28, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void fNombreEscuelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fNombreEscuelaActionPerformed
    
  }//GEN-LAST:event_fNombreEscuelaActionPerformed

  private void fCodigoEscuelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fCodigoEscuelaActionPerformed
    
  }//GEN-LAST:event_fCodigoEscuelaActionPerformed

  /**
   * Botón para limpiar campos de texto
   * 
   * @param evt 
   */
  private void bLimpiarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLimpiarCamposActionPerformed
    fNombreEscuela.setText(null);
    fCodigoEscuela.setText(null);
  }//GEN-LAST:event_bLimpiarCamposActionPerformed

  /**
   * Botón para registrar una escuela o área académica
   * 
   * @param evt 
   */
  private void bRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRegistrarActionPerformed
    this.nombreEscuela = fNombreEscuela.getText();
    this.codigo = fCodigoEscuela.getText();
    
    if (this.nombreEscuela.length() == 0){
      JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
    }else{
      Escuela escuela = new Escuela(nombreEscuela, codigo);
      JOptionPane.showMessageDialog(null, "Operación realizada exitosamente");
      fNombreEscuela.setText(null);
      fCodigoEscuela.setText(null);
    }
  }//GEN-LAST:event_bRegistrarActionPerformed

  /**
   * Mátodo para validar la entrada de texto en el campo de nombre
   * 
   * @param evt 
   */
  private void fNombreEscuelaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fNombreEscuelaKeyTyped
    int key = evt.getKeyChar();

    boolean mayusculas = key >= 65 && key <= 90;
    boolean minusculas = key >= 97 && key <= 122;
    boolean espacio = key == 32;
            
    if (!(minusculas || mayusculas || espacio)){
      evt.consume();
    }
  }//GEN-LAST:event_fNombreEscuelaKeyTyped

  /**
   * Campo para validar la entrada de texto en el campo de código
   * 
   * @param evt 
   */
  private void fCodigoEscuelaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fCodigoEscuelaKeyTyped
    int key = evt.getKeyChar();

    boolean mayusculas = key >= 65 && key <= 90;
    boolean minusculas = key >= 97 && key <= 122;
    boolean espacio = key == 32;
            
    if (!(minusculas || mayusculas || espacio)){
      evt.consume();
    }
  }//GEN-LAST:event_fCodigoEscuelaKeyTyped

  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try
    {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
      {
        if ("Nimbus".equals(info.getName()))
        {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex)
    {
      java.util.logging.Logger.getLogger(RegistroEscuela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex)
    {
      java.util.logging.Logger.getLogger(RegistroEscuela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex)
    {
      java.util.logging.Logger.getLogger(RegistroEscuela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex)
    {
      java.util.logging.Logger.getLogger(RegistroEscuela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new RegistroEscuela().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton bLimpiarCampos;
  private javax.swing.JButton bRegistrar;
  private javax.swing.JTextField fCodigoEscuela;
  private javax.swing.JTextField fNombreEscuela;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  // End of variables declaration//GEN-END:variables
}
